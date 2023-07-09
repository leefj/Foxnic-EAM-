package com.dt.platform.domain.eam;

import com.github.foxnic.dao.entity.Entity;
import io.swagger.annotations.ApiModel;
import javax.persistence.Table;
import com.github.foxnic.sql.meta.DBTable;
import com.dt.platform.constants.db.EAMTables.EAM_INSPECTION_POINT_OWNER;
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
import com.dt.platform.domain.eam.meta.InspectionPointOwnerMeta;
import com.github.foxnic.sql.data.ExprRcd;



/**
 * 巡检点
 * <p>巡检点 , 数据表 eam_inspection_point_owner 的PO类型</p>
 * @author 金杰 , maillank@qq.com
 * @since 2023-07-06 20:04:13
 * @sign AA4A15C565F05375AD9EAA119F11D0C5
 * 此文件由工具自动生成，请勿修改。若表结构或配置发生变动，请使用工具重新生成。
*/

@Table(name = "eam_inspection_point_owner")
@ApiModel(description = "巡检点 ; 巡检点 , 数据表 eam_inspection_point_owner 的PO类型")
public class InspectionPointOwner extends Entity {

	private static final long serialVersionUID = 1L;

	public static final DBTable TABLE =EAM_INSPECTION_POINT_OWNER.$TABLE;
	
	/**
	 * 主键：主键
	*/
	@Id
	@ApiModelProperty(required = true,value="主键" , notes = "主键" , example = "1c2c458b-1bd3-11ee-a48e-00163e1b60a7")
	private String id;
	
	/**
	 * 巡检计划：巡检计划
	*/
	@ApiModelProperty(required = false,value="巡检计划" , notes = "巡检计划" , example = "729365478572556288")
	private String ownerId;
	
	/**
	 * 巡检点：巡检点
	*/
	@ApiModelProperty(required = false,value="巡检点" , notes = "巡检点" , example = "729333314053210112")
	private String pointId;
	
	/**
	 * 排序：排序
	*/
	@ApiModelProperty(required = false,value="排序" , notes = "排序" , example = "0")
	private Integer sort;
	
	/**
	 * 备注：备注
	*/
	@ApiModelProperty(required = false,value="备注" , notes = "备注")
	private String notes;
	
	/**
	 * 选择：选择
	*/
	@ApiModelProperty(required = false,value="选择" , notes = "选择" , example = "1688630401000")
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
	@ApiModelProperty(required = false,value="租户" , notes = "租户")
	private String tenantId;
	
	/**
	 * version：version
	*/
	@ApiModelProperty(required = true,value="version" , notes = "version" , example = "1")
	private Integer version;
	
	/**
	 * inspectionPoint：inspectionPoint
	*/
	@ApiModelProperty(required = false,value="inspectionPoint" , notes = "inspectionPoint")
	private InspectionPoint inspectionPoint;
	
	/**
	 * checkItemList：checkItemList
	*/
	@ApiModelProperty(required = false,value="checkItemList" , notes = "checkItemList")
	private List<CheckItem> checkItemList;
	
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
	public InspectionPointOwner setId(String id) {
		this.id=id;
		return this;
	}
	
	/**
	 * 获得 巡检计划<br>
	 * 巡检计划
	 * @return 巡检计划
	*/
	public String getOwnerId() {
		return ownerId;
	}
	
	/**
	 * 设置 巡检计划
	 * @param ownerId 巡检计划
	 * @return 当前对象
	*/
	public InspectionPointOwner setOwnerId(String ownerId) {
		this.ownerId=ownerId;
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
	public InspectionPointOwner setPointId(String pointId) {
		this.pointId=pointId;
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
	public InspectionPointOwner setSort(Integer sort) {
		this.sort=sort;
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
	public InspectionPointOwner setNotes(String notes) {
		this.notes=notes;
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
	public InspectionPointOwner setSelectedCode(String selectedCode) {
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
	public InspectionPointOwner setCreateBy(String createBy) {
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
	public InspectionPointOwner setCreateTime(Date createTime) {
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
	public InspectionPointOwner setUpdateBy(String updateBy) {
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
	public InspectionPointOwner setUpdateTime(Date updateTime) {
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
	public InspectionPointOwner setDeleted(Integer deleted) {
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
	public InspectionPointOwner setDeleted(Boolean deletedBool) {
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
	public InspectionPointOwner setDeleteBy(String deleteBy) {
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
	public InspectionPointOwner setDeleteTime(Date deleteTime) {
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
	public InspectionPointOwner setTenantId(String tenantId) {
		this.tenantId=tenantId;
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
	public InspectionPointOwner setVersion(Integer version) {
		this.version=version;
		return this;
	}
	
	/**
	 * 获得 inspectionPoint<br>
	 * inspectionPoint
	 * @return inspectionPoint
	*/
	public InspectionPoint getInspectionPoint() {
		return inspectionPoint;
	}
	
	/**
	 * 设置 inspectionPoint
	 * @param inspectionPoint inspectionPoint
	 * @return 当前对象
	*/
	public InspectionPointOwner setInspectionPoint(InspectionPoint inspectionPoint) {
		this.inspectionPoint=inspectionPoint;
		return this;
	}
	
	/**
	 * 获得 checkItemList<br>
	 * checkItemList
	 * @return checkItemList
	*/
	public List<CheckItem> getCheckItemList() {
		return checkItemList;
	}
	
	/**
	 * 设置 checkItemList
	 * @param checkItemList checkItemList
	 * @return 当前对象
	*/
	public InspectionPointOwner setCheckItemList(List<CheckItem> checkItemList) {
		this.checkItemList=checkItemList;
		return this;
	}
	
	/**
	 * 添加 checkItemList
	 * @param checkItem checkItemList
	 * @return 当前对象
	*/
	public InspectionPointOwner addCheckItem(CheckItem... checkItem) {
		if(this.checkItemList==null) checkItemList=new ArrayList<>();
		this.checkItemList.addAll(Arrays.asList(checkItem));
		return this;
	}

	/**
	 * 将自己转换成指定类型的PO
	 * @param poType  PO类型
	 * @return InspectionPointOwner , 转换好的 InspectionPointOwner 对象
	*/
	@Transient
	public <T extends Entity> T toPO(Class<T> poType) {
		return EntityContext.create(poType, this);
	}

	/**
	 * 将自己转换成任意指定类型
	 * @param pojoType  Pojo类型
	 * @return InspectionPointOwner , 转换好的 PoJo 对象
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
	public InspectionPointOwner clone() {
		return duplicate(true);
	}

	/**
	 * 复制当前对象
	 * @param all 是否复制全部属性，当 false 时，仅复制来自数据表的属性
	*/
	@Transient
	public InspectionPointOwner duplicate(boolean all) {
		com.dt.platform.domain.eam.meta.InspectionPointOwnerMeta.$$proxy$$ inst = new com.dt.platform.domain.eam.meta.InspectionPointOwnerMeta.$$proxy$$();
		inst.setNotes(this.getNotes());
		inst.setUpdateTime(this.getUpdateTime());
		inst.setSort(this.getSort());
		inst.setOwnerId(this.getOwnerId());
		inst.setSelectedCode(this.getSelectedCode());
		inst.setVersion(this.getVersion());
		inst.setCreateBy(this.getCreateBy());
		inst.setDeleted(this.getDeleted());
		inst.setPointId(this.getPointId());
		inst.setCreateTime(this.getCreateTime());
		inst.setUpdateBy(this.getUpdateBy());
		inst.setDeleteTime(this.getDeleteTime());
		inst.setTenantId(this.getTenantId());
		inst.setDeleteBy(this.getDeleteBy());
		inst.setId(this.getId());
		if(all) {
			inst.setCheckItemList(this.getCheckItemList());
			inst.setInspectionPoint(this.getInspectionPoint());
		}
		inst.clearModifies();
		return inst;
	}

	/**
	 * 克隆当前对象
	*/
	@Transient
	public InspectionPointOwner clone(boolean deep) {
		return EntityContext.clone(InspectionPointOwner.class,this,deep);
	}

	/**
	 * 将 Map 转换成 InspectionPointOwner
	 * @param inspectionPointOwnerMap 包含实体信息的 Map 对象
	 * @return InspectionPointOwner , 转换好的的 InspectionPointOwner 对象
	*/
	@Transient
	public static InspectionPointOwner createFrom(Map<String,Object> inspectionPointOwnerMap) {
		if(inspectionPointOwnerMap==null) return null;
		InspectionPointOwner po = create();
		EntityContext.copyProperties(po,inspectionPointOwnerMap);
		po.clearModifies();
		return po;
	}

	/**
	 * 将 Pojo 转换成 InspectionPointOwner
	 * @param pojo 包含实体信息的 Pojo 对象
	 * @return InspectionPointOwner , 转换好的的 InspectionPointOwner 对象
	*/
	@Transient
	public static InspectionPointOwner createFrom(Object pojo) {
		if(pojo==null) return null;
		InspectionPointOwner po = create();
		EntityContext.copyProperties(po,pojo);
		po.clearModifies();
		return po;
	}

	/**
	 * 创建一个 InspectionPointOwner，等同于 new
	 * @return InspectionPointOwner 对象
	*/
	@Transient
	public static InspectionPointOwner create() {
		return new com.dt.platform.domain.eam.meta.InspectionPointOwnerMeta.$$proxy$$();
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
			this.setNotes(DataParser.parse(String.class, map.get(InspectionPointOwnerMeta.NOTES)));
			this.setUpdateTime(DataParser.parse(Date.class, map.get(InspectionPointOwnerMeta.UPDATE_TIME)));
			this.setSort(DataParser.parse(Integer.class, map.get(InspectionPointOwnerMeta.SORT)));
			this.setOwnerId(DataParser.parse(String.class, map.get(InspectionPointOwnerMeta.OWNER_ID)));
			this.setSelectedCode(DataParser.parse(String.class, map.get(InspectionPointOwnerMeta.SELECTED_CODE)));
			this.setVersion(DataParser.parse(Integer.class, map.get(InspectionPointOwnerMeta.VERSION)));
			this.setCreateBy(DataParser.parse(String.class, map.get(InspectionPointOwnerMeta.CREATE_BY)));
			this.setDeleted(DataParser.parse(Integer.class, map.get(InspectionPointOwnerMeta.DELETED)));
			this.setPointId(DataParser.parse(String.class, map.get(InspectionPointOwnerMeta.POINT_ID)));
			this.setCreateTime(DataParser.parse(Date.class, map.get(InspectionPointOwnerMeta.CREATE_TIME)));
			this.setUpdateBy(DataParser.parse(String.class, map.get(InspectionPointOwnerMeta.UPDATE_BY)));
			this.setDeleteTime(DataParser.parse(Date.class, map.get(InspectionPointOwnerMeta.DELETE_TIME)));
			this.setTenantId(DataParser.parse(String.class, map.get(InspectionPointOwnerMeta.TENANT_ID)));
			this.setDeleteBy(DataParser.parse(String.class, map.get(InspectionPointOwnerMeta.DELETE_BY)));
			this.setId(DataParser.parse(String.class, map.get(InspectionPointOwnerMeta.ID)));
			// others
			this.setInspectionPoint(DataParser.parse(InspectionPoint.class, map.get(InspectionPointOwnerMeta.INSPECTION_POINT)));
			return true;
		} else {
			try {
				this.setNotes( (String)map.get(InspectionPointOwnerMeta.NOTES));
				this.setUpdateTime( (Date)map.get(InspectionPointOwnerMeta.UPDATE_TIME));
				this.setSort( (Integer)map.get(InspectionPointOwnerMeta.SORT));
				this.setOwnerId( (String)map.get(InspectionPointOwnerMeta.OWNER_ID));
				this.setSelectedCode( (String)map.get(InspectionPointOwnerMeta.SELECTED_CODE));
				this.setVersion( (Integer)map.get(InspectionPointOwnerMeta.VERSION));
				this.setCreateBy( (String)map.get(InspectionPointOwnerMeta.CREATE_BY));
				this.setDeleted( (Integer)map.get(InspectionPointOwnerMeta.DELETED));
				this.setPointId( (String)map.get(InspectionPointOwnerMeta.POINT_ID));
				this.setCreateTime( (Date)map.get(InspectionPointOwnerMeta.CREATE_TIME));
				this.setUpdateBy( (String)map.get(InspectionPointOwnerMeta.UPDATE_BY));
				this.setDeleteTime( (Date)map.get(InspectionPointOwnerMeta.DELETE_TIME));
				this.setTenantId( (String)map.get(InspectionPointOwnerMeta.TENANT_ID));
				this.setDeleteBy( (String)map.get(InspectionPointOwnerMeta.DELETE_BY));
				this.setId( (String)map.get(InspectionPointOwnerMeta.ID));
				// others
				this.setInspectionPoint( (InspectionPoint)map.get(InspectionPointOwnerMeta.INSPECTION_POINT));
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
			this.setNotes(DataParser.parse(String.class, r.getValue(InspectionPointOwnerMeta.NOTES)));
			this.setUpdateTime(DataParser.parse(Date.class, r.getValue(InspectionPointOwnerMeta.UPDATE_TIME)));
			this.setSort(DataParser.parse(Integer.class, r.getValue(InspectionPointOwnerMeta.SORT)));
			this.setOwnerId(DataParser.parse(String.class, r.getValue(InspectionPointOwnerMeta.OWNER_ID)));
			this.setSelectedCode(DataParser.parse(String.class, r.getValue(InspectionPointOwnerMeta.SELECTED_CODE)));
			this.setVersion(DataParser.parse(Integer.class, r.getValue(InspectionPointOwnerMeta.VERSION)));
			this.setCreateBy(DataParser.parse(String.class, r.getValue(InspectionPointOwnerMeta.CREATE_BY)));
			this.setDeleted(DataParser.parse(Integer.class, r.getValue(InspectionPointOwnerMeta.DELETED)));
			this.setPointId(DataParser.parse(String.class, r.getValue(InspectionPointOwnerMeta.POINT_ID)));
			this.setCreateTime(DataParser.parse(Date.class, r.getValue(InspectionPointOwnerMeta.CREATE_TIME)));
			this.setUpdateBy(DataParser.parse(String.class, r.getValue(InspectionPointOwnerMeta.UPDATE_BY)));
			this.setDeleteTime(DataParser.parse(Date.class, r.getValue(InspectionPointOwnerMeta.DELETE_TIME)));
			this.setTenantId(DataParser.parse(String.class, r.getValue(InspectionPointOwnerMeta.TENANT_ID)));
			this.setDeleteBy(DataParser.parse(String.class, r.getValue(InspectionPointOwnerMeta.DELETE_BY)));
			this.setId(DataParser.parse(String.class, r.getValue(InspectionPointOwnerMeta.ID)));
			return true;
		} else {
			try {
				this.setNotes( (String)r.getValue(InspectionPointOwnerMeta.NOTES));
				this.setUpdateTime( (Date)r.getValue(InspectionPointOwnerMeta.UPDATE_TIME));
				this.setSort( (Integer)r.getValue(InspectionPointOwnerMeta.SORT));
				this.setOwnerId( (String)r.getValue(InspectionPointOwnerMeta.OWNER_ID));
				this.setSelectedCode( (String)r.getValue(InspectionPointOwnerMeta.SELECTED_CODE));
				this.setVersion( (Integer)r.getValue(InspectionPointOwnerMeta.VERSION));
				this.setCreateBy( (String)r.getValue(InspectionPointOwnerMeta.CREATE_BY));
				this.setDeleted( (Integer)r.getValue(InspectionPointOwnerMeta.DELETED));
				this.setPointId( (String)r.getValue(InspectionPointOwnerMeta.POINT_ID));
				this.setCreateTime( (Date)r.getValue(InspectionPointOwnerMeta.CREATE_TIME));
				this.setUpdateBy( (String)r.getValue(InspectionPointOwnerMeta.UPDATE_BY));
				this.setDeleteTime( (Date)r.getValue(InspectionPointOwnerMeta.DELETE_TIME));
				this.setTenantId( (String)r.getValue(InspectionPointOwnerMeta.TENANT_ID));
				this.setDeleteBy( (String)r.getValue(InspectionPointOwnerMeta.DELETE_BY));
				this.setId( (String)r.getValue(InspectionPointOwnerMeta.ID));
				return true;
			} catch (Exception e) {
				return false;
			}
		}
	}
}