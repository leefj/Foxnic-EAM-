package com.dt.platform.domain.ops;

import com.github.foxnic.dao.entity.Entity;
import io.swagger.annotations.ApiModel;
import javax.persistence.Table;
import com.github.foxnic.sql.meta.DBTable;
import com.dt.platform.constants.db.OpsTables.OPS_DB_APPLY_EXECUTE;
import javax.persistence.Id;
import io.swagger.annotations.ApiModelProperty;
import java.util.Date;
import javax.persistence.Transient;
import com.github.foxnic.api.swagger.EnumFor;
import org.github.foxnic.web.domain.hrm.Employee;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.github.foxnic.commons.lang.DataParser;
import java.util.Map;
import com.github.foxnic.dao.entity.EntityContext;
import com.dt.platform.domain.ops.meta.DbApplyExecuteMeta;
import com.github.foxnic.sql.data.ExprRcd;



/**
 * 数据库操作执行
 * <p>数据库操作执行 , 数据表 ops_db_apply_execute 的PO类型</p>
 * @author 金杰 , maillank@qq.com
 * @since 2024-03-31 15:36:14
 * @sign 42B8C945928078DAD279DBCD51AB70B4
 * 此文件由工具自动生成，请勿修改。若表结构或配置发生变动，请使用工具重新生成。
*/

@Table(name = "ops_db_apply_execute")
@ApiModel(description = "数据库操作执行 ; 数据库操作执行 , 数据表 ops_db_apply_execute 的PO类型")
public class DbApplyExecute extends Entity {

	private static final long serialVersionUID = 1L;

	public static final DBTable TABLE =OPS_DB_APPLY_EXECUTE.$TABLE;
	
	/**
	 * 主键：主键
	*/
	@Id
	@ApiModelProperty(required = true,value="主键" , notes = "主键")
	private String id;
	
	/**
	 * 来源：来源
	*/
	@ApiModelProperty(required = false,value="来源" , notes = "来源")
	private String source;
	
	/**
	 * 编号：编号
	*/
	@ApiModelProperty(required = false,value="编号" , notes = "编号")
	private String ownerId;
	
	/**
	 * 标题：标题
	*/
	@ApiModelProperty(required = false,value="标题" , notes = "标题")
	private String title;
	
	/**
	 * 操作人：操作人
	*/
	@ApiModelProperty(required = false,value="操作人" , notes = "操作人")
	private String operId;
	
	/**
	 * 操作结果：操作结果
	*/
	@ApiModelProperty(required = false,value="操作结果" , notes = "操作结果")
	private String result;
	
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
	 * operUser：operUser
	*/
	@ApiModelProperty(required = false,value="operUser" , notes = "operUser")
	private Employee operUser;
	
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
	public DbApplyExecute setId(String id) {
		this.id=id;
		return this;
	}
	
	/**
	 * 获得 来源<br>
	 * 来源
	 * @return 来源
	*/
	public String getSource() {
		return source;
	}
	
	/**
	 * 设置 来源
	 * @param source 来源
	 * @return 当前对象
	*/
	public DbApplyExecute setSource(String source) {
		this.source=source;
		return this;
	}
	
	/**
	 * 获得 编号<br>
	 * 编号
	 * @return 编号
	*/
	public String getOwnerId() {
		return ownerId;
	}
	
	/**
	 * 设置 编号
	 * @param ownerId 编号
	 * @return 当前对象
	*/
	public DbApplyExecute setOwnerId(String ownerId) {
		this.ownerId=ownerId;
		return this;
	}
	
	/**
	 * 获得 标题<br>
	 * 标题
	 * @return 标题
	*/
	public String getTitle() {
		return title;
	}
	
	/**
	 * 设置 标题
	 * @param title 标题
	 * @return 当前对象
	*/
	public DbApplyExecute setTitle(String title) {
		this.title=title;
		return this;
	}
	
	/**
	 * 获得 操作人<br>
	 * 操作人
	 * @return 操作人
	*/
	public String getOperId() {
		return operId;
	}
	
	/**
	 * 设置 操作人
	 * @param operId 操作人
	 * @return 当前对象
	*/
	public DbApplyExecute setOperId(String operId) {
		this.operId=operId;
		return this;
	}
	
	/**
	 * 获得 操作结果<br>
	 * 操作结果
	 * @return 操作结果
	*/
	public String getResult() {
		return result;
	}
	
	/**
	 * 设置 操作结果
	 * @param result 操作结果
	 * @return 当前对象
	*/
	public DbApplyExecute setResult(String result) {
		this.result=result;
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
	public DbApplyExecute setUpdateBy(String updateBy) {
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
	public DbApplyExecute setUpdateTime(Date updateTime) {
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
	public DbApplyExecute setDeleted(Integer deleted) {
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
	public DbApplyExecute setDeleted(Boolean deletedBool) {
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
	public DbApplyExecute setDeleteBy(String deleteBy) {
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
	public DbApplyExecute setDeleteTime(Date deleteTime) {
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
	public DbApplyExecute setCreateBy(String createBy) {
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
	public DbApplyExecute setCreateTime(Date createTime) {
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
	public DbApplyExecute setVersion(Integer version) {
		this.version=version;
		return this;
	}
	
	/**
	 * 获得 operUser<br>
	 * operUser
	 * @return operUser
	*/
	public Employee getOperUser() {
		return operUser;
	}
	
	/**
	 * 设置 operUser
	 * @param operUser operUser
	 * @return 当前对象
	*/
	public DbApplyExecute setOperUser(Employee operUser) {
		this.operUser=operUser;
		return this;
	}

	/**
	 * 将自己转换成指定类型的PO
	 * @param poType  PO类型
	 * @return DbApplyExecute , 转换好的 DbApplyExecute 对象
	*/
	@Transient
	public <T extends Entity> T toPO(Class<T> poType) {
		return EntityContext.create(poType, this);
	}

	/**
	 * 将自己转换成任意指定类型
	 * @param pojoType  Pojo类型
	 * @return DbApplyExecute , 转换好的 PoJo 对象
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
	public DbApplyExecute clone() {
		return duplicate(true);
	}

	/**
	 * 复制当前对象
	 * @param all 是否复制全部属性，当 false 时，仅复制来自数据表的属性
	*/
	@Transient
	public DbApplyExecute duplicate(boolean all) {
		com.dt.platform.domain.ops.meta.DbApplyExecuteMeta.$$proxy$$ inst = new com.dt.platform.domain.ops.meta.DbApplyExecuteMeta.$$proxy$$();
		inst.setOperId(this.getOperId());
		inst.setUpdateTime(this.getUpdateTime());
		inst.setSource(this.getSource());
		inst.setOwnerId(this.getOwnerId());
		inst.setTitle(this.getTitle());
		inst.setVersion(this.getVersion());
		inst.setResult(this.getResult());
		inst.setCreateBy(this.getCreateBy());
		inst.setDeleted(this.getDeleted());
		inst.setUpdateBy(this.getUpdateBy());
		inst.setDeleteTime(this.getDeleteTime());
		inst.setCreateTime(this.getCreateTime());
		inst.setDeleteBy(this.getDeleteBy());
		inst.setId(this.getId());
		if(all) {
			inst.setOperUser(this.getOperUser());
		}
		inst.clearModifies();
		return inst;
	}

	/**
	 * 克隆当前对象
	*/
	@Transient
	public DbApplyExecute clone(boolean deep) {
		return EntityContext.clone(DbApplyExecute.class,this,deep);
	}

	/**
	 * 将 Map 转换成 DbApplyExecute
	 * @param dbApplyExecuteMap 包含实体信息的 Map 对象
	 * @return DbApplyExecute , 转换好的的 DbApplyExecute 对象
	*/
	@Transient
	public static DbApplyExecute createFrom(Map<String,Object> dbApplyExecuteMap) {
		if(dbApplyExecuteMap==null) return null;
		DbApplyExecute po = create();
		EntityContext.copyProperties(po,dbApplyExecuteMap);
		po.clearModifies();
		return po;
	}

	/**
	 * 将 Pojo 转换成 DbApplyExecute
	 * @param pojo 包含实体信息的 Pojo 对象
	 * @return DbApplyExecute , 转换好的的 DbApplyExecute 对象
	*/
	@Transient
	public static DbApplyExecute createFrom(Object pojo) {
		if(pojo==null) return null;
		DbApplyExecute po = create();
		EntityContext.copyProperties(po,pojo);
		po.clearModifies();
		return po;
	}

	/**
	 * 创建一个 DbApplyExecute，等同于 new
	 * @return DbApplyExecute 对象
	*/
	@Transient
	public static DbApplyExecute create() {
		return new com.dt.platform.domain.ops.meta.DbApplyExecuteMeta.$$proxy$$();
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
			this.setOperId(DataParser.parse(String.class, map.get(DbApplyExecuteMeta.OPER_ID)));
			this.setUpdateTime(DataParser.parse(Date.class, map.get(DbApplyExecuteMeta.UPDATE_TIME)));
			this.setSource(DataParser.parse(String.class, map.get(DbApplyExecuteMeta.SOURCE)));
			this.setOwnerId(DataParser.parse(String.class, map.get(DbApplyExecuteMeta.OWNER_ID)));
			this.setTitle(DataParser.parse(String.class, map.get(DbApplyExecuteMeta.TITLE)));
			this.setVersion(DataParser.parse(Integer.class, map.get(DbApplyExecuteMeta.VERSION)));
			this.setResult(DataParser.parse(String.class, map.get(DbApplyExecuteMeta.RESULT)));
			this.setCreateBy(DataParser.parse(String.class, map.get(DbApplyExecuteMeta.CREATE_BY)));
			this.setDeleted(DataParser.parse(Integer.class, map.get(DbApplyExecuteMeta.DELETED)));
			this.setUpdateBy(DataParser.parse(String.class, map.get(DbApplyExecuteMeta.UPDATE_BY)));
			this.setDeleteTime(DataParser.parse(Date.class, map.get(DbApplyExecuteMeta.DELETE_TIME)));
			this.setCreateTime(DataParser.parse(Date.class, map.get(DbApplyExecuteMeta.CREATE_TIME)));
			this.setDeleteBy(DataParser.parse(String.class, map.get(DbApplyExecuteMeta.DELETE_BY)));
			this.setId(DataParser.parse(String.class, map.get(DbApplyExecuteMeta.ID)));
			// others
			this.setOperUser(DataParser.parse(Employee.class, map.get(DbApplyExecuteMeta.OPER_USER)));
			return true;
		} else {
			try {
				this.setOperId( (String)map.get(DbApplyExecuteMeta.OPER_ID));
				this.setUpdateTime( (Date)map.get(DbApplyExecuteMeta.UPDATE_TIME));
				this.setSource( (String)map.get(DbApplyExecuteMeta.SOURCE));
				this.setOwnerId( (String)map.get(DbApplyExecuteMeta.OWNER_ID));
				this.setTitle( (String)map.get(DbApplyExecuteMeta.TITLE));
				this.setVersion( (Integer)map.get(DbApplyExecuteMeta.VERSION));
				this.setResult( (String)map.get(DbApplyExecuteMeta.RESULT));
				this.setCreateBy( (String)map.get(DbApplyExecuteMeta.CREATE_BY));
				this.setDeleted( (Integer)map.get(DbApplyExecuteMeta.DELETED));
				this.setUpdateBy( (String)map.get(DbApplyExecuteMeta.UPDATE_BY));
				this.setDeleteTime( (Date)map.get(DbApplyExecuteMeta.DELETE_TIME));
				this.setCreateTime( (Date)map.get(DbApplyExecuteMeta.CREATE_TIME));
				this.setDeleteBy( (String)map.get(DbApplyExecuteMeta.DELETE_BY));
				this.setId( (String)map.get(DbApplyExecuteMeta.ID));
				// others
				this.setOperUser( (Employee)map.get(DbApplyExecuteMeta.OPER_USER));
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
			this.setOperId(DataParser.parse(String.class, r.getValue(DbApplyExecuteMeta.OPER_ID)));
			this.setUpdateTime(DataParser.parse(Date.class, r.getValue(DbApplyExecuteMeta.UPDATE_TIME)));
			this.setSource(DataParser.parse(String.class, r.getValue(DbApplyExecuteMeta.SOURCE)));
			this.setOwnerId(DataParser.parse(String.class, r.getValue(DbApplyExecuteMeta.OWNER_ID)));
			this.setTitle(DataParser.parse(String.class, r.getValue(DbApplyExecuteMeta.TITLE)));
			this.setVersion(DataParser.parse(Integer.class, r.getValue(DbApplyExecuteMeta.VERSION)));
			this.setResult(DataParser.parse(String.class, r.getValue(DbApplyExecuteMeta.RESULT)));
			this.setCreateBy(DataParser.parse(String.class, r.getValue(DbApplyExecuteMeta.CREATE_BY)));
			this.setDeleted(DataParser.parse(Integer.class, r.getValue(DbApplyExecuteMeta.DELETED)));
			this.setUpdateBy(DataParser.parse(String.class, r.getValue(DbApplyExecuteMeta.UPDATE_BY)));
			this.setDeleteTime(DataParser.parse(Date.class, r.getValue(DbApplyExecuteMeta.DELETE_TIME)));
			this.setCreateTime(DataParser.parse(Date.class, r.getValue(DbApplyExecuteMeta.CREATE_TIME)));
			this.setDeleteBy(DataParser.parse(String.class, r.getValue(DbApplyExecuteMeta.DELETE_BY)));
			this.setId(DataParser.parse(String.class, r.getValue(DbApplyExecuteMeta.ID)));
			return true;
		} else {
			try {
				this.setOperId( (String)r.getValue(DbApplyExecuteMeta.OPER_ID));
				this.setUpdateTime( (Date)r.getValue(DbApplyExecuteMeta.UPDATE_TIME));
				this.setSource( (String)r.getValue(DbApplyExecuteMeta.SOURCE));
				this.setOwnerId( (String)r.getValue(DbApplyExecuteMeta.OWNER_ID));
				this.setTitle( (String)r.getValue(DbApplyExecuteMeta.TITLE));
				this.setVersion( (Integer)r.getValue(DbApplyExecuteMeta.VERSION));
				this.setResult( (String)r.getValue(DbApplyExecuteMeta.RESULT));
				this.setCreateBy( (String)r.getValue(DbApplyExecuteMeta.CREATE_BY));
				this.setDeleted( (Integer)r.getValue(DbApplyExecuteMeta.DELETED));
				this.setUpdateBy( (String)r.getValue(DbApplyExecuteMeta.UPDATE_BY));
				this.setDeleteTime( (Date)r.getValue(DbApplyExecuteMeta.DELETE_TIME));
				this.setCreateTime( (Date)r.getValue(DbApplyExecuteMeta.CREATE_TIME));
				this.setDeleteBy( (String)r.getValue(DbApplyExecuteMeta.DELETE_BY));
				this.setId( (String)r.getValue(DbApplyExecuteMeta.ID));
				return true;
			} catch (Exception e) {
				return false;
			}
		}
	}
}