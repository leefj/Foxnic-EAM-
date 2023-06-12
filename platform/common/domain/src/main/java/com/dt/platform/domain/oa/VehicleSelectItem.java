package com.dt.platform.domain.oa;

import com.github.foxnic.dao.entity.Entity;
import io.swagger.annotations.ApiModel;
import javax.persistence.Table;
import com.github.foxnic.sql.meta.DBTable;
import com.dt.platform.constants.db.OaTables.OA_VEHICLE_SELECT_ITEM;
import javax.persistence.Id;
import io.swagger.annotations.ApiModelProperty;
import java.util.Date;
import javax.persistence.Transient;
import com.github.foxnic.api.swagger.EnumFor;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.github.foxnic.commons.lang.DataParser;
import java.util.Map;
import com.github.foxnic.dao.entity.EntityContext;
import com.dt.platform.domain.oa.meta.VehicleSelectItemMeta;
import com.github.foxnic.sql.data.ExprRcd;



/**
 * 车辆数据
 * <p>车辆数据 , 数据表 oa_vehicle_select_item 的PO类型</p>
 * @author 金杰 , maillank@qq.com
 * @since 2023-06-10 13:50:38
 * @sign 7CD53D138FFDF74524AD3BE71070585F
 * 此文件由工具自动生成，请勿修改。若表结构或配置发生变动，请使用工具重新生成。
*/

@Table(name = "oa_vehicle_select_item")
@ApiModel(description = "车辆数据 ; 车辆数据 , 数据表 oa_vehicle_select_item 的PO类型")
public class VehicleSelectItem extends Entity {

	private static final long serialVersionUID = 1L;

	public static final DBTable TABLE =OA_VEHICLE_SELECT_ITEM.$TABLE;
	
	/**
	 * 主键：主键
	*/
	@Id
	@ApiModelProperty(required = true,value="主键" , notes = "主键")
	private String id;
	
	/**
	 * 处理：处理
	*/
	@ApiModelProperty(required = false,value="处理" , notes = "处理")
	private String handleId;
	
	/**
	 * 车辆：车辆
	*/
	@ApiModelProperty(required = false,value="车辆" , notes = "车辆")
	private String assetId;
	
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
	public VehicleSelectItem setId(String id) {
		this.id=id;
		return this;
	}
	
	/**
	 * 获得 处理<br>
	 * 处理
	 * @return 处理
	*/
	public String getHandleId() {
		return handleId;
	}
	
	/**
	 * 设置 处理
	 * @param handleId 处理
	 * @return 当前对象
	*/
	public VehicleSelectItem setHandleId(String handleId) {
		this.handleId=handleId;
		return this;
	}
	
	/**
	 * 获得 车辆<br>
	 * 车辆
	 * @return 车辆
	*/
	public String getAssetId() {
		return assetId;
	}
	
	/**
	 * 设置 车辆
	 * @param assetId 车辆
	 * @return 当前对象
	*/
	public VehicleSelectItem setAssetId(String assetId) {
		this.assetId=assetId;
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
	public VehicleSelectItem setCreateBy(String createBy) {
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
	public VehicleSelectItem setCreateTime(Date createTime) {
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
	public VehicleSelectItem setUpdateBy(String updateBy) {
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
	public VehicleSelectItem setUpdateTime(Date updateTime) {
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
	public VehicleSelectItem setDeleted(Integer deleted) {
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
	public VehicleSelectItem setDeleted(Boolean deletedBool) {
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
	public VehicleSelectItem setDeleteBy(String deleteBy) {
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
	public VehicleSelectItem setDeleteTime(Date deleteTime) {
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
	public VehicleSelectItem setVersion(Integer version) {
		this.version=version;
		return this;
	}

	/**
	 * 将自己转换成指定类型的PO
	 * @param poType  PO类型
	 * @return VehicleSelectItem , 转换好的 VehicleSelectItem 对象
	*/
	@Transient
	public <T extends Entity> T toPO(Class<T> poType) {
		return EntityContext.create(poType, this);
	}

	/**
	 * 将自己转换成任意指定类型
	 * @param pojoType  Pojo类型
	 * @return VehicleSelectItem , 转换好的 PoJo 对象
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
	public VehicleSelectItem clone() {
		return duplicate(true);
	}

	/**
	 * 复制当前对象
	 * @param all 是否复制全部属性，当 false 时，仅复制来自数据表的属性
	*/
	@Transient
	public VehicleSelectItem duplicate(boolean all) {
		com.dt.platform.domain.oa.meta.VehicleSelectItemMeta.$$proxy$$ inst = new com.dt.platform.domain.oa.meta.VehicleSelectItemMeta.$$proxy$$();
		inst.setCreateBy(this.getCreateBy());
		inst.setDeleted(this.getDeleted());
		inst.setCreateTime(this.getCreateTime());
		inst.setUpdateBy(this.getUpdateBy());
		inst.setDeleteTime(this.getDeleteTime());
		inst.setAssetId(this.getAssetId());
		inst.setDeleteBy(this.getDeleteBy());
		inst.setUpdateTime(this.getUpdateTime());
		inst.setId(this.getId());
		inst.setHandleId(this.getHandleId());
		inst.setVersion(this.getVersion());
		inst.clearModifies();
		return inst;
	}

	/**
	 * 克隆当前对象
	*/
	@Transient
	public VehicleSelectItem clone(boolean deep) {
		return EntityContext.clone(VehicleSelectItem.class,this,deep);
	}

	/**
	 * 将 Map 转换成 VehicleSelectItem
	 * @param vehicleSelectItemMap 包含实体信息的 Map 对象
	 * @return VehicleSelectItem , 转换好的的 VehicleSelectItem 对象
	*/
	@Transient
	public static VehicleSelectItem createFrom(Map<String,Object> vehicleSelectItemMap) {
		if(vehicleSelectItemMap==null) return null;
		VehicleSelectItem po = create();
		EntityContext.copyProperties(po,vehicleSelectItemMap);
		po.clearModifies();
		return po;
	}

	/**
	 * 将 Pojo 转换成 VehicleSelectItem
	 * @param pojo 包含实体信息的 Pojo 对象
	 * @return VehicleSelectItem , 转换好的的 VehicleSelectItem 对象
	*/
	@Transient
	public static VehicleSelectItem createFrom(Object pojo) {
		if(pojo==null) return null;
		VehicleSelectItem po = create();
		EntityContext.copyProperties(po,pojo);
		po.clearModifies();
		return po;
	}

	/**
	 * 创建一个 VehicleSelectItem，等同于 new
	 * @return VehicleSelectItem 对象
	*/
	@Transient
	public static VehicleSelectItem create() {
		return new com.dt.platform.domain.oa.meta.VehicleSelectItemMeta.$$proxy$$();
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
			this.setCreateBy(DataParser.parse(String.class, map.get(VehicleSelectItemMeta.CREATE_BY)));
			this.setDeleted(DataParser.parse(Integer.class, map.get(VehicleSelectItemMeta.DELETED)));
			this.setCreateTime(DataParser.parse(Date.class, map.get(VehicleSelectItemMeta.CREATE_TIME)));
			this.setUpdateBy(DataParser.parse(String.class, map.get(VehicleSelectItemMeta.UPDATE_BY)));
			this.setDeleteTime(DataParser.parse(Date.class, map.get(VehicleSelectItemMeta.DELETE_TIME)));
			this.setAssetId(DataParser.parse(String.class, map.get(VehicleSelectItemMeta.ASSET_ID)));
			this.setDeleteBy(DataParser.parse(String.class, map.get(VehicleSelectItemMeta.DELETE_BY)));
			this.setUpdateTime(DataParser.parse(Date.class, map.get(VehicleSelectItemMeta.UPDATE_TIME)));
			this.setId(DataParser.parse(String.class, map.get(VehicleSelectItemMeta.ID)));
			this.setHandleId(DataParser.parse(String.class, map.get(VehicleSelectItemMeta.HANDLE_ID)));
			this.setVersion(DataParser.parse(Integer.class, map.get(VehicleSelectItemMeta.VERSION)));
			// others
			return true;
		} else {
			try {
				this.setCreateBy( (String)map.get(VehicleSelectItemMeta.CREATE_BY));
				this.setDeleted( (Integer)map.get(VehicleSelectItemMeta.DELETED));
				this.setCreateTime( (Date)map.get(VehicleSelectItemMeta.CREATE_TIME));
				this.setUpdateBy( (String)map.get(VehicleSelectItemMeta.UPDATE_BY));
				this.setDeleteTime( (Date)map.get(VehicleSelectItemMeta.DELETE_TIME));
				this.setAssetId( (String)map.get(VehicleSelectItemMeta.ASSET_ID));
				this.setDeleteBy( (String)map.get(VehicleSelectItemMeta.DELETE_BY));
				this.setUpdateTime( (Date)map.get(VehicleSelectItemMeta.UPDATE_TIME));
				this.setId( (String)map.get(VehicleSelectItemMeta.ID));
				this.setHandleId( (String)map.get(VehicleSelectItemMeta.HANDLE_ID));
				this.setVersion( (Integer)map.get(VehicleSelectItemMeta.VERSION));
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
			this.setCreateBy(DataParser.parse(String.class, r.getValue(VehicleSelectItemMeta.CREATE_BY)));
			this.setDeleted(DataParser.parse(Integer.class, r.getValue(VehicleSelectItemMeta.DELETED)));
			this.setCreateTime(DataParser.parse(Date.class, r.getValue(VehicleSelectItemMeta.CREATE_TIME)));
			this.setUpdateBy(DataParser.parse(String.class, r.getValue(VehicleSelectItemMeta.UPDATE_BY)));
			this.setDeleteTime(DataParser.parse(Date.class, r.getValue(VehicleSelectItemMeta.DELETE_TIME)));
			this.setAssetId(DataParser.parse(String.class, r.getValue(VehicleSelectItemMeta.ASSET_ID)));
			this.setDeleteBy(DataParser.parse(String.class, r.getValue(VehicleSelectItemMeta.DELETE_BY)));
			this.setUpdateTime(DataParser.parse(Date.class, r.getValue(VehicleSelectItemMeta.UPDATE_TIME)));
			this.setId(DataParser.parse(String.class, r.getValue(VehicleSelectItemMeta.ID)));
			this.setHandleId(DataParser.parse(String.class, r.getValue(VehicleSelectItemMeta.HANDLE_ID)));
			this.setVersion(DataParser.parse(Integer.class, r.getValue(VehicleSelectItemMeta.VERSION)));
			return true;
		} else {
			try {
				this.setCreateBy( (String)r.getValue(VehicleSelectItemMeta.CREATE_BY));
				this.setDeleted( (Integer)r.getValue(VehicleSelectItemMeta.DELETED));
				this.setCreateTime( (Date)r.getValue(VehicleSelectItemMeta.CREATE_TIME));
				this.setUpdateBy( (String)r.getValue(VehicleSelectItemMeta.UPDATE_BY));
				this.setDeleteTime( (Date)r.getValue(VehicleSelectItemMeta.DELETE_TIME));
				this.setAssetId( (String)r.getValue(VehicleSelectItemMeta.ASSET_ID));
				this.setDeleteBy( (String)r.getValue(VehicleSelectItemMeta.DELETE_BY));
				this.setUpdateTime( (Date)r.getValue(VehicleSelectItemMeta.UPDATE_TIME));
				this.setId( (String)r.getValue(VehicleSelectItemMeta.ID));
				this.setHandleId( (String)r.getValue(VehicleSelectItemMeta.HANDLE_ID));
				this.setVersion( (Integer)r.getValue(VehicleSelectItemMeta.VERSION));
				return true;
			} catch (Exception e) {
				return false;
			}
		}
	}
}