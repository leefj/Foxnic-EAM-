package com.dt.platform.domain.common.meta;

import com.github.foxnic.api.bean.BeanProperty;
import com.dt.platform.domain.common.ScreenDsDb;
import java.util.Date;
import javax.persistence.Transient;



/**
 * @author 金杰 , maillank@qq.com
 * @since 2023-10-28 07:56:44
 * @sign 1DF2C582AEC754E6D4DB593BC81CC9F3
 * 此文件由工具自动生成，请勿修改。若表结构或配置发生变动，请使用工具重新生成。
*/

public class ScreenDsDbMeta {
	
	/**
	 * 主键 , 类型: java.lang.String
	*/
	public static final String ID="id";
	
	/**
	 * 主键 , 类型: java.lang.String
	*/
	public static final BeanProperty<com.dt.platform.domain.common.ScreenDsDb,java.lang.String> ID_PROP = new BeanProperty(com.dt.platform.domain.common.ScreenDsDb.class ,ID, java.lang.String.class, "主键", "主键", java.lang.String.class, null);
	
	/**
	 * 名称 , 类型: java.lang.String
	*/
	public static final String NAME="name";
	
	/**
	 * 名称 , 类型: java.lang.String
	*/
	public static final BeanProperty<com.dt.platform.domain.common.ScreenDsDb,java.lang.String> NAME_PROP = new BeanProperty(com.dt.platform.domain.common.ScreenDsDb.class ,NAME, java.lang.String.class, "名称", "名称", java.lang.String.class, null);
	
	/**
	 * 类型 , system|user , 类型: java.lang.String
	*/
	public static final String TYPE="type";
	
	/**
	 * 类型 , system|user , 类型: java.lang.String
	*/
	public static final BeanProperty<com.dt.platform.domain.common.ScreenDsDb,java.lang.String> TYPE_PROP = new BeanProperty(com.dt.platform.domain.common.ScreenDsDb.class ,TYPE, java.lang.String.class, "类型", "system|user", java.lang.String.class, null);
	
	/**
	 * 数据库类型 , 类型: java.lang.String
	*/
	public static final String DS_TYPE="dsType";
	
	/**
	 * 数据库类型 , 类型: java.lang.String
	*/
	public static final BeanProperty<com.dt.platform.domain.common.ScreenDsDb,java.lang.String> DS_TYPE_PROP = new BeanProperty(com.dt.platform.domain.common.ScreenDsDb.class ,DS_TYPE, java.lang.String.class, "数据库类型", "数据库类型", java.lang.String.class, null);
	
	/**
	 * 账户 , 类型: java.lang.String
	*/
	public static final String USER="user";
	
	/**
	 * 账户 , 类型: java.lang.String
	*/
	public static final BeanProperty<com.dt.platform.domain.common.ScreenDsDb,java.lang.String> USER_PROP = new BeanProperty(com.dt.platform.domain.common.ScreenDsDb.class ,USER, java.lang.String.class, "账户", "账户", java.lang.String.class, null);
	
	/**
	 * 密码 , 类型: java.lang.String
	*/
	public static final String PWD="pwd";
	
	/**
	 * 密码 , 类型: java.lang.String
	*/
	public static final BeanProperty<com.dt.platform.domain.common.ScreenDsDb,java.lang.String> PWD_PROP = new BeanProperty(com.dt.platform.domain.common.ScreenDsDb.class ,PWD, java.lang.String.class, "密码", "密码", java.lang.String.class, null);
	
	/**
	 * uri , 类型: java.lang.String
	*/
	public static final String URI="uri";
	
	/**
	 * uri , 类型: java.lang.String
	*/
	public static final BeanProperty<com.dt.platform.domain.common.ScreenDsDb,java.lang.String> URI_PROP = new BeanProperty(com.dt.platform.domain.common.ScreenDsDb.class ,URI, java.lang.String.class, "uri", "uri", java.lang.String.class, null);
	
	/**
	 * 备注 , 类型: java.lang.String
	*/
	public static final String NOTES="notes";
	
	/**
	 * 备注 , 类型: java.lang.String
	*/
	public static final BeanProperty<com.dt.platform.domain.common.ScreenDsDb,java.lang.String> NOTES_PROP = new BeanProperty(com.dt.platform.domain.common.ScreenDsDb.class ,NOTES, java.lang.String.class, "备注", "备注", java.lang.String.class, null);
	
	/**
	 * 创建人ID , 类型: java.lang.String
	*/
	public static final String CREATE_BY="createBy";
	
	/**
	 * 创建人ID , 类型: java.lang.String
	*/
	public static final BeanProperty<com.dt.platform.domain.common.ScreenDsDb,java.lang.String> CREATE_BY_PROP = new BeanProperty(com.dt.platform.domain.common.ScreenDsDb.class ,CREATE_BY, java.lang.String.class, "创建人ID", "创建人ID", java.lang.String.class, null);
	
	/**
	 * 创建时间 , 类型: java.util.Date
	*/
	public static final String CREATE_TIME="createTime";
	
	/**
	 * 创建时间 , 类型: java.util.Date
	*/
	public static final BeanProperty<com.dt.platform.domain.common.ScreenDsDb,java.util.Date> CREATE_TIME_PROP = new BeanProperty(com.dt.platform.domain.common.ScreenDsDb.class ,CREATE_TIME, java.util.Date.class, "创建时间", "创建时间", java.util.Date.class, null);
	
	/**
	 * 修改人ID , 类型: java.lang.String
	*/
	public static final String UPDATE_BY="updateBy";
	
	/**
	 * 修改人ID , 类型: java.lang.String
	*/
	public static final BeanProperty<com.dt.platform.domain.common.ScreenDsDb,java.lang.String> UPDATE_BY_PROP = new BeanProperty(com.dt.platform.domain.common.ScreenDsDb.class ,UPDATE_BY, java.lang.String.class, "修改人ID", "修改人ID", java.lang.String.class, null);
	
	/**
	 * 修改时间 , 类型: java.util.Date
	*/
	public static final String UPDATE_TIME="updateTime";
	
	/**
	 * 修改时间 , 类型: java.util.Date
	*/
	public static final BeanProperty<com.dt.platform.domain.common.ScreenDsDb,java.util.Date> UPDATE_TIME_PROP = new BeanProperty(com.dt.platform.domain.common.ScreenDsDb.class ,UPDATE_TIME, java.util.Date.class, "修改时间", "修改时间", java.util.Date.class, null);
	
	/**
	 * 是否已删除 , 类型: java.lang.Integer
	*/
	public static final String DELETED="deleted";
	
	/**
	 * 是否已删除 , 类型: java.lang.Integer
	*/
	public static final BeanProperty<com.dt.platform.domain.common.ScreenDsDb,java.lang.Integer> DELETED_PROP = new BeanProperty(com.dt.platform.domain.common.ScreenDsDb.class ,DELETED, java.lang.Integer.class, "是否已删除", "是否已删除", java.lang.Integer.class, null);
	
	/**
	 * 删除人ID , 类型: java.lang.String
	*/
	public static final String DELETE_BY="deleteBy";
	
	/**
	 * 删除人ID , 类型: java.lang.String
	*/
	public static final BeanProperty<com.dt.platform.domain.common.ScreenDsDb,java.lang.String> DELETE_BY_PROP = new BeanProperty(com.dt.platform.domain.common.ScreenDsDb.class ,DELETE_BY, java.lang.String.class, "删除人ID", "删除人ID", java.lang.String.class, null);
	
	/**
	 * 删除时间 , 类型: java.util.Date
	*/
	public static final String DELETE_TIME="deleteTime";
	
	/**
	 * 删除时间 , 类型: java.util.Date
	*/
	public static final BeanProperty<com.dt.platform.domain.common.ScreenDsDb,java.util.Date> DELETE_TIME_PROP = new BeanProperty(com.dt.platform.domain.common.ScreenDsDb.class ,DELETE_TIME, java.util.Date.class, "删除时间", "删除时间", java.util.Date.class, null);
	
	/**
	 * version , 类型: java.lang.Integer
	*/
	public static final String VERSION="version";
	
	/**
	 * version , 类型: java.lang.Integer
	*/
	public static final BeanProperty<com.dt.platform.domain.common.ScreenDsDb,java.lang.Integer> VERSION_PROP = new BeanProperty(com.dt.platform.domain.common.ScreenDsDb.class ,VERSION, java.lang.Integer.class, "version", "version", java.lang.Integer.class, null);
	
	/**
	 * 租户 , 类型: java.lang.String
	*/
	public static final String TENANT_ID="tenantId";
	
	/**
	 * 租户 , 类型: java.lang.String
	*/
	public static final BeanProperty<com.dt.platform.domain.common.ScreenDsDb,java.lang.String> TENANT_ID_PROP = new BeanProperty(com.dt.platform.domain.common.ScreenDsDb.class ,TENANT_ID, java.lang.String.class, "租户", "租户", java.lang.String.class, null);
	
	/**
	 * 全部属性清单
	*/
	public static final String[] $PROPS={ ID , NAME , TYPE , DS_TYPE , USER , PWD , URI , NOTES , CREATE_BY , CREATE_TIME , UPDATE_BY , UPDATE_TIME , DELETED , DELETE_BY , DELETE_TIME , VERSION , TENANT_ID };
	
	/**
	 * 代理类
	*/
	public static class $$proxy$$ extends com.dt.platform.domain.common.ScreenDsDb {

		private static final long serialVersionUID = 1L;

		
		/**
		 * 设置 主键
		 * @param id 主键
		 * @return 当前对象
		*/
		public ScreenDsDb setId(String id) {
			super.change(ID,super.getId(),id);
			super.setId(id);
			return this;
		}
		
		/**
		 * 设置 名称
		 * @param name 名称
		 * @return 当前对象
		*/
		public ScreenDsDb setName(String name) {
			super.change(NAME,super.getName(),name);
			super.setName(name);
			return this;
		}
		
		/**
		 * 设置 类型
		 * @param type 类型
		 * @return 当前对象
		*/
		public ScreenDsDb setType(String type) {
			super.change(TYPE,super.getType(),type);
			super.setType(type);
			return this;
		}
		
		/**
		 * 设置 数据库类型
		 * @param dsType 数据库类型
		 * @return 当前对象
		*/
		public ScreenDsDb setDsType(String dsType) {
			super.change(DS_TYPE,super.getDsType(),dsType);
			super.setDsType(dsType);
			return this;
		}
		
		/**
		 * 设置 账户
		 * @param user 账户
		 * @return 当前对象
		*/
		public ScreenDsDb setUser(String user) {
			super.change(USER,super.getUser(),user);
			super.setUser(user);
			return this;
		}
		
		/**
		 * 设置 密码
		 * @param pwd 密码
		 * @return 当前对象
		*/
		public ScreenDsDb setPwd(String pwd) {
			super.change(PWD,super.getPwd(),pwd);
			super.setPwd(pwd);
			return this;
		}
		
		/**
		 * 设置 uri
		 * @param uri uri
		 * @return 当前对象
		*/
		public ScreenDsDb setUri(String uri) {
			super.change(URI,super.getUri(),uri);
			super.setUri(uri);
			return this;
		}
		
		/**
		 * 设置 备注
		 * @param notes 备注
		 * @return 当前对象
		*/
		public ScreenDsDb setNotes(String notes) {
			super.change(NOTES,super.getNotes(),notes);
			super.setNotes(notes);
			return this;
		}
		
		/**
		 * 设置 创建人ID
		 * @param createBy 创建人ID
		 * @return 当前对象
		*/
		public ScreenDsDb setCreateBy(String createBy) {
			super.change(CREATE_BY,super.getCreateBy(),createBy);
			super.setCreateBy(createBy);
			return this;
		}
		
		/**
		 * 设置 创建时间
		 * @param createTime 创建时间
		 * @return 当前对象
		*/
		public ScreenDsDb setCreateTime(Date createTime) {
			super.change(CREATE_TIME,super.getCreateTime(),createTime);
			super.setCreateTime(createTime);
			return this;
		}
		
		/**
		 * 设置 修改人ID
		 * @param updateBy 修改人ID
		 * @return 当前对象
		*/
		public ScreenDsDb setUpdateBy(String updateBy) {
			super.change(UPDATE_BY,super.getUpdateBy(),updateBy);
			super.setUpdateBy(updateBy);
			return this;
		}
		
		/**
		 * 设置 修改时间
		 * @param updateTime 修改时间
		 * @return 当前对象
		*/
		public ScreenDsDb setUpdateTime(Date updateTime) {
			super.change(UPDATE_TIME,super.getUpdateTime(),updateTime);
			super.setUpdateTime(updateTime);
			return this;
		}
		
		/**
		 * 设置 是否已删除
		 * @param deleted 是否已删除
		 * @return 当前对象
		*/
		public ScreenDsDb setDeleted(Integer deleted) {
			super.change(DELETED,super.getDeleted(),deleted);
			super.setDeleted(deleted);
			return this;
		}
		
		/**
		 * 设置 删除人ID
		 * @param deleteBy 删除人ID
		 * @return 当前对象
		*/
		public ScreenDsDb setDeleteBy(String deleteBy) {
			super.change(DELETE_BY,super.getDeleteBy(),deleteBy);
			super.setDeleteBy(deleteBy);
			return this;
		}
		
		/**
		 * 设置 删除时间
		 * @param deleteTime 删除时间
		 * @return 当前对象
		*/
		public ScreenDsDb setDeleteTime(Date deleteTime) {
			super.change(DELETE_TIME,super.getDeleteTime(),deleteTime);
			super.setDeleteTime(deleteTime);
			return this;
		}
		
		/**
		 * 设置 version
		 * @param version version
		 * @return 当前对象
		*/
		public ScreenDsDb setVersion(Integer version) {
			super.change(VERSION,super.getVersion(),version);
			super.setVersion(version);
			return this;
		}
		
		/**
		 * 设置 租户
		 * @param tenantId 租户
		 * @return 当前对象
		*/
		public ScreenDsDb setTenantId(String tenantId) {
			super.change(TENANT_ID,super.getTenantId(),tenantId);
			super.setTenantId(tenantId);
			return this;
		}

		/**
		 * 克隆当前对象
		*/
		@Transient
		public ScreenDsDb clone() {
			return duplicate(true);
		}

		/**
		 * 复制当前对象
		 * @param all 是否复制全部属性，当 false 时，仅复制来自数据表的属性
		*/
		@Transient
		public ScreenDsDb duplicate(boolean all) {
			$$proxy$$ inst=new $$proxy$$();
			inst.setNotes(this.getNotes());
			inst.setDsType(this.getDsType());
			inst.setUpdateTime(this.getUpdateTime());
			inst.setType(this.getType());
			inst.setUri(this.getUri());
			inst.setVersion(this.getVersion());
			inst.setCreateBy(this.getCreateBy());
			inst.setDeleted(this.getDeleted());
			inst.setCreateTime(this.getCreateTime());
			inst.setUpdateBy(this.getUpdateBy());
			inst.setDeleteTime(this.getDeleteTime());
			inst.setName(this.getName());
			inst.setTenantId(this.getTenantId());
			inst.setDeleteBy(this.getDeleteBy());
			inst.setId(this.getId());
			inst.setPwd(this.getPwd());
			inst.setUser(this.getUser());
			inst.clearModifies();
			return inst;
		}

	}
}