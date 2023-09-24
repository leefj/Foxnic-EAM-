package com.dt.platform.domain.oa;

import com.github.foxnic.dao.entity.Entity;
import io.swagger.annotations.ApiModel;
import javax.persistence.Table;
import com.github.foxnic.sql.meta.DBTable;
import com.dt.platform.constants.db.OaTables.OA_NETDISK_ORIGIN_FILE;
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
import com.dt.platform.domain.oa.meta.NetdiskOriginFileMeta;
import com.github.foxnic.sql.data.ExprRcd;



/**
 * 源文件
 * <p>源文件 , 数据表 oa_netdisk_origin_file 的PO类型</p>
 * @author 金杰 , maillank@qq.com
 * @since 2023-09-22 18:17:17
 * @sign ABD3F8F4A8F8C3722AC5568AE18B0D93
 * 此文件由工具自动生成，请勿修改。若表结构或配置发生变动，请使用工具重新生成。
*/

@Table(name = "oa_netdisk_origin_file")
@ApiModel(description = "源文件 ; 源文件 , 数据表 oa_netdisk_origin_file 的PO类型")
public class NetdiskOriginFile extends Entity {

	private static final long serialVersionUID = 1L;

	public static final DBTable TABLE =OA_NETDISK_ORIGIN_FILE.$TABLE;
	
	/**
	 * 主键：主键
	*/
	@Id
	@ApiModelProperty(required = true,value="主键" , notes = "主键" , example = "757363148821889024")
	private String id;
	
	/**
	 * 文件名称：文件名称
	*/
	@ApiModelProperty(required = false,value="文件名称" , notes = "文件名称" , example = "ade8ea5334a5f556e14ab6c8ba7ec2a9.jpeg")
	private String fileName;
	
	/**
	 * 大小：大小
	*/
	@ApiModelProperty(required = false,value="大小" , notes = "大小" , example = "19261")
	private Long fileSize;
	
	/**
	 * 路径：路径
	*/
	@ApiModelProperty(required = false,value="路径" , notes = "路径" , example = "/20230921/757363148813500416.jpeg")
	private String location;
	
	/**
	 * 媒体类型：媒体类型
	*/
	@ApiModelProperty(required = false,value="媒体类型" , notes = "媒体类型" , example = "image/jpeg")
	private String mediaType;
	
	/**
	 * 文件类型：文件类型
	*/
	@ApiModelProperty(required = false,value="文件类型" , notes = "文件类型" , example = "jpeg")
	private String fileType;
	
	/**
	 * 扩展类型：jpg,png
	*/
	@ApiModelProperty(required = false,value="扩展类型" , notes = "jpg,png")
	private String extValue;
	
	/**
	 * 存储类型：存储类型
	*/
	@ApiModelProperty(required = false,value="存储类型" , notes = "存储类型")
	private String storageType;
	
	/**
	 * 是否加密：Y|N
	*/
	@ApiModelProperty(required = false,value="是否加密" , notes = "Y|N")
	private String encrypted;
	
	/**
	 * 所属用户：所属用户
	*/
	@ApiModelProperty(required = false,value="所属用户" , notes = "所属用户")
	private String userId;
	
	/**
	 * 存储地址：存储地址
	*/
	@ApiModelProperty(required = false,value="存储地址" , notes = "存储地址")
	private String storageStoreId;
	
	/**
	 * 下载地址：下载地址
	*/
	@ApiModelProperty(required = false,value="下载地址" , notes = "下载地址")
	private String downloadUrl;
	
	/**
	 * 下载次数：下载次数
	*/
	@ApiModelProperty(required = false,value="下载次数" , notes = "下载次数" , example = "0")
	private Long downloadCount;
	
	/**
	 * 引用次数：引用次数
	*/
	@ApiModelProperty(required = false,value="引用次数" , notes = "引用次数" , example = "1")
	private Integer referenceCount;
	
	/**
	 * 上次访问时间：上次访问时间
	*/
	@ApiModelProperty(required = false,value="上次访问时间" , notes = "上次访问时间")
	private Date lastVisitTime;
	
	/**
	 * MD5：MD5
	*/
	@ApiModelProperty(required = false,value="MD5" , notes = "MD5" , example = "000000")
	private String md5Value;
	
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
	@ApiModelProperty(required = false,value="创建时间" , notes = "创建时间" , example = "2023-09-21 10:10:46")
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
	public NetdiskOriginFile setId(String id) {
		this.id=id;
		return this;
	}
	
	/**
	 * 获得 文件名称<br>
	 * 文件名称
	 * @return 文件名称
	*/
	public String getFileName() {
		return fileName;
	}
	
	/**
	 * 设置 文件名称
	 * @param fileName 文件名称
	 * @return 当前对象
	*/
	public NetdiskOriginFile setFileName(String fileName) {
		this.fileName=fileName;
		return this;
	}
	
	/**
	 * 获得 大小<br>
	 * 大小
	 * @return 大小
	*/
	public Long getFileSize() {
		return fileSize;
	}
	
	/**
	 * 设置 大小
	 * @param fileSize 大小
	 * @return 当前对象
	*/
	public NetdiskOriginFile setFileSize(Long fileSize) {
		this.fileSize=fileSize;
		return this;
	}
	
	/**
	 * 获得 路径<br>
	 * 路径
	 * @return 路径
	*/
	public String getLocation() {
		return location;
	}
	
	/**
	 * 设置 路径
	 * @param location 路径
	 * @return 当前对象
	*/
	public NetdiskOriginFile setLocation(String location) {
		this.location=location;
		return this;
	}
	
	/**
	 * 获得 媒体类型<br>
	 * 媒体类型
	 * @return 媒体类型
	*/
	public String getMediaType() {
		return mediaType;
	}
	
	/**
	 * 设置 媒体类型
	 * @param mediaType 媒体类型
	 * @return 当前对象
	*/
	public NetdiskOriginFile setMediaType(String mediaType) {
		this.mediaType=mediaType;
		return this;
	}
	
	/**
	 * 获得 文件类型<br>
	 * 文件类型
	 * @return 文件类型
	*/
	public String getFileType() {
		return fileType;
	}
	
	/**
	 * 设置 文件类型
	 * @param fileType 文件类型
	 * @return 当前对象
	*/
	public NetdiskOriginFile setFileType(String fileType) {
		this.fileType=fileType;
		return this;
	}
	
	/**
	 * 获得 扩展类型<br>
	 * jpg,png
	 * @return 扩展类型
	*/
	public String getExtValue() {
		return extValue;
	}
	
	/**
	 * 设置 扩展类型
	 * @param extValue 扩展类型
	 * @return 当前对象
	*/
	public NetdiskOriginFile setExtValue(String extValue) {
		this.extValue=extValue;
		return this;
	}
	
	/**
	 * 获得 存储类型<br>
	 * 存储类型
	 * @return 存储类型
	*/
	public String getStorageType() {
		return storageType;
	}
	
	/**
	 * 设置 存储类型
	 * @param storageType 存储类型
	 * @return 当前对象
	*/
	public NetdiskOriginFile setStorageType(String storageType) {
		this.storageType=storageType;
		return this;
	}
	
	/**
	 * 获得 是否加密<br>
	 * Y|N
	 * @return 是否加密
	*/
	public String getEncrypted() {
		return encrypted;
	}
	
	/**
	 * 设置 是否加密
	 * @param encrypted 是否加密
	 * @return 当前对象
	*/
	public NetdiskOriginFile setEncrypted(String encrypted) {
		this.encrypted=encrypted;
		return this;
	}
	
	/**
	 * 获得 所属用户<br>
	 * 所属用户
	 * @return 所属用户
	*/
	public String getUserId() {
		return userId;
	}
	
	/**
	 * 设置 所属用户
	 * @param userId 所属用户
	 * @return 当前对象
	*/
	public NetdiskOriginFile setUserId(String userId) {
		this.userId=userId;
		return this;
	}
	
	/**
	 * 获得 存储地址<br>
	 * 存储地址
	 * @return 存储地址
	*/
	public String getStorageStoreId() {
		return storageStoreId;
	}
	
	/**
	 * 设置 存储地址
	 * @param storageStoreId 存储地址
	 * @return 当前对象
	*/
	public NetdiskOriginFile setStorageStoreId(String storageStoreId) {
		this.storageStoreId=storageStoreId;
		return this;
	}
	
	/**
	 * 获得 下载地址<br>
	 * 下载地址
	 * @return 下载地址
	*/
	public String getDownloadUrl() {
		return downloadUrl;
	}
	
	/**
	 * 设置 下载地址
	 * @param downloadUrl 下载地址
	 * @return 当前对象
	*/
	public NetdiskOriginFile setDownloadUrl(String downloadUrl) {
		this.downloadUrl=downloadUrl;
		return this;
	}
	
	/**
	 * 获得 下载次数<br>
	 * 下载次数
	 * @return 下载次数
	*/
	public Long getDownloadCount() {
		return downloadCount;
	}
	
	/**
	 * 设置 下载次数
	 * @param downloadCount 下载次数
	 * @return 当前对象
	*/
	public NetdiskOriginFile setDownloadCount(Long downloadCount) {
		this.downloadCount=downloadCount;
		return this;
	}
	
	/**
	 * 获得 引用次数<br>
	 * 引用次数
	 * @return 引用次数
	*/
	public Integer getReferenceCount() {
		return referenceCount;
	}
	
	/**
	 * 设置 引用次数
	 * @param referenceCount 引用次数
	 * @return 当前对象
	*/
	public NetdiskOriginFile setReferenceCount(Integer referenceCount) {
		this.referenceCount=referenceCount;
		return this;
	}
	
	/**
	 * 获得 上次访问时间<br>
	 * 上次访问时间
	 * @return 上次访问时间
	*/
	public Date getLastVisitTime() {
		return lastVisitTime;
	}
	
	/**
	 * 设置 上次访问时间
	 * @param lastVisitTime 上次访问时间
	 * @return 当前对象
	*/
	public NetdiskOriginFile setLastVisitTime(Date lastVisitTime) {
		this.lastVisitTime=lastVisitTime;
		return this;
	}
	
	/**
	 * 获得 MD5<br>
	 * MD5
	 * @return MD5
	*/
	public String getMd5Value() {
		return md5Value;
	}
	
	/**
	 * 设置 MD5
	 * @param md5Value MD5
	 * @return 当前对象
	*/
	public NetdiskOriginFile setMd5Value(String md5Value) {
		this.md5Value=md5Value;
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
	public NetdiskOriginFile setVersion(Integer version) {
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
	public NetdiskOriginFile setCreateBy(String createBy) {
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
	public NetdiskOriginFile setCreateTime(Date createTime) {
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
	public NetdiskOriginFile setUpdateBy(String updateBy) {
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
	public NetdiskOriginFile setUpdateTime(Date updateTime) {
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
	public NetdiskOriginFile setDeleted(Integer deleted) {
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
	public NetdiskOriginFile setDeleted(Boolean deletedBool) {
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
	public NetdiskOriginFile setDeleteBy(String deleteBy) {
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
	public NetdiskOriginFile setDeleteTime(Date deleteTime) {
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
	public NetdiskOriginFile setTenantId(String tenantId) {
		this.tenantId=tenantId;
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
	public NetdiskOriginFile setOwnerUser(Employee ownerUser) {
		this.ownerUser=ownerUser;
		return this;
	}

	/**
	 * 将自己转换成指定类型的PO
	 * @param poType  PO类型
	 * @return NetdiskOriginFile , 转换好的 NetdiskOriginFile 对象
	*/
	@Transient
	public <T extends Entity> T toPO(Class<T> poType) {
		return EntityContext.create(poType, this);
	}

	/**
	 * 将自己转换成任意指定类型
	 * @param pojoType  Pojo类型
	 * @return NetdiskOriginFile , 转换好的 PoJo 对象
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
	public NetdiskOriginFile clone() {
		return duplicate(true);
	}

	/**
	 * 复制当前对象
	 * @param all 是否复制全部属性，当 false 时，仅复制来自数据表的属性
	*/
	@Transient
	public NetdiskOriginFile duplicate(boolean all) {
		com.dt.platform.domain.oa.meta.NetdiskOriginFileMeta.$$proxy$$ inst = new com.dt.platform.domain.oa.meta.NetdiskOriginFileMeta.$$proxy$$();
		inst.setFileName(this.getFileName());
		inst.setDownloadUrl(this.getDownloadUrl());
		inst.setExtValue(this.getExtValue());
		inst.setLastVisitTime(this.getLastVisitTime());
		inst.setUpdateBy(this.getUpdateBy());
		inst.setId(this.getId());
		inst.setStorageStoreId(this.getStorageStoreId());
		inst.setMediaType(this.getMediaType());
		inst.setUpdateTime(this.getUpdateTime());
		inst.setUserId(this.getUserId());
		inst.setVersion(this.getVersion());
		inst.setCreateBy(this.getCreateBy());
		inst.setDeleted(this.getDeleted());
		inst.setEncrypted(this.getEncrypted());
		inst.setFileSize(this.getFileSize());
		inst.setCreateTime(this.getCreateTime());
		inst.setDeleteTime(this.getDeleteTime());
		inst.setReferenceCount(this.getReferenceCount());
		inst.setTenantId(this.getTenantId());
		inst.setStorageType(this.getStorageType());
		inst.setDeleteBy(this.getDeleteBy());
		inst.setLocation(this.getLocation());
		inst.setMd5Value(this.getMd5Value());
		inst.setFileType(this.getFileType());
		inst.setDownloadCount(this.getDownloadCount());
		if(all) {
			inst.setOwnerUser(this.getOwnerUser());
		}
		inst.clearModifies();
		return inst;
	}

	/**
	 * 克隆当前对象
	*/
	@Transient
	public NetdiskOriginFile clone(boolean deep) {
		return EntityContext.clone(NetdiskOriginFile.class,this,deep);
	}

	/**
	 * 将 Map 转换成 NetdiskOriginFile
	 * @param netdiskOriginFileMap 包含实体信息的 Map 对象
	 * @return NetdiskOriginFile , 转换好的的 NetdiskOriginFile 对象
	*/
	@Transient
	public static NetdiskOriginFile createFrom(Map<String,Object> netdiskOriginFileMap) {
		if(netdiskOriginFileMap==null) return null;
		NetdiskOriginFile po = create();
		EntityContext.copyProperties(po,netdiskOriginFileMap);
		po.clearModifies();
		return po;
	}

	/**
	 * 将 Pojo 转换成 NetdiskOriginFile
	 * @param pojo 包含实体信息的 Pojo 对象
	 * @return NetdiskOriginFile , 转换好的的 NetdiskOriginFile 对象
	*/
	@Transient
	public static NetdiskOriginFile createFrom(Object pojo) {
		if(pojo==null) return null;
		NetdiskOriginFile po = create();
		EntityContext.copyProperties(po,pojo);
		po.clearModifies();
		return po;
	}

	/**
	 * 创建一个 NetdiskOriginFile，等同于 new
	 * @return NetdiskOriginFile 对象
	*/
	@Transient
	public static NetdiskOriginFile create() {
		return new com.dt.platform.domain.oa.meta.NetdiskOriginFileMeta.$$proxy$$();
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
			this.setFileName(DataParser.parse(String.class, map.get(NetdiskOriginFileMeta.FILE_NAME)));
			this.setDownloadUrl(DataParser.parse(String.class, map.get(NetdiskOriginFileMeta.DOWNLOAD_URL)));
			this.setExtValue(DataParser.parse(String.class, map.get(NetdiskOriginFileMeta.EXT_VALUE)));
			this.setLastVisitTime(DataParser.parse(Date.class, map.get(NetdiskOriginFileMeta.LAST_VISIT_TIME)));
			this.setUpdateBy(DataParser.parse(String.class, map.get(NetdiskOriginFileMeta.UPDATE_BY)));
			this.setId(DataParser.parse(String.class, map.get(NetdiskOriginFileMeta.ID)));
			this.setStorageStoreId(DataParser.parse(String.class, map.get(NetdiskOriginFileMeta.STORAGE_STORE_ID)));
			this.setMediaType(DataParser.parse(String.class, map.get(NetdiskOriginFileMeta.MEDIA_TYPE)));
			this.setUpdateTime(DataParser.parse(Date.class, map.get(NetdiskOriginFileMeta.UPDATE_TIME)));
			this.setUserId(DataParser.parse(String.class, map.get(NetdiskOriginFileMeta.USER_ID)));
			this.setVersion(DataParser.parse(Integer.class, map.get(NetdiskOriginFileMeta.VERSION)));
			this.setCreateBy(DataParser.parse(String.class, map.get(NetdiskOriginFileMeta.CREATE_BY)));
			this.setDeleted(DataParser.parse(Integer.class, map.get(NetdiskOriginFileMeta.DELETED)));
			this.setEncrypted(DataParser.parse(String.class, map.get(NetdiskOriginFileMeta.ENCRYPTED)));
			this.setFileSize(DataParser.parse(Long.class, map.get(NetdiskOriginFileMeta.FILE_SIZE)));
			this.setCreateTime(DataParser.parse(Date.class, map.get(NetdiskOriginFileMeta.CREATE_TIME)));
			this.setDeleteTime(DataParser.parse(Date.class, map.get(NetdiskOriginFileMeta.DELETE_TIME)));
			this.setReferenceCount(DataParser.parse(Integer.class, map.get(NetdiskOriginFileMeta.REFERENCE_COUNT)));
			this.setTenantId(DataParser.parse(String.class, map.get(NetdiskOriginFileMeta.TENANT_ID)));
			this.setStorageType(DataParser.parse(String.class, map.get(NetdiskOriginFileMeta.STORAGE_TYPE)));
			this.setDeleteBy(DataParser.parse(String.class, map.get(NetdiskOriginFileMeta.DELETE_BY)));
			this.setLocation(DataParser.parse(String.class, map.get(NetdiskOriginFileMeta.LOCATION)));
			this.setMd5Value(DataParser.parse(String.class, map.get(NetdiskOriginFileMeta.MD5_VALUE)));
			this.setFileType(DataParser.parse(String.class, map.get(NetdiskOriginFileMeta.FILE_TYPE)));
			this.setDownloadCount(DataParser.parse(Long.class, map.get(NetdiskOriginFileMeta.DOWNLOAD_COUNT)));
			// others
			this.setOwnerUser(DataParser.parse(Employee.class, map.get(NetdiskOriginFileMeta.OWNER_USER)));
			return true;
		} else {
			try {
				this.setFileName( (String)map.get(NetdiskOriginFileMeta.FILE_NAME));
				this.setDownloadUrl( (String)map.get(NetdiskOriginFileMeta.DOWNLOAD_URL));
				this.setExtValue( (String)map.get(NetdiskOriginFileMeta.EXT_VALUE));
				this.setLastVisitTime( (Date)map.get(NetdiskOriginFileMeta.LAST_VISIT_TIME));
				this.setUpdateBy( (String)map.get(NetdiskOriginFileMeta.UPDATE_BY));
				this.setId( (String)map.get(NetdiskOriginFileMeta.ID));
				this.setStorageStoreId( (String)map.get(NetdiskOriginFileMeta.STORAGE_STORE_ID));
				this.setMediaType( (String)map.get(NetdiskOriginFileMeta.MEDIA_TYPE));
				this.setUpdateTime( (Date)map.get(NetdiskOriginFileMeta.UPDATE_TIME));
				this.setUserId( (String)map.get(NetdiskOriginFileMeta.USER_ID));
				this.setVersion( (Integer)map.get(NetdiskOriginFileMeta.VERSION));
				this.setCreateBy( (String)map.get(NetdiskOriginFileMeta.CREATE_BY));
				this.setDeleted( (Integer)map.get(NetdiskOriginFileMeta.DELETED));
				this.setEncrypted( (String)map.get(NetdiskOriginFileMeta.ENCRYPTED));
				this.setFileSize( (Long)map.get(NetdiskOriginFileMeta.FILE_SIZE));
				this.setCreateTime( (Date)map.get(NetdiskOriginFileMeta.CREATE_TIME));
				this.setDeleteTime( (Date)map.get(NetdiskOriginFileMeta.DELETE_TIME));
				this.setReferenceCount( (Integer)map.get(NetdiskOriginFileMeta.REFERENCE_COUNT));
				this.setTenantId( (String)map.get(NetdiskOriginFileMeta.TENANT_ID));
				this.setStorageType( (String)map.get(NetdiskOriginFileMeta.STORAGE_TYPE));
				this.setDeleteBy( (String)map.get(NetdiskOriginFileMeta.DELETE_BY));
				this.setLocation( (String)map.get(NetdiskOriginFileMeta.LOCATION));
				this.setMd5Value( (String)map.get(NetdiskOriginFileMeta.MD5_VALUE));
				this.setFileType( (String)map.get(NetdiskOriginFileMeta.FILE_TYPE));
				this.setDownloadCount( (Long)map.get(NetdiskOriginFileMeta.DOWNLOAD_COUNT));
				// others
				this.setOwnerUser( (Employee)map.get(NetdiskOriginFileMeta.OWNER_USER));
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
			this.setFileName(DataParser.parse(String.class, r.getValue(NetdiskOriginFileMeta.FILE_NAME)));
			this.setDownloadUrl(DataParser.parse(String.class, r.getValue(NetdiskOriginFileMeta.DOWNLOAD_URL)));
			this.setExtValue(DataParser.parse(String.class, r.getValue(NetdiskOriginFileMeta.EXT_VALUE)));
			this.setLastVisitTime(DataParser.parse(Date.class, r.getValue(NetdiskOriginFileMeta.LAST_VISIT_TIME)));
			this.setUpdateBy(DataParser.parse(String.class, r.getValue(NetdiskOriginFileMeta.UPDATE_BY)));
			this.setId(DataParser.parse(String.class, r.getValue(NetdiskOriginFileMeta.ID)));
			this.setStorageStoreId(DataParser.parse(String.class, r.getValue(NetdiskOriginFileMeta.STORAGE_STORE_ID)));
			this.setMediaType(DataParser.parse(String.class, r.getValue(NetdiskOriginFileMeta.MEDIA_TYPE)));
			this.setUpdateTime(DataParser.parse(Date.class, r.getValue(NetdiskOriginFileMeta.UPDATE_TIME)));
			this.setUserId(DataParser.parse(String.class, r.getValue(NetdiskOriginFileMeta.USER_ID)));
			this.setVersion(DataParser.parse(Integer.class, r.getValue(NetdiskOriginFileMeta.VERSION)));
			this.setCreateBy(DataParser.parse(String.class, r.getValue(NetdiskOriginFileMeta.CREATE_BY)));
			this.setDeleted(DataParser.parse(Integer.class, r.getValue(NetdiskOriginFileMeta.DELETED)));
			this.setEncrypted(DataParser.parse(String.class, r.getValue(NetdiskOriginFileMeta.ENCRYPTED)));
			this.setFileSize(DataParser.parse(Long.class, r.getValue(NetdiskOriginFileMeta.FILE_SIZE)));
			this.setCreateTime(DataParser.parse(Date.class, r.getValue(NetdiskOriginFileMeta.CREATE_TIME)));
			this.setDeleteTime(DataParser.parse(Date.class, r.getValue(NetdiskOriginFileMeta.DELETE_TIME)));
			this.setReferenceCount(DataParser.parse(Integer.class, r.getValue(NetdiskOriginFileMeta.REFERENCE_COUNT)));
			this.setTenantId(DataParser.parse(String.class, r.getValue(NetdiskOriginFileMeta.TENANT_ID)));
			this.setStorageType(DataParser.parse(String.class, r.getValue(NetdiskOriginFileMeta.STORAGE_TYPE)));
			this.setDeleteBy(DataParser.parse(String.class, r.getValue(NetdiskOriginFileMeta.DELETE_BY)));
			this.setLocation(DataParser.parse(String.class, r.getValue(NetdiskOriginFileMeta.LOCATION)));
			this.setMd5Value(DataParser.parse(String.class, r.getValue(NetdiskOriginFileMeta.MD5_VALUE)));
			this.setFileType(DataParser.parse(String.class, r.getValue(NetdiskOriginFileMeta.FILE_TYPE)));
			this.setDownloadCount(DataParser.parse(Long.class, r.getValue(NetdiskOriginFileMeta.DOWNLOAD_COUNT)));
			return true;
		} else {
			try {
				this.setFileName( (String)r.getValue(NetdiskOriginFileMeta.FILE_NAME));
				this.setDownloadUrl( (String)r.getValue(NetdiskOriginFileMeta.DOWNLOAD_URL));
				this.setExtValue( (String)r.getValue(NetdiskOriginFileMeta.EXT_VALUE));
				this.setLastVisitTime( (Date)r.getValue(NetdiskOriginFileMeta.LAST_VISIT_TIME));
				this.setUpdateBy( (String)r.getValue(NetdiskOriginFileMeta.UPDATE_BY));
				this.setId( (String)r.getValue(NetdiskOriginFileMeta.ID));
				this.setStorageStoreId( (String)r.getValue(NetdiskOriginFileMeta.STORAGE_STORE_ID));
				this.setMediaType( (String)r.getValue(NetdiskOriginFileMeta.MEDIA_TYPE));
				this.setUpdateTime( (Date)r.getValue(NetdiskOriginFileMeta.UPDATE_TIME));
				this.setUserId( (String)r.getValue(NetdiskOriginFileMeta.USER_ID));
				this.setVersion( (Integer)r.getValue(NetdiskOriginFileMeta.VERSION));
				this.setCreateBy( (String)r.getValue(NetdiskOriginFileMeta.CREATE_BY));
				this.setDeleted( (Integer)r.getValue(NetdiskOriginFileMeta.DELETED));
				this.setEncrypted( (String)r.getValue(NetdiskOriginFileMeta.ENCRYPTED));
				this.setFileSize( (Long)r.getValue(NetdiskOriginFileMeta.FILE_SIZE));
				this.setCreateTime( (Date)r.getValue(NetdiskOriginFileMeta.CREATE_TIME));
				this.setDeleteTime( (Date)r.getValue(NetdiskOriginFileMeta.DELETE_TIME));
				this.setReferenceCount( (Integer)r.getValue(NetdiskOriginFileMeta.REFERENCE_COUNT));
				this.setTenantId( (String)r.getValue(NetdiskOriginFileMeta.TENANT_ID));
				this.setStorageType( (String)r.getValue(NetdiskOriginFileMeta.STORAGE_TYPE));
				this.setDeleteBy( (String)r.getValue(NetdiskOriginFileMeta.DELETE_BY));
				this.setLocation( (String)r.getValue(NetdiskOriginFileMeta.LOCATION));
				this.setMd5Value( (String)r.getValue(NetdiskOriginFileMeta.MD5_VALUE));
				this.setFileType( (String)r.getValue(NetdiskOriginFileMeta.FILE_TYPE));
				this.setDownloadCount( (Long)r.getValue(NetdiskOriginFileMeta.DOWNLOAD_COUNT));
				return true;
			} catch (Exception e) {
				return false;
			}
		}
	}
}