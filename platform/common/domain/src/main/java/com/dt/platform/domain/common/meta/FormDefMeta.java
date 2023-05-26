package com.dt.platform.domain.common.meta;

import com.github.foxnic.api.bean.BeanProperty;
import com.dt.platform.domain.common.FormDef;
import java.util.Date;
import javax.persistence.Transient;



/**
 * @author 金杰 , maillank@qq.com
 * @since 2023-05-26 15:20:47
 * @sign 7B7953F1F2CB93F9CE34D5DF4FB1E0F0
 * 此文件由工具自动生成，请勿修改。若表结构或配置发生变动，请使用工具重新生成。
*/

public class FormDefMeta {
	
	/**
	 * 主键 , 类型: java.lang.String
	*/
	public static final String ID="id";
	
	/**
	 * 主键 , 类型: java.lang.String
	*/
	public static final BeanProperty<com.dt.platform.domain.common.FormDef,java.lang.String> ID_PROP = new BeanProperty(com.dt.platform.domain.common.FormDef.class ,ID, java.lang.String.class, "主键", "主键", java.lang.String.class, null);
	
	/**
	 * 表单 , 类型: java.lang.String
	*/
	public static final String FORM_ID="formId";
	
	/**
	 * 表单 , 类型: java.lang.String
	*/
	public static final BeanProperty<com.dt.platform.domain.common.FormDef,java.lang.String> FORM_ID_PROP = new BeanProperty(com.dt.platform.domain.common.FormDef.class ,FORM_ID, java.lang.String.class, "表单", "表单", java.lang.String.class, null);
	
	/**
	 * 状态 , 类型: java.lang.String
	*/
	public static final String STATUS="status";
	
	/**
	 * 状态 , 类型: java.lang.String
	*/
	public static final BeanProperty<com.dt.platform.domain.common.FormDef,java.lang.String> STATUS_PROP = new BeanProperty(com.dt.platform.domain.common.FormDef.class ,STATUS, java.lang.String.class, "状态", "状态", java.lang.String.class, null);
	
	/**
	 * 定义 , 类型: java.lang.String
	*/
	public static final String DESIGNER_DATA="designerData";
	
	/**
	 * 定义 , 类型: java.lang.String
	*/
	public static final BeanProperty<com.dt.platform.domain.common.FormDef,java.lang.String> DESIGNER_DATA_PROP = new BeanProperty(com.dt.platform.domain.common.FormDef.class ,DESIGNER_DATA, java.lang.String.class, "定义", "定义", java.lang.String.class, null);
	
	/**
	 * 备注 , 类型: java.lang.String
	*/
	public static final String NOTES="notes";
	
	/**
	 * 备注 , 类型: java.lang.String
	*/
	public static final BeanProperty<com.dt.platform.domain.common.FormDef,java.lang.String> NOTES_PROP = new BeanProperty(com.dt.platform.domain.common.FormDef.class ,NOTES, java.lang.String.class, "备注", "备注", java.lang.String.class, null);
	
	/**
	 * 创建人ID , 类型: java.lang.String
	*/
	public static final String CREATE_BY="createBy";
	
	/**
	 * 创建人ID , 类型: java.lang.String
	*/
	public static final BeanProperty<com.dt.platform.domain.common.FormDef,java.lang.String> CREATE_BY_PROP = new BeanProperty(com.dt.platform.domain.common.FormDef.class ,CREATE_BY, java.lang.String.class, "创建人ID", "创建人ID", java.lang.String.class, null);
	
	/**
	 * 创建时间 , 类型: java.util.Date
	*/
	public static final String CREATE_TIME="createTime";
	
	/**
	 * 创建时间 , 类型: java.util.Date
	*/
	public static final BeanProperty<com.dt.platform.domain.common.FormDef,java.util.Date> CREATE_TIME_PROP = new BeanProperty(com.dt.platform.domain.common.FormDef.class ,CREATE_TIME, java.util.Date.class, "创建时间", "创建时间", java.util.Date.class, null);
	
	/**
	 * 修改人ID , 类型: java.lang.String
	*/
	public static final String UPDATE_BY="updateBy";
	
	/**
	 * 修改人ID , 类型: java.lang.String
	*/
	public static final BeanProperty<com.dt.platform.domain.common.FormDef,java.lang.String> UPDATE_BY_PROP = new BeanProperty(com.dt.platform.domain.common.FormDef.class ,UPDATE_BY, java.lang.String.class, "修改人ID", "修改人ID", java.lang.String.class, null);
	
	/**
	 * 修改时间 , 类型: java.util.Date
	*/
	public static final String UPDATE_TIME="updateTime";
	
	/**
	 * 修改时间 , 类型: java.util.Date
	*/
	public static final BeanProperty<com.dt.platform.domain.common.FormDef,java.util.Date> UPDATE_TIME_PROP = new BeanProperty(com.dt.platform.domain.common.FormDef.class ,UPDATE_TIME, java.util.Date.class, "修改时间", "修改时间", java.util.Date.class, null);
	
	/**
	 * 是否已删除 , 类型: java.lang.Integer
	*/
	public static final String DELETED="deleted";
	
	/**
	 * 是否已删除 , 类型: java.lang.Integer
	*/
	public static final BeanProperty<com.dt.platform.domain.common.FormDef,java.lang.Integer> DELETED_PROP = new BeanProperty(com.dt.platform.domain.common.FormDef.class ,DELETED, java.lang.Integer.class, "是否已删除", "是否已删除", java.lang.Integer.class, null);
	
	/**
	 * 删除人ID , 类型: java.lang.String
	*/
	public static final String DELETE_BY="deleteBy";
	
	/**
	 * 删除人ID , 类型: java.lang.String
	*/
	public static final BeanProperty<com.dt.platform.domain.common.FormDef,java.lang.String> DELETE_BY_PROP = new BeanProperty(com.dt.platform.domain.common.FormDef.class ,DELETE_BY, java.lang.String.class, "删除人ID", "删除人ID", java.lang.String.class, null);
	
	/**
	 * 删除时间 , 类型: java.util.Date
	*/
	public static final String DELETE_TIME="deleteTime";
	
	/**
	 * 删除时间 , 类型: java.util.Date
	*/
	public static final BeanProperty<com.dt.platform.domain.common.FormDef,java.util.Date> DELETE_TIME_PROP = new BeanProperty(com.dt.platform.domain.common.FormDef.class ,DELETE_TIME, java.util.Date.class, "删除时间", "删除时间", java.util.Date.class, null);
	
	/**
	 * version , 类型: java.lang.Integer
	*/
	public static final String VERSION="version";
	
	/**
	 * version , 类型: java.lang.Integer
	*/
	public static final BeanProperty<com.dt.platform.domain.common.FormDef,java.lang.Integer> VERSION_PROP = new BeanProperty(com.dt.platform.domain.common.FormDef.class ,VERSION, java.lang.Integer.class, "version", "version", java.lang.Integer.class, null);
	
	/**
	 * 全部属性清单
	*/
	public static final String[] $PROPS={ ID , FORM_ID , STATUS , DESIGNER_DATA , NOTES , CREATE_BY , CREATE_TIME , UPDATE_BY , UPDATE_TIME , DELETED , DELETE_BY , DELETE_TIME , VERSION };
	
	/**
	 * 代理类
	*/
	public static class $$proxy$$ extends com.dt.platform.domain.common.FormDef {

		private static final long serialVersionUID = 1L;

		
		/**
		 * 设置 主键
		 * @param id 主键
		 * @return 当前对象
		*/
		public FormDef setId(String id) {
			super.change(ID,super.getId(),id);
			super.setId(id);
			return this;
		}
		
		/**
		 * 设置 表单
		 * @param formId 表单
		 * @return 当前对象
		*/
		public FormDef setFormId(String formId) {
			super.change(FORM_ID,super.getFormId(),formId);
			super.setFormId(formId);
			return this;
		}
		
		/**
		 * 设置 状态
		 * @param status 状态
		 * @return 当前对象
		*/
		public FormDef setStatus(String status) {
			super.change(STATUS,super.getStatus(),status);
			super.setStatus(status);
			return this;
		}
		
		/**
		 * 设置 定义
		 * @param designerData 定义
		 * @return 当前对象
		*/
		public FormDef setDesignerData(String designerData) {
			super.change(DESIGNER_DATA,super.getDesignerData(),designerData);
			super.setDesignerData(designerData);
			return this;
		}
		
		/**
		 * 设置 备注
		 * @param notes 备注
		 * @return 当前对象
		*/
		public FormDef setNotes(String notes) {
			super.change(NOTES,super.getNotes(),notes);
			super.setNotes(notes);
			return this;
		}
		
		/**
		 * 设置 创建人ID
		 * @param createBy 创建人ID
		 * @return 当前对象
		*/
		public FormDef setCreateBy(String createBy) {
			super.change(CREATE_BY,super.getCreateBy(),createBy);
			super.setCreateBy(createBy);
			return this;
		}
		
		/**
		 * 设置 创建时间
		 * @param createTime 创建时间
		 * @return 当前对象
		*/
		public FormDef setCreateTime(Date createTime) {
			super.change(CREATE_TIME,super.getCreateTime(),createTime);
			super.setCreateTime(createTime);
			return this;
		}
		
		/**
		 * 设置 修改人ID
		 * @param updateBy 修改人ID
		 * @return 当前对象
		*/
		public FormDef setUpdateBy(String updateBy) {
			super.change(UPDATE_BY,super.getUpdateBy(),updateBy);
			super.setUpdateBy(updateBy);
			return this;
		}
		
		/**
		 * 设置 修改时间
		 * @param updateTime 修改时间
		 * @return 当前对象
		*/
		public FormDef setUpdateTime(Date updateTime) {
			super.change(UPDATE_TIME,super.getUpdateTime(),updateTime);
			super.setUpdateTime(updateTime);
			return this;
		}
		
		/**
		 * 设置 是否已删除
		 * @param deleted 是否已删除
		 * @return 当前对象
		*/
		public FormDef setDeleted(Integer deleted) {
			super.change(DELETED,super.getDeleted(),deleted);
			super.setDeleted(deleted);
			return this;
		}
		
		/**
		 * 设置 删除人ID
		 * @param deleteBy 删除人ID
		 * @return 当前对象
		*/
		public FormDef setDeleteBy(String deleteBy) {
			super.change(DELETE_BY,super.getDeleteBy(),deleteBy);
			super.setDeleteBy(deleteBy);
			return this;
		}
		
		/**
		 * 设置 删除时间
		 * @param deleteTime 删除时间
		 * @return 当前对象
		*/
		public FormDef setDeleteTime(Date deleteTime) {
			super.change(DELETE_TIME,super.getDeleteTime(),deleteTime);
			super.setDeleteTime(deleteTime);
			return this;
		}
		
		/**
		 * 设置 version
		 * @param version version
		 * @return 当前对象
		*/
		public FormDef setVersion(Integer version) {
			super.change(VERSION,super.getVersion(),version);
			super.setVersion(version);
			return this;
		}

		/**
		 * 克隆当前对象
		*/
		@Transient
		public FormDef clone() {
			return duplicate(true);
		}

		/**
		 * 复制当前对象
		 * @param all 是否复制全部属性，当 false 时，仅复制来自数据表的属性
		*/
		@Transient
		public FormDef duplicate(boolean all) {
			$$proxy$$ inst=new $$proxy$$();
			inst.setFormId(this.getFormId());
			inst.setDesignerData(this.getDesignerData());
			inst.setNotes(this.getNotes());
			inst.setUpdateTime(this.getUpdateTime());
			inst.setVersion(this.getVersion());
			inst.setCreateBy(this.getCreateBy());
			inst.setDeleted(this.getDeleted());
			inst.setCreateTime(this.getCreateTime());
			inst.setUpdateBy(this.getUpdateBy());
			inst.setDeleteTime(this.getDeleteTime());
			inst.setDeleteBy(this.getDeleteBy());
			inst.setId(this.getId());
			inst.setStatus(this.getStatus());
			inst.clearModifies();
			return inst;
		}

	}
}