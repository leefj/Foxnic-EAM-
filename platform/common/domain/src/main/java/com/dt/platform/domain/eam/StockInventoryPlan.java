package com.dt.platform.domain.eam;

import com.github.foxnic.dao.entity.Entity;
import io.swagger.annotations.ApiModel;
import javax.persistence.Table;
import com.github.foxnic.sql.meta.DBTable;
import com.dt.platform.constants.db.EAMTables.EAM_STOCK_INVENTORY_PLAN;
import javax.persistence.Id;
import io.swagger.annotations.ApiModelProperty;
import java.util.Date;
import javax.persistence.Transient;
import com.github.foxnic.api.swagger.EnumFor;
import org.github.foxnic.web.domain.system.DictItem;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.github.foxnic.commons.lang.DataParser;
import java.util.Map;
import com.github.foxnic.dao.entity.EntityContext;
import com.dt.platform.domain.eam.meta.StockInventoryPlanMeta;
import com.github.foxnic.sql.data.ExprRcd;



/**
 * 盘点计划2
 * <p>盘点计划2 , 数据表 eam_stock_inventory_plan 的PO类型</p>
 * @author 金杰 , maillank@qq.com
 * @since 2024-05-05 17:18:50
 * @sign 2956D4D171E14C03F97FA2C57E475E31
 * 此文件由工具自动生成，请勿修改。若表结构或配置发生变动，请使用工具重新生成。
*/

@Table(name = "eam_stock_inventory_plan")
@ApiModel(description = "盘点计划2 ; 盘点计划2 , 数据表 eam_stock_inventory_plan 的PO类型")
public class StockInventoryPlan extends Entity {

	private static final long serialVersionUID = 1L;

	public static final DBTable TABLE =EAM_STOCK_INVENTORY_PLAN.$TABLE;
	
	/**
	 * 主键：主键
	*/
	@Id
	@ApiModelProperty(required = true,value="主键" , notes = "主键" , example = "839043042928230400")
	private String id;
	
	/**
	 * 计划名称：计划名称
	*/
	@ApiModelProperty(required = false,value="计划名称" , notes = "计划名称" , example = "1234")
	private String name;
	
	/**
	 * 归属：归属
	*/
	@ApiModelProperty(required = false,value="归属" , notes = "归属")
	private String ownerCode;
	
	/**
	 * 启用状态：启用状态
	*/
	@ApiModelProperty(required = false,value="启用状态" , notes = "启用状态" , example = "enable")
	private String status;
	
	/**
	 * 计划类型：计划类型
	*/
	@ApiModelProperty(required = false,value="计划类型" , notes = "计划类型" , example = "plan")
	private String planType;
	
	/**
	 * 模板：模板
	*/
	@ApiModelProperty(required = false,value="模板" , notes = "模板")
	private String tplId;
	
	/**
	 * 备注：备注
	*/
	@ApiModelProperty(required = false,value="备注" , notes = "备注" , example = "kj")
	private String notes;
	
	/**
	 * 创建人ID：创建人ID
	*/
	@ApiModelProperty(required = false,value="创建人ID" , notes = "创建人ID" , example = "110588348101165911")
	private String createBy;
	
	/**
	 * 创建时间：创建时间
	*/
	@ApiModelProperty(required = false,value="创建时间" , notes = "创建时间" , example = "2024-05-04 07:37:30")
	private Date createTime;
	
	/**
	 * 修改人ID：修改人ID
	*/
	@ApiModelProperty(required = false,value="修改人ID" , notes = "修改人ID" , example = "110588348101165911")
	private String updateBy;
	
	/**
	 * 修改时间：修改时间
	*/
	@ApiModelProperty(required = false,value="修改时间" , notes = "修改时间" , example = "2024-05-04 08:32:44")
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
	 * 数据版本号：数据版本号
	*/
	@ApiModelProperty(required = true,value="数据版本号" , notes = "数据版本号" , example = "2")
	private Integer version;
	
	/**
	 * 租户：租户
	*/
	@ApiModelProperty(required = false,value="租户" , notes = "租户" , example = "T001")
	private String tenantId;
	
	/**
	 * 盘点任务：盘点任务
	*/
	@ApiModelProperty(required = false,value="盘点任务" , notes = "盘点任务")
	private StockInventoryTask inventoryTask;
	
	/**
	 * 盘点类型：盘点类型
	*/
	@ApiModelProperty(required = false,value="盘点类型" , notes = "盘点类型")
	private DictItem inventoryPlanType;
	
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
	public StockInventoryPlan setId(String id) {
		this.id=id;
		return this;
	}
	
	/**
	 * 获得 计划名称<br>
	 * 计划名称
	 * @return 计划名称
	*/
	public String getName() {
		return name;
	}
	
	/**
	 * 设置 计划名称
	 * @param name 计划名称
	 * @return 当前对象
	*/
	public StockInventoryPlan setName(String name) {
		this.name=name;
		return this;
	}
	
	/**
	 * 获得 归属<br>
	 * 归属
	 * @return 归属
	*/
	public String getOwnerCode() {
		return ownerCode;
	}
	
	/**
	 * 设置 归属
	 * @param ownerCode 归属
	 * @return 当前对象
	*/
	public StockInventoryPlan setOwnerCode(String ownerCode) {
		this.ownerCode=ownerCode;
		return this;
	}
	
	/**
	 * 获得 启用状态<br>
	 * 启用状态
	 * @return 启用状态
	*/
	public String getStatus() {
		return status;
	}
	
	/**
	 * 设置 启用状态
	 * @param status 启用状态
	 * @return 当前对象
	*/
	public StockInventoryPlan setStatus(String status) {
		this.status=status;
		return this;
	}
	
	/**
	 * 获得 计划类型<br>
	 * 计划类型
	 * @return 计划类型
	*/
	public String getPlanType() {
		return planType;
	}
	
	/**
	 * 设置 计划类型
	 * @param planType 计划类型
	 * @return 当前对象
	*/
	public StockInventoryPlan setPlanType(String planType) {
		this.planType=planType;
		return this;
	}
	
	/**
	 * 获得 模板<br>
	 * 模板
	 * @return 模板
	*/
	public String getTplId() {
		return tplId;
	}
	
	/**
	 * 设置 模板
	 * @param tplId 模板
	 * @return 当前对象
	*/
	public StockInventoryPlan setTplId(String tplId) {
		this.tplId=tplId;
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
	public StockInventoryPlan setNotes(String notes) {
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
	public StockInventoryPlan setCreateBy(String createBy) {
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
	public StockInventoryPlan setCreateTime(Date createTime) {
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
	public StockInventoryPlan setUpdateBy(String updateBy) {
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
	public StockInventoryPlan setUpdateTime(Date updateTime) {
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
	public StockInventoryPlan setDeleted(Integer deleted) {
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
	public StockInventoryPlan setDeleted(Boolean deletedBool) {
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
	public StockInventoryPlan setDeleteBy(String deleteBy) {
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
	public StockInventoryPlan setDeleteTime(Date deleteTime) {
		this.deleteTime=deleteTime;
		return this;
	}
	
	/**
	 * 获得 数据版本号<br>
	 * 数据版本号
	 * @return 数据版本号
	*/
	public Integer getVersion() {
		return version;
	}
	
	/**
	 * 设置 数据版本号
	 * @param version 数据版本号
	 * @return 当前对象
	*/
	public StockInventoryPlan setVersion(Integer version) {
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
	public StockInventoryPlan setTenantId(String tenantId) {
		this.tenantId=tenantId;
		return this;
	}
	
	/**
	 * 获得 盘点任务<br>
	 * 盘点任务
	 * @return 盘点任务
	*/
	public StockInventoryTask getInventoryTask() {
		return inventoryTask;
	}
	
	/**
	 * 设置 盘点任务
	 * @param inventoryTask 盘点任务
	 * @return 当前对象
	*/
	public StockInventoryPlan setInventoryTask(StockInventoryTask inventoryTask) {
		this.inventoryTask=inventoryTask;
		return this;
	}
	
	/**
	 * 获得 盘点类型<br>
	 * 盘点类型
	 * @return 盘点类型
	*/
	public DictItem getInventoryPlanType() {
		return inventoryPlanType;
	}
	
	/**
	 * 设置 盘点类型
	 * @param inventoryPlanType 盘点类型
	 * @return 当前对象
	*/
	public StockInventoryPlan setInventoryPlanType(DictItem inventoryPlanType) {
		this.inventoryPlanType=inventoryPlanType;
		return this;
	}

	/**
	 * 将自己转换成指定类型的PO
	 * @param poType  PO类型
	 * @return StockInventoryPlan , 转换好的 StockInventoryPlan 对象
	*/
	@Transient
	public <T extends Entity> T toPO(Class<T> poType) {
		return EntityContext.create(poType, this);
	}

	/**
	 * 将自己转换成任意指定类型
	 * @param pojoType  Pojo类型
	 * @return StockInventoryPlan , 转换好的 PoJo 对象
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
	public StockInventoryPlan clone() {
		return duplicate(true);
	}

	/**
	 * 复制当前对象
	 * @param all 是否复制全部属性，当 false 时，仅复制来自数据表的属性
	*/
	@Transient
	public StockInventoryPlan duplicate(boolean all) {
		com.dt.platform.domain.eam.meta.StockInventoryPlanMeta.$$proxy$$ inst = new com.dt.platform.domain.eam.meta.StockInventoryPlanMeta.$$proxy$$();
		inst.setPlanType(this.getPlanType());
		inst.setNotes(this.getNotes());
		inst.setOwnerCode(this.getOwnerCode());
		inst.setUpdateTime(this.getUpdateTime());
		inst.setVersion(this.getVersion());
		inst.setCreateBy(this.getCreateBy());
		inst.setDeleted(this.getDeleted());
		inst.setCreateTime(this.getCreateTime());
		inst.setUpdateBy(this.getUpdateBy());
		inst.setDeleteTime(this.getDeleteTime());
		inst.setName(this.getName());
		inst.setTenantId(this.getTenantId());
		inst.setDeleteBy(this.getDeleteBy());
		inst.setId(this.getId());
		inst.setTplId(this.getTplId());
		inst.setStatus(this.getStatus());
		if(all) {
			inst.setInventoryTask(this.getInventoryTask());
			inst.setInventoryPlanType(this.getInventoryPlanType());
		}
		inst.clearModifies();
		return inst;
	}

	/**
	 * 克隆当前对象
	*/
	@Transient
	public StockInventoryPlan clone(boolean deep) {
		return EntityContext.clone(StockInventoryPlan.class,this,deep);
	}

	/**
	 * 将 Map 转换成 StockInventoryPlan
	 * @param stockInventoryPlanMap 包含实体信息的 Map 对象
	 * @return StockInventoryPlan , 转换好的的 StockInventoryPlan 对象
	*/
	@Transient
	public static StockInventoryPlan createFrom(Map<String,Object> stockInventoryPlanMap) {
		if(stockInventoryPlanMap==null) return null;
		StockInventoryPlan po = create();
		EntityContext.copyProperties(po,stockInventoryPlanMap);
		po.clearModifies();
		return po;
	}

	/**
	 * 将 Pojo 转换成 StockInventoryPlan
	 * @param pojo 包含实体信息的 Pojo 对象
	 * @return StockInventoryPlan , 转换好的的 StockInventoryPlan 对象
	*/
	@Transient
	public static StockInventoryPlan createFrom(Object pojo) {
		if(pojo==null) return null;
		StockInventoryPlan po = create();
		EntityContext.copyProperties(po,pojo);
		po.clearModifies();
		return po;
	}

	/**
	 * 创建一个 StockInventoryPlan，等同于 new
	 * @return StockInventoryPlan 对象
	*/
	@Transient
	public static StockInventoryPlan create() {
		return new com.dt.platform.domain.eam.meta.StockInventoryPlanMeta.$$proxy$$();
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
			this.setPlanType(DataParser.parse(String.class, map.get(StockInventoryPlanMeta.PLAN_TYPE)));
			this.setNotes(DataParser.parse(String.class, map.get(StockInventoryPlanMeta.NOTES)));
			this.setOwnerCode(DataParser.parse(String.class, map.get(StockInventoryPlanMeta.OWNER_CODE)));
			this.setUpdateTime(DataParser.parse(Date.class, map.get(StockInventoryPlanMeta.UPDATE_TIME)));
			this.setVersion(DataParser.parse(Integer.class, map.get(StockInventoryPlanMeta.VERSION)));
			this.setCreateBy(DataParser.parse(String.class, map.get(StockInventoryPlanMeta.CREATE_BY)));
			this.setDeleted(DataParser.parse(Integer.class, map.get(StockInventoryPlanMeta.DELETED)));
			this.setCreateTime(DataParser.parse(Date.class, map.get(StockInventoryPlanMeta.CREATE_TIME)));
			this.setUpdateBy(DataParser.parse(String.class, map.get(StockInventoryPlanMeta.UPDATE_BY)));
			this.setDeleteTime(DataParser.parse(Date.class, map.get(StockInventoryPlanMeta.DELETE_TIME)));
			this.setName(DataParser.parse(String.class, map.get(StockInventoryPlanMeta.NAME)));
			this.setTenantId(DataParser.parse(String.class, map.get(StockInventoryPlanMeta.TENANT_ID)));
			this.setDeleteBy(DataParser.parse(String.class, map.get(StockInventoryPlanMeta.DELETE_BY)));
			this.setId(DataParser.parse(String.class, map.get(StockInventoryPlanMeta.ID)));
			this.setTplId(DataParser.parse(String.class, map.get(StockInventoryPlanMeta.TPL_ID)));
			this.setStatus(DataParser.parse(String.class, map.get(StockInventoryPlanMeta.STATUS)));
			// others
			this.setInventoryTask(DataParser.parse(StockInventoryTask.class, map.get(StockInventoryPlanMeta.INVENTORY_TASK)));
			this.setInventoryPlanType(DataParser.parse(DictItem.class, map.get(StockInventoryPlanMeta.INVENTORY_PLAN_TYPE)));
			return true;
		} else {
			try {
				this.setPlanType( (String)map.get(StockInventoryPlanMeta.PLAN_TYPE));
				this.setNotes( (String)map.get(StockInventoryPlanMeta.NOTES));
				this.setOwnerCode( (String)map.get(StockInventoryPlanMeta.OWNER_CODE));
				this.setUpdateTime( (Date)map.get(StockInventoryPlanMeta.UPDATE_TIME));
				this.setVersion( (Integer)map.get(StockInventoryPlanMeta.VERSION));
				this.setCreateBy( (String)map.get(StockInventoryPlanMeta.CREATE_BY));
				this.setDeleted( (Integer)map.get(StockInventoryPlanMeta.DELETED));
				this.setCreateTime( (Date)map.get(StockInventoryPlanMeta.CREATE_TIME));
				this.setUpdateBy( (String)map.get(StockInventoryPlanMeta.UPDATE_BY));
				this.setDeleteTime( (Date)map.get(StockInventoryPlanMeta.DELETE_TIME));
				this.setName( (String)map.get(StockInventoryPlanMeta.NAME));
				this.setTenantId( (String)map.get(StockInventoryPlanMeta.TENANT_ID));
				this.setDeleteBy( (String)map.get(StockInventoryPlanMeta.DELETE_BY));
				this.setId( (String)map.get(StockInventoryPlanMeta.ID));
				this.setTplId( (String)map.get(StockInventoryPlanMeta.TPL_ID));
				this.setStatus( (String)map.get(StockInventoryPlanMeta.STATUS));
				// others
				this.setInventoryTask( (StockInventoryTask)map.get(StockInventoryPlanMeta.INVENTORY_TASK));
				this.setInventoryPlanType( (DictItem)map.get(StockInventoryPlanMeta.INVENTORY_PLAN_TYPE));
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
			this.setPlanType(DataParser.parse(String.class, r.getValue(StockInventoryPlanMeta.PLAN_TYPE)));
			this.setNotes(DataParser.parse(String.class, r.getValue(StockInventoryPlanMeta.NOTES)));
			this.setOwnerCode(DataParser.parse(String.class, r.getValue(StockInventoryPlanMeta.OWNER_CODE)));
			this.setUpdateTime(DataParser.parse(Date.class, r.getValue(StockInventoryPlanMeta.UPDATE_TIME)));
			this.setVersion(DataParser.parse(Integer.class, r.getValue(StockInventoryPlanMeta.VERSION)));
			this.setCreateBy(DataParser.parse(String.class, r.getValue(StockInventoryPlanMeta.CREATE_BY)));
			this.setDeleted(DataParser.parse(Integer.class, r.getValue(StockInventoryPlanMeta.DELETED)));
			this.setCreateTime(DataParser.parse(Date.class, r.getValue(StockInventoryPlanMeta.CREATE_TIME)));
			this.setUpdateBy(DataParser.parse(String.class, r.getValue(StockInventoryPlanMeta.UPDATE_BY)));
			this.setDeleteTime(DataParser.parse(Date.class, r.getValue(StockInventoryPlanMeta.DELETE_TIME)));
			this.setName(DataParser.parse(String.class, r.getValue(StockInventoryPlanMeta.NAME)));
			this.setTenantId(DataParser.parse(String.class, r.getValue(StockInventoryPlanMeta.TENANT_ID)));
			this.setDeleteBy(DataParser.parse(String.class, r.getValue(StockInventoryPlanMeta.DELETE_BY)));
			this.setId(DataParser.parse(String.class, r.getValue(StockInventoryPlanMeta.ID)));
			this.setTplId(DataParser.parse(String.class, r.getValue(StockInventoryPlanMeta.TPL_ID)));
			this.setStatus(DataParser.parse(String.class, r.getValue(StockInventoryPlanMeta.STATUS)));
			return true;
		} else {
			try {
				this.setPlanType( (String)r.getValue(StockInventoryPlanMeta.PLAN_TYPE));
				this.setNotes( (String)r.getValue(StockInventoryPlanMeta.NOTES));
				this.setOwnerCode( (String)r.getValue(StockInventoryPlanMeta.OWNER_CODE));
				this.setUpdateTime( (Date)r.getValue(StockInventoryPlanMeta.UPDATE_TIME));
				this.setVersion( (Integer)r.getValue(StockInventoryPlanMeta.VERSION));
				this.setCreateBy( (String)r.getValue(StockInventoryPlanMeta.CREATE_BY));
				this.setDeleted( (Integer)r.getValue(StockInventoryPlanMeta.DELETED));
				this.setCreateTime( (Date)r.getValue(StockInventoryPlanMeta.CREATE_TIME));
				this.setUpdateBy( (String)r.getValue(StockInventoryPlanMeta.UPDATE_BY));
				this.setDeleteTime( (Date)r.getValue(StockInventoryPlanMeta.DELETE_TIME));
				this.setName( (String)r.getValue(StockInventoryPlanMeta.NAME));
				this.setTenantId( (String)r.getValue(StockInventoryPlanMeta.TENANT_ID));
				this.setDeleteBy( (String)r.getValue(StockInventoryPlanMeta.DELETE_BY));
				this.setId( (String)r.getValue(StockInventoryPlanMeta.ID));
				this.setTplId( (String)r.getValue(StockInventoryPlanMeta.TPL_ID));
				this.setStatus( (String)r.getValue(StockInventoryPlanMeta.STATUS));
				return true;
			} catch (Exception e) {
				return false;
			}
		}
	}
}