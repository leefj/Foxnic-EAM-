package com.dt.platform.domain.eam;

import com.github.foxnic.dao.entity.Entity;
import io.swagger.annotations.ApiModel;
import javax.persistence.Table;
import com.github.foxnic.sql.meta.DBTable;
import com.dt.platform.constants.db.EAMTables.EAM_MAPPING_OWNER;
import javax.persistence.Id;
import io.swagger.annotations.ApiModelProperty;
import java.util.Date;
import javax.persistence.Transient;
import com.github.foxnic.api.swagger.EnumFor;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.github.foxnic.commons.lang.DataParser;
import java.util.Map;
import com.github.foxnic.dao.entity.EntityContext;
import com.dt.platform.domain.eam.meta.MappingOwnerMeta;
import com.github.foxnic.sql.data.ExprRcd;



/**
 * 归属
 * <p>归属 , 数据表 eam_mapping_owner 的PO类型</p>
 * @author 金杰 , maillank@qq.com
 * @since 2023-07-10 18:26:18
 * @sign E0F96657F24A61F10EB7B5AFA6CC725A
 * 此文件由工具自动生成，请勿修改。若表结构或配置发生变动，请使用工具重新生成。
*/

@Table(name = "eam_mapping_owner")
@ApiModel(description = "归属 ; 归属 , 数据表 eam_mapping_owner 的PO类型")
public class MappingOwner extends Entity {

	private static final long serialVersionUID = 1L;

	public static final DBTable TABLE =EAM_MAPPING_OWNER.$TABLE;
	
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
	 * 选择：选择
	*/
	@ApiModelProperty(required = false,value="选择" , notes = "选择")
	private String selectedCode;
	
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
	public MappingOwner setId(String id) {
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
	public MappingOwner setOwnerId(String ownerId) {
		this.ownerId=ownerId;
		return this;
	}
	
	/**
	 * 获得 选择<br>
	 * 选择
	 * @return 选择
	*/
	public String getSelectedCode() {
		return selectedCode;
	}
	
	/**
	 * 设置 选择
	 * @param selectedCode 选择
	 * @return 当前对象
	*/
	public MappingOwner setSelectedCode(String selectedCode) {
		this.selectedCode=selectedCode;
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
	public MappingOwner setCreateBy(String createBy) {
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
	public MappingOwner setCreateTime(Date createTime) {
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
	public MappingOwner setUpdateBy(String updateBy) {
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
	public MappingOwner setUpdateTime(Date updateTime) {
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
	public MappingOwner setDeleted(Integer deleted) {
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
	public MappingOwner setDeleted(Boolean deletedBool) {
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
	public MappingOwner setDeleteBy(String deleteBy) {
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
	public MappingOwner setDeleteTime(Date deleteTime) {
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
	public MappingOwner setVersion(Integer version) {
		this.version=version;
		return this;
	}

	/**
	 * 将自己转换成指定类型的PO
	 * @param poType  PO类型
	 * @return MappingOwner , 转换好的 MappingOwner 对象
	*/
	@Transient
	public <T extends Entity> T toPO(Class<T> poType) {
		return EntityContext.create(poType, this);
	}

	/**
	 * 将自己转换成任意指定类型
	 * @param pojoType  Pojo类型
	 * @return MappingOwner , 转换好的 PoJo 对象
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
	public MappingOwner clone() {
		return duplicate(true);
	}

	/**
	 * 复制当前对象
	 * @param all 是否复制全部属性，当 false 时，仅复制来自数据表的属性
	*/
	@Transient
	public MappingOwner duplicate(boolean all) {
		com.dt.platform.domain.eam.meta.MappingOwnerMeta.$$proxy$$ inst = new com.dt.platform.domain.eam.meta.MappingOwnerMeta.$$proxy$$();
		inst.setCreateBy(this.getCreateBy());
		inst.setDeleted(this.getDeleted());
		inst.setCreateTime(this.getCreateTime());
		inst.setUpdateBy(this.getUpdateBy());
		inst.setDeleteTime(this.getDeleteTime());
		inst.setDeleteBy(this.getDeleteBy());
		inst.setUpdateTime(this.getUpdateTime());
		inst.setId(this.getId());
		inst.setOwnerId(this.getOwnerId());
		inst.setSelectedCode(this.getSelectedCode());
		inst.setVersion(this.getVersion());
		inst.clearModifies();
		return inst;
	}

	/**
	 * 克隆当前对象
	*/
	@Transient
	public MappingOwner clone(boolean deep) {
		return EntityContext.clone(MappingOwner.class,this,deep);
	}

	/**
	 * 将 Map 转换成 MappingOwner
	 * @param mappingOwnerMap 包含实体信息的 Map 对象
	 * @return MappingOwner , 转换好的的 MappingOwner 对象
	*/
	@Transient
	public static MappingOwner createFrom(Map<String,Object> mappingOwnerMap) {
		if(mappingOwnerMap==null) return null;
		MappingOwner po = create();
		EntityContext.copyProperties(po,mappingOwnerMap);
		po.clearModifies();
		return po;
	}

	/**
	 * 将 Pojo 转换成 MappingOwner
	 * @param pojo 包含实体信息的 Pojo 对象
	 * @return MappingOwner , 转换好的的 MappingOwner 对象
	*/
	@Transient
	public static MappingOwner createFrom(Object pojo) {
		if(pojo==null) return null;
		MappingOwner po = create();
		EntityContext.copyProperties(po,pojo);
		po.clearModifies();
		return po;
	}

	/**
	 * 创建一个 MappingOwner，等同于 new
	 * @return MappingOwner 对象
	*/
	@Transient
	public static MappingOwner create() {
		return new com.dt.platform.domain.eam.meta.MappingOwnerMeta.$$proxy$$();
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
			this.setCreateBy(DataParser.parse(String.class, map.get(MappingOwnerMeta.CREATE_BY)));
			this.setDeleted(DataParser.parse(Integer.class, map.get(MappingOwnerMeta.DELETED)));
			this.setCreateTime(DataParser.parse(Date.class, map.get(MappingOwnerMeta.CREATE_TIME)));
			this.setUpdateBy(DataParser.parse(String.class, map.get(MappingOwnerMeta.UPDATE_BY)));
			this.setDeleteTime(DataParser.parse(Date.class, map.get(MappingOwnerMeta.DELETE_TIME)));
			this.setDeleteBy(DataParser.parse(String.class, map.get(MappingOwnerMeta.DELETE_BY)));
			this.setUpdateTime(DataParser.parse(Date.class, map.get(MappingOwnerMeta.UPDATE_TIME)));
			this.setId(DataParser.parse(String.class, map.get(MappingOwnerMeta.ID)));
			this.setOwnerId(DataParser.parse(String.class, map.get(MappingOwnerMeta.OWNER_ID)));
			this.setSelectedCode(DataParser.parse(String.class, map.get(MappingOwnerMeta.SELECTED_CODE)));
			this.setVersion(DataParser.parse(Integer.class, map.get(MappingOwnerMeta.VERSION)));
			// others
			return true;
		} else {
			try {
				this.setCreateBy( (String)map.get(MappingOwnerMeta.CREATE_BY));
				this.setDeleted( (Integer)map.get(MappingOwnerMeta.DELETED));
				this.setCreateTime( (Date)map.get(MappingOwnerMeta.CREATE_TIME));
				this.setUpdateBy( (String)map.get(MappingOwnerMeta.UPDATE_BY));
				this.setDeleteTime( (Date)map.get(MappingOwnerMeta.DELETE_TIME));
				this.setDeleteBy( (String)map.get(MappingOwnerMeta.DELETE_BY));
				this.setUpdateTime( (Date)map.get(MappingOwnerMeta.UPDATE_TIME));
				this.setId( (String)map.get(MappingOwnerMeta.ID));
				this.setOwnerId( (String)map.get(MappingOwnerMeta.OWNER_ID));
				this.setSelectedCode( (String)map.get(MappingOwnerMeta.SELECTED_CODE));
				this.setVersion( (Integer)map.get(MappingOwnerMeta.VERSION));
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
			this.setCreateBy(DataParser.parse(String.class, r.getValue(MappingOwnerMeta.CREATE_BY)));
			this.setDeleted(DataParser.parse(Integer.class, r.getValue(MappingOwnerMeta.DELETED)));
			this.setCreateTime(DataParser.parse(Date.class, r.getValue(MappingOwnerMeta.CREATE_TIME)));
			this.setUpdateBy(DataParser.parse(String.class, r.getValue(MappingOwnerMeta.UPDATE_BY)));
			this.setDeleteTime(DataParser.parse(Date.class, r.getValue(MappingOwnerMeta.DELETE_TIME)));
			this.setDeleteBy(DataParser.parse(String.class, r.getValue(MappingOwnerMeta.DELETE_BY)));
			this.setUpdateTime(DataParser.parse(Date.class, r.getValue(MappingOwnerMeta.UPDATE_TIME)));
			this.setId(DataParser.parse(String.class, r.getValue(MappingOwnerMeta.ID)));
			this.setOwnerId(DataParser.parse(String.class, r.getValue(MappingOwnerMeta.OWNER_ID)));
			this.setSelectedCode(DataParser.parse(String.class, r.getValue(MappingOwnerMeta.SELECTED_CODE)));
			this.setVersion(DataParser.parse(Integer.class, r.getValue(MappingOwnerMeta.VERSION)));
			return true;
		} else {
			try {
				this.setCreateBy( (String)r.getValue(MappingOwnerMeta.CREATE_BY));
				this.setDeleted( (Integer)r.getValue(MappingOwnerMeta.DELETED));
				this.setCreateTime( (Date)r.getValue(MappingOwnerMeta.CREATE_TIME));
				this.setUpdateBy( (String)r.getValue(MappingOwnerMeta.UPDATE_BY));
				this.setDeleteTime( (Date)r.getValue(MappingOwnerMeta.DELETE_TIME));
				this.setDeleteBy( (String)r.getValue(MappingOwnerMeta.DELETE_BY));
				this.setUpdateTime( (Date)r.getValue(MappingOwnerMeta.UPDATE_TIME));
				this.setId( (String)r.getValue(MappingOwnerMeta.ID));
				this.setOwnerId( (String)r.getValue(MappingOwnerMeta.OWNER_ID));
				this.setSelectedCode( (String)r.getValue(MappingOwnerMeta.SELECTED_CODE));
				this.setVersion( (Integer)r.getValue(MappingOwnerMeta.VERSION));
				return true;
			} catch (Exception e) {
				return false;
			}
		}
	}
}