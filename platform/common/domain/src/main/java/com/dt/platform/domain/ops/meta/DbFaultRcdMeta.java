package com.dt.platform.domain.ops.meta;

import com.github.foxnic.api.bean.BeanProperty;
import com.dt.platform.domain.ops.DbFaultRcd;
import java.util.Date;
import com.dt.platform.domain.ops.DbInstance;
import javax.persistence.Transient;



/**
 * @author 金杰 , maillank@qq.com
 * @since 2023-06-11 09:33:42
 * @sign 0CE6B8C486D426CFF7202AEF00C3D782
 * 此文件由工具自动生成，请勿修改。若表结构或配置发生变动，请使用工具重新生成。
*/

public class DbFaultRcdMeta {
	
	/**
	 * 主键 , 类型: java.lang.String
	*/
	public static final String ID="id";
	
	/**
	 * 主键 , 类型: java.lang.String
	*/
	public static final BeanProperty<com.dt.platform.domain.ops.DbFaultRcd,java.lang.String> ID_PROP = new BeanProperty(com.dt.platform.domain.ops.DbFaultRcd.class ,ID, java.lang.String.class, "主键", "主键", java.lang.String.class, null);
	
	/**
	 * 名称 , 类型: java.lang.String
	*/
	public static final String NAME="name";
	
	/**
	 * 名称 , 类型: java.lang.String
	*/
	public static final BeanProperty<com.dt.platform.domain.ops.DbFaultRcd,java.lang.String> NAME_PROP = new BeanProperty(com.dt.platform.domain.ops.DbFaultRcd.class ,NAME, java.lang.String.class, "名称", "名称", java.lang.String.class, null);
	
	/**
	 * 数据库 , 类型: java.lang.String
	*/
	public static final String DB_INSTANCE_ID="dbInstanceId";
	
	/**
	 * 数据库 , 类型: java.lang.String
	*/
	public static final BeanProperty<com.dt.platform.domain.ops.DbFaultRcd,java.lang.String> DB_INSTANCE_ID_PROP = new BeanProperty(com.dt.platform.domain.ops.DbFaultRcd.class ,DB_INSTANCE_ID, java.lang.String.class, "数据库", "数据库", java.lang.String.class, null);
	
	/**
	 * 原因 , 类型: java.lang.String
	*/
	public static final String REASON="reason";
	
	/**
	 * 原因 , 类型: java.lang.String
	*/
	public static final BeanProperty<com.dt.platform.domain.ops.DbFaultRcd,java.lang.String> REASON_PROP = new BeanProperty(com.dt.platform.domain.ops.DbFaultRcd.class ,REASON, java.lang.String.class, "原因", "原因", java.lang.String.class, null);
	
	/**
	 * 处理 , 类型: java.lang.String
	*/
	public static final String PROCESS="process";
	
	/**
	 * 处理 , 类型: java.lang.String
	*/
	public static final BeanProperty<com.dt.platform.domain.ops.DbFaultRcd,java.lang.String> PROCESS_PROP = new BeanProperty(com.dt.platform.domain.ops.DbFaultRcd.class ,PROCESS, java.lang.String.class, "处理", "处理", java.lang.String.class, null);
	
	/**
	 * 记录时间 , 类型: java.util.Date
	*/
	public static final String RCD_DATE="rcdDate";
	
	/**
	 * 记录时间 , 类型: java.util.Date
	*/
	public static final BeanProperty<com.dt.platform.domain.ops.DbFaultRcd,java.util.Date> RCD_DATE_PROP = new BeanProperty(com.dt.platform.domain.ops.DbFaultRcd.class ,RCD_DATE, java.util.Date.class, "记录时间", "记录时间", java.util.Date.class, null);
	
	/**
	 * 文件 , 类型: java.lang.String
	*/
	public static final String FILE_ID="fileId";
	
	/**
	 * 文件 , 类型: java.lang.String
	*/
	public static final BeanProperty<com.dt.platform.domain.ops.DbFaultRcd,java.lang.String> FILE_ID_PROP = new BeanProperty(com.dt.platform.domain.ops.DbFaultRcd.class ,FILE_ID, java.lang.String.class, "文件", "文件", java.lang.String.class, null);
	
	/**
	 * 备注 , 类型: java.lang.String
	*/
	public static final String NOTES="notes";
	
	/**
	 * 备注 , 类型: java.lang.String
	*/
	public static final BeanProperty<com.dt.platform.domain.ops.DbFaultRcd,java.lang.String> NOTES_PROP = new BeanProperty(com.dt.platform.domain.ops.DbFaultRcd.class ,NOTES, java.lang.String.class, "备注", "备注", java.lang.String.class, null);
	
	/**
	 * 创建人ID , 类型: java.lang.String
	*/
	public static final String CREATE_BY="createBy";
	
	/**
	 * 创建人ID , 类型: java.lang.String
	*/
	public static final BeanProperty<com.dt.platform.domain.ops.DbFaultRcd,java.lang.String> CREATE_BY_PROP = new BeanProperty(com.dt.platform.domain.ops.DbFaultRcd.class ,CREATE_BY, java.lang.String.class, "创建人ID", "创建人ID", java.lang.String.class, null);
	
	/**
	 * 创建时间 , 类型: java.util.Date
	*/
	public static final String CREATE_TIME="createTime";
	
	/**
	 * 创建时间 , 类型: java.util.Date
	*/
	public static final BeanProperty<com.dt.platform.domain.ops.DbFaultRcd,java.util.Date> CREATE_TIME_PROP = new BeanProperty(com.dt.platform.domain.ops.DbFaultRcd.class ,CREATE_TIME, java.util.Date.class, "创建时间", "创建时间", java.util.Date.class, null);
	
	/**
	 * 修改人ID , 类型: java.lang.String
	*/
	public static final String UPDATE_BY="updateBy";
	
	/**
	 * 修改人ID , 类型: java.lang.String
	*/
	public static final BeanProperty<com.dt.platform.domain.ops.DbFaultRcd,java.lang.String> UPDATE_BY_PROP = new BeanProperty(com.dt.platform.domain.ops.DbFaultRcd.class ,UPDATE_BY, java.lang.String.class, "修改人ID", "修改人ID", java.lang.String.class, null);
	
	/**
	 * 修改时间 , 类型: java.util.Date
	*/
	public static final String UPDATE_TIME="updateTime";
	
	/**
	 * 修改时间 , 类型: java.util.Date
	*/
	public static final BeanProperty<com.dt.platform.domain.ops.DbFaultRcd,java.util.Date> UPDATE_TIME_PROP = new BeanProperty(com.dt.platform.domain.ops.DbFaultRcd.class ,UPDATE_TIME, java.util.Date.class, "修改时间", "修改时间", java.util.Date.class, null);
	
	/**
	 * 是否已删除 , 类型: java.lang.Integer
	*/
	public static final String DELETED="deleted";
	
	/**
	 * 是否已删除 , 类型: java.lang.Integer
	*/
	public static final BeanProperty<com.dt.platform.domain.ops.DbFaultRcd,java.lang.Integer> DELETED_PROP = new BeanProperty(com.dt.platform.domain.ops.DbFaultRcd.class ,DELETED, java.lang.Integer.class, "是否已删除", "是否已删除", java.lang.Integer.class, null);
	
	/**
	 * 删除人ID , 类型: java.lang.String
	*/
	public static final String DELETE_BY="deleteBy";
	
	/**
	 * 删除人ID , 类型: java.lang.String
	*/
	public static final BeanProperty<com.dt.platform.domain.ops.DbFaultRcd,java.lang.String> DELETE_BY_PROP = new BeanProperty(com.dt.platform.domain.ops.DbFaultRcd.class ,DELETE_BY, java.lang.String.class, "删除人ID", "删除人ID", java.lang.String.class, null);
	
	/**
	 * 删除时间 , 类型: java.util.Date
	*/
	public static final String DELETE_TIME="deleteTime";
	
	/**
	 * 删除时间 , 类型: java.util.Date
	*/
	public static final BeanProperty<com.dt.platform.domain.ops.DbFaultRcd,java.util.Date> DELETE_TIME_PROP = new BeanProperty(com.dt.platform.domain.ops.DbFaultRcd.class ,DELETE_TIME, java.util.Date.class, "删除时间", "删除时间", java.util.Date.class, null);
	
	/**
	 * version , 类型: java.lang.Integer
	*/
	public static final String VERSION="version";
	
	/**
	 * version , 类型: java.lang.Integer
	*/
	public static final BeanProperty<com.dt.platform.domain.ops.DbFaultRcd,java.lang.Integer> VERSION_PROP = new BeanProperty(com.dt.platform.domain.ops.DbFaultRcd.class ,VERSION, java.lang.Integer.class, "version", "version", java.lang.Integer.class, null);
	
	/**
	 * 租户 , 类型: java.lang.String
	*/
	public static final String TENANT_ID="tenantId";
	
	/**
	 * 租户 , 类型: java.lang.String
	*/
	public static final BeanProperty<com.dt.platform.domain.ops.DbFaultRcd,java.lang.String> TENANT_ID_PROP = new BeanProperty(com.dt.platform.domain.ops.DbFaultRcd.class ,TENANT_ID, java.lang.String.class, "租户", "租户", java.lang.String.class, null);
	
	/**
	 * dbInstance , 类型: com.dt.platform.domain.ops.DbInstance
	*/
	public static final String DB_INSTANCE="dbInstance";
	
	/**
	 * dbInstance , 类型: com.dt.platform.domain.ops.DbInstance
	*/
	public static final BeanProperty<com.dt.platform.domain.ops.DbFaultRcd,com.dt.platform.domain.ops.DbInstance> DB_INSTANCE_PROP = new BeanProperty(com.dt.platform.domain.ops.DbFaultRcd.class ,DB_INSTANCE, com.dt.platform.domain.ops.DbInstance.class, "dbInstance", "dbInstance", com.dt.platform.domain.ops.DbInstance.class, null);
	
	/**
	 * 全部属性清单
	*/
	public static final String[] $PROPS={ ID , NAME , DB_INSTANCE_ID , REASON , PROCESS , RCD_DATE , FILE_ID , NOTES , CREATE_BY , CREATE_TIME , UPDATE_BY , UPDATE_TIME , DELETED , DELETE_BY , DELETE_TIME , VERSION , TENANT_ID , DB_INSTANCE };
	
	/**
	 * 代理类
	*/
	public static class $$proxy$$ extends com.dt.platform.domain.ops.DbFaultRcd {

		private static final long serialVersionUID = 1L;

		
		/**
		 * 设置 主键
		 * @param id 主键
		 * @return 当前对象
		*/
		public DbFaultRcd setId(String id) {
			super.change(ID,super.getId(),id);
			super.setId(id);
			return this;
		}
		
		/**
		 * 设置 名称
		 * @param name 名称
		 * @return 当前对象
		*/
		public DbFaultRcd setName(String name) {
			super.change(NAME,super.getName(),name);
			super.setName(name);
			return this;
		}
		
		/**
		 * 设置 数据库
		 * @param dbInstanceId 数据库
		 * @return 当前对象
		*/
		public DbFaultRcd setDbInstanceId(String dbInstanceId) {
			super.change(DB_INSTANCE_ID,super.getDbInstanceId(),dbInstanceId);
			super.setDbInstanceId(dbInstanceId);
			return this;
		}
		
		/**
		 * 设置 原因
		 * @param reason 原因
		 * @return 当前对象
		*/
		public DbFaultRcd setReason(String reason) {
			super.change(REASON,super.getReason(),reason);
			super.setReason(reason);
			return this;
		}
		
		/**
		 * 设置 处理
		 * @param process 处理
		 * @return 当前对象
		*/
		public DbFaultRcd setProcess(String process) {
			super.change(PROCESS,super.getProcess(),process);
			super.setProcess(process);
			return this;
		}
		
		/**
		 * 设置 记录时间
		 * @param rcdDate 记录时间
		 * @return 当前对象
		*/
		public DbFaultRcd setRcdDate(Date rcdDate) {
			super.change(RCD_DATE,super.getRcdDate(),rcdDate);
			super.setRcdDate(rcdDate);
			return this;
		}
		
		/**
		 * 设置 文件
		 * @param fileId 文件
		 * @return 当前对象
		*/
		public DbFaultRcd setFileId(String fileId) {
			super.change(FILE_ID,super.getFileId(),fileId);
			super.setFileId(fileId);
			return this;
		}
		
		/**
		 * 设置 备注
		 * @param notes 备注
		 * @return 当前对象
		*/
		public DbFaultRcd setNotes(String notes) {
			super.change(NOTES,super.getNotes(),notes);
			super.setNotes(notes);
			return this;
		}
		
		/**
		 * 设置 创建人ID
		 * @param createBy 创建人ID
		 * @return 当前对象
		*/
		public DbFaultRcd setCreateBy(String createBy) {
			super.change(CREATE_BY,super.getCreateBy(),createBy);
			super.setCreateBy(createBy);
			return this;
		}
		
		/**
		 * 设置 创建时间
		 * @param createTime 创建时间
		 * @return 当前对象
		*/
		public DbFaultRcd setCreateTime(Date createTime) {
			super.change(CREATE_TIME,super.getCreateTime(),createTime);
			super.setCreateTime(createTime);
			return this;
		}
		
		/**
		 * 设置 修改人ID
		 * @param updateBy 修改人ID
		 * @return 当前对象
		*/
		public DbFaultRcd setUpdateBy(String updateBy) {
			super.change(UPDATE_BY,super.getUpdateBy(),updateBy);
			super.setUpdateBy(updateBy);
			return this;
		}
		
		/**
		 * 设置 修改时间
		 * @param updateTime 修改时间
		 * @return 当前对象
		*/
		public DbFaultRcd setUpdateTime(Date updateTime) {
			super.change(UPDATE_TIME,super.getUpdateTime(),updateTime);
			super.setUpdateTime(updateTime);
			return this;
		}
		
		/**
		 * 设置 是否已删除
		 * @param deleted 是否已删除
		 * @return 当前对象
		*/
		public DbFaultRcd setDeleted(Integer deleted) {
			super.change(DELETED,super.getDeleted(),deleted);
			super.setDeleted(deleted);
			return this;
		}
		
		/**
		 * 设置 删除人ID
		 * @param deleteBy 删除人ID
		 * @return 当前对象
		*/
		public DbFaultRcd setDeleteBy(String deleteBy) {
			super.change(DELETE_BY,super.getDeleteBy(),deleteBy);
			super.setDeleteBy(deleteBy);
			return this;
		}
		
		/**
		 * 设置 删除时间
		 * @param deleteTime 删除时间
		 * @return 当前对象
		*/
		public DbFaultRcd setDeleteTime(Date deleteTime) {
			super.change(DELETE_TIME,super.getDeleteTime(),deleteTime);
			super.setDeleteTime(deleteTime);
			return this;
		}
		
		/**
		 * 设置 version
		 * @param version version
		 * @return 当前对象
		*/
		public DbFaultRcd setVersion(Integer version) {
			super.change(VERSION,super.getVersion(),version);
			super.setVersion(version);
			return this;
		}
		
		/**
		 * 设置 租户
		 * @param tenantId 租户
		 * @return 当前对象
		*/
		public DbFaultRcd setTenantId(String tenantId) {
			super.change(TENANT_ID,super.getTenantId(),tenantId);
			super.setTenantId(tenantId);
			return this;
		}
		
		/**
		 * 设置 dbInstance
		 * @param dbInstance dbInstance
		 * @return 当前对象
		*/
		public DbFaultRcd setDbInstance(DbInstance dbInstance) {
			super.change(DB_INSTANCE,super.getDbInstance(),dbInstance);
			super.setDbInstance(dbInstance);
			return this;
		}

		/**
		 * 克隆当前对象
		*/
		@Transient
		public DbFaultRcd clone() {
			return duplicate(true);
		}

		/**
		 * 复制当前对象
		 * @param all 是否复制全部属性，当 false 时，仅复制来自数据表的属性
		*/
		@Transient
		public DbFaultRcd duplicate(boolean all) {
			$$proxy$$ inst=new $$proxy$$();
			inst.setReason(this.getReason());
			inst.setProcess(this.getProcess());
			inst.setNotes(this.getNotes());
			inst.setDbInstanceId(this.getDbInstanceId());
			inst.setUpdateTime(this.getUpdateTime());
			inst.setVersion(this.getVersion());
			inst.setCreateBy(this.getCreateBy());
			inst.setDeleted(this.getDeleted());
			inst.setCreateTime(this.getCreateTime());
			inst.setUpdateBy(this.getUpdateBy());
			inst.setDeleteTime(this.getDeleteTime());
			inst.setRcdDate(this.getRcdDate());
			inst.setName(this.getName());
			inst.setTenantId(this.getTenantId());
			inst.setDeleteBy(this.getDeleteBy());
			inst.setId(this.getId());
			inst.setFileId(this.getFileId());
			if(all) {
				inst.setDbInstance(this.getDbInstance());
			}
			inst.clearModifies();
			return inst;
		}

	}
}