package com.dt.platform.domain.eam;

import com.github.foxnic.dao.entity.Entity;
import io.swagger.annotations.ApiModel;
import javax.persistence.Table;
import com.github.foxnic.sql.meta.DBTable;
import com.dt.platform.constants.db.EAMTables.EAM_CHECK_GROUP_ITEM;
import javax.persistence.Id;
import io.swagger.annotations.ApiModelProperty;
import java.util.Date;
import javax.persistence.Transient;
import com.github.foxnic.api.swagger.EnumFor;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.github.foxnic.commons.lang.DataParser;
import java.util.Map;
import com.github.foxnic.dao.entity.EntityContext;
import com.dt.platform.domain.eam.meta.CheckGroupItemMeta;
import com.github.foxnic.sql.data.ExprRcd;



/**
 * 检查项内容
 * <p>检查项内容 , 数据表 eam_check_group_item 的PO类型</p>
 * @author 金杰 , maillank@qq.com
 * @since 2023-07-05 09:44:04
 * @sign 8DEDC3F05D696F875DC0E04B7FCFAC1A
 * 此文件由工具自动生成，请勿修改。若表结构或配置发生变动，请使用工具重新生成。
*/

@Table(name = "eam_check_group_item")
@ApiModel(description = "检查项内容 ; 检查项内容 , 数据表 eam_check_group_item 的PO类型")
public class CheckGroupItem extends Entity {

	private static final long serialVersionUID = 1L;

	public static final DBTable TABLE =EAM_CHECK_GROUP_ITEM.$TABLE;
	
	/**
	 * 主键：主键
	*/
	@Id
	@ApiModelProperty(required = true,value="主键" , notes = "主键")
	private String id;
	
	/**
	 * 组：组
	*/
	@ApiModelProperty(required = false,value="组" , notes = "组")
	private String groupId;
	
	/**
	 * 检查项：检查项
	*/
	@ApiModelProperty(required = false,value="检查项" , notes = "检查项")
	private String itemId;
	
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
	public CheckGroupItem setId(String id) {
		this.id=id;
		return this;
	}
	
	/**
	 * 获得 组<br>
	 * 组
	 * @return 组
	*/
	public String getGroupId() {
		return groupId;
	}
	
	/**
	 * 设置 组
	 * @param groupId 组
	 * @return 当前对象
	*/
	public CheckGroupItem setGroupId(String groupId) {
		this.groupId=groupId;
		return this;
	}
	
	/**
	 * 获得 检查项<br>
	 * 检查项
	 * @return 检查项
	*/
	public String getItemId() {
		return itemId;
	}
	
	/**
	 * 设置 检查项
	 * @param itemId 检查项
	 * @return 当前对象
	*/
	public CheckGroupItem setItemId(String itemId) {
		this.itemId=itemId;
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
	public CheckGroupItem setCreateBy(String createBy) {
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
	public CheckGroupItem setCreateTime(Date createTime) {
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
	public CheckGroupItem setUpdateBy(String updateBy) {
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
	public CheckGroupItem setUpdateTime(Date updateTime) {
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
	public CheckGroupItem setDeleted(Integer deleted) {
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
	public CheckGroupItem setDeleted(Boolean deletedBool) {
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
	public CheckGroupItem setDeleteBy(String deleteBy) {
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
	public CheckGroupItem setDeleteTime(Date deleteTime) {
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
	public CheckGroupItem setVersion(Integer version) {
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
	public CheckGroupItem setTenantId(String tenantId) {
		this.tenantId=tenantId;
		return this;
	}

	/**
	 * 将自己转换成指定类型的PO
	 * @param poType  PO类型
	 * @return CheckGroupItem , 转换好的 CheckGroupItem 对象
	*/
	@Transient
	public <T extends Entity> T toPO(Class<T> poType) {
		return EntityContext.create(poType, this);
	}

	/**
	 * 将自己转换成任意指定类型
	 * @param pojoType  Pojo类型
	 * @return CheckGroupItem , 转换好的 PoJo 对象
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
	public CheckGroupItem clone() {
		return duplicate(true);
	}

	/**
	 * 复制当前对象
	 * @param all 是否复制全部属性，当 false 时，仅复制来自数据表的属性
	*/
	@Transient
	public CheckGroupItem duplicate(boolean all) {
		com.dt.platform.domain.eam.meta.CheckGroupItemMeta.$$proxy$$ inst = new com.dt.platform.domain.eam.meta.CheckGroupItemMeta.$$proxy$$();
		inst.setItemId(this.getItemId());
		inst.setCreateBy(this.getCreateBy());
		inst.setDeleted(this.getDeleted());
		inst.setCreateTime(this.getCreateTime());
		inst.setUpdateBy(this.getUpdateBy());
		inst.setDeleteTime(this.getDeleteTime());
		inst.setGroupId(this.getGroupId());
		inst.setTenantId(this.getTenantId());
		inst.setDeleteBy(this.getDeleteBy());
		inst.setUpdateTime(this.getUpdateTime());
		inst.setId(this.getId());
		inst.setVersion(this.getVersion());
		inst.clearModifies();
		return inst;
	}

	/**
	 * 克隆当前对象
	*/
	@Transient
	public CheckGroupItem clone(boolean deep) {
		return EntityContext.clone(CheckGroupItem.class,this,deep);
	}

	/**
	 * 将 Map 转换成 CheckGroupItem
	 * @param checkGroupItemMap 包含实体信息的 Map 对象
	 * @return CheckGroupItem , 转换好的的 CheckGroupItem 对象
	*/
	@Transient
	public static CheckGroupItem createFrom(Map<String,Object> checkGroupItemMap) {
		if(checkGroupItemMap==null) return null;
		CheckGroupItem po = create();
		EntityContext.copyProperties(po,checkGroupItemMap);
		po.clearModifies();
		return po;
	}

	/**
	 * 将 Pojo 转换成 CheckGroupItem
	 * @param pojo 包含实体信息的 Pojo 对象
	 * @return CheckGroupItem , 转换好的的 CheckGroupItem 对象
	*/
	@Transient
	public static CheckGroupItem createFrom(Object pojo) {
		if(pojo==null) return null;
		CheckGroupItem po = create();
		EntityContext.copyProperties(po,pojo);
		po.clearModifies();
		return po;
	}

	/**
	 * 创建一个 CheckGroupItem，等同于 new
	 * @return CheckGroupItem 对象
	*/
	@Transient
	public static CheckGroupItem create() {
		return new com.dt.platform.domain.eam.meta.CheckGroupItemMeta.$$proxy$$();
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
			this.setItemId(DataParser.parse(String.class, map.get(CheckGroupItemMeta.ITEM_ID)));
			this.setCreateBy(DataParser.parse(String.class, map.get(CheckGroupItemMeta.CREATE_BY)));
			this.setDeleted(DataParser.parse(Integer.class, map.get(CheckGroupItemMeta.DELETED)));
			this.setCreateTime(DataParser.parse(Date.class, map.get(CheckGroupItemMeta.CREATE_TIME)));
			this.setUpdateBy(DataParser.parse(String.class, map.get(CheckGroupItemMeta.UPDATE_BY)));
			this.setDeleteTime(DataParser.parse(Date.class, map.get(CheckGroupItemMeta.DELETE_TIME)));
			this.setGroupId(DataParser.parse(String.class, map.get(CheckGroupItemMeta.GROUP_ID)));
			this.setTenantId(DataParser.parse(String.class, map.get(CheckGroupItemMeta.TENANT_ID)));
			this.setDeleteBy(DataParser.parse(String.class, map.get(CheckGroupItemMeta.DELETE_BY)));
			this.setUpdateTime(DataParser.parse(Date.class, map.get(CheckGroupItemMeta.UPDATE_TIME)));
			this.setId(DataParser.parse(String.class, map.get(CheckGroupItemMeta.ID)));
			this.setVersion(DataParser.parse(Integer.class, map.get(CheckGroupItemMeta.VERSION)));
			// others
			return true;
		} else {
			try {
				this.setItemId( (String)map.get(CheckGroupItemMeta.ITEM_ID));
				this.setCreateBy( (String)map.get(CheckGroupItemMeta.CREATE_BY));
				this.setDeleted( (Integer)map.get(CheckGroupItemMeta.DELETED));
				this.setCreateTime( (Date)map.get(CheckGroupItemMeta.CREATE_TIME));
				this.setUpdateBy( (String)map.get(CheckGroupItemMeta.UPDATE_BY));
				this.setDeleteTime( (Date)map.get(CheckGroupItemMeta.DELETE_TIME));
				this.setGroupId( (String)map.get(CheckGroupItemMeta.GROUP_ID));
				this.setTenantId( (String)map.get(CheckGroupItemMeta.TENANT_ID));
				this.setDeleteBy( (String)map.get(CheckGroupItemMeta.DELETE_BY));
				this.setUpdateTime( (Date)map.get(CheckGroupItemMeta.UPDATE_TIME));
				this.setId( (String)map.get(CheckGroupItemMeta.ID));
				this.setVersion( (Integer)map.get(CheckGroupItemMeta.VERSION));
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
			this.setItemId(DataParser.parse(String.class, r.getValue(CheckGroupItemMeta.ITEM_ID)));
			this.setCreateBy(DataParser.parse(String.class, r.getValue(CheckGroupItemMeta.CREATE_BY)));
			this.setDeleted(DataParser.parse(Integer.class, r.getValue(CheckGroupItemMeta.DELETED)));
			this.setCreateTime(DataParser.parse(Date.class, r.getValue(CheckGroupItemMeta.CREATE_TIME)));
			this.setUpdateBy(DataParser.parse(String.class, r.getValue(CheckGroupItemMeta.UPDATE_BY)));
			this.setDeleteTime(DataParser.parse(Date.class, r.getValue(CheckGroupItemMeta.DELETE_TIME)));
			this.setGroupId(DataParser.parse(String.class, r.getValue(CheckGroupItemMeta.GROUP_ID)));
			this.setTenantId(DataParser.parse(String.class, r.getValue(CheckGroupItemMeta.TENANT_ID)));
			this.setDeleteBy(DataParser.parse(String.class, r.getValue(CheckGroupItemMeta.DELETE_BY)));
			this.setUpdateTime(DataParser.parse(Date.class, r.getValue(CheckGroupItemMeta.UPDATE_TIME)));
			this.setId(DataParser.parse(String.class, r.getValue(CheckGroupItemMeta.ID)));
			this.setVersion(DataParser.parse(Integer.class, r.getValue(CheckGroupItemMeta.VERSION)));
			return true;
		} else {
			try {
				this.setItemId( (String)r.getValue(CheckGroupItemMeta.ITEM_ID));
				this.setCreateBy( (String)r.getValue(CheckGroupItemMeta.CREATE_BY));
				this.setDeleted( (Integer)r.getValue(CheckGroupItemMeta.DELETED));
				this.setCreateTime( (Date)r.getValue(CheckGroupItemMeta.CREATE_TIME));
				this.setUpdateBy( (String)r.getValue(CheckGroupItemMeta.UPDATE_BY));
				this.setDeleteTime( (Date)r.getValue(CheckGroupItemMeta.DELETE_TIME));
				this.setGroupId( (String)r.getValue(CheckGroupItemMeta.GROUP_ID));
				this.setTenantId( (String)r.getValue(CheckGroupItemMeta.TENANT_ID));
				this.setDeleteBy( (String)r.getValue(CheckGroupItemMeta.DELETE_BY));
				this.setUpdateTime( (Date)r.getValue(CheckGroupItemMeta.UPDATE_TIME));
				this.setId( (String)r.getValue(CheckGroupItemMeta.ID));
				this.setVersion( (Integer)r.getValue(CheckGroupItemMeta.VERSION));
				return true;
			} catch (Exception e) {
				return false;
			}
		}
	}
}