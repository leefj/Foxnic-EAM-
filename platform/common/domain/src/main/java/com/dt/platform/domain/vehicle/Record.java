package com.dt.platform.domain.vehicle;

import com.github.foxnic.dao.entity.Entity;
import io.swagger.annotations.ApiModel;
import javax.persistence.Table;
import com.github.foxnic.sql.meta.DBTable;
import com.dt.platform.constants.db.OaTables.OA_ROOM_RECORD;
import javax.persistence.Id;
import io.swagger.annotations.ApiModelProperty;
import java.util.Date;
import javax.persistence.Transient;
import com.github.foxnic.api.swagger.EnumFor;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.github.foxnic.commons.lang.DataParser;
import java.util.Map;
import com.github.foxnic.dao.entity.EntityContext;
import com.dt.platform.domain.vehicle.meta.RecordMeta;
import com.github.foxnic.sql.data.ExprRcd;



/**
 * 使用记录
 * <p>使用记录 , 数据表 oa_room_record 的PO类型</p>
 * @author 金杰 , maillank@qq.com
 * @since 2023-05-09 12:47:55
 * @sign BFEF1590C358AF820B4A5FEB2BF660EB
 * 此文件由工具自动生成，请勿修改。若表结构或配置发生变动，请使用工具重新生成。
*/

@Table(name = "oa_room_record")
@ApiModel(description = "使用记录 ; 使用记录 , 数据表 oa_room_record 的PO类型")
public class Record extends Entity {

	private static final long serialVersionUID = 1L;

	public static final DBTable TABLE =OA_ROOM_RECORD.$TABLE;
	
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
	 * 使用类型：使用类型
	*/
	@ApiModelProperty(required = false,value="使用类型" , notes = "使用类型")
	private String businessType;
	
	/**
	 * 车辆：车辆
	*/
	@ApiModelProperty(required = false,value="车辆" , notes = "车辆")
	private String roomId;
	
	/**
	 * 开始时间：开始时间
	*/
	@ApiModelProperty(required = false,value="开始时间" , notes = "开始时间")
	private Date stime;
	
	/**
	 * 结束时间：结束时间
	*/
	@ApiModelProperty(required = false,value="结束时间" , notes = "结束时间")
	private Date etime;
	
	/**
	 * 使用说明：使用说明
	*/
	@ApiModelProperty(required = false,value="使用说明" , notes = "使用说明")
	private String info;
	
	/**
	 * 制单人：制单人
	*/
	@ApiModelProperty(required = false,value="制单人" , notes = "制单人")
	private String originatorId;
	
	/**
	 * 备注：备注
	*/
	@ApiModelProperty(required = false,value="备注" , notes = "备注")
	private String notes;
	
	/**
	 * 版本：版本
	*/
	@ApiModelProperty(required = true,value="版本" , notes = "版本")
	private Integer version;
	
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
	 * 租户：租户
	*/
	@ApiModelProperty(required = false,value="租户" , notes = "租户")
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
	public Record setId(String id) {
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
	public Record setBusinessCode(String businessCode) {
		this.businessCode=businessCode;
		return this;
	}
	
	/**
	 * 获得 使用类型<br>
	 * 使用类型
	 * @return 使用类型
	*/
	public String getBusinessType() {
		return businessType;
	}
	
	/**
	 * 设置 使用类型
	 * @param businessType 使用类型
	 * @return 当前对象
	*/
	public Record setBusinessType(String businessType) {
		this.businessType=businessType;
		return this;
	}
	
	/**
	 * 获得 车辆<br>
	 * 车辆
	 * @return 车辆
	*/
	public String getRoomId() {
		return roomId;
	}
	
	/**
	 * 设置 车辆
	 * @param roomId 车辆
	 * @return 当前对象
	*/
	public Record setRoomId(String roomId) {
		this.roomId=roomId;
		return this;
	}
	
	/**
	 * 获得 开始时间<br>
	 * 开始时间
	 * @return 开始时间
	*/
	public Date getStime() {
		return stime;
	}
	
	/**
	 * 设置 开始时间
	 * @param stime 开始时间
	 * @return 当前对象
	*/
	public Record setStime(Date stime) {
		this.stime=stime;
		return this;
	}
	
	/**
	 * 获得 结束时间<br>
	 * 结束时间
	 * @return 结束时间
	*/
	public Date getEtime() {
		return etime;
	}
	
	/**
	 * 设置 结束时间
	 * @param etime 结束时间
	 * @return 当前对象
	*/
	public Record setEtime(Date etime) {
		this.etime=etime;
		return this;
	}
	
	/**
	 * 获得 使用说明<br>
	 * 使用说明
	 * @return 使用说明
	*/
	public String getInfo() {
		return info;
	}
	
	/**
	 * 设置 使用说明
	 * @param info 使用说明
	 * @return 当前对象
	*/
	public Record setInfo(String info) {
		this.info=info;
		return this;
	}
	
	/**
	 * 获得 制单人<br>
	 * 制单人
	 * @return 制单人
	*/
	public String getOriginatorId() {
		return originatorId;
	}
	
	/**
	 * 设置 制单人
	 * @param originatorId 制单人
	 * @return 当前对象
	*/
	public Record setOriginatorId(String originatorId) {
		this.originatorId=originatorId;
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
	public Record setNotes(String notes) {
		this.notes=notes;
		return this;
	}
	
	/**
	 * 获得 版本<br>
	 * 版本
	 * @return 版本
	*/
	public Integer getVersion() {
		return version;
	}
	
	/**
	 * 设置 版本
	 * @param version 版本
	 * @return 当前对象
	*/
	public Record setVersion(Integer version) {
		this.version=version;
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
	public Record setCreateBy(String createBy) {
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
	public Record setCreateTime(Date createTime) {
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
	public Record setUpdateBy(String updateBy) {
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
	public Record setUpdateTime(Date updateTime) {
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
	public Record setDeleted(Integer deleted) {
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
	public Record setDeleted(Boolean deletedBool) {
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
	public Record setDeleteBy(String deleteBy) {
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
	public Record setDeleteTime(Date deleteTime) {
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
	public Record setTenantId(String tenantId) {
		this.tenantId=tenantId;
		return this;
	}

	/**
	 * 将自己转换成指定类型的PO
	 * @param poType  PO类型
	 * @return Record , 转换好的 Record 对象
	*/
	@Transient
	public <T extends Entity> T toPO(Class<T> poType) {
		return EntityContext.create(poType, this);
	}

	/**
	 * 将自己转换成任意指定类型
	 * @param pojoType  Pojo类型
	 * @return Record , 转换好的 PoJo 对象
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
	public Record clone() {
		return duplicate(true);
	}

	/**
	 * 复制当前对象
	 * @param all 是否复制全部属性，当 false 时，仅复制来自数据表的属性
	*/
	@Transient
	public Record duplicate(boolean all) {
		com.dt.platform.domain.vehicle.meta.RecordMeta.$$proxy$$ inst = new com.dt.platform.domain.vehicle.meta.RecordMeta.$$proxy$$();
		inst.setNotes(this.getNotes());
		inst.setStime(this.getStime());
		inst.setUpdateTime(this.getUpdateTime());
		inst.setVersion(this.getVersion());
		inst.setRoomId(this.getRoomId());
		inst.setBusinessCode(this.getBusinessCode());
		inst.setCreateBy(this.getCreateBy());
		inst.setDeleted(this.getDeleted());
		inst.setCreateTime(this.getCreateTime());
		inst.setUpdateBy(this.getUpdateBy());
		inst.setDeleteTime(this.getDeleteTime());
		inst.setEtime(this.getEtime());
		inst.setTenantId(this.getTenantId());
		inst.setDeleteBy(this.getDeleteBy());
		inst.setId(this.getId());
		inst.setOriginatorId(this.getOriginatorId());
		inst.setBusinessType(this.getBusinessType());
		inst.setInfo(this.getInfo());
		inst.clearModifies();
		return inst;
	}

	/**
	 * 克隆当前对象
	*/
	@Transient
	public Record clone(boolean deep) {
		return EntityContext.clone(Record.class,this,deep);
	}

	/**
	 * 将 Map 转换成 Record
	 * @param recordMap 包含实体信息的 Map 对象
	 * @return Record , 转换好的的 Record 对象
	*/
	@Transient
	public static Record createFrom(Map<String,Object> recordMap) {
		if(recordMap==null) return null;
		Record po = create();
		EntityContext.copyProperties(po,recordMap);
		po.clearModifies();
		return po;
	}

	/**
	 * 将 Pojo 转换成 Record
	 * @param pojo 包含实体信息的 Pojo 对象
	 * @return Record , 转换好的的 Record 对象
	*/
	@Transient
	public static Record createFrom(Object pojo) {
		if(pojo==null) return null;
		Record po = create();
		EntityContext.copyProperties(po,pojo);
		po.clearModifies();
		return po;
	}

	/**
	 * 创建一个 Record，等同于 new
	 * @return Record 对象
	*/
	@Transient
	public static Record create() {
		return new com.dt.platform.domain.vehicle.meta.RecordMeta.$$proxy$$();
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
			this.setNotes(DataParser.parse(String.class, map.get(RecordMeta.NOTES)));
			this.setStime(DataParser.parse(Date.class, map.get(RecordMeta.STIME)));
			this.setUpdateTime(DataParser.parse(Date.class, map.get(RecordMeta.UPDATE_TIME)));
			this.setVersion(DataParser.parse(Integer.class, map.get(RecordMeta.VERSION)));
			this.setRoomId(DataParser.parse(String.class, map.get(RecordMeta.ROOM_ID)));
			this.setBusinessCode(DataParser.parse(String.class, map.get(RecordMeta.BUSINESS_CODE)));
			this.setCreateBy(DataParser.parse(String.class, map.get(RecordMeta.CREATE_BY)));
			this.setDeleted(DataParser.parse(Integer.class, map.get(RecordMeta.DELETED)));
			this.setCreateTime(DataParser.parse(Date.class, map.get(RecordMeta.CREATE_TIME)));
			this.setUpdateBy(DataParser.parse(String.class, map.get(RecordMeta.UPDATE_BY)));
			this.setDeleteTime(DataParser.parse(Date.class, map.get(RecordMeta.DELETE_TIME)));
			this.setEtime(DataParser.parse(Date.class, map.get(RecordMeta.ETIME)));
			this.setTenantId(DataParser.parse(String.class, map.get(RecordMeta.TENANT_ID)));
			this.setDeleteBy(DataParser.parse(String.class, map.get(RecordMeta.DELETE_BY)));
			this.setId(DataParser.parse(String.class, map.get(RecordMeta.ID)));
			this.setOriginatorId(DataParser.parse(String.class, map.get(RecordMeta.ORIGINATOR_ID)));
			this.setBusinessType(DataParser.parse(String.class, map.get(RecordMeta.BUSINESS_TYPE)));
			this.setInfo(DataParser.parse(String.class, map.get(RecordMeta.INFO)));
			// others
			return true;
		} else {
			try {
				this.setNotes( (String)map.get(RecordMeta.NOTES));
				this.setStime( (Date)map.get(RecordMeta.STIME));
				this.setUpdateTime( (Date)map.get(RecordMeta.UPDATE_TIME));
				this.setVersion( (Integer)map.get(RecordMeta.VERSION));
				this.setRoomId( (String)map.get(RecordMeta.ROOM_ID));
				this.setBusinessCode( (String)map.get(RecordMeta.BUSINESS_CODE));
				this.setCreateBy( (String)map.get(RecordMeta.CREATE_BY));
				this.setDeleted( (Integer)map.get(RecordMeta.DELETED));
				this.setCreateTime( (Date)map.get(RecordMeta.CREATE_TIME));
				this.setUpdateBy( (String)map.get(RecordMeta.UPDATE_BY));
				this.setDeleteTime( (Date)map.get(RecordMeta.DELETE_TIME));
				this.setEtime( (Date)map.get(RecordMeta.ETIME));
				this.setTenantId( (String)map.get(RecordMeta.TENANT_ID));
				this.setDeleteBy( (String)map.get(RecordMeta.DELETE_BY));
				this.setId( (String)map.get(RecordMeta.ID));
				this.setOriginatorId( (String)map.get(RecordMeta.ORIGINATOR_ID));
				this.setBusinessType( (String)map.get(RecordMeta.BUSINESS_TYPE));
				this.setInfo( (String)map.get(RecordMeta.INFO));
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
			this.setNotes(DataParser.parse(String.class, r.getValue(RecordMeta.NOTES)));
			this.setStime(DataParser.parse(Date.class, r.getValue(RecordMeta.STIME)));
			this.setUpdateTime(DataParser.parse(Date.class, r.getValue(RecordMeta.UPDATE_TIME)));
			this.setVersion(DataParser.parse(Integer.class, r.getValue(RecordMeta.VERSION)));
			this.setRoomId(DataParser.parse(String.class, r.getValue(RecordMeta.ROOM_ID)));
			this.setBusinessCode(DataParser.parse(String.class, r.getValue(RecordMeta.BUSINESS_CODE)));
			this.setCreateBy(DataParser.parse(String.class, r.getValue(RecordMeta.CREATE_BY)));
			this.setDeleted(DataParser.parse(Integer.class, r.getValue(RecordMeta.DELETED)));
			this.setCreateTime(DataParser.parse(Date.class, r.getValue(RecordMeta.CREATE_TIME)));
			this.setUpdateBy(DataParser.parse(String.class, r.getValue(RecordMeta.UPDATE_BY)));
			this.setDeleteTime(DataParser.parse(Date.class, r.getValue(RecordMeta.DELETE_TIME)));
			this.setEtime(DataParser.parse(Date.class, r.getValue(RecordMeta.ETIME)));
			this.setTenantId(DataParser.parse(String.class, r.getValue(RecordMeta.TENANT_ID)));
			this.setDeleteBy(DataParser.parse(String.class, r.getValue(RecordMeta.DELETE_BY)));
			this.setId(DataParser.parse(String.class, r.getValue(RecordMeta.ID)));
			this.setOriginatorId(DataParser.parse(String.class, r.getValue(RecordMeta.ORIGINATOR_ID)));
			this.setBusinessType(DataParser.parse(String.class, r.getValue(RecordMeta.BUSINESS_TYPE)));
			this.setInfo(DataParser.parse(String.class, r.getValue(RecordMeta.INFO)));
			return true;
		} else {
			try {
				this.setNotes( (String)r.getValue(RecordMeta.NOTES));
				this.setStime( (Date)r.getValue(RecordMeta.STIME));
				this.setUpdateTime( (Date)r.getValue(RecordMeta.UPDATE_TIME));
				this.setVersion( (Integer)r.getValue(RecordMeta.VERSION));
				this.setRoomId( (String)r.getValue(RecordMeta.ROOM_ID));
				this.setBusinessCode( (String)r.getValue(RecordMeta.BUSINESS_CODE));
				this.setCreateBy( (String)r.getValue(RecordMeta.CREATE_BY));
				this.setDeleted( (Integer)r.getValue(RecordMeta.DELETED));
				this.setCreateTime( (Date)r.getValue(RecordMeta.CREATE_TIME));
				this.setUpdateBy( (String)r.getValue(RecordMeta.UPDATE_BY));
				this.setDeleteTime( (Date)r.getValue(RecordMeta.DELETE_TIME));
				this.setEtime( (Date)r.getValue(RecordMeta.ETIME));
				this.setTenantId( (String)r.getValue(RecordMeta.TENANT_ID));
				this.setDeleteBy( (String)r.getValue(RecordMeta.DELETE_BY));
				this.setId( (String)r.getValue(RecordMeta.ID));
				this.setOriginatorId( (String)r.getValue(RecordMeta.ORIGINATOR_ID));
				this.setBusinessType( (String)r.getValue(RecordMeta.BUSINESS_TYPE));
				this.setInfo( (String)r.getValue(RecordMeta.INFO));
				return true;
			} catch (Exception e) {
				return false;
			}
		}
	}
}