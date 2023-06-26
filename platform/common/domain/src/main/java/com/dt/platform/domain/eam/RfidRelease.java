package com.dt.platform.domain.eam;

import com.github.foxnic.dao.entity.Entity;
import io.swagger.annotations.ApiModel;
import javax.persistence.Table;
import com.github.foxnic.sql.meta.DBTable;
import com.dt.platform.constants.db.EAMTables.EAM_RFID_RELEASE;
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
import com.dt.platform.domain.eam.meta.RfidReleaseMeta;
import com.github.foxnic.sql.data.ExprRcd;



/**
 * RFID发卡
 * <p>RFID发卡 , 数据表 eam_rfid_release 的PO类型</p>
 * @author 金杰 , maillank@qq.com
 * @since 2023-06-23 20:46:17
 * @sign 9AE755EF846B1727521AE5AB9893C4CE
 * 此文件由工具自动生成，请勿修改。若表结构或配置发生变动，请使用工具重新生成。
*/

@Table(name = "eam_rfid_release")
@ApiModel(description = "RFID发卡 ; RFID发卡 , 数据表 eam_rfid_release 的PO类型")
public class RfidRelease extends Entity {

	private static final long serialVersionUID = 1L;

	public static final DBTable TABLE =EAM_RFID_RELEASE.$TABLE;
	
	/**
	 * 主键：主键
	*/
	@Id
	@ApiModelProperty(required = true,value="主键" , notes = "主键" , example = "724709211031732224")
	private String id;
	
	/**
	 * 名称：名称
	*/
	@ApiModelProperty(required = false,value="名称" , notes = "名称" , example = "`12")
	private String name;
	
	/**
	 * 状态：状态
	*/
	@ApiModelProperty(required = false,value="状态" , notes = "状态")
	private String status;
	
	/**
	 * 备注：备注
	*/
	@ApiModelProperty(required = false,value="备注" , notes = "备注" , example = "121212")
	private String notes;
	
	/**
	 * 创建人ID：创建人ID
	*/
	@ApiModelProperty(required = false,value="创建人ID" , notes = "创建人ID" , example = "110588348101165911")
	private String createBy;
	
	/**
	 * 创建时间：创建时间
	*/
	@ApiModelProperty(required = false,value="创建时间" , notes = "创建时间" , example = "2023-06-23 07:35:40")
	private Date createTime;
	
	/**
	 * 修改人ID：修改人ID
	*/
	@ApiModelProperty(required = false,value="修改人ID" , notes = "修改人ID" , example = "110588348101165911")
	private String updateBy;
	
	/**
	 * 修改时间：修改时间
	*/
	@ApiModelProperty(required = false,value="修改时间" , notes = "修改时间" , example = "2023-06-23 07:55:14")
	private Date updateTime;
	
	/**
	 * 是否已删除：是否已删除
	*/
	@ApiModelProperty(required = true,value="是否已删除" , notes = "是否已删除" , example = "1")
	private Integer deleted;
	@Transient
	@EnumFor("deleted")
	private Boolean deletedBool;
	
	/**
	 * 删除人ID：删除人ID
	*/
	@ApiModelProperty(required = false,value="删除人ID" , notes = "删除人ID" , example = "110588348101165911")
	private String deleteBy;
	
	/**
	 * 删除时间：删除时间
	*/
	@ApiModelProperty(required = false,value="删除时间" , notes = "删除时间" , example = "2023-06-23 07:55:14")
	private Date deleteTime;
	
	/**
	 * 租户：租户
	*/
	@ApiModelProperty(required = false,value="租户" , notes = "租户" , example = "T001")
	private String tenantId;
	
	/**
	 * version：version
	*/
	@ApiModelProperty(required = true,value="version" , notes = "version" , example = "2")
	private Integer version;
	
	/**
	 * rfidLabelList：rfidLabelList
	*/
	@ApiModelProperty(required = false,value="rfidLabelList" , notes = "rfidLabelList")
	private List<RfidLabel> rfidLabelList;
	
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
	public RfidRelease setId(String id) {
		this.id=id;
		return this;
	}
	
	/**
	 * 获得 名称<br>
	 * 名称
	 * @return 名称
	*/
	public String getName() {
		return name;
	}
	
	/**
	 * 设置 名称
	 * @param name 名称
	 * @return 当前对象
	*/
	public RfidRelease setName(String name) {
		this.name=name;
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
	public RfidRelease setStatus(String status) {
		this.status=status;
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
	public RfidRelease setNotes(String notes) {
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
	public RfidRelease setCreateBy(String createBy) {
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
	public RfidRelease setCreateTime(Date createTime) {
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
	public RfidRelease setUpdateBy(String updateBy) {
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
	public RfidRelease setUpdateTime(Date updateTime) {
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
	public RfidRelease setDeleted(Integer deleted) {
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
	public RfidRelease setDeleted(Boolean deletedBool) {
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
	public RfidRelease setDeleteBy(String deleteBy) {
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
	public RfidRelease setDeleteTime(Date deleteTime) {
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
	public RfidRelease setTenantId(String tenantId) {
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
	public RfidRelease setVersion(Integer version) {
		this.version=version;
		return this;
	}
	
	/**
	 * 获得 rfidLabelList<br>
	 * rfidLabelList
	 * @return rfidLabelList
	*/
	public List<RfidLabel> getRfidLabelList() {
		return rfidLabelList;
	}
	
	/**
	 * 设置 rfidLabelList
	 * @param rfidLabelList rfidLabelList
	 * @return 当前对象
	*/
	public RfidRelease setRfidLabelList(List<RfidLabel> rfidLabelList) {
		this.rfidLabelList=rfidLabelList;
		return this;
	}
	
	/**
	 * 添加 rfidLabelList
	 * @param rfidLabel rfidLabelList
	 * @return 当前对象
	*/
	public RfidRelease addRfidLabel(RfidLabel... rfidLabel) {
		if(this.rfidLabelList==null) rfidLabelList=new ArrayList<>();
		this.rfidLabelList.addAll(Arrays.asList(rfidLabel));
		return this;
	}

	/**
	 * 将自己转换成指定类型的PO
	 * @param poType  PO类型
	 * @return RfidRelease , 转换好的 RfidRelease 对象
	*/
	@Transient
	public <T extends Entity> T toPO(Class<T> poType) {
		return EntityContext.create(poType, this);
	}

	/**
	 * 将自己转换成任意指定类型
	 * @param pojoType  Pojo类型
	 * @return RfidRelease , 转换好的 PoJo 对象
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
	public RfidRelease clone() {
		return duplicate(true);
	}

	/**
	 * 复制当前对象
	 * @param all 是否复制全部属性，当 false 时，仅复制来自数据表的属性
	*/
	@Transient
	public RfidRelease duplicate(boolean all) {
		com.dt.platform.domain.eam.meta.RfidReleaseMeta.$$proxy$$ inst = new com.dt.platform.domain.eam.meta.RfidReleaseMeta.$$proxy$$();
		inst.setNotes(this.getNotes());
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
		inst.setStatus(this.getStatus());
		if(all) {
			inst.setRfidLabelList(this.getRfidLabelList());
		}
		inst.clearModifies();
		return inst;
	}

	/**
	 * 克隆当前对象
	*/
	@Transient
	public RfidRelease clone(boolean deep) {
		return EntityContext.clone(RfidRelease.class,this,deep);
	}

	/**
	 * 将 Map 转换成 RfidRelease
	 * @param rfidReleaseMap 包含实体信息的 Map 对象
	 * @return RfidRelease , 转换好的的 RfidRelease 对象
	*/
	@Transient
	public static RfidRelease createFrom(Map<String,Object> rfidReleaseMap) {
		if(rfidReleaseMap==null) return null;
		RfidRelease po = create();
		EntityContext.copyProperties(po,rfidReleaseMap);
		po.clearModifies();
		return po;
	}

	/**
	 * 将 Pojo 转换成 RfidRelease
	 * @param pojo 包含实体信息的 Pojo 对象
	 * @return RfidRelease , 转换好的的 RfidRelease 对象
	*/
	@Transient
	public static RfidRelease createFrom(Object pojo) {
		if(pojo==null) return null;
		RfidRelease po = create();
		EntityContext.copyProperties(po,pojo);
		po.clearModifies();
		return po;
	}

	/**
	 * 创建一个 RfidRelease，等同于 new
	 * @return RfidRelease 对象
	*/
	@Transient
	public static RfidRelease create() {
		return new com.dt.platform.domain.eam.meta.RfidReleaseMeta.$$proxy$$();
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
			this.setNotes(DataParser.parse(String.class, map.get(RfidReleaseMeta.NOTES)));
			this.setUpdateTime(DataParser.parse(Date.class, map.get(RfidReleaseMeta.UPDATE_TIME)));
			this.setVersion(DataParser.parse(Integer.class, map.get(RfidReleaseMeta.VERSION)));
			this.setCreateBy(DataParser.parse(String.class, map.get(RfidReleaseMeta.CREATE_BY)));
			this.setDeleted(DataParser.parse(Integer.class, map.get(RfidReleaseMeta.DELETED)));
			this.setCreateTime(DataParser.parse(Date.class, map.get(RfidReleaseMeta.CREATE_TIME)));
			this.setUpdateBy(DataParser.parse(String.class, map.get(RfidReleaseMeta.UPDATE_BY)));
			this.setDeleteTime(DataParser.parse(Date.class, map.get(RfidReleaseMeta.DELETE_TIME)));
			this.setName(DataParser.parse(String.class, map.get(RfidReleaseMeta.NAME)));
			this.setTenantId(DataParser.parse(String.class, map.get(RfidReleaseMeta.TENANT_ID)));
			this.setDeleteBy(DataParser.parse(String.class, map.get(RfidReleaseMeta.DELETE_BY)));
			this.setId(DataParser.parse(String.class, map.get(RfidReleaseMeta.ID)));
			this.setStatus(DataParser.parse(String.class, map.get(RfidReleaseMeta.STATUS)));
			// others
			return true;
		} else {
			try {
				this.setNotes( (String)map.get(RfidReleaseMeta.NOTES));
				this.setUpdateTime( (Date)map.get(RfidReleaseMeta.UPDATE_TIME));
				this.setVersion( (Integer)map.get(RfidReleaseMeta.VERSION));
				this.setCreateBy( (String)map.get(RfidReleaseMeta.CREATE_BY));
				this.setDeleted( (Integer)map.get(RfidReleaseMeta.DELETED));
				this.setCreateTime( (Date)map.get(RfidReleaseMeta.CREATE_TIME));
				this.setUpdateBy( (String)map.get(RfidReleaseMeta.UPDATE_BY));
				this.setDeleteTime( (Date)map.get(RfidReleaseMeta.DELETE_TIME));
				this.setName( (String)map.get(RfidReleaseMeta.NAME));
				this.setTenantId( (String)map.get(RfidReleaseMeta.TENANT_ID));
				this.setDeleteBy( (String)map.get(RfidReleaseMeta.DELETE_BY));
				this.setId( (String)map.get(RfidReleaseMeta.ID));
				this.setStatus( (String)map.get(RfidReleaseMeta.STATUS));
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
			this.setNotes(DataParser.parse(String.class, r.getValue(RfidReleaseMeta.NOTES)));
			this.setUpdateTime(DataParser.parse(Date.class, r.getValue(RfidReleaseMeta.UPDATE_TIME)));
			this.setVersion(DataParser.parse(Integer.class, r.getValue(RfidReleaseMeta.VERSION)));
			this.setCreateBy(DataParser.parse(String.class, r.getValue(RfidReleaseMeta.CREATE_BY)));
			this.setDeleted(DataParser.parse(Integer.class, r.getValue(RfidReleaseMeta.DELETED)));
			this.setCreateTime(DataParser.parse(Date.class, r.getValue(RfidReleaseMeta.CREATE_TIME)));
			this.setUpdateBy(DataParser.parse(String.class, r.getValue(RfidReleaseMeta.UPDATE_BY)));
			this.setDeleteTime(DataParser.parse(Date.class, r.getValue(RfidReleaseMeta.DELETE_TIME)));
			this.setName(DataParser.parse(String.class, r.getValue(RfidReleaseMeta.NAME)));
			this.setTenantId(DataParser.parse(String.class, r.getValue(RfidReleaseMeta.TENANT_ID)));
			this.setDeleteBy(DataParser.parse(String.class, r.getValue(RfidReleaseMeta.DELETE_BY)));
			this.setId(DataParser.parse(String.class, r.getValue(RfidReleaseMeta.ID)));
			this.setStatus(DataParser.parse(String.class, r.getValue(RfidReleaseMeta.STATUS)));
			return true;
		} else {
			try {
				this.setNotes( (String)r.getValue(RfidReleaseMeta.NOTES));
				this.setUpdateTime( (Date)r.getValue(RfidReleaseMeta.UPDATE_TIME));
				this.setVersion( (Integer)r.getValue(RfidReleaseMeta.VERSION));
				this.setCreateBy( (String)r.getValue(RfidReleaseMeta.CREATE_BY));
				this.setDeleted( (Integer)r.getValue(RfidReleaseMeta.DELETED));
				this.setCreateTime( (Date)r.getValue(RfidReleaseMeta.CREATE_TIME));
				this.setUpdateBy( (String)r.getValue(RfidReleaseMeta.UPDATE_BY));
				this.setDeleteTime( (Date)r.getValue(RfidReleaseMeta.DELETE_TIME));
				this.setName( (String)r.getValue(RfidReleaseMeta.NAME));
				this.setTenantId( (String)r.getValue(RfidReleaseMeta.TENANT_ID));
				this.setDeleteBy( (String)r.getValue(RfidReleaseMeta.DELETE_BY));
				this.setId( (String)r.getValue(RfidReleaseMeta.ID));
				this.setStatus( (String)r.getValue(RfidReleaseMeta.STATUS));
				return true;
			} catch (Exception e) {
				return false;
			}
		}
	}
}