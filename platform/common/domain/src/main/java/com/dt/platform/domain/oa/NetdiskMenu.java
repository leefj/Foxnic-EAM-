package com.dt.platform.domain.oa;

import com.github.foxnic.dao.entity.Entity;
import io.swagger.annotations.ApiModel;
import javax.persistence.Table;
import com.github.foxnic.sql.meta.DBTable;
import com.dt.platform.constants.db.OaTables.OA_NETDISK_MENU;
import javax.persistence.Id;
import io.swagger.annotations.ApiModelProperty;
import java.util.Date;
import javax.persistence.Transient;
import com.github.foxnic.api.swagger.EnumFor;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.github.foxnic.commons.lang.DataParser;
import java.util.Map;
import com.github.foxnic.dao.entity.EntityContext;
import com.dt.platform.domain.oa.meta.NetdiskMenuMeta;
import com.github.foxnic.sql.data.ExprRcd;



/**
 * 文件菜单
 * <p>文件菜单 , 数据表 oa_netdisk_menu 的PO类型</p>
 * @author 金杰 , maillank@qq.com
 * @since 2023-09-18 14:20:12
 * @sign 056DFD88C97765EEE666683E3C546D05
 * 此文件由工具自动生成，请勿修改。若表结构或配置发生变动，请使用工具重新生成。
*/

@Table(name = "oa_netdisk_menu")
@ApiModel(description = "文件菜单 ; 文件菜单 , 数据表 oa_netdisk_menu 的PO类型")
public class NetdiskMenu extends Entity {

	private static final long serialVersionUID = 1L;

	public static final DBTable TABLE =OA_NETDISK_MENU.$TABLE;
	
	/**
	 * 主键：主键
	*/
	@Id
	@ApiModelProperty(required = true,value="主键" , notes = "主键" , example = "1")
	private String id;
	
	/**
	 * 编码：编码
	*/
	@ApiModelProperty(required = false,value="编码" , notes = "编码" , example = "root")
	private String code;
	
	/**
	 * 名称：名称
	*/
	@ApiModelProperty(required = false,value="名称" , notes = "名称" , example = "位置")
	private String name;
	
	/**
	 * 图标：图标
	*/
	@ApiModelProperty(required = false,value="图标" , notes = "图标" , example = "icon_home")
	private String iconCode;
	
	/**
	 * 类型：类型
	*/
	@ApiModelProperty(required = false,value="类型" , notes = "类型" , example = "system")
	private String type;
	
	/**
	 * 是否显示：Y|N
	*/
	@ApiModelProperty(required = false,value="是否显示" , notes = "Y|N" , example = "show")
	private String showValue;
	
	/**
	 * 排序：排序
	*/
	@ApiModelProperty(required = false,value="排序" , notes = "排序" , example = "1")
	private Integer sortValue;
	
	/**
	 * 上一级：上一级
	*/
	@ApiModelProperty(required = false,value="上一级" , notes = "上一级" , example = "0")
	private String parentId;
	
	/**
	 * 版本：版本
	*/
	@ApiModelProperty(required = true,value="版本" , notes = "版本" , example = "7")
	private Integer version;
	
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
	@ApiModelProperty(required = false,value="修改人ID" , notes = "修改人ID" , example = "110588348101165911")
	private String updateBy;
	
	/**
	 * 修改时间：修改时间
	*/
	@ApiModelProperty(required = false,value="修改时间" , notes = "修改时间" , example = "2023-09-18 09:51:03")
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
	public NetdiskMenu setId(String id) {
		this.id=id;
		return this;
	}
	
	/**
	 * 获得 编码<br>
	 * 编码
	 * @return 编码
	*/
	public String getCode() {
		return code;
	}
	
	/**
	 * 设置 编码
	 * @param code 编码
	 * @return 当前对象
	*/
	public NetdiskMenu setCode(String code) {
		this.code=code;
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
	public NetdiskMenu setName(String name) {
		this.name=name;
		return this;
	}
	
	/**
	 * 获得 图标<br>
	 * 图标
	 * @return 图标
	*/
	public String getIconCode() {
		return iconCode;
	}
	
	/**
	 * 设置 图标
	 * @param iconCode 图标
	 * @return 当前对象
	*/
	public NetdiskMenu setIconCode(String iconCode) {
		this.iconCode=iconCode;
		return this;
	}
	
	/**
	 * 获得 类型<br>
	 * 类型
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
	public NetdiskMenu setType(String type) {
		this.type=type;
		return this;
	}
	
	/**
	 * 获得 是否显示<br>
	 * Y|N
	 * @return 是否显示
	*/
	public String getShowValue() {
		return showValue;
	}
	
	/**
	 * 设置 是否显示
	 * @param showValue 是否显示
	 * @return 当前对象
	*/
	public NetdiskMenu setShowValue(String showValue) {
		this.showValue=showValue;
		return this;
	}
	
	/**
	 * 获得 排序<br>
	 * 排序
	 * @return 排序
	*/
	public Integer getSortValue() {
		return sortValue;
	}
	
	/**
	 * 设置 排序
	 * @param sortValue 排序
	 * @return 当前对象
	*/
	public NetdiskMenu setSortValue(Integer sortValue) {
		this.sortValue=sortValue;
		return this;
	}
	
	/**
	 * 获得 上一级<br>
	 * 上一级
	 * @return 上一级
	*/
	public String getParentId() {
		return parentId;
	}
	
	/**
	 * 设置 上一级
	 * @param parentId 上一级
	 * @return 当前对象
	*/
	public NetdiskMenu setParentId(String parentId) {
		this.parentId=parentId;
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
	public NetdiskMenu setVersion(Integer version) {
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
	public NetdiskMenu setCreateBy(String createBy) {
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
	public NetdiskMenu setCreateTime(Date createTime) {
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
	public NetdiskMenu setUpdateBy(String updateBy) {
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
	public NetdiskMenu setUpdateTime(Date updateTime) {
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
	public NetdiskMenu setDeleted(Integer deleted) {
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
	public NetdiskMenu setDeleted(Boolean deletedBool) {
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
	public NetdiskMenu setDeleteBy(String deleteBy) {
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
	public NetdiskMenu setDeleteTime(Date deleteTime) {
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
	public NetdiskMenu setTenantId(String tenantId) {
		this.tenantId=tenantId;
		return this;
	}

	/**
	 * 将自己转换成指定类型的PO
	 * @param poType  PO类型
	 * @return NetdiskMenu , 转换好的 NetdiskMenu 对象
	*/
	@Transient
	public <T extends Entity> T toPO(Class<T> poType) {
		return EntityContext.create(poType, this);
	}

	/**
	 * 将自己转换成任意指定类型
	 * @param pojoType  Pojo类型
	 * @return NetdiskMenu , 转换好的 PoJo 对象
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
	public NetdiskMenu clone() {
		return duplicate(true);
	}

	/**
	 * 复制当前对象
	 * @param all 是否复制全部属性，当 false 时，仅复制来自数据表的属性
	*/
	@Transient
	public NetdiskMenu duplicate(boolean all) {
		com.dt.platform.domain.oa.meta.NetdiskMenuMeta.$$proxy$$ inst = new com.dt.platform.domain.oa.meta.NetdiskMenuMeta.$$proxy$$();
		inst.setCode(this.getCode());
		inst.setUpdateTime(this.getUpdateTime());
		inst.setType(this.getType());
		inst.setVersion(this.getVersion());
		inst.setParentId(this.getParentId());
		inst.setSortValue(this.getSortValue());
		inst.setShowValue(this.getShowValue());
		inst.setCreateBy(this.getCreateBy());
		inst.setDeleted(this.getDeleted());
		inst.setCreateTime(this.getCreateTime());
		inst.setUpdateBy(this.getUpdateBy());
		inst.setDeleteTime(this.getDeleteTime());
		inst.setName(this.getName());
		inst.setTenantId(this.getTenantId());
		inst.setDeleteBy(this.getDeleteBy());
		inst.setIconCode(this.getIconCode());
		inst.setId(this.getId());
		inst.clearModifies();
		return inst;
	}

	/**
	 * 克隆当前对象
	*/
	@Transient
	public NetdiskMenu clone(boolean deep) {
		return EntityContext.clone(NetdiskMenu.class,this,deep);
	}

	/**
	 * 将 Map 转换成 NetdiskMenu
	 * @param netdiskMenuMap 包含实体信息的 Map 对象
	 * @return NetdiskMenu , 转换好的的 NetdiskMenu 对象
	*/
	@Transient
	public static NetdiskMenu createFrom(Map<String,Object> netdiskMenuMap) {
		if(netdiskMenuMap==null) return null;
		NetdiskMenu po = create();
		EntityContext.copyProperties(po,netdiskMenuMap);
		po.clearModifies();
		return po;
	}

	/**
	 * 将 Pojo 转换成 NetdiskMenu
	 * @param pojo 包含实体信息的 Pojo 对象
	 * @return NetdiskMenu , 转换好的的 NetdiskMenu 对象
	*/
	@Transient
	public static NetdiskMenu createFrom(Object pojo) {
		if(pojo==null) return null;
		NetdiskMenu po = create();
		EntityContext.copyProperties(po,pojo);
		po.clearModifies();
		return po;
	}

	/**
	 * 创建一个 NetdiskMenu，等同于 new
	 * @return NetdiskMenu 对象
	*/
	@Transient
	public static NetdiskMenu create() {
		return new com.dt.platform.domain.oa.meta.NetdiskMenuMeta.$$proxy$$();
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
			this.setCode(DataParser.parse(String.class, map.get(NetdiskMenuMeta.CODE)));
			this.setUpdateTime(DataParser.parse(Date.class, map.get(NetdiskMenuMeta.UPDATE_TIME)));
			this.setType(DataParser.parse(String.class, map.get(NetdiskMenuMeta.TYPE)));
			this.setVersion(DataParser.parse(Integer.class, map.get(NetdiskMenuMeta.VERSION)));
			this.setParentId(DataParser.parse(String.class, map.get(NetdiskMenuMeta.PARENT_ID)));
			this.setSortValue(DataParser.parse(Integer.class, map.get(NetdiskMenuMeta.SORT_VALUE)));
			this.setShowValue(DataParser.parse(String.class, map.get(NetdiskMenuMeta.SHOW_VALUE)));
			this.setCreateBy(DataParser.parse(String.class, map.get(NetdiskMenuMeta.CREATE_BY)));
			this.setDeleted(DataParser.parse(Integer.class, map.get(NetdiskMenuMeta.DELETED)));
			this.setCreateTime(DataParser.parse(Date.class, map.get(NetdiskMenuMeta.CREATE_TIME)));
			this.setUpdateBy(DataParser.parse(String.class, map.get(NetdiskMenuMeta.UPDATE_BY)));
			this.setDeleteTime(DataParser.parse(Date.class, map.get(NetdiskMenuMeta.DELETE_TIME)));
			this.setName(DataParser.parse(String.class, map.get(NetdiskMenuMeta.NAME)));
			this.setTenantId(DataParser.parse(String.class, map.get(NetdiskMenuMeta.TENANT_ID)));
			this.setDeleteBy(DataParser.parse(String.class, map.get(NetdiskMenuMeta.DELETE_BY)));
			this.setIconCode(DataParser.parse(String.class, map.get(NetdiskMenuMeta.ICON_CODE)));
			this.setId(DataParser.parse(String.class, map.get(NetdiskMenuMeta.ID)));
			// others
			return true;
		} else {
			try {
				this.setCode( (String)map.get(NetdiskMenuMeta.CODE));
				this.setUpdateTime( (Date)map.get(NetdiskMenuMeta.UPDATE_TIME));
				this.setType( (String)map.get(NetdiskMenuMeta.TYPE));
				this.setVersion( (Integer)map.get(NetdiskMenuMeta.VERSION));
				this.setParentId( (String)map.get(NetdiskMenuMeta.PARENT_ID));
				this.setSortValue( (Integer)map.get(NetdiskMenuMeta.SORT_VALUE));
				this.setShowValue( (String)map.get(NetdiskMenuMeta.SHOW_VALUE));
				this.setCreateBy( (String)map.get(NetdiskMenuMeta.CREATE_BY));
				this.setDeleted( (Integer)map.get(NetdiskMenuMeta.DELETED));
				this.setCreateTime( (Date)map.get(NetdiskMenuMeta.CREATE_TIME));
				this.setUpdateBy( (String)map.get(NetdiskMenuMeta.UPDATE_BY));
				this.setDeleteTime( (Date)map.get(NetdiskMenuMeta.DELETE_TIME));
				this.setName( (String)map.get(NetdiskMenuMeta.NAME));
				this.setTenantId( (String)map.get(NetdiskMenuMeta.TENANT_ID));
				this.setDeleteBy( (String)map.get(NetdiskMenuMeta.DELETE_BY));
				this.setIconCode( (String)map.get(NetdiskMenuMeta.ICON_CODE));
				this.setId( (String)map.get(NetdiskMenuMeta.ID));
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
			this.setCode(DataParser.parse(String.class, r.getValue(NetdiskMenuMeta.CODE)));
			this.setUpdateTime(DataParser.parse(Date.class, r.getValue(NetdiskMenuMeta.UPDATE_TIME)));
			this.setType(DataParser.parse(String.class, r.getValue(NetdiskMenuMeta.TYPE)));
			this.setVersion(DataParser.parse(Integer.class, r.getValue(NetdiskMenuMeta.VERSION)));
			this.setParentId(DataParser.parse(String.class, r.getValue(NetdiskMenuMeta.PARENT_ID)));
			this.setSortValue(DataParser.parse(Integer.class, r.getValue(NetdiskMenuMeta.SORT_VALUE)));
			this.setShowValue(DataParser.parse(String.class, r.getValue(NetdiskMenuMeta.SHOW_VALUE)));
			this.setCreateBy(DataParser.parse(String.class, r.getValue(NetdiskMenuMeta.CREATE_BY)));
			this.setDeleted(DataParser.parse(Integer.class, r.getValue(NetdiskMenuMeta.DELETED)));
			this.setCreateTime(DataParser.parse(Date.class, r.getValue(NetdiskMenuMeta.CREATE_TIME)));
			this.setUpdateBy(DataParser.parse(String.class, r.getValue(NetdiskMenuMeta.UPDATE_BY)));
			this.setDeleteTime(DataParser.parse(Date.class, r.getValue(NetdiskMenuMeta.DELETE_TIME)));
			this.setName(DataParser.parse(String.class, r.getValue(NetdiskMenuMeta.NAME)));
			this.setTenantId(DataParser.parse(String.class, r.getValue(NetdiskMenuMeta.TENANT_ID)));
			this.setDeleteBy(DataParser.parse(String.class, r.getValue(NetdiskMenuMeta.DELETE_BY)));
			this.setIconCode(DataParser.parse(String.class, r.getValue(NetdiskMenuMeta.ICON_CODE)));
			this.setId(DataParser.parse(String.class, r.getValue(NetdiskMenuMeta.ID)));
			return true;
		} else {
			try {
				this.setCode( (String)r.getValue(NetdiskMenuMeta.CODE));
				this.setUpdateTime( (Date)r.getValue(NetdiskMenuMeta.UPDATE_TIME));
				this.setType( (String)r.getValue(NetdiskMenuMeta.TYPE));
				this.setVersion( (Integer)r.getValue(NetdiskMenuMeta.VERSION));
				this.setParentId( (String)r.getValue(NetdiskMenuMeta.PARENT_ID));
				this.setSortValue( (Integer)r.getValue(NetdiskMenuMeta.SORT_VALUE));
				this.setShowValue( (String)r.getValue(NetdiskMenuMeta.SHOW_VALUE));
				this.setCreateBy( (String)r.getValue(NetdiskMenuMeta.CREATE_BY));
				this.setDeleted( (Integer)r.getValue(NetdiskMenuMeta.DELETED));
				this.setCreateTime( (Date)r.getValue(NetdiskMenuMeta.CREATE_TIME));
				this.setUpdateBy( (String)r.getValue(NetdiskMenuMeta.UPDATE_BY));
				this.setDeleteTime( (Date)r.getValue(NetdiskMenuMeta.DELETE_TIME));
				this.setName( (String)r.getValue(NetdiskMenuMeta.NAME));
				this.setTenantId( (String)r.getValue(NetdiskMenuMeta.TENANT_ID));
				this.setDeleteBy( (String)r.getValue(NetdiskMenuMeta.DELETE_BY));
				this.setIconCode( (String)r.getValue(NetdiskMenuMeta.ICON_CODE));
				this.setId( (String)r.getValue(NetdiskMenuMeta.ID));
				return true;
			} catch (Exception e) {
				return false;
			}
		}
	}
}