package com.dt.platform.domain.eam;

import com.github.foxnic.dao.entity.Entity;
import io.swagger.annotations.ApiModel;
import javax.persistence.Table;
import com.github.foxnic.sql.meta.DBTable;
import com.dt.platform.constants.db.EAMTables.EAM_WAREHOUSE_POSITION;
import javax.persistence.Id;
import io.swagger.annotations.ApiModelProperty;
import java.util.Date;
import javax.persistence.Transient;
import com.github.foxnic.api.swagger.EnumFor;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.github.foxnic.commons.lang.DataParser;
import java.util.Map;
import com.github.foxnic.dao.entity.EntityContext;
import com.dt.platform.domain.eam.meta.WarehousePositionMeta;
import com.github.foxnic.sql.data.ExprRcd;



/**
 * 仓库库位
 * <p>仓库库位 , 数据表 eam_warehouse_position 的PO类型</p>
 * @author 金杰 , maillank@qq.com
 * @since 2024-04-26 19:14:27
 * @sign FCBC776D3541C27D4104A60F346A7CF3
 * 此文件由工具自动生成，请勿修改。若表结构或配置发生变动，请使用工具重新生成。
*/

@Table(name = "eam_warehouse_position")
@ApiModel(description = "仓库库位 ; 仓库库位 , 数据表 eam_warehouse_position 的PO类型")
public class WarehousePosition extends Entity {

	private static final long serialVersionUID = 1L;

	public static final DBTable TABLE =EAM_WAREHOUSE_POSITION.$TABLE;
	
	/**
	 * 主键：主键
	*/
	@Id
	@ApiModelProperty(required = true,value="主键" , notes = "主键" , example = "558599358870716416")
	private String id;
	
	/**
	 * 仓库：仓库
	*/
	@ApiModelProperty(required = false,value="仓库" , notes = "仓库" , example = "558599358870716416")
	private String warehouseId;
	
	/**
	 * 编码：编码
	*/
	@ApiModelProperty(required = false,value="编码" , notes = "编码" , example = "def")
	private String code;
	
	/**
	 * 全称：全称
	*/
	@ApiModelProperty(required = false,value="全称" , notes = "全称" , example = "上海仓库/默认库存")
	private String fullName;
	
	/**
	 * 库位：库位
	*/
	@ApiModelProperty(required = false,value="库位" , notes = "库位" , example = "默认库存")
	private String name;
	
	/**
	 * 最大容量：最大容量
	*/
	@ApiModelProperty(required = false,value="最大容量" , notes = "最大容量" , example = "2000")
	private Integer maximumCapacity;
	
	/**
	 * 备注：备注
	*/
	@ApiModelProperty(required = false,value="备注" , notes = "备注" , example = "默认库存")
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
	 * warehouse：warehouse
	*/
	@ApiModelProperty(required = false,value="warehouse" , notes = "warehouse")
	private Warehouse warehouse;
	
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
	public WarehousePosition setId(String id) {
		this.id=id;
		return this;
	}
	
	/**
	 * 获得 仓库<br>
	 * 仓库
	 * @return 仓库
	*/
	public String getWarehouseId() {
		return warehouseId;
	}
	
	/**
	 * 设置 仓库
	 * @param warehouseId 仓库
	 * @return 当前对象
	*/
	public WarehousePosition setWarehouseId(String warehouseId) {
		this.warehouseId=warehouseId;
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
	public WarehousePosition setCode(String code) {
		this.code=code;
		return this;
	}
	
	/**
	 * 获得 全称<br>
	 * 全称
	 * @return 全称
	*/
	public String getFullName() {
		return fullName;
	}
	
	/**
	 * 设置 全称
	 * @param fullName 全称
	 * @return 当前对象
	*/
	public WarehousePosition setFullName(String fullName) {
		this.fullName=fullName;
		return this;
	}
	
	/**
	 * 获得 库位<br>
	 * 库位
	 * @return 库位
	*/
	public String getName() {
		return name;
	}
	
	/**
	 * 设置 库位
	 * @param name 库位
	 * @return 当前对象
	*/
	public WarehousePosition setName(String name) {
		this.name=name;
		return this;
	}
	
	/**
	 * 获得 最大容量<br>
	 * 最大容量
	 * @return 最大容量
	*/
	public Integer getMaximumCapacity() {
		return maximumCapacity;
	}
	
	/**
	 * 设置 最大容量
	 * @param maximumCapacity 最大容量
	 * @return 当前对象
	*/
	public WarehousePosition setMaximumCapacity(Integer maximumCapacity) {
		this.maximumCapacity=maximumCapacity;
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
	public WarehousePosition setNotes(String notes) {
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
	public WarehousePosition setCreateBy(String createBy) {
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
	public WarehousePosition setCreateTime(Date createTime) {
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
	public WarehousePosition setUpdateBy(String updateBy) {
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
	public WarehousePosition setUpdateTime(Date updateTime) {
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
	public WarehousePosition setDeleted(Integer deleted) {
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
	public WarehousePosition setDeleted(Boolean deletedBool) {
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
	public WarehousePosition setDeleteBy(String deleteBy) {
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
	public WarehousePosition setDeleteTime(Date deleteTime) {
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
	public WarehousePosition setVersion(Integer version) {
		this.version=version;
		return this;
	}
	
	/**
	 * 获得 warehouse<br>
	 * warehouse
	 * @return warehouse
	*/
	public Warehouse getWarehouse() {
		return warehouse;
	}
	
	/**
	 * 设置 warehouse
	 * @param warehouse warehouse
	 * @return 当前对象
	*/
	public WarehousePosition setWarehouse(Warehouse warehouse) {
		this.warehouse=warehouse;
		return this;
	}

	/**
	 * 将自己转换成指定类型的PO
	 * @param poType  PO类型
	 * @return WarehousePosition , 转换好的 WarehousePosition 对象
	*/
	@Transient
	public <T extends Entity> T toPO(Class<T> poType) {
		return EntityContext.create(poType, this);
	}

	/**
	 * 将自己转换成任意指定类型
	 * @param pojoType  Pojo类型
	 * @return WarehousePosition , 转换好的 PoJo 对象
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
	public WarehousePosition clone() {
		return duplicate(true);
	}

	/**
	 * 复制当前对象
	 * @param all 是否复制全部属性，当 false 时，仅复制来自数据表的属性
	*/
	@Transient
	public WarehousePosition duplicate(boolean all) {
		com.dt.platform.domain.eam.meta.WarehousePositionMeta.$$proxy$$ inst = new com.dt.platform.domain.eam.meta.WarehousePositionMeta.$$proxy$$();
		inst.setCode(this.getCode());
		inst.setNotes(this.getNotes());
		inst.setFullName(this.getFullName());
		inst.setUpdateTime(this.getUpdateTime());
		inst.setVersion(this.getVersion());
		inst.setCreateBy(this.getCreateBy());
		inst.setDeleted(this.getDeleted());
		inst.setWarehouseId(this.getWarehouseId());
		inst.setCreateTime(this.getCreateTime());
		inst.setUpdateBy(this.getUpdateBy());
		inst.setDeleteTime(this.getDeleteTime());
		inst.setName(this.getName());
		inst.setDeleteBy(this.getDeleteBy());
		inst.setId(this.getId());
		inst.setMaximumCapacity(this.getMaximumCapacity());
		if(all) {
			inst.setWarehouse(this.getWarehouse());
		}
		inst.clearModifies();
		return inst;
	}

	/**
	 * 克隆当前对象
	*/
	@Transient
	public WarehousePosition clone(boolean deep) {
		return EntityContext.clone(WarehousePosition.class,this,deep);
	}

	/**
	 * 将 Map 转换成 WarehousePosition
	 * @param warehousePositionMap 包含实体信息的 Map 对象
	 * @return WarehousePosition , 转换好的的 WarehousePosition 对象
	*/
	@Transient
	public static WarehousePosition createFrom(Map<String,Object> warehousePositionMap) {
		if(warehousePositionMap==null) return null;
		WarehousePosition po = create();
		EntityContext.copyProperties(po,warehousePositionMap);
		po.clearModifies();
		return po;
	}

	/**
	 * 将 Pojo 转换成 WarehousePosition
	 * @param pojo 包含实体信息的 Pojo 对象
	 * @return WarehousePosition , 转换好的的 WarehousePosition 对象
	*/
	@Transient
	public static WarehousePosition createFrom(Object pojo) {
		if(pojo==null) return null;
		WarehousePosition po = create();
		EntityContext.copyProperties(po,pojo);
		po.clearModifies();
		return po;
	}

	/**
	 * 创建一个 WarehousePosition，等同于 new
	 * @return WarehousePosition 对象
	*/
	@Transient
	public static WarehousePosition create() {
		return new com.dt.platform.domain.eam.meta.WarehousePositionMeta.$$proxy$$();
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
			this.setCode(DataParser.parse(String.class, map.get(WarehousePositionMeta.CODE)));
			this.setNotes(DataParser.parse(String.class, map.get(WarehousePositionMeta.NOTES)));
			this.setFullName(DataParser.parse(String.class, map.get(WarehousePositionMeta.FULL_NAME)));
			this.setUpdateTime(DataParser.parse(Date.class, map.get(WarehousePositionMeta.UPDATE_TIME)));
			this.setVersion(DataParser.parse(Integer.class, map.get(WarehousePositionMeta.VERSION)));
			this.setCreateBy(DataParser.parse(String.class, map.get(WarehousePositionMeta.CREATE_BY)));
			this.setDeleted(DataParser.parse(Integer.class, map.get(WarehousePositionMeta.DELETED)));
			this.setWarehouseId(DataParser.parse(String.class, map.get(WarehousePositionMeta.WAREHOUSE_ID)));
			this.setCreateTime(DataParser.parse(Date.class, map.get(WarehousePositionMeta.CREATE_TIME)));
			this.setUpdateBy(DataParser.parse(String.class, map.get(WarehousePositionMeta.UPDATE_BY)));
			this.setDeleteTime(DataParser.parse(Date.class, map.get(WarehousePositionMeta.DELETE_TIME)));
			this.setName(DataParser.parse(String.class, map.get(WarehousePositionMeta.NAME)));
			this.setDeleteBy(DataParser.parse(String.class, map.get(WarehousePositionMeta.DELETE_BY)));
			this.setId(DataParser.parse(String.class, map.get(WarehousePositionMeta.ID)));
			this.setMaximumCapacity(DataParser.parse(Integer.class, map.get(WarehousePositionMeta.MAXIMUM_CAPACITY)));
			// others
			this.setWarehouse(DataParser.parse(Warehouse.class, map.get(WarehousePositionMeta.WAREHOUSE)));
			return true;
		} else {
			try {
				this.setCode( (String)map.get(WarehousePositionMeta.CODE));
				this.setNotes( (String)map.get(WarehousePositionMeta.NOTES));
				this.setFullName( (String)map.get(WarehousePositionMeta.FULL_NAME));
				this.setUpdateTime( (Date)map.get(WarehousePositionMeta.UPDATE_TIME));
				this.setVersion( (Integer)map.get(WarehousePositionMeta.VERSION));
				this.setCreateBy( (String)map.get(WarehousePositionMeta.CREATE_BY));
				this.setDeleted( (Integer)map.get(WarehousePositionMeta.DELETED));
				this.setWarehouseId( (String)map.get(WarehousePositionMeta.WAREHOUSE_ID));
				this.setCreateTime( (Date)map.get(WarehousePositionMeta.CREATE_TIME));
				this.setUpdateBy( (String)map.get(WarehousePositionMeta.UPDATE_BY));
				this.setDeleteTime( (Date)map.get(WarehousePositionMeta.DELETE_TIME));
				this.setName( (String)map.get(WarehousePositionMeta.NAME));
				this.setDeleteBy( (String)map.get(WarehousePositionMeta.DELETE_BY));
				this.setId( (String)map.get(WarehousePositionMeta.ID));
				this.setMaximumCapacity( (Integer)map.get(WarehousePositionMeta.MAXIMUM_CAPACITY));
				// others
				this.setWarehouse( (Warehouse)map.get(WarehousePositionMeta.WAREHOUSE));
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
			this.setCode(DataParser.parse(String.class, r.getValue(WarehousePositionMeta.CODE)));
			this.setNotes(DataParser.parse(String.class, r.getValue(WarehousePositionMeta.NOTES)));
			this.setFullName(DataParser.parse(String.class, r.getValue(WarehousePositionMeta.FULL_NAME)));
			this.setUpdateTime(DataParser.parse(Date.class, r.getValue(WarehousePositionMeta.UPDATE_TIME)));
			this.setVersion(DataParser.parse(Integer.class, r.getValue(WarehousePositionMeta.VERSION)));
			this.setCreateBy(DataParser.parse(String.class, r.getValue(WarehousePositionMeta.CREATE_BY)));
			this.setDeleted(DataParser.parse(Integer.class, r.getValue(WarehousePositionMeta.DELETED)));
			this.setWarehouseId(DataParser.parse(String.class, r.getValue(WarehousePositionMeta.WAREHOUSE_ID)));
			this.setCreateTime(DataParser.parse(Date.class, r.getValue(WarehousePositionMeta.CREATE_TIME)));
			this.setUpdateBy(DataParser.parse(String.class, r.getValue(WarehousePositionMeta.UPDATE_BY)));
			this.setDeleteTime(DataParser.parse(Date.class, r.getValue(WarehousePositionMeta.DELETE_TIME)));
			this.setName(DataParser.parse(String.class, r.getValue(WarehousePositionMeta.NAME)));
			this.setDeleteBy(DataParser.parse(String.class, r.getValue(WarehousePositionMeta.DELETE_BY)));
			this.setId(DataParser.parse(String.class, r.getValue(WarehousePositionMeta.ID)));
			this.setMaximumCapacity(DataParser.parse(Integer.class, r.getValue(WarehousePositionMeta.MAXIMUM_CAPACITY)));
			return true;
		} else {
			try {
				this.setCode( (String)r.getValue(WarehousePositionMeta.CODE));
				this.setNotes( (String)r.getValue(WarehousePositionMeta.NOTES));
				this.setFullName( (String)r.getValue(WarehousePositionMeta.FULL_NAME));
				this.setUpdateTime( (Date)r.getValue(WarehousePositionMeta.UPDATE_TIME));
				this.setVersion( (Integer)r.getValue(WarehousePositionMeta.VERSION));
				this.setCreateBy( (String)r.getValue(WarehousePositionMeta.CREATE_BY));
				this.setDeleted( (Integer)r.getValue(WarehousePositionMeta.DELETED));
				this.setWarehouseId( (String)r.getValue(WarehousePositionMeta.WAREHOUSE_ID));
				this.setCreateTime( (Date)r.getValue(WarehousePositionMeta.CREATE_TIME));
				this.setUpdateBy( (String)r.getValue(WarehousePositionMeta.UPDATE_BY));
				this.setDeleteTime( (Date)r.getValue(WarehousePositionMeta.DELETE_TIME));
				this.setName( (String)r.getValue(WarehousePositionMeta.NAME));
				this.setDeleteBy( (String)r.getValue(WarehousePositionMeta.DELETE_BY));
				this.setId( (String)r.getValue(WarehousePositionMeta.ID));
				this.setMaximumCapacity( (Integer)r.getValue(WarehousePositionMeta.MAXIMUM_CAPACITY));
				return true;
			} catch (Exception e) {
				return false;
			}
		}
	}
}