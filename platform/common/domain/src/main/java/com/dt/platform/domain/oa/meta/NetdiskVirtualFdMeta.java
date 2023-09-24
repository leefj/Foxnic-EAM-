package com.dt.platform.domain.oa.meta;

import com.github.foxnic.api.bean.BeanProperty;
import com.dt.platform.domain.oa.NetdiskVirtualFd;
import java.util.Date;
import com.dt.platform.domain.oa.NetdiskFile;
import com.dt.platform.domain.oa.NetdiskOriginFile;
import org.github.foxnic.web.domain.hrm.Employee;
import javax.persistence.Transient;



/**
 * @author 金杰 , maillank@qq.com
 * @since 2023-09-22 21:55:06
 * @sign 88C139F935CFF0FF364A97D55FB5F38E
 * 此文件由工具自动生成，请勿修改。若表结构或配置发生变动，请使用工具重新生成。
*/

public class NetdiskVirtualFdMeta {
	
	/**
	 * 主键 , 类型: java.lang.String
	*/
	public static final String ID="id";
	
	/**
	 * 主键 , 类型: java.lang.String
	*/
	public static final BeanProperty<com.dt.platform.domain.oa.NetdiskVirtualFd,java.lang.String> ID_PROP = new BeanProperty(com.dt.platform.domain.oa.NetdiskVirtualFd.class ,ID, java.lang.String.class, "主键", "主键", java.lang.String.class, null);
	
	/**
	 * 文件 , 类型: java.lang.String
	*/
	public static final String FD_ID="fdId";
	
	/**
	 * 文件 , 类型: java.lang.String
	*/
	public static final BeanProperty<com.dt.platform.domain.oa.NetdiskVirtualFd,java.lang.String> FD_ID_PROP = new BeanProperty(com.dt.platform.domain.oa.NetdiskVirtualFd.class ,FD_ID, java.lang.String.class, "文件", "文件", java.lang.String.class, null);
	
	/**
	 * 名称 , 类型: java.lang.String
	*/
	public static final String FD_NAME="fdName";
	
	/**
	 * 名称 , 类型: java.lang.String
	*/
	public static final BeanProperty<com.dt.platform.domain.oa.NetdiskVirtualFd,java.lang.String> FD_NAME_PROP = new BeanProperty(com.dt.platform.domain.oa.NetdiskVirtualFd.class ,FD_NAME, java.lang.String.class, "名称", "名称", java.lang.String.class, null);
	
	/**
	 * 大小 , 类型: java.lang.String
	*/
	public static final String FD_SIZE="fdSize";
	
	/**
	 * 大小 , 类型: java.lang.String
	*/
	public static final BeanProperty<com.dt.platform.domain.oa.NetdiskVirtualFd,java.lang.String> FD_SIZE_PROP = new BeanProperty(com.dt.platform.domain.oa.NetdiskVirtualFd.class ,FD_SIZE, java.lang.String.class, "大小", "大小", java.lang.String.class, null);
	
	/**
	 * 文件类型 , 类型: java.lang.String
	*/
	public static final String FD_FILE_TYPE="fdFileType";
	
	/**
	 * 文件类型 , 类型: java.lang.String
	*/
	public static final BeanProperty<com.dt.platform.domain.oa.NetdiskVirtualFd,java.lang.String> FD_FILE_TYPE_PROP = new BeanProperty(com.dt.platform.domain.oa.NetdiskVirtualFd.class ,FD_FILE_TYPE, java.lang.String.class, "文件类型", "文件类型", java.lang.String.class, null);
	
	/**
	 * 路径编号 , 类型: java.lang.String
	*/
	public static final String FD_HIERARCHY="fdHierarchy";
	
	/**
	 * 路径编号 , 类型: java.lang.String
	*/
	public static final BeanProperty<com.dt.platform.domain.oa.NetdiskVirtualFd,java.lang.String> FD_HIERARCHY_PROP = new BeanProperty(com.dt.platform.domain.oa.NetdiskVirtualFd.class ,FD_HIERARCHY, java.lang.String.class, "路径编号", "路径编号", java.lang.String.class, null);
	
	/**
	 * 路径名称 , 类型: java.lang.String
	*/
	public static final String FD_HIERARCHY_NAME="fdHierarchyName";
	
	/**
	 * 路径名称 , 类型: java.lang.String
	*/
	public static final BeanProperty<com.dt.platform.domain.oa.NetdiskVirtualFd,java.lang.String> FD_HIERARCHY_NAME_PROP = new BeanProperty(com.dt.platform.domain.oa.NetdiskVirtualFd.class ,FD_HIERARCHY_NAME, java.lang.String.class, "路径名称", "路径名称", java.lang.String.class, null);
	
	/**
	 * 是否收藏 , 类型: java.lang.String
	*/
	public static final String IS_FAVOURITE="isFavourite";
	
	/**
	 * 是否收藏 , 类型: java.lang.String
	*/
	public static final BeanProperty<com.dt.platform.domain.oa.NetdiskVirtualFd,java.lang.String> IS_FAVOURITE_PROP = new BeanProperty(com.dt.platform.domain.oa.NetdiskVirtualFd.class ,IS_FAVOURITE, java.lang.String.class, "是否收藏", "是否收藏", java.lang.String.class, null);
	
	/**
	 * 文件夹 , 类型: java.lang.String
	*/
	public static final String FOLDER_ID="folderId";
	
	/**
	 * 文件夹 , 类型: java.lang.String
	*/
	public static final BeanProperty<com.dt.platform.domain.oa.NetdiskVirtualFd,java.lang.String> FOLDER_ID_PROP = new BeanProperty(com.dt.platform.domain.oa.NetdiskVirtualFd.class ,FOLDER_ID, java.lang.String.class, "文件夹", "文件夹", java.lang.String.class, null);
	
	/**
	 * fd类型 , 类型: java.lang.String
	*/
	public static final String FD_TYPE="fdType";
	
	/**
	 * fd类型 , 类型: java.lang.String
	*/
	public static final BeanProperty<com.dt.platform.domain.oa.NetdiskVirtualFd,java.lang.String> FD_TYPE_PROP = new BeanProperty(com.dt.platform.domain.oa.NetdiskVirtualFd.class ,FD_TYPE, java.lang.String.class, "fd类型", "fd类型", java.lang.String.class, null);
	
	/**
	 * 用户 , 类型: java.lang.String
	*/
	public static final String USER_ID="userId";
	
	/**
	 * 用户 , 类型: java.lang.String
	*/
	public static final BeanProperty<com.dt.platform.domain.oa.NetdiskVirtualFd,java.lang.String> USER_ID_PROP = new BeanProperty(com.dt.platform.domain.oa.NetdiskVirtualFd.class ,USER_ID, java.lang.String.class, "用户", "用户", java.lang.String.class, null);
	
	/**
	 * 父节点 , 类型: java.lang.String
	*/
	public static final String PARENT_ID="parentId";
	
	/**
	 * 父节点 , 类型: java.lang.String
	*/
	public static final BeanProperty<com.dt.platform.domain.oa.NetdiskVirtualFd,java.lang.String> PARENT_ID_PROP = new BeanProperty(com.dt.platform.domain.oa.NetdiskVirtualFd.class ,PARENT_ID, java.lang.String.class, "父节点", "父节点", java.lang.String.class, null);
	
	/**
	 * 版本 , 类型: java.lang.Integer
	*/
	public static final String VERSION="version";
	
	/**
	 * 版本 , 类型: java.lang.Integer
	*/
	public static final BeanProperty<com.dt.platform.domain.oa.NetdiskVirtualFd,java.lang.Integer> VERSION_PROP = new BeanProperty(com.dt.platform.domain.oa.NetdiskVirtualFd.class ,VERSION, java.lang.Integer.class, "版本", "版本", java.lang.Integer.class, null);
	
	/**
	 * 创建人ID , 类型: java.lang.String
	*/
	public static final String CREATE_BY="createBy";
	
	/**
	 * 创建人ID , 类型: java.lang.String
	*/
	public static final BeanProperty<com.dt.platform.domain.oa.NetdiskVirtualFd,java.lang.String> CREATE_BY_PROP = new BeanProperty(com.dt.platform.domain.oa.NetdiskVirtualFd.class ,CREATE_BY, java.lang.String.class, "创建人ID", "创建人ID", java.lang.String.class, null);
	
	/**
	 * 创建时间 , 类型: java.util.Date
	*/
	public static final String CREATE_TIME="createTime";
	
	/**
	 * 创建时间 , 类型: java.util.Date
	*/
	public static final BeanProperty<com.dt.platform.domain.oa.NetdiskVirtualFd,java.util.Date> CREATE_TIME_PROP = new BeanProperty(com.dt.platform.domain.oa.NetdiskVirtualFd.class ,CREATE_TIME, java.util.Date.class, "创建时间", "创建时间", java.util.Date.class, null);
	
	/**
	 * 修改人ID , 类型: java.lang.String
	*/
	public static final String UPDATE_BY="updateBy";
	
	/**
	 * 修改人ID , 类型: java.lang.String
	*/
	public static final BeanProperty<com.dt.platform.domain.oa.NetdiskVirtualFd,java.lang.String> UPDATE_BY_PROP = new BeanProperty(com.dt.platform.domain.oa.NetdiskVirtualFd.class ,UPDATE_BY, java.lang.String.class, "修改人ID", "修改人ID", java.lang.String.class, null);
	
	/**
	 * 修改时间 , 类型: java.util.Date
	*/
	public static final String UPDATE_TIME="updateTime";
	
	/**
	 * 修改时间 , 类型: java.util.Date
	*/
	public static final BeanProperty<com.dt.platform.domain.oa.NetdiskVirtualFd,java.util.Date> UPDATE_TIME_PROP = new BeanProperty(com.dt.platform.domain.oa.NetdiskVirtualFd.class ,UPDATE_TIME, java.util.Date.class, "修改时间", "修改时间", java.util.Date.class, null);
	
	/**
	 * 是否已删除 , 类型: java.lang.Integer
	*/
	public static final String DELETED="deleted";
	
	/**
	 * 是否已删除 , 类型: java.lang.Integer
	*/
	public static final BeanProperty<com.dt.platform.domain.oa.NetdiskVirtualFd,java.lang.Integer> DELETED_PROP = new BeanProperty(com.dt.platform.domain.oa.NetdiskVirtualFd.class ,DELETED, java.lang.Integer.class, "是否已删除", "是否已删除", java.lang.Integer.class, null);
	
	/**
	 * 删除人ID , 类型: java.lang.String
	*/
	public static final String DELETE_BY="deleteBy";
	
	/**
	 * 删除人ID , 类型: java.lang.String
	*/
	public static final BeanProperty<com.dt.platform.domain.oa.NetdiskVirtualFd,java.lang.String> DELETE_BY_PROP = new BeanProperty(com.dt.platform.domain.oa.NetdiskVirtualFd.class ,DELETE_BY, java.lang.String.class, "删除人ID", "删除人ID", java.lang.String.class, null);
	
	/**
	 * 删除时间 , 类型: java.util.Date
	*/
	public static final String DELETE_TIME="deleteTime";
	
	/**
	 * 删除时间 , 类型: java.util.Date
	*/
	public static final BeanProperty<com.dt.platform.domain.oa.NetdiskVirtualFd,java.util.Date> DELETE_TIME_PROP = new BeanProperty(com.dt.platform.domain.oa.NetdiskVirtualFd.class ,DELETE_TIME, java.util.Date.class, "删除时间", "删除时间", java.util.Date.class, null);
	
	/**
	 * netdiskFile , 类型: com.dt.platform.domain.oa.NetdiskFile
	*/
	public static final String NETDISK_FILE="netdiskFile";
	
	/**
	 * netdiskFile , 类型: com.dt.platform.domain.oa.NetdiskFile
	*/
	public static final BeanProperty<com.dt.platform.domain.oa.NetdiskVirtualFd,com.dt.platform.domain.oa.NetdiskFile> NETDISK_FILE_PROP = new BeanProperty(com.dt.platform.domain.oa.NetdiskVirtualFd.class ,NETDISK_FILE, com.dt.platform.domain.oa.NetdiskFile.class, "netdiskFile", "netdiskFile", com.dt.platform.domain.oa.NetdiskFile.class, null);
	
	/**
	 * netdiskOriginFile , 类型: com.dt.platform.domain.oa.NetdiskOriginFile
	*/
	public static final String NETDISK_ORIGIN_FILE="netdiskOriginFile";
	
	/**
	 * netdiskOriginFile , 类型: com.dt.platform.domain.oa.NetdiskOriginFile
	*/
	public static final BeanProperty<com.dt.platform.domain.oa.NetdiskVirtualFd,com.dt.platform.domain.oa.NetdiskOriginFile> NETDISK_ORIGIN_FILE_PROP = new BeanProperty(com.dt.platform.domain.oa.NetdiskVirtualFd.class ,NETDISK_ORIGIN_FILE, com.dt.platform.domain.oa.NetdiskOriginFile.class, "netdiskOriginFile", "netdiskOriginFile", com.dt.platform.domain.oa.NetdiskOriginFile.class, null);
	
	/**
	 * searchFolderId , 类型: java.lang.String
	*/
	public static final String SEARCH_FOLDER_ID="searchFolderId";
	
	/**
	 * searchFolderId , 类型: java.lang.String
	*/
	public static final BeanProperty<com.dt.platform.domain.oa.NetdiskVirtualFd,java.lang.String> SEARCH_FOLDER_ID_PROP = new BeanProperty(com.dt.platform.domain.oa.NetdiskVirtualFd.class ,SEARCH_FOLDER_ID, java.lang.String.class, "searchFolderId", "searchFolderId", java.lang.String.class, null);
	
	/**
	 * searchFavourite , 类型: java.lang.String
	*/
	public static final String SEARCH_FAVOURITE="searchFavourite";
	
	/**
	 * searchFavourite , 类型: java.lang.String
	*/
	public static final BeanProperty<com.dt.platform.domain.oa.NetdiskVirtualFd,java.lang.String> SEARCH_FAVOURITE_PROP = new BeanProperty(com.dt.platform.domain.oa.NetdiskVirtualFd.class ,SEARCH_FAVOURITE, java.lang.String.class, "searchFavourite", "searchFavourite", java.lang.String.class, null);
	
	/**
	 * searchRecycle , 类型: java.lang.String
	*/
	public static final String SEARCH_RECYCLE="searchRecycle";
	
	/**
	 * searchRecycle , 类型: java.lang.String
	*/
	public static final BeanProperty<com.dt.platform.domain.oa.NetdiskVirtualFd,java.lang.String> SEARCH_RECYCLE_PROP = new BeanProperty(com.dt.platform.domain.oa.NetdiskVirtualFd.class ,SEARCH_RECYCLE, java.lang.String.class, "searchRecycle", "searchRecycle", java.lang.String.class, null);
	
	/**
	 * searchFileType , 类型: java.lang.String
	*/
	public static final String SEARCH_FILE_TYPE="searchFileType";
	
	/**
	 * searchFileType , 类型: java.lang.String
	*/
	public static final BeanProperty<com.dt.platform.domain.oa.NetdiskVirtualFd,java.lang.String> SEARCH_FILE_TYPE_PROP = new BeanProperty(com.dt.platform.domain.oa.NetdiskVirtualFd.class ,SEARCH_FILE_TYPE, java.lang.String.class, "searchFileType", "searchFileType", java.lang.String.class, null);
	
	/**
	 * ownerUser , 类型: org.github.foxnic.web.domain.hrm.Employee
	*/
	public static final String OWNER_USER="ownerUser";
	
	/**
	 * ownerUser , 类型: org.github.foxnic.web.domain.hrm.Employee
	*/
	public static final BeanProperty<com.dt.platform.domain.oa.NetdiskVirtualFd,org.github.foxnic.web.domain.hrm.Employee> OWNER_USER_PROP = new BeanProperty(com.dt.platform.domain.oa.NetdiskVirtualFd.class ,OWNER_USER, org.github.foxnic.web.domain.hrm.Employee.class, "ownerUser", "ownerUser", org.github.foxnic.web.domain.hrm.Employee.class, null);
	
	/**
	 * 全部属性清单
	*/
	public static final String[] $PROPS={ ID , FD_ID , FD_NAME , FD_SIZE , FD_FILE_TYPE , FD_HIERARCHY , FD_HIERARCHY_NAME , IS_FAVOURITE , FOLDER_ID , FD_TYPE , USER_ID , PARENT_ID , VERSION , CREATE_BY , CREATE_TIME , UPDATE_BY , UPDATE_TIME , DELETED , DELETE_BY , DELETE_TIME , NETDISK_FILE , NETDISK_ORIGIN_FILE , SEARCH_FOLDER_ID , SEARCH_FAVOURITE , SEARCH_RECYCLE , SEARCH_FILE_TYPE , OWNER_USER };
	
	/**
	 * 代理类
	*/
	public static class $$proxy$$ extends com.dt.platform.domain.oa.NetdiskVirtualFd {

		private static final long serialVersionUID = 1L;

		
		/**
		 * 设置 主键
		 * @param id 主键
		 * @return 当前对象
		*/
		public NetdiskVirtualFd setId(String id) {
			super.change(ID,super.getId(),id);
			super.setId(id);
			return this;
		}
		
		/**
		 * 设置 文件
		 * @param fdId 文件
		 * @return 当前对象
		*/
		public NetdiskVirtualFd setFdId(String fdId) {
			super.change(FD_ID,super.getFdId(),fdId);
			super.setFdId(fdId);
			return this;
		}
		
		/**
		 * 设置 名称
		 * @param fdName 名称
		 * @return 当前对象
		*/
		public NetdiskVirtualFd setFdName(String fdName) {
			super.change(FD_NAME,super.getFdName(),fdName);
			super.setFdName(fdName);
			return this;
		}
		
		/**
		 * 设置 大小
		 * @param fdSize 大小
		 * @return 当前对象
		*/
		public NetdiskVirtualFd setFdSize(String fdSize) {
			super.change(FD_SIZE,super.getFdSize(),fdSize);
			super.setFdSize(fdSize);
			return this;
		}
		
		/**
		 * 设置 文件类型
		 * @param fdFileType 文件类型
		 * @return 当前对象
		*/
		public NetdiskVirtualFd setFdFileType(String fdFileType) {
			super.change(FD_FILE_TYPE,super.getFdFileType(),fdFileType);
			super.setFdFileType(fdFileType);
			return this;
		}
		
		/**
		 * 设置 路径编号
		 * @param fdHierarchy 路径编号
		 * @return 当前对象
		*/
		public NetdiskVirtualFd setFdHierarchy(String fdHierarchy) {
			super.change(FD_HIERARCHY,super.getFdHierarchy(),fdHierarchy);
			super.setFdHierarchy(fdHierarchy);
			return this;
		}
		
		/**
		 * 设置 路径名称
		 * @param fdHierarchyName 路径名称
		 * @return 当前对象
		*/
		public NetdiskVirtualFd setFdHierarchyName(String fdHierarchyName) {
			super.change(FD_HIERARCHY_NAME,super.getFdHierarchyName(),fdHierarchyName);
			super.setFdHierarchyName(fdHierarchyName);
			return this;
		}
		
		/**
		 * 设置 是否收藏
		 * @param isFavourite 是否收藏
		 * @return 当前对象
		*/
		public NetdiskVirtualFd setIsFavourite(String isFavourite) {
			super.change(IS_FAVOURITE,super.getIsFavourite(),isFavourite);
			super.setIsFavourite(isFavourite);
			return this;
		}
		
		/**
		 * 设置 文件夹
		 * @param folderId 文件夹
		 * @return 当前对象
		*/
		public NetdiskVirtualFd setFolderId(String folderId) {
			super.change(FOLDER_ID,super.getFolderId(),folderId);
			super.setFolderId(folderId);
			return this;
		}
		
		/**
		 * 设置 fd类型
		 * @param fdType fd类型
		 * @return 当前对象
		*/
		public NetdiskVirtualFd setFdType(String fdType) {
			super.change(FD_TYPE,super.getFdType(),fdType);
			super.setFdType(fdType);
			return this;
		}
		
		/**
		 * 设置 用户
		 * @param userId 用户
		 * @return 当前对象
		*/
		public NetdiskVirtualFd setUserId(String userId) {
			super.change(USER_ID,super.getUserId(),userId);
			super.setUserId(userId);
			return this;
		}
		
		/**
		 * 设置 父节点
		 * @param parentId 父节点
		 * @return 当前对象
		*/
		public NetdiskVirtualFd setParentId(String parentId) {
			super.change(PARENT_ID,super.getParentId(),parentId);
			super.setParentId(parentId);
			return this;
		}
		
		/**
		 * 设置 版本
		 * @param version 版本
		 * @return 当前对象
		*/
		public NetdiskVirtualFd setVersion(Integer version) {
			super.change(VERSION,super.getVersion(),version);
			super.setVersion(version);
			return this;
		}
		
		/**
		 * 设置 创建人ID
		 * @param createBy 创建人ID
		 * @return 当前对象
		*/
		public NetdiskVirtualFd setCreateBy(String createBy) {
			super.change(CREATE_BY,super.getCreateBy(),createBy);
			super.setCreateBy(createBy);
			return this;
		}
		
		/**
		 * 设置 创建时间
		 * @param createTime 创建时间
		 * @return 当前对象
		*/
		public NetdiskVirtualFd setCreateTime(Date createTime) {
			super.change(CREATE_TIME,super.getCreateTime(),createTime);
			super.setCreateTime(createTime);
			return this;
		}
		
		/**
		 * 设置 修改人ID
		 * @param updateBy 修改人ID
		 * @return 当前对象
		*/
		public NetdiskVirtualFd setUpdateBy(String updateBy) {
			super.change(UPDATE_BY,super.getUpdateBy(),updateBy);
			super.setUpdateBy(updateBy);
			return this;
		}
		
		/**
		 * 设置 修改时间
		 * @param updateTime 修改时间
		 * @return 当前对象
		*/
		public NetdiskVirtualFd setUpdateTime(Date updateTime) {
			super.change(UPDATE_TIME,super.getUpdateTime(),updateTime);
			super.setUpdateTime(updateTime);
			return this;
		}
		
		/**
		 * 设置 是否已删除
		 * @param deleted 是否已删除
		 * @return 当前对象
		*/
		public NetdiskVirtualFd setDeleted(Integer deleted) {
			super.change(DELETED,super.getDeleted(),deleted);
			super.setDeleted(deleted);
			return this;
		}
		
		/**
		 * 设置 删除人ID
		 * @param deleteBy 删除人ID
		 * @return 当前对象
		*/
		public NetdiskVirtualFd setDeleteBy(String deleteBy) {
			super.change(DELETE_BY,super.getDeleteBy(),deleteBy);
			super.setDeleteBy(deleteBy);
			return this;
		}
		
		/**
		 * 设置 删除时间
		 * @param deleteTime 删除时间
		 * @return 当前对象
		*/
		public NetdiskVirtualFd setDeleteTime(Date deleteTime) {
			super.change(DELETE_TIME,super.getDeleteTime(),deleteTime);
			super.setDeleteTime(deleteTime);
			return this;
		}
		
		/**
		 * 设置 netdiskFile
		 * @param netdiskFile netdiskFile
		 * @return 当前对象
		*/
		public NetdiskVirtualFd setNetdiskFile(NetdiskFile netdiskFile) {
			super.change(NETDISK_FILE,super.getNetdiskFile(),netdiskFile);
			super.setNetdiskFile(netdiskFile);
			return this;
		}
		
		/**
		 * 设置 netdiskOriginFile
		 * @param netdiskOriginFile netdiskOriginFile
		 * @return 当前对象
		*/
		public NetdiskVirtualFd setNetdiskOriginFile(NetdiskOriginFile netdiskOriginFile) {
			super.change(NETDISK_ORIGIN_FILE,super.getNetdiskOriginFile(),netdiskOriginFile);
			super.setNetdiskOriginFile(netdiskOriginFile);
			return this;
		}
		
		/**
		 * 设置 searchFolderId
		 * @param searchFolderId searchFolderId
		 * @return 当前对象
		*/
		public NetdiskVirtualFd setSearchFolderId(String searchFolderId) {
			super.change(SEARCH_FOLDER_ID,super.getSearchFolderId(),searchFolderId);
			super.setSearchFolderId(searchFolderId);
			return this;
		}
		
		/**
		 * 设置 searchFavourite
		 * @param searchFavourite searchFavourite
		 * @return 当前对象
		*/
		public NetdiskVirtualFd setSearchFavourite(String searchFavourite) {
			super.change(SEARCH_FAVOURITE,super.getSearchFavourite(),searchFavourite);
			super.setSearchFavourite(searchFavourite);
			return this;
		}
		
		/**
		 * 设置 searchRecycle
		 * @param searchRecycle searchRecycle
		 * @return 当前对象
		*/
		public NetdiskVirtualFd setSearchRecycle(String searchRecycle) {
			super.change(SEARCH_RECYCLE,super.getSearchRecycle(),searchRecycle);
			super.setSearchRecycle(searchRecycle);
			return this;
		}
		
		/**
		 * 设置 searchFileType
		 * @param searchFileType searchFileType
		 * @return 当前对象
		*/
		public NetdiskVirtualFd setSearchFileType(String searchFileType) {
			super.change(SEARCH_FILE_TYPE,super.getSearchFileType(),searchFileType);
			super.setSearchFileType(searchFileType);
			return this;
		}
		
		/**
		 * 设置 ownerUser
		 * @param ownerUser ownerUser
		 * @return 当前对象
		*/
		public NetdiskVirtualFd setOwnerUser(Employee ownerUser) {
			super.change(OWNER_USER,super.getOwnerUser(),ownerUser);
			super.setOwnerUser(ownerUser);
			return this;
		}

		/**
		 * 克隆当前对象
		*/
		@Transient
		public NetdiskVirtualFd clone() {
			return duplicate(true);
		}

		/**
		 * 复制当前对象
		 * @param all 是否复制全部属性，当 false 时，仅复制来自数据表的属性
		*/
		@Transient
		public NetdiskVirtualFd duplicate(boolean all) {
			$$proxy$$ inst=new $$proxy$$();
			inst.setFdHierarchy(this.getFdHierarchy());
			inst.setFdSize(this.getFdSize());
			inst.setUpdateTime(this.getUpdateTime());
			inst.setUserId(this.getUserId());
			inst.setVersion(this.getVersion());
			inst.setFolderId(this.getFolderId());
			inst.setParentId(this.getParentId());
			inst.setFdType(this.getFdType());
			inst.setCreateBy(this.getCreateBy());
			inst.setDeleted(this.getDeleted());
			inst.setFdFileType(this.getFdFileType());
			inst.setFdHierarchyName(this.getFdHierarchyName());
			inst.setCreateTime(this.getCreateTime());
			inst.setUpdateBy(this.getUpdateBy());
			inst.setDeleteTime(this.getDeleteTime());
			inst.setFdId(this.getFdId());
			inst.setDeleteBy(this.getDeleteBy());
			inst.setId(this.getId());
			inst.setFdName(this.getFdName());
			inst.setIsFavourite(this.getIsFavourite());
			if(all) {
				inst.setSearchFavourite(this.getSearchFavourite());
				inst.setNetdiskFile(this.getNetdiskFile());
				inst.setSearchFolderId(this.getSearchFolderId());
				inst.setOwnerUser(this.getOwnerUser());
				inst.setSearchRecycle(this.getSearchRecycle());
				inst.setNetdiskOriginFile(this.getNetdiskOriginFile());
				inst.setSearchFileType(this.getSearchFileType());
			}
			inst.clearModifies();
			return inst;
		}

	}
}