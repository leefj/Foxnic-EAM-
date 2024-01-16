package com.dt.platform.domain.eam;

import com.github.foxnic.dao.entity.Entity;
import io.swagger.annotations.ApiModel;
import javax.persistence.Table;
import com.github.foxnic.sql.meta.DBTable;
import com.dt.platform.constants.db.EAMTables.EAM_CHECK_GROUP;
import javax.persistence.Id;
import io.swagger.annotations.ApiModelProperty;
import java.util.Date;
import javax.persistence.Transient;
import com.github.foxnic.api.swagger.EnumFor;
import java.util.List;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.github.foxnic.commons.lang.DataParser;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Map;
import com.github.foxnic.dao.entity.EntityContext;
import com.dt.platform.domain.eam.meta.CheckGroupMeta;
import com.github.foxnic.sql.data.ExprRcd;



/**
 * 检查模版
 * <p>检查模版 , 数据表 eam_check_group 的PO类型</p>
 * @author 金杰 , maillank@qq.com
 * @since 2024-01-13 13:02:53
 * @sign 43ECA0E5EF9ADB27D8C22EB9BB1168B9
 * 此文件由工具自动生成，请勿修改。若表结构或配置发生变动，请使用工具重新生成。
*/

@Table(name = "eam_check_group")
@ApiModel(description = "检查模版 ; 检查模版 , 数据表 eam_check_group 的PO类型")
public class CheckGroup extends Entity {

	private static final long serialVersionUID = 1L;

	public static final DBTable TABLE =EAM_CHECK_GROUP.$TABLE;
	
	/**
	 * 主键：主键
	*/
	@Id
	@ApiModelProperty(required = true,value="主键" , notes = "主键" , example = "728920300598591488")
	private String id;
	
	/**
	 * 名称：名称
	*/
	@ApiModelProperty(required = false,value="名称" , notes = "名称" , example = "检查组")
	private String name;
	
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
	@ApiModelProperty(required = false,value="创建时间" , notes = "创建时间" , example = "2023-07-05 10:29:02")
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
	@ApiModelProperty(required = true,value="version" , notes = "version" , example = "1")
	private Integer version;
	
	/**
	 * 租户：租户
	*/
	@ApiModelProperty(required = false,value="租户" , notes = "租户" , example = "T001")
	private String tenantId;
	
	/**
	 * itemList：itemList
	*/
	@ApiModelProperty(required = false,value="itemList" , notes = "itemList")
	private List<CheckGroupItem> itemList;
	
	/**
	 * idsList：idsList
	*/
	@ApiModelProperty(required = false,value="idsList" , notes = "idsList")
	private List<String> idsList;
	
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
	public CheckGroup setId(String id) {
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
	public CheckGroup setName(String name) {
		this.name=name;
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
	public CheckGroup setNotes(String notes) {
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
	public CheckGroup setCreateBy(String createBy) {
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
	public CheckGroup setCreateTime(Date createTime) {
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
	public CheckGroup setUpdateBy(String updateBy) {
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
	public CheckGroup setUpdateTime(Date updateTime) {
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
	public CheckGroup setDeleted(Integer deleted) {
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
	public CheckGroup setDeleted(Boolean deletedBool) {
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
	public CheckGroup setDeleteBy(String deleteBy) {
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
	public CheckGroup setDeleteTime(Date deleteTime) {
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
	public CheckGroup setVersion(Integer version) {
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
	public CheckGroup setTenantId(String tenantId) {
		this.tenantId=tenantId;
		return this;
	}
	
	/**
	 * 获得 itemList<br>
	 * itemList
	 * @return itemList
	*/
	public List<CheckGroupItem> getItemList() {
		return itemList;
	}
	
	/**
	 * 设置 itemList
	 * @param itemList itemList
	 * @return 当前对象
	*/
	public CheckGroup setItemList(List<CheckGroupItem> itemList) {
		this.itemList=itemList;
		return this;
	}
	
	/**
	 * 添加 itemList
	 * @param item itemList
	 * @return 当前对象
	*/
	public CheckGroup addItem(CheckGroupItem... item) {
		if(this.itemList==null) itemList=new ArrayList<>();
		this.itemList.addAll(Arrays.asList(item));
		return this;
	}
	
	/**
	 * 获得 idsList<br>
	 * idsList
	 * @return idsList
	*/
	public List<String> getIdsList() {
		return idsList;
	}
	
	/**
	 * 设置 idsList
	 * @param idsList idsList
	 * @return 当前对象
	*/
	public CheckGroup setIdsList(List<String> idsList) {
		this.idsList=idsList;
		return this;
	}
	
	/**
	 * 添加 idsList
	 * @param ids idsList
	 * @return 当前对象
	*/
	public CheckGroup addIds(String... ids) {
		if(this.idsList==null) idsList=new ArrayList<>();
		this.idsList.addAll(Arrays.asList(ids));
		return this;
	}

	/**
	 * 将自己转换成指定类型的PO
	 * @param poType  PO类型
	 * @return CheckGroup , 转换好的 CheckGroup 对象
	*/
	@Transient
	public <T extends Entity> T toPO(Class<T> poType) {
		return EntityContext.create(poType, this);
	}

	/**
	 * 将自己转换成任意指定类型
	 * @param pojoType  Pojo类型
	 * @return CheckGroup , 转换好的 PoJo 对象
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
	public CheckGroup clone() {
		return duplicate(true);
	}

	/**
	 * 复制当前对象
	 * @param all 是否复制全部属性，当 false 时，仅复制来自数据表的属性
	*/
	@Transient
	public CheckGroup duplicate(boolean all) {
		com.dt.platform.domain.eam.meta.CheckGroupMeta.$$proxy$$ inst = new com.dt.platform.domain.eam.meta.CheckGroupMeta.$$proxy$$();
		inst.setCreateBy(this.getCreateBy());
		inst.setNotes(this.getNotes());
		inst.setDeleted(this.getDeleted());
		inst.setCreateTime(this.getCreateTime());
		inst.setUpdateBy(this.getUpdateBy());
		inst.setDeleteTime(this.getDeleteTime());
		inst.setName(this.getName());
		inst.setTenantId(this.getTenantId());
		inst.setDeleteBy(this.getDeleteBy());
		inst.setUpdateTime(this.getUpdateTime());
		inst.setId(this.getId());
		inst.setVersion(this.getVersion());
		if(all) {
			inst.setItemList(this.getItemList());
			inst.setIdsList(this.getIdsList());
		}
		inst.clearModifies();
		return inst;
	}

	/**
	 * 克隆当前对象
	*/
	@Transient
	public CheckGroup clone(boolean deep) {
		return EntityContext.clone(CheckGroup.class,this,deep);
	}

	/**
	 * 将 Map 转换成 CheckGroup
	 * @param checkGroupMap 包含实体信息的 Map 对象
	 * @return CheckGroup , 转换好的的 CheckGroup 对象
	*/
	@Transient
	public static CheckGroup createFrom(Map<String,Object> checkGroupMap) {
		if(checkGroupMap==null) return null;
		CheckGroup po = create();
		EntityContext.copyProperties(po,checkGroupMap);
		po.clearModifies();
		return po;
	}

	/**
	 * 将 Pojo 转换成 CheckGroup
	 * @param pojo 包含实体信息的 Pojo 对象
	 * @return CheckGroup , 转换好的的 CheckGroup 对象
	*/
	@Transient
	public static CheckGroup createFrom(Object pojo) {
		if(pojo==null) return null;
		CheckGroup po = create();
		EntityContext.copyProperties(po,pojo);
		po.clearModifies();
		return po;
	}

	/**
	 * 创建一个 CheckGroup，等同于 new
	 * @return CheckGroup 对象
	*/
	@Transient
	public static CheckGroup create() {
		return new com.dt.platform.domain.eam.meta.CheckGroupMeta.$$proxy$$();
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
			this.setCreateBy(DataParser.parse(String.class, map.get(CheckGroupMeta.CREATE_BY)));
			this.setNotes(DataParser.parse(String.class, map.get(CheckGroupMeta.NOTES)));
			this.setDeleted(DataParser.parse(Integer.class, map.get(CheckGroupMeta.DELETED)));
			this.setCreateTime(DataParser.parse(Date.class, map.get(CheckGroupMeta.CREATE_TIME)));
			this.setUpdateBy(DataParser.parse(String.class, map.get(CheckGroupMeta.UPDATE_BY)));
			this.setDeleteTime(DataParser.parse(Date.class, map.get(CheckGroupMeta.DELETE_TIME)));
			this.setName(DataParser.parse(String.class, map.get(CheckGroupMeta.NAME)));
			this.setTenantId(DataParser.parse(String.class, map.get(CheckGroupMeta.TENANT_ID)));
			this.setDeleteBy(DataParser.parse(String.class, map.get(CheckGroupMeta.DELETE_BY)));
			this.setUpdateTime(DataParser.parse(Date.class, map.get(CheckGroupMeta.UPDATE_TIME)));
			this.setId(DataParser.parse(String.class, map.get(CheckGroupMeta.ID)));
			this.setVersion(DataParser.parse(Integer.class, map.get(CheckGroupMeta.VERSION)));
			// others
			return true;
		} else {
			try {
				this.setCreateBy( (String)map.get(CheckGroupMeta.CREATE_BY));
				this.setNotes( (String)map.get(CheckGroupMeta.NOTES));
				this.setDeleted( (Integer)map.get(CheckGroupMeta.DELETED));
				this.setCreateTime( (Date)map.get(CheckGroupMeta.CREATE_TIME));
				this.setUpdateBy( (String)map.get(CheckGroupMeta.UPDATE_BY));
				this.setDeleteTime( (Date)map.get(CheckGroupMeta.DELETE_TIME));
				this.setName( (String)map.get(CheckGroupMeta.NAME));
				this.setTenantId( (String)map.get(CheckGroupMeta.TENANT_ID));
				this.setDeleteBy( (String)map.get(CheckGroupMeta.DELETE_BY));
				this.setUpdateTime( (Date)map.get(CheckGroupMeta.UPDATE_TIME));
				this.setId( (String)map.get(CheckGroupMeta.ID));
				this.setVersion( (Integer)map.get(CheckGroupMeta.VERSION));
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
			this.setCreateBy(DataParser.parse(String.class, r.getValue(CheckGroupMeta.CREATE_BY)));
			this.setNotes(DataParser.parse(String.class, r.getValue(CheckGroupMeta.NOTES)));
			this.setDeleted(DataParser.parse(Integer.class, r.getValue(CheckGroupMeta.DELETED)));
			this.setCreateTime(DataParser.parse(Date.class, r.getValue(CheckGroupMeta.CREATE_TIME)));
			this.setUpdateBy(DataParser.parse(String.class, r.getValue(CheckGroupMeta.UPDATE_BY)));
			this.setDeleteTime(DataParser.parse(Date.class, r.getValue(CheckGroupMeta.DELETE_TIME)));
			this.setName(DataParser.parse(String.class, r.getValue(CheckGroupMeta.NAME)));
			this.setTenantId(DataParser.parse(String.class, r.getValue(CheckGroupMeta.TENANT_ID)));
			this.setDeleteBy(DataParser.parse(String.class, r.getValue(CheckGroupMeta.DELETE_BY)));
			this.setUpdateTime(DataParser.parse(Date.class, r.getValue(CheckGroupMeta.UPDATE_TIME)));
			this.setId(DataParser.parse(String.class, r.getValue(CheckGroupMeta.ID)));
			this.setVersion(DataParser.parse(Integer.class, r.getValue(CheckGroupMeta.VERSION)));
			return true;
		} else {
			try {
				this.setCreateBy( (String)r.getValue(CheckGroupMeta.CREATE_BY));
				this.setNotes( (String)r.getValue(CheckGroupMeta.NOTES));
				this.setDeleted( (Integer)r.getValue(CheckGroupMeta.DELETED));
				this.setCreateTime( (Date)r.getValue(CheckGroupMeta.CREATE_TIME));
				this.setUpdateBy( (String)r.getValue(CheckGroupMeta.UPDATE_BY));
				this.setDeleteTime( (Date)r.getValue(CheckGroupMeta.DELETE_TIME));
				this.setName( (String)r.getValue(CheckGroupMeta.NAME));
				this.setTenantId( (String)r.getValue(CheckGroupMeta.TENANT_ID));
				this.setDeleteBy( (String)r.getValue(CheckGroupMeta.DELETE_BY));
				this.setUpdateTime( (Date)r.getValue(CheckGroupMeta.UPDATE_TIME));
				this.setId( (String)r.getValue(CheckGroupMeta.ID));
				this.setVersion( (Integer)r.getValue(CheckGroupMeta.VERSION));
				return true;
			} catch (Exception e) {
				return false;
			}
		}
	}
}