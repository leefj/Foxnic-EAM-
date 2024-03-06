package com.dt.platform.domain.eam;

import com.github.foxnic.dao.entity.Entity;
import io.swagger.annotations.ApiModel;
import javax.persistence.Table;
import com.github.foxnic.sql.meta.DBTable;
import com.dt.platform.constants.db.EAMTables.EAM_ASSET_SCAN_SCENE;
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
import com.dt.platform.domain.eam.meta.AssetScanSceneMeta;
import com.github.foxnic.sql.data.ExprRcd;



/**
 * 扫码配置
 * <p>扫码配置 , 数据表 eam_asset_scan_scene 的PO类型</p>
 * @author 金杰 , maillank@qq.com
 * @since 2024-03-06 15:28:16
 * @sign 4CD3C815F291790DCC9A820675DA8747
 * 此文件由工具自动生成，请勿修改。若表结构或配置发生变动，请使用工具重新生成。
*/

@Table(name = "eam_asset_scan_scene")
@ApiModel(description = "扫码配置 ; 扫码配置 , 数据表 eam_asset_scan_scene 的PO类型")
public class AssetScanScene extends Entity {

	private static final long serialVersionUID = 1L;

	public static final DBTable TABLE =EAM_ASSET_SCAN_SCENE.$TABLE;
	
	/**
	 * 主键：主键
	*/
	@Id
	@ApiModelProperty(required = true,value="主键" , notes = "主键" , example = "817779842689794048")
	private String id;
	
	/**
	 * 场景编码：场景编码
	*/
	@ApiModelProperty(required = false,value="场景编码" , notes = "场景编码" , example = "mobile_asset_scan")
	private String code;
	
	/**
	 * 场景名称：场景名称
	*/
	@ApiModelProperty(required = false,value="场景名称" , notes = "场景名称" , example = "移动端资产扫码")
	private String name;
	
	/**
	 * 方式：方式
	*/
	@ApiModelProperty(required = false,value="方式" , notes = "方式" , example = "asset_url")
	private String method;
	
	/**
	 * 创建人ID：创建人ID
	*/
	@ApiModelProperty(required = false,value="创建人ID" , notes = "创建人ID" , example = "110588348101165911")
	private String createBy;
	
	/**
	 * 创建时间：创建时间
	*/
	@ApiModelProperty(required = false,value="创建时间" , notes = "创建时间" , example = "2024-03-06 03:25:08")
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
	 * 数据版本号：数据版本号
	*/
	@ApiModelProperty(required = true,value="数据版本号" , notes = "数据版本号" , example = "1")
	private Integer version;
	
	/**
	 * 租户：租户
	*/
	@ApiModelProperty(required = false,value="租户" , notes = "租户" , example = "T001")
	private String tenantId;
	
	/**
	 * methodDict：methodDict
	*/
	@ApiModelProperty(required = false,value="methodDict" , notes = "methodDict")
	private DictItem methodDict;
	
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
	public AssetScanScene setId(String id) {
		this.id=id;
		return this;
	}
	
	/**
	 * 获得 场景编码<br>
	 * 场景编码
	 * @return 场景编码
	*/
	public String getCode() {
		return code;
	}
	
	/**
	 * 设置 场景编码
	 * @param code 场景编码
	 * @return 当前对象
	*/
	public AssetScanScene setCode(String code) {
		this.code=code;
		return this;
	}
	
	/**
	 * 获得 场景名称<br>
	 * 场景名称
	 * @return 场景名称
	*/
	public String getName() {
		return name;
	}
	
	/**
	 * 设置 场景名称
	 * @param name 场景名称
	 * @return 当前对象
	*/
	public AssetScanScene setName(String name) {
		this.name=name;
		return this;
	}
	
	/**
	 * 获得 方式<br>
	 * 方式
	 * @return 方式
	*/
	public String getMethod() {
		return method;
	}
	
	/**
	 * 设置 方式
	 * @param method 方式
	 * @return 当前对象
	*/
	public AssetScanScene setMethod(String method) {
		this.method=method;
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
	public AssetScanScene setCreateBy(String createBy) {
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
	public AssetScanScene setCreateTime(Date createTime) {
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
	public AssetScanScene setUpdateBy(String updateBy) {
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
	public AssetScanScene setUpdateTime(Date updateTime) {
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
	public AssetScanScene setDeleted(Integer deleted) {
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
	public AssetScanScene setDeleted(Boolean deletedBool) {
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
	public AssetScanScene setDeleteBy(String deleteBy) {
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
	public AssetScanScene setDeleteTime(Date deleteTime) {
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
	public AssetScanScene setVersion(Integer version) {
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
	public AssetScanScene setTenantId(String tenantId) {
		this.tenantId=tenantId;
		return this;
	}
	
	/**
	 * 获得 methodDict<br>
	 * methodDict
	 * @return methodDict
	*/
	public DictItem getMethodDict() {
		return methodDict;
	}
	
	/**
	 * 设置 methodDict
	 * @param methodDict methodDict
	 * @return 当前对象
	*/
	public AssetScanScene setMethodDict(DictItem methodDict) {
		this.methodDict=methodDict;
		return this;
	}

	/**
	 * 将自己转换成指定类型的PO
	 * @param poType  PO类型
	 * @return AssetScanScene , 转换好的 AssetScanScene 对象
	*/
	@Transient
	public <T extends Entity> T toPO(Class<T> poType) {
		return EntityContext.create(poType, this);
	}

	/**
	 * 将自己转换成任意指定类型
	 * @param pojoType  Pojo类型
	 * @return AssetScanScene , 转换好的 PoJo 对象
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
	public AssetScanScene clone() {
		return duplicate(true);
	}

	/**
	 * 复制当前对象
	 * @param all 是否复制全部属性，当 false 时，仅复制来自数据表的属性
	*/
	@Transient
	public AssetScanScene duplicate(boolean all) {
		com.dt.platform.domain.eam.meta.AssetScanSceneMeta.$$proxy$$ inst = new com.dt.platform.domain.eam.meta.AssetScanSceneMeta.$$proxy$$();
		inst.setCode(this.getCode());
		inst.setMethod(this.getMethod());
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
		if(all) {
			inst.setMethodDict(this.getMethodDict());
		}
		inst.clearModifies();
		return inst;
	}

	/**
	 * 克隆当前对象
	*/
	@Transient
	public AssetScanScene clone(boolean deep) {
		return EntityContext.clone(AssetScanScene.class,this,deep);
	}

	/**
	 * 将 Map 转换成 AssetScanScene
	 * @param assetScanSceneMap 包含实体信息的 Map 对象
	 * @return AssetScanScene , 转换好的的 AssetScanScene 对象
	*/
	@Transient
	public static AssetScanScene createFrom(Map<String,Object> assetScanSceneMap) {
		if(assetScanSceneMap==null) return null;
		AssetScanScene po = create();
		EntityContext.copyProperties(po,assetScanSceneMap);
		po.clearModifies();
		return po;
	}

	/**
	 * 将 Pojo 转换成 AssetScanScene
	 * @param pojo 包含实体信息的 Pojo 对象
	 * @return AssetScanScene , 转换好的的 AssetScanScene 对象
	*/
	@Transient
	public static AssetScanScene createFrom(Object pojo) {
		if(pojo==null) return null;
		AssetScanScene po = create();
		EntityContext.copyProperties(po,pojo);
		po.clearModifies();
		return po;
	}

	/**
	 * 创建一个 AssetScanScene，等同于 new
	 * @return AssetScanScene 对象
	*/
	@Transient
	public static AssetScanScene create() {
		return new com.dt.platform.domain.eam.meta.AssetScanSceneMeta.$$proxy$$();
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
			this.setCode(DataParser.parse(String.class, map.get(AssetScanSceneMeta.CODE)));
			this.setMethod(DataParser.parse(String.class, map.get(AssetScanSceneMeta.METHOD)));
			this.setUpdateTime(DataParser.parse(Date.class, map.get(AssetScanSceneMeta.UPDATE_TIME)));
			this.setVersion(DataParser.parse(Integer.class, map.get(AssetScanSceneMeta.VERSION)));
			this.setCreateBy(DataParser.parse(String.class, map.get(AssetScanSceneMeta.CREATE_BY)));
			this.setDeleted(DataParser.parse(Integer.class, map.get(AssetScanSceneMeta.DELETED)));
			this.setCreateTime(DataParser.parse(Date.class, map.get(AssetScanSceneMeta.CREATE_TIME)));
			this.setUpdateBy(DataParser.parse(String.class, map.get(AssetScanSceneMeta.UPDATE_BY)));
			this.setDeleteTime(DataParser.parse(Date.class, map.get(AssetScanSceneMeta.DELETE_TIME)));
			this.setName(DataParser.parse(String.class, map.get(AssetScanSceneMeta.NAME)));
			this.setTenantId(DataParser.parse(String.class, map.get(AssetScanSceneMeta.TENANT_ID)));
			this.setDeleteBy(DataParser.parse(String.class, map.get(AssetScanSceneMeta.DELETE_BY)));
			this.setId(DataParser.parse(String.class, map.get(AssetScanSceneMeta.ID)));
			// others
			this.setMethodDict(DataParser.parse(DictItem.class, map.get(AssetScanSceneMeta.METHOD_DICT)));
			return true;
		} else {
			try {
				this.setCode( (String)map.get(AssetScanSceneMeta.CODE));
				this.setMethod( (String)map.get(AssetScanSceneMeta.METHOD));
				this.setUpdateTime( (Date)map.get(AssetScanSceneMeta.UPDATE_TIME));
				this.setVersion( (Integer)map.get(AssetScanSceneMeta.VERSION));
				this.setCreateBy( (String)map.get(AssetScanSceneMeta.CREATE_BY));
				this.setDeleted( (Integer)map.get(AssetScanSceneMeta.DELETED));
				this.setCreateTime( (Date)map.get(AssetScanSceneMeta.CREATE_TIME));
				this.setUpdateBy( (String)map.get(AssetScanSceneMeta.UPDATE_BY));
				this.setDeleteTime( (Date)map.get(AssetScanSceneMeta.DELETE_TIME));
				this.setName( (String)map.get(AssetScanSceneMeta.NAME));
				this.setTenantId( (String)map.get(AssetScanSceneMeta.TENANT_ID));
				this.setDeleteBy( (String)map.get(AssetScanSceneMeta.DELETE_BY));
				this.setId( (String)map.get(AssetScanSceneMeta.ID));
				// others
				this.setMethodDict( (DictItem)map.get(AssetScanSceneMeta.METHOD_DICT));
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
			this.setCode(DataParser.parse(String.class, r.getValue(AssetScanSceneMeta.CODE)));
			this.setMethod(DataParser.parse(String.class, r.getValue(AssetScanSceneMeta.METHOD)));
			this.setUpdateTime(DataParser.parse(Date.class, r.getValue(AssetScanSceneMeta.UPDATE_TIME)));
			this.setVersion(DataParser.parse(Integer.class, r.getValue(AssetScanSceneMeta.VERSION)));
			this.setCreateBy(DataParser.parse(String.class, r.getValue(AssetScanSceneMeta.CREATE_BY)));
			this.setDeleted(DataParser.parse(Integer.class, r.getValue(AssetScanSceneMeta.DELETED)));
			this.setCreateTime(DataParser.parse(Date.class, r.getValue(AssetScanSceneMeta.CREATE_TIME)));
			this.setUpdateBy(DataParser.parse(String.class, r.getValue(AssetScanSceneMeta.UPDATE_BY)));
			this.setDeleteTime(DataParser.parse(Date.class, r.getValue(AssetScanSceneMeta.DELETE_TIME)));
			this.setName(DataParser.parse(String.class, r.getValue(AssetScanSceneMeta.NAME)));
			this.setTenantId(DataParser.parse(String.class, r.getValue(AssetScanSceneMeta.TENANT_ID)));
			this.setDeleteBy(DataParser.parse(String.class, r.getValue(AssetScanSceneMeta.DELETE_BY)));
			this.setId(DataParser.parse(String.class, r.getValue(AssetScanSceneMeta.ID)));
			return true;
		} else {
			try {
				this.setCode( (String)r.getValue(AssetScanSceneMeta.CODE));
				this.setMethod( (String)r.getValue(AssetScanSceneMeta.METHOD));
				this.setUpdateTime( (Date)r.getValue(AssetScanSceneMeta.UPDATE_TIME));
				this.setVersion( (Integer)r.getValue(AssetScanSceneMeta.VERSION));
				this.setCreateBy( (String)r.getValue(AssetScanSceneMeta.CREATE_BY));
				this.setDeleted( (Integer)r.getValue(AssetScanSceneMeta.DELETED));
				this.setCreateTime( (Date)r.getValue(AssetScanSceneMeta.CREATE_TIME));
				this.setUpdateBy( (String)r.getValue(AssetScanSceneMeta.UPDATE_BY));
				this.setDeleteTime( (Date)r.getValue(AssetScanSceneMeta.DELETE_TIME));
				this.setName( (String)r.getValue(AssetScanSceneMeta.NAME));
				this.setTenantId( (String)r.getValue(AssetScanSceneMeta.TENANT_ID));
				this.setDeleteBy( (String)r.getValue(AssetScanSceneMeta.DELETE_BY));
				this.setId( (String)r.getValue(AssetScanSceneMeta.ID));
				return true;
			} catch (Exception e) {
				return false;
			}
		}
	}
}