package com.dt.platform.domain.ops.meta;

import com.github.foxnic.api.bean.BeanProperty;
import com.dt.platform.domain.ops.DbExecuteUser;
import java.util.Date;
import com.dt.platform.domain.ops.DbInfoApply;
import java.util.List;
import javax.persistence.Transient;



/**
 * @author 金杰 , maillank@qq.com
 * @since 2024-03-31 21:12:53
 * @sign A6A6312B8013B51F93609BC0EC2B99E1
 * 此文件由工具自动生成，请勿修改。若表结构或配置发生变动，请使用工具重新生成。
*/

public class DbExecuteUserMeta {
	
	/**
	 * 主键 , 类型: java.lang.String
	*/
	public static final String ID="id";
	
	/**
	 * 主键 , 类型: java.lang.String
	*/
	public static final BeanProperty<com.dt.platform.domain.ops.DbExecuteUser,java.lang.String> ID_PROP = new BeanProperty(com.dt.platform.domain.ops.DbExecuteUser.class ,ID, java.lang.String.class, "主键", "主键", java.lang.String.class, null);
	
	/**
	 * 操作人 , 类型: java.lang.String
	*/
	public static final String USER_ID="userId";
	
	/**
	 * 操作人 , 类型: java.lang.String
	*/
	public static final BeanProperty<com.dt.platform.domain.ops.DbExecuteUser,java.lang.String> USER_ID_PROP = new BeanProperty(com.dt.platform.domain.ops.DbExecuteUser.class ,USER_ID, java.lang.String.class, "操作人", "操作人", java.lang.String.class, null);
	
	/**
	 * 备注 , 类型: java.lang.String
	*/
	public static final String NOTES="notes";
	
	/**
	 * 备注 , 类型: java.lang.String
	*/
	public static final BeanProperty<com.dt.platform.domain.ops.DbExecuteUser,java.lang.String> NOTES_PROP = new BeanProperty(com.dt.platform.domain.ops.DbExecuteUser.class ,NOTES, java.lang.String.class, "备注", "备注", java.lang.String.class, null);
	
	/**
	 * 修改人ID , 类型: java.lang.String
	*/
	public static final String UPDATE_BY="updateBy";
	
	/**
	 * 修改人ID , 类型: java.lang.String
	*/
	public static final BeanProperty<com.dt.platform.domain.ops.DbExecuteUser,java.lang.String> UPDATE_BY_PROP = new BeanProperty(com.dt.platform.domain.ops.DbExecuteUser.class ,UPDATE_BY, java.lang.String.class, "修改人ID", "修改人ID", java.lang.String.class, null);
	
	/**
	 * 修改时间 , 类型: java.util.Date
	*/
	public static final String UPDATE_TIME="updateTime";
	
	/**
	 * 修改时间 , 类型: java.util.Date
	*/
	public static final BeanProperty<com.dt.platform.domain.ops.DbExecuteUser,java.util.Date> UPDATE_TIME_PROP = new BeanProperty(com.dt.platform.domain.ops.DbExecuteUser.class ,UPDATE_TIME, java.util.Date.class, "修改时间", "修改时间", java.util.Date.class, null);
	
	/**
	 * 是否已删除 , 类型: java.lang.Integer
	*/
	public static final String DELETED="deleted";
	
	/**
	 * 是否已删除 , 类型: java.lang.Integer
	*/
	public static final BeanProperty<com.dt.platform.domain.ops.DbExecuteUser,java.lang.Integer> DELETED_PROP = new BeanProperty(com.dt.platform.domain.ops.DbExecuteUser.class ,DELETED, java.lang.Integer.class, "是否已删除", "是否已删除", java.lang.Integer.class, null);
	
	/**
	 * 删除人ID , 类型: java.lang.String
	*/
	public static final String DELETE_BY="deleteBy";
	
	/**
	 * 删除人ID , 类型: java.lang.String
	*/
	public static final BeanProperty<com.dt.platform.domain.ops.DbExecuteUser,java.lang.String> DELETE_BY_PROP = new BeanProperty(com.dt.platform.domain.ops.DbExecuteUser.class ,DELETE_BY, java.lang.String.class, "删除人ID", "删除人ID", java.lang.String.class, null);
	
	/**
	 * 删除时间 , 类型: java.util.Date
	*/
	public static final String DELETE_TIME="deleteTime";
	
	/**
	 * 删除时间 , 类型: java.util.Date
	*/
	public static final BeanProperty<com.dt.platform.domain.ops.DbExecuteUser,java.util.Date> DELETE_TIME_PROP = new BeanProperty(com.dt.platform.domain.ops.DbExecuteUser.class ,DELETE_TIME, java.util.Date.class, "删除时间", "删除时间", java.util.Date.class, null);
	
	/**
	 * 创建人ID , 类型: java.lang.String
	*/
	public static final String CREATE_BY="createBy";
	
	/**
	 * 创建人ID , 类型: java.lang.String
	*/
	public static final BeanProperty<com.dt.platform.domain.ops.DbExecuteUser,java.lang.String> CREATE_BY_PROP = new BeanProperty(com.dt.platform.domain.ops.DbExecuteUser.class ,CREATE_BY, java.lang.String.class, "创建人ID", "创建人ID", java.lang.String.class, null);
	
	/**
	 * 创建时间 , 类型: java.util.Date
	*/
	public static final String CREATE_TIME="createTime";
	
	/**
	 * 创建时间 , 类型: java.util.Date
	*/
	public static final BeanProperty<com.dt.platform.domain.ops.DbExecuteUser,java.util.Date> CREATE_TIME_PROP = new BeanProperty(com.dt.platform.domain.ops.DbExecuteUser.class ,CREATE_TIME, java.util.Date.class, "创建时间", "创建时间", java.util.Date.class, null);
	
	/**
	 * version , 类型: java.lang.Integer
	*/
	public static final String VERSION="version";
	
	/**
	 * version , 类型: java.lang.Integer
	*/
	public static final BeanProperty<com.dt.platform.domain.ops.DbExecuteUser,java.lang.Integer> VERSION_PROP = new BeanProperty(com.dt.platform.domain.ops.DbExecuteUser.class ,VERSION, java.lang.Integer.class, "version", "version", java.lang.Integer.class, null);
	
	/**
	 * dbInfoApplyForYqList , 集合类型: LIST , 类型: com.dt.platform.domain.ops.DbInfoApply
	*/
	public static final String DB_INFO_APPLY_FOR_YQ_LIST="dbInfoApplyForYqList";
	
	/**
	 * dbInfoApplyForYqList , 集合类型: LIST , 类型: com.dt.platform.domain.ops.DbInfoApply
	*/
	public static final BeanProperty<com.dt.platform.domain.ops.DbExecuteUser,com.dt.platform.domain.ops.DbInfoApply> DB_INFO_APPLY_FOR_YQ_LIST_PROP = new BeanProperty(com.dt.platform.domain.ops.DbExecuteUser.class ,DB_INFO_APPLY_FOR_YQ_LIST, java.util.List.class, "dbInfoApplyForYqList", "dbInfoApplyForYqList", com.dt.platform.domain.ops.DbInfoApply.class, null);
	
	/**
	 * dbInfoApplyForYqIds , 集合类型: LIST , 类型: java.lang.String
	*/
	public static final String DB_INFO_APPLY_FOR_YQ_IDS="dbInfoApplyForYqIds";
	
	/**
	 * dbInfoApplyForYqIds , 集合类型: LIST , 类型: java.lang.String
	*/
	public static final BeanProperty<com.dt.platform.domain.ops.DbExecuteUser,java.lang.String> DB_INFO_APPLY_FOR_YQ_IDS_PROP = new BeanProperty(com.dt.platform.domain.ops.DbExecuteUser.class ,DB_INFO_APPLY_FOR_YQ_IDS, java.util.List.class, "dbInfoApplyForYqIds", "dbInfoApplyForYqIds", java.lang.String.class, null);
	
	/**
	 * dbInfoApplyForBbList , 集合类型: LIST , 类型: com.dt.platform.domain.ops.DbInfoApply
	*/
	public static final String DB_INFO_APPLY_FOR_BB_LIST="dbInfoApplyForBbList";
	
	/**
	 * dbInfoApplyForBbList , 集合类型: LIST , 类型: com.dt.platform.domain.ops.DbInfoApply
	*/
	public static final BeanProperty<com.dt.platform.domain.ops.DbExecuteUser,com.dt.platform.domain.ops.DbInfoApply> DB_INFO_APPLY_FOR_BB_LIST_PROP = new BeanProperty(com.dt.platform.domain.ops.DbExecuteUser.class ,DB_INFO_APPLY_FOR_BB_LIST, java.util.List.class, "dbInfoApplyForBbList", "dbInfoApplyForBbList", com.dt.platform.domain.ops.DbInfoApply.class, null);
	
	/**
	 * dbInfoApplyForBbIds , 集合类型: LIST , 类型: java.lang.String
	*/
	public static final String DB_INFO_APPLY_FOR_BB_IDS="dbInfoApplyForBbIds";
	
	/**
	 * dbInfoApplyForBbIds , 集合类型: LIST , 类型: java.lang.String
	*/
	public static final BeanProperty<com.dt.platform.domain.ops.DbExecuteUser,java.lang.String> DB_INFO_APPLY_FOR_BB_IDS_PROP = new BeanProperty(com.dt.platform.domain.ops.DbExecuteUser.class ,DB_INFO_APPLY_FOR_BB_IDS, java.util.List.class, "dbInfoApplyForBbIds", "dbInfoApplyForBbIds", java.lang.String.class, null);
	
	/**
	 * 全部属性清单
	*/
	public static final String[] $PROPS={ ID , USER_ID , NOTES , UPDATE_BY , UPDATE_TIME , DELETED , DELETE_BY , DELETE_TIME , CREATE_BY , CREATE_TIME , VERSION , DB_INFO_APPLY_FOR_YQ_LIST , DB_INFO_APPLY_FOR_YQ_IDS , DB_INFO_APPLY_FOR_BB_LIST , DB_INFO_APPLY_FOR_BB_IDS };
	
	/**
	 * 代理类
	*/
	public static class $$proxy$$ extends com.dt.platform.domain.ops.DbExecuteUser {

		private static final long serialVersionUID = 1L;

		
		/**
		 * 设置 主键
		 * @param id 主键
		 * @return 当前对象
		*/
		public DbExecuteUser setId(String id) {
			super.change(ID,super.getId(),id);
			super.setId(id);
			return this;
		}
		
		/**
		 * 设置 操作人
		 * @param userId 操作人
		 * @return 当前对象
		*/
		public DbExecuteUser setUserId(String userId) {
			super.change(USER_ID,super.getUserId(),userId);
			super.setUserId(userId);
			return this;
		}
		
		/**
		 * 设置 备注
		 * @param notes 备注
		 * @return 当前对象
		*/
		public DbExecuteUser setNotes(String notes) {
			super.change(NOTES,super.getNotes(),notes);
			super.setNotes(notes);
			return this;
		}
		
		/**
		 * 设置 修改人ID
		 * @param updateBy 修改人ID
		 * @return 当前对象
		*/
		public DbExecuteUser setUpdateBy(String updateBy) {
			super.change(UPDATE_BY,super.getUpdateBy(),updateBy);
			super.setUpdateBy(updateBy);
			return this;
		}
		
		/**
		 * 设置 修改时间
		 * @param updateTime 修改时间
		 * @return 当前对象
		*/
		public DbExecuteUser setUpdateTime(Date updateTime) {
			super.change(UPDATE_TIME,super.getUpdateTime(),updateTime);
			super.setUpdateTime(updateTime);
			return this;
		}
		
		/**
		 * 设置 是否已删除
		 * @param deleted 是否已删除
		 * @return 当前对象
		*/
		public DbExecuteUser setDeleted(Integer deleted) {
			super.change(DELETED,super.getDeleted(),deleted);
			super.setDeleted(deleted);
			return this;
		}
		
		/**
		 * 设置 删除人ID
		 * @param deleteBy 删除人ID
		 * @return 当前对象
		*/
		public DbExecuteUser setDeleteBy(String deleteBy) {
			super.change(DELETE_BY,super.getDeleteBy(),deleteBy);
			super.setDeleteBy(deleteBy);
			return this;
		}
		
		/**
		 * 设置 删除时间
		 * @param deleteTime 删除时间
		 * @return 当前对象
		*/
		public DbExecuteUser setDeleteTime(Date deleteTime) {
			super.change(DELETE_TIME,super.getDeleteTime(),deleteTime);
			super.setDeleteTime(deleteTime);
			return this;
		}
		
		/**
		 * 设置 创建人ID
		 * @param createBy 创建人ID
		 * @return 当前对象
		*/
		public DbExecuteUser setCreateBy(String createBy) {
			super.change(CREATE_BY,super.getCreateBy(),createBy);
			super.setCreateBy(createBy);
			return this;
		}
		
		/**
		 * 设置 创建时间
		 * @param createTime 创建时间
		 * @return 当前对象
		*/
		public DbExecuteUser setCreateTime(Date createTime) {
			super.change(CREATE_TIME,super.getCreateTime(),createTime);
			super.setCreateTime(createTime);
			return this;
		}
		
		/**
		 * 设置 version
		 * @param version version
		 * @return 当前对象
		*/
		public DbExecuteUser setVersion(Integer version) {
			super.change(VERSION,super.getVersion(),version);
			super.setVersion(version);
			return this;
		}
		
		/**
		 * 设置 dbInfoApplyForYqList
		 * @param dbInfoApplyForYqList dbInfoApplyForYqList
		 * @return 当前对象
		*/
		public DbExecuteUser setDbInfoApplyForYqList(List<DbInfoApply> dbInfoApplyForYqList) {
			super.change(DB_INFO_APPLY_FOR_YQ_LIST,super.getDbInfoApplyForYqList(),dbInfoApplyForYqList);
			super.setDbInfoApplyForYqList(dbInfoApplyForYqList);
			return this;
		}
		
		/**
		 * 设置 dbInfoApplyForYqIds
		 * @param dbInfoApplyForYqIds dbInfoApplyForYqIds
		 * @return 当前对象
		*/
		public DbExecuteUser setDbInfoApplyForYqIds(List<String> dbInfoApplyForYqIds) {
			super.change(DB_INFO_APPLY_FOR_YQ_IDS,super.getDbInfoApplyForYqIds(),dbInfoApplyForYqIds);
			super.setDbInfoApplyForYqIds(dbInfoApplyForYqIds);
			return this;
		}
		
		/**
		 * 设置 dbInfoApplyForBbList
		 * @param dbInfoApplyForBbList dbInfoApplyForBbList
		 * @return 当前对象
		*/
		public DbExecuteUser setDbInfoApplyForBbList(List<DbInfoApply> dbInfoApplyForBbList) {
			super.change(DB_INFO_APPLY_FOR_BB_LIST,super.getDbInfoApplyForBbList(),dbInfoApplyForBbList);
			super.setDbInfoApplyForBbList(dbInfoApplyForBbList);
			return this;
		}
		
		/**
		 * 设置 dbInfoApplyForBbIds
		 * @param dbInfoApplyForBbIds dbInfoApplyForBbIds
		 * @return 当前对象
		*/
		public DbExecuteUser setDbInfoApplyForBbIds(List<String> dbInfoApplyForBbIds) {
			super.change(DB_INFO_APPLY_FOR_BB_IDS,super.getDbInfoApplyForBbIds(),dbInfoApplyForBbIds);
			super.setDbInfoApplyForBbIds(dbInfoApplyForBbIds);
			return this;
		}

		/**
		 * 克隆当前对象
		*/
		@Transient
		public DbExecuteUser clone() {
			return duplicate(true);
		}

		/**
		 * 复制当前对象
		 * @param all 是否复制全部属性，当 false 时，仅复制来自数据表的属性
		*/
		@Transient
		public DbExecuteUser duplicate(boolean all) {
			$$proxy$$ inst=new $$proxy$$();
			inst.setCreateBy(this.getCreateBy());
			inst.setNotes(this.getNotes());
			inst.setDeleted(this.getDeleted());
			inst.setUpdateBy(this.getUpdateBy());
			inst.setDeleteTime(this.getDeleteTime());
			inst.setCreateTime(this.getCreateTime());
			inst.setDeleteBy(this.getDeleteBy());
			inst.setUpdateTime(this.getUpdateTime());
			inst.setId(this.getId());
			inst.setUserId(this.getUserId());
			inst.setVersion(this.getVersion());
			if(all) {
				inst.setDbInfoApplyForBbIds(this.getDbInfoApplyForBbIds());
				inst.setDbInfoApplyForYqIds(this.getDbInfoApplyForYqIds());
				inst.setDbInfoApplyForBbList(this.getDbInfoApplyForBbList());
				inst.setDbInfoApplyForYqList(this.getDbInfoApplyForYqList());
			}
			inst.clearModifies();
			return inst;
		}

	}
}