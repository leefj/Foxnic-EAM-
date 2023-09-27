package com.dt.platform.domain.oa.meta;

import com.github.foxnic.api.bean.BeanProperty;
import com.dt.platform.domain.oa.NetdiskResourceLimit;
import java.util.Date;
import org.github.foxnic.web.domain.hrm.Employee;
import javax.persistence.Transient;



/**
 * @author 金杰 , maillank@qq.com
 * @since 2023-09-27 22:40:34
 * @sign C9A4BCC8EC22D5B638799E1360CE504F
 * 此文件由工具自动生成，请勿修改。若表结构或配置发生变动，请使用工具重新生成。
*/

public class NetdiskResourceLimitMeta {
	
	/**
	 * 主键 , 类型: java.lang.String
	*/
	public static final String ID="id";
	
	/**
	 * 主键 , 类型: java.lang.String
	*/
	public static final BeanProperty<com.dt.platform.domain.oa.NetdiskResourceLimit,java.lang.String> ID_PROP = new BeanProperty(com.dt.platform.domain.oa.NetdiskResourceLimit.class ,ID, java.lang.String.class, "主键", "主键", java.lang.String.class, null);
	
	/**
	 * 用户 , 类型: java.lang.String
	*/
	public static final String USER_ID="userId";
	
	/**
	 * 用户 , 类型: java.lang.String
	*/
	public static final BeanProperty<com.dt.platform.domain.oa.NetdiskResourceLimit,java.lang.String> USER_ID_PROP = new BeanProperty(com.dt.platform.domain.oa.NetdiskResourceLimit.class ,USER_ID, java.lang.String.class, "用户", "用户", java.lang.String.class, null);
	
	/**
	 * 最大容量 , M） , 类型: java.lang.Long
	*/
	public static final String CAPACITY_SIZE_M="capacitySizeM";
	
	/**
	 * 最大容量 , M） , 类型: java.lang.Long
	*/
	public static final BeanProperty<com.dt.platform.domain.oa.NetdiskResourceLimit,java.lang.Long> CAPACITY_SIZE_M_PROP = new BeanProperty(com.dt.platform.domain.oa.NetdiskResourceLimit.class ,CAPACITY_SIZE_M, java.lang.Long.class, "最大容量", "M）", java.lang.Long.class, null);
	
	/**
	 * 当前容量 , B） , 类型: java.lang.Long
	*/
	public static final String CURRENT_SIZE_B="currentSizeB";
	
	/**
	 * 当前容量 , B） , 类型: java.lang.Long
	*/
	public static final BeanProperty<com.dt.platform.domain.oa.NetdiskResourceLimit,java.lang.Long> CURRENT_SIZE_B_PROP = new BeanProperty(com.dt.platform.domain.oa.NetdiskResourceLimit.class ,CURRENT_SIZE_B, java.lang.Long.class, "当前容量", "B）", java.lang.Long.class, null);
	
	/**
	 * 上传大小 , M） , 类型: java.lang.Long
	*/
	public static final String UPLOAD_MAX_SIZE_M="uploadMaxSizeM";
	
	/**
	 * 上传大小 , M） , 类型: java.lang.Long
	*/
	public static final BeanProperty<com.dt.platform.domain.oa.NetdiskResourceLimit,java.lang.Long> UPLOAD_MAX_SIZE_M_PROP = new BeanProperty(com.dt.platform.domain.oa.NetdiskResourceLimit.class ,UPLOAD_MAX_SIZE_M, java.lang.Long.class, "上传大小", "M）", java.lang.Long.class, null);
	
	/**
	 * 文件类型 , 类型: java.lang.String
	*/
	public static final String UPLOAD_FILE_TYPE="uploadFileType";
	
	/**
	 * 文件类型 , 类型: java.lang.String
	*/
	public static final BeanProperty<com.dt.platform.domain.oa.NetdiskResourceLimit,java.lang.String> UPLOAD_FILE_TYPE_PROP = new BeanProperty(com.dt.platform.domain.oa.NetdiskResourceLimit.class ,UPLOAD_FILE_TYPE, java.lang.String.class, "文件类型", "文件类型", java.lang.String.class, null);
	
	/**
	 * 视频播放 , 类型: java.lang.String
	*/
	public static final String PLAY_VIDEO_VALID="playVideoValid";
	
	/**
	 * 视频播放 , 类型: java.lang.String
	*/
	public static final BeanProperty<com.dt.platform.domain.oa.NetdiskResourceLimit,java.lang.String> PLAY_VIDEO_VALID_PROP = new BeanProperty(com.dt.platform.domain.oa.NetdiskResourceLimit.class ,PLAY_VIDEO_VALID, java.lang.String.class, "视频播放", "视频播放", java.lang.String.class, null);
	
	/**
	 * 音频播放 , 类型: java.lang.String
	*/
	public static final String PLAY_MUSIC_VALID="playMusicValid";
	
	/**
	 * 音频播放 , 类型: java.lang.String
	*/
	public static final BeanProperty<com.dt.platform.domain.oa.NetdiskResourceLimit,java.lang.String> PLAY_MUSIC_VALID_PROP = new BeanProperty(com.dt.platform.domain.oa.NetdiskResourceLimit.class ,PLAY_MUSIC_VALID, java.lang.String.class, "音频播放", "音频播放", java.lang.String.class, null);
	
	/**
	 * 图片预览 , 类型: java.lang.String
	*/
	public static final String VIEW_PHOTO_VALID="viewPhotoValid";
	
	/**
	 * 图片预览 , 类型: java.lang.String
	*/
	public static final BeanProperty<com.dt.platform.domain.oa.NetdiskResourceLimit,java.lang.String> VIEW_PHOTO_VALID_PROP = new BeanProperty(com.dt.platform.domain.oa.NetdiskResourceLimit.class ,VIEW_PHOTO_VALID, java.lang.String.class, "图片预览", "图片预览", java.lang.String.class, null);
	
	/**
	 * 文档预览 , 类型: java.lang.String
	*/
	public static final String VIEW_DOC_VALID="viewDocValid";
	
	/**
	 * 文档预览 , 类型: java.lang.String
	*/
	public static final BeanProperty<com.dt.platform.domain.oa.NetdiskResourceLimit,java.lang.String> VIEW_DOC_VALID_PROP = new BeanProperty(com.dt.platform.domain.oa.NetdiskResourceLimit.class ,VIEW_DOC_VALID, java.lang.String.class, "文档预览", "文档预览", java.lang.String.class, null);
	
	/**
	 * 版本 , 类型: java.lang.Integer
	*/
	public static final String VERSION="version";
	
	/**
	 * 版本 , 类型: java.lang.Integer
	*/
	public static final BeanProperty<com.dt.platform.domain.oa.NetdiskResourceLimit,java.lang.Integer> VERSION_PROP = new BeanProperty(com.dt.platform.domain.oa.NetdiskResourceLimit.class ,VERSION, java.lang.Integer.class, "版本", "版本", java.lang.Integer.class, null);
	
	/**
	 * 创建人ID , 类型: java.lang.String
	*/
	public static final String CREATE_BY="createBy";
	
	/**
	 * 创建人ID , 类型: java.lang.String
	*/
	public static final BeanProperty<com.dt.platform.domain.oa.NetdiskResourceLimit,java.lang.String> CREATE_BY_PROP = new BeanProperty(com.dt.platform.domain.oa.NetdiskResourceLimit.class ,CREATE_BY, java.lang.String.class, "创建人ID", "创建人ID", java.lang.String.class, null);
	
	/**
	 * 创建时间 , 类型: java.util.Date
	*/
	public static final String CREATE_TIME="createTime";
	
	/**
	 * 创建时间 , 类型: java.util.Date
	*/
	public static final BeanProperty<com.dt.platform.domain.oa.NetdiskResourceLimit,java.util.Date> CREATE_TIME_PROP = new BeanProperty(com.dt.platform.domain.oa.NetdiskResourceLimit.class ,CREATE_TIME, java.util.Date.class, "创建时间", "创建时间", java.util.Date.class, null);
	
	/**
	 * 修改人ID , 类型: java.lang.String
	*/
	public static final String UPDATE_BY="updateBy";
	
	/**
	 * 修改人ID , 类型: java.lang.String
	*/
	public static final BeanProperty<com.dt.platform.domain.oa.NetdiskResourceLimit,java.lang.String> UPDATE_BY_PROP = new BeanProperty(com.dt.platform.domain.oa.NetdiskResourceLimit.class ,UPDATE_BY, java.lang.String.class, "修改人ID", "修改人ID", java.lang.String.class, null);
	
	/**
	 * 修改时间 , 类型: java.util.Date
	*/
	public static final String UPDATE_TIME="updateTime";
	
	/**
	 * 修改时间 , 类型: java.util.Date
	*/
	public static final BeanProperty<com.dt.platform.domain.oa.NetdiskResourceLimit,java.util.Date> UPDATE_TIME_PROP = new BeanProperty(com.dt.platform.domain.oa.NetdiskResourceLimit.class ,UPDATE_TIME, java.util.Date.class, "修改时间", "修改时间", java.util.Date.class, null);
	
	/**
	 * 是否已删除 , 类型: java.lang.Integer
	*/
	public static final String DELETED="deleted";
	
	/**
	 * 是否已删除 , 类型: java.lang.Integer
	*/
	public static final BeanProperty<com.dt.platform.domain.oa.NetdiskResourceLimit,java.lang.Integer> DELETED_PROP = new BeanProperty(com.dt.platform.domain.oa.NetdiskResourceLimit.class ,DELETED, java.lang.Integer.class, "是否已删除", "是否已删除", java.lang.Integer.class, null);
	
	/**
	 * 删除人ID , 类型: java.lang.String
	*/
	public static final String DELETE_BY="deleteBy";
	
	/**
	 * 删除人ID , 类型: java.lang.String
	*/
	public static final BeanProperty<com.dt.platform.domain.oa.NetdiskResourceLimit,java.lang.String> DELETE_BY_PROP = new BeanProperty(com.dt.platform.domain.oa.NetdiskResourceLimit.class ,DELETE_BY, java.lang.String.class, "删除人ID", "删除人ID", java.lang.String.class, null);
	
	/**
	 * 删除时间 , 类型: java.util.Date
	*/
	public static final String DELETE_TIME="deleteTime";
	
	/**
	 * 删除时间 , 类型: java.util.Date
	*/
	public static final BeanProperty<com.dt.platform.domain.oa.NetdiskResourceLimit,java.util.Date> DELETE_TIME_PROP = new BeanProperty(com.dt.platform.domain.oa.NetdiskResourceLimit.class ,DELETE_TIME, java.util.Date.class, "删除时间", "删除时间", java.util.Date.class, null);
	
	/**
	 * 租户 , 类型: java.lang.String
	*/
	public static final String TENANT_ID="tenantId";
	
	/**
	 * 租户 , 类型: java.lang.String
	*/
	public static final BeanProperty<com.dt.platform.domain.oa.NetdiskResourceLimit,java.lang.String> TENANT_ID_PROP = new BeanProperty(com.dt.platform.domain.oa.NetdiskResourceLimit.class ,TENANT_ID, java.lang.String.class, "租户", "租户", java.lang.String.class, null);
	
	/**
	 * user , 类型: org.github.foxnic.web.domain.hrm.Employee
	*/
	public static final String USER="user";
	
	/**
	 * user , 类型: org.github.foxnic.web.domain.hrm.Employee
	*/
	public static final BeanProperty<com.dt.platform.domain.oa.NetdiskResourceLimit,org.github.foxnic.web.domain.hrm.Employee> USER_PROP = new BeanProperty(com.dt.platform.domain.oa.NetdiskResourceLimit.class ,USER, org.github.foxnic.web.domain.hrm.Employee.class, "user", "user", org.github.foxnic.web.domain.hrm.Employee.class, null);
	
	/**
	 * capacitySizeValue , 类型: java.lang.String
	*/
	public static final String CAPACITY_SIZE_VALUE="capacitySizeValue";
	
	/**
	 * capacitySizeValue , 类型: java.lang.String
	*/
	public static final BeanProperty<com.dt.platform.domain.oa.NetdiskResourceLimit,java.lang.String> CAPACITY_SIZE_VALUE_PROP = new BeanProperty(com.dt.platform.domain.oa.NetdiskResourceLimit.class ,CAPACITY_SIZE_VALUE, java.lang.String.class, "capacitySizeValue", "capacitySizeValue", java.lang.String.class, null);
	
	/**
	 * currentSizeValue , 类型: java.lang.String
	*/
	public static final String CURRENT_SIZE_VALUE="currentSizeValue";
	
	/**
	 * currentSizeValue , 类型: java.lang.String
	*/
	public static final BeanProperty<com.dt.platform.domain.oa.NetdiskResourceLimit,java.lang.String> CURRENT_SIZE_VALUE_PROP = new BeanProperty(com.dt.platform.domain.oa.NetdiskResourceLimit.class ,CURRENT_SIZE_VALUE, java.lang.String.class, "currentSizeValue", "currentSizeValue", java.lang.String.class, null);
	
	/**
	 * 全部属性清单
	*/
	public static final String[] $PROPS={ ID , USER_ID , CAPACITY_SIZE_M , CURRENT_SIZE_B , UPLOAD_MAX_SIZE_M , UPLOAD_FILE_TYPE , PLAY_VIDEO_VALID , PLAY_MUSIC_VALID , VIEW_PHOTO_VALID , VIEW_DOC_VALID , VERSION , CREATE_BY , CREATE_TIME , UPDATE_BY , UPDATE_TIME , DELETED , DELETE_BY , DELETE_TIME , TENANT_ID , USER , CAPACITY_SIZE_VALUE , CURRENT_SIZE_VALUE };
	
	/**
	 * 代理类
	*/
	public static class $$proxy$$ extends com.dt.platform.domain.oa.NetdiskResourceLimit {

		private static final long serialVersionUID = 1L;

		
		/**
		 * 设置 主键
		 * @param id 主键
		 * @return 当前对象
		*/
		public NetdiskResourceLimit setId(String id) {
			super.change(ID,super.getId(),id);
			super.setId(id);
			return this;
		}
		
		/**
		 * 设置 用户
		 * @param userId 用户
		 * @return 当前对象
		*/
		public NetdiskResourceLimit setUserId(String userId) {
			super.change(USER_ID,super.getUserId(),userId);
			super.setUserId(userId);
			return this;
		}
		
		/**
		 * 设置 最大容量
		 * @param capacitySizeM 最大容量
		 * @return 当前对象
		*/
		public NetdiskResourceLimit setCapacitySizeM(Long capacitySizeM) {
			super.change(CAPACITY_SIZE_M,super.getCapacitySizeM(),capacitySizeM);
			super.setCapacitySizeM(capacitySizeM);
			return this;
		}
		
		/**
		 * 设置 当前容量
		 * @param currentSizeB 当前容量
		 * @return 当前对象
		*/
		public NetdiskResourceLimit setCurrentSizeB(Long currentSizeB) {
			super.change(CURRENT_SIZE_B,super.getCurrentSizeB(),currentSizeB);
			super.setCurrentSizeB(currentSizeB);
			return this;
		}
		
		/**
		 * 设置 上传大小
		 * @param uploadMaxSizeM 上传大小
		 * @return 当前对象
		*/
		public NetdiskResourceLimit setUploadMaxSizeM(Long uploadMaxSizeM) {
			super.change(UPLOAD_MAX_SIZE_M,super.getUploadMaxSizeM(),uploadMaxSizeM);
			super.setUploadMaxSizeM(uploadMaxSizeM);
			return this;
		}
		
		/**
		 * 设置 文件类型
		 * @param uploadFileType 文件类型
		 * @return 当前对象
		*/
		public NetdiskResourceLimit setUploadFileType(String uploadFileType) {
			super.change(UPLOAD_FILE_TYPE,super.getUploadFileType(),uploadFileType);
			super.setUploadFileType(uploadFileType);
			return this;
		}
		
		/**
		 * 设置 视频播放
		 * @param playVideoValid 视频播放
		 * @return 当前对象
		*/
		public NetdiskResourceLimit setPlayVideoValid(String playVideoValid) {
			super.change(PLAY_VIDEO_VALID,super.getPlayVideoValid(),playVideoValid);
			super.setPlayVideoValid(playVideoValid);
			return this;
		}
		
		/**
		 * 设置 音频播放
		 * @param playMusicValid 音频播放
		 * @return 当前对象
		*/
		public NetdiskResourceLimit setPlayMusicValid(String playMusicValid) {
			super.change(PLAY_MUSIC_VALID,super.getPlayMusicValid(),playMusicValid);
			super.setPlayMusicValid(playMusicValid);
			return this;
		}
		
		/**
		 * 设置 图片预览
		 * @param viewPhotoValid 图片预览
		 * @return 当前对象
		*/
		public NetdiskResourceLimit setViewPhotoValid(String viewPhotoValid) {
			super.change(VIEW_PHOTO_VALID,super.getViewPhotoValid(),viewPhotoValid);
			super.setViewPhotoValid(viewPhotoValid);
			return this;
		}
		
		/**
		 * 设置 文档预览
		 * @param viewDocValid 文档预览
		 * @return 当前对象
		*/
		public NetdiskResourceLimit setViewDocValid(String viewDocValid) {
			super.change(VIEW_DOC_VALID,super.getViewDocValid(),viewDocValid);
			super.setViewDocValid(viewDocValid);
			return this;
		}
		
		/**
		 * 设置 版本
		 * @param version 版本
		 * @return 当前对象
		*/
		public NetdiskResourceLimit setVersion(Integer version) {
			super.change(VERSION,super.getVersion(),version);
			super.setVersion(version);
			return this;
		}
		
		/**
		 * 设置 创建人ID
		 * @param createBy 创建人ID
		 * @return 当前对象
		*/
		public NetdiskResourceLimit setCreateBy(String createBy) {
			super.change(CREATE_BY,super.getCreateBy(),createBy);
			super.setCreateBy(createBy);
			return this;
		}
		
		/**
		 * 设置 创建时间
		 * @param createTime 创建时间
		 * @return 当前对象
		*/
		public NetdiskResourceLimit setCreateTime(Date createTime) {
			super.change(CREATE_TIME,super.getCreateTime(),createTime);
			super.setCreateTime(createTime);
			return this;
		}
		
		/**
		 * 设置 修改人ID
		 * @param updateBy 修改人ID
		 * @return 当前对象
		*/
		public NetdiskResourceLimit setUpdateBy(String updateBy) {
			super.change(UPDATE_BY,super.getUpdateBy(),updateBy);
			super.setUpdateBy(updateBy);
			return this;
		}
		
		/**
		 * 设置 修改时间
		 * @param updateTime 修改时间
		 * @return 当前对象
		*/
		public NetdiskResourceLimit setUpdateTime(Date updateTime) {
			super.change(UPDATE_TIME,super.getUpdateTime(),updateTime);
			super.setUpdateTime(updateTime);
			return this;
		}
		
		/**
		 * 设置 是否已删除
		 * @param deleted 是否已删除
		 * @return 当前对象
		*/
		public NetdiskResourceLimit setDeleted(Integer deleted) {
			super.change(DELETED,super.getDeleted(),deleted);
			super.setDeleted(deleted);
			return this;
		}
		
		/**
		 * 设置 删除人ID
		 * @param deleteBy 删除人ID
		 * @return 当前对象
		*/
		public NetdiskResourceLimit setDeleteBy(String deleteBy) {
			super.change(DELETE_BY,super.getDeleteBy(),deleteBy);
			super.setDeleteBy(deleteBy);
			return this;
		}
		
		/**
		 * 设置 删除时间
		 * @param deleteTime 删除时间
		 * @return 当前对象
		*/
		public NetdiskResourceLimit setDeleteTime(Date deleteTime) {
			super.change(DELETE_TIME,super.getDeleteTime(),deleteTime);
			super.setDeleteTime(deleteTime);
			return this;
		}
		
		/**
		 * 设置 租户
		 * @param tenantId 租户
		 * @return 当前对象
		*/
		public NetdiskResourceLimit setTenantId(String tenantId) {
			super.change(TENANT_ID,super.getTenantId(),tenantId);
			super.setTenantId(tenantId);
			return this;
		}
		
		/**
		 * 设置 user
		 * @param user user
		 * @return 当前对象
		*/
		public NetdiskResourceLimit setUser(Employee user) {
			super.change(USER,super.getUser(),user);
			super.setUser(user);
			return this;
		}
		
		/**
		 * 设置 capacitySizeValue
		 * @param capacitySizeValue capacitySizeValue
		 * @return 当前对象
		*/
		public NetdiskResourceLimit setCapacitySizeValue(String capacitySizeValue) {
			super.change(CAPACITY_SIZE_VALUE,super.getCapacitySizeValue(),capacitySizeValue);
			super.setCapacitySizeValue(capacitySizeValue);
			return this;
		}
		
		/**
		 * 设置 currentSizeValue
		 * @param currentSizeValue currentSizeValue
		 * @return 当前对象
		*/
		public NetdiskResourceLimit setCurrentSizeValue(String currentSizeValue) {
			super.change(CURRENT_SIZE_VALUE,super.getCurrentSizeValue(),currentSizeValue);
			super.setCurrentSizeValue(currentSizeValue);
			return this;
		}

		/**
		 * 克隆当前对象
		*/
		@Transient
		public NetdiskResourceLimit clone() {
			return duplicate(true);
		}

		/**
		 * 复制当前对象
		 * @param all 是否复制全部属性，当 false 时，仅复制来自数据表的属性
		*/
		@Transient
		public NetdiskResourceLimit duplicate(boolean all) {
			$$proxy$$ inst=new $$proxy$$();
			inst.setPlayVideoValid(this.getPlayVideoValid());
			inst.setPlayMusicValid(this.getPlayMusicValid());
			inst.setViewPhotoValid(this.getViewPhotoValid());
			inst.setUploadFileType(this.getUploadFileType());
			inst.setUpdateTime(this.getUpdateTime());
			inst.setUserId(this.getUserId());
			inst.setCapacitySizeM(this.getCapacitySizeM());
			inst.setVersion(this.getVersion());
			inst.setCreateBy(this.getCreateBy());
			inst.setUploadMaxSizeM(this.getUploadMaxSizeM());
			inst.setDeleted(this.getDeleted());
			inst.setCreateTime(this.getCreateTime());
			inst.setUpdateBy(this.getUpdateBy());
			inst.setDeleteTime(this.getDeleteTime());
			inst.setCurrentSizeB(this.getCurrentSizeB());
			inst.setTenantId(this.getTenantId());
			inst.setDeleteBy(this.getDeleteBy());
			inst.setId(this.getId());
			inst.setViewDocValid(this.getViewDocValid());
			if(all) {
				inst.setCurrentSizeValue(this.getCurrentSizeValue());
				inst.setCapacitySizeValue(this.getCapacitySizeValue());
				inst.setUser(this.getUser());
			}
			inst.clearModifies();
			return inst;
		}

	}
}