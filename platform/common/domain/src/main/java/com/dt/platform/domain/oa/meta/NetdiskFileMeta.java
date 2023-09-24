package com.dt.platform.domain.oa.meta;

import com.github.foxnic.api.bean.BeanProperty;
import com.dt.platform.domain.oa.NetdiskFile;
import java.util.Date;
import com.dt.platform.domain.oa.NetdiskOriginFile;
import com.dt.platform.domain.oa.NetdiskFolder;
import org.github.foxnic.web.domain.hrm.Employee;
import javax.persistence.Transient;



/**
 * @author 金杰 , maillank@qq.com
 * @since 2023-09-23 07:46:34
 * @sign F7554909F995A13A33688B47A593E0A0
 * 此文件由工具自动生成，请勿修改。若表结构或配置发生变动，请使用工具重新生成。
*/

public class NetdiskFileMeta {
	
	/**
	 * 主键 , 类型: java.lang.String
	*/
	public static final String ID="id";
	
	/**
	 * 主键 , 类型: java.lang.String
	*/
	public static final BeanProperty<com.dt.platform.domain.oa.NetdiskFile,java.lang.String> ID_PROP = new BeanProperty(com.dt.platform.domain.oa.NetdiskFile.class ,ID, java.lang.String.class, "主键", "主键", java.lang.String.class, null);
	
	/**
	 * 文件 , 类型: java.lang.String
	*/
	public static final String ORIGIN_FILE_ID="originFileId";
	
	/**
	 * 文件 , 类型: java.lang.String
	*/
	public static final BeanProperty<com.dt.platform.domain.oa.NetdiskFile,java.lang.String> ORIGIN_FILE_ID_PROP = new BeanProperty(com.dt.platform.domain.oa.NetdiskFile.class ,ORIGIN_FILE_ID, java.lang.String.class, "文件", "文件", java.lang.String.class, null);
	
	/**
	 * 名称 , 类型: java.lang.String
	*/
	public static final String FILE_NAME="fileName";
	
	/**
	 * 名称 , 类型: java.lang.String
	*/
	public static final BeanProperty<com.dt.platform.domain.oa.NetdiskFile,java.lang.String> FILE_NAME_PROP = new BeanProperty(com.dt.platform.domain.oa.NetdiskFile.class ,FILE_NAME, java.lang.String.class, "名称", "名称", java.lang.String.class, null);
	
	/**
	 * 大小 , 类型: java.lang.String
	*/
	public static final String FILE_SIZE="fileSize";
	
	/**
	 * 大小 , 类型: java.lang.String
	*/
	public static final BeanProperty<com.dt.platform.domain.oa.NetdiskFile,java.lang.String> FILE_SIZE_PROP = new BeanProperty(com.dt.platform.domain.oa.NetdiskFile.class ,FILE_SIZE, java.lang.String.class, "大小", "大小", java.lang.String.class, null);
	
	/**
	 * 类型 , 类型: java.lang.String
	*/
	public static final String FILE_TYPE="fileType";
	
	/**
	 * 类型 , 类型: java.lang.String
	*/
	public static final BeanProperty<com.dt.platform.domain.oa.NetdiskFile,java.lang.String> FILE_TYPE_PROP = new BeanProperty(com.dt.platform.domain.oa.NetdiskFile.class ,FILE_TYPE, java.lang.String.class, "类型", "类型", java.lang.String.class, null);
	
	/**
	 * 是否收藏 , 类型: java.lang.String
	*/
	public static final String IS_FAVOURITE="isFavourite";
	
	/**
	 * 是否收藏 , 类型: java.lang.String
	*/
	public static final BeanProperty<com.dt.platform.domain.oa.NetdiskFile,java.lang.String> IS_FAVOURITE_PROP = new BeanProperty(com.dt.platform.domain.oa.NetdiskFile.class ,IS_FAVOURITE, java.lang.String.class, "是否收藏", "是否收藏", java.lang.String.class, null);
	
	/**
	 * 回收站 , 类型: java.lang.String
	*/
	public static final String IN_RECYCLE="inRecycle";
	
	/**
	 * 回收站 , 类型: java.lang.String
	*/
	public static final BeanProperty<com.dt.platform.domain.oa.NetdiskFile,java.lang.String> IN_RECYCLE_PROP = new BeanProperty(com.dt.platform.domain.oa.NetdiskFile.class ,IN_RECYCLE, java.lang.String.class, "回收站", "回收站", java.lang.String.class, null);
	
	/**
	 * 用户 , 类型: java.lang.String
	*/
	public static final String USER_ID="userId";
	
	/**
	 * 用户 , 类型: java.lang.String
	*/
	public static final BeanProperty<com.dt.platform.domain.oa.NetdiskFile,java.lang.String> USER_ID_PROP = new BeanProperty(com.dt.platform.domain.oa.NetdiskFile.class ,USER_ID, java.lang.String.class, "用户", "用户", java.lang.String.class, null);
	
	/**
	 * 文件夹 , 类型: java.lang.String
	*/
	public static final String FOLDER_ID="folderId";
	
	/**
	 * 文件夹 , 类型: java.lang.String
	*/
	public static final BeanProperty<com.dt.platform.domain.oa.NetdiskFile,java.lang.String> FOLDER_ID_PROP = new BeanProperty(com.dt.platform.domain.oa.NetdiskFile.class ,FOLDER_ID, java.lang.String.class, "文件夹", "文件夹", java.lang.String.class, null);
	
	/**
	 * 版本 , 类型: java.lang.Integer
	*/
	public static final String VERSION="version";
	
	/**
	 * 版本 , 类型: java.lang.Integer
	*/
	public static final BeanProperty<com.dt.platform.domain.oa.NetdiskFile,java.lang.Integer> VERSION_PROP = new BeanProperty(com.dt.platform.domain.oa.NetdiskFile.class ,VERSION, java.lang.Integer.class, "版本", "版本", java.lang.Integer.class, null);
	
	/**
	 * 创建人ID , 类型: java.lang.String
	*/
	public static final String CREATE_BY="createBy";
	
	/**
	 * 创建人ID , 类型: java.lang.String
	*/
	public static final BeanProperty<com.dt.platform.domain.oa.NetdiskFile,java.lang.String> CREATE_BY_PROP = new BeanProperty(com.dt.platform.domain.oa.NetdiskFile.class ,CREATE_BY, java.lang.String.class, "创建人ID", "创建人ID", java.lang.String.class, null);
	
	/**
	 * 创建时间 , 类型: java.util.Date
	*/
	public static final String CREATE_TIME="createTime";
	
	/**
	 * 创建时间 , 类型: java.util.Date
	*/
	public static final BeanProperty<com.dt.platform.domain.oa.NetdiskFile,java.util.Date> CREATE_TIME_PROP = new BeanProperty(com.dt.platform.domain.oa.NetdiskFile.class ,CREATE_TIME, java.util.Date.class, "创建时间", "创建时间", java.util.Date.class, null);
	
	/**
	 * 修改人ID , 类型: java.lang.String
	*/
	public static final String UPDATE_BY="updateBy";
	
	/**
	 * 修改人ID , 类型: java.lang.String
	*/
	public static final BeanProperty<com.dt.platform.domain.oa.NetdiskFile,java.lang.String> UPDATE_BY_PROP = new BeanProperty(com.dt.platform.domain.oa.NetdiskFile.class ,UPDATE_BY, java.lang.String.class, "修改人ID", "修改人ID", java.lang.String.class, null);
	
	/**
	 * 修改时间 , 类型: java.util.Date
	*/
	public static final String UPDATE_TIME="updateTime";
	
	/**
	 * 修改时间 , 类型: java.util.Date
	*/
	public static final BeanProperty<com.dt.platform.domain.oa.NetdiskFile,java.util.Date> UPDATE_TIME_PROP = new BeanProperty(com.dt.platform.domain.oa.NetdiskFile.class ,UPDATE_TIME, java.util.Date.class, "修改时间", "修改时间", java.util.Date.class, null);
	
	/**
	 * 是否已删除 , 类型: java.lang.Integer
	*/
	public static final String DELETED="deleted";
	
	/**
	 * 是否已删除 , 类型: java.lang.Integer
	*/
	public static final BeanProperty<com.dt.platform.domain.oa.NetdiskFile,java.lang.Integer> DELETED_PROP = new BeanProperty(com.dt.platform.domain.oa.NetdiskFile.class ,DELETED, java.lang.Integer.class, "是否已删除", "是否已删除", java.lang.Integer.class, null);
	
	/**
	 * 删除人ID , 类型: java.lang.String
	*/
	public static final String DELETE_BY="deleteBy";
	
	/**
	 * 删除人ID , 类型: java.lang.String
	*/
	public static final BeanProperty<com.dt.platform.domain.oa.NetdiskFile,java.lang.String> DELETE_BY_PROP = new BeanProperty(com.dt.platform.domain.oa.NetdiskFile.class ,DELETE_BY, java.lang.String.class, "删除人ID", "删除人ID", java.lang.String.class, null);
	
	/**
	 * 删除时间 , 类型: java.util.Date
	*/
	public static final String DELETE_TIME="deleteTime";
	
	/**
	 * 删除时间 , 类型: java.util.Date
	*/
	public static final BeanProperty<com.dt.platform.domain.oa.NetdiskFile,java.util.Date> DELETE_TIME_PROP = new BeanProperty(com.dt.platform.domain.oa.NetdiskFile.class ,DELETE_TIME, java.util.Date.class, "删除时间", "删除时间", java.util.Date.class, null);
	
	/**
	 * netdiskOriginFile , 类型: com.dt.platform.domain.oa.NetdiskOriginFile
	*/
	public static final String NETDISK_ORIGIN_FILE="netdiskOriginFile";
	
	/**
	 * netdiskOriginFile , 类型: com.dt.platform.domain.oa.NetdiskOriginFile
	*/
	public static final BeanProperty<com.dt.platform.domain.oa.NetdiskFile,com.dt.platform.domain.oa.NetdiskOriginFile> NETDISK_ORIGIN_FILE_PROP = new BeanProperty(com.dt.platform.domain.oa.NetdiskFile.class ,NETDISK_ORIGIN_FILE, com.dt.platform.domain.oa.NetdiskOriginFile.class, "netdiskOriginFile", "netdiskOriginFile", com.dt.platform.domain.oa.NetdiskOriginFile.class, null);
	
	/**
	 * netdiskFolder , 类型: com.dt.platform.domain.oa.NetdiskFolder
	*/
	public static final String NETDISK_FOLDER="netdiskFolder";
	
	/**
	 * netdiskFolder , 类型: com.dt.platform.domain.oa.NetdiskFolder
	*/
	public static final BeanProperty<com.dt.platform.domain.oa.NetdiskFile,com.dt.platform.domain.oa.NetdiskFolder> NETDISK_FOLDER_PROP = new BeanProperty(com.dt.platform.domain.oa.NetdiskFile.class ,NETDISK_FOLDER, com.dt.platform.domain.oa.NetdiskFolder.class, "netdiskFolder", "netdiskFolder", com.dt.platform.domain.oa.NetdiskFolder.class, null);
	
	/**
	 * ownerUser , 类型: org.github.foxnic.web.domain.hrm.Employee
	*/
	public static final String OWNER_USER="ownerUser";
	
	/**
	 * ownerUser , 类型: org.github.foxnic.web.domain.hrm.Employee
	*/
	public static final BeanProperty<com.dt.platform.domain.oa.NetdiskFile,org.github.foxnic.web.domain.hrm.Employee> OWNER_USER_PROP = new BeanProperty(com.dt.platform.domain.oa.NetdiskFile.class ,OWNER_USER, org.github.foxnic.web.domain.hrm.Employee.class, "ownerUser", "ownerUser", org.github.foxnic.web.domain.hrm.Employee.class, null);
	
	/**
	 * 全部属性清单
	*/
	public static final String[] $PROPS={ ID , ORIGIN_FILE_ID , FILE_NAME , FILE_SIZE , FILE_TYPE , IS_FAVOURITE , IN_RECYCLE , USER_ID , FOLDER_ID , VERSION , CREATE_BY , CREATE_TIME , UPDATE_BY , UPDATE_TIME , DELETED , DELETE_BY , DELETE_TIME , NETDISK_ORIGIN_FILE , NETDISK_FOLDER , OWNER_USER };
	
	/**
	 * 代理类
	*/
	public static class $$proxy$$ extends com.dt.platform.domain.oa.NetdiskFile {

		private static final long serialVersionUID = 1L;

		
		/**
		 * 设置 主键
		 * @param id 主键
		 * @return 当前对象
		*/
		public NetdiskFile setId(String id) {
			super.change(ID,super.getId(),id);
			super.setId(id);
			return this;
		}
		
		/**
		 * 设置 文件
		 * @param originFileId 文件
		 * @return 当前对象
		*/
		public NetdiskFile setOriginFileId(String originFileId) {
			super.change(ORIGIN_FILE_ID,super.getOriginFileId(),originFileId);
			super.setOriginFileId(originFileId);
			return this;
		}
		
		/**
		 * 设置 名称
		 * @param fileName 名称
		 * @return 当前对象
		*/
		public NetdiskFile setFileName(String fileName) {
			super.change(FILE_NAME,super.getFileName(),fileName);
			super.setFileName(fileName);
			return this;
		}
		
		/**
		 * 设置 大小
		 * @param fileSize 大小
		 * @return 当前对象
		*/
		public NetdiskFile setFileSize(String fileSize) {
			super.change(FILE_SIZE,super.getFileSize(),fileSize);
			super.setFileSize(fileSize);
			return this;
		}
		
		/**
		 * 设置 类型
		 * @param fileType 类型
		 * @return 当前对象
		*/
		public NetdiskFile setFileType(String fileType) {
			super.change(FILE_TYPE,super.getFileType(),fileType);
			super.setFileType(fileType);
			return this;
		}
		
		/**
		 * 设置 是否收藏
		 * @param isFavourite 是否收藏
		 * @return 当前对象
		*/
		public NetdiskFile setIsFavourite(String isFavourite) {
			super.change(IS_FAVOURITE,super.getIsFavourite(),isFavourite);
			super.setIsFavourite(isFavourite);
			return this;
		}
		
		/**
		 * 设置 回收站
		 * @param inRecycle 回收站
		 * @return 当前对象
		*/
		public NetdiskFile setInRecycle(String inRecycle) {
			super.change(IN_RECYCLE,super.getInRecycle(),inRecycle);
			super.setInRecycle(inRecycle);
			return this;
		}
		
		/**
		 * 设置 用户
		 * @param userId 用户
		 * @return 当前对象
		*/
		public NetdiskFile setUserId(String userId) {
			super.change(USER_ID,super.getUserId(),userId);
			super.setUserId(userId);
			return this;
		}
		
		/**
		 * 设置 文件夹
		 * @param folderId 文件夹
		 * @return 当前对象
		*/
		public NetdiskFile setFolderId(String folderId) {
			super.change(FOLDER_ID,super.getFolderId(),folderId);
			super.setFolderId(folderId);
			return this;
		}
		
		/**
		 * 设置 版本
		 * @param version 版本
		 * @return 当前对象
		*/
		public NetdiskFile setVersion(Integer version) {
			super.change(VERSION,super.getVersion(),version);
			super.setVersion(version);
			return this;
		}
		
		/**
		 * 设置 创建人ID
		 * @param createBy 创建人ID
		 * @return 当前对象
		*/
		public NetdiskFile setCreateBy(String createBy) {
			super.change(CREATE_BY,super.getCreateBy(),createBy);
			super.setCreateBy(createBy);
			return this;
		}
		
		/**
		 * 设置 创建时间
		 * @param createTime 创建时间
		 * @return 当前对象
		*/
		public NetdiskFile setCreateTime(Date createTime) {
			super.change(CREATE_TIME,super.getCreateTime(),createTime);
			super.setCreateTime(createTime);
			return this;
		}
		
		/**
		 * 设置 修改人ID
		 * @param updateBy 修改人ID
		 * @return 当前对象
		*/
		public NetdiskFile setUpdateBy(String updateBy) {
			super.change(UPDATE_BY,super.getUpdateBy(),updateBy);
			super.setUpdateBy(updateBy);
			return this;
		}
		
		/**
		 * 设置 修改时间
		 * @param updateTime 修改时间
		 * @return 当前对象
		*/
		public NetdiskFile setUpdateTime(Date updateTime) {
			super.change(UPDATE_TIME,super.getUpdateTime(),updateTime);
			super.setUpdateTime(updateTime);
			return this;
		}
		
		/**
		 * 设置 是否已删除
		 * @param deleted 是否已删除
		 * @return 当前对象
		*/
		public NetdiskFile setDeleted(Integer deleted) {
			super.change(DELETED,super.getDeleted(),deleted);
			super.setDeleted(deleted);
			return this;
		}
		
		/**
		 * 设置 删除人ID
		 * @param deleteBy 删除人ID
		 * @return 当前对象
		*/
		public NetdiskFile setDeleteBy(String deleteBy) {
			super.change(DELETE_BY,super.getDeleteBy(),deleteBy);
			super.setDeleteBy(deleteBy);
			return this;
		}
		
		/**
		 * 设置 删除时间
		 * @param deleteTime 删除时间
		 * @return 当前对象
		*/
		public NetdiskFile setDeleteTime(Date deleteTime) {
			super.change(DELETE_TIME,super.getDeleteTime(),deleteTime);
			super.setDeleteTime(deleteTime);
			return this;
		}
		
		/**
		 * 设置 netdiskOriginFile
		 * @param netdiskOriginFile netdiskOriginFile
		 * @return 当前对象
		*/
		public NetdiskFile setNetdiskOriginFile(NetdiskOriginFile netdiskOriginFile) {
			super.change(NETDISK_ORIGIN_FILE,super.getNetdiskOriginFile(),netdiskOriginFile);
			super.setNetdiskOriginFile(netdiskOriginFile);
			return this;
		}
		
		/**
		 * 设置 netdiskFolder
		 * @param netdiskFolder netdiskFolder
		 * @return 当前对象
		*/
		public NetdiskFile setNetdiskFolder(NetdiskFolder netdiskFolder) {
			super.change(NETDISK_FOLDER,super.getNetdiskFolder(),netdiskFolder);
			super.setNetdiskFolder(netdiskFolder);
			return this;
		}
		
		/**
		 * 设置 ownerUser
		 * @param ownerUser ownerUser
		 * @return 当前对象
		*/
		public NetdiskFile setOwnerUser(Employee ownerUser) {
			super.change(OWNER_USER,super.getOwnerUser(),ownerUser);
			super.setOwnerUser(ownerUser);
			return this;
		}

		/**
		 * 克隆当前对象
		*/
		@Transient
		public NetdiskFile clone() {
			return duplicate(true);
		}

		/**
		 * 复制当前对象
		 * @param all 是否复制全部属性，当 false 时，仅复制来自数据表的属性
		*/
		@Transient
		public NetdiskFile duplicate(boolean all) {
			$$proxy$$ inst=new $$proxy$$();
			inst.setOriginFileId(this.getOriginFileId());
			inst.setFileName(this.getFileName());
			inst.setUpdateTime(this.getUpdateTime());
			inst.setUserId(this.getUserId());
			inst.setVersion(this.getVersion());
			inst.setFolderId(this.getFolderId());
			inst.setCreateBy(this.getCreateBy());
			inst.setDeleted(this.getDeleted());
			inst.setFileSize(this.getFileSize());
			inst.setCreateTime(this.getCreateTime());
			inst.setUpdateBy(this.getUpdateBy());
			inst.setDeleteTime(this.getDeleteTime());
			inst.setInRecycle(this.getInRecycle());
			inst.setDeleteBy(this.getDeleteBy());
			inst.setId(this.getId());
			inst.setIsFavourite(this.getIsFavourite());
			inst.setFileType(this.getFileType());
			if(all) {
				inst.setNetdiskFolder(this.getNetdiskFolder());
				inst.setOwnerUser(this.getOwnerUser());
				inst.setNetdiskOriginFile(this.getNetdiskOriginFile());
			}
			inst.clearModifies();
			return inst;
		}

	}
}