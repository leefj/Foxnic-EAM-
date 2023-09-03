package com.dt.platform.domain.ops;

import com.github.foxnic.dao.entity.Entity;
import io.swagger.annotations.ApiModel;
import javax.persistence.Table;
import com.github.foxnic.sql.meta.DBTable;
import com.dt.platform.constants.db.OpsTables.OPS_AUTO_ACTION_S_SCRIPT;
import javax.persistence.Id;
import io.swagger.annotations.ApiModelProperty;
import java.util.Date;
import javax.persistence.Transient;
import com.github.foxnic.api.swagger.EnumFor;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.github.foxnic.commons.lang.DataParser;
import java.util.Map;
import com.github.foxnic.dao.entity.EntityContext;
import com.dt.platform.domain.ops.meta.AutoActionSScriptMeta;
import com.github.foxnic.sql.data.ExprRcd;



/**
 * 脚本选择
 * <p>脚本选择 , 数据表 ops_auto_action_s_script 的PO类型</p>
 * @author 金杰 , maillank@qq.com
 * @since 2023-08-31 18:17:54
 * @sign 26977A0D77B0857ECD6D2C8D181F1097
 * 此文件由工具自动生成，请勿修改。若表结构或配置发生变动，请使用工具重新生成。
*/

@Table(name = "ops_auto_action_s_script")
@ApiModel(description = "脚本选择 ; 脚本选择 , 数据表 ops_auto_action_s_script 的PO类型")
public class AutoActionSScript extends Entity {

	private static final long serialVersionUID = 1L;

	public static final DBTable TABLE =OPS_AUTO_ACTION_S_SCRIPT.$TABLE;
	
	/**
	 * 主键：主键
	*/
	@Id
	@ApiModelProperty(required = true,value="主键" , notes = "主键" , example = "613759412992999424")
	private String id;
	
	/**
	 * 所属：所属
	*/
	@ApiModelProperty(required = false,value="所属" , notes = "所属" , example = "613756265390145536")
	private String ownerId;
	
	/**
	 * 文件：文件
	*/
	@ApiModelProperty(required = false,value="文件" , notes = "文件" , example = "613733471919013888")
	private String scriptId;
	
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
	@ApiModelProperty(required = true,value="version" , notes = "version" , example = "1")
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
	public AutoActionSScript setId(String id) {
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
	public AutoActionSScript setOwnerId(String ownerId) {
		this.ownerId=ownerId;
		return this;
	}
	
	/**
	 * 获得 文件<br>
	 * 文件
	 * @return 文件
	*/
	public String getScriptId() {
		return scriptId;
	}
	
	/**
	 * 设置 文件
	 * @param scriptId 文件
	 * @return 当前对象
	*/
	public AutoActionSScript setScriptId(String scriptId) {
		this.scriptId=scriptId;
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
	public AutoActionSScript setUpdateBy(String updateBy) {
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
	public AutoActionSScript setUpdateTime(Date updateTime) {
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
	public AutoActionSScript setDeleted(Integer deleted) {
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
	public AutoActionSScript setDeleted(Boolean deletedBool) {
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
	public AutoActionSScript setDeleteBy(String deleteBy) {
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
	public AutoActionSScript setDeleteTime(Date deleteTime) {
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
	public AutoActionSScript setVersion(Integer version) {
		this.version=version;
		return this;
	}

	/**
	 * 将自己转换成指定类型的PO
	 * @param poType  PO类型
	 * @return AutoActionSScript , 转换好的 AutoActionSScript 对象
	*/
	@Transient
	public <T extends Entity> T toPO(Class<T> poType) {
		return EntityContext.create(poType, this);
	}

	/**
	 * 将自己转换成任意指定类型
	 * @param pojoType  Pojo类型
	 * @return AutoActionSScript , 转换好的 PoJo 对象
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
	public AutoActionSScript clone() {
		return duplicate(true);
	}

	/**
	 * 复制当前对象
	 * @param all 是否复制全部属性，当 false 时，仅复制来自数据表的属性
	*/
	@Transient
	public AutoActionSScript duplicate(boolean all) {
		com.dt.platform.domain.ops.meta.AutoActionSScriptMeta.$$proxy$$ inst = new com.dt.platform.domain.ops.meta.AutoActionSScriptMeta.$$proxy$$();
		inst.setScriptId(this.getScriptId());
		inst.setDeleted(this.getDeleted());
		inst.setUpdateBy(this.getUpdateBy());
		inst.setDeleteTime(this.getDeleteTime());
		inst.setDeleteBy(this.getDeleteBy());
		inst.setUpdateTime(this.getUpdateTime());
		inst.setId(this.getId());
		inst.setOwnerId(this.getOwnerId());
		inst.setVersion(this.getVersion());
		inst.clearModifies();
		return inst;
	}

	/**
	 * 克隆当前对象
	*/
	@Transient
	public AutoActionSScript clone(boolean deep) {
		return EntityContext.clone(AutoActionSScript.class,this,deep);
	}

	/**
	 * 将 Map 转换成 AutoActionSScript
	 * @param autoActionSScriptMap 包含实体信息的 Map 对象
	 * @return AutoActionSScript , 转换好的的 AutoActionSScript 对象
	*/
	@Transient
	public static AutoActionSScript createFrom(Map<String,Object> autoActionSScriptMap) {
		if(autoActionSScriptMap==null) return null;
		AutoActionSScript po = create();
		EntityContext.copyProperties(po,autoActionSScriptMap);
		po.clearModifies();
		return po;
	}

	/**
	 * 将 Pojo 转换成 AutoActionSScript
	 * @param pojo 包含实体信息的 Pojo 对象
	 * @return AutoActionSScript , 转换好的的 AutoActionSScript 对象
	*/
	@Transient
	public static AutoActionSScript createFrom(Object pojo) {
		if(pojo==null) return null;
		AutoActionSScript po = create();
		EntityContext.copyProperties(po,pojo);
		po.clearModifies();
		return po;
	}

	/**
	 * 创建一个 AutoActionSScript，等同于 new
	 * @return AutoActionSScript 对象
	*/
	@Transient
	public static AutoActionSScript create() {
		return new com.dt.platform.domain.ops.meta.AutoActionSScriptMeta.$$proxy$$();
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
			this.setScriptId(DataParser.parse(String.class, map.get(AutoActionSScriptMeta.SCRIPT_ID)));
			this.setDeleted(DataParser.parse(Integer.class, map.get(AutoActionSScriptMeta.DELETED)));
			this.setUpdateBy(DataParser.parse(String.class, map.get(AutoActionSScriptMeta.UPDATE_BY)));
			this.setDeleteTime(DataParser.parse(Date.class, map.get(AutoActionSScriptMeta.DELETE_TIME)));
			this.setDeleteBy(DataParser.parse(String.class, map.get(AutoActionSScriptMeta.DELETE_BY)));
			this.setUpdateTime(DataParser.parse(Date.class, map.get(AutoActionSScriptMeta.UPDATE_TIME)));
			this.setId(DataParser.parse(String.class, map.get(AutoActionSScriptMeta.ID)));
			this.setOwnerId(DataParser.parse(String.class, map.get(AutoActionSScriptMeta.OWNER_ID)));
			this.setVersion(DataParser.parse(Integer.class, map.get(AutoActionSScriptMeta.VERSION)));
			// others
			return true;
		} else {
			try {
				this.setScriptId( (String)map.get(AutoActionSScriptMeta.SCRIPT_ID));
				this.setDeleted( (Integer)map.get(AutoActionSScriptMeta.DELETED));
				this.setUpdateBy( (String)map.get(AutoActionSScriptMeta.UPDATE_BY));
				this.setDeleteTime( (Date)map.get(AutoActionSScriptMeta.DELETE_TIME));
				this.setDeleteBy( (String)map.get(AutoActionSScriptMeta.DELETE_BY));
				this.setUpdateTime( (Date)map.get(AutoActionSScriptMeta.UPDATE_TIME));
				this.setId( (String)map.get(AutoActionSScriptMeta.ID));
				this.setOwnerId( (String)map.get(AutoActionSScriptMeta.OWNER_ID));
				this.setVersion( (Integer)map.get(AutoActionSScriptMeta.VERSION));
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
			this.setScriptId(DataParser.parse(String.class, r.getValue(AutoActionSScriptMeta.SCRIPT_ID)));
			this.setDeleted(DataParser.parse(Integer.class, r.getValue(AutoActionSScriptMeta.DELETED)));
			this.setUpdateBy(DataParser.parse(String.class, r.getValue(AutoActionSScriptMeta.UPDATE_BY)));
			this.setDeleteTime(DataParser.parse(Date.class, r.getValue(AutoActionSScriptMeta.DELETE_TIME)));
			this.setDeleteBy(DataParser.parse(String.class, r.getValue(AutoActionSScriptMeta.DELETE_BY)));
			this.setUpdateTime(DataParser.parse(Date.class, r.getValue(AutoActionSScriptMeta.UPDATE_TIME)));
			this.setId(DataParser.parse(String.class, r.getValue(AutoActionSScriptMeta.ID)));
			this.setOwnerId(DataParser.parse(String.class, r.getValue(AutoActionSScriptMeta.OWNER_ID)));
			this.setVersion(DataParser.parse(Integer.class, r.getValue(AutoActionSScriptMeta.VERSION)));
			return true;
		} else {
			try {
				this.setScriptId( (String)r.getValue(AutoActionSScriptMeta.SCRIPT_ID));
				this.setDeleted( (Integer)r.getValue(AutoActionSScriptMeta.DELETED));
				this.setUpdateBy( (String)r.getValue(AutoActionSScriptMeta.UPDATE_BY));
				this.setDeleteTime( (Date)r.getValue(AutoActionSScriptMeta.DELETE_TIME));
				this.setDeleteBy( (String)r.getValue(AutoActionSScriptMeta.DELETE_BY));
				this.setUpdateTime( (Date)r.getValue(AutoActionSScriptMeta.UPDATE_TIME));
				this.setId( (String)r.getValue(AutoActionSScriptMeta.ID));
				this.setOwnerId( (String)r.getValue(AutoActionSScriptMeta.OWNER_ID));
				this.setVersion( (Integer)r.getValue(AutoActionSScriptMeta.VERSION));
				return true;
			} catch (Exception e) {
				return false;
			}
		}
	}
}