package com.dt.platform.domain.eam;

import com.github.foxnic.dao.entity.Entity;
import io.swagger.annotations.ApiModel;
import javax.persistence.Table;
import com.github.foxnic.sql.meta.DBTable;
import com.dt.platform.constants.db.EAMTables.EAM_REPAIR_RCD;
import javax.persistence.Id;
import io.swagger.annotations.ApiModelProperty;
import java.util.Date;
import javax.persistence.Transient;
import com.github.foxnic.api.swagger.EnumFor;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.github.foxnic.commons.lang.DataParser;
import java.util.Map;
import com.github.foxnic.dao.entity.EntityContext;
import com.dt.platform.domain.eam.meta.RepairRcdMeta;
import com.github.foxnic.sql.data.ExprRcd;



/**
 * 维修记录
 * <p>维修记录 , 数据表 eam_repair_rcd 的PO类型</p>
 * @author 金杰 , maillank@qq.com
 * @since 2023-08-12 12:15:36
 * @sign 6CE731136A90590F5F0F1A86044A44F4
 * 此文件由工具自动生成，请勿修改。若表结构或配置发生变动，请使用工具重新生成。
*/

@Table(name = "eam_repair_rcd")
@ApiModel(description = "维修记录 ; 维修记录 , 数据表 eam_repair_rcd 的PO类型")
public class RepairRcd extends Entity {

	private static final long serialVersionUID = 1L;

	public static final DBTable TABLE =EAM_REPAIR_RCD.$TABLE;
	
	/**
	 * 主键：主键
	*/
	@Id
	@ApiModelProperty(required = true,value="主键" , notes = "主键")
	private String id;
	
	/**
	 * 单据：单据
	*/
	@ApiModelProperty(required = false,value="单据" , notes = "单据")
	private String businessCode;
	
	/**
	 * 设备：设备
	*/
	@ApiModelProperty(required = false,value="设备" , notes = "设备")
	private String assetId;
	
	/**
	 * 内容：内容
	*/
	@ApiModelProperty(required = false,value="内容" , notes = "内容")
	private String content;
	
	/**
	 * 操作日期：操作日期
	*/
	@ApiModelProperty(required = false,value="操作日期" , notes = "操作日期")
	private Date rcdTime;
	
	/**
	 * 操作人员：操作人员
	*/
	@ApiModelProperty(required = false,value="操作人员" , notes = "操作人员")
	private String operUserId;
	
	/**
	 * 操作人员：操作人员
	*/
	@ApiModelProperty(required = false,value="操作人员" , notes = "操作人员")
	private String operUserName;
	
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
	public RepairRcd setId(String id) {
		this.id=id;
		return this;
	}
	
	/**
	 * 获得 单据<br>
	 * 单据
	 * @return 单据
	*/
	public String getBusinessCode() {
		return businessCode;
	}
	
	/**
	 * 设置 单据
	 * @param businessCode 单据
	 * @return 当前对象
	*/
	public RepairRcd setBusinessCode(String businessCode) {
		this.businessCode=businessCode;
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
	public RepairRcd setAssetId(String assetId) {
		this.assetId=assetId;
		return this;
	}
	
	/**
	 * 获得 内容<br>
	 * 内容
	 * @return 内容
	*/
	public String getContent() {
		return content;
	}
	
	/**
	 * 设置 内容
	 * @param content 内容
	 * @return 当前对象
	*/
	public RepairRcd setContent(String content) {
		this.content=content;
		return this;
	}
	
	/**
	 * 获得 操作日期<br>
	 * 操作日期
	 * @return 操作日期
	*/
	public Date getRcdTime() {
		return rcdTime;
	}
	
	/**
	 * 设置 操作日期
	 * @param rcdTime 操作日期
	 * @return 当前对象
	*/
	public RepairRcd setRcdTime(Date rcdTime) {
		this.rcdTime=rcdTime;
		return this;
	}
	
	/**
	 * 获得 操作人员<br>
	 * 操作人员
	 * @return 操作人员
	*/
	public String getOperUserId() {
		return operUserId;
	}
	
	/**
	 * 设置 操作人员
	 * @param operUserId 操作人员
	 * @return 当前对象
	*/
	public RepairRcd setOperUserId(String operUserId) {
		this.operUserId=operUserId;
		return this;
	}
	
	/**
	 * 获得 操作人员<br>
	 * 操作人员
	 * @return 操作人员
	*/
	public String getOperUserName() {
		return operUserName;
	}
	
	/**
	 * 设置 操作人员
	 * @param operUserName 操作人员
	 * @return 当前对象
	*/
	public RepairRcd setOperUserName(String operUserName) {
		this.operUserName=operUserName;
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
	public RepairRcd setCreateBy(String createBy) {
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
	public RepairRcd setCreateTime(Date createTime) {
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
	public RepairRcd setUpdateBy(String updateBy) {
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
	public RepairRcd setUpdateTime(Date updateTime) {
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
	public RepairRcd setDeleted(Integer deleted) {
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
	public RepairRcd setDeleted(Boolean deletedBool) {
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
	public RepairRcd setDeleteBy(String deleteBy) {
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
	public RepairRcd setDeleteTime(Date deleteTime) {
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
	public RepairRcd setVersion(Integer version) {
		this.version=version;
		return this;
	}

	/**
	 * 将自己转换成指定类型的PO
	 * @param poType  PO类型
	 * @return RepairRcd , 转换好的 RepairRcd 对象
	*/
	@Transient
	public <T extends Entity> T toPO(Class<T> poType) {
		return EntityContext.create(poType, this);
	}

	/**
	 * 将自己转换成任意指定类型
	 * @param pojoType  Pojo类型
	 * @return RepairRcd , 转换好的 PoJo 对象
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
	public RepairRcd clone() {
		return duplicate(true);
	}

	/**
	 * 复制当前对象
	 * @param all 是否复制全部属性，当 false 时，仅复制来自数据表的属性
	*/
	@Transient
	public RepairRcd duplicate(boolean all) {
		com.dt.platform.domain.eam.meta.RepairRcdMeta.$$proxy$$ inst = new com.dt.platform.domain.eam.meta.RepairRcdMeta.$$proxy$$();
		inst.setOperUserId(this.getOperUserId());
		inst.setUpdateTime(this.getUpdateTime());
		inst.setVersion(this.getVersion());
		inst.setContent(this.getContent());
		inst.setBusinessCode(this.getBusinessCode());
		inst.setCreateBy(this.getCreateBy());
		inst.setDeleted(this.getDeleted());
		inst.setCreateTime(this.getCreateTime());
		inst.setUpdateBy(this.getUpdateBy());
		inst.setDeleteTime(this.getDeleteTime());
		inst.setAssetId(this.getAssetId());
		inst.setOperUserName(this.getOperUserName());
		inst.setDeleteBy(this.getDeleteBy());
		inst.setId(this.getId());
		inst.setRcdTime(this.getRcdTime());
		inst.clearModifies();
		return inst;
	}

	/**
	 * 克隆当前对象
	*/
	@Transient
	public RepairRcd clone(boolean deep) {
		return EntityContext.clone(RepairRcd.class,this,deep);
	}

	/**
	 * 将 Map 转换成 RepairRcd
	 * @param repairRcdMap 包含实体信息的 Map 对象
	 * @return RepairRcd , 转换好的的 RepairRcd 对象
	*/
	@Transient
	public static RepairRcd createFrom(Map<String,Object> repairRcdMap) {
		if(repairRcdMap==null) return null;
		RepairRcd po = create();
		EntityContext.copyProperties(po,repairRcdMap);
		po.clearModifies();
		return po;
	}

	/**
	 * 将 Pojo 转换成 RepairRcd
	 * @param pojo 包含实体信息的 Pojo 对象
	 * @return RepairRcd , 转换好的的 RepairRcd 对象
	*/
	@Transient
	public static RepairRcd createFrom(Object pojo) {
		if(pojo==null) return null;
		RepairRcd po = create();
		EntityContext.copyProperties(po,pojo);
		po.clearModifies();
		return po;
	}

	/**
	 * 创建一个 RepairRcd，等同于 new
	 * @return RepairRcd 对象
	*/
	@Transient
	public static RepairRcd create() {
		return new com.dt.platform.domain.eam.meta.RepairRcdMeta.$$proxy$$();
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
			this.setOperUserId(DataParser.parse(String.class, map.get(RepairRcdMeta.OPER_USER_ID)));
			this.setUpdateTime(DataParser.parse(Date.class, map.get(RepairRcdMeta.UPDATE_TIME)));
			this.setVersion(DataParser.parse(Integer.class, map.get(RepairRcdMeta.VERSION)));
			this.setContent(DataParser.parse(String.class, map.get(RepairRcdMeta.CONTENT)));
			this.setBusinessCode(DataParser.parse(String.class, map.get(RepairRcdMeta.BUSINESS_CODE)));
			this.setCreateBy(DataParser.parse(String.class, map.get(RepairRcdMeta.CREATE_BY)));
			this.setDeleted(DataParser.parse(Integer.class, map.get(RepairRcdMeta.DELETED)));
			this.setCreateTime(DataParser.parse(Date.class, map.get(RepairRcdMeta.CREATE_TIME)));
			this.setUpdateBy(DataParser.parse(String.class, map.get(RepairRcdMeta.UPDATE_BY)));
			this.setDeleteTime(DataParser.parse(Date.class, map.get(RepairRcdMeta.DELETE_TIME)));
			this.setAssetId(DataParser.parse(String.class, map.get(RepairRcdMeta.ASSET_ID)));
			this.setOperUserName(DataParser.parse(String.class, map.get(RepairRcdMeta.OPER_USER_NAME)));
			this.setDeleteBy(DataParser.parse(String.class, map.get(RepairRcdMeta.DELETE_BY)));
			this.setId(DataParser.parse(String.class, map.get(RepairRcdMeta.ID)));
			this.setRcdTime(DataParser.parse(Date.class, map.get(RepairRcdMeta.RCD_TIME)));
			// others
			return true;
		} else {
			try {
				this.setOperUserId( (String)map.get(RepairRcdMeta.OPER_USER_ID));
				this.setUpdateTime( (Date)map.get(RepairRcdMeta.UPDATE_TIME));
				this.setVersion( (Integer)map.get(RepairRcdMeta.VERSION));
				this.setContent( (String)map.get(RepairRcdMeta.CONTENT));
				this.setBusinessCode( (String)map.get(RepairRcdMeta.BUSINESS_CODE));
				this.setCreateBy( (String)map.get(RepairRcdMeta.CREATE_BY));
				this.setDeleted( (Integer)map.get(RepairRcdMeta.DELETED));
				this.setCreateTime( (Date)map.get(RepairRcdMeta.CREATE_TIME));
				this.setUpdateBy( (String)map.get(RepairRcdMeta.UPDATE_BY));
				this.setDeleteTime( (Date)map.get(RepairRcdMeta.DELETE_TIME));
				this.setAssetId( (String)map.get(RepairRcdMeta.ASSET_ID));
				this.setOperUserName( (String)map.get(RepairRcdMeta.OPER_USER_NAME));
				this.setDeleteBy( (String)map.get(RepairRcdMeta.DELETE_BY));
				this.setId( (String)map.get(RepairRcdMeta.ID));
				this.setRcdTime( (Date)map.get(RepairRcdMeta.RCD_TIME));
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
			this.setOperUserId(DataParser.parse(String.class, r.getValue(RepairRcdMeta.OPER_USER_ID)));
			this.setUpdateTime(DataParser.parse(Date.class, r.getValue(RepairRcdMeta.UPDATE_TIME)));
			this.setVersion(DataParser.parse(Integer.class, r.getValue(RepairRcdMeta.VERSION)));
			this.setContent(DataParser.parse(String.class, r.getValue(RepairRcdMeta.CONTENT)));
			this.setBusinessCode(DataParser.parse(String.class, r.getValue(RepairRcdMeta.BUSINESS_CODE)));
			this.setCreateBy(DataParser.parse(String.class, r.getValue(RepairRcdMeta.CREATE_BY)));
			this.setDeleted(DataParser.parse(Integer.class, r.getValue(RepairRcdMeta.DELETED)));
			this.setCreateTime(DataParser.parse(Date.class, r.getValue(RepairRcdMeta.CREATE_TIME)));
			this.setUpdateBy(DataParser.parse(String.class, r.getValue(RepairRcdMeta.UPDATE_BY)));
			this.setDeleteTime(DataParser.parse(Date.class, r.getValue(RepairRcdMeta.DELETE_TIME)));
			this.setAssetId(DataParser.parse(String.class, r.getValue(RepairRcdMeta.ASSET_ID)));
			this.setOperUserName(DataParser.parse(String.class, r.getValue(RepairRcdMeta.OPER_USER_NAME)));
			this.setDeleteBy(DataParser.parse(String.class, r.getValue(RepairRcdMeta.DELETE_BY)));
			this.setId(DataParser.parse(String.class, r.getValue(RepairRcdMeta.ID)));
			this.setRcdTime(DataParser.parse(Date.class, r.getValue(RepairRcdMeta.RCD_TIME)));
			return true;
		} else {
			try {
				this.setOperUserId( (String)r.getValue(RepairRcdMeta.OPER_USER_ID));
				this.setUpdateTime( (Date)r.getValue(RepairRcdMeta.UPDATE_TIME));
				this.setVersion( (Integer)r.getValue(RepairRcdMeta.VERSION));
				this.setContent( (String)r.getValue(RepairRcdMeta.CONTENT));
				this.setBusinessCode( (String)r.getValue(RepairRcdMeta.BUSINESS_CODE));
				this.setCreateBy( (String)r.getValue(RepairRcdMeta.CREATE_BY));
				this.setDeleted( (Integer)r.getValue(RepairRcdMeta.DELETED));
				this.setCreateTime( (Date)r.getValue(RepairRcdMeta.CREATE_TIME));
				this.setUpdateBy( (String)r.getValue(RepairRcdMeta.UPDATE_BY));
				this.setDeleteTime( (Date)r.getValue(RepairRcdMeta.DELETE_TIME));
				this.setAssetId( (String)r.getValue(RepairRcdMeta.ASSET_ID));
				this.setOperUserName( (String)r.getValue(RepairRcdMeta.OPER_USER_NAME));
				this.setDeleteBy( (String)r.getValue(RepairRcdMeta.DELETE_BY));
				this.setId( (String)r.getValue(RepairRcdMeta.ID));
				this.setRcdTime( (Date)r.getValue(RepairRcdMeta.RCD_TIME));
				return true;
			} catch (Exception e) {
				return false;
			}
		}
	}
}