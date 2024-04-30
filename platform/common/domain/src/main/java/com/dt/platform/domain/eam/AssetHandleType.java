package com.dt.platform.domain.eam;

import com.github.foxnic.dao.entity.Entity;
import io.swagger.annotations.ApiModel;
import javax.persistence.Table;
import com.github.foxnic.sql.meta.DBTable;
import com.dt.platform.constants.db.EAMTables.EAM_ASSET_HANDLE_TYPE;
import javax.persistence.Id;
import io.swagger.annotations.ApiModelProperty;
import java.util.Date;
import javax.persistence.Transient;
import com.github.foxnic.api.swagger.EnumFor;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.github.foxnic.commons.lang.DataParser;
import java.util.Map;
import com.github.foxnic.dao.entity.EntityContext;
import com.dt.platform.domain.eam.meta.AssetHandleTypeMeta;
import com.github.foxnic.sql.data.ExprRcd;



/**
 * 处置类型
 * <p>处置类型 , 数据表 eam_asset_handle_type 的PO类型</p>
 * @author 金杰 , maillank@qq.com
 * @since 2024-04-30 12:38:09
 * @sign CA326156710B5A195C12FBF71B958AA3
 * 此文件由工具自动生成，请勿修改。若表结构或配置发生变动，请使用工具重新生成。
*/

@Table(name = "eam_asset_handle_type")
@ApiModel(description = "处置类型 ; 处置类型 , 数据表 eam_asset_handle_type 的PO类型")
public class AssetHandleType extends Entity {

	private static final long serialVersionUID = 1L;

	public static final DBTable TABLE =EAM_ASSET_HANDLE_TYPE.$TABLE;
	
	/**
	 * 主键：主键
	*/
	@Id
	@ApiModelProperty(required = true,value="主键" , notes = "主键" , example = "837667251493535744")
	private String id;
	
	/**
	 * 编码：编码
	*/
	@ApiModelProperty(required = false,value="编码" , notes = "编码" , example = "fq")
	private String code;
	
	/**
	 * 名称：名称
	*/
	@ApiModelProperty(required = false,value="名称" , notes = "名称" , example = "废弃")
	private String label;
	
	/**
	 * 状态：状态
	*/
	@ApiModelProperty(required = false,value="状态" , notes = "状态" , example = "valid")
	private String status;
	
	/**
	 * 资产状态：资产状态
	*/
	@ApiModelProperty(required = false,value="资产状态" , notes = "资产状态" , example = "handled")
	private String handleStatus;
	
	/**
	 * 是否清理：是否清理
	*/
	@ApiModelProperty(required = false,value="是否清理" , notes = "是否清理")
	private String cleanStatus;
	
	/**
	 * 动作：动作
	*/
	@ApiModelProperty(required = false,value="动作" , notes = "动作")
	private String actionMethod;
	
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
	@ApiModelProperty(required = false,value="创建时间" , notes = "创建时间" , example = "2024-04-30 12:30:36")
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
	 * assetStatusData：assetStatusData
	*/
	@ApiModelProperty(required = false,value="assetStatusData" , notes = "assetStatusData")
	private AssetStatus assetStatusData;
	
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
	public AssetHandleType setId(String id) {
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
	public AssetHandleType setCode(String code) {
		this.code=code;
		return this;
	}
	
	/**
	 * 获得 名称<br>
	 * 名称
	 * @return 名称
	*/
	public String getLabel() {
		return label;
	}
	
	/**
	 * 设置 名称
	 * @param label 名称
	 * @return 当前对象
	*/
	public AssetHandleType setLabel(String label) {
		this.label=label;
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
	public AssetHandleType setStatus(String status) {
		this.status=status;
		return this;
	}
	
	/**
	 * 获得 资产状态<br>
	 * 资产状态
	 * @return 资产状态
	*/
	public String getHandleStatus() {
		return handleStatus;
	}
	
	/**
	 * 设置 资产状态
	 * @param handleStatus 资产状态
	 * @return 当前对象
	*/
	public AssetHandleType setHandleStatus(String handleStatus) {
		this.handleStatus=handleStatus;
		return this;
	}
	
	/**
	 * 获得 是否清理<br>
	 * 是否清理
	 * @return 是否清理
	*/
	public String getCleanStatus() {
		return cleanStatus;
	}
	
	/**
	 * 设置 是否清理
	 * @param cleanStatus 是否清理
	 * @return 当前对象
	*/
	public AssetHandleType setCleanStatus(String cleanStatus) {
		this.cleanStatus=cleanStatus;
		return this;
	}
	
	/**
	 * 获得 动作<br>
	 * 动作
	 * @return 动作
	*/
	public String getActionMethod() {
		return actionMethod;
	}
	
	/**
	 * 设置 动作
	 * @param actionMethod 动作
	 * @return 当前对象
	*/
	public AssetHandleType setActionMethod(String actionMethod) {
		this.actionMethod=actionMethod;
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
	public AssetHandleType setNotes(String notes) {
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
	public AssetHandleType setCreateBy(String createBy) {
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
	public AssetHandleType setCreateTime(Date createTime) {
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
	public AssetHandleType setUpdateBy(String updateBy) {
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
	public AssetHandleType setUpdateTime(Date updateTime) {
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
	public AssetHandleType setDeleted(Integer deleted) {
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
	public AssetHandleType setDeleted(Boolean deletedBool) {
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
	public AssetHandleType setDeleteBy(String deleteBy) {
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
	public AssetHandleType setDeleteTime(Date deleteTime) {
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
	public AssetHandleType setVersion(Integer version) {
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
	public AssetHandleType setTenantId(String tenantId) {
		this.tenantId=tenantId;
		return this;
	}
	
	/**
	 * 获得 assetStatusData<br>
	 * assetStatusData
	 * @return assetStatusData
	*/
	public AssetStatus getAssetStatusData() {
		return assetStatusData;
	}
	
	/**
	 * 设置 assetStatusData
	 * @param assetStatusData assetStatusData
	 * @return 当前对象
	*/
	public AssetHandleType setAssetStatusData(AssetStatus assetStatusData) {
		this.assetStatusData=assetStatusData;
		return this;
	}

	/**
	 * 将自己转换成指定类型的PO
	 * @param poType  PO类型
	 * @return AssetHandleType , 转换好的 AssetHandleType 对象
	*/
	@Transient
	public <T extends Entity> T toPO(Class<T> poType) {
		return EntityContext.create(poType, this);
	}

	/**
	 * 将自己转换成任意指定类型
	 * @param pojoType  Pojo类型
	 * @return AssetHandleType , 转换好的 PoJo 对象
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
	public AssetHandleType clone() {
		return duplicate(true);
	}

	/**
	 * 复制当前对象
	 * @param all 是否复制全部属性，当 false 时，仅复制来自数据表的属性
	*/
	@Transient
	public AssetHandleType duplicate(boolean all) {
		com.dt.platform.domain.eam.meta.AssetHandleTypeMeta.$$proxy$$ inst = new com.dt.platform.domain.eam.meta.AssetHandleTypeMeta.$$proxy$$();
		inst.setCode(this.getCode());
		inst.setActionMethod(this.getActionMethod());
		inst.setNotes(this.getNotes());
		inst.setCleanStatus(this.getCleanStatus());
		inst.setUpdateTime(this.getUpdateTime());
		inst.setLabel(this.getLabel());
		inst.setVersion(this.getVersion());
		inst.setCreateBy(this.getCreateBy());
		inst.setDeleted(this.getDeleted());
		inst.setCreateTime(this.getCreateTime());
		inst.setUpdateBy(this.getUpdateBy());
		inst.setDeleteTime(this.getDeleteTime());
		inst.setTenantId(this.getTenantId());
		inst.setHandleStatus(this.getHandleStatus());
		inst.setDeleteBy(this.getDeleteBy());
		inst.setId(this.getId());
		inst.setStatus(this.getStatus());
		if(all) {
			inst.setAssetStatusData(this.getAssetStatusData());
		}
		inst.clearModifies();
		return inst;
	}

	/**
	 * 克隆当前对象
	*/
	@Transient
	public AssetHandleType clone(boolean deep) {
		return EntityContext.clone(AssetHandleType.class,this,deep);
	}

	/**
	 * 将 Map 转换成 AssetHandleType
	 * @param assetHandleTypeMap 包含实体信息的 Map 对象
	 * @return AssetHandleType , 转换好的的 AssetHandleType 对象
	*/
	@Transient
	public static AssetHandleType createFrom(Map<String,Object> assetHandleTypeMap) {
		if(assetHandleTypeMap==null) return null;
		AssetHandleType po = create();
		EntityContext.copyProperties(po,assetHandleTypeMap);
		po.clearModifies();
		return po;
	}

	/**
	 * 将 Pojo 转换成 AssetHandleType
	 * @param pojo 包含实体信息的 Pojo 对象
	 * @return AssetHandleType , 转换好的的 AssetHandleType 对象
	*/
	@Transient
	public static AssetHandleType createFrom(Object pojo) {
		if(pojo==null) return null;
		AssetHandleType po = create();
		EntityContext.copyProperties(po,pojo);
		po.clearModifies();
		return po;
	}

	/**
	 * 创建一个 AssetHandleType，等同于 new
	 * @return AssetHandleType 对象
	*/
	@Transient
	public static AssetHandleType create() {
		return new com.dt.platform.domain.eam.meta.AssetHandleTypeMeta.$$proxy$$();
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
			this.setCode(DataParser.parse(String.class, map.get(AssetHandleTypeMeta.CODE)));
			this.setActionMethod(DataParser.parse(String.class, map.get(AssetHandleTypeMeta.ACTION_METHOD)));
			this.setNotes(DataParser.parse(String.class, map.get(AssetHandleTypeMeta.NOTES)));
			this.setCleanStatus(DataParser.parse(String.class, map.get(AssetHandleTypeMeta.CLEAN_STATUS)));
			this.setUpdateTime(DataParser.parse(Date.class, map.get(AssetHandleTypeMeta.UPDATE_TIME)));
			this.setLabel(DataParser.parse(String.class, map.get(AssetHandleTypeMeta.LABEL)));
			this.setVersion(DataParser.parse(Integer.class, map.get(AssetHandleTypeMeta.VERSION)));
			this.setCreateBy(DataParser.parse(String.class, map.get(AssetHandleTypeMeta.CREATE_BY)));
			this.setDeleted(DataParser.parse(Integer.class, map.get(AssetHandleTypeMeta.DELETED)));
			this.setCreateTime(DataParser.parse(Date.class, map.get(AssetHandleTypeMeta.CREATE_TIME)));
			this.setUpdateBy(DataParser.parse(String.class, map.get(AssetHandleTypeMeta.UPDATE_BY)));
			this.setDeleteTime(DataParser.parse(Date.class, map.get(AssetHandleTypeMeta.DELETE_TIME)));
			this.setTenantId(DataParser.parse(String.class, map.get(AssetHandleTypeMeta.TENANT_ID)));
			this.setHandleStatus(DataParser.parse(String.class, map.get(AssetHandleTypeMeta.HANDLE_STATUS)));
			this.setDeleteBy(DataParser.parse(String.class, map.get(AssetHandleTypeMeta.DELETE_BY)));
			this.setId(DataParser.parse(String.class, map.get(AssetHandleTypeMeta.ID)));
			this.setStatus(DataParser.parse(String.class, map.get(AssetHandleTypeMeta.STATUS)));
			// others
			this.setAssetStatusData(DataParser.parse(AssetStatus.class, map.get(AssetHandleTypeMeta.ASSET_STATUS_DATA)));
			return true;
		} else {
			try {
				this.setCode( (String)map.get(AssetHandleTypeMeta.CODE));
				this.setActionMethod( (String)map.get(AssetHandleTypeMeta.ACTION_METHOD));
				this.setNotes( (String)map.get(AssetHandleTypeMeta.NOTES));
				this.setCleanStatus( (String)map.get(AssetHandleTypeMeta.CLEAN_STATUS));
				this.setUpdateTime( (Date)map.get(AssetHandleTypeMeta.UPDATE_TIME));
				this.setLabel( (String)map.get(AssetHandleTypeMeta.LABEL));
				this.setVersion( (Integer)map.get(AssetHandleTypeMeta.VERSION));
				this.setCreateBy( (String)map.get(AssetHandleTypeMeta.CREATE_BY));
				this.setDeleted( (Integer)map.get(AssetHandleTypeMeta.DELETED));
				this.setCreateTime( (Date)map.get(AssetHandleTypeMeta.CREATE_TIME));
				this.setUpdateBy( (String)map.get(AssetHandleTypeMeta.UPDATE_BY));
				this.setDeleteTime( (Date)map.get(AssetHandleTypeMeta.DELETE_TIME));
				this.setTenantId( (String)map.get(AssetHandleTypeMeta.TENANT_ID));
				this.setHandleStatus( (String)map.get(AssetHandleTypeMeta.HANDLE_STATUS));
				this.setDeleteBy( (String)map.get(AssetHandleTypeMeta.DELETE_BY));
				this.setId( (String)map.get(AssetHandleTypeMeta.ID));
				this.setStatus( (String)map.get(AssetHandleTypeMeta.STATUS));
				// others
				this.setAssetStatusData( (AssetStatus)map.get(AssetHandleTypeMeta.ASSET_STATUS_DATA));
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
			this.setCode(DataParser.parse(String.class, r.getValue(AssetHandleTypeMeta.CODE)));
			this.setActionMethod(DataParser.parse(String.class, r.getValue(AssetHandleTypeMeta.ACTION_METHOD)));
			this.setNotes(DataParser.parse(String.class, r.getValue(AssetHandleTypeMeta.NOTES)));
			this.setCleanStatus(DataParser.parse(String.class, r.getValue(AssetHandleTypeMeta.CLEAN_STATUS)));
			this.setUpdateTime(DataParser.parse(Date.class, r.getValue(AssetHandleTypeMeta.UPDATE_TIME)));
			this.setLabel(DataParser.parse(String.class, r.getValue(AssetHandleTypeMeta.LABEL)));
			this.setVersion(DataParser.parse(Integer.class, r.getValue(AssetHandleTypeMeta.VERSION)));
			this.setCreateBy(DataParser.parse(String.class, r.getValue(AssetHandleTypeMeta.CREATE_BY)));
			this.setDeleted(DataParser.parse(Integer.class, r.getValue(AssetHandleTypeMeta.DELETED)));
			this.setCreateTime(DataParser.parse(Date.class, r.getValue(AssetHandleTypeMeta.CREATE_TIME)));
			this.setUpdateBy(DataParser.parse(String.class, r.getValue(AssetHandleTypeMeta.UPDATE_BY)));
			this.setDeleteTime(DataParser.parse(Date.class, r.getValue(AssetHandleTypeMeta.DELETE_TIME)));
			this.setTenantId(DataParser.parse(String.class, r.getValue(AssetHandleTypeMeta.TENANT_ID)));
			this.setHandleStatus(DataParser.parse(String.class, r.getValue(AssetHandleTypeMeta.HANDLE_STATUS)));
			this.setDeleteBy(DataParser.parse(String.class, r.getValue(AssetHandleTypeMeta.DELETE_BY)));
			this.setId(DataParser.parse(String.class, r.getValue(AssetHandleTypeMeta.ID)));
			this.setStatus(DataParser.parse(String.class, r.getValue(AssetHandleTypeMeta.STATUS)));
			return true;
		} else {
			try {
				this.setCode( (String)r.getValue(AssetHandleTypeMeta.CODE));
				this.setActionMethod( (String)r.getValue(AssetHandleTypeMeta.ACTION_METHOD));
				this.setNotes( (String)r.getValue(AssetHandleTypeMeta.NOTES));
				this.setCleanStatus( (String)r.getValue(AssetHandleTypeMeta.CLEAN_STATUS));
				this.setUpdateTime( (Date)r.getValue(AssetHandleTypeMeta.UPDATE_TIME));
				this.setLabel( (String)r.getValue(AssetHandleTypeMeta.LABEL));
				this.setVersion( (Integer)r.getValue(AssetHandleTypeMeta.VERSION));
				this.setCreateBy( (String)r.getValue(AssetHandleTypeMeta.CREATE_BY));
				this.setDeleted( (Integer)r.getValue(AssetHandleTypeMeta.DELETED));
				this.setCreateTime( (Date)r.getValue(AssetHandleTypeMeta.CREATE_TIME));
				this.setUpdateBy( (String)r.getValue(AssetHandleTypeMeta.UPDATE_BY));
				this.setDeleteTime( (Date)r.getValue(AssetHandleTypeMeta.DELETE_TIME));
				this.setTenantId( (String)r.getValue(AssetHandleTypeMeta.TENANT_ID));
				this.setHandleStatus( (String)r.getValue(AssetHandleTypeMeta.HANDLE_STATUS));
				this.setDeleteBy( (String)r.getValue(AssetHandleTypeMeta.DELETE_BY));
				this.setId( (String)r.getValue(AssetHandleTypeMeta.ID));
				this.setStatus( (String)r.getValue(AssetHandleTypeMeta.STATUS));
				return true;
			} catch (Exception e) {
				return false;
			}
		}
	}
}