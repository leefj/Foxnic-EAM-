package com.dt.platform.domain.eam.meta;

import com.github.foxnic.api.bean.BeanProperty;
import com.dt.platform.domain.eam.EquipmentLabel;
import java.util.Date;
import javax.persistence.Transient;



/**
 * @author 金杰 , maillank@qq.com
 * @since 2024-04-08 07:36:30
 * @sign 1D14CCEDDB812CF53586E1334DDA123E
 * 此文件由工具自动生成，请勿修改。若表结构或配置发生变动，请使用工具重新生成。
*/

public class EquipmentLabelMeta {
	
	/**
	 * 主键 , 类型: java.lang.String
	*/
	public static final String ID="id";
	
	/**
	 * 主键 , 类型: java.lang.String
	*/
	public static final BeanProperty<com.dt.platform.domain.eam.EquipmentLabel,java.lang.String> ID_PROP = new BeanProperty(com.dt.platform.domain.eam.EquipmentLabel.class ,ID, java.lang.String.class, "主键", "主键", java.lang.String.class, null);
	
	/**
	 * 所属 , 类型: java.lang.String
	*/
	public static final String OWNER_ID="ownerId";
	
	/**
	 * 所属 , 类型: java.lang.String
	*/
	public static final BeanProperty<com.dt.platform.domain.eam.EquipmentLabel,java.lang.String> OWNER_ID_PROP = new BeanProperty(com.dt.platform.domain.eam.EquipmentLabel.class ,OWNER_ID, java.lang.String.class, "所属", "所属", java.lang.String.class, null);
	
	/**
	 * 标签名称 , 类型: java.lang.String
	*/
	public static final String NAME="name";
	
	/**
	 * 标签名称 , 类型: java.lang.String
	*/
	public static final BeanProperty<com.dt.platform.domain.eam.EquipmentLabel,java.lang.String> NAME_PROP = new BeanProperty(com.dt.platform.domain.eam.EquipmentLabel.class ,NAME, java.lang.String.class, "标签名称", "标签名称", java.lang.String.class, null);
	
	/**
	 * 标识符 , 类型: java.lang.String
	*/
	public static final String IDENTIFIER="identifier";
	
	/**
	 * 标识符 , 类型: java.lang.String
	*/
	public static final BeanProperty<com.dt.platform.domain.eam.EquipmentLabel,java.lang.String> IDENTIFIER_PROP = new BeanProperty(com.dt.platform.domain.eam.EquipmentLabel.class ,IDENTIFIER, java.lang.String.class, "标识符", "标识符", java.lang.String.class, null);
	
	/**
	 * 标签值 , 类型: java.lang.String
	*/
	public static final String VALUE="value";
	
	/**
	 * 标签值 , 类型: java.lang.String
	*/
	public static final BeanProperty<com.dt.platform.domain.eam.EquipmentLabel,java.lang.String> VALUE_PROP = new BeanProperty(com.dt.platform.domain.eam.EquipmentLabel.class ,VALUE, java.lang.String.class, "标签值", "标签值", java.lang.String.class, null);
	
	/**
	 * 创建人ID , 类型: java.lang.String
	*/
	public static final String CREATE_BY="createBy";
	
	/**
	 * 创建人ID , 类型: java.lang.String
	*/
	public static final BeanProperty<com.dt.platform.domain.eam.EquipmentLabel,java.lang.String> CREATE_BY_PROP = new BeanProperty(com.dt.platform.domain.eam.EquipmentLabel.class ,CREATE_BY, java.lang.String.class, "创建人ID", "创建人ID", java.lang.String.class, null);
	
	/**
	 * 创建时间 , 类型: java.util.Date
	*/
	public static final String CREATE_TIME="createTime";
	
	/**
	 * 创建时间 , 类型: java.util.Date
	*/
	public static final BeanProperty<com.dt.platform.domain.eam.EquipmentLabel,java.util.Date> CREATE_TIME_PROP = new BeanProperty(com.dt.platform.domain.eam.EquipmentLabel.class ,CREATE_TIME, java.util.Date.class, "创建时间", "创建时间", java.util.Date.class, null);
	
	/**
	 * 修改人ID , 类型: java.lang.String
	*/
	public static final String UPDATE_BY="updateBy";
	
	/**
	 * 修改人ID , 类型: java.lang.String
	*/
	public static final BeanProperty<com.dt.platform.domain.eam.EquipmentLabel,java.lang.String> UPDATE_BY_PROP = new BeanProperty(com.dt.platform.domain.eam.EquipmentLabel.class ,UPDATE_BY, java.lang.String.class, "修改人ID", "修改人ID", java.lang.String.class, null);
	
	/**
	 * 修改时间 , 类型: java.util.Date
	*/
	public static final String UPDATE_TIME="updateTime";
	
	/**
	 * 修改时间 , 类型: java.util.Date
	*/
	public static final BeanProperty<com.dt.platform.domain.eam.EquipmentLabel,java.util.Date> UPDATE_TIME_PROP = new BeanProperty(com.dt.platform.domain.eam.EquipmentLabel.class ,UPDATE_TIME, java.util.Date.class, "修改时间", "修改时间", java.util.Date.class, null);
	
	/**
	 * 是否已删除 , 类型: java.lang.Integer
	*/
	public static final String DELETED="deleted";
	
	/**
	 * 是否已删除 , 类型: java.lang.Integer
	*/
	public static final BeanProperty<com.dt.platform.domain.eam.EquipmentLabel,java.lang.Integer> DELETED_PROP = new BeanProperty(com.dt.platform.domain.eam.EquipmentLabel.class ,DELETED, java.lang.Integer.class, "是否已删除", "是否已删除", java.lang.Integer.class, null);
	
	/**
	 * 删除人ID , 类型: java.lang.String
	*/
	public static final String DELETE_BY="deleteBy";
	
	/**
	 * 删除人ID , 类型: java.lang.String
	*/
	public static final BeanProperty<com.dt.platform.domain.eam.EquipmentLabel,java.lang.String> DELETE_BY_PROP = new BeanProperty(com.dt.platform.domain.eam.EquipmentLabel.class ,DELETE_BY, java.lang.String.class, "删除人ID", "删除人ID", java.lang.String.class, null);
	
	/**
	 * 删除时间 , 类型: java.util.Date
	*/
	public static final String DELETE_TIME="deleteTime";
	
	/**
	 * 删除时间 , 类型: java.util.Date
	*/
	public static final BeanProperty<com.dt.platform.domain.eam.EquipmentLabel,java.util.Date> DELETE_TIME_PROP = new BeanProperty(com.dt.platform.domain.eam.EquipmentLabel.class ,DELETE_TIME, java.util.Date.class, "删除时间", "删除时间", java.util.Date.class, null);
	
	/**
	 * version , 类型: java.lang.Integer
	*/
	public static final String VERSION="version";
	
	/**
	 * version , 类型: java.lang.Integer
	*/
	public static final BeanProperty<com.dt.platform.domain.eam.EquipmentLabel,java.lang.Integer> VERSION_PROP = new BeanProperty(com.dt.platform.domain.eam.EquipmentLabel.class ,VERSION, java.lang.Integer.class, "version", "version", java.lang.Integer.class, null);
	
	/**
	 * 全部属性清单
	*/
	public static final String[] $PROPS={ ID , OWNER_ID , NAME , IDENTIFIER , VALUE , CREATE_BY , CREATE_TIME , UPDATE_BY , UPDATE_TIME , DELETED , DELETE_BY , DELETE_TIME , VERSION };
	
	/**
	 * 代理类
	*/
	public static class $$proxy$$ extends com.dt.platform.domain.eam.EquipmentLabel {

		private static final long serialVersionUID = 1L;

		
		/**
		 * 设置 主键
		 * @param id 主键
		 * @return 当前对象
		*/
		public EquipmentLabel setId(String id) {
			super.change(ID,super.getId(),id);
			super.setId(id);
			return this;
		}
		
		/**
		 * 设置 所属
		 * @param ownerId 所属
		 * @return 当前对象
		*/
		public EquipmentLabel setOwnerId(String ownerId) {
			super.change(OWNER_ID,super.getOwnerId(),ownerId);
			super.setOwnerId(ownerId);
			return this;
		}
		
		/**
		 * 设置 标签名称
		 * @param name 标签名称
		 * @return 当前对象
		*/
		public EquipmentLabel setName(String name) {
			super.change(NAME,super.getName(),name);
			super.setName(name);
			return this;
		}
		
		/**
		 * 设置 标识符
		 * @param identifier 标识符
		 * @return 当前对象
		*/
		public EquipmentLabel setIdentifier(String identifier) {
			super.change(IDENTIFIER,super.getIdentifier(),identifier);
			super.setIdentifier(identifier);
			return this;
		}
		
		/**
		 * 设置 标签值
		 * @param value 标签值
		 * @return 当前对象
		*/
		public EquipmentLabel setValue(String value) {
			super.change(VALUE,super.getValue(),value);
			super.setValue(value);
			return this;
		}
		
		/**
		 * 设置 创建人ID
		 * @param createBy 创建人ID
		 * @return 当前对象
		*/
		public EquipmentLabel setCreateBy(String createBy) {
			super.change(CREATE_BY,super.getCreateBy(),createBy);
			super.setCreateBy(createBy);
			return this;
		}
		
		/**
		 * 设置 创建时间
		 * @param createTime 创建时间
		 * @return 当前对象
		*/
		public EquipmentLabel setCreateTime(Date createTime) {
			super.change(CREATE_TIME,super.getCreateTime(),createTime);
			super.setCreateTime(createTime);
			return this;
		}
		
		/**
		 * 设置 修改人ID
		 * @param updateBy 修改人ID
		 * @return 当前对象
		*/
		public EquipmentLabel setUpdateBy(String updateBy) {
			super.change(UPDATE_BY,super.getUpdateBy(),updateBy);
			super.setUpdateBy(updateBy);
			return this;
		}
		
		/**
		 * 设置 修改时间
		 * @param updateTime 修改时间
		 * @return 当前对象
		*/
		public EquipmentLabel setUpdateTime(Date updateTime) {
			super.change(UPDATE_TIME,super.getUpdateTime(),updateTime);
			super.setUpdateTime(updateTime);
			return this;
		}
		
		/**
		 * 设置 是否已删除
		 * @param deleted 是否已删除
		 * @return 当前对象
		*/
		public EquipmentLabel setDeleted(Integer deleted) {
			super.change(DELETED,super.getDeleted(),deleted);
			super.setDeleted(deleted);
			return this;
		}
		
		/**
		 * 设置 删除人ID
		 * @param deleteBy 删除人ID
		 * @return 当前对象
		*/
		public EquipmentLabel setDeleteBy(String deleteBy) {
			super.change(DELETE_BY,super.getDeleteBy(),deleteBy);
			super.setDeleteBy(deleteBy);
			return this;
		}
		
		/**
		 * 设置 删除时间
		 * @param deleteTime 删除时间
		 * @return 当前对象
		*/
		public EquipmentLabel setDeleteTime(Date deleteTime) {
			super.change(DELETE_TIME,super.getDeleteTime(),deleteTime);
			super.setDeleteTime(deleteTime);
			return this;
		}
		
		/**
		 * 设置 version
		 * @param version version
		 * @return 当前对象
		*/
		public EquipmentLabel setVersion(Integer version) {
			super.change(VERSION,super.getVersion(),version);
			super.setVersion(version);
			return this;
		}

		/**
		 * 克隆当前对象
		*/
		@Transient
		public EquipmentLabel clone() {
			return duplicate(true);
		}

		/**
		 * 复制当前对象
		 * @param all 是否复制全部属性，当 false 时，仅复制来自数据表的属性
		*/
		@Transient
		public EquipmentLabel duplicate(boolean all) {
			$$proxy$$ inst=new $$proxy$$();
			inst.setIdentifier(this.getIdentifier());
			inst.setUpdateTime(this.getUpdateTime());
			inst.setOwnerId(this.getOwnerId());
			inst.setVersion(this.getVersion());
			inst.setCreateBy(this.getCreateBy());
			inst.setDeleted(this.getDeleted());
			inst.setCreateTime(this.getCreateTime());
			inst.setUpdateBy(this.getUpdateBy());
			inst.setDeleteTime(this.getDeleteTime());
			inst.setName(this.getName());
			inst.setDeleteBy(this.getDeleteBy());
			inst.setId(this.getId());
			inst.setValue(this.getValue());
			inst.clearModifies();
			return inst;
		}

	}
}