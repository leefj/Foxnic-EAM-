package com.dt.platform.domain.eam;

import com.github.foxnic.dao.entity.Entity;
import io.swagger.annotations.ApiModel;
import javax.persistence.Table;
import com.github.foxnic.sql.meta.DBTable;
import com.dt.platform.constants.db.EAMTables.EAM_ASSET_RUNNING_SITUATION;
import javax.persistence.Id;
import io.swagger.annotations.ApiModelProperty;
import java.util.Date;
import javax.persistence.Transient;
import com.github.foxnic.api.swagger.EnumFor;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.github.foxnic.commons.lang.DataParser;
import java.util.Map;
import com.github.foxnic.dao.entity.EntityContext;
import com.dt.platform.domain.eam.meta.AssetRunningSituationMeta;
import com.github.foxnic.sql.data.ExprRcd;



/**
 * 运行情况
 * <p>运行情况 , 数据表 eam_asset_running_situation 的PO类型</p>
 * @author 金杰 , maillank@qq.com
 * @since 2023-08-11 19:57:53
 * @sign 6C4296CF4FDE762A1F08E311F2891BC3
 * 此文件由工具自动生成，请勿修改。若表结构或配置发生变动，请使用工具重新生成。
*/

@Table(name = "eam_asset_running_situation")
@ApiModel(description = "运行情况 ; 运行情况 , 数据表 eam_asset_running_situation 的PO类型")
public class AssetRunningSituation extends Entity {

	private static final long serialVersionUID = 1L;

	public static final DBTable TABLE =EAM_ASSET_RUNNING_SITUATION.$TABLE;
	
	/**
	 * 主键：主键
	*/
	@Id
	@ApiModelProperty(required = true,value="主键" , notes = "主键")
	private String id;
	
	/**
	 * 设备：设备
	*/
	@ApiModelProperty(required = false,value="设备" , notes = "设备")
	private String assetId;
	
	/**
	 * 设备：设备
	*/
	@ApiModelProperty(required = false,value="设备" , notes = "设备")
	private String status;
	
	/**
	 * 记录时间：记录时间
	*/
	@ApiModelProperty(required = false,value="记录时间" , notes = "记录时间")
	private Date recTime;
	
	/**
	 * 记录来源：记录来源
	*/
	@ApiModelProperty(required = false,value="记录来源" , notes = "记录来源")
	private String source;
	
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
	public AssetRunningSituation setId(String id) {
		this.id=id;
		return this;
	}
	
	/**
	 * 获得 设备<br>
	 * 设备
	 * @return 设备
	*/
	public String getAssetId() {
		return assetId;
	}
	
	/**
	 * 设置 设备
	 * @param assetId 设备
	 * @return 当前对象
	*/
	public AssetRunningSituation setAssetId(String assetId) {
		this.assetId=assetId;
		return this;
	}
	
	/**
	 * 获得 设备<br>
	 * 设备
	 * @return 设备
	*/
	public String getStatus() {
		return status;
	}
	
	/**
	 * 设置 设备
	 * @param status 设备
	 * @return 当前对象
	*/
	public AssetRunningSituation setStatus(String status) {
		this.status=status;
		return this;
	}
	
	/**
	 * 获得 记录时间<br>
	 * 记录时间
	 * @return 记录时间
	*/
	public Date getRecTime() {
		return recTime;
	}
	
	/**
	 * 设置 记录时间
	 * @param recTime 记录时间
	 * @return 当前对象
	*/
	public AssetRunningSituation setRecTime(Date recTime) {
		this.recTime=recTime;
		return this;
	}
	
	/**
	 * 获得 记录来源<br>
	 * 记录来源
	 * @return 记录来源
	*/
	public String getSource() {
		return source;
	}
	
	/**
	 * 设置 记录来源
	 * @param source 记录来源
	 * @return 当前对象
	*/
	public AssetRunningSituation setSource(String source) {
		this.source=source;
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
	public AssetRunningSituation setCreateTime(Date createTime) {
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
	public AssetRunningSituation setUpdateBy(String updateBy) {
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
	public AssetRunningSituation setUpdateTime(Date updateTime) {
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
	public AssetRunningSituation setDeleted(Integer deleted) {
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
	public AssetRunningSituation setDeleted(Boolean deletedBool) {
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
	public AssetRunningSituation setDeleteBy(String deleteBy) {
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
	public AssetRunningSituation setDeleteTime(Date deleteTime) {
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
	public AssetRunningSituation setVersion(Integer version) {
		this.version=version;
		return this;
	}

	/**
	 * 将自己转换成指定类型的PO
	 * @param poType  PO类型
	 * @return AssetRunningSituation , 转换好的 AssetRunningSituation 对象
	*/
	@Transient
	public <T extends Entity> T toPO(Class<T> poType) {
		return EntityContext.create(poType, this);
	}

	/**
	 * 将自己转换成任意指定类型
	 * @param pojoType  Pojo类型
	 * @return AssetRunningSituation , 转换好的 PoJo 对象
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
	public AssetRunningSituation clone() {
		return duplicate(true);
	}

	/**
	 * 复制当前对象
	 * @param all 是否复制全部属性，当 false 时，仅复制来自数据表的属性
	*/
	@Transient
	public AssetRunningSituation duplicate(boolean all) {
		com.dt.platform.domain.eam.meta.AssetRunningSituationMeta.$$proxy$$ inst = new com.dt.platform.domain.eam.meta.AssetRunningSituationMeta.$$proxy$$();
		inst.setDeleted(this.getDeleted());
		inst.setCreateTime(this.getCreateTime());
		inst.setUpdateBy(this.getUpdateBy());
		inst.setDeleteTime(this.getDeleteTime());
		inst.setAssetId(this.getAssetId());
		inst.setRecTime(this.getRecTime());
		inst.setDeleteBy(this.getDeleteBy());
		inst.setUpdateTime(this.getUpdateTime());
		inst.setId(this.getId());
		inst.setSource(this.getSource());
		inst.setVersion(this.getVersion());
		inst.setStatus(this.getStatus());
		inst.clearModifies();
		return inst;
	}

	/**
	 * 克隆当前对象
	*/
	@Transient
	public AssetRunningSituation clone(boolean deep) {
		return EntityContext.clone(AssetRunningSituation.class,this,deep);
	}

	/**
	 * 将 Map 转换成 AssetRunningSituation
	 * @param assetRunningSituationMap 包含实体信息的 Map 对象
	 * @return AssetRunningSituation , 转换好的的 AssetRunningSituation 对象
	*/
	@Transient
	public static AssetRunningSituation createFrom(Map<String,Object> assetRunningSituationMap) {
		if(assetRunningSituationMap==null) return null;
		AssetRunningSituation po = create();
		EntityContext.copyProperties(po,assetRunningSituationMap);
		po.clearModifies();
		return po;
	}

	/**
	 * 将 Pojo 转换成 AssetRunningSituation
	 * @param pojo 包含实体信息的 Pojo 对象
	 * @return AssetRunningSituation , 转换好的的 AssetRunningSituation 对象
	*/
	@Transient
	public static AssetRunningSituation createFrom(Object pojo) {
		if(pojo==null) return null;
		AssetRunningSituation po = create();
		EntityContext.copyProperties(po,pojo);
		po.clearModifies();
		return po;
	}

	/**
	 * 创建一个 AssetRunningSituation，等同于 new
	 * @return AssetRunningSituation 对象
	*/
	@Transient
	public static AssetRunningSituation create() {
		return new com.dt.platform.domain.eam.meta.AssetRunningSituationMeta.$$proxy$$();
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
			this.setDeleted(DataParser.parse(Integer.class, map.get(AssetRunningSituationMeta.DELETED)));
			this.setCreateTime(DataParser.parse(Date.class, map.get(AssetRunningSituationMeta.CREATE_TIME)));
			this.setUpdateBy(DataParser.parse(String.class, map.get(AssetRunningSituationMeta.UPDATE_BY)));
			this.setDeleteTime(DataParser.parse(Date.class, map.get(AssetRunningSituationMeta.DELETE_TIME)));
			this.setAssetId(DataParser.parse(String.class, map.get(AssetRunningSituationMeta.ASSET_ID)));
			this.setRecTime(DataParser.parse(Date.class, map.get(AssetRunningSituationMeta.REC_TIME)));
			this.setDeleteBy(DataParser.parse(String.class, map.get(AssetRunningSituationMeta.DELETE_BY)));
			this.setUpdateTime(DataParser.parse(Date.class, map.get(AssetRunningSituationMeta.UPDATE_TIME)));
			this.setId(DataParser.parse(String.class, map.get(AssetRunningSituationMeta.ID)));
			this.setSource(DataParser.parse(String.class, map.get(AssetRunningSituationMeta.SOURCE)));
			this.setVersion(DataParser.parse(Integer.class, map.get(AssetRunningSituationMeta.VERSION)));
			this.setStatus(DataParser.parse(String.class, map.get(AssetRunningSituationMeta.STATUS)));
			// others
			return true;
		} else {
			try {
				this.setDeleted( (Integer)map.get(AssetRunningSituationMeta.DELETED));
				this.setCreateTime( (Date)map.get(AssetRunningSituationMeta.CREATE_TIME));
				this.setUpdateBy( (String)map.get(AssetRunningSituationMeta.UPDATE_BY));
				this.setDeleteTime( (Date)map.get(AssetRunningSituationMeta.DELETE_TIME));
				this.setAssetId( (String)map.get(AssetRunningSituationMeta.ASSET_ID));
				this.setRecTime( (Date)map.get(AssetRunningSituationMeta.REC_TIME));
				this.setDeleteBy( (String)map.get(AssetRunningSituationMeta.DELETE_BY));
				this.setUpdateTime( (Date)map.get(AssetRunningSituationMeta.UPDATE_TIME));
				this.setId( (String)map.get(AssetRunningSituationMeta.ID));
				this.setSource( (String)map.get(AssetRunningSituationMeta.SOURCE));
				this.setVersion( (Integer)map.get(AssetRunningSituationMeta.VERSION));
				this.setStatus( (String)map.get(AssetRunningSituationMeta.STATUS));
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
			this.setDeleted(DataParser.parse(Integer.class, r.getValue(AssetRunningSituationMeta.DELETED)));
			this.setCreateTime(DataParser.parse(Date.class, r.getValue(AssetRunningSituationMeta.CREATE_TIME)));
			this.setUpdateBy(DataParser.parse(String.class, r.getValue(AssetRunningSituationMeta.UPDATE_BY)));
			this.setDeleteTime(DataParser.parse(Date.class, r.getValue(AssetRunningSituationMeta.DELETE_TIME)));
			this.setAssetId(DataParser.parse(String.class, r.getValue(AssetRunningSituationMeta.ASSET_ID)));
			this.setRecTime(DataParser.parse(Date.class, r.getValue(AssetRunningSituationMeta.REC_TIME)));
			this.setDeleteBy(DataParser.parse(String.class, r.getValue(AssetRunningSituationMeta.DELETE_BY)));
			this.setUpdateTime(DataParser.parse(Date.class, r.getValue(AssetRunningSituationMeta.UPDATE_TIME)));
			this.setId(DataParser.parse(String.class, r.getValue(AssetRunningSituationMeta.ID)));
			this.setSource(DataParser.parse(String.class, r.getValue(AssetRunningSituationMeta.SOURCE)));
			this.setVersion(DataParser.parse(Integer.class, r.getValue(AssetRunningSituationMeta.VERSION)));
			this.setStatus(DataParser.parse(String.class, r.getValue(AssetRunningSituationMeta.STATUS)));
			return true;
		} else {
			try {
				this.setDeleted( (Integer)r.getValue(AssetRunningSituationMeta.DELETED));
				this.setCreateTime( (Date)r.getValue(AssetRunningSituationMeta.CREATE_TIME));
				this.setUpdateBy( (String)r.getValue(AssetRunningSituationMeta.UPDATE_BY));
				this.setDeleteTime( (Date)r.getValue(AssetRunningSituationMeta.DELETE_TIME));
				this.setAssetId( (String)r.getValue(AssetRunningSituationMeta.ASSET_ID));
				this.setRecTime( (Date)r.getValue(AssetRunningSituationMeta.REC_TIME));
				this.setDeleteBy( (String)r.getValue(AssetRunningSituationMeta.DELETE_BY));
				this.setUpdateTime( (Date)r.getValue(AssetRunningSituationMeta.UPDATE_TIME));
				this.setId( (String)r.getValue(AssetRunningSituationMeta.ID));
				this.setSource( (String)r.getValue(AssetRunningSituationMeta.SOURCE));
				this.setVersion( (Integer)r.getValue(AssetRunningSituationMeta.VERSION));
				this.setStatus( (String)r.getValue(AssetRunningSituationMeta.STATUS));
				return true;
			} catch (Exception e) {
				return false;
			}
		}
	}
}