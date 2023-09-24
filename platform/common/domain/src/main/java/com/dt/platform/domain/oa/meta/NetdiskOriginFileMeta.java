package com.dt.platform.domain.oa.meta;

import com.github.foxnic.api.bean.BeanProperty;
import com.dt.platform.domain.oa.NetdiskOriginFile;
import java.util.Date;
import org.github.foxnic.web.domain.hrm.Employee;
import javax.persistence.Transient;



/**
 * @author 金杰 , maillank@qq.com
 * @since 2023-09-22 18:17:17
 * @sign ABD3F8F4A8F8C3722AC5568AE18B0D93
 * 此文件由工具自动生成，请勿修改。若表结构或配置发生变动，请使用工具重新生成。
*/

public class NetdiskOriginFileMeta {
	
	/**
	 * 主键 , 类型: java.lang.String
	*/
	public static final String ID="id";
	
	/**
	 * 主键 , 类型: java.lang.String
	*/
	public static final BeanProperty<com.dt.platform.domain.oa.NetdiskOriginFile,java.lang.String> ID_PROP = new BeanProperty(com.dt.platform.domain.oa.NetdiskOriginFile.class ,ID, java.lang.String.class, "主键", "主键", java.lang.String.class, null);
	
	/**
	 * 文件名称 , 类型: java.lang.String
	*/
	public static final String FILE_NAME="fileName";
	
	/**
	 * 文件名称 , 类型: java.lang.String
	*/
	public static final BeanProperty<com.dt.platform.domain.oa.NetdiskOriginFile,java.lang.String> FILE_NAME_PROP = new BeanProperty(com.dt.platform.domain.oa.NetdiskOriginFile.class ,FILE_NAME, java.lang.String.class, "文件名称", "文件名称", java.lang.String.class, null);
	
	/**
	 * 大小 , 类型: java.lang.Long
	*/
	public static final String FILE_SIZE="fileSize";
	
	/**
	 * 大小 , 类型: java.lang.Long
	*/
	public static final BeanProperty<com.dt.platform.domain.oa.NetdiskOriginFile,java.lang.Long> FILE_SIZE_PROP = new BeanProperty(com.dt.platform.domain.oa.NetdiskOriginFile.class ,FILE_SIZE, java.lang.Long.class, "大小", "大小", java.lang.Long.class, null);
	
	/**
	 * 路径 , 类型: java.lang.String
	*/
	public static final String LOCATION="location";
	
	/**
	 * 路径 , 类型: java.lang.String
	*/
	public static final BeanProperty<com.dt.platform.domain.oa.NetdiskOriginFile,java.lang.String> LOCATION_PROP = new BeanProperty(com.dt.platform.domain.oa.NetdiskOriginFile.class ,LOCATION, java.lang.String.class, "路径", "路径", java.lang.String.class, null);
	
	/**
	 * 媒体类型 , 类型: java.lang.String
	*/
	public static final String MEDIA_TYPE="mediaType";
	
	/**
	 * 媒体类型 , 类型: java.lang.String
	*/
	public static final BeanProperty<com.dt.platform.domain.oa.NetdiskOriginFile,java.lang.String> MEDIA_TYPE_PROP = new BeanProperty(com.dt.platform.domain.oa.NetdiskOriginFile.class ,MEDIA_TYPE, java.lang.String.class, "媒体类型", "媒体类型", java.lang.String.class, null);
	
	/**
	 * 文件类型 , 类型: java.lang.String
	*/
	public static final String FILE_TYPE="fileType";
	
	/**
	 * 文件类型 , 类型: java.lang.String
	*/
	public static final BeanProperty<com.dt.platform.domain.oa.NetdiskOriginFile,java.lang.String> FILE_TYPE_PROP = new BeanProperty(com.dt.platform.domain.oa.NetdiskOriginFile.class ,FILE_TYPE, java.lang.String.class, "文件类型", "文件类型", java.lang.String.class, null);
	
	/**
	 * 扩展类型 , jpg,png , 类型: java.lang.String
	*/
	public static final String EXT_VALUE="extValue";
	
	/**
	 * 扩展类型 , jpg,png , 类型: java.lang.String
	*/
	public static final BeanProperty<com.dt.platform.domain.oa.NetdiskOriginFile,java.lang.String> EXT_VALUE_PROP = new BeanProperty(com.dt.platform.domain.oa.NetdiskOriginFile.class ,EXT_VALUE, java.lang.String.class, "扩展类型", "jpg,png", java.lang.String.class, null);
	
	/**
	 * 存储类型 , 类型: java.lang.String
	*/
	public static final String STORAGE_TYPE="storageType";
	
	/**
	 * 存储类型 , 类型: java.lang.String
	*/
	public static final BeanProperty<com.dt.platform.domain.oa.NetdiskOriginFile,java.lang.String> STORAGE_TYPE_PROP = new BeanProperty(com.dt.platform.domain.oa.NetdiskOriginFile.class ,STORAGE_TYPE, java.lang.String.class, "存储类型", "存储类型", java.lang.String.class, null);
	
	/**
	 * 是否加密 , Y|N , 类型: java.lang.String
	*/
	public static final String ENCRYPTED="encrypted";
	
	/**
	 * 是否加密 , Y|N , 类型: java.lang.String
	*/
	public static final BeanProperty<com.dt.platform.domain.oa.NetdiskOriginFile,java.lang.String> ENCRYPTED_PROP = new BeanProperty(com.dt.platform.domain.oa.NetdiskOriginFile.class ,ENCRYPTED, java.lang.String.class, "是否加密", "Y|N", java.lang.String.class, null);
	
	/**
	 * 所属用户 , 类型: java.lang.String
	*/
	public static final String USER_ID="userId";
	
	/**
	 * 所属用户 , 类型: java.lang.String
	*/
	public static final BeanProperty<com.dt.platform.domain.oa.NetdiskOriginFile,java.lang.String> USER_ID_PROP = new BeanProperty(com.dt.platform.domain.oa.NetdiskOriginFile.class ,USER_ID, java.lang.String.class, "所属用户", "所属用户", java.lang.String.class, null);
	
	/**
	 * 存储地址 , 类型: java.lang.String
	*/
	public static final String STORAGE_STORE_ID="storageStoreId";
	
	/**
	 * 存储地址 , 类型: java.lang.String
	*/
	public static final BeanProperty<com.dt.platform.domain.oa.NetdiskOriginFile,java.lang.String> STORAGE_STORE_ID_PROP = new BeanProperty(com.dt.platform.domain.oa.NetdiskOriginFile.class ,STORAGE_STORE_ID, java.lang.String.class, "存储地址", "存储地址", java.lang.String.class, null);
	
	/**
	 * 下载地址 , 类型: java.lang.String
	*/
	public static final String DOWNLOAD_URL="downloadUrl";
	
	/**
	 * 下载地址 , 类型: java.lang.String
	*/
	public static final BeanProperty<com.dt.platform.domain.oa.NetdiskOriginFile,java.lang.String> DOWNLOAD_URL_PROP = new BeanProperty(com.dt.platform.domain.oa.NetdiskOriginFile.class ,DOWNLOAD_URL, java.lang.String.class, "下载地址", "下载地址", java.lang.String.class, null);
	
	/**
	 * 下载次数 , 类型: java.lang.Long
	*/
	public static final String DOWNLOAD_COUNT="downloadCount";
	
	/**
	 * 下载次数 , 类型: java.lang.Long
	*/
	public static final BeanProperty<com.dt.platform.domain.oa.NetdiskOriginFile,java.lang.Long> DOWNLOAD_COUNT_PROP = new BeanProperty(com.dt.platform.domain.oa.NetdiskOriginFile.class ,DOWNLOAD_COUNT, java.lang.Long.class, "下载次数", "下载次数", java.lang.Long.class, null);
	
	/**
	 * 引用次数 , 类型: java.lang.Integer
	*/
	public static final String REFERENCE_COUNT="referenceCount";
	
	/**
	 * 引用次数 , 类型: java.lang.Integer
	*/
	public static final BeanProperty<com.dt.platform.domain.oa.NetdiskOriginFile,java.lang.Integer> REFERENCE_COUNT_PROP = new BeanProperty(com.dt.platform.domain.oa.NetdiskOriginFile.class ,REFERENCE_COUNT, java.lang.Integer.class, "引用次数", "引用次数", java.lang.Integer.class, null);
	
	/**
	 * 上次访问时间 , 类型: java.util.Date
	*/
	public static final String LAST_VISIT_TIME="lastVisitTime";
	
	/**
	 * 上次访问时间 , 类型: java.util.Date
	*/
	public static final BeanProperty<com.dt.platform.domain.oa.NetdiskOriginFile,java.util.Date> LAST_VISIT_TIME_PROP = new BeanProperty(com.dt.platform.domain.oa.NetdiskOriginFile.class ,LAST_VISIT_TIME, java.util.Date.class, "上次访问时间", "上次访问时间", java.util.Date.class, null);
	
	/**
	 * MD5 , 类型: java.lang.String
	*/
	public static final String MD5_VALUE="md5Value";
	
	/**
	 * MD5 , 类型: java.lang.String
	*/
	public static final BeanProperty<com.dt.platform.domain.oa.NetdiskOriginFile,java.lang.String> MD5_VALUE_PROP = new BeanProperty(com.dt.platform.domain.oa.NetdiskOriginFile.class ,MD5_VALUE, java.lang.String.class, "MD5", "MD5", java.lang.String.class, null);
	
	/**
	 * 版本 , 类型: java.lang.Integer
	*/
	public static final String VERSION="version";
	
	/**
	 * 版本 , 类型: java.lang.Integer
	*/
	public static final BeanProperty<com.dt.platform.domain.oa.NetdiskOriginFile,java.lang.Integer> VERSION_PROP = new BeanProperty(com.dt.platform.domain.oa.NetdiskOriginFile.class ,VERSION, java.lang.Integer.class, "版本", "版本", java.lang.Integer.class, null);
	
	/**
	 * 创建人ID , 类型: java.lang.String
	*/
	public static final String CREATE_BY="createBy";
	
	/**
	 * 创建人ID , 类型: java.lang.String
	*/
	public static final BeanProperty<com.dt.platform.domain.oa.NetdiskOriginFile,java.lang.String> CREATE_BY_PROP = new BeanProperty(com.dt.platform.domain.oa.NetdiskOriginFile.class ,CREATE_BY, java.lang.String.class, "创建人ID", "创建人ID", java.lang.String.class, null);
	
	/**
	 * 创建时间 , 类型: java.util.Date
	*/
	public static final String CREATE_TIME="createTime";
	
	/**
	 * 创建时间 , 类型: java.util.Date
	*/
	public static final BeanProperty<com.dt.platform.domain.oa.NetdiskOriginFile,java.util.Date> CREATE_TIME_PROP = new BeanProperty(com.dt.platform.domain.oa.NetdiskOriginFile.class ,CREATE_TIME, java.util.Date.class, "创建时间", "创建时间", java.util.Date.class, null);
	
	/**
	 * 修改人ID , 类型: java.lang.String
	*/
	public static final String UPDATE_BY="updateBy";
	
	/**
	 * 修改人ID , 类型: java.lang.String
	*/
	public static final BeanProperty<com.dt.platform.domain.oa.NetdiskOriginFile,java.lang.String> UPDATE_BY_PROP = new BeanProperty(com.dt.platform.domain.oa.NetdiskOriginFile.class ,UPDATE_BY, java.lang.String.class, "修改人ID", "修改人ID", java.lang.String.class, null);
	
	/**
	 * 修改时间 , 类型: java.util.Date
	*/
	public static final String UPDATE_TIME="updateTime";
	
	/**
	 * 修改时间 , 类型: java.util.Date
	*/
	public static final BeanProperty<com.dt.platform.domain.oa.NetdiskOriginFile,java.util.Date> UPDATE_TIME_PROP = new BeanProperty(com.dt.platform.domain.oa.NetdiskOriginFile.class ,UPDATE_TIME, java.util.Date.class, "修改时间", "修改时间", java.util.Date.class, null);
	
	/**
	 * 是否已删除 , 类型: java.lang.Integer
	*/
	public static final String DELETED="deleted";
	
	/**
	 * 是否已删除 , 类型: java.lang.Integer
	*/
	public static final BeanProperty<com.dt.platform.domain.oa.NetdiskOriginFile,java.lang.Integer> DELETED_PROP = new BeanProperty(com.dt.platform.domain.oa.NetdiskOriginFile.class ,DELETED, java.lang.Integer.class, "是否已删除", "是否已删除", java.lang.Integer.class, null);
	
	/**
	 * 删除人ID , 类型: java.lang.String
	*/
	public static final String DELETE_BY="deleteBy";
	
	/**
	 * 删除人ID , 类型: java.lang.String
	*/
	public static final BeanProperty<com.dt.platform.domain.oa.NetdiskOriginFile,java.lang.String> DELETE_BY_PROP = new BeanProperty(com.dt.platform.domain.oa.NetdiskOriginFile.class ,DELETE_BY, java.lang.String.class, "删除人ID", "删除人ID", java.lang.String.class, null);
	
	/**
	 * 删除时间 , 类型: java.util.Date
	*/
	public static final String DELETE_TIME="deleteTime";
	
	/**
	 * 删除时间 , 类型: java.util.Date
	*/
	public static final BeanProperty<com.dt.platform.domain.oa.NetdiskOriginFile,java.util.Date> DELETE_TIME_PROP = new BeanProperty(com.dt.platform.domain.oa.NetdiskOriginFile.class ,DELETE_TIME, java.util.Date.class, "删除时间", "删除时间", java.util.Date.class, null);
	
	/**
	 * 租户 , 类型: java.lang.String
	*/
	public static final String TENANT_ID="tenantId";
	
	/**
	 * 租户 , 类型: java.lang.String
	*/
	public static final BeanProperty<com.dt.platform.domain.oa.NetdiskOriginFile,java.lang.String> TENANT_ID_PROP = new BeanProperty(com.dt.platform.domain.oa.NetdiskOriginFile.class ,TENANT_ID, java.lang.String.class, "租户", "租户", java.lang.String.class, null);
	
	/**
	 * ownerUser , 类型: org.github.foxnic.web.domain.hrm.Employee
	*/
	public static final String OWNER_USER="ownerUser";
	
	/**
	 * ownerUser , 类型: org.github.foxnic.web.domain.hrm.Employee
	*/
	public static final BeanProperty<com.dt.platform.domain.oa.NetdiskOriginFile,org.github.foxnic.web.domain.hrm.Employee> OWNER_USER_PROP = new BeanProperty(com.dt.platform.domain.oa.NetdiskOriginFile.class ,OWNER_USER, org.github.foxnic.web.domain.hrm.Employee.class, "ownerUser", "ownerUser", org.github.foxnic.web.domain.hrm.Employee.class, null);
	
	/**
	 * 全部属性清单
	*/
	public static final String[] $PROPS={ ID , FILE_NAME , FILE_SIZE , LOCATION , MEDIA_TYPE , FILE_TYPE , EXT_VALUE , STORAGE_TYPE , ENCRYPTED , USER_ID , STORAGE_STORE_ID , DOWNLOAD_URL , DOWNLOAD_COUNT , REFERENCE_COUNT , LAST_VISIT_TIME , MD5_VALUE , VERSION , CREATE_BY , CREATE_TIME , UPDATE_BY , UPDATE_TIME , DELETED , DELETE_BY , DELETE_TIME , TENANT_ID , OWNER_USER };
	
	/**
	 * 代理类
	*/
	public static class $$proxy$$ extends com.dt.platform.domain.oa.NetdiskOriginFile {

		private static final long serialVersionUID = 1L;

		
		/**
		 * 设置 主键
		 * @param id 主键
		 * @return 当前对象
		*/
		public NetdiskOriginFile setId(String id) {
			super.change(ID,super.getId(),id);
			super.setId(id);
			return this;
		}
		
		/**
		 * 设置 文件名称
		 * @param fileName 文件名称
		 * @return 当前对象
		*/
		public NetdiskOriginFile setFileName(String fileName) {
			super.change(FILE_NAME,super.getFileName(),fileName);
			super.setFileName(fileName);
			return this;
		}
		
		/**
		 * 设置 大小
		 * @param fileSize 大小
		 * @return 当前对象
		*/
		public NetdiskOriginFile setFileSize(Long fileSize) {
			super.change(FILE_SIZE,super.getFileSize(),fileSize);
			super.setFileSize(fileSize);
			return this;
		}
		
		/**
		 * 设置 路径
		 * @param location 路径
		 * @return 当前对象
		*/
		public NetdiskOriginFile setLocation(String location) {
			super.change(LOCATION,super.getLocation(),location);
			super.setLocation(location);
			return this;
		}
		
		/**
		 * 设置 媒体类型
		 * @param mediaType 媒体类型
		 * @return 当前对象
		*/
		public NetdiskOriginFile setMediaType(String mediaType) {
			super.change(MEDIA_TYPE,super.getMediaType(),mediaType);
			super.setMediaType(mediaType);
			return this;
		}
		
		/**
		 * 设置 文件类型
		 * @param fileType 文件类型
		 * @return 当前对象
		*/
		public NetdiskOriginFile setFileType(String fileType) {
			super.change(FILE_TYPE,super.getFileType(),fileType);
			super.setFileType(fileType);
			return this;
		}
		
		/**
		 * 设置 扩展类型
		 * @param extValue 扩展类型
		 * @return 当前对象
		*/
		public NetdiskOriginFile setExtValue(String extValue) {
			super.change(EXT_VALUE,super.getExtValue(),extValue);
			super.setExtValue(extValue);
			return this;
		}
		
		/**
		 * 设置 存储类型
		 * @param storageType 存储类型
		 * @return 当前对象
		*/
		public NetdiskOriginFile setStorageType(String storageType) {
			super.change(STORAGE_TYPE,super.getStorageType(),storageType);
			super.setStorageType(storageType);
			return this;
		}
		
		/**
		 * 设置 是否加密
		 * @param encrypted 是否加密
		 * @return 当前对象
		*/
		public NetdiskOriginFile setEncrypted(String encrypted) {
			super.change(ENCRYPTED,super.getEncrypted(),encrypted);
			super.setEncrypted(encrypted);
			return this;
		}
		
		/**
		 * 设置 所属用户
		 * @param userId 所属用户
		 * @return 当前对象
		*/
		public NetdiskOriginFile setUserId(String userId) {
			super.change(USER_ID,super.getUserId(),userId);
			super.setUserId(userId);
			return this;
		}
		
		/**
		 * 设置 存储地址
		 * @param storageStoreId 存储地址
		 * @return 当前对象
		*/
		public NetdiskOriginFile setStorageStoreId(String storageStoreId) {
			super.change(STORAGE_STORE_ID,super.getStorageStoreId(),storageStoreId);
			super.setStorageStoreId(storageStoreId);
			return this;
		}
		
		/**
		 * 设置 下载地址
		 * @param downloadUrl 下载地址
		 * @return 当前对象
		*/
		public NetdiskOriginFile setDownloadUrl(String downloadUrl) {
			super.change(DOWNLOAD_URL,super.getDownloadUrl(),downloadUrl);
			super.setDownloadUrl(downloadUrl);
			return this;
		}
		
		/**
		 * 设置 下载次数
		 * @param downloadCount 下载次数
		 * @return 当前对象
		*/
		public NetdiskOriginFile setDownloadCount(Long downloadCount) {
			super.change(DOWNLOAD_COUNT,super.getDownloadCount(),downloadCount);
			super.setDownloadCount(downloadCount);
			return this;
		}
		
		/**
		 * 设置 引用次数
		 * @param referenceCount 引用次数
		 * @return 当前对象
		*/
		public NetdiskOriginFile setReferenceCount(Integer referenceCount) {
			super.change(REFERENCE_COUNT,super.getReferenceCount(),referenceCount);
			super.setReferenceCount(referenceCount);
			return this;
		}
		
		/**
		 * 设置 上次访问时间
		 * @param lastVisitTime 上次访问时间
		 * @return 当前对象
		*/
		public NetdiskOriginFile setLastVisitTime(Date lastVisitTime) {
			super.change(LAST_VISIT_TIME,super.getLastVisitTime(),lastVisitTime);
			super.setLastVisitTime(lastVisitTime);
			return this;
		}
		
		/**
		 * 设置 MD5
		 * @param md5Value MD5
		 * @return 当前对象
		*/
		public NetdiskOriginFile setMd5Value(String md5Value) {
			super.change(MD5_VALUE,super.getMd5Value(),md5Value);
			super.setMd5Value(md5Value);
			return this;
		}
		
		/**
		 * 设置 版本
		 * @param version 版本
		 * @return 当前对象
		*/
		public NetdiskOriginFile setVersion(Integer version) {
			super.change(VERSION,super.getVersion(),version);
			super.setVersion(version);
			return this;
		}
		
		/**
		 * 设置 创建人ID
		 * @param createBy 创建人ID
		 * @return 当前对象
		*/
		public NetdiskOriginFile setCreateBy(String createBy) {
			super.change(CREATE_BY,super.getCreateBy(),createBy);
			super.setCreateBy(createBy);
			return this;
		}
		
		/**
		 * 设置 创建时间
		 * @param createTime 创建时间
		 * @return 当前对象
		*/
		public NetdiskOriginFile setCreateTime(Date createTime) {
			super.change(CREATE_TIME,super.getCreateTime(),createTime);
			super.setCreateTime(createTime);
			return this;
		}
		
		/**
		 * 设置 修改人ID
		 * @param updateBy 修改人ID
		 * @return 当前对象
		*/
		public NetdiskOriginFile setUpdateBy(String updateBy) {
			super.change(UPDATE_BY,super.getUpdateBy(),updateBy);
			super.setUpdateBy(updateBy);
			return this;
		}
		
		/**
		 * 设置 修改时间
		 * @param updateTime 修改时间
		 * @return 当前对象
		*/
		public NetdiskOriginFile setUpdateTime(Date updateTime) {
			super.change(UPDATE_TIME,super.getUpdateTime(),updateTime);
			super.setUpdateTime(updateTime);
			return this;
		}
		
		/**
		 * 设置 是否已删除
		 * @param deleted 是否已删除
		 * @return 当前对象
		*/
		public NetdiskOriginFile setDeleted(Integer deleted) {
			super.change(DELETED,super.getDeleted(),deleted);
			super.setDeleted(deleted);
			return this;
		}
		
		/**
		 * 设置 删除人ID
		 * @param deleteBy 删除人ID
		 * @return 当前对象
		*/
		public NetdiskOriginFile setDeleteBy(String deleteBy) {
			super.change(DELETE_BY,super.getDeleteBy(),deleteBy);
			super.setDeleteBy(deleteBy);
			return this;
		}
		
		/**
		 * 设置 删除时间
		 * @param deleteTime 删除时间
		 * @return 当前对象
		*/
		public NetdiskOriginFile setDeleteTime(Date deleteTime) {
			super.change(DELETE_TIME,super.getDeleteTime(),deleteTime);
			super.setDeleteTime(deleteTime);
			return this;
		}
		
		/**
		 * 设置 租户
		 * @param tenantId 租户
		 * @return 当前对象
		*/
		public NetdiskOriginFile setTenantId(String tenantId) {
			super.change(TENANT_ID,super.getTenantId(),tenantId);
			super.setTenantId(tenantId);
			return this;
		}
		
		/**
		 * 设置 ownerUser
		 * @param ownerUser ownerUser
		 * @return 当前对象
		*/
		public NetdiskOriginFile setOwnerUser(Employee ownerUser) {
			super.change(OWNER_USER,super.getOwnerUser(),ownerUser);
			super.setOwnerUser(ownerUser);
			return this;
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
			$$proxy$$ inst=new $$proxy$$();
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

	}
}