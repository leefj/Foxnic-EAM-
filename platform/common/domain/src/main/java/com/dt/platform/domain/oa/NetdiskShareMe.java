package com.dt.platform.domain.oa;

import com.github.foxnic.dao.entity.Entity;
import io.swagger.annotations.ApiModel;
import javax.persistence.Table;
import com.github.foxnic.sql.meta.DBTable;
import com.dt.platform.constants.db.OaTables.OA_NETDISK_SHARE_ME;
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
import com.dt.platform.domain.oa.meta.NetdiskShareMeMeta;
import com.github.foxnic.sql.data.ExprRcd;



/**
 * 分享给我
 * <p>分享给我 , 数据表 oa_netdisk_share_me 的PO类型</p>
 * @author 金杰 , maillank@qq.com
 * @since 2023-09-23 15:51:15
 * @sign 3D18FCDD9E3A3475F0D7737757D45CD3
 * 此文件由工具自动生成，请勿修改。若表结构或配置发生变动，请使用工具重新生成。
*/

@Table(name = "oa_netdisk_share_me")
@ApiModel(description = "分享给我 ; 分享给我 , 数据表 oa_netdisk_share_me 的PO类型")
public class NetdiskShareMe extends Entity {

	private static final long serialVersionUID = 1L;

	public static final DBTable TABLE =OA_NETDISK_SHARE_ME.$TABLE;
	
	/**
	 * 主键：主键
	*/
	@Id
	@ApiModelProperty(required = true,value="主键" , notes = "主键" , example = "757989086731436032")
	private String id;
	
	/**
	 * 文件：文件
	*/
	@ApiModelProperty(required = false,value="文件" , notes = "文件" , example = "757962175141642240")
	private String fileId;
	
	/**
	 * 分享：分享
	*/
	@ApiModelProperty(required = false,value="分享" , notes = "分享" , example = "757989086525915136")
	private String shareId;
	
	/**
	 * 用户：用户
	*/
	@ApiModelProperty(required = false,value="用户" , notes = "用户" , example = "586965315200483328")
	private String userId;
	
	/**
	 * 所属：所属
	*/
	@ApiModelProperty(required = false,value="所属" , notes = "所属" , example = "E001")
	private String ownerUserId;
	
	/**
	 * 版本：版本
	*/
	@ApiModelProperty(required = true,value="版本" , notes = "版本" , example = "1")
	private Integer version;
	
	/**
	 * 创建人ID：创建人ID
	*/
	@ApiModelProperty(required = false,value="创建人ID" , notes = "创建人ID" , example = "110588348101165911")
	private String createBy;
	
	/**
	 * 创建时间：创建时间
	*/
	@ApiModelProperty(required = false,value="创建时间" , notes = "创建时间" , example = "2023-09-23 03:38:01")
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
	 * 租户：租户
	*/
	@ApiModelProperty(required = false,value="租户" , notes = "租户" , example = "T001")
	private String tenantId;
	
	/**
	 * netdiskFile：netdiskFile
	*/
	@ApiModelProperty(required = false,value="netdiskFile" , notes = "netdiskFile")
	private NetdiskFile netdiskFile;
	
	/**
	 * netdiskOriginFile：netdiskOriginFile
	*/
	@ApiModelProperty(required = false,value="netdiskOriginFile" , notes = "netdiskOriginFile")
	private NetdiskOriginFile netdiskOriginFile;
	
	/**
	 * user：user
	*/
	@ApiModelProperty(required = false,value="user" , notes = "user")
	private Employee user;
	
	/**
	 * ownerUser：ownerUser
	*/
	@ApiModelProperty(required = false,value="ownerUser" , notes = "ownerUser")
	private Employee ownerUser;
	
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
	public NetdiskShareMe setId(String id) {
		this.id=id;
		return this;
	}
	
	/**
	 * 获得 文件<br>
	 * 文件
	 * @return 文件
	*/
	public String getFileId() {
		return fileId;
	}
	
	/**
	 * 设置 文件
	 * @param fileId 文件
	 * @return 当前对象
	*/
	public NetdiskShareMe setFileId(String fileId) {
		this.fileId=fileId;
		return this;
	}
	
	/**
	 * 获得 分享<br>
	 * 分享
	 * @return 分享
	*/
	public String getShareId() {
		return shareId;
	}
	
	/**
	 * 设置 分享
	 * @param shareId 分享
	 * @return 当前对象
	*/
	public NetdiskShareMe setShareId(String shareId) {
		this.shareId=shareId;
		return this;
	}
	
	/**
	 * 获得 用户<br>
	 * 用户
	 * @return 用户
	*/
	public String getUserId() {
		return userId;
	}
	
	/**
	 * 设置 用户
	 * @param userId 用户
	 * @return 当前对象
	*/
	public NetdiskShareMe setUserId(String userId) {
		this.userId=userId;
		return this;
	}
	
	/**
	 * 获得 所属<br>
	 * 所属
	 * @return 所属
	*/
	public String getOwnerUserId() {
		return ownerUserId;
	}
	
	/**
	 * 设置 所属
	 * @param ownerUserId 所属
	 * @return 当前对象
	*/
	public NetdiskShareMe setOwnerUserId(String ownerUserId) {
		this.ownerUserId=ownerUserId;
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
	public NetdiskShareMe setVersion(Integer version) {
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
	public NetdiskShareMe setCreateBy(String createBy) {
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
	public NetdiskShareMe setCreateTime(Date createTime) {
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
	public NetdiskShareMe setUpdateBy(String updateBy) {
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
	public NetdiskShareMe setUpdateTime(Date updateTime) {
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
	public NetdiskShareMe setDeleted(Integer deleted) {
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
	public NetdiskShareMe setDeleted(Boolean deletedBool) {
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
	public NetdiskShareMe setDeleteBy(String deleteBy) {
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
	public NetdiskShareMe setDeleteTime(Date deleteTime) {
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
	public NetdiskShareMe setTenantId(String tenantId) {
		this.tenantId=tenantId;
		return this;
	}
	
	/**
	 * 获得 netdiskFile<br>
	 * netdiskFile
	 * @return netdiskFile
	*/
	public NetdiskFile getNetdiskFile() {
		return netdiskFile;
	}
	
	/**
	 * 设置 netdiskFile
	 * @param netdiskFile netdiskFile
	 * @return 当前对象
	*/
	public NetdiskShareMe setNetdiskFile(NetdiskFile netdiskFile) {
		this.netdiskFile=netdiskFile;
		return this;
	}
	
	/**
	 * 获得 netdiskOriginFile<br>
	 * netdiskOriginFile
	 * @return netdiskOriginFile
	*/
	public NetdiskOriginFile getNetdiskOriginFile() {
		return netdiskOriginFile;
	}
	
	/**
	 * 设置 netdiskOriginFile
	 * @param netdiskOriginFile netdiskOriginFile
	 * @return 当前对象
	*/
	public NetdiskShareMe setNetdiskOriginFile(NetdiskOriginFile netdiskOriginFile) {
		this.netdiskOriginFile=netdiskOriginFile;
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
	public NetdiskShareMe setUser(Employee user) {
		this.user=user;
		return this;
	}
	
	/**
	 * 获得 ownerUser<br>
	 * ownerUser
	 * @return ownerUser
	*/
	public Employee getOwnerUser() {
		return ownerUser;
	}
	
	/**
	 * 设置 ownerUser
	 * @param ownerUser ownerUser
	 * @return 当前对象
	*/
	public NetdiskShareMe setOwnerUser(Employee ownerUser) {
		this.ownerUser=ownerUser;
		return this;
	}

	/**
	 * 将自己转换成指定类型的PO
	 * @param poType  PO类型
	 * @return NetdiskShareMe , 转换好的 NetdiskShareMe 对象
	*/
	@Transient
	public <T extends Entity> T toPO(Class<T> poType) {
		return EntityContext.create(poType, this);
	}

	/**
	 * 将自己转换成任意指定类型
	 * @param pojoType  Pojo类型
	 * @return NetdiskShareMe , 转换好的 PoJo 对象
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
	public NetdiskShareMe clone() {
		return duplicate(true);
	}

	/**
	 * 复制当前对象
	 * @param all 是否复制全部属性，当 false 时，仅复制来自数据表的属性
	*/
	@Transient
	public NetdiskShareMe duplicate(boolean all) {
		com.dt.platform.domain.oa.meta.NetdiskShareMeMeta.$$proxy$$ inst = new com.dt.platform.domain.oa.meta.NetdiskShareMeMeta.$$proxy$$();
		inst.setShareId(this.getShareId());
		inst.setUpdateTime(this.getUpdateTime());
		inst.setUserId(this.getUserId());
		inst.setVersion(this.getVersion());
		inst.setCreateBy(this.getCreateBy());
		inst.setDeleted(this.getDeleted());
		inst.setCreateTime(this.getCreateTime());
		inst.setUpdateBy(this.getUpdateBy());
		inst.setDeleteTime(this.getDeleteTime());
		inst.setOwnerUserId(this.getOwnerUserId());
		inst.setTenantId(this.getTenantId());
		inst.setDeleteBy(this.getDeleteBy());
		inst.setId(this.getId());
		inst.setFileId(this.getFileId());
		if(all) {
			inst.setNetdiskFile(this.getNetdiskFile());
			inst.setOwnerUser(this.getOwnerUser());
			inst.setNetdiskOriginFile(this.getNetdiskOriginFile());
			inst.setUser(this.getUser());
		}
		inst.clearModifies();
		return inst;
	}

	/**
	 * 克隆当前对象
	*/
	@Transient
	public NetdiskShareMe clone(boolean deep) {
		return EntityContext.clone(NetdiskShareMe.class,this,deep);
	}

	/**
	 * 将 Map 转换成 NetdiskShareMe
	 * @param netdiskShareMeMap 包含实体信息的 Map 对象
	 * @return NetdiskShareMe , 转换好的的 NetdiskShareMe 对象
	*/
	@Transient
	public static NetdiskShareMe createFrom(Map<String,Object> netdiskShareMeMap) {
		if(netdiskShareMeMap==null) return null;
		NetdiskShareMe po = create();
		EntityContext.copyProperties(po,netdiskShareMeMap);
		po.clearModifies();
		return po;
	}

	/**
	 * 将 Pojo 转换成 NetdiskShareMe
	 * @param pojo 包含实体信息的 Pojo 对象
	 * @return NetdiskShareMe , 转换好的的 NetdiskShareMe 对象
	*/
	@Transient
	public static NetdiskShareMe createFrom(Object pojo) {
		if(pojo==null) return null;
		NetdiskShareMe po = create();
		EntityContext.copyProperties(po,pojo);
		po.clearModifies();
		return po;
	}

	/**
	 * 创建一个 NetdiskShareMe，等同于 new
	 * @return NetdiskShareMe 对象
	*/
	@Transient
	public static NetdiskShareMe create() {
		return new com.dt.platform.domain.oa.meta.NetdiskShareMeMeta.$$proxy$$();
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
			this.setShareId(DataParser.parse(String.class, map.get(NetdiskShareMeMeta.SHARE_ID)));
			this.setUpdateTime(DataParser.parse(Date.class, map.get(NetdiskShareMeMeta.UPDATE_TIME)));
			this.setUserId(DataParser.parse(String.class, map.get(NetdiskShareMeMeta.USER_ID)));
			this.setVersion(DataParser.parse(Integer.class, map.get(NetdiskShareMeMeta.VERSION)));
			this.setCreateBy(DataParser.parse(String.class, map.get(NetdiskShareMeMeta.CREATE_BY)));
			this.setDeleted(DataParser.parse(Integer.class, map.get(NetdiskShareMeMeta.DELETED)));
			this.setCreateTime(DataParser.parse(Date.class, map.get(NetdiskShareMeMeta.CREATE_TIME)));
			this.setUpdateBy(DataParser.parse(String.class, map.get(NetdiskShareMeMeta.UPDATE_BY)));
			this.setDeleteTime(DataParser.parse(Date.class, map.get(NetdiskShareMeMeta.DELETE_TIME)));
			this.setOwnerUserId(DataParser.parse(String.class, map.get(NetdiskShareMeMeta.OWNER_USER_ID)));
			this.setTenantId(DataParser.parse(String.class, map.get(NetdiskShareMeMeta.TENANT_ID)));
			this.setDeleteBy(DataParser.parse(String.class, map.get(NetdiskShareMeMeta.DELETE_BY)));
			this.setId(DataParser.parse(String.class, map.get(NetdiskShareMeMeta.ID)));
			this.setFileId(DataParser.parse(String.class, map.get(NetdiskShareMeMeta.FILE_ID)));
			// others
			this.setNetdiskFile(DataParser.parse(NetdiskFile.class, map.get(NetdiskShareMeMeta.NETDISK_FILE)));
			this.setOwnerUser(DataParser.parse(Employee.class, map.get(NetdiskShareMeMeta.OWNER_USER)));
			this.setNetdiskOriginFile(DataParser.parse(NetdiskOriginFile.class, map.get(NetdiskShareMeMeta.NETDISK_ORIGIN_FILE)));
			this.setUser(DataParser.parse(Employee.class, map.get(NetdiskShareMeMeta.USER)));
			return true;
		} else {
			try {
				this.setShareId( (String)map.get(NetdiskShareMeMeta.SHARE_ID));
				this.setUpdateTime( (Date)map.get(NetdiskShareMeMeta.UPDATE_TIME));
				this.setUserId( (String)map.get(NetdiskShareMeMeta.USER_ID));
				this.setVersion( (Integer)map.get(NetdiskShareMeMeta.VERSION));
				this.setCreateBy( (String)map.get(NetdiskShareMeMeta.CREATE_BY));
				this.setDeleted( (Integer)map.get(NetdiskShareMeMeta.DELETED));
				this.setCreateTime( (Date)map.get(NetdiskShareMeMeta.CREATE_TIME));
				this.setUpdateBy( (String)map.get(NetdiskShareMeMeta.UPDATE_BY));
				this.setDeleteTime( (Date)map.get(NetdiskShareMeMeta.DELETE_TIME));
				this.setOwnerUserId( (String)map.get(NetdiskShareMeMeta.OWNER_USER_ID));
				this.setTenantId( (String)map.get(NetdiskShareMeMeta.TENANT_ID));
				this.setDeleteBy( (String)map.get(NetdiskShareMeMeta.DELETE_BY));
				this.setId( (String)map.get(NetdiskShareMeMeta.ID));
				this.setFileId( (String)map.get(NetdiskShareMeMeta.FILE_ID));
				// others
				this.setNetdiskFile( (NetdiskFile)map.get(NetdiskShareMeMeta.NETDISK_FILE));
				this.setOwnerUser( (Employee)map.get(NetdiskShareMeMeta.OWNER_USER));
				this.setNetdiskOriginFile( (NetdiskOriginFile)map.get(NetdiskShareMeMeta.NETDISK_ORIGIN_FILE));
				this.setUser( (Employee)map.get(NetdiskShareMeMeta.USER));
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
			this.setShareId(DataParser.parse(String.class, r.getValue(NetdiskShareMeMeta.SHARE_ID)));
			this.setUpdateTime(DataParser.parse(Date.class, r.getValue(NetdiskShareMeMeta.UPDATE_TIME)));
			this.setUserId(DataParser.parse(String.class, r.getValue(NetdiskShareMeMeta.USER_ID)));
			this.setVersion(DataParser.parse(Integer.class, r.getValue(NetdiskShareMeMeta.VERSION)));
			this.setCreateBy(DataParser.parse(String.class, r.getValue(NetdiskShareMeMeta.CREATE_BY)));
			this.setDeleted(DataParser.parse(Integer.class, r.getValue(NetdiskShareMeMeta.DELETED)));
			this.setCreateTime(DataParser.parse(Date.class, r.getValue(NetdiskShareMeMeta.CREATE_TIME)));
			this.setUpdateBy(DataParser.parse(String.class, r.getValue(NetdiskShareMeMeta.UPDATE_BY)));
			this.setDeleteTime(DataParser.parse(Date.class, r.getValue(NetdiskShareMeMeta.DELETE_TIME)));
			this.setOwnerUserId(DataParser.parse(String.class, r.getValue(NetdiskShareMeMeta.OWNER_USER_ID)));
			this.setTenantId(DataParser.parse(String.class, r.getValue(NetdiskShareMeMeta.TENANT_ID)));
			this.setDeleteBy(DataParser.parse(String.class, r.getValue(NetdiskShareMeMeta.DELETE_BY)));
			this.setId(DataParser.parse(String.class, r.getValue(NetdiskShareMeMeta.ID)));
			this.setFileId(DataParser.parse(String.class, r.getValue(NetdiskShareMeMeta.FILE_ID)));
			return true;
		} else {
			try {
				this.setShareId( (String)r.getValue(NetdiskShareMeMeta.SHARE_ID));
				this.setUpdateTime( (Date)r.getValue(NetdiskShareMeMeta.UPDATE_TIME));
				this.setUserId( (String)r.getValue(NetdiskShareMeMeta.USER_ID));
				this.setVersion( (Integer)r.getValue(NetdiskShareMeMeta.VERSION));
				this.setCreateBy( (String)r.getValue(NetdiskShareMeMeta.CREATE_BY));
				this.setDeleted( (Integer)r.getValue(NetdiskShareMeMeta.DELETED));
				this.setCreateTime( (Date)r.getValue(NetdiskShareMeMeta.CREATE_TIME));
				this.setUpdateBy( (String)r.getValue(NetdiskShareMeMeta.UPDATE_BY));
				this.setDeleteTime( (Date)r.getValue(NetdiskShareMeMeta.DELETE_TIME));
				this.setOwnerUserId( (String)r.getValue(NetdiskShareMeMeta.OWNER_USER_ID));
				this.setTenantId( (String)r.getValue(NetdiskShareMeMeta.TENANT_ID));
				this.setDeleteBy( (String)r.getValue(NetdiskShareMeMeta.DELETE_BY));
				this.setId( (String)r.getValue(NetdiskShareMeMeta.ID));
				this.setFileId( (String)r.getValue(NetdiskShareMeMeta.FILE_ID));
				return true;
			} catch (Exception e) {
				return false;
			}
		}
	}
}