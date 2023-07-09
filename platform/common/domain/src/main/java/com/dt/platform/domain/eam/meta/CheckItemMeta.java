package com.dt.platform.domain.eam.meta;

import com.github.foxnic.api.bean.BeanProperty;
import com.dt.platform.domain.eam.CheckItem;
import java.util.Date;
import javax.persistence.Transient;



/**
 * @author 金杰 , maillank@qq.com
 * @since 2023-07-07 13:59:01
 * @sign 015FCE7FC422A1104EA86D12D411D1ED
 * 此文件由工具自动生成，请勿修改。若表结构或配置发生变动，请使用工具重新生成。
*/

public class CheckItemMeta {
	
	/**
	 * 主键 , 类型: java.lang.String
	*/
	public static final String ID="id";
	
	/**
	 * 主键 , 类型: java.lang.String
	*/
	public static final BeanProperty<com.dt.platform.domain.eam.CheckItem,java.lang.String> ID_PROP = new BeanProperty(com.dt.platform.domain.eam.CheckItem.class ,ID, java.lang.String.class, "主键", "主键", java.lang.String.class, null);
	
	/**
	 * 归属 , 类型: java.lang.String
	*/
	public static final String OWNER="owner";
	
	/**
	 * 归属 , 类型: java.lang.String
	*/
	public static final BeanProperty<com.dt.platform.domain.eam.CheckItem,java.lang.String> OWNER_PROP = new BeanProperty(com.dt.platform.domain.eam.CheckItem.class ,OWNER, java.lang.String.class, "归属", "归属", java.lang.String.class, null);
	
	/**
	 * 编码 , 类型: java.lang.String
	*/
	public static final String CODE="code";
	
	/**
	 * 编码 , 类型: java.lang.String
	*/
	public static final BeanProperty<com.dt.platform.domain.eam.CheckItem,java.lang.String> CODE_PROP = new BeanProperty(com.dt.platform.domain.eam.CheckItem.class ,CODE, java.lang.String.class, "编码", "编码", java.lang.String.class, null);
	
	/**
	 * 状态 , 类型: java.lang.String
	*/
	public static final String STATUS="status";
	
	/**
	 * 状态 , 类型: java.lang.String
	*/
	public static final BeanProperty<com.dt.platform.domain.eam.CheckItem,java.lang.String> STATUS_PROP = new BeanProperty(com.dt.platform.domain.eam.CheckItem.class ,STATUS, java.lang.String.class, "状态", "状态", java.lang.String.class, null);
	
	/**
	 * 名称 , 类型: java.lang.String
	*/
	public static final String NAME="name";
	
	/**
	 * 名称 , 类型: java.lang.String
	*/
	public static final BeanProperty<com.dt.platform.domain.eam.CheckItem,java.lang.String> NAME_PROP = new BeanProperty(com.dt.platform.domain.eam.CheckItem.class ,NAME, java.lang.String.class, "名称", "名称", java.lang.String.class, null);
	
	/**
	 * 描述 , 类型: java.lang.String
	*/
	public static final String CHECK_DESC="checkDesc";
	
	/**
	 * 描述 , 类型: java.lang.String
	*/
	public static final BeanProperty<com.dt.platform.domain.eam.CheckItem,java.lang.String> CHECK_DESC_PROP = new BeanProperty(com.dt.platform.domain.eam.CheckItem.class ,CHECK_DESC, java.lang.String.class, "描述", "描述", java.lang.String.class, null);
	
	/**
	 * 组件类型 , 类型: java.lang.String
	*/
	public static final String TYPE="type";
	
	/**
	 * 组件类型 , 类型: java.lang.String
	*/
	public static final BeanProperty<com.dt.platform.domain.eam.CheckItem,java.lang.String> TYPE_PROP = new BeanProperty(com.dt.platform.domain.eam.CheckItem.class ,TYPE, java.lang.String.class, "组件类型", "组件类型", java.lang.String.class, null);
	
	/**
	 * 配置项 , 类型: java.lang.String
	*/
	public static final String CONFIG="config";
	
	/**
	 * 配置项 , 类型: java.lang.String
	*/
	public static final BeanProperty<com.dt.platform.domain.eam.CheckItem,java.lang.String> CONFIG_PROP = new BeanProperty(com.dt.platform.domain.eam.CheckItem.class ,CONFIG, java.lang.String.class, "配置项", "配置项", java.lang.String.class, null);
	
	/**
	 * 默认内容 , 类型: java.lang.String
	*/
	public static final String DEF_VALUE="defValue";
	
	/**
	 * 默认内容 , 类型: java.lang.String
	*/
	public static final BeanProperty<com.dt.platform.domain.eam.CheckItem,java.lang.String> DEF_VALUE_PROP = new BeanProperty(com.dt.platform.domain.eam.CheckItem.class ,DEF_VALUE, java.lang.String.class, "默认内容", "默认内容", java.lang.String.class, null);
	
	/**
	 * 备注 , 类型: java.lang.String
	*/
	public static final String NOTES="notes";
	
	/**
	 * 备注 , 类型: java.lang.String
	*/
	public static final BeanProperty<com.dt.platform.domain.eam.CheckItem,java.lang.String> NOTES_PROP = new BeanProperty(com.dt.platform.domain.eam.CheckItem.class ,NOTES, java.lang.String.class, "备注", "备注", java.lang.String.class, null);
	
	/**
	 * 创建人ID , 类型: java.lang.String
	*/
	public static final String CREATE_BY="createBy";
	
	/**
	 * 创建人ID , 类型: java.lang.String
	*/
	public static final BeanProperty<com.dt.platform.domain.eam.CheckItem,java.lang.String> CREATE_BY_PROP = new BeanProperty(com.dt.platform.domain.eam.CheckItem.class ,CREATE_BY, java.lang.String.class, "创建人ID", "创建人ID", java.lang.String.class, null);
	
	/**
	 * 创建时间 , 类型: java.util.Date
	*/
	public static final String CREATE_TIME="createTime";
	
	/**
	 * 创建时间 , 类型: java.util.Date
	*/
	public static final BeanProperty<com.dt.platform.domain.eam.CheckItem,java.util.Date> CREATE_TIME_PROP = new BeanProperty(com.dt.platform.domain.eam.CheckItem.class ,CREATE_TIME, java.util.Date.class, "创建时间", "创建时间", java.util.Date.class, null);
	
	/**
	 * 修改人ID , 类型: java.lang.String
	*/
	public static final String UPDATE_BY="updateBy";
	
	/**
	 * 修改人ID , 类型: java.lang.String
	*/
	public static final BeanProperty<com.dt.platform.domain.eam.CheckItem,java.lang.String> UPDATE_BY_PROP = new BeanProperty(com.dt.platform.domain.eam.CheckItem.class ,UPDATE_BY, java.lang.String.class, "修改人ID", "修改人ID", java.lang.String.class, null);
	
	/**
	 * 修改时间 , 类型: java.util.Date
	*/
	public static final String UPDATE_TIME="updateTime";
	
	/**
	 * 修改时间 , 类型: java.util.Date
	*/
	public static final BeanProperty<com.dt.platform.domain.eam.CheckItem,java.util.Date> UPDATE_TIME_PROP = new BeanProperty(com.dt.platform.domain.eam.CheckItem.class ,UPDATE_TIME, java.util.Date.class, "修改时间", "修改时间", java.util.Date.class, null);
	
	/**
	 * 是否已删除 , 类型: java.lang.Integer
	*/
	public static final String DELETED="deleted";
	
	/**
	 * 是否已删除 , 类型: java.lang.Integer
	*/
	public static final BeanProperty<com.dt.platform.domain.eam.CheckItem,java.lang.Integer> DELETED_PROP = new BeanProperty(com.dt.platform.domain.eam.CheckItem.class ,DELETED, java.lang.Integer.class, "是否已删除", "是否已删除", java.lang.Integer.class, null);
	
	/**
	 * 删除人ID , 类型: java.lang.String
	*/
	public static final String DELETE_BY="deleteBy";
	
	/**
	 * 删除人ID , 类型: java.lang.String
	*/
	public static final BeanProperty<com.dt.platform.domain.eam.CheckItem,java.lang.String> DELETE_BY_PROP = new BeanProperty(com.dt.platform.domain.eam.CheckItem.class ,DELETE_BY, java.lang.String.class, "删除人ID", "删除人ID", java.lang.String.class, null);
	
	/**
	 * 删除时间 , 类型: java.util.Date
	*/
	public static final String DELETE_TIME="deleteTime";
	
	/**
	 * 删除时间 , 类型: java.util.Date
	*/
	public static final BeanProperty<com.dt.platform.domain.eam.CheckItem,java.util.Date> DELETE_TIME_PROP = new BeanProperty(com.dt.platform.domain.eam.CheckItem.class ,DELETE_TIME, java.util.Date.class, "删除时间", "删除时间", java.util.Date.class, null);
	
	/**
	 * version , 类型: java.lang.Integer
	*/
	public static final String VERSION="version";
	
	/**
	 * version , 类型: java.lang.Integer
	*/
	public static final BeanProperty<com.dt.platform.domain.eam.CheckItem,java.lang.Integer> VERSION_PROP = new BeanProperty(com.dt.platform.domain.eam.CheckItem.class ,VERSION, java.lang.Integer.class, "version", "version", java.lang.Integer.class, null);
	
	/**
	 * 租户 , 类型: java.lang.String
	*/
	public static final String TENANT_ID="tenantId";
	
	/**
	 * 租户 , 类型: java.lang.String
	*/
	public static final BeanProperty<com.dt.platform.domain.eam.CheckItem,java.lang.String> TENANT_ID_PROP = new BeanProperty(com.dt.platform.domain.eam.CheckItem.class ,TENANT_ID, java.lang.String.class, "租户", "租户", java.lang.String.class, null);
	
	/**
	 * 全部属性清单
	*/
	public static final String[] $PROPS={ ID , OWNER , CODE , STATUS , NAME , CHECK_DESC , TYPE , CONFIG , DEF_VALUE , NOTES , CREATE_BY , CREATE_TIME , UPDATE_BY , UPDATE_TIME , DELETED , DELETE_BY , DELETE_TIME , VERSION , TENANT_ID };
	
	/**
	 * 代理类
	*/
	public static class $$proxy$$ extends com.dt.platform.domain.eam.CheckItem {

		private static final long serialVersionUID = 1L;

		
		/**
		 * 设置 主键
		 * @param id 主键
		 * @return 当前对象
		*/
		public CheckItem setId(String id) {
			super.change(ID,super.getId(),id);
			super.setId(id);
			return this;
		}
		
		/**
		 * 设置 归属
		 * @param owner 归属
		 * @return 当前对象
		*/
		public CheckItem setOwner(String owner) {
			super.change(OWNER,super.getOwner(),owner);
			super.setOwner(owner);
			return this;
		}
		
		/**
		 * 设置 编码
		 * @param code 编码
		 * @return 当前对象
		*/
		public CheckItem setCode(String code) {
			super.change(CODE,super.getCode(),code);
			super.setCode(code);
			return this;
		}
		
		/**
		 * 设置 状态
		 * @param status 状态
		 * @return 当前对象
		*/
		public CheckItem setStatus(String status) {
			super.change(STATUS,super.getStatus(),status);
			super.setStatus(status);
			return this;
		}
		
		/**
		 * 设置 名称
		 * @param name 名称
		 * @return 当前对象
		*/
		public CheckItem setName(String name) {
			super.change(NAME,super.getName(),name);
			super.setName(name);
			return this;
		}
		
		/**
		 * 设置 描述
		 * @param checkDesc 描述
		 * @return 当前对象
		*/
		public CheckItem setCheckDesc(String checkDesc) {
			super.change(CHECK_DESC,super.getCheckDesc(),checkDesc);
			super.setCheckDesc(checkDesc);
			return this;
		}
		
		/**
		 * 设置 组件类型
		 * @param type 组件类型
		 * @return 当前对象
		*/
		public CheckItem setType(String type) {
			super.change(TYPE,super.getType(),type);
			super.setType(type);
			return this;
		}
		
		/**
		 * 设置 配置项
		 * @param config 配置项
		 * @return 当前对象
		*/
		public CheckItem setConfig(String config) {
			super.change(CONFIG,super.getConfig(),config);
			super.setConfig(config);
			return this;
		}
		
		/**
		 * 设置 默认内容
		 * @param defValue 默认内容
		 * @return 当前对象
		*/
		public CheckItem setDefValue(String defValue) {
			super.change(DEF_VALUE,super.getDefValue(),defValue);
			super.setDefValue(defValue);
			return this;
		}
		
		/**
		 * 设置 备注
		 * @param notes 备注
		 * @return 当前对象
		*/
		public CheckItem setNotes(String notes) {
			super.change(NOTES,super.getNotes(),notes);
			super.setNotes(notes);
			return this;
		}
		
		/**
		 * 设置 创建人ID
		 * @param createBy 创建人ID
		 * @return 当前对象
		*/
		public CheckItem setCreateBy(String createBy) {
			super.change(CREATE_BY,super.getCreateBy(),createBy);
			super.setCreateBy(createBy);
			return this;
		}
		
		/**
		 * 设置 创建时间
		 * @param createTime 创建时间
		 * @return 当前对象
		*/
		public CheckItem setCreateTime(Date createTime) {
			super.change(CREATE_TIME,super.getCreateTime(),createTime);
			super.setCreateTime(createTime);
			return this;
		}
		
		/**
		 * 设置 修改人ID
		 * @param updateBy 修改人ID
		 * @return 当前对象
		*/
		public CheckItem setUpdateBy(String updateBy) {
			super.change(UPDATE_BY,super.getUpdateBy(),updateBy);
			super.setUpdateBy(updateBy);
			return this;
		}
		
		/**
		 * 设置 修改时间
		 * @param updateTime 修改时间
		 * @return 当前对象
		*/
		public CheckItem setUpdateTime(Date updateTime) {
			super.change(UPDATE_TIME,super.getUpdateTime(),updateTime);
			super.setUpdateTime(updateTime);
			return this;
		}
		
		/**
		 * 设置 是否已删除
		 * @param deleted 是否已删除
		 * @return 当前对象
		*/
		public CheckItem setDeleted(Integer deleted) {
			super.change(DELETED,super.getDeleted(),deleted);
			super.setDeleted(deleted);
			return this;
		}
		
		/**
		 * 设置 删除人ID
		 * @param deleteBy 删除人ID
		 * @return 当前对象
		*/
		public CheckItem setDeleteBy(String deleteBy) {
			super.change(DELETE_BY,super.getDeleteBy(),deleteBy);
			super.setDeleteBy(deleteBy);
			return this;
		}
		
		/**
		 * 设置 删除时间
		 * @param deleteTime 删除时间
		 * @return 当前对象
		*/
		public CheckItem setDeleteTime(Date deleteTime) {
			super.change(DELETE_TIME,super.getDeleteTime(),deleteTime);
			super.setDeleteTime(deleteTime);
			return this;
		}
		
		/**
		 * 设置 version
		 * @param version version
		 * @return 当前对象
		*/
		public CheckItem setVersion(Integer version) {
			super.change(VERSION,super.getVersion(),version);
			super.setVersion(version);
			return this;
		}
		
		/**
		 * 设置 租户
		 * @param tenantId 租户
		 * @return 当前对象
		*/
		public CheckItem setTenantId(String tenantId) {
			super.change(TENANT_ID,super.getTenantId(),tenantId);
			super.setTenantId(tenantId);
			return this;
		}

		/**
		 * 克隆当前对象
		*/
		@Transient
		public CheckItem clone() {
			return duplicate(true);
		}

		/**
		 * 复制当前对象
		 * @param all 是否复制全部属性，当 false 时，仅复制来自数据表的属性
		*/
		@Transient
		public CheckItem duplicate(boolean all) {
			$$proxy$$ inst=new $$proxy$$();
			inst.setOwner(this.getOwner());
			inst.setCode(this.getCode());
			inst.setCheckDesc(this.getCheckDesc());
			inst.setNotes(this.getNotes());
			inst.setUpdateTime(this.getUpdateTime());
			inst.setType(this.getType());
			inst.setVersion(this.getVersion());
			inst.setDefValue(this.getDefValue());
			inst.setCreateBy(this.getCreateBy());
			inst.setDeleted(this.getDeleted());
			inst.setCreateTime(this.getCreateTime());
			inst.setUpdateBy(this.getUpdateBy());
			inst.setDeleteTime(this.getDeleteTime());
			inst.setName(this.getName());
			inst.setTenantId(this.getTenantId());
			inst.setDeleteBy(this.getDeleteBy());
			inst.setId(this.getId());
			inst.setConfig(this.getConfig());
			inst.setStatus(this.getStatus());
			inst.clearModifies();
			return inst;
		}

	}
}