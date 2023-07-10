package com.dt.platform.domain.eam;

import com.github.foxnic.dao.entity.Entity;
import io.swagger.annotations.ApiModel;
import javax.persistence.Table;
import com.github.foxnic.sql.meta.DBTable;
import com.dt.platform.constants.db.EAMTables.EAM_INSPECTION_POINT_ITEM;
import javax.persistence.Id;
import io.swagger.annotations.ApiModelProperty;
import java.util.Date;
import javax.persistence.Transient;
import com.github.foxnic.api.swagger.EnumFor;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.github.foxnic.commons.lang.DataParser;
import java.util.Map;
import com.github.foxnic.dao.entity.EntityContext;
import com.dt.platform.domain.eam.meta.InspectionPointItemMeta;
import com.github.foxnic.sql.data.ExprRcd;



/**
 * 巡检点项
 * <p>巡检点项 , 数据表 eam_inspection_point_item 的PO类型</p>
 * @author 金杰 , maillank@qq.com
 * @since 2023-07-10 12:35:13
 * @sign 2BD08DDF8723FDDB097B87BD23D92B79
 * 此文件由工具自动生成，请勿修改。若表结构或配置发生变动，请使用工具重新生成。
*/

@Table(name = "eam_inspection_point_item")
@ApiModel(description = "巡检点项 ; 巡检点项 , 数据表 eam_inspection_point_item 的PO类型")
public class InspectionPointItem extends Entity {

	private static final long serialVersionUID = 1L;

	public static final DBTable TABLE =EAM_INSPECTION_POINT_ITEM.$TABLE;
	
	/**
	 * 主键：主键
	*/
	@Id
	@ApiModelProperty(required = true,value="主键" , notes = "主键" , example = "25593b52-1bf9-11ee-a48e-00163e1b60a7")
	private String id;
	
	/**
	 * 巡检点：巡检点
	*/
	@ApiModelProperty(required = false,value="巡检点" , notes = "巡检点" , example = "729333314053210112")
	private String pointId;
	
	/**
	 * 巡检项：巡检项
	*/
	@ApiModelProperty(required = false,value="巡检项" , notes = "巡检项" , example = "728973556154630145")
	private String itemId;
	
	/**
	 * 选择：选择
	*/
	@ApiModelProperty(required = false,value="选择" , notes = "选择" , example = "1688646736000")
	private String selectCode;
	
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
	public InspectionPointItem setId(String id) {
		this.id=id;
		return this;
	}
	
	/**
	 * 获得 巡检点<br>
	 * 巡检点
	 * @return 巡检点
	*/
	public String getPointId() {
		return pointId;
	}
	
	/**
	 * 设置 巡检点
	 * @param pointId 巡检点
	 * @return 当前对象
	*/
	public InspectionPointItem setPointId(String pointId) {
		this.pointId=pointId;
		return this;
	}
	
	/**
	 * 获得 巡检项<br>
	 * 巡检项
	 * @return 巡检项
	*/
	public String getItemId() {
		return itemId;
	}
	
	/**
	 * 设置 巡检项
	 * @param itemId 巡检项
	 * @return 当前对象
	*/
	public InspectionPointItem setItemId(String itemId) {
		this.itemId=itemId;
		return this;
	}
	
	/**
	 * 获得 选择<br>
	 * 选择
	 * @return 选择
	*/
	public String getSelectCode() {
		return selectCode;
	}
	
	/**
	 * 设置 选择
	 * @param selectCode 选择
	 * @return 当前对象
	*/
	public InspectionPointItem setSelectCode(String selectCode) {
		this.selectCode=selectCode;
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
	public InspectionPointItem setCreateBy(String createBy) {
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
	public InspectionPointItem setCreateTime(Date createTime) {
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
	public InspectionPointItem setUpdateBy(String updateBy) {
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
	public InspectionPointItem setUpdateTime(Date updateTime) {
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
	public InspectionPointItem setDeleted(Integer deleted) {
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
	public InspectionPointItem setDeleted(Boolean deletedBool) {
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
	public InspectionPointItem setDeleteBy(String deleteBy) {
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
	public InspectionPointItem setDeleteTime(Date deleteTime) {
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
	public InspectionPointItem setVersion(Integer version) {
		this.version=version;
		return this;
	}

	/**
	 * 将自己转换成指定类型的PO
	 * @param poType  PO类型
	 * @return InspectionPointItem , 转换好的 InspectionPointItem 对象
	*/
	@Transient
	public <T extends Entity> T toPO(Class<T> poType) {
		return EntityContext.create(poType, this);
	}

	/**
	 * 将自己转换成任意指定类型
	 * @param pojoType  Pojo类型
	 * @return InspectionPointItem , 转换好的 PoJo 对象
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
	public InspectionPointItem clone() {
		return duplicate(true);
	}

	/**
	 * 复制当前对象
	 * @param all 是否复制全部属性，当 false 时，仅复制来自数据表的属性
	*/
	@Transient
	public InspectionPointItem duplicate(boolean all) {
		com.dt.platform.domain.eam.meta.InspectionPointItemMeta.$$proxy$$ inst = new com.dt.platform.domain.eam.meta.InspectionPointItemMeta.$$proxy$$();
		inst.setItemId(this.getItemId());
		inst.setCreateBy(this.getCreateBy());
		inst.setDeleted(this.getDeleted());
		inst.setPointId(this.getPointId());
		inst.setCreateTime(this.getCreateTime());
		inst.setUpdateBy(this.getUpdateBy());
		inst.setDeleteTime(this.getDeleteTime());
		inst.setDeleteBy(this.getDeleteBy());
		inst.setUpdateTime(this.getUpdateTime());
		inst.setId(this.getId());
		inst.setSelectCode(this.getSelectCode());
		inst.setVersion(this.getVersion());
		inst.clearModifies();
		return inst;
	}

	/**
	 * 克隆当前对象
	*/
	@Transient
	public InspectionPointItem clone(boolean deep) {
		return EntityContext.clone(InspectionPointItem.class,this,deep);
	}

	/**
	 * 将 Map 转换成 InspectionPointItem
	 * @param inspectionPointItemMap 包含实体信息的 Map 对象
	 * @return InspectionPointItem , 转换好的的 InspectionPointItem 对象
	*/
	@Transient
	public static InspectionPointItem createFrom(Map<String,Object> inspectionPointItemMap) {
		if(inspectionPointItemMap==null) return null;
		InspectionPointItem po = create();
		EntityContext.copyProperties(po,inspectionPointItemMap);
		po.clearModifies();
		return po;
	}

	/**
	 * 将 Pojo 转换成 InspectionPointItem
	 * @param pojo 包含实体信息的 Pojo 对象
	 * @return InspectionPointItem , 转换好的的 InspectionPointItem 对象
	*/
	@Transient
	public static InspectionPointItem createFrom(Object pojo) {
		if(pojo==null) return null;
		InspectionPointItem po = create();
		EntityContext.copyProperties(po,pojo);
		po.clearModifies();
		return po;
	}

	/**
	 * 创建一个 InspectionPointItem，等同于 new
	 * @return InspectionPointItem 对象
	*/
	@Transient
	public static InspectionPointItem create() {
		return new com.dt.platform.domain.eam.meta.InspectionPointItemMeta.$$proxy$$();
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
			this.setItemId(DataParser.parse(String.class, map.get(InspectionPointItemMeta.ITEM_ID)));
			this.setCreateBy(DataParser.parse(String.class, map.get(InspectionPointItemMeta.CREATE_BY)));
			this.setDeleted(DataParser.parse(Integer.class, map.get(InspectionPointItemMeta.DELETED)));
			this.setPointId(DataParser.parse(String.class, map.get(InspectionPointItemMeta.POINT_ID)));
			this.setCreateTime(DataParser.parse(Date.class, map.get(InspectionPointItemMeta.CREATE_TIME)));
			this.setUpdateBy(DataParser.parse(String.class, map.get(InspectionPointItemMeta.UPDATE_BY)));
			this.setDeleteTime(DataParser.parse(Date.class, map.get(InspectionPointItemMeta.DELETE_TIME)));
			this.setDeleteBy(DataParser.parse(String.class, map.get(InspectionPointItemMeta.DELETE_BY)));
			this.setUpdateTime(DataParser.parse(Date.class, map.get(InspectionPointItemMeta.UPDATE_TIME)));
			this.setId(DataParser.parse(String.class, map.get(InspectionPointItemMeta.ID)));
			this.setSelectCode(DataParser.parse(String.class, map.get(InspectionPointItemMeta.SELECT_CODE)));
			this.setVersion(DataParser.parse(Integer.class, map.get(InspectionPointItemMeta.VERSION)));
			// others
			return true;
		} else {
			try {
				this.setItemId( (String)map.get(InspectionPointItemMeta.ITEM_ID));
				this.setCreateBy( (String)map.get(InspectionPointItemMeta.CREATE_BY));
				this.setDeleted( (Integer)map.get(InspectionPointItemMeta.DELETED));
				this.setPointId( (String)map.get(InspectionPointItemMeta.POINT_ID));
				this.setCreateTime( (Date)map.get(InspectionPointItemMeta.CREATE_TIME));
				this.setUpdateBy( (String)map.get(InspectionPointItemMeta.UPDATE_BY));
				this.setDeleteTime( (Date)map.get(InspectionPointItemMeta.DELETE_TIME));
				this.setDeleteBy( (String)map.get(InspectionPointItemMeta.DELETE_BY));
				this.setUpdateTime( (Date)map.get(InspectionPointItemMeta.UPDATE_TIME));
				this.setId( (String)map.get(InspectionPointItemMeta.ID));
				this.setSelectCode( (String)map.get(InspectionPointItemMeta.SELECT_CODE));
				this.setVersion( (Integer)map.get(InspectionPointItemMeta.VERSION));
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
			this.setItemId(DataParser.parse(String.class, r.getValue(InspectionPointItemMeta.ITEM_ID)));
			this.setCreateBy(DataParser.parse(String.class, r.getValue(InspectionPointItemMeta.CREATE_BY)));
			this.setDeleted(DataParser.parse(Integer.class, r.getValue(InspectionPointItemMeta.DELETED)));
			this.setPointId(DataParser.parse(String.class, r.getValue(InspectionPointItemMeta.POINT_ID)));
			this.setCreateTime(DataParser.parse(Date.class, r.getValue(InspectionPointItemMeta.CREATE_TIME)));
			this.setUpdateBy(DataParser.parse(String.class, r.getValue(InspectionPointItemMeta.UPDATE_BY)));
			this.setDeleteTime(DataParser.parse(Date.class, r.getValue(InspectionPointItemMeta.DELETE_TIME)));
			this.setDeleteBy(DataParser.parse(String.class, r.getValue(InspectionPointItemMeta.DELETE_BY)));
			this.setUpdateTime(DataParser.parse(Date.class, r.getValue(InspectionPointItemMeta.UPDATE_TIME)));
			this.setId(DataParser.parse(String.class, r.getValue(InspectionPointItemMeta.ID)));
			this.setSelectCode(DataParser.parse(String.class, r.getValue(InspectionPointItemMeta.SELECT_CODE)));
			this.setVersion(DataParser.parse(Integer.class, r.getValue(InspectionPointItemMeta.VERSION)));
			return true;
		} else {
			try {
				this.setItemId( (String)r.getValue(InspectionPointItemMeta.ITEM_ID));
				this.setCreateBy( (String)r.getValue(InspectionPointItemMeta.CREATE_BY));
				this.setDeleted( (Integer)r.getValue(InspectionPointItemMeta.DELETED));
				this.setPointId( (String)r.getValue(InspectionPointItemMeta.POINT_ID));
				this.setCreateTime( (Date)r.getValue(InspectionPointItemMeta.CREATE_TIME));
				this.setUpdateBy( (String)r.getValue(InspectionPointItemMeta.UPDATE_BY));
				this.setDeleteTime( (Date)r.getValue(InspectionPointItemMeta.DELETE_TIME));
				this.setDeleteBy( (String)r.getValue(InspectionPointItemMeta.DELETE_BY));
				this.setUpdateTime( (Date)r.getValue(InspectionPointItemMeta.UPDATE_TIME));
				this.setId( (String)r.getValue(InspectionPointItemMeta.ID));
				this.setSelectCode( (String)r.getValue(InspectionPointItemMeta.SELECT_CODE));
				this.setVersion( (Integer)r.getValue(InspectionPointItemMeta.VERSION));
				return true;
			} catch (Exception e) {
				return false;
			}
		}
	}
}