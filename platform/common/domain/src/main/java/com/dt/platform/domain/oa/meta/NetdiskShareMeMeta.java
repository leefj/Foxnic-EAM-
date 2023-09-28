package com.dt.platform.domain.oa.meta;

import com.github.foxnic.api.bean.BeanProperty;
import com.dt.platform.domain.oa.NetdiskShareMe;
import java.util.Date;
import com.dt.platform.domain.oa.NetdiskFile;
import com.dt.platform.domain.oa.NetdiskOriginFile;
import org.github.foxnic.web.domain.hrm.Employee;
import javax.persistence.Transient;



/**
 * @author 金杰 , maillank@qq.com
 * @since 2023-09-28 13:33:04
 * @sign FC5E03EA28BE59C5814B4A11855C0CC4
 * 此文件由工具自动生成，请勿修改。若表结构或配置发生变动，请使用工具重新生成。
*/

public class NetdiskShareMeMeta {
	
	/**
	 * 主键 , 类型: java.lang.String
	*/
	public static final String ID="id";
	
	/**
	 * 主键 , 类型: java.lang.String
	*/
	public static final BeanProperty<com.dt.platform.domain.oa.NetdiskShareMe,java.lang.String> ID_PROP = new BeanProperty(com.dt.platform.domain.oa.NetdiskShareMe.class ,ID, java.lang.String.class, "主键", "主键", java.lang.String.class, null);
	
	/**
	 * 文件 , 类型: java.lang.String
	*/
	public static final String FILE_ID="fileId";
	
	/**
	 * 文件 , 类型: java.lang.String
	*/
	public static final BeanProperty<com.dt.platform.domain.oa.NetdiskShareMe,java.lang.String> FILE_ID_PROP = new BeanProperty(com.dt.platform.domain.oa.NetdiskShareMe.class ,FILE_ID, java.lang.String.class, "文件", "文件", java.lang.String.class, null);
	
	/**
	 * 文件 , 类型: java.lang.String
	*/
	public static final String FD_ID="fdId";
	
	/**
	 * 文件 , 类型: java.lang.String
	*/
	public static final BeanProperty<com.dt.platform.domain.oa.NetdiskShareMe,java.lang.String> FD_ID_PROP = new BeanProperty(com.dt.platform.domain.oa.NetdiskShareMe.class ,FD_ID, java.lang.String.class, "文件", "文件", java.lang.String.class, null);
	
	/**
	 * 文件类型 , 类型: java.lang.String
	*/
	public static final String FD_TYPE="fdType";
	
	/**
	 * 文件类型 , 类型: java.lang.String
	*/
	public static final BeanProperty<com.dt.platform.domain.oa.NetdiskShareMe,java.lang.String> FD_TYPE_PROP = new BeanProperty(com.dt.platform.domain.oa.NetdiskShareMe.class ,FD_TYPE, java.lang.String.class, "文件类型", "文件类型", java.lang.String.class, null);
	
	/**
	 * 分享 , 类型: java.lang.String
	*/
	public static final String SHARE_ID="shareId";
	
	/**
	 * 分享 , 类型: java.lang.String
	*/
	public static final BeanProperty<com.dt.platform.domain.oa.NetdiskShareMe,java.lang.String> SHARE_ID_PROP = new BeanProperty(com.dt.platform.domain.oa.NetdiskShareMe.class ,SHARE_ID, java.lang.String.class, "分享", "分享", java.lang.String.class, null);
	
	/**
	 * 用户 , 类型: java.lang.String
	*/
	public static final String USER_ID="userId";
	
	/**
	 * 用户 , 类型: java.lang.String
	*/
	public static final BeanProperty<com.dt.platform.domain.oa.NetdiskShareMe,java.lang.String> USER_ID_PROP = new BeanProperty(com.dt.platform.domain.oa.NetdiskShareMe.class ,USER_ID, java.lang.String.class, "用户", "用户", java.lang.String.class, null);
	
	/**
	 * 所属 , 类型: java.lang.String
	*/
	public static final String OWNER_USER_ID="ownerUserId";
	
	/**
	 * 所属 , 类型: java.lang.String
	*/
	public static final BeanProperty<com.dt.platform.domain.oa.NetdiskShareMe,java.lang.String> OWNER_USER_ID_PROP = new BeanProperty(com.dt.platform.domain.oa.NetdiskShareMe.class ,OWNER_USER_ID, java.lang.String.class, "所属", "所属", java.lang.String.class, null);
	
	/**
	 * 版本 , 类型: java.lang.Integer
	*/
	public static final String VERSION="version";
	
	/**
	 * 版本 , 类型: java.lang.Integer
	*/
	public static final BeanProperty<com.dt.platform.domain.oa.NetdiskShareMe,java.lang.Integer> VERSION_PROP = new BeanProperty(com.dt.platform.domain.oa.NetdiskShareMe.class ,VERSION, java.lang.Integer.class, "版本", "版本", java.lang.Integer.class, null);
	
	/**
	 * 创建人ID , 类型: java.lang.String
	*/
	public static final String CREATE_BY="createBy";
	
	/**
	 * 创建人ID , 类型: java.lang.String
	*/
	public static final BeanProperty<com.dt.platform.domain.oa.NetdiskShareMe,java.lang.String> CREATE_BY_PROP = new BeanProperty(com.dt.platform.domain.oa.NetdiskShareMe.class ,CREATE_BY, java.lang.String.class, "创建人ID", "创建人ID", java.lang.String.class, null);
	
	/**
	 * 创建时间 , 类型: java.util.Date
	*/
	public static final String CREATE_TIME="createTime";
	
	/**
	 * 创建时间 , 类型: java.util.Date
	*/
	public static final BeanProperty<com.dt.platform.domain.oa.NetdiskShareMe,java.util.Date> CREATE_TIME_PROP = new BeanProperty(com.dt.platform.domain.oa.NetdiskShareMe.class ,CREATE_TIME, java.util.Date.class, "创建时间", "创建时间", java.util.Date.class, null);
	
	/**
	 * 修改人ID , 类型: java.lang.String
	*/
	public static final String UPDATE_BY="updateBy";
	
	/**
	 * 修改人ID , 类型: java.lang.String
	*/
	public static final BeanProperty<com.dt.platform.domain.oa.NetdiskShareMe,java.lang.String> UPDATE_BY_PROP = new BeanProperty(com.dt.platform.domain.oa.NetdiskShareMe.class ,UPDATE_BY, java.lang.String.class, "修改人ID", "修改人ID", java.lang.String.class, null);
	
	/**
	 * 修改时间 , 类型: java.util.Date
	*/
	public static final String UPDATE_TIME="updateTime";
	
	/**
	 * 修改时间 , 类型: java.util.Date
	*/
	public static final BeanProperty<com.dt.platform.domain.oa.NetdiskShareMe,java.util.Date> UPDATE_TIME_PROP = new BeanProperty(com.dt.platform.domain.oa.NetdiskShareMe.class ,UPDATE_TIME, java.util.Date.class, "修改时间", "修改时间", java.util.Date.class, null);
	
	/**
	 * 是否已删除 , 类型: java.lang.Integer
	*/
	public static final String DELETED="deleted";
	
	/**
	 * 是否已删除 , 类型: java.lang.Integer
	*/
	public static final BeanProperty<com.dt.platform.domain.oa.NetdiskShareMe,java.lang.Integer> DELETED_PROP = new BeanProperty(com.dt.platform.domain.oa.NetdiskShareMe.class ,DELETED, java.lang.Integer.class, "是否已删除", "是否已删除", java.lang.Integer.class, null);
	
	/**
	 * 删除人ID , 类型: java.lang.String
	*/
	public static final String DELETE_BY="deleteBy";
	
	/**
	 * 删除人ID , 类型: java.lang.String
	*/
	public static final BeanProperty<com.dt.platform.domain.oa.NetdiskShareMe,java.lang.String> DELETE_BY_PROP = new BeanProperty(com.dt.platform.domain.oa.NetdiskShareMe.class ,DELETE_BY, java.lang.String.class, "删除人ID", "删除人ID", java.lang.String.class, null);
	
	/**
	 * 删除时间 , 类型: java.util.Date
	*/
	public static final String DELETE_TIME="deleteTime";
	
	/**
	 * 删除时间 , 类型: java.util.Date
	*/
	public static final BeanProperty<com.dt.platform.domain.oa.NetdiskShareMe,java.util.Date> DELETE_TIME_PROP = new BeanProperty(com.dt.platform.domain.oa.NetdiskShareMe.class ,DELETE_TIME, java.util.Date.class, "删除时间", "删除时间", java.util.Date.class, null);
	
	/**
	 * 租户 , 类型: java.lang.String
	*/
	public static final String TENANT_ID="tenantId";
	
	/**
	 * 租户 , 类型: java.lang.String
	*/
	public static final BeanProperty<com.dt.platform.domain.oa.NetdiskShareMe,java.lang.String> TENANT_ID_PROP = new BeanProperty(com.dt.platform.domain.oa.NetdiskShareMe.class ,TENANT_ID, java.lang.String.class, "租户", "租户", java.lang.String.class, null);
	
	/**
	 * netdiskFile , 类型: com.dt.platform.domain.oa.NetdiskFile
	*/
	public static final String NETDISK_FILE="netdiskFile";
	
	/**
	 * netdiskFile , 类型: com.dt.platform.domain.oa.NetdiskFile
	*/
	public static final BeanProperty<com.dt.platform.domain.oa.NetdiskShareMe,com.dt.platform.domain.oa.NetdiskFile> NETDISK_FILE_PROP = new BeanProperty(com.dt.platform.domain.oa.NetdiskShareMe.class ,NETDISK_FILE, com.dt.platform.domain.oa.NetdiskFile.class, "netdiskFile", "netdiskFile", com.dt.platform.domain.oa.NetdiskFile.class, null);
	
	/**
	 * netdiskOriginFile , 类型: com.dt.platform.domain.oa.NetdiskOriginFile
	*/
	public static final String NETDISK_ORIGIN_FILE="netdiskOriginFile";
	
	/**
	 * netdiskOriginFile , 类型: com.dt.platform.domain.oa.NetdiskOriginFile
	*/
	public static final BeanProperty<com.dt.platform.domain.oa.NetdiskShareMe,com.dt.platform.domain.oa.NetdiskOriginFile> NETDISK_ORIGIN_FILE_PROP = new BeanProperty(com.dt.platform.domain.oa.NetdiskShareMe.class ,NETDISK_ORIGIN_FILE, com.dt.platform.domain.oa.NetdiskOriginFile.class, "netdiskOriginFile", "netdiskOriginFile", com.dt.platform.domain.oa.NetdiskOriginFile.class, null);
	
	/**
	 * user , 类型: org.github.foxnic.web.domain.hrm.Employee
	*/
	public static final String USER="user";
	
	/**
	 * user , 类型: org.github.foxnic.web.domain.hrm.Employee
	*/
	public static final BeanProperty<com.dt.platform.domain.oa.NetdiskShareMe,org.github.foxnic.web.domain.hrm.Employee> USER_PROP = new BeanProperty(com.dt.platform.domain.oa.NetdiskShareMe.class ,USER, org.github.foxnic.web.domain.hrm.Employee.class, "user", "user", org.github.foxnic.web.domain.hrm.Employee.class, null);
	
	/**
	 * ownerUser , 类型: org.github.foxnic.web.domain.hrm.Employee
	*/
	public static final String OWNER_USER="ownerUser";
	
	/**
	 * ownerUser , 类型: org.github.foxnic.web.domain.hrm.Employee
	*/
	public static final BeanProperty<com.dt.platform.domain.oa.NetdiskShareMe,org.github.foxnic.web.domain.hrm.Employee> OWNER_USER_PROP = new BeanProperty(com.dt.platform.domain.oa.NetdiskShareMe.class ,OWNER_USER, org.github.foxnic.web.domain.hrm.Employee.class, "ownerUser", "ownerUser", org.github.foxnic.web.domain.hrm.Employee.class, null);
	
	/**
	 * 全部属性清单
	*/
	public static final String[] $PROPS={ ID , FILE_ID , FD_ID , FD_TYPE , SHARE_ID , USER_ID , OWNER_USER_ID , VERSION , CREATE_BY , CREATE_TIME , UPDATE_BY , UPDATE_TIME , DELETED , DELETE_BY , DELETE_TIME , TENANT_ID , NETDISK_FILE , NETDISK_ORIGIN_FILE , USER , OWNER_USER };
	
	/**
	 * 代理类
	*/
	public static class $$proxy$$ extends com.dt.platform.domain.oa.NetdiskShareMe {

		private static final long serialVersionUID = 1L;

		
		/**
		 * 设置 主键
		 * @param id 主键
		 * @return 当前对象
		*/
		public NetdiskShareMe setId(String id) {
			super.change(ID,super.getId(),id);
			super.setId(id);
			return this;
		}
		
		/**
		 * 设置 文件
		 * @param fileId 文件
		 * @return 当前对象
		*/
		public NetdiskShareMe setFileId(String fileId) {
			super.change(FILE_ID,super.getFileId(),fileId);
			super.setFileId(fileId);
			return this;
		}
		
		/**
		 * 设置 文件
		 * @param fdId 文件
		 * @return 当前对象
		*/
		public NetdiskShareMe setFdId(String fdId) {
			super.change(FD_ID,super.getFdId(),fdId);
			super.setFdId(fdId);
			return this;
		}
		
		/**
		 * 设置 文件类型
		 * @param fdType 文件类型
		 * @return 当前对象
		*/
		public NetdiskShareMe setFdType(String fdType) {
			super.change(FD_TYPE,super.getFdType(),fdType);
			super.setFdType(fdType);
			return this;
		}
		
		/**
		 * 设置 分享
		 * @param shareId 分享
		 * @return 当前对象
		*/
		public NetdiskShareMe setShareId(String shareId) {
			super.change(SHARE_ID,super.getShareId(),shareId);
			super.setShareId(shareId);
			return this;
		}
		
		/**
		 * 设置 用户
		 * @param userId 用户
		 * @return 当前对象
		*/
		public NetdiskShareMe setUserId(String userId) {
			super.change(USER_ID,super.getUserId(),userId);
			super.setUserId(userId);
			return this;
		}
		
		/**
		 * 设置 所属
		 * @param ownerUserId 所属
		 * @return 当前对象
		*/
		public NetdiskShareMe setOwnerUserId(String ownerUserId) {
			super.change(OWNER_USER_ID,super.getOwnerUserId(),ownerUserId);
			super.setOwnerUserId(ownerUserId);
			return this;
		}
		
		/**
		 * 设置 版本
		 * @param version 版本
		 * @return 当前对象
		*/
		public NetdiskShareMe setVersion(Integer version) {
			super.change(VERSION,super.getVersion(),version);
			super.setVersion(version);
			return this;
		}
		
		/**
		 * 设置 创建人ID
		 * @param createBy 创建人ID
		 * @return 当前对象
		*/
		public NetdiskShareMe setCreateBy(String createBy) {
			super.change(CREATE_BY,super.getCreateBy(),createBy);
			super.setCreateBy(createBy);
			return this;
		}
		
		/**
		 * 设置 创建时间
		 * @param createTime 创建时间
		 * @return 当前对象
		*/
		public NetdiskShareMe setCreateTime(Date createTime) {
			super.change(CREATE_TIME,super.getCreateTime(),createTime);
			super.setCreateTime(createTime);
			return this;
		}
		
		/**
		 * 设置 修改人ID
		 * @param updateBy 修改人ID
		 * @return 当前对象
		*/
		public NetdiskShareMe setUpdateBy(String updateBy) {
			super.change(UPDATE_BY,super.getUpdateBy(),updateBy);
			super.setUpdateBy(updateBy);
			return this;
		}
		
		/**
		 * 设置 修改时间
		 * @param updateTime 修改时间
		 * @return 当前对象
		*/
		public NetdiskShareMe setUpdateTime(Date updateTime) {
			super.change(UPDATE_TIME,super.getUpdateTime(),updateTime);
			super.setUpdateTime(updateTime);
			return this;
		}
		
		/**
		 * 设置 是否已删除
		 * @param deleted 是否已删除
		 * @return 当前对象
		*/
		public NetdiskShareMe setDeleted(Integer deleted) {
			super.change(DELETED,super.getDeleted(),deleted);
			super.setDeleted(deleted);
			return this;
		}
		
		/**
		 * 设置 删除人ID
		 * @param deleteBy 删除人ID
		 * @return 当前对象
		*/
		public NetdiskShareMe setDeleteBy(String deleteBy) {
			super.change(DELETE_BY,super.getDeleteBy(),deleteBy);
			super.setDeleteBy(deleteBy);
			return this;
		}
		
		/**
		 * 设置 删除时间
		 * @param deleteTime 删除时间
		 * @return 当前对象
		*/
		public NetdiskShareMe setDeleteTime(Date deleteTime) {
			super.change(DELETE_TIME,super.getDeleteTime(),deleteTime);
			super.setDeleteTime(deleteTime);
			return this;
		}
		
		/**
		 * 设置 租户
		 * @param tenantId 租户
		 * @return 当前对象
		*/
		public NetdiskShareMe setTenantId(String tenantId) {
			super.change(TENANT_ID,super.getTenantId(),tenantId);
			super.setTenantId(tenantId);
			return this;
		}
		
		/**
		 * 设置 netdiskFile
		 * @param netdiskFile netdiskFile
		 * @return 当前对象
		*/
		public NetdiskShareMe setNetdiskFile(NetdiskFile netdiskFile) {
			super.change(NETDISK_FILE,super.getNetdiskFile(),netdiskFile);
			super.setNetdiskFile(netdiskFile);
			return this;
		}
		
		/**
		 * 设置 netdiskOriginFile
		 * @param netdiskOriginFile netdiskOriginFile
		 * @return 当前对象
		*/
		public NetdiskShareMe setNetdiskOriginFile(NetdiskOriginFile netdiskOriginFile) {
			super.change(NETDISK_ORIGIN_FILE,super.getNetdiskOriginFile(),netdiskOriginFile);
			super.setNetdiskOriginFile(netdiskOriginFile);
			return this;
		}
		
		/**
		 * 设置 user
		 * @param user user
		 * @return 当前对象
		*/
		public NetdiskShareMe setUser(Employee user) {
			super.change(USER,super.getUser(),user);
			super.setUser(user);
			return this;
		}
		
		/**
		 * 设置 ownerUser
		 * @param ownerUser ownerUser
		 * @return 当前对象
		*/
		public NetdiskShareMe setOwnerUser(Employee ownerUser) {
			super.change(OWNER_USER,super.getOwnerUser(),ownerUser);
			super.setOwnerUser(ownerUser);
			return this;
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
			$$proxy$$ inst=new $$proxy$$();
			inst.setShareId(this.getShareId());
			inst.setUpdateTime(this.getUpdateTime());
			inst.setUserId(this.getUserId());
			inst.setVersion(this.getVersion());
			inst.setFdType(this.getFdType());
			inst.setCreateBy(this.getCreateBy());
			inst.setDeleted(this.getDeleted());
			inst.setCreateTime(this.getCreateTime());
			inst.setUpdateBy(this.getUpdateBy());
			inst.setDeleteTime(this.getDeleteTime());
			inst.setFdId(this.getFdId());
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

	}
}