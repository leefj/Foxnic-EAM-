package com.dt.platform.domain.oa.meta;

import com.github.foxnic.api.bean.BeanProperty;
import com.dt.platform.domain.oa.NetdiskOperRecord;
import java.util.Date;
import org.github.foxnic.web.domain.hrm.Employee;
import javax.persistence.Transient;



/**
 * @author 金杰 , maillank@qq.com
 * @since 2023-09-30 10:52:17
 * @sign 18EDA62D0F7C46D56923851479C99B0F
 * 此文件由工具自动生成，请勿修改。若表结构或配置发生变动，请使用工具重新生成。
*/

public class NetdiskOperRecordMeta {
	
	/**
	 * 主键 , 类型: java.lang.String
	*/
	public static final String ID="id";
	
	/**
	 * 主键 , 类型: java.lang.String
	*/
	public static final BeanProperty<com.dt.platform.domain.oa.NetdiskOperRecord,java.lang.String> ID_PROP = new BeanProperty(com.dt.platform.domain.oa.NetdiskOperRecord.class ,ID, java.lang.String.class, "主键", "主键", java.lang.String.class, null);
	
	/**
	 * 对象 , 类型: java.lang.String
	*/
	public static final String FD_ID="fdId";
	
	/**
	 * 对象 , 类型: java.lang.String
	*/
	public static final BeanProperty<com.dt.platform.domain.oa.NetdiskOperRecord,java.lang.String> FD_ID_PROP = new BeanProperty(com.dt.platform.domain.oa.NetdiskOperRecord.class ,FD_ID, java.lang.String.class, "对象", "对象", java.lang.String.class, null);
	
	/**
	 * 对象类型 , 类型: java.lang.String
	*/
	public static final String FD_TYPE="fdType";
	
	/**
	 * 对象类型 , 类型: java.lang.String
	*/
	public static final BeanProperty<com.dt.platform.domain.oa.NetdiskOperRecord,java.lang.String> FD_TYPE_PROP = new BeanProperty(com.dt.platform.domain.oa.NetdiskOperRecord.class ,FD_TYPE, java.lang.String.class, "对象类型", "对象类型", java.lang.String.class, null);
	
	/**
	 * 操作内容 , 类型: java.lang.String
	*/
	public static final String OPER_CONTENT="operContent";
	
	/**
	 * 操作内容 , 类型: java.lang.String
	*/
	public static final BeanProperty<com.dt.platform.domain.oa.NetdiskOperRecord,java.lang.String> OPER_CONTENT_PROP = new BeanProperty(com.dt.platform.domain.oa.NetdiskOperRecord.class ,OPER_CONTENT, java.lang.String.class, "操作内容", "操作内容", java.lang.String.class, null);
	
	/**
	 * 操作人 , 类型: java.lang.String
	*/
	public static final String OPER_USER_ID="operUserId";
	
	/**
	 * 操作人 , 类型: java.lang.String
	*/
	public static final BeanProperty<com.dt.platform.domain.oa.NetdiskOperRecord,java.lang.String> OPER_USER_ID_PROP = new BeanProperty(com.dt.platform.domain.oa.NetdiskOperRecord.class ,OPER_USER_ID, java.lang.String.class, "操作人", "操作人", java.lang.String.class, null);
	
	/**
	 * 操作时间 , 类型: java.util.Date
	*/
	public static final String OPER_TIME="operTime";
	
	/**
	 * 操作时间 , 类型: java.util.Date
	*/
	public static final BeanProperty<com.dt.platform.domain.oa.NetdiskOperRecord,java.util.Date> OPER_TIME_PROP = new BeanProperty(com.dt.platform.domain.oa.NetdiskOperRecord.class ,OPER_TIME, java.util.Date.class, "操作时间", "操作时间", java.util.Date.class, null);
	
	/**
	 * 版本 , 类型: java.lang.Integer
	*/
	public static final String VERSION="version";
	
	/**
	 * 版本 , 类型: java.lang.Integer
	*/
	public static final BeanProperty<com.dt.platform.domain.oa.NetdiskOperRecord,java.lang.Integer> VERSION_PROP = new BeanProperty(com.dt.platform.domain.oa.NetdiskOperRecord.class ,VERSION, java.lang.Integer.class, "版本", "版本", java.lang.Integer.class, null);
	
	/**
	 * 创建人ID , 类型: java.lang.String
	*/
	public static final String CREATE_BY="createBy";
	
	/**
	 * 创建人ID , 类型: java.lang.String
	*/
	public static final BeanProperty<com.dt.platform.domain.oa.NetdiskOperRecord,java.lang.String> CREATE_BY_PROP = new BeanProperty(com.dt.platform.domain.oa.NetdiskOperRecord.class ,CREATE_BY, java.lang.String.class, "创建人ID", "创建人ID", java.lang.String.class, null);
	
	/**
	 * 创建时间 , 类型: java.util.Date
	*/
	public static final String CREATE_TIME="createTime";
	
	/**
	 * 创建时间 , 类型: java.util.Date
	*/
	public static final BeanProperty<com.dt.platform.domain.oa.NetdiskOperRecord,java.util.Date> CREATE_TIME_PROP = new BeanProperty(com.dt.platform.domain.oa.NetdiskOperRecord.class ,CREATE_TIME, java.util.Date.class, "创建时间", "创建时间", java.util.Date.class, null);
	
	/**
	 * 修改人ID , 类型: java.lang.String
	*/
	public static final String UPDATE_BY="updateBy";
	
	/**
	 * 修改人ID , 类型: java.lang.String
	*/
	public static final BeanProperty<com.dt.platform.domain.oa.NetdiskOperRecord,java.lang.String> UPDATE_BY_PROP = new BeanProperty(com.dt.platform.domain.oa.NetdiskOperRecord.class ,UPDATE_BY, java.lang.String.class, "修改人ID", "修改人ID", java.lang.String.class, null);
	
	/**
	 * 修改时间 , 类型: java.util.Date
	*/
	public static final String UPDATE_TIME="updateTime";
	
	/**
	 * 修改时间 , 类型: java.util.Date
	*/
	public static final BeanProperty<com.dt.platform.domain.oa.NetdiskOperRecord,java.util.Date> UPDATE_TIME_PROP = new BeanProperty(com.dt.platform.domain.oa.NetdiskOperRecord.class ,UPDATE_TIME, java.util.Date.class, "修改时间", "修改时间", java.util.Date.class, null);
	
	/**
	 * 是否已删除 , 类型: java.lang.Integer
	*/
	public static final String DELETED="deleted";
	
	/**
	 * 是否已删除 , 类型: java.lang.Integer
	*/
	public static final BeanProperty<com.dt.platform.domain.oa.NetdiskOperRecord,java.lang.Integer> DELETED_PROP = new BeanProperty(com.dt.platform.domain.oa.NetdiskOperRecord.class ,DELETED, java.lang.Integer.class, "是否已删除", "是否已删除", java.lang.Integer.class, null);
	
	/**
	 * 删除人ID , 类型: java.lang.String
	*/
	public static final String DELETE_BY="deleteBy";
	
	/**
	 * 删除人ID , 类型: java.lang.String
	*/
	public static final BeanProperty<com.dt.platform.domain.oa.NetdiskOperRecord,java.lang.String> DELETE_BY_PROP = new BeanProperty(com.dt.platform.domain.oa.NetdiskOperRecord.class ,DELETE_BY, java.lang.String.class, "删除人ID", "删除人ID", java.lang.String.class, null);
	
	/**
	 * 删除时间 , 类型: java.util.Date
	*/
	public static final String DELETE_TIME="deleteTime";
	
	/**
	 * 删除时间 , 类型: java.util.Date
	*/
	public static final BeanProperty<com.dt.platform.domain.oa.NetdiskOperRecord,java.util.Date> DELETE_TIME_PROP = new BeanProperty(com.dt.platform.domain.oa.NetdiskOperRecord.class ,DELETE_TIME, java.util.Date.class, "删除时间", "删除时间", java.util.Date.class, null);
	
	/**
	 * 租户 , 类型: java.lang.String
	*/
	public static final String TENANT_ID="tenantId";
	
	/**
	 * 租户 , 类型: java.lang.String
	*/
	public static final BeanProperty<com.dt.platform.domain.oa.NetdiskOperRecord,java.lang.String> TENANT_ID_PROP = new BeanProperty(com.dt.platform.domain.oa.NetdiskOperRecord.class ,TENANT_ID, java.lang.String.class, "租户", "租户", java.lang.String.class, null);
	
	/**
	 * user , 类型: org.github.foxnic.web.domain.hrm.Employee
	*/
	public static final String USER="user";
	
	/**
	 * user , 类型: org.github.foxnic.web.domain.hrm.Employee
	*/
	public static final BeanProperty<com.dt.platform.domain.oa.NetdiskOperRecord,org.github.foxnic.web.domain.hrm.Employee> USER_PROP = new BeanProperty(com.dt.platform.domain.oa.NetdiskOperRecord.class ,USER, org.github.foxnic.web.domain.hrm.Employee.class, "user", "user", org.github.foxnic.web.domain.hrm.Employee.class, null);
	
	/**
	 * 全部属性清单
	*/
	public static final String[] $PROPS={ ID , FD_ID , FD_TYPE , OPER_CONTENT , OPER_USER_ID , OPER_TIME , VERSION , CREATE_BY , CREATE_TIME , UPDATE_BY , UPDATE_TIME , DELETED , DELETE_BY , DELETE_TIME , TENANT_ID , USER };
	
	/**
	 * 代理类
	*/
	public static class $$proxy$$ extends com.dt.platform.domain.oa.NetdiskOperRecord {

		private static final long serialVersionUID = 1L;

		
		/**
		 * 设置 主键
		 * @param id 主键
		 * @return 当前对象
		*/
		public NetdiskOperRecord setId(String id) {
			super.change(ID,super.getId(),id);
			super.setId(id);
			return this;
		}
		
		/**
		 * 设置 对象
		 * @param fdId 对象
		 * @return 当前对象
		*/
		public NetdiskOperRecord setFdId(String fdId) {
			super.change(FD_ID,super.getFdId(),fdId);
			super.setFdId(fdId);
			return this;
		}
		
		/**
		 * 设置 对象类型
		 * @param fdType 对象类型
		 * @return 当前对象
		*/
		public NetdiskOperRecord setFdType(String fdType) {
			super.change(FD_TYPE,super.getFdType(),fdType);
			super.setFdType(fdType);
			return this;
		}
		
		/**
		 * 设置 操作内容
		 * @param operContent 操作内容
		 * @return 当前对象
		*/
		public NetdiskOperRecord setOperContent(String operContent) {
			super.change(OPER_CONTENT,super.getOperContent(),operContent);
			super.setOperContent(operContent);
			return this;
		}
		
		/**
		 * 设置 操作人
		 * @param operUserId 操作人
		 * @return 当前对象
		*/
		public NetdiskOperRecord setOperUserId(String operUserId) {
			super.change(OPER_USER_ID,super.getOperUserId(),operUserId);
			super.setOperUserId(operUserId);
			return this;
		}
		
		/**
		 * 设置 操作时间
		 * @param operTime 操作时间
		 * @return 当前对象
		*/
		public NetdiskOperRecord setOperTime(Date operTime) {
			super.change(OPER_TIME,super.getOperTime(),operTime);
			super.setOperTime(operTime);
			return this;
		}
		
		/**
		 * 设置 版本
		 * @param version 版本
		 * @return 当前对象
		*/
		public NetdiskOperRecord setVersion(Integer version) {
			super.change(VERSION,super.getVersion(),version);
			super.setVersion(version);
			return this;
		}
		
		/**
		 * 设置 创建人ID
		 * @param createBy 创建人ID
		 * @return 当前对象
		*/
		public NetdiskOperRecord setCreateBy(String createBy) {
			super.change(CREATE_BY,super.getCreateBy(),createBy);
			super.setCreateBy(createBy);
			return this;
		}
		
		/**
		 * 设置 创建时间
		 * @param createTime 创建时间
		 * @return 当前对象
		*/
		public NetdiskOperRecord setCreateTime(Date createTime) {
			super.change(CREATE_TIME,super.getCreateTime(),createTime);
			super.setCreateTime(createTime);
			return this;
		}
		
		/**
		 * 设置 修改人ID
		 * @param updateBy 修改人ID
		 * @return 当前对象
		*/
		public NetdiskOperRecord setUpdateBy(String updateBy) {
			super.change(UPDATE_BY,super.getUpdateBy(),updateBy);
			super.setUpdateBy(updateBy);
			return this;
		}
		
		/**
		 * 设置 修改时间
		 * @param updateTime 修改时间
		 * @return 当前对象
		*/
		public NetdiskOperRecord setUpdateTime(Date updateTime) {
			super.change(UPDATE_TIME,super.getUpdateTime(),updateTime);
			super.setUpdateTime(updateTime);
			return this;
		}
		
		/**
		 * 设置 是否已删除
		 * @param deleted 是否已删除
		 * @return 当前对象
		*/
		public NetdiskOperRecord setDeleted(Integer deleted) {
			super.change(DELETED,super.getDeleted(),deleted);
			super.setDeleted(deleted);
			return this;
		}
		
		/**
		 * 设置 删除人ID
		 * @param deleteBy 删除人ID
		 * @return 当前对象
		*/
		public NetdiskOperRecord setDeleteBy(String deleteBy) {
			super.change(DELETE_BY,super.getDeleteBy(),deleteBy);
			super.setDeleteBy(deleteBy);
			return this;
		}
		
		/**
		 * 设置 删除时间
		 * @param deleteTime 删除时间
		 * @return 当前对象
		*/
		public NetdiskOperRecord setDeleteTime(Date deleteTime) {
			super.change(DELETE_TIME,super.getDeleteTime(),deleteTime);
			super.setDeleteTime(deleteTime);
			return this;
		}
		
		/**
		 * 设置 租户
		 * @param tenantId 租户
		 * @return 当前对象
		*/
		public NetdiskOperRecord setTenantId(String tenantId) {
			super.change(TENANT_ID,super.getTenantId(),tenantId);
			super.setTenantId(tenantId);
			return this;
		}
		
		/**
		 * 设置 user
		 * @param user user
		 * @return 当前对象
		*/
		public NetdiskOperRecord setUser(Employee user) {
			super.change(USER,super.getUser(),user);
			super.setUser(user);
			return this;
		}

		/**
		 * 克隆当前对象
		*/
		@Transient
		public NetdiskOperRecord clone() {
			return duplicate(true);
		}

		/**
		 * 复制当前对象
		 * @param all 是否复制全部属性，当 false 时，仅复制来自数据表的属性
		*/
		@Transient
		public NetdiskOperRecord duplicate(boolean all) {
			$$proxy$$ inst=new $$proxy$$();
			inst.setOperUserId(this.getOperUserId());
			inst.setUpdateTime(this.getUpdateTime());
			inst.setOperContent(this.getOperContent());
			inst.setVersion(this.getVersion());
			inst.setFdType(this.getFdType());
			inst.setCreateBy(this.getCreateBy());
			inst.setDeleted(this.getDeleted());
			inst.setCreateTime(this.getCreateTime());
			inst.setUpdateBy(this.getUpdateBy());
			inst.setDeleteTime(this.getDeleteTime());
			inst.setFdId(this.getFdId());
			inst.setTenantId(this.getTenantId());
			inst.setDeleteBy(this.getDeleteBy());
			inst.setId(this.getId());
			inst.setOperTime(this.getOperTime());
			if(all) {
				inst.setUser(this.getUser());
			}
			inst.clearModifies();
			return inst;
		}

	}
}