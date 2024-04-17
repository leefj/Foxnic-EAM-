package com.dt.platform.domain.eam;

import com.github.foxnic.dao.entity.Entity;
import io.swagger.annotations.ApiModel;
import javax.persistence.Table;
import com.github.foxnic.sql.meta.DBTable;
import com.dt.platform.constants.db.EAMTables.EAM_WAREHOUSE;
import javax.persistence.Id;
import io.swagger.annotations.ApiModelProperty;
import java.util.Date;
import javax.persistence.Transient;
import com.github.foxnic.api.swagger.EnumFor;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.github.foxnic.commons.lang.DataParser;
import java.util.Map;
import com.github.foxnic.dao.entity.EntityContext;
import com.dt.platform.domain.eam.meta.WarehouseMeta;
import com.github.foxnic.sql.data.ExprRcd;



/**
 * 仓库
 * <p>仓库 , 数据表 eam_warehouse 的PO类型</p>
 * @author 金杰 , maillank@qq.com
 * @since 2024-04-17 18:36:10
 * @sign 78605464C80109C601CBB817915F56AE
 * 此文件由工具自动生成，请勿修改。若表结构或配置发生变动，请使用工具重新生成。
*/

@Table(name = "eam_warehouse")
@ApiModel(description = "仓库 ; 仓库 , 数据表 eam_warehouse 的PO类型")
public class Warehouse extends Entity {

	private static final long serialVersionUID = 1L;

	public static final DBTable TABLE =EAM_WAREHOUSE.$TABLE;
	
	/**
	 * 主键：主键
	*/
	@Id
	@ApiModelProperty(required = true,value="主键" , notes = "主键" , example = "558599358870716416")
	private String id;
	
	/**
	 * 编号：编号
	*/
	@ApiModelProperty(required = false,value="编号" , notes = "编号" , example = "c1")
	private String code;
	
	/**
	 * 状态：状态
	*/
	@ApiModelProperty(required = false,value="状态" , notes = "状态" , example = "enable")
	private String status;
	
	/**
	 * 名称：名称
	*/
	@ApiModelProperty(required = false,value="名称" , notes = "名称" , example = "上海仓库")
	private String warehouseName;
	
	/**
	 * 备注：备注
	*/
	@ApiModelProperty(required = false,value="备注" , notes = "备注" , example = "上海仓库")
	private String warehouseNotes;
	
	/**
	 * 创建人ID：创建人ID
	*/
	@ApiModelProperty(required = false,value="创建人ID" , notes = "创建人ID" , example = "110588348101165911")
	private String createBy;
	
	/**
	 * 创建时间：创建时间
	*/
	@ApiModelProperty(required = false,value="创建时间" , notes = "创建时间" , example = "2022-03-22 10:34:25")
	private Date createTime;
	
	/**
	 * 修改人ID：修改人ID
	*/
	@ApiModelProperty(required = false,value="修改人ID" , notes = "修改人ID" , example = "110588348101165911")
	private String updateBy;
	
	/**
	 * 修改时间：修改时间
	*/
	@ApiModelProperty(required = false,value="修改时间" , notes = "修改时间" , example = "2022-06-21 12:38:06")
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
	@ApiModelProperty(required = true,value="version" , notes = "version" , example = "4")
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
	public Warehouse setId(String id) {
		this.id=id;
		return this;
	}
	
	/**
	 * 获得 编号<br>
	 * 编号
	 * @return 编号
	*/
	public String getCode() {
		return code;
	}
	
	/**
	 * 设置 编号
	 * @param code 编号
	 * @return 当前对象
	*/
	public Warehouse setCode(String code) {
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
	public Warehouse setStatus(String status) {
		this.status=status;
		return this;
	}
	
	/**
	 * 获得 名称<br>
	 * 名称
	 * @return 名称
	*/
	public String getWarehouseName() {
		return warehouseName;
	}
	
	/**
	 * 设置 名称
	 * @param warehouseName 名称
	 * @return 当前对象
	*/
	public Warehouse setWarehouseName(String warehouseName) {
		this.warehouseName=warehouseName;
		return this;
	}
	
	/**
	 * 获得 备注<br>
	 * 备注
	 * @return 备注
	*/
	public String getWarehouseNotes() {
		return warehouseNotes;
	}
	
	/**
	 * 设置 备注
	 * @param warehouseNotes 备注
	 * @return 当前对象
	*/
	public Warehouse setWarehouseNotes(String warehouseNotes) {
		this.warehouseNotes=warehouseNotes;
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
	public Warehouse setCreateBy(String createBy) {
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
	public Warehouse setCreateTime(Date createTime) {
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
	public Warehouse setUpdateBy(String updateBy) {
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
	public Warehouse setUpdateTime(Date updateTime) {
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
	public Warehouse setDeleted(Integer deleted) {
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
	public Warehouse setDeleted(Boolean deletedBool) {
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
	public Warehouse setDeleteBy(String deleteBy) {
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
	public Warehouse setDeleteTime(Date deleteTime) {
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
	public Warehouse setVersion(Integer version) {
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
	public Warehouse setTenantId(String tenantId) {
		this.tenantId=tenantId;
		return this;
	}

	/**
	 * 将自己转换成指定类型的PO
	 * @param poType  PO类型
	 * @return Warehouse , 转换好的 Warehouse 对象
	*/
	@Transient
	public <T extends Entity> T toPO(Class<T> poType) {
		return EntityContext.create(poType, this);
	}

	/**
	 * 将自己转换成任意指定类型
	 * @param pojoType  Pojo类型
	 * @return Warehouse , 转换好的 PoJo 对象
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
	public Warehouse clone() {
		return duplicate(true);
	}

	/**
	 * 复制当前对象
	 * @param all 是否复制全部属性，当 false 时，仅复制来自数据表的属性
	*/
	@Transient
	public Warehouse duplicate(boolean all) {
		com.dt.platform.domain.eam.meta.WarehouseMeta.$$proxy$$ inst = new com.dt.platform.domain.eam.meta.WarehouseMeta.$$proxy$$();
		inst.setCode(this.getCode());
		inst.setUpdateTime(this.getUpdateTime());
		inst.setWarehouseName(this.getWarehouseName());
		inst.setVersion(this.getVersion());
		inst.setCreateBy(this.getCreateBy());
		inst.setDeleted(this.getDeleted());
		inst.setCreateTime(this.getCreateTime());
		inst.setUpdateBy(this.getUpdateBy());
		inst.setDeleteTime(this.getDeleteTime());
		inst.setTenantId(this.getTenantId());
		inst.setDeleteBy(this.getDeleteBy());
		inst.setId(this.getId());
		inst.setWarehouseNotes(this.getWarehouseNotes());
		inst.setStatus(this.getStatus());
		inst.clearModifies();
		return inst;
	}

	/**
	 * 克隆当前对象
	*/
	@Transient
	public Warehouse clone(boolean deep) {
		return EntityContext.clone(Warehouse.class,this,deep);
	}

	/**
	 * 将 Map 转换成 Warehouse
	 * @param warehouseMap 包含实体信息的 Map 对象
	 * @return Warehouse , 转换好的的 Warehouse 对象
	*/
	@Transient
	public static Warehouse createFrom(Map<String,Object> warehouseMap) {
		if(warehouseMap==null) return null;
		Warehouse po = create();
		EntityContext.copyProperties(po,warehouseMap);
		po.clearModifies();
		return po;
	}

	/**
	 * 将 Pojo 转换成 Warehouse
	 * @param pojo 包含实体信息的 Pojo 对象
	 * @return Warehouse , 转换好的的 Warehouse 对象
	*/
	@Transient
	public static Warehouse createFrom(Object pojo) {
		if(pojo==null) return null;
		Warehouse po = create();
		EntityContext.copyProperties(po,pojo);
		po.clearModifies();
		return po;
	}

	/**
	 * 创建一个 Warehouse，等同于 new
	 * @return Warehouse 对象
	*/
	@Transient
	public static Warehouse create() {
		return new com.dt.platform.domain.eam.meta.WarehouseMeta.$$proxy$$();
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
			this.setCode(DataParser.parse(String.class, map.get(WarehouseMeta.CODE)));
			this.setUpdateTime(DataParser.parse(Date.class, map.get(WarehouseMeta.UPDATE_TIME)));
			this.setWarehouseName(DataParser.parse(String.class, map.get(WarehouseMeta.WAREHOUSE_NAME)));
			this.setVersion(DataParser.parse(Integer.class, map.get(WarehouseMeta.VERSION)));
			this.setCreateBy(DataParser.parse(String.class, map.get(WarehouseMeta.CREATE_BY)));
			this.setDeleted(DataParser.parse(Integer.class, map.get(WarehouseMeta.DELETED)));
			this.setCreateTime(DataParser.parse(Date.class, map.get(WarehouseMeta.CREATE_TIME)));
			this.setUpdateBy(DataParser.parse(String.class, map.get(WarehouseMeta.UPDATE_BY)));
			this.setDeleteTime(DataParser.parse(Date.class, map.get(WarehouseMeta.DELETE_TIME)));
			this.setTenantId(DataParser.parse(String.class, map.get(WarehouseMeta.TENANT_ID)));
			this.setDeleteBy(DataParser.parse(String.class, map.get(WarehouseMeta.DELETE_BY)));
			this.setId(DataParser.parse(String.class, map.get(WarehouseMeta.ID)));
			this.setWarehouseNotes(DataParser.parse(String.class, map.get(WarehouseMeta.WAREHOUSE_NOTES)));
			this.setStatus(DataParser.parse(String.class, map.get(WarehouseMeta.STATUS)));
			// others
			return true;
		} else {
			try {
				this.setCode( (String)map.get(WarehouseMeta.CODE));
				this.setUpdateTime( (Date)map.get(WarehouseMeta.UPDATE_TIME));
				this.setWarehouseName( (String)map.get(WarehouseMeta.WAREHOUSE_NAME));
				this.setVersion( (Integer)map.get(WarehouseMeta.VERSION));
				this.setCreateBy( (String)map.get(WarehouseMeta.CREATE_BY));
				this.setDeleted( (Integer)map.get(WarehouseMeta.DELETED));
				this.setCreateTime( (Date)map.get(WarehouseMeta.CREATE_TIME));
				this.setUpdateBy( (String)map.get(WarehouseMeta.UPDATE_BY));
				this.setDeleteTime( (Date)map.get(WarehouseMeta.DELETE_TIME));
				this.setTenantId( (String)map.get(WarehouseMeta.TENANT_ID));
				this.setDeleteBy( (String)map.get(WarehouseMeta.DELETE_BY));
				this.setId( (String)map.get(WarehouseMeta.ID));
				this.setWarehouseNotes( (String)map.get(WarehouseMeta.WAREHOUSE_NOTES));
				this.setStatus( (String)map.get(WarehouseMeta.STATUS));
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
			this.setCode(DataParser.parse(String.class, r.getValue(WarehouseMeta.CODE)));
			this.setUpdateTime(DataParser.parse(Date.class, r.getValue(WarehouseMeta.UPDATE_TIME)));
			this.setWarehouseName(DataParser.parse(String.class, r.getValue(WarehouseMeta.WAREHOUSE_NAME)));
			this.setVersion(DataParser.parse(Integer.class, r.getValue(WarehouseMeta.VERSION)));
			this.setCreateBy(DataParser.parse(String.class, r.getValue(WarehouseMeta.CREATE_BY)));
			this.setDeleted(DataParser.parse(Integer.class, r.getValue(WarehouseMeta.DELETED)));
			this.setCreateTime(DataParser.parse(Date.class, r.getValue(WarehouseMeta.CREATE_TIME)));
			this.setUpdateBy(DataParser.parse(String.class, r.getValue(WarehouseMeta.UPDATE_BY)));
			this.setDeleteTime(DataParser.parse(Date.class, r.getValue(WarehouseMeta.DELETE_TIME)));
			this.setTenantId(DataParser.parse(String.class, r.getValue(WarehouseMeta.TENANT_ID)));
			this.setDeleteBy(DataParser.parse(String.class, r.getValue(WarehouseMeta.DELETE_BY)));
			this.setId(DataParser.parse(String.class, r.getValue(WarehouseMeta.ID)));
			this.setWarehouseNotes(DataParser.parse(String.class, r.getValue(WarehouseMeta.WAREHOUSE_NOTES)));
			this.setStatus(DataParser.parse(String.class, r.getValue(WarehouseMeta.STATUS)));
			return true;
		} else {
			try {
				this.setCode( (String)r.getValue(WarehouseMeta.CODE));
				this.setUpdateTime( (Date)r.getValue(WarehouseMeta.UPDATE_TIME));
				this.setWarehouseName( (String)r.getValue(WarehouseMeta.WAREHOUSE_NAME));
				this.setVersion( (Integer)r.getValue(WarehouseMeta.VERSION));
				this.setCreateBy( (String)r.getValue(WarehouseMeta.CREATE_BY));
				this.setDeleted( (Integer)r.getValue(WarehouseMeta.DELETED));
				this.setCreateTime( (Date)r.getValue(WarehouseMeta.CREATE_TIME));
				this.setUpdateBy( (String)r.getValue(WarehouseMeta.UPDATE_BY));
				this.setDeleteTime( (Date)r.getValue(WarehouseMeta.DELETE_TIME));
				this.setTenantId( (String)r.getValue(WarehouseMeta.TENANT_ID));
				this.setDeleteBy( (String)r.getValue(WarehouseMeta.DELETE_BY));
				this.setId( (String)r.getValue(WarehouseMeta.ID));
				this.setWarehouseNotes( (String)r.getValue(WarehouseMeta.WAREHOUSE_NOTES));
				this.setStatus( (String)r.getValue(WarehouseMeta.STATUS));
				return true;
			} catch (Exception e) {
				return false;
			}
		}
	}
}