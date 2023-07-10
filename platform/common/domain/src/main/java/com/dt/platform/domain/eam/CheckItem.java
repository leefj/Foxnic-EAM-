package com.dt.platform.domain.eam;

import com.github.foxnic.dao.entity.Entity;
import io.swagger.annotations.ApiModel;
import javax.persistence.Table;
import com.github.foxnic.sql.meta.DBTable;
import com.dt.platform.constants.db.EAMTables.EAM_CHECK_ITEM;
import javax.persistence.Id;
import io.swagger.annotations.ApiModelProperty;
import java.util.Date;
import javax.persistence.Transient;
import com.github.foxnic.api.swagger.EnumFor;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.github.foxnic.commons.lang.DataParser;
import java.util.Map;
import com.github.foxnic.dao.entity.EntityContext;
import com.dt.platform.domain.eam.meta.CheckItemMeta;
import com.github.foxnic.sql.data.ExprRcd;



/**
 * 检查项
 * <p>检查项 , 数据表 eam_check_item 的PO类型</p>
 * @author 金杰 , maillank@qq.com
 * @since 2023-07-10 12:35:18
 * @sign 015FCE7FC422A1104EA86D12D411D1ED
 * 此文件由工具自动生成，请勿修改。若表结构或配置发生变动，请使用工具重新生成。
*/

@Table(name = "eam_check_item")
@ApiModel(description = "检查项 ; 检查项 , 数据表 eam_check_item 的PO类型")
public class CheckItem extends Entity {

	private static final long serialVersionUID = 1L;

	public static final DBTable TABLE =EAM_CHECK_ITEM.$TABLE;
	
	/**
	 * 主键：主键
	*/
	@Id
	@ApiModelProperty(required = true,value="主键" , notes = "主键" , example = "728972909854326784")
	private String id;
	
	/**
	 * 归属：归属
	*/
	@ApiModelProperty(required = false,value="归属" , notes = "归属" , example = "inspect")
	private String owner;
	
	/**
	 * 编码：编码
	*/
	@ApiModelProperty(required = false,value="编码" , notes = "编码" , example = "C000001")
	private String code;
	
	/**
	 * 状态：状态
	*/
	@ApiModelProperty(required = false,value="状态" , notes = "状态" , example = "enable")
	private String status;
	
	/**
	 * 名称：名称
	*/
	@ApiModelProperty(required = false,value="名称" , notes = "名称" , example = "外观检查项")
	private String name;
	
	/**
	 * 描述：描述
	*/
	@ApiModelProperty(required = false,value="描述" , notes = "描述")
	private String checkDesc;
	
	/**
	 * 组件类型：组件类型
	*/
	@ApiModelProperty(required = false,value="组件类型" , notes = "组件类型" , example = "input")
	private String type;
	
	/**
	 * 配置项：配置项
	*/
	@ApiModelProperty(required = false,value="配置项" , notes = "配置项")
	private String config;
	
	/**
	 * 默认内容：默认内容
	*/
	@ApiModelProperty(required = false,value="默认内容" , notes = "默认内容" , example = "检查正常")
	private String defValue;
	
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
	@ApiModelProperty(required = false,value="创建时间" , notes = "创建时间" , example = "2023-07-05 01:58:05")
	private Date createTime;
	
	/**
	 * 修改人ID：修改人ID
	*/
	@ApiModelProperty(required = false,value="修改人ID" , notes = "修改人ID" , example = "110588348101165911")
	private String updateBy;
	
	/**
	 * 修改时间：修改时间
	*/
	@ApiModelProperty(required = false,value="修改时间" , notes = "修改时间" , example = "2023-07-09 06:55:17")
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
	@ApiModelProperty(required = true,value="version" , notes = "version" , example = "3")
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
	public CheckItem setId(String id) {
		this.id=id;
		return this;
	}
	
	/**
	 * 获得 归属<br>
	 * 归属
	 * @return 归属
	*/
	public String getOwner() {
		return owner;
	}
	
	/**
	 * 设置 归属
	 * @param owner 归属
	 * @return 当前对象
	*/
	public CheckItem setOwner(String owner) {
		this.owner=owner;
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
	public CheckItem setCode(String code) {
		this.code=code;
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
	public CheckItem setStatus(String status) {
		this.status=status;
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
	public CheckItem setName(String name) {
		this.name=name;
		return this;
	}
	
	/**
	 * 获得 描述<br>
	 * 描述
	 * @return 描述
	*/
	public String getCheckDesc() {
		return checkDesc;
	}
	
	/**
	 * 设置 描述
	 * @param checkDesc 描述
	 * @return 当前对象
	*/
	public CheckItem setCheckDesc(String checkDesc) {
		this.checkDesc=checkDesc;
		return this;
	}
	
	/**
	 * 获得 组件类型<br>
	 * 组件类型
	 * @return 组件类型
	*/
	public String getType() {
		return type;
	}
	
	/**
	 * 设置 组件类型
	 * @param type 组件类型
	 * @return 当前对象
	*/
	public CheckItem setType(String type) {
		this.type=type;
		return this;
	}
	
	/**
	 * 获得 配置项<br>
	 * 配置项
	 * @return 配置项
	*/
	public String getConfig() {
		return config;
	}
	
	/**
	 * 设置 配置项
	 * @param config 配置项
	 * @return 当前对象
	*/
	public CheckItem setConfig(String config) {
		this.config=config;
		return this;
	}
	
	/**
	 * 获得 默认内容<br>
	 * 默认内容
	 * @return 默认内容
	*/
	public String getDefValue() {
		return defValue;
	}
	
	/**
	 * 设置 默认内容
	 * @param defValue 默认内容
	 * @return 当前对象
	*/
	public CheckItem setDefValue(String defValue) {
		this.defValue=defValue;
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
	public CheckItem setNotes(String notes) {
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
	public CheckItem setCreateBy(String createBy) {
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
	public CheckItem setCreateTime(Date createTime) {
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
	public CheckItem setUpdateBy(String updateBy) {
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
	public CheckItem setUpdateTime(Date updateTime) {
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
	public CheckItem setDeleted(Integer deleted) {
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
	public CheckItem setDeleted(Boolean deletedBool) {
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
	public CheckItem setDeleteBy(String deleteBy) {
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
	public CheckItem setDeleteTime(Date deleteTime) {
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
	public CheckItem setVersion(Integer version) {
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
	public CheckItem setTenantId(String tenantId) {
		this.tenantId=tenantId;
		return this;
	}

	/**
	 * 将自己转换成指定类型的PO
	 * @param poType  PO类型
	 * @return CheckItem , 转换好的 CheckItem 对象
	*/
	@Transient
	public <T extends Entity> T toPO(Class<T> poType) {
		return EntityContext.create(poType, this);
	}

	/**
	 * 将自己转换成任意指定类型
	 * @param pojoType  Pojo类型
	 * @return CheckItem , 转换好的 PoJo 对象
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
	public CheckItem clone() {
		return duplicate(true);
	}

	/**
	 * 复制当前对象
	 * @param all 是否复制全部属性，当 false 时，仅复制来自数据表的属性
	*/
	@Transient
	public CheckItem duplicate(boolean all) {
		com.dt.platform.domain.eam.meta.CheckItemMeta.$$proxy$$ inst = new com.dt.platform.domain.eam.meta.CheckItemMeta.$$proxy$$();
		inst.setOwner(this.getOwner());
		inst.setCode(this.getCode());
		inst.setCheckDesc(this.getCheckDesc());
		inst.setNotes(this.getNotes());
		inst.setUpdateTime(this.getUpdateTime());
		inst.setType(this.getType());
		inst.setVersion(this.getVersion());
		inst.setDefValue(this.getDefValue());
		inst.setCreateBy(this.getCreateBy());
		inst.setDeleted(this.getDeleted());
		inst.setCreateTime(this.getCreateTime());
		inst.setUpdateBy(this.getUpdateBy());
		inst.setDeleteTime(this.getDeleteTime());
		inst.setName(this.getName());
		inst.setTenantId(this.getTenantId());
		inst.setDeleteBy(this.getDeleteBy());
		inst.setId(this.getId());
		inst.setConfig(this.getConfig());
		inst.setStatus(this.getStatus());
		inst.clearModifies();
		return inst;
	}

	/**
	 * 克隆当前对象
	*/
	@Transient
	public CheckItem clone(boolean deep) {
		return EntityContext.clone(CheckItem.class,this,deep);
	}

	/**
	 * 将 Map 转换成 CheckItem
	 * @param checkItemMap 包含实体信息的 Map 对象
	 * @return CheckItem , 转换好的的 CheckItem 对象
	*/
	@Transient
	public static CheckItem createFrom(Map<String,Object> checkItemMap) {
		if(checkItemMap==null) return null;
		CheckItem po = create();
		EntityContext.copyProperties(po,checkItemMap);
		po.clearModifies();
		return po;
	}

	/**
	 * 将 Pojo 转换成 CheckItem
	 * @param pojo 包含实体信息的 Pojo 对象
	 * @return CheckItem , 转换好的的 CheckItem 对象
	*/
	@Transient
	public static CheckItem createFrom(Object pojo) {
		if(pojo==null) return null;
		CheckItem po = create();
		EntityContext.copyProperties(po,pojo);
		po.clearModifies();
		return po;
	}

	/**
	 * 创建一个 CheckItem，等同于 new
	 * @return CheckItem 对象
	*/
	@Transient
	public static CheckItem create() {
		return new com.dt.platform.domain.eam.meta.CheckItemMeta.$$proxy$$();
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
			this.setOwner(DataParser.parse(String.class, map.get(CheckItemMeta.OWNER)));
			this.setCode(DataParser.parse(String.class, map.get(CheckItemMeta.CODE)));
			this.setCheckDesc(DataParser.parse(String.class, map.get(CheckItemMeta.CHECK_DESC)));
			this.setNotes(DataParser.parse(String.class, map.get(CheckItemMeta.NOTES)));
			this.setUpdateTime(DataParser.parse(Date.class, map.get(CheckItemMeta.UPDATE_TIME)));
			this.setType(DataParser.parse(String.class, map.get(CheckItemMeta.TYPE)));
			this.setVersion(DataParser.parse(Integer.class, map.get(CheckItemMeta.VERSION)));
			this.setDefValue(DataParser.parse(String.class, map.get(CheckItemMeta.DEF_VALUE)));
			this.setCreateBy(DataParser.parse(String.class, map.get(CheckItemMeta.CREATE_BY)));
			this.setDeleted(DataParser.parse(Integer.class, map.get(CheckItemMeta.DELETED)));
			this.setCreateTime(DataParser.parse(Date.class, map.get(CheckItemMeta.CREATE_TIME)));
			this.setUpdateBy(DataParser.parse(String.class, map.get(CheckItemMeta.UPDATE_BY)));
			this.setDeleteTime(DataParser.parse(Date.class, map.get(CheckItemMeta.DELETE_TIME)));
			this.setName(DataParser.parse(String.class, map.get(CheckItemMeta.NAME)));
			this.setTenantId(DataParser.parse(String.class, map.get(CheckItemMeta.TENANT_ID)));
			this.setDeleteBy(DataParser.parse(String.class, map.get(CheckItemMeta.DELETE_BY)));
			this.setId(DataParser.parse(String.class, map.get(CheckItemMeta.ID)));
			this.setConfig(DataParser.parse(String.class, map.get(CheckItemMeta.CONFIG)));
			this.setStatus(DataParser.parse(String.class, map.get(CheckItemMeta.STATUS)));
			// others
			return true;
		} else {
			try {
				this.setOwner( (String)map.get(CheckItemMeta.OWNER));
				this.setCode( (String)map.get(CheckItemMeta.CODE));
				this.setCheckDesc( (String)map.get(CheckItemMeta.CHECK_DESC));
				this.setNotes( (String)map.get(CheckItemMeta.NOTES));
				this.setUpdateTime( (Date)map.get(CheckItemMeta.UPDATE_TIME));
				this.setType( (String)map.get(CheckItemMeta.TYPE));
				this.setVersion( (Integer)map.get(CheckItemMeta.VERSION));
				this.setDefValue( (String)map.get(CheckItemMeta.DEF_VALUE));
				this.setCreateBy( (String)map.get(CheckItemMeta.CREATE_BY));
				this.setDeleted( (Integer)map.get(CheckItemMeta.DELETED));
				this.setCreateTime( (Date)map.get(CheckItemMeta.CREATE_TIME));
				this.setUpdateBy( (String)map.get(CheckItemMeta.UPDATE_BY));
				this.setDeleteTime( (Date)map.get(CheckItemMeta.DELETE_TIME));
				this.setName( (String)map.get(CheckItemMeta.NAME));
				this.setTenantId( (String)map.get(CheckItemMeta.TENANT_ID));
				this.setDeleteBy( (String)map.get(CheckItemMeta.DELETE_BY));
				this.setId( (String)map.get(CheckItemMeta.ID));
				this.setConfig( (String)map.get(CheckItemMeta.CONFIG));
				this.setStatus( (String)map.get(CheckItemMeta.STATUS));
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
			this.setOwner(DataParser.parse(String.class, r.getValue(CheckItemMeta.OWNER)));
			this.setCode(DataParser.parse(String.class, r.getValue(CheckItemMeta.CODE)));
			this.setCheckDesc(DataParser.parse(String.class, r.getValue(CheckItemMeta.CHECK_DESC)));
			this.setNotes(DataParser.parse(String.class, r.getValue(CheckItemMeta.NOTES)));
			this.setUpdateTime(DataParser.parse(Date.class, r.getValue(CheckItemMeta.UPDATE_TIME)));
			this.setType(DataParser.parse(String.class, r.getValue(CheckItemMeta.TYPE)));
			this.setVersion(DataParser.parse(Integer.class, r.getValue(CheckItemMeta.VERSION)));
			this.setDefValue(DataParser.parse(String.class, r.getValue(CheckItemMeta.DEF_VALUE)));
			this.setCreateBy(DataParser.parse(String.class, r.getValue(CheckItemMeta.CREATE_BY)));
			this.setDeleted(DataParser.parse(Integer.class, r.getValue(CheckItemMeta.DELETED)));
			this.setCreateTime(DataParser.parse(Date.class, r.getValue(CheckItemMeta.CREATE_TIME)));
			this.setUpdateBy(DataParser.parse(String.class, r.getValue(CheckItemMeta.UPDATE_BY)));
			this.setDeleteTime(DataParser.parse(Date.class, r.getValue(CheckItemMeta.DELETE_TIME)));
			this.setName(DataParser.parse(String.class, r.getValue(CheckItemMeta.NAME)));
			this.setTenantId(DataParser.parse(String.class, r.getValue(CheckItemMeta.TENANT_ID)));
			this.setDeleteBy(DataParser.parse(String.class, r.getValue(CheckItemMeta.DELETE_BY)));
			this.setId(DataParser.parse(String.class, r.getValue(CheckItemMeta.ID)));
			this.setConfig(DataParser.parse(String.class, r.getValue(CheckItemMeta.CONFIG)));
			this.setStatus(DataParser.parse(String.class, r.getValue(CheckItemMeta.STATUS)));
			return true;
		} else {
			try {
				this.setOwner( (String)r.getValue(CheckItemMeta.OWNER));
				this.setCode( (String)r.getValue(CheckItemMeta.CODE));
				this.setCheckDesc( (String)r.getValue(CheckItemMeta.CHECK_DESC));
				this.setNotes( (String)r.getValue(CheckItemMeta.NOTES));
				this.setUpdateTime( (Date)r.getValue(CheckItemMeta.UPDATE_TIME));
				this.setType( (String)r.getValue(CheckItemMeta.TYPE));
				this.setVersion( (Integer)r.getValue(CheckItemMeta.VERSION));
				this.setDefValue( (String)r.getValue(CheckItemMeta.DEF_VALUE));
				this.setCreateBy( (String)r.getValue(CheckItemMeta.CREATE_BY));
				this.setDeleted( (Integer)r.getValue(CheckItemMeta.DELETED));
				this.setCreateTime( (Date)r.getValue(CheckItemMeta.CREATE_TIME));
				this.setUpdateBy( (String)r.getValue(CheckItemMeta.UPDATE_BY));
				this.setDeleteTime( (Date)r.getValue(CheckItemMeta.DELETE_TIME));
				this.setName( (String)r.getValue(CheckItemMeta.NAME));
				this.setTenantId( (String)r.getValue(CheckItemMeta.TENANT_ID));
				this.setDeleteBy( (String)r.getValue(CheckItemMeta.DELETE_BY));
				this.setId( (String)r.getValue(CheckItemMeta.ID));
				this.setConfig( (String)r.getValue(CheckItemMeta.CONFIG));
				this.setStatus( (String)r.getValue(CheckItemMeta.STATUS));
				return true;
			} catch (Exception e) {
				return false;
			}
		}
	}
}