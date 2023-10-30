package com.dt.platform.domain.common;

import com.github.foxnic.dao.entity.Entity;
import io.swagger.annotations.ApiModel;
import javax.persistence.Table;
import com.github.foxnic.sql.meta.DBTable;
import com.dt.platform.constants.db.SysTables.SYS_SCREEN_DS_DB;
import javax.persistence.Id;
import io.swagger.annotations.ApiModelProperty;
import java.util.Date;
import javax.persistence.Transient;
import com.github.foxnic.api.swagger.EnumFor;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.github.foxnic.commons.lang.DataParser;
import java.util.Map;
import com.github.foxnic.dao.entity.EntityContext;
import com.dt.platform.domain.common.meta.ScreenDsDbMeta;
import com.github.foxnic.sql.data.ExprRcd;



/**
 * 数据库
 * <p>数据库 , 数据表 sys_screen_ds_db 的PO类型</p>
 * @author 金杰 , maillank@qq.com
 * @since 2023-10-30 20:09:02
 * @sign 1DF2C582AEC754E6D4DB593BC81CC9F3
 * 此文件由工具自动生成，请勿修改。若表结构或配置发生变动，请使用工具重新生成。
*/

@Table(name = "sys_screen_ds_db")
@ApiModel(description = "数据库 ; 数据库 , 数据表 sys_screen_ds_db 的PO类型")
public class ScreenDsDb extends Entity {

	private static final long serialVersionUID = 1L;

	public static final DBTable TABLE =SYS_SCREEN_DS_DB.$TABLE;
	
	/**
	 * 主键：主键
	*/
	@Id
	@ApiModelProperty(required = true,value="主键" , notes = "主键" , example = "1")
	private String id;
	
	/**
	 * 名称：名称
	*/
	@ApiModelProperty(required = false,value="名称" , notes = "名称" , example = "系统当前数据库")
	private String name;
	
	/**
	 * 类型：system|user
	*/
	@ApiModelProperty(required = false,value="类型" , notes = "system|user" , example = "system")
	private String type;
	
	/**
	 * 数据库类型：数据库类型
	*/
	@ApiModelProperty(required = false,value="数据库类型" , notes = "数据库类型" , example = "mysql")
	private String dsType;
	
	/**
	 * 账户：账户
	*/
	@ApiModelProperty(required = false,value="账户" , notes = "账户" , example = "null")
	private String user;
	
	/**
	 * 密码：密码
	*/
	@ApiModelProperty(required = false,value="密码" , notes = "密码" , example = "null")
	private String pwd;
	
	/**
	 * uri：uri
	*/
	@ApiModelProperty(required = false,value="uri" , notes = "uri" , example = "null")
	private String uri;
	
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
	@ApiModelProperty(required = false,value="创建时间" , notes = "创建时间" , example = "2023-10-28 08:19:54")
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
	 * version：version
	*/
	@ApiModelProperty(required = false,value="version" , notes = "version" , example = "1")
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
	public ScreenDsDb setId(String id) {
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
	public ScreenDsDb setName(String name) {
		this.name=name;
		return this;
	}
	
	/**
	 * 获得 类型<br>
	 * system|user
	 * @return 类型
	*/
	public String getType() {
		return type;
	}
	
	/**
	 * 设置 类型
	 * @param type 类型
	 * @return 当前对象
	*/
	public ScreenDsDb setType(String type) {
		this.type=type;
		return this;
	}
	
	/**
	 * 获得 数据库类型<br>
	 * 数据库类型
	 * @return 数据库类型
	*/
	public String getDsType() {
		return dsType;
	}
	
	/**
	 * 设置 数据库类型
	 * @param dsType 数据库类型
	 * @return 当前对象
	*/
	public ScreenDsDb setDsType(String dsType) {
		this.dsType=dsType;
		return this;
	}
	
	/**
	 * 获得 账户<br>
	 * 账户
	 * @return 账户
	*/
	public String getUser() {
		return user;
	}
	
	/**
	 * 设置 账户
	 * @param user 账户
	 * @return 当前对象
	*/
	public ScreenDsDb setUser(String user) {
		this.user=user;
		return this;
	}
	
	/**
	 * 获得 密码<br>
	 * 密码
	 * @return 密码
	*/
	public String getPwd() {
		return pwd;
	}
	
	/**
	 * 设置 密码
	 * @param pwd 密码
	 * @return 当前对象
	*/
	public ScreenDsDb setPwd(String pwd) {
		this.pwd=pwd;
		return this;
	}
	
	/**
	 * 获得 uri<br>
	 * uri
	 * @return uri
	*/
	public String getUri() {
		return uri;
	}
	
	/**
	 * 设置 uri
	 * @param uri uri
	 * @return 当前对象
	*/
	public ScreenDsDb setUri(String uri) {
		this.uri=uri;
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
	public ScreenDsDb setNotes(String notes) {
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
	public ScreenDsDb setCreateBy(String createBy) {
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
	public ScreenDsDb setCreateTime(Date createTime) {
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
	public ScreenDsDb setUpdateBy(String updateBy) {
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
	public ScreenDsDb setUpdateTime(Date updateTime) {
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
	public ScreenDsDb setDeleted(Integer deleted) {
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
	public ScreenDsDb setDeleted(Boolean deletedBool) {
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
	public ScreenDsDb setDeleteBy(String deleteBy) {
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
	public ScreenDsDb setDeleteTime(Date deleteTime) {
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
	public ScreenDsDb setVersion(Integer version) {
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
	public ScreenDsDb setTenantId(String tenantId) {
		this.tenantId=tenantId;
		return this;
	}

	/**
	 * 将自己转换成指定类型的PO
	 * @param poType  PO类型
	 * @return ScreenDsDb , 转换好的 ScreenDsDb 对象
	*/
	@Transient
	public <T extends Entity> T toPO(Class<T> poType) {
		return EntityContext.create(poType, this);
	}

	/**
	 * 将自己转换成任意指定类型
	 * @param pojoType  Pojo类型
	 * @return ScreenDsDb , 转换好的 PoJo 对象
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
	public ScreenDsDb clone() {
		return duplicate(true);
	}

	/**
	 * 复制当前对象
	 * @param all 是否复制全部属性，当 false 时，仅复制来自数据表的属性
	*/
	@Transient
	public ScreenDsDb duplicate(boolean all) {
		com.dt.platform.domain.common.meta.ScreenDsDbMeta.$$proxy$$ inst = new com.dt.platform.domain.common.meta.ScreenDsDbMeta.$$proxy$$();
		inst.setNotes(this.getNotes());
		inst.setDsType(this.getDsType());
		inst.setUpdateTime(this.getUpdateTime());
		inst.setType(this.getType());
		inst.setUri(this.getUri());
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
		inst.setPwd(this.getPwd());
		inst.setUser(this.getUser());
		inst.clearModifies();
		return inst;
	}

	/**
	 * 克隆当前对象
	*/
	@Transient
	public ScreenDsDb clone(boolean deep) {
		return EntityContext.clone(ScreenDsDb.class,this,deep);
	}

	/**
	 * 将 Map 转换成 ScreenDsDb
	 * @param screenDsDbMap 包含实体信息的 Map 对象
	 * @return ScreenDsDb , 转换好的的 ScreenDsDb 对象
	*/
	@Transient
	public static ScreenDsDb createFrom(Map<String,Object> screenDsDbMap) {
		if(screenDsDbMap==null) return null;
		ScreenDsDb po = create();
		EntityContext.copyProperties(po,screenDsDbMap);
		po.clearModifies();
		return po;
	}

	/**
	 * 将 Pojo 转换成 ScreenDsDb
	 * @param pojo 包含实体信息的 Pojo 对象
	 * @return ScreenDsDb , 转换好的的 ScreenDsDb 对象
	*/
	@Transient
	public static ScreenDsDb createFrom(Object pojo) {
		if(pojo==null) return null;
		ScreenDsDb po = create();
		EntityContext.copyProperties(po,pojo);
		po.clearModifies();
		return po;
	}

	/**
	 * 创建一个 ScreenDsDb，等同于 new
	 * @return ScreenDsDb 对象
	*/
	@Transient
	public static ScreenDsDb create() {
		return new com.dt.platform.domain.common.meta.ScreenDsDbMeta.$$proxy$$();
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
			this.setNotes(DataParser.parse(String.class, map.get(ScreenDsDbMeta.NOTES)));
			this.setDsType(DataParser.parse(String.class, map.get(ScreenDsDbMeta.DS_TYPE)));
			this.setUpdateTime(DataParser.parse(Date.class, map.get(ScreenDsDbMeta.UPDATE_TIME)));
			this.setType(DataParser.parse(String.class, map.get(ScreenDsDbMeta.TYPE)));
			this.setUri(DataParser.parse(String.class, map.get(ScreenDsDbMeta.URI)));
			this.setVersion(DataParser.parse(Integer.class, map.get(ScreenDsDbMeta.VERSION)));
			this.setCreateBy(DataParser.parse(String.class, map.get(ScreenDsDbMeta.CREATE_BY)));
			this.setDeleted(DataParser.parse(Integer.class, map.get(ScreenDsDbMeta.DELETED)));
			this.setCreateTime(DataParser.parse(Date.class, map.get(ScreenDsDbMeta.CREATE_TIME)));
			this.setUpdateBy(DataParser.parse(String.class, map.get(ScreenDsDbMeta.UPDATE_BY)));
			this.setDeleteTime(DataParser.parse(Date.class, map.get(ScreenDsDbMeta.DELETE_TIME)));
			this.setName(DataParser.parse(String.class, map.get(ScreenDsDbMeta.NAME)));
			this.setTenantId(DataParser.parse(String.class, map.get(ScreenDsDbMeta.TENANT_ID)));
			this.setDeleteBy(DataParser.parse(String.class, map.get(ScreenDsDbMeta.DELETE_BY)));
			this.setId(DataParser.parse(String.class, map.get(ScreenDsDbMeta.ID)));
			this.setPwd(DataParser.parse(String.class, map.get(ScreenDsDbMeta.PWD)));
			this.setUser(DataParser.parse(String.class, map.get(ScreenDsDbMeta.USER)));
			// others
			return true;
		} else {
			try {
				this.setNotes( (String)map.get(ScreenDsDbMeta.NOTES));
				this.setDsType( (String)map.get(ScreenDsDbMeta.DS_TYPE));
				this.setUpdateTime( (Date)map.get(ScreenDsDbMeta.UPDATE_TIME));
				this.setType( (String)map.get(ScreenDsDbMeta.TYPE));
				this.setUri( (String)map.get(ScreenDsDbMeta.URI));
				this.setVersion( (Integer)map.get(ScreenDsDbMeta.VERSION));
				this.setCreateBy( (String)map.get(ScreenDsDbMeta.CREATE_BY));
				this.setDeleted( (Integer)map.get(ScreenDsDbMeta.DELETED));
				this.setCreateTime( (Date)map.get(ScreenDsDbMeta.CREATE_TIME));
				this.setUpdateBy( (String)map.get(ScreenDsDbMeta.UPDATE_BY));
				this.setDeleteTime( (Date)map.get(ScreenDsDbMeta.DELETE_TIME));
				this.setName( (String)map.get(ScreenDsDbMeta.NAME));
				this.setTenantId( (String)map.get(ScreenDsDbMeta.TENANT_ID));
				this.setDeleteBy( (String)map.get(ScreenDsDbMeta.DELETE_BY));
				this.setId( (String)map.get(ScreenDsDbMeta.ID));
				this.setPwd( (String)map.get(ScreenDsDbMeta.PWD));
				this.setUser( (String)map.get(ScreenDsDbMeta.USER));
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
			this.setNotes(DataParser.parse(String.class, r.getValue(ScreenDsDbMeta.NOTES)));
			this.setDsType(DataParser.parse(String.class, r.getValue(ScreenDsDbMeta.DS_TYPE)));
			this.setUpdateTime(DataParser.parse(Date.class, r.getValue(ScreenDsDbMeta.UPDATE_TIME)));
			this.setType(DataParser.parse(String.class, r.getValue(ScreenDsDbMeta.TYPE)));
			this.setUri(DataParser.parse(String.class, r.getValue(ScreenDsDbMeta.URI)));
			this.setVersion(DataParser.parse(Integer.class, r.getValue(ScreenDsDbMeta.VERSION)));
			this.setCreateBy(DataParser.parse(String.class, r.getValue(ScreenDsDbMeta.CREATE_BY)));
			this.setDeleted(DataParser.parse(Integer.class, r.getValue(ScreenDsDbMeta.DELETED)));
			this.setCreateTime(DataParser.parse(Date.class, r.getValue(ScreenDsDbMeta.CREATE_TIME)));
			this.setUpdateBy(DataParser.parse(String.class, r.getValue(ScreenDsDbMeta.UPDATE_BY)));
			this.setDeleteTime(DataParser.parse(Date.class, r.getValue(ScreenDsDbMeta.DELETE_TIME)));
			this.setName(DataParser.parse(String.class, r.getValue(ScreenDsDbMeta.NAME)));
			this.setTenantId(DataParser.parse(String.class, r.getValue(ScreenDsDbMeta.TENANT_ID)));
			this.setDeleteBy(DataParser.parse(String.class, r.getValue(ScreenDsDbMeta.DELETE_BY)));
			this.setId(DataParser.parse(String.class, r.getValue(ScreenDsDbMeta.ID)));
			this.setPwd(DataParser.parse(String.class, r.getValue(ScreenDsDbMeta.PWD)));
			this.setUser(DataParser.parse(String.class, r.getValue(ScreenDsDbMeta.USER)));
			return true;
		} else {
			try {
				this.setNotes( (String)r.getValue(ScreenDsDbMeta.NOTES));
				this.setDsType( (String)r.getValue(ScreenDsDbMeta.DS_TYPE));
				this.setUpdateTime( (Date)r.getValue(ScreenDsDbMeta.UPDATE_TIME));
				this.setType( (String)r.getValue(ScreenDsDbMeta.TYPE));
				this.setUri( (String)r.getValue(ScreenDsDbMeta.URI));
				this.setVersion( (Integer)r.getValue(ScreenDsDbMeta.VERSION));
				this.setCreateBy( (String)r.getValue(ScreenDsDbMeta.CREATE_BY));
				this.setDeleted( (Integer)r.getValue(ScreenDsDbMeta.DELETED));
				this.setCreateTime( (Date)r.getValue(ScreenDsDbMeta.CREATE_TIME));
				this.setUpdateBy( (String)r.getValue(ScreenDsDbMeta.UPDATE_BY));
				this.setDeleteTime( (Date)r.getValue(ScreenDsDbMeta.DELETE_TIME));
				this.setName( (String)r.getValue(ScreenDsDbMeta.NAME));
				this.setTenantId( (String)r.getValue(ScreenDsDbMeta.TENANT_ID));
				this.setDeleteBy( (String)r.getValue(ScreenDsDbMeta.DELETE_BY));
				this.setId( (String)r.getValue(ScreenDsDbMeta.ID));
				this.setPwd( (String)r.getValue(ScreenDsDbMeta.PWD));
				this.setUser( (String)r.getValue(ScreenDsDbMeta.USER));
				return true;
			} catch (Exception e) {
				return false;
			}
		}
	}
}