package com.dt.platform.domain.oa;

import com.github.foxnic.dao.entity.Entity;
import io.swagger.annotations.ApiModel;
import javax.persistence.Table;
import com.github.foxnic.sql.meta.DBTable;
import com.dt.platform.constants.db.OaTables.OA_NETDISK_FOLDER;
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
import com.dt.platform.domain.oa.meta.NetdiskFolderMeta;
import com.github.foxnic.sql.data.ExprRcd;



/**
 * 文件夹
 * <p>文件夹 , 数据表 oa_netdisk_folder 的PO类型</p>
 * @author 金杰 , maillank@qq.com
 * @since 2023-09-20 16:39:12
 * @sign 4667CCB6106EB2C81A0DFCC05F63B98B
 * 此文件由工具自动生成，请勿修改。若表结构或配置发生变动，请使用工具重新生成。
*/

@Table(name = "oa_netdisk_folder")
@ApiModel(description = "文件夹 ; 文件夹 , 数据表 oa_netdisk_folder 的PO类型")
public class NetdiskFolder extends Entity {

	private static final long serialVersionUID = 1L;

	public static final DBTable TABLE =OA_NETDISK_FOLDER.$TABLE;
	
	/**
	 * 主键：主键
	*/
	@Id
	@ApiModelProperty(required = true,value="主键" , notes = "主键" , example = "756915345796628480")
	private String id;
	
	/**
	 * 名称：名称
	*/
	@ApiModelProperty(required = false,value="名称" , notes = "名称" , example = "121212")
	private String name;
	
	/**
	 * 用户：用户
	*/
	@ApiModelProperty(required = false,value="用户" , notes = "用户" , example = "E001")
	private String userId;
	
	/**
	 * 是否收藏：是否收藏
	*/
	@ApiModelProperty(required = false,value="是否收藏" , notes = "是否收藏" , example = "N")
	private String isFavourite;
	
	/**
	 * 回收站：回收站
	*/
	@ApiModelProperty(required = false,value="回收站" , notes = "回收站" , example = "N")
	private String inRecycle;
	
	/**
	 * 父级：父级
	*/
	@ApiModelProperty(required = false,value="父级" , notes = "父级")
	private String parentId;
	
	/**
	 * 文件路径：文件路径
	*/
	@ApiModelProperty(required = false,value="文件路径" , notes = "文件路径" , example = "121212")
	private String hierarchy;
	
	/**
	 * 路径全名：路径全名
	*/
	@ApiModelProperty(required = false,value="路径全名" , notes = "路径全名")
	private String hierarchyName;
	
	/**
	 * 版本：版本
	*/
	@ApiModelProperty(required = true,value="版本" , notes = "版本" , example = "1")
	private Integer version;
	
	/**
	 * 创建人ID：创建人ID
	*/
	@ApiModelProperty(required = false,value="创建人ID" , notes = "创建人ID" , example = "110588348101165911")
	private String createBy;
	
	/**
	 * 创建时间：创建时间
	*/
	@ApiModelProperty(required = false,value="创建时间" , notes = "创建时间" , example = "2023-09-20 04:31:21")
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
	 * 租户：租户
	*/
	@ApiModelProperty(required = false,value="租户" , notes = "租户" , example = "T001")
	private String tenantId;
	
	/**
	 * ownerUser：ownerUser
	*/
	@ApiModelProperty(required = false,value="ownerUser" , notes = "ownerUser")
	private Employee ownerUser;
	
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
	public NetdiskFolder setId(String id) {
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
	public NetdiskFolder setName(String name) {
		this.name=name;
		return this;
	}
	
	/**
	 * 获得 用户<br>
	 * 用户
	 * @return 用户
	*/
	public String getUserId() {
		return userId;
	}
	
	/**
	 * 设置 用户
	 * @param userId 用户
	 * @return 当前对象
	*/
	public NetdiskFolder setUserId(String userId) {
		this.userId=userId;
		return this;
	}
	
	/**
	 * 获得 是否收藏<br>
	 * 是否收藏
	 * @return 是否收藏
	*/
	public String getIsFavourite() {
		return isFavourite;
	}
	
	/**
	 * 设置 是否收藏
	 * @param isFavourite 是否收藏
	 * @return 当前对象
	*/
	public NetdiskFolder setIsFavourite(String isFavourite) {
		this.isFavourite=isFavourite;
		return this;
	}
	
	/**
	 * 获得 回收站<br>
	 * 回收站
	 * @return 回收站
	*/
	public String getInRecycle() {
		return inRecycle;
	}
	
	/**
	 * 设置 回收站
	 * @param inRecycle 回收站
	 * @return 当前对象
	*/
	public NetdiskFolder setInRecycle(String inRecycle) {
		this.inRecycle=inRecycle;
		return this;
	}
	
	/**
	 * 获得 父级<br>
	 * 父级
	 * @return 父级
	*/
	public String getParentId() {
		return parentId;
	}
	
	/**
	 * 设置 父级
	 * @param parentId 父级
	 * @return 当前对象
	*/
	public NetdiskFolder setParentId(String parentId) {
		this.parentId=parentId;
		return this;
	}
	
	/**
	 * 获得 文件路径<br>
	 * 文件路径
	 * @return 文件路径
	*/
	public String getHierarchy() {
		return hierarchy;
	}
	
	/**
	 * 设置 文件路径
	 * @param hierarchy 文件路径
	 * @return 当前对象
	*/
	public NetdiskFolder setHierarchy(String hierarchy) {
		this.hierarchy=hierarchy;
		return this;
	}
	
	/**
	 * 获得 路径全名<br>
	 * 路径全名
	 * @return 路径全名
	*/
	public String getHierarchyName() {
		return hierarchyName;
	}
	
	/**
	 * 设置 路径全名
	 * @param hierarchyName 路径全名
	 * @return 当前对象
	*/
	public NetdiskFolder setHierarchyName(String hierarchyName) {
		this.hierarchyName=hierarchyName;
		return this;
	}
	
	/**
	 * 获得 版本<br>
	 * 版本
	 * @return 版本
	*/
	public Integer getVersion() {
		return version;
	}
	
	/**
	 * 设置 版本
	 * @param version 版本
	 * @return 当前对象
	*/
	public NetdiskFolder setVersion(Integer version) {
		this.version=version;
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
	public NetdiskFolder setCreateBy(String createBy) {
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
	public NetdiskFolder setCreateTime(Date createTime) {
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
	public NetdiskFolder setUpdateBy(String updateBy) {
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
	public NetdiskFolder setUpdateTime(Date updateTime) {
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
	public NetdiskFolder setDeleted(Integer deleted) {
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
	public NetdiskFolder setDeleted(Boolean deletedBool) {
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
	public NetdiskFolder setDeleteBy(String deleteBy) {
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
	public NetdiskFolder setDeleteTime(Date deleteTime) {
		this.deleteTime=deleteTime;
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
	public NetdiskFolder setTenantId(String tenantId) {
		this.tenantId=tenantId;
		return this;
	}
	
	/**
	 * 获得 ownerUser<br>
	 * ownerUser
	 * @return ownerUser
	*/
	public Employee getOwnerUser() {
		return ownerUser;
	}
	
	/**
	 * 设置 ownerUser
	 * @param ownerUser ownerUser
	 * @return 当前对象
	*/
	public NetdiskFolder setOwnerUser(Employee ownerUser) {
		this.ownerUser=ownerUser;
		return this;
	}

	/**
	 * 将自己转换成指定类型的PO
	 * @param poType  PO类型
	 * @return NetdiskFolder , 转换好的 NetdiskFolder 对象
	*/
	@Transient
	public <T extends Entity> T toPO(Class<T> poType) {
		return EntityContext.create(poType, this);
	}

	/**
	 * 将自己转换成任意指定类型
	 * @param pojoType  Pojo类型
	 * @return NetdiskFolder , 转换好的 PoJo 对象
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
	public NetdiskFolder clone() {
		return duplicate(true);
	}

	/**
	 * 复制当前对象
	 * @param all 是否复制全部属性，当 false 时，仅复制来自数据表的属性
	*/
	@Transient
	public NetdiskFolder duplicate(boolean all) {
		com.dt.platform.domain.oa.meta.NetdiskFolderMeta.$$proxy$$ inst = new com.dt.platform.domain.oa.meta.NetdiskFolderMeta.$$proxy$$();
		inst.setHierarchy(this.getHierarchy());
		inst.setHierarchyName(this.getHierarchyName());
		inst.setUpdateTime(this.getUpdateTime());
		inst.setUserId(this.getUserId());
		inst.setVersion(this.getVersion());
		inst.setParentId(this.getParentId());
		inst.setCreateBy(this.getCreateBy());
		inst.setDeleted(this.getDeleted());
		inst.setCreateTime(this.getCreateTime());
		inst.setUpdateBy(this.getUpdateBy());
		inst.setDeleteTime(this.getDeleteTime());
		inst.setName(this.getName());
		inst.setInRecycle(this.getInRecycle());
		inst.setTenantId(this.getTenantId());
		inst.setDeleteBy(this.getDeleteBy());
		inst.setId(this.getId());
		inst.setIsFavourite(this.getIsFavourite());
		if(all) {
			inst.setOwnerUser(this.getOwnerUser());
		}
		inst.clearModifies();
		return inst;
	}

	/**
	 * 克隆当前对象
	*/
	@Transient
	public NetdiskFolder clone(boolean deep) {
		return EntityContext.clone(NetdiskFolder.class,this,deep);
	}

	/**
	 * 将 Map 转换成 NetdiskFolder
	 * @param netdiskFolderMap 包含实体信息的 Map 对象
	 * @return NetdiskFolder , 转换好的的 NetdiskFolder 对象
	*/
	@Transient
	public static NetdiskFolder createFrom(Map<String,Object> netdiskFolderMap) {
		if(netdiskFolderMap==null) return null;
		NetdiskFolder po = create();
		EntityContext.copyProperties(po,netdiskFolderMap);
		po.clearModifies();
		return po;
	}

	/**
	 * 将 Pojo 转换成 NetdiskFolder
	 * @param pojo 包含实体信息的 Pojo 对象
	 * @return NetdiskFolder , 转换好的的 NetdiskFolder 对象
	*/
	@Transient
	public static NetdiskFolder createFrom(Object pojo) {
		if(pojo==null) return null;
		NetdiskFolder po = create();
		EntityContext.copyProperties(po,pojo);
		po.clearModifies();
		return po;
	}

	/**
	 * 创建一个 NetdiskFolder，等同于 new
	 * @return NetdiskFolder 对象
	*/
	@Transient
	public static NetdiskFolder create() {
		return new com.dt.platform.domain.oa.meta.NetdiskFolderMeta.$$proxy$$();
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
			this.setHierarchy(DataParser.parse(String.class, map.get(NetdiskFolderMeta.HIERARCHY)));
			this.setHierarchyName(DataParser.parse(String.class, map.get(NetdiskFolderMeta.HIERARCHY_NAME)));
			this.setUpdateTime(DataParser.parse(Date.class, map.get(NetdiskFolderMeta.UPDATE_TIME)));
			this.setUserId(DataParser.parse(String.class, map.get(NetdiskFolderMeta.USER_ID)));
			this.setVersion(DataParser.parse(Integer.class, map.get(NetdiskFolderMeta.VERSION)));
			this.setParentId(DataParser.parse(String.class, map.get(NetdiskFolderMeta.PARENT_ID)));
			this.setCreateBy(DataParser.parse(String.class, map.get(NetdiskFolderMeta.CREATE_BY)));
			this.setDeleted(DataParser.parse(Integer.class, map.get(NetdiskFolderMeta.DELETED)));
			this.setCreateTime(DataParser.parse(Date.class, map.get(NetdiskFolderMeta.CREATE_TIME)));
			this.setUpdateBy(DataParser.parse(String.class, map.get(NetdiskFolderMeta.UPDATE_BY)));
			this.setDeleteTime(DataParser.parse(Date.class, map.get(NetdiskFolderMeta.DELETE_TIME)));
			this.setName(DataParser.parse(String.class, map.get(NetdiskFolderMeta.NAME)));
			this.setInRecycle(DataParser.parse(String.class, map.get(NetdiskFolderMeta.IN_RECYCLE)));
			this.setTenantId(DataParser.parse(String.class, map.get(NetdiskFolderMeta.TENANT_ID)));
			this.setDeleteBy(DataParser.parse(String.class, map.get(NetdiskFolderMeta.DELETE_BY)));
			this.setId(DataParser.parse(String.class, map.get(NetdiskFolderMeta.ID)));
			this.setIsFavourite(DataParser.parse(String.class, map.get(NetdiskFolderMeta.IS_FAVOURITE)));
			// others
			this.setOwnerUser(DataParser.parse(Employee.class, map.get(NetdiskFolderMeta.OWNER_USER)));
			return true;
		} else {
			try {
				this.setHierarchy( (String)map.get(NetdiskFolderMeta.HIERARCHY));
				this.setHierarchyName( (String)map.get(NetdiskFolderMeta.HIERARCHY_NAME));
				this.setUpdateTime( (Date)map.get(NetdiskFolderMeta.UPDATE_TIME));
				this.setUserId( (String)map.get(NetdiskFolderMeta.USER_ID));
				this.setVersion( (Integer)map.get(NetdiskFolderMeta.VERSION));
				this.setParentId( (String)map.get(NetdiskFolderMeta.PARENT_ID));
				this.setCreateBy( (String)map.get(NetdiskFolderMeta.CREATE_BY));
				this.setDeleted( (Integer)map.get(NetdiskFolderMeta.DELETED));
				this.setCreateTime( (Date)map.get(NetdiskFolderMeta.CREATE_TIME));
				this.setUpdateBy( (String)map.get(NetdiskFolderMeta.UPDATE_BY));
				this.setDeleteTime( (Date)map.get(NetdiskFolderMeta.DELETE_TIME));
				this.setName( (String)map.get(NetdiskFolderMeta.NAME));
				this.setInRecycle( (String)map.get(NetdiskFolderMeta.IN_RECYCLE));
				this.setTenantId( (String)map.get(NetdiskFolderMeta.TENANT_ID));
				this.setDeleteBy( (String)map.get(NetdiskFolderMeta.DELETE_BY));
				this.setId( (String)map.get(NetdiskFolderMeta.ID));
				this.setIsFavourite( (String)map.get(NetdiskFolderMeta.IS_FAVOURITE));
				// others
				this.setOwnerUser( (Employee)map.get(NetdiskFolderMeta.OWNER_USER));
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
			this.setHierarchy(DataParser.parse(String.class, r.getValue(NetdiskFolderMeta.HIERARCHY)));
			this.setHierarchyName(DataParser.parse(String.class, r.getValue(NetdiskFolderMeta.HIERARCHY_NAME)));
			this.setUpdateTime(DataParser.parse(Date.class, r.getValue(NetdiskFolderMeta.UPDATE_TIME)));
			this.setUserId(DataParser.parse(String.class, r.getValue(NetdiskFolderMeta.USER_ID)));
			this.setVersion(DataParser.parse(Integer.class, r.getValue(NetdiskFolderMeta.VERSION)));
			this.setParentId(DataParser.parse(String.class, r.getValue(NetdiskFolderMeta.PARENT_ID)));
			this.setCreateBy(DataParser.parse(String.class, r.getValue(NetdiskFolderMeta.CREATE_BY)));
			this.setDeleted(DataParser.parse(Integer.class, r.getValue(NetdiskFolderMeta.DELETED)));
			this.setCreateTime(DataParser.parse(Date.class, r.getValue(NetdiskFolderMeta.CREATE_TIME)));
			this.setUpdateBy(DataParser.parse(String.class, r.getValue(NetdiskFolderMeta.UPDATE_BY)));
			this.setDeleteTime(DataParser.parse(Date.class, r.getValue(NetdiskFolderMeta.DELETE_TIME)));
			this.setName(DataParser.parse(String.class, r.getValue(NetdiskFolderMeta.NAME)));
			this.setInRecycle(DataParser.parse(String.class, r.getValue(NetdiskFolderMeta.IN_RECYCLE)));
			this.setTenantId(DataParser.parse(String.class, r.getValue(NetdiskFolderMeta.TENANT_ID)));
			this.setDeleteBy(DataParser.parse(String.class, r.getValue(NetdiskFolderMeta.DELETE_BY)));
			this.setId(DataParser.parse(String.class, r.getValue(NetdiskFolderMeta.ID)));
			this.setIsFavourite(DataParser.parse(String.class, r.getValue(NetdiskFolderMeta.IS_FAVOURITE)));
			return true;
		} else {
			try {
				this.setHierarchy( (String)r.getValue(NetdiskFolderMeta.HIERARCHY));
				this.setHierarchyName( (String)r.getValue(NetdiskFolderMeta.HIERARCHY_NAME));
				this.setUpdateTime( (Date)r.getValue(NetdiskFolderMeta.UPDATE_TIME));
				this.setUserId( (String)r.getValue(NetdiskFolderMeta.USER_ID));
				this.setVersion( (Integer)r.getValue(NetdiskFolderMeta.VERSION));
				this.setParentId( (String)r.getValue(NetdiskFolderMeta.PARENT_ID));
				this.setCreateBy( (String)r.getValue(NetdiskFolderMeta.CREATE_BY));
				this.setDeleted( (Integer)r.getValue(NetdiskFolderMeta.DELETED));
				this.setCreateTime( (Date)r.getValue(NetdiskFolderMeta.CREATE_TIME));
				this.setUpdateBy( (String)r.getValue(NetdiskFolderMeta.UPDATE_BY));
				this.setDeleteTime( (Date)r.getValue(NetdiskFolderMeta.DELETE_TIME));
				this.setName( (String)r.getValue(NetdiskFolderMeta.NAME));
				this.setInRecycle( (String)r.getValue(NetdiskFolderMeta.IN_RECYCLE));
				this.setTenantId( (String)r.getValue(NetdiskFolderMeta.TENANT_ID));
				this.setDeleteBy( (String)r.getValue(NetdiskFolderMeta.DELETE_BY));
				this.setId( (String)r.getValue(NetdiskFolderMeta.ID));
				this.setIsFavourite( (String)r.getValue(NetdiskFolderMeta.IS_FAVOURITE));
				return true;
			} catch (Exception e) {
				return false;
			}
		}
	}
}