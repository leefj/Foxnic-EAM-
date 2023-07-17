package com.dt.platform.domain.eam;

import com.github.foxnic.dao.entity.Entity;
import io.swagger.annotations.ApiModel;
import javax.persistence.Table;
import com.github.foxnic.sql.meta.DBTable;
import com.dt.platform.constants.db.EAMTables.EAM_DEVICE_ASSOCIATE;
import javax.persistence.Id;
import io.swagger.annotations.ApiModelProperty;
import java.util.Date;
import javax.persistence.Transient;
import com.github.foxnic.api.swagger.EnumFor;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.github.foxnic.commons.lang.DataParser;
import java.util.Map;
import com.github.foxnic.dao.entity.EntityContext;
import com.dt.platform.domain.eam.meta.DeviceAssociateMeta;
import com.github.foxnic.sql.data.ExprRcd;



/**
 * 备件关联
 * <p>备件关联 , 数据表 eam_device_associate 的PO类型</p>
 * @author 金杰 , maillank@qq.com
 * @since 2023-07-15 10:44:08
 * @sign A556CD0507D2D214759B219ADC23A6AD
 * 此文件由工具自动生成，请勿修改。若表结构或配置发生变动，请使用工具重新生成。
*/

@Table(name = "eam_device_associate")
@ApiModel(description = "备件关联 ; 备件关联 , 数据表 eam_device_associate 的PO类型")
public class DeviceAssociate extends Entity {

	private static final long serialVersionUID = 1L;

	public static final DBTable TABLE =EAM_DEVICE_ASSOCIATE.$TABLE;
	
	/**
	 * 主键：主键
	*/
	@Id
	@ApiModelProperty(required = true,value="主键" , notes = "主键")
	private String id;
	
	/**
	 * 名称：名称
	*/
	@ApiModelProperty(required = false,value="名称" , notes = "名称")
	private String associateName;
	
	/**
	 * 父节点：父节点
	*/
	@ApiModelProperty(required = false,value="父节点" , notes = "父节点")
	private String parentId;
	
	/**
	 * 排序：排序
	*/
	@ApiModelProperty(required = false,value="排序" , notes = "排序")
	private Integer sort;
	
	/**
	 * 节点路径：节点路径
	*/
	@ApiModelProperty(required = false,value="节点路径" , notes = "节点路径")
	private String hierarchy;
	
	/**
	 * 节点路径名称：节点路径名称
	*/
	@ApiModelProperty(required = false,value="节点路径名称" , notes = "节点路径名称")
	private String hierarchyName;
	
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
	@ApiModelProperty(required = false,value="version" , notes = "version")
	private Integer version;
	
	/**
	 * 租户：租户
	*/
	@ApiModelProperty(required = false,value="租户" , notes = "租户")
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
	public DeviceAssociate setId(String id) {
		this.id=id;
		return this;
	}
	
	/**
	 * 获得 名称<br>
	 * 名称
	 * @return 名称
	*/
	public String getAssociateName() {
		return associateName;
	}
	
	/**
	 * 设置 名称
	 * @param associateName 名称
	 * @return 当前对象
	*/
	public DeviceAssociate setAssociateName(String associateName) {
		this.associateName=associateName;
		return this;
	}
	
	/**
	 * 获得 父节点<br>
	 * 父节点
	 * @return 父节点
	*/
	public String getParentId() {
		return parentId;
	}
	
	/**
	 * 设置 父节点
	 * @param parentId 父节点
	 * @return 当前对象
	*/
	public DeviceAssociate setParentId(String parentId) {
		this.parentId=parentId;
		return this;
	}
	
	/**
	 * 获得 排序<br>
	 * 排序
	 * @return 排序
	*/
	public Integer getSort() {
		return sort;
	}
	
	/**
	 * 设置 排序
	 * @param sort 排序
	 * @return 当前对象
	*/
	public DeviceAssociate setSort(Integer sort) {
		this.sort=sort;
		return this;
	}
	
	/**
	 * 获得 节点路径<br>
	 * 节点路径
	 * @return 节点路径
	*/
	public String getHierarchy() {
		return hierarchy;
	}
	
	/**
	 * 设置 节点路径
	 * @param hierarchy 节点路径
	 * @return 当前对象
	*/
	public DeviceAssociate setHierarchy(String hierarchy) {
		this.hierarchy=hierarchy;
		return this;
	}
	
	/**
	 * 获得 节点路径名称<br>
	 * 节点路径名称
	 * @return 节点路径名称
	*/
	public String getHierarchyName() {
		return hierarchyName;
	}
	
	/**
	 * 设置 节点路径名称
	 * @param hierarchyName 节点路径名称
	 * @return 当前对象
	*/
	public DeviceAssociate setHierarchyName(String hierarchyName) {
		this.hierarchyName=hierarchyName;
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
	public DeviceAssociate setNotes(String notes) {
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
	public DeviceAssociate setCreateBy(String createBy) {
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
	public DeviceAssociate setCreateTime(Date createTime) {
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
	public DeviceAssociate setUpdateBy(String updateBy) {
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
	public DeviceAssociate setUpdateTime(Date updateTime) {
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
	public DeviceAssociate setDeleted(Integer deleted) {
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
	public DeviceAssociate setDeleted(Boolean deletedBool) {
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
	public DeviceAssociate setDeleteBy(String deleteBy) {
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
	public DeviceAssociate setDeleteTime(Date deleteTime) {
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
	public DeviceAssociate setVersion(Integer version) {
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
	public DeviceAssociate setTenantId(String tenantId) {
		this.tenantId=tenantId;
		return this;
	}

	/**
	 * 将自己转换成指定类型的PO
	 * @param poType  PO类型
	 * @return DeviceAssociate , 转换好的 DeviceAssociate 对象
	*/
	@Transient
	public <T extends Entity> T toPO(Class<T> poType) {
		return EntityContext.create(poType, this);
	}

	/**
	 * 将自己转换成任意指定类型
	 * @param pojoType  Pojo类型
	 * @return DeviceAssociate , 转换好的 PoJo 对象
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
	public DeviceAssociate clone() {
		return duplicate(true);
	}

	/**
	 * 复制当前对象
	 * @param all 是否复制全部属性，当 false 时，仅复制来自数据表的属性
	*/
	@Transient
	public DeviceAssociate duplicate(boolean all) {
		com.dt.platform.domain.eam.meta.DeviceAssociateMeta.$$proxy$$ inst = new com.dt.platform.domain.eam.meta.DeviceAssociateMeta.$$proxy$$();
		inst.setNotes(this.getNotes());
		inst.setHierarchy(this.getHierarchy());
		inst.setHierarchyName(this.getHierarchyName());
		inst.setUpdateTime(this.getUpdateTime());
		inst.setSort(this.getSort());
		inst.setVersion(this.getVersion());
		inst.setParentId(this.getParentId());
		inst.setCreateBy(this.getCreateBy());
		inst.setDeleted(this.getDeleted());
		inst.setAssociateName(this.getAssociateName());
		inst.setCreateTime(this.getCreateTime());
		inst.setUpdateBy(this.getUpdateBy());
		inst.setDeleteTime(this.getDeleteTime());
		inst.setTenantId(this.getTenantId());
		inst.setDeleteBy(this.getDeleteBy());
		inst.setId(this.getId());
		inst.clearModifies();
		return inst;
	}

	/**
	 * 克隆当前对象
	*/
	@Transient
	public DeviceAssociate clone(boolean deep) {
		return EntityContext.clone(DeviceAssociate.class,this,deep);
	}

	/**
	 * 将 Map 转换成 DeviceAssociate
	 * @param deviceAssociateMap 包含实体信息的 Map 对象
	 * @return DeviceAssociate , 转换好的的 DeviceAssociate 对象
	*/
	@Transient
	public static DeviceAssociate createFrom(Map<String,Object> deviceAssociateMap) {
		if(deviceAssociateMap==null) return null;
		DeviceAssociate po = create();
		EntityContext.copyProperties(po,deviceAssociateMap);
		po.clearModifies();
		return po;
	}

	/**
	 * 将 Pojo 转换成 DeviceAssociate
	 * @param pojo 包含实体信息的 Pojo 对象
	 * @return DeviceAssociate , 转换好的的 DeviceAssociate 对象
	*/
	@Transient
	public static DeviceAssociate createFrom(Object pojo) {
		if(pojo==null) return null;
		DeviceAssociate po = create();
		EntityContext.copyProperties(po,pojo);
		po.clearModifies();
		return po;
	}

	/**
	 * 创建一个 DeviceAssociate，等同于 new
	 * @return DeviceAssociate 对象
	*/
	@Transient
	public static DeviceAssociate create() {
		return new com.dt.platform.domain.eam.meta.DeviceAssociateMeta.$$proxy$$();
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
			this.setNotes(DataParser.parse(String.class, map.get(DeviceAssociateMeta.NOTES)));
			this.setHierarchy(DataParser.parse(String.class, map.get(DeviceAssociateMeta.HIERARCHY)));
			this.setHierarchyName(DataParser.parse(String.class, map.get(DeviceAssociateMeta.HIERARCHY_NAME)));
			this.setUpdateTime(DataParser.parse(Date.class, map.get(DeviceAssociateMeta.UPDATE_TIME)));
			this.setSort(DataParser.parse(Integer.class, map.get(DeviceAssociateMeta.SORT)));
			this.setVersion(DataParser.parse(Integer.class, map.get(DeviceAssociateMeta.VERSION)));
			this.setParentId(DataParser.parse(String.class, map.get(DeviceAssociateMeta.PARENT_ID)));
			this.setCreateBy(DataParser.parse(String.class, map.get(DeviceAssociateMeta.CREATE_BY)));
			this.setDeleted(DataParser.parse(Integer.class, map.get(DeviceAssociateMeta.DELETED)));
			this.setAssociateName(DataParser.parse(String.class, map.get(DeviceAssociateMeta.ASSOCIATE_NAME)));
			this.setCreateTime(DataParser.parse(Date.class, map.get(DeviceAssociateMeta.CREATE_TIME)));
			this.setUpdateBy(DataParser.parse(String.class, map.get(DeviceAssociateMeta.UPDATE_BY)));
			this.setDeleteTime(DataParser.parse(Date.class, map.get(DeviceAssociateMeta.DELETE_TIME)));
			this.setTenantId(DataParser.parse(String.class, map.get(DeviceAssociateMeta.TENANT_ID)));
			this.setDeleteBy(DataParser.parse(String.class, map.get(DeviceAssociateMeta.DELETE_BY)));
			this.setId(DataParser.parse(String.class, map.get(DeviceAssociateMeta.ID)));
			// others
			return true;
		} else {
			try {
				this.setNotes( (String)map.get(DeviceAssociateMeta.NOTES));
				this.setHierarchy( (String)map.get(DeviceAssociateMeta.HIERARCHY));
				this.setHierarchyName( (String)map.get(DeviceAssociateMeta.HIERARCHY_NAME));
				this.setUpdateTime( (Date)map.get(DeviceAssociateMeta.UPDATE_TIME));
				this.setSort( (Integer)map.get(DeviceAssociateMeta.SORT));
				this.setVersion( (Integer)map.get(DeviceAssociateMeta.VERSION));
				this.setParentId( (String)map.get(DeviceAssociateMeta.PARENT_ID));
				this.setCreateBy( (String)map.get(DeviceAssociateMeta.CREATE_BY));
				this.setDeleted( (Integer)map.get(DeviceAssociateMeta.DELETED));
				this.setAssociateName( (String)map.get(DeviceAssociateMeta.ASSOCIATE_NAME));
				this.setCreateTime( (Date)map.get(DeviceAssociateMeta.CREATE_TIME));
				this.setUpdateBy( (String)map.get(DeviceAssociateMeta.UPDATE_BY));
				this.setDeleteTime( (Date)map.get(DeviceAssociateMeta.DELETE_TIME));
				this.setTenantId( (String)map.get(DeviceAssociateMeta.TENANT_ID));
				this.setDeleteBy( (String)map.get(DeviceAssociateMeta.DELETE_BY));
				this.setId( (String)map.get(DeviceAssociateMeta.ID));
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
			this.setNotes(DataParser.parse(String.class, r.getValue(DeviceAssociateMeta.NOTES)));
			this.setHierarchy(DataParser.parse(String.class, r.getValue(DeviceAssociateMeta.HIERARCHY)));
			this.setHierarchyName(DataParser.parse(String.class, r.getValue(DeviceAssociateMeta.HIERARCHY_NAME)));
			this.setUpdateTime(DataParser.parse(Date.class, r.getValue(DeviceAssociateMeta.UPDATE_TIME)));
			this.setSort(DataParser.parse(Integer.class, r.getValue(DeviceAssociateMeta.SORT)));
			this.setVersion(DataParser.parse(Integer.class, r.getValue(DeviceAssociateMeta.VERSION)));
			this.setParentId(DataParser.parse(String.class, r.getValue(DeviceAssociateMeta.PARENT_ID)));
			this.setCreateBy(DataParser.parse(String.class, r.getValue(DeviceAssociateMeta.CREATE_BY)));
			this.setDeleted(DataParser.parse(Integer.class, r.getValue(DeviceAssociateMeta.DELETED)));
			this.setAssociateName(DataParser.parse(String.class, r.getValue(DeviceAssociateMeta.ASSOCIATE_NAME)));
			this.setCreateTime(DataParser.parse(Date.class, r.getValue(DeviceAssociateMeta.CREATE_TIME)));
			this.setUpdateBy(DataParser.parse(String.class, r.getValue(DeviceAssociateMeta.UPDATE_BY)));
			this.setDeleteTime(DataParser.parse(Date.class, r.getValue(DeviceAssociateMeta.DELETE_TIME)));
			this.setTenantId(DataParser.parse(String.class, r.getValue(DeviceAssociateMeta.TENANT_ID)));
			this.setDeleteBy(DataParser.parse(String.class, r.getValue(DeviceAssociateMeta.DELETE_BY)));
			this.setId(DataParser.parse(String.class, r.getValue(DeviceAssociateMeta.ID)));
			return true;
		} else {
			try {
				this.setNotes( (String)r.getValue(DeviceAssociateMeta.NOTES));
				this.setHierarchy( (String)r.getValue(DeviceAssociateMeta.HIERARCHY));
				this.setHierarchyName( (String)r.getValue(DeviceAssociateMeta.HIERARCHY_NAME));
				this.setUpdateTime( (Date)r.getValue(DeviceAssociateMeta.UPDATE_TIME));
				this.setSort( (Integer)r.getValue(DeviceAssociateMeta.SORT));
				this.setVersion( (Integer)r.getValue(DeviceAssociateMeta.VERSION));
				this.setParentId( (String)r.getValue(DeviceAssociateMeta.PARENT_ID));
				this.setCreateBy( (String)r.getValue(DeviceAssociateMeta.CREATE_BY));
				this.setDeleted( (Integer)r.getValue(DeviceAssociateMeta.DELETED));
				this.setAssociateName( (String)r.getValue(DeviceAssociateMeta.ASSOCIATE_NAME));
				this.setCreateTime( (Date)r.getValue(DeviceAssociateMeta.CREATE_TIME));
				this.setUpdateBy( (String)r.getValue(DeviceAssociateMeta.UPDATE_BY));
				this.setDeleteTime( (Date)r.getValue(DeviceAssociateMeta.DELETE_TIME));
				this.setTenantId( (String)r.getValue(DeviceAssociateMeta.TENANT_ID));
				this.setDeleteBy( (String)r.getValue(DeviceAssociateMeta.DELETE_BY));
				this.setId( (String)r.getValue(DeviceAssociateMeta.ID));
				return true;
			} catch (Exception e) {
				return false;
			}
		}
	}
}