package com.dt.platform.domain.oa;

import com.github.foxnic.dao.entity.Entity;
import io.swagger.annotations.ApiModel;
import javax.persistence.Table;
import com.github.foxnic.sql.meta.DBTable;
import com.dt.platform.constants.db.OaTables.OA_NETDISK_MY_SHARE;
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
import com.dt.platform.domain.oa.meta.NetdiskMyShareMeta;
import com.github.foxnic.sql.data.ExprRcd;



/**
 * 我的分享
 * <p>我的分享 , 数据表 oa_netdisk_my_share 的PO类型</p>
 * @author 金杰 , maillank@qq.com
 * @since 2023-09-28 13:31:43
 * @sign 447658EC885645924648BF86E2DAF81D
 * 此文件由工具自动生成，请勿修改。若表结构或配置发生变动，请使用工具重新生成。
*/

@Table(name = "oa_netdisk_my_share")
@ApiModel(description = "我的分享 ; 我的分享 , 数据表 oa_netdisk_my_share 的PO类型")
public class NetdiskMyShare extends Entity {

	private static final long serialVersionUID = 1L;

	public static final DBTable TABLE =OA_NETDISK_MY_SHARE.$TABLE;
	
	/**
	 * 主键：主键
	*/
	@Id
	@ApiModelProperty(required = true,value="主键" , notes = "主键" , example = "758122044071084033")
	private String id;
	
	/**
	 * 用户：用户
	*/
	@ApiModelProperty(required = false,value="用户" , notes = "用户" , example = "110588348101165911")
	private String userId;
	
	/**
	 * 文件：文件
	*/
	@ApiModelProperty(required = false,value="文件" , notes = "文件" , example = "757962175141642240")
	private String fileId;
	
	/**
	 * 链接：链接
	*/
	@ApiModelProperty(required = false,value="链接" , notes = "链接")
	private String fileUrl;
	
	/**
	 * 文件：文件
	*/
	@ApiModelProperty(required = false,value="文件" , notes = "文件")
	private String fdId;
	
	/**
	 * 文件类型：文件类型
	*/
	@ApiModelProperty(required = false,value="文件类型" , notes = "文件类型")
	private String fdType;
	
	/**
	 * 过期时间：过期时间
	*/
	@ApiModelProperty(required = false,value="过期时间" , notes = "过期时间")
	private Date expirationTime;
	
	/**
	 * 过期方式：过期方式
	*/
	@ApiModelProperty(required = false,value="过期方式" , notes = "过期方式" , example = "no_expiration")
	private String expirationMethod;
	
	/**
	 * 类型：类型
	*/
	@ApiModelProperty(required = false,value="类型" , notes = "类型" , example = "in")
	private String type;
	
	/**
	 * 状态：valid|expired|delete
	*/
	@ApiModelProperty(required = false,value="状态" , notes = "valid|expired|delete" , example = "valid")
	private String status;
	
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
	@ApiModelProperty(required = false,value="创建时间" , notes = "创建时间" , example = "2023-09-24 12:26:21")
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
	public NetdiskMyShare setId(String id) {
		this.id=id;
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
	public NetdiskMyShare setUserId(String userId) {
		this.userId=userId;
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
	public NetdiskMyShare setFileId(String fileId) {
		this.fileId=fileId;
		return this;
	}
	
	/**
	 * 获得 链接<br>
	 * 链接
	 * @return 链接
	*/
	public String getFileUrl() {
		return fileUrl;
	}
	
	/**
	 * 设置 链接
	 * @param fileUrl 链接
	 * @return 当前对象
	*/
	public NetdiskMyShare setFileUrl(String fileUrl) {
		this.fileUrl=fileUrl;
		return this;
	}
	
	/**
	 * 获得 文件<br>
	 * 文件
	 * @return 文件
	*/
	public String getFdId() {
		return fdId;
	}
	
	/**
	 * 设置 文件
	 * @param fdId 文件
	 * @return 当前对象
	*/
	public NetdiskMyShare setFdId(String fdId) {
		this.fdId=fdId;
		return this;
	}
	
	/**
	 * 获得 文件类型<br>
	 * 文件类型
	 * @return 文件类型
	*/
	public String getFdType() {
		return fdType;
	}
	
	/**
	 * 设置 文件类型
	 * @param fdType 文件类型
	 * @return 当前对象
	*/
	public NetdiskMyShare setFdType(String fdType) {
		this.fdType=fdType;
		return this;
	}
	
	/**
	 * 获得 过期时间<br>
	 * 过期时间
	 * @return 过期时间
	*/
	public Date getExpirationTime() {
		return expirationTime;
	}
	
	/**
	 * 设置 过期时间
	 * @param expirationTime 过期时间
	 * @return 当前对象
	*/
	public NetdiskMyShare setExpirationTime(Date expirationTime) {
		this.expirationTime=expirationTime;
		return this;
	}
	
	/**
	 * 获得 过期方式<br>
	 * 过期方式
	 * @return 过期方式
	*/
	public String getExpirationMethod() {
		return expirationMethod;
	}
	
	/**
	 * 设置 过期方式
	 * @param expirationMethod 过期方式
	 * @return 当前对象
	*/
	public NetdiskMyShare setExpirationMethod(String expirationMethod) {
		this.expirationMethod=expirationMethod;
		return this;
	}
	
	/**
	 * 获得 类型<br>
	 * 类型
	 * @return 类型
	*/
	public String getType() {
		return type;
	}
	
	/**
	 * 设置 类型
	 * @param type 类型
	 * @return 当前对象
	*/
	public NetdiskMyShare setType(String type) {
		this.type=type;
		return this;
	}
	
	/**
	 * 获得 状态<br>
	 * valid|expired|delete
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
	public NetdiskMyShare setStatus(String status) {
		this.status=status;
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
	public NetdiskMyShare setVersion(Integer version) {
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
	public NetdiskMyShare setCreateBy(String createBy) {
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
	public NetdiskMyShare setCreateTime(Date createTime) {
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
	public NetdiskMyShare setUpdateBy(String updateBy) {
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
	public NetdiskMyShare setUpdateTime(Date updateTime) {
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
	public NetdiskMyShare setDeleted(Integer deleted) {
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
	public NetdiskMyShare setDeleted(Boolean deletedBool) {
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
	public NetdiskMyShare setDeleteBy(String deleteBy) {
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
	public NetdiskMyShare setDeleteTime(Date deleteTime) {
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
	public NetdiskMyShare setTenantId(String tenantId) {
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
	public NetdiskMyShare setNetdiskFile(NetdiskFile netdiskFile) {
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
	public NetdiskMyShare setNetdiskOriginFile(NetdiskOriginFile netdiskOriginFile) {
		this.netdiskOriginFile=netdiskOriginFile;
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
	public NetdiskMyShare setOwnerUser(Employee ownerUser) {
		this.ownerUser=ownerUser;
		return this;
	}

	/**
	 * 将自己转换成指定类型的PO
	 * @param poType  PO类型
	 * @return NetdiskMyShare , 转换好的 NetdiskMyShare 对象
	*/
	@Transient
	public <T extends Entity> T toPO(Class<T> poType) {
		return EntityContext.create(poType, this);
	}

	/**
	 * 将自己转换成任意指定类型
	 * @param pojoType  Pojo类型
	 * @return NetdiskMyShare , 转换好的 PoJo 对象
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
	public NetdiskMyShare clone() {
		return duplicate(true);
	}

	/**
	 * 复制当前对象
	 * @param all 是否复制全部属性，当 false 时，仅复制来自数据表的属性
	*/
	@Transient
	public NetdiskMyShare duplicate(boolean all) {
		com.dt.platform.domain.oa.meta.NetdiskMyShareMeta.$$proxy$$ inst = new com.dt.platform.domain.oa.meta.NetdiskMyShareMeta.$$proxy$$();
		inst.setUpdateTime(this.getUpdateTime());
		inst.setType(this.getType());
		inst.setUserId(this.getUserId());
		inst.setVersion(this.getVersion());
		inst.setFdType(this.getFdType());
		inst.setCreateBy(this.getCreateBy());
		inst.setExpirationMethod(this.getExpirationMethod());
		inst.setDeleted(this.getDeleted());
		inst.setCreateTime(this.getCreateTime());
		inst.setUpdateBy(this.getUpdateBy());
		inst.setDeleteTime(this.getDeleteTime());
		inst.setFdId(this.getFdId());
		inst.setExpirationTime(this.getExpirationTime());
		inst.setTenantId(this.getTenantId());
		inst.setDeleteBy(this.getDeleteBy());
		inst.setFileUrl(this.getFileUrl());
		inst.setId(this.getId());
		inst.setFileId(this.getFileId());
		inst.setStatus(this.getStatus());
		if(all) {
			inst.setNetdiskFile(this.getNetdiskFile());
			inst.setOwnerUser(this.getOwnerUser());
			inst.setNetdiskOriginFile(this.getNetdiskOriginFile());
		}
		inst.clearModifies();
		return inst;
	}

	/**
	 * 克隆当前对象
	*/
	@Transient
	public NetdiskMyShare clone(boolean deep) {
		return EntityContext.clone(NetdiskMyShare.class,this,deep);
	}

	/**
	 * 将 Map 转换成 NetdiskMyShare
	 * @param netdiskMyShareMap 包含实体信息的 Map 对象
	 * @return NetdiskMyShare , 转换好的的 NetdiskMyShare 对象
	*/
	@Transient
	public static NetdiskMyShare createFrom(Map<String,Object> netdiskMyShareMap) {
		if(netdiskMyShareMap==null) return null;
		NetdiskMyShare po = create();
		EntityContext.copyProperties(po,netdiskMyShareMap);
		po.clearModifies();
		return po;
	}

	/**
	 * 将 Pojo 转换成 NetdiskMyShare
	 * @param pojo 包含实体信息的 Pojo 对象
	 * @return NetdiskMyShare , 转换好的的 NetdiskMyShare 对象
	*/
	@Transient
	public static NetdiskMyShare createFrom(Object pojo) {
		if(pojo==null) return null;
		NetdiskMyShare po = create();
		EntityContext.copyProperties(po,pojo);
		po.clearModifies();
		return po;
	}

	/**
	 * 创建一个 NetdiskMyShare，等同于 new
	 * @return NetdiskMyShare 对象
	*/
	@Transient
	public static NetdiskMyShare create() {
		return new com.dt.platform.domain.oa.meta.NetdiskMyShareMeta.$$proxy$$();
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
			this.setUpdateTime(DataParser.parse(Date.class, map.get(NetdiskMyShareMeta.UPDATE_TIME)));
			this.setType(DataParser.parse(String.class, map.get(NetdiskMyShareMeta.TYPE)));
			this.setUserId(DataParser.parse(String.class, map.get(NetdiskMyShareMeta.USER_ID)));
			this.setVersion(DataParser.parse(Integer.class, map.get(NetdiskMyShareMeta.VERSION)));
			this.setFdType(DataParser.parse(String.class, map.get(NetdiskMyShareMeta.FD_TYPE)));
			this.setCreateBy(DataParser.parse(String.class, map.get(NetdiskMyShareMeta.CREATE_BY)));
			this.setExpirationMethod(DataParser.parse(String.class, map.get(NetdiskMyShareMeta.EXPIRATION_METHOD)));
			this.setDeleted(DataParser.parse(Integer.class, map.get(NetdiskMyShareMeta.DELETED)));
			this.setCreateTime(DataParser.parse(Date.class, map.get(NetdiskMyShareMeta.CREATE_TIME)));
			this.setUpdateBy(DataParser.parse(String.class, map.get(NetdiskMyShareMeta.UPDATE_BY)));
			this.setDeleteTime(DataParser.parse(Date.class, map.get(NetdiskMyShareMeta.DELETE_TIME)));
			this.setFdId(DataParser.parse(String.class, map.get(NetdiskMyShareMeta.FD_ID)));
			this.setExpirationTime(DataParser.parse(Date.class, map.get(NetdiskMyShareMeta.EXPIRATION_TIME)));
			this.setTenantId(DataParser.parse(String.class, map.get(NetdiskMyShareMeta.TENANT_ID)));
			this.setDeleteBy(DataParser.parse(String.class, map.get(NetdiskMyShareMeta.DELETE_BY)));
			this.setFileUrl(DataParser.parse(String.class, map.get(NetdiskMyShareMeta.FILE_URL)));
			this.setId(DataParser.parse(String.class, map.get(NetdiskMyShareMeta.ID)));
			this.setFileId(DataParser.parse(String.class, map.get(NetdiskMyShareMeta.FILE_ID)));
			this.setStatus(DataParser.parse(String.class, map.get(NetdiskMyShareMeta.STATUS)));
			// others
			this.setNetdiskFile(DataParser.parse(NetdiskFile.class, map.get(NetdiskMyShareMeta.NETDISK_FILE)));
			this.setOwnerUser(DataParser.parse(Employee.class, map.get(NetdiskMyShareMeta.OWNER_USER)));
			this.setNetdiskOriginFile(DataParser.parse(NetdiskOriginFile.class, map.get(NetdiskMyShareMeta.NETDISK_ORIGIN_FILE)));
			return true;
		} else {
			try {
				this.setUpdateTime( (Date)map.get(NetdiskMyShareMeta.UPDATE_TIME));
				this.setType( (String)map.get(NetdiskMyShareMeta.TYPE));
				this.setUserId( (String)map.get(NetdiskMyShareMeta.USER_ID));
				this.setVersion( (Integer)map.get(NetdiskMyShareMeta.VERSION));
				this.setFdType( (String)map.get(NetdiskMyShareMeta.FD_TYPE));
				this.setCreateBy( (String)map.get(NetdiskMyShareMeta.CREATE_BY));
				this.setExpirationMethod( (String)map.get(NetdiskMyShareMeta.EXPIRATION_METHOD));
				this.setDeleted( (Integer)map.get(NetdiskMyShareMeta.DELETED));
				this.setCreateTime( (Date)map.get(NetdiskMyShareMeta.CREATE_TIME));
				this.setUpdateBy( (String)map.get(NetdiskMyShareMeta.UPDATE_BY));
				this.setDeleteTime( (Date)map.get(NetdiskMyShareMeta.DELETE_TIME));
				this.setFdId( (String)map.get(NetdiskMyShareMeta.FD_ID));
				this.setExpirationTime( (Date)map.get(NetdiskMyShareMeta.EXPIRATION_TIME));
				this.setTenantId( (String)map.get(NetdiskMyShareMeta.TENANT_ID));
				this.setDeleteBy( (String)map.get(NetdiskMyShareMeta.DELETE_BY));
				this.setFileUrl( (String)map.get(NetdiskMyShareMeta.FILE_URL));
				this.setId( (String)map.get(NetdiskMyShareMeta.ID));
				this.setFileId( (String)map.get(NetdiskMyShareMeta.FILE_ID));
				this.setStatus( (String)map.get(NetdiskMyShareMeta.STATUS));
				// others
				this.setNetdiskFile( (NetdiskFile)map.get(NetdiskMyShareMeta.NETDISK_FILE));
				this.setOwnerUser( (Employee)map.get(NetdiskMyShareMeta.OWNER_USER));
				this.setNetdiskOriginFile( (NetdiskOriginFile)map.get(NetdiskMyShareMeta.NETDISK_ORIGIN_FILE));
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
			this.setUpdateTime(DataParser.parse(Date.class, r.getValue(NetdiskMyShareMeta.UPDATE_TIME)));
			this.setType(DataParser.parse(String.class, r.getValue(NetdiskMyShareMeta.TYPE)));
			this.setUserId(DataParser.parse(String.class, r.getValue(NetdiskMyShareMeta.USER_ID)));
			this.setVersion(DataParser.parse(Integer.class, r.getValue(NetdiskMyShareMeta.VERSION)));
			this.setFdType(DataParser.parse(String.class, r.getValue(NetdiskMyShareMeta.FD_TYPE)));
			this.setCreateBy(DataParser.parse(String.class, r.getValue(NetdiskMyShareMeta.CREATE_BY)));
			this.setExpirationMethod(DataParser.parse(String.class, r.getValue(NetdiskMyShareMeta.EXPIRATION_METHOD)));
			this.setDeleted(DataParser.parse(Integer.class, r.getValue(NetdiskMyShareMeta.DELETED)));
			this.setCreateTime(DataParser.parse(Date.class, r.getValue(NetdiskMyShareMeta.CREATE_TIME)));
			this.setUpdateBy(DataParser.parse(String.class, r.getValue(NetdiskMyShareMeta.UPDATE_BY)));
			this.setDeleteTime(DataParser.parse(Date.class, r.getValue(NetdiskMyShareMeta.DELETE_TIME)));
			this.setFdId(DataParser.parse(String.class, r.getValue(NetdiskMyShareMeta.FD_ID)));
			this.setExpirationTime(DataParser.parse(Date.class, r.getValue(NetdiskMyShareMeta.EXPIRATION_TIME)));
			this.setTenantId(DataParser.parse(String.class, r.getValue(NetdiskMyShareMeta.TENANT_ID)));
			this.setDeleteBy(DataParser.parse(String.class, r.getValue(NetdiskMyShareMeta.DELETE_BY)));
			this.setFileUrl(DataParser.parse(String.class, r.getValue(NetdiskMyShareMeta.FILE_URL)));
			this.setId(DataParser.parse(String.class, r.getValue(NetdiskMyShareMeta.ID)));
			this.setFileId(DataParser.parse(String.class, r.getValue(NetdiskMyShareMeta.FILE_ID)));
			this.setStatus(DataParser.parse(String.class, r.getValue(NetdiskMyShareMeta.STATUS)));
			return true;
		} else {
			try {
				this.setUpdateTime( (Date)r.getValue(NetdiskMyShareMeta.UPDATE_TIME));
				this.setType( (String)r.getValue(NetdiskMyShareMeta.TYPE));
				this.setUserId( (String)r.getValue(NetdiskMyShareMeta.USER_ID));
				this.setVersion( (Integer)r.getValue(NetdiskMyShareMeta.VERSION));
				this.setFdType( (String)r.getValue(NetdiskMyShareMeta.FD_TYPE));
				this.setCreateBy( (String)r.getValue(NetdiskMyShareMeta.CREATE_BY));
				this.setExpirationMethod( (String)r.getValue(NetdiskMyShareMeta.EXPIRATION_METHOD));
				this.setDeleted( (Integer)r.getValue(NetdiskMyShareMeta.DELETED));
				this.setCreateTime( (Date)r.getValue(NetdiskMyShareMeta.CREATE_TIME));
				this.setUpdateBy( (String)r.getValue(NetdiskMyShareMeta.UPDATE_BY));
				this.setDeleteTime( (Date)r.getValue(NetdiskMyShareMeta.DELETE_TIME));
				this.setFdId( (String)r.getValue(NetdiskMyShareMeta.FD_ID));
				this.setExpirationTime( (Date)r.getValue(NetdiskMyShareMeta.EXPIRATION_TIME));
				this.setTenantId( (String)r.getValue(NetdiskMyShareMeta.TENANT_ID));
				this.setDeleteBy( (String)r.getValue(NetdiskMyShareMeta.DELETE_BY));
				this.setFileUrl( (String)r.getValue(NetdiskMyShareMeta.FILE_URL));
				this.setId( (String)r.getValue(NetdiskMyShareMeta.ID));
				this.setFileId( (String)r.getValue(NetdiskMyShareMeta.FILE_ID));
				this.setStatus( (String)r.getValue(NetdiskMyShareMeta.STATUS));
				return true;
			} catch (Exception e) {
				return false;
			}
		}
	}
}