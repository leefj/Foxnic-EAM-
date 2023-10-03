package com.dt.platform.domain.oa;

import com.github.foxnic.dao.entity.Entity;
import io.swagger.annotations.ApiModel;
import javax.persistence.Table;
import com.github.foxnic.sql.meta.DBTable;
import com.dt.platform.constants.db.OaTables.OA_NETDISK_OPER_RECORD;
import javax.persistence.Id;
import io.swagger.annotations.ApiModelProperty;
import java.util.Date;
import javax.persistence.Transient;
import com.github.foxnic.api.swagger.EnumFor;
import org.github.foxnic.web.domain.hrm.Employee;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.github.foxnic.commons.lang.DataParser;
import java.util.Map;
import com.github.foxnic.dao.entity.EntityContext;
import com.dt.platform.domain.oa.meta.NetdiskOperRecordMeta;
import com.github.foxnic.sql.data.ExprRcd;



/**
 * 操作记录
 * <p>操作记录 , 数据表 oa_netdisk_oper_record 的PO类型</p>
 * @author 金杰 , maillank@qq.com
 * @since 2023-09-30 10:52:17
 * @sign 18EDA62D0F7C46D56923851479C99B0F
 * 此文件由工具自动生成，请勿修改。若表结构或配置发生变动，请使用工具重新生成。
*/

@Table(name = "oa_netdisk_oper_record")
@ApiModel(description = "操作记录 ; 操作记录 , 数据表 oa_netdisk_oper_record 的PO类型")
public class NetdiskOperRecord extends Entity {

	private static final long serialVersionUID = 1L;

	public static final DBTable TABLE =OA_NETDISK_OPER_RECORD.$TABLE;
	
	/**
	 * 主键：主键
	*/
	@Id
	@ApiModelProperty(required = true,value="主键" , notes = "主键")
	private String id;
	
	/**
	 * 对象：对象
	*/
	@ApiModelProperty(required = false,value="对象" , notes = "对象")
	private String fdId;
	
	/**
	 * 对象类型：对象类型
	*/
	@ApiModelProperty(required = false,value="对象类型" , notes = "对象类型")
	private String fdType;
	
	/**
	 * 操作内容：操作内容
	*/
	@ApiModelProperty(required = false,value="操作内容" , notes = "操作内容")
	private String operContent;
	
	/**
	 * 操作人：操作人
	*/
	@ApiModelProperty(required = false,value="操作人" , notes = "操作人")
	private String operUserId;
	
	/**
	 * 操作时间：操作时间
	*/
	@ApiModelProperty(required = false,value="操作时间" , notes = "操作时间")
	private Date operTime;
	
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
	 * user：user
	*/
	@ApiModelProperty(required = false,value="user" , notes = "user")
	private Employee user;
	
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
	public NetdiskOperRecord setId(String id) {
		this.id=id;
		return this;
	}
	
	/**
	 * 获得 对象<br>
	 * 对象
	 * @return 对象
	*/
	public String getFdId() {
		return fdId;
	}
	
	/**
	 * 设置 对象
	 * @param fdId 对象
	 * @return 当前对象
	*/
	public NetdiskOperRecord setFdId(String fdId) {
		this.fdId=fdId;
		return this;
	}
	
	/**
	 * 获得 对象类型<br>
	 * 对象类型
	 * @return 对象类型
	*/
	public String getFdType() {
		return fdType;
	}
	
	/**
	 * 设置 对象类型
	 * @param fdType 对象类型
	 * @return 当前对象
	*/
	public NetdiskOperRecord setFdType(String fdType) {
		this.fdType=fdType;
		return this;
	}
	
	/**
	 * 获得 操作内容<br>
	 * 操作内容
	 * @return 操作内容
	*/
	public String getOperContent() {
		return operContent;
	}
	
	/**
	 * 设置 操作内容
	 * @param operContent 操作内容
	 * @return 当前对象
	*/
	public NetdiskOperRecord setOperContent(String operContent) {
		this.operContent=operContent;
		return this;
	}
	
	/**
	 * 获得 操作人<br>
	 * 操作人
	 * @return 操作人
	*/
	public String getOperUserId() {
		return operUserId;
	}
	
	/**
	 * 设置 操作人
	 * @param operUserId 操作人
	 * @return 当前对象
	*/
	public NetdiskOperRecord setOperUserId(String operUserId) {
		this.operUserId=operUserId;
		return this;
	}
	
	/**
	 * 获得 操作时间<br>
	 * 操作时间
	 * @return 操作时间
	*/
	public Date getOperTime() {
		return operTime;
	}
	
	/**
	 * 设置 操作时间
	 * @param operTime 操作时间
	 * @return 当前对象
	*/
	public NetdiskOperRecord setOperTime(Date operTime) {
		this.operTime=operTime;
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
	public NetdiskOperRecord setVersion(Integer version) {
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
	public NetdiskOperRecord setCreateBy(String createBy) {
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
	public NetdiskOperRecord setCreateTime(Date createTime) {
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
	public NetdiskOperRecord setUpdateBy(String updateBy) {
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
	public NetdiskOperRecord setUpdateTime(Date updateTime) {
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
	public NetdiskOperRecord setDeleted(Integer deleted) {
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
	public NetdiskOperRecord setDeleted(Boolean deletedBool) {
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
	public NetdiskOperRecord setDeleteBy(String deleteBy) {
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
	public NetdiskOperRecord setDeleteTime(Date deleteTime) {
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
	public NetdiskOperRecord setTenantId(String tenantId) {
		this.tenantId=tenantId;
		return this;
	}
	
	/**
	 * 获得 user<br>
	 * user
	 * @return user
	*/
	public Employee getUser() {
		return user;
	}
	
	/**
	 * 设置 user
	 * @param user user
	 * @return 当前对象
	*/
	public NetdiskOperRecord setUser(Employee user) {
		this.user=user;
		return this;
	}

	/**
	 * 将自己转换成指定类型的PO
	 * @param poType  PO类型
	 * @return NetdiskOperRecord , 转换好的 NetdiskOperRecord 对象
	*/
	@Transient
	public <T extends Entity> T toPO(Class<T> poType) {
		return EntityContext.create(poType, this);
	}

	/**
	 * 将自己转换成任意指定类型
	 * @param pojoType  Pojo类型
	 * @return NetdiskOperRecord , 转换好的 PoJo 对象
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
	public NetdiskOperRecord clone() {
		return duplicate(true);
	}

	/**
	 * 复制当前对象
	 * @param all 是否复制全部属性，当 false 时，仅复制来自数据表的属性
	*/
	@Transient
	public NetdiskOperRecord duplicate(boolean all) {
		com.dt.platform.domain.oa.meta.NetdiskOperRecordMeta.$$proxy$$ inst = new com.dt.platform.domain.oa.meta.NetdiskOperRecordMeta.$$proxy$$();
		inst.setOperUserId(this.getOperUserId());
		inst.setUpdateTime(this.getUpdateTime());
		inst.setOperContent(this.getOperContent());
		inst.setVersion(this.getVersion());
		inst.setFdType(this.getFdType());
		inst.setCreateBy(this.getCreateBy());
		inst.setDeleted(this.getDeleted());
		inst.setCreateTime(this.getCreateTime());
		inst.setUpdateBy(this.getUpdateBy());
		inst.setDeleteTime(this.getDeleteTime());
		inst.setFdId(this.getFdId());
		inst.setTenantId(this.getTenantId());
		inst.setDeleteBy(this.getDeleteBy());
		inst.setId(this.getId());
		inst.setOperTime(this.getOperTime());
		if(all) {
			inst.setUser(this.getUser());
		}
		inst.clearModifies();
		return inst;
	}

	/**
	 * 克隆当前对象
	*/
	@Transient
	public NetdiskOperRecord clone(boolean deep) {
		return EntityContext.clone(NetdiskOperRecord.class,this,deep);
	}

	/**
	 * 将 Map 转换成 NetdiskOperRecord
	 * @param netdiskOperRecordMap 包含实体信息的 Map 对象
	 * @return NetdiskOperRecord , 转换好的的 NetdiskOperRecord 对象
	*/
	@Transient
	public static NetdiskOperRecord createFrom(Map<String,Object> netdiskOperRecordMap) {
		if(netdiskOperRecordMap==null) return null;
		NetdiskOperRecord po = create();
		EntityContext.copyProperties(po,netdiskOperRecordMap);
		po.clearModifies();
		return po;
	}

	/**
	 * 将 Pojo 转换成 NetdiskOperRecord
	 * @param pojo 包含实体信息的 Pojo 对象
	 * @return NetdiskOperRecord , 转换好的的 NetdiskOperRecord 对象
	*/
	@Transient
	public static NetdiskOperRecord createFrom(Object pojo) {
		if(pojo==null) return null;
		NetdiskOperRecord po = create();
		EntityContext.copyProperties(po,pojo);
		po.clearModifies();
		return po;
	}

	/**
	 * 创建一个 NetdiskOperRecord，等同于 new
	 * @return NetdiskOperRecord 对象
	*/
	@Transient
	public static NetdiskOperRecord create() {
		return new com.dt.platform.domain.oa.meta.NetdiskOperRecordMeta.$$proxy$$();
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
			this.setOperUserId(DataParser.parse(String.class, map.get(NetdiskOperRecordMeta.OPER_USER_ID)));
			this.setUpdateTime(DataParser.parse(Date.class, map.get(NetdiskOperRecordMeta.UPDATE_TIME)));
			this.setOperContent(DataParser.parse(String.class, map.get(NetdiskOperRecordMeta.OPER_CONTENT)));
			this.setVersion(DataParser.parse(Integer.class, map.get(NetdiskOperRecordMeta.VERSION)));
			this.setFdType(DataParser.parse(String.class, map.get(NetdiskOperRecordMeta.FD_TYPE)));
			this.setCreateBy(DataParser.parse(String.class, map.get(NetdiskOperRecordMeta.CREATE_BY)));
			this.setDeleted(DataParser.parse(Integer.class, map.get(NetdiskOperRecordMeta.DELETED)));
			this.setCreateTime(DataParser.parse(Date.class, map.get(NetdiskOperRecordMeta.CREATE_TIME)));
			this.setUpdateBy(DataParser.parse(String.class, map.get(NetdiskOperRecordMeta.UPDATE_BY)));
			this.setDeleteTime(DataParser.parse(Date.class, map.get(NetdiskOperRecordMeta.DELETE_TIME)));
			this.setFdId(DataParser.parse(String.class, map.get(NetdiskOperRecordMeta.FD_ID)));
			this.setTenantId(DataParser.parse(String.class, map.get(NetdiskOperRecordMeta.TENANT_ID)));
			this.setDeleteBy(DataParser.parse(String.class, map.get(NetdiskOperRecordMeta.DELETE_BY)));
			this.setId(DataParser.parse(String.class, map.get(NetdiskOperRecordMeta.ID)));
			this.setOperTime(DataParser.parse(Date.class, map.get(NetdiskOperRecordMeta.OPER_TIME)));
			// others
			this.setUser(DataParser.parse(Employee.class, map.get(NetdiskOperRecordMeta.USER)));
			return true;
		} else {
			try {
				this.setOperUserId( (String)map.get(NetdiskOperRecordMeta.OPER_USER_ID));
				this.setUpdateTime( (Date)map.get(NetdiskOperRecordMeta.UPDATE_TIME));
				this.setOperContent( (String)map.get(NetdiskOperRecordMeta.OPER_CONTENT));
				this.setVersion( (Integer)map.get(NetdiskOperRecordMeta.VERSION));
				this.setFdType( (String)map.get(NetdiskOperRecordMeta.FD_TYPE));
				this.setCreateBy( (String)map.get(NetdiskOperRecordMeta.CREATE_BY));
				this.setDeleted( (Integer)map.get(NetdiskOperRecordMeta.DELETED));
				this.setCreateTime( (Date)map.get(NetdiskOperRecordMeta.CREATE_TIME));
				this.setUpdateBy( (String)map.get(NetdiskOperRecordMeta.UPDATE_BY));
				this.setDeleteTime( (Date)map.get(NetdiskOperRecordMeta.DELETE_TIME));
				this.setFdId( (String)map.get(NetdiskOperRecordMeta.FD_ID));
				this.setTenantId( (String)map.get(NetdiskOperRecordMeta.TENANT_ID));
				this.setDeleteBy( (String)map.get(NetdiskOperRecordMeta.DELETE_BY));
				this.setId( (String)map.get(NetdiskOperRecordMeta.ID));
				this.setOperTime( (Date)map.get(NetdiskOperRecordMeta.OPER_TIME));
				// others
				this.setUser( (Employee)map.get(NetdiskOperRecordMeta.USER));
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
			this.setOperUserId(DataParser.parse(String.class, r.getValue(NetdiskOperRecordMeta.OPER_USER_ID)));
			this.setUpdateTime(DataParser.parse(Date.class, r.getValue(NetdiskOperRecordMeta.UPDATE_TIME)));
			this.setOperContent(DataParser.parse(String.class, r.getValue(NetdiskOperRecordMeta.OPER_CONTENT)));
			this.setVersion(DataParser.parse(Integer.class, r.getValue(NetdiskOperRecordMeta.VERSION)));
			this.setFdType(DataParser.parse(String.class, r.getValue(NetdiskOperRecordMeta.FD_TYPE)));
			this.setCreateBy(DataParser.parse(String.class, r.getValue(NetdiskOperRecordMeta.CREATE_BY)));
			this.setDeleted(DataParser.parse(Integer.class, r.getValue(NetdiskOperRecordMeta.DELETED)));
			this.setCreateTime(DataParser.parse(Date.class, r.getValue(NetdiskOperRecordMeta.CREATE_TIME)));
			this.setUpdateBy(DataParser.parse(String.class, r.getValue(NetdiskOperRecordMeta.UPDATE_BY)));
			this.setDeleteTime(DataParser.parse(Date.class, r.getValue(NetdiskOperRecordMeta.DELETE_TIME)));
			this.setFdId(DataParser.parse(String.class, r.getValue(NetdiskOperRecordMeta.FD_ID)));
			this.setTenantId(DataParser.parse(String.class, r.getValue(NetdiskOperRecordMeta.TENANT_ID)));
			this.setDeleteBy(DataParser.parse(String.class, r.getValue(NetdiskOperRecordMeta.DELETE_BY)));
			this.setId(DataParser.parse(String.class, r.getValue(NetdiskOperRecordMeta.ID)));
			this.setOperTime(DataParser.parse(Date.class, r.getValue(NetdiskOperRecordMeta.OPER_TIME)));
			return true;
		} else {
			try {
				this.setOperUserId( (String)r.getValue(NetdiskOperRecordMeta.OPER_USER_ID));
				this.setUpdateTime( (Date)r.getValue(NetdiskOperRecordMeta.UPDATE_TIME));
				this.setOperContent( (String)r.getValue(NetdiskOperRecordMeta.OPER_CONTENT));
				this.setVersion( (Integer)r.getValue(NetdiskOperRecordMeta.VERSION));
				this.setFdType( (String)r.getValue(NetdiskOperRecordMeta.FD_TYPE));
				this.setCreateBy( (String)r.getValue(NetdiskOperRecordMeta.CREATE_BY));
				this.setDeleted( (Integer)r.getValue(NetdiskOperRecordMeta.DELETED));
				this.setCreateTime( (Date)r.getValue(NetdiskOperRecordMeta.CREATE_TIME));
				this.setUpdateBy( (String)r.getValue(NetdiskOperRecordMeta.UPDATE_BY));
				this.setDeleteTime( (Date)r.getValue(NetdiskOperRecordMeta.DELETE_TIME));
				this.setFdId( (String)r.getValue(NetdiskOperRecordMeta.FD_ID));
				this.setTenantId( (String)r.getValue(NetdiskOperRecordMeta.TENANT_ID));
				this.setDeleteBy( (String)r.getValue(NetdiskOperRecordMeta.DELETE_BY));
				this.setId( (String)r.getValue(NetdiskOperRecordMeta.ID));
				this.setOperTime( (Date)r.getValue(NetdiskOperRecordMeta.OPER_TIME));
				return true;
			} catch (Exception e) {
				return false;
			}
		}
	}
}