package com.dt.platform.domain.eam;

import com.github.foxnic.dao.entity.Entity;
import io.swagger.annotations.ApiModel;
import javax.persistence.Table;
import com.github.foxnic.sql.meta.DBTable;
import com.dt.platform.constants.db.EAMTables.EAM_DEVICE_SP_TYPE;
import javax.persistence.Id;
import io.swagger.annotations.ApiModelProperty;
import java.math.BigDecimal;
import java.util.Date;
import javax.persistence.Transient;
import com.github.foxnic.api.swagger.EnumFor;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.github.foxnic.commons.lang.DataParser;
import java.util.Map;
import com.github.foxnic.dao.entity.EntityContext;
import com.dt.platform.domain.eam.meta.DeviceSpTypeMeta;
import com.github.foxnic.sql.data.ExprRcd;



/**
 * 备件分类
 * <p>备件分类 , 数据表 eam_device_sp_type 的PO类型</p>
 * @author 金杰 , maillank@qq.com
 * @since 2023-07-15 07:49:22
 * @sign 09C755A2D1FBBD9BB7B757152A0792DA
 * 此文件由工具自动生成，请勿修改。若表结构或配置发生变动，请使用工具重新生成。
*/

@Table(name = "eam_device_sp_type")
@ApiModel(description = "备件分类 ; 备件分类 , 数据表 eam_device_sp_type 的PO类型")
public class DeviceSpType extends Entity {

	private static final long serialVersionUID = 1L;

	public static final DBTable TABLE =EAM_DEVICE_SP_TYPE.$TABLE;
	
	/**
	 * 主键：主键
	*/
	@Id
	@ApiModelProperty(required = true,value="主键" , notes = "主键")
	private String id;
	
	/**
	 * 状态：状态
	*/
	@ApiModelProperty(required = false,value="状态" , notes = "状态")
	private String status;
	
	/**
	 * 名称：名称
	*/
	@ApiModelProperty(required = false,value="名称" , notes = "名称")
	private String categoryName;
	
	/**
	 * 全称：全称
	*/
	@ApiModelProperty(required = false,value="全称" , notes = "全称")
	private String categoryFullname;
	
	/**
	 * 编码：编码
	*/
	@ApiModelProperty(required = false,value="编码" , notes = "编码")
	private String categoryCode;
	
	/**
	 * 使用期限：使用期限
	*/
	@ApiModelProperty(required = false,value="使用期限" , notes = "使用期限")
	private BigDecimal serviceLife;
	
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
	public DeviceSpType setId(String id) {
		this.id=id;
		return this;
	}
	
	/**
	 * 获得 状态<br>
	 * 状态
	 * @return 状态
	*/
	public String getStatus() {
		return status;
	}
	
	/**
	 * 设置 状态
	 * @param status 状态
	 * @return 当前对象
	*/
	public DeviceSpType setStatus(String status) {
		this.status=status;
		return this;
	}
	
	/**
	 * 获得 名称<br>
	 * 名称
	 * @return 名称
	*/
	public String getCategoryName() {
		return categoryName;
	}
	
	/**
	 * 设置 名称
	 * @param categoryName 名称
	 * @return 当前对象
	*/
	public DeviceSpType setCategoryName(String categoryName) {
		this.categoryName=categoryName;
		return this;
	}
	
	/**
	 * 获得 全称<br>
	 * 全称
	 * @return 全称
	*/
	public String getCategoryFullname() {
		return categoryFullname;
	}
	
	/**
	 * 设置 全称
	 * @param categoryFullname 全称
	 * @return 当前对象
	*/
	public DeviceSpType setCategoryFullname(String categoryFullname) {
		this.categoryFullname=categoryFullname;
		return this;
	}
	
	/**
	 * 获得 编码<br>
	 * 编码
	 * @return 编码
	*/
	public String getCategoryCode() {
		return categoryCode;
	}
	
	/**
	 * 设置 编码
	 * @param categoryCode 编码
	 * @return 当前对象
	*/
	public DeviceSpType setCategoryCode(String categoryCode) {
		this.categoryCode=categoryCode;
		return this;
	}
	
	/**
	 * 获得 使用期限<br>
	 * 使用期限
	 * @return 使用期限
	*/
	public BigDecimal getServiceLife() {
		return serviceLife;
	}
	
	/**
	 * 设置 使用期限
	 * @param serviceLife 使用期限
	 * @return 当前对象
	*/
	public DeviceSpType setServiceLife(BigDecimal serviceLife) {
		this.serviceLife=serviceLife;
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
	public DeviceSpType setParentId(String parentId) {
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
	public DeviceSpType setSort(Integer sort) {
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
	public DeviceSpType setHierarchy(String hierarchy) {
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
	public DeviceSpType setHierarchyName(String hierarchyName) {
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
	public DeviceSpType setNotes(String notes) {
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
	public DeviceSpType setCreateBy(String createBy) {
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
	public DeviceSpType setCreateTime(Date createTime) {
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
	public DeviceSpType setUpdateBy(String updateBy) {
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
	public DeviceSpType setUpdateTime(Date updateTime) {
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
	public DeviceSpType setDeleted(Integer deleted) {
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
	public DeviceSpType setDeleted(Boolean deletedBool) {
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
	public DeviceSpType setDeleteBy(String deleteBy) {
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
	public DeviceSpType setDeleteTime(Date deleteTime) {
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
	public DeviceSpType setVersion(Integer version) {
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
	public DeviceSpType setTenantId(String tenantId) {
		this.tenantId=tenantId;
		return this;
	}

	/**
	 * 将自己转换成指定类型的PO
	 * @param poType  PO类型
	 * @return DeviceSpType , 转换好的 DeviceSpType 对象
	*/
	@Transient
	public <T extends Entity> T toPO(Class<T> poType) {
		return EntityContext.create(poType, this);
	}

	/**
	 * 将自己转换成任意指定类型
	 * @param pojoType  Pojo类型
	 * @return DeviceSpType , 转换好的 PoJo 对象
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
	public DeviceSpType clone() {
		return duplicate(true);
	}

	/**
	 * 复制当前对象
	 * @param all 是否复制全部属性，当 false 时，仅复制来自数据表的属性
	*/
	@Transient
	public DeviceSpType duplicate(boolean all) {
		com.dt.platform.domain.eam.meta.DeviceSpTypeMeta.$$proxy$$ inst = new com.dt.platform.domain.eam.meta.DeviceSpTypeMeta.$$proxy$$();
		inst.setNotes(this.getNotes());
		inst.setHierarchy(this.getHierarchy());
		inst.setHierarchyName(this.getHierarchyName());
		inst.setUpdateTime(this.getUpdateTime());
		inst.setCategoryCode(this.getCategoryCode());
		inst.setSort(this.getSort());
		inst.setCategoryName(this.getCategoryName());
		inst.setVersion(this.getVersion());
		inst.setParentId(this.getParentId());
		inst.setCategoryFullname(this.getCategoryFullname());
		inst.setCreateBy(this.getCreateBy());
		inst.setDeleted(this.getDeleted());
		inst.setCreateTime(this.getCreateTime());
		inst.setUpdateBy(this.getUpdateBy());
		inst.setDeleteTime(this.getDeleteTime());
		inst.setTenantId(this.getTenantId());
		inst.setDeleteBy(this.getDeleteBy());
		inst.setServiceLife(this.getServiceLife());
		inst.setId(this.getId());
		inst.setStatus(this.getStatus());
		inst.clearModifies();
		return inst;
	}

	/**
	 * 克隆当前对象
	*/
	@Transient
	public DeviceSpType clone(boolean deep) {
		return EntityContext.clone(DeviceSpType.class,this,deep);
	}

	/**
	 * 将 Map 转换成 DeviceSpType
	 * @param deviceSpTypeMap 包含实体信息的 Map 对象
	 * @return DeviceSpType , 转换好的的 DeviceSpType 对象
	*/
	@Transient
	public static DeviceSpType createFrom(Map<String,Object> deviceSpTypeMap) {
		if(deviceSpTypeMap==null) return null;
		DeviceSpType po = create();
		EntityContext.copyProperties(po,deviceSpTypeMap);
		po.clearModifies();
		return po;
	}

	/**
	 * 将 Pojo 转换成 DeviceSpType
	 * @param pojo 包含实体信息的 Pojo 对象
	 * @return DeviceSpType , 转换好的的 DeviceSpType 对象
	*/
	@Transient
	public static DeviceSpType createFrom(Object pojo) {
		if(pojo==null) return null;
		DeviceSpType po = create();
		EntityContext.copyProperties(po,pojo);
		po.clearModifies();
		return po;
	}

	/**
	 * 创建一个 DeviceSpType，等同于 new
	 * @return DeviceSpType 对象
	*/
	@Transient
	public static DeviceSpType create() {
		return new com.dt.platform.domain.eam.meta.DeviceSpTypeMeta.$$proxy$$();
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
			this.setNotes(DataParser.parse(String.class, map.get(DeviceSpTypeMeta.NOTES)));
			this.setHierarchy(DataParser.parse(String.class, map.get(DeviceSpTypeMeta.HIERARCHY)));
			this.setHierarchyName(DataParser.parse(String.class, map.get(DeviceSpTypeMeta.HIERARCHY_NAME)));
			this.setUpdateTime(DataParser.parse(Date.class, map.get(DeviceSpTypeMeta.UPDATE_TIME)));
			this.setCategoryCode(DataParser.parse(String.class, map.get(DeviceSpTypeMeta.CATEGORY_CODE)));
			this.setSort(DataParser.parse(Integer.class, map.get(DeviceSpTypeMeta.SORT)));
			this.setCategoryName(DataParser.parse(String.class, map.get(DeviceSpTypeMeta.CATEGORY_NAME)));
			this.setVersion(DataParser.parse(Integer.class, map.get(DeviceSpTypeMeta.VERSION)));
			this.setParentId(DataParser.parse(String.class, map.get(DeviceSpTypeMeta.PARENT_ID)));
			this.setCategoryFullname(DataParser.parse(String.class, map.get(DeviceSpTypeMeta.CATEGORY_FULLNAME)));
			this.setCreateBy(DataParser.parse(String.class, map.get(DeviceSpTypeMeta.CREATE_BY)));
			this.setDeleted(DataParser.parse(Integer.class, map.get(DeviceSpTypeMeta.DELETED)));
			this.setCreateTime(DataParser.parse(Date.class, map.get(DeviceSpTypeMeta.CREATE_TIME)));
			this.setUpdateBy(DataParser.parse(String.class, map.get(DeviceSpTypeMeta.UPDATE_BY)));
			this.setDeleteTime(DataParser.parse(Date.class, map.get(DeviceSpTypeMeta.DELETE_TIME)));
			this.setTenantId(DataParser.parse(String.class, map.get(DeviceSpTypeMeta.TENANT_ID)));
			this.setDeleteBy(DataParser.parse(String.class, map.get(DeviceSpTypeMeta.DELETE_BY)));
			this.setServiceLife(DataParser.parse(BigDecimal.class, map.get(DeviceSpTypeMeta.SERVICE_LIFE)));
			this.setId(DataParser.parse(String.class, map.get(DeviceSpTypeMeta.ID)));
			this.setStatus(DataParser.parse(String.class, map.get(DeviceSpTypeMeta.STATUS)));
			// others
			return true;
		} else {
			try {
				this.setNotes( (String)map.get(DeviceSpTypeMeta.NOTES));
				this.setHierarchy( (String)map.get(DeviceSpTypeMeta.HIERARCHY));
				this.setHierarchyName( (String)map.get(DeviceSpTypeMeta.HIERARCHY_NAME));
				this.setUpdateTime( (Date)map.get(DeviceSpTypeMeta.UPDATE_TIME));
				this.setCategoryCode( (String)map.get(DeviceSpTypeMeta.CATEGORY_CODE));
				this.setSort( (Integer)map.get(DeviceSpTypeMeta.SORT));
				this.setCategoryName( (String)map.get(DeviceSpTypeMeta.CATEGORY_NAME));
				this.setVersion( (Integer)map.get(DeviceSpTypeMeta.VERSION));
				this.setParentId( (String)map.get(DeviceSpTypeMeta.PARENT_ID));
				this.setCategoryFullname( (String)map.get(DeviceSpTypeMeta.CATEGORY_FULLNAME));
				this.setCreateBy( (String)map.get(DeviceSpTypeMeta.CREATE_BY));
				this.setDeleted( (Integer)map.get(DeviceSpTypeMeta.DELETED));
				this.setCreateTime( (Date)map.get(DeviceSpTypeMeta.CREATE_TIME));
				this.setUpdateBy( (String)map.get(DeviceSpTypeMeta.UPDATE_BY));
				this.setDeleteTime( (Date)map.get(DeviceSpTypeMeta.DELETE_TIME));
				this.setTenantId( (String)map.get(DeviceSpTypeMeta.TENANT_ID));
				this.setDeleteBy( (String)map.get(DeviceSpTypeMeta.DELETE_BY));
				this.setServiceLife( (BigDecimal)map.get(DeviceSpTypeMeta.SERVICE_LIFE));
				this.setId( (String)map.get(DeviceSpTypeMeta.ID));
				this.setStatus( (String)map.get(DeviceSpTypeMeta.STATUS));
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
			this.setNotes(DataParser.parse(String.class, r.getValue(DeviceSpTypeMeta.NOTES)));
			this.setHierarchy(DataParser.parse(String.class, r.getValue(DeviceSpTypeMeta.HIERARCHY)));
			this.setHierarchyName(DataParser.parse(String.class, r.getValue(DeviceSpTypeMeta.HIERARCHY_NAME)));
			this.setUpdateTime(DataParser.parse(Date.class, r.getValue(DeviceSpTypeMeta.UPDATE_TIME)));
			this.setCategoryCode(DataParser.parse(String.class, r.getValue(DeviceSpTypeMeta.CATEGORY_CODE)));
			this.setSort(DataParser.parse(Integer.class, r.getValue(DeviceSpTypeMeta.SORT)));
			this.setCategoryName(DataParser.parse(String.class, r.getValue(DeviceSpTypeMeta.CATEGORY_NAME)));
			this.setVersion(DataParser.parse(Integer.class, r.getValue(DeviceSpTypeMeta.VERSION)));
			this.setParentId(DataParser.parse(String.class, r.getValue(DeviceSpTypeMeta.PARENT_ID)));
			this.setCategoryFullname(DataParser.parse(String.class, r.getValue(DeviceSpTypeMeta.CATEGORY_FULLNAME)));
			this.setCreateBy(DataParser.parse(String.class, r.getValue(DeviceSpTypeMeta.CREATE_BY)));
			this.setDeleted(DataParser.parse(Integer.class, r.getValue(DeviceSpTypeMeta.DELETED)));
			this.setCreateTime(DataParser.parse(Date.class, r.getValue(DeviceSpTypeMeta.CREATE_TIME)));
			this.setUpdateBy(DataParser.parse(String.class, r.getValue(DeviceSpTypeMeta.UPDATE_BY)));
			this.setDeleteTime(DataParser.parse(Date.class, r.getValue(DeviceSpTypeMeta.DELETE_TIME)));
			this.setTenantId(DataParser.parse(String.class, r.getValue(DeviceSpTypeMeta.TENANT_ID)));
			this.setDeleteBy(DataParser.parse(String.class, r.getValue(DeviceSpTypeMeta.DELETE_BY)));
			this.setServiceLife(DataParser.parse(BigDecimal.class, r.getValue(DeviceSpTypeMeta.SERVICE_LIFE)));
			this.setId(DataParser.parse(String.class, r.getValue(DeviceSpTypeMeta.ID)));
			this.setStatus(DataParser.parse(String.class, r.getValue(DeviceSpTypeMeta.STATUS)));
			return true;
		} else {
			try {
				this.setNotes( (String)r.getValue(DeviceSpTypeMeta.NOTES));
				this.setHierarchy( (String)r.getValue(DeviceSpTypeMeta.HIERARCHY));
				this.setHierarchyName( (String)r.getValue(DeviceSpTypeMeta.HIERARCHY_NAME));
				this.setUpdateTime( (Date)r.getValue(DeviceSpTypeMeta.UPDATE_TIME));
				this.setCategoryCode( (String)r.getValue(DeviceSpTypeMeta.CATEGORY_CODE));
				this.setSort( (Integer)r.getValue(DeviceSpTypeMeta.SORT));
				this.setCategoryName( (String)r.getValue(DeviceSpTypeMeta.CATEGORY_NAME));
				this.setVersion( (Integer)r.getValue(DeviceSpTypeMeta.VERSION));
				this.setParentId( (String)r.getValue(DeviceSpTypeMeta.PARENT_ID));
				this.setCategoryFullname( (String)r.getValue(DeviceSpTypeMeta.CATEGORY_FULLNAME));
				this.setCreateBy( (String)r.getValue(DeviceSpTypeMeta.CREATE_BY));
				this.setDeleted( (Integer)r.getValue(DeviceSpTypeMeta.DELETED));
				this.setCreateTime( (Date)r.getValue(DeviceSpTypeMeta.CREATE_TIME));
				this.setUpdateBy( (String)r.getValue(DeviceSpTypeMeta.UPDATE_BY));
				this.setDeleteTime( (Date)r.getValue(DeviceSpTypeMeta.DELETE_TIME));
				this.setTenantId( (String)r.getValue(DeviceSpTypeMeta.TENANT_ID));
				this.setDeleteBy( (String)r.getValue(DeviceSpTypeMeta.DELETE_BY));
				this.setServiceLife( (BigDecimal)r.getValue(DeviceSpTypeMeta.SERVICE_LIFE));
				this.setId( (String)r.getValue(DeviceSpTypeMeta.ID));
				this.setStatus( (String)r.getValue(DeviceSpTypeMeta.STATUS));
				return true;
			} catch (Exception e) {
				return false;
			}
		}
	}
}