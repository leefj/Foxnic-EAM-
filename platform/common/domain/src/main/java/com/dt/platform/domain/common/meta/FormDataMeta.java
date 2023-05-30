package com.dt.platform.domain.common.meta;

import com.github.foxnic.api.bean.BeanProperty;
import com.dt.platform.domain.common.FormData;
import java.util.Date;
import com.dt.platform.domain.common.FormDataExt;
import javax.persistence.Transient;



/**
 * @author 金杰 , maillank@qq.com
 * @since 2023-05-29 08:39:42
 * @sign 7D101636AEC854C9627F9D103FEDABCF
 * 此文件由工具自动生成，请勿修改。若表结构或配置发生变动，请使用工具重新生成。
*/

public class FormDataMeta {
	
	/**
	 * 主键 , 类型: java.lang.String
	*/
	public static final String ID="id";
	
	/**
	 * 主键 , 类型: java.lang.String
	*/
	public static final BeanProperty<com.dt.platform.domain.common.FormData,java.lang.String> ID_PROP = new BeanProperty(com.dt.platform.domain.common.FormData.class ,ID, java.lang.String.class, "主键", "主键", java.lang.String.class, null);
	
	/**
	 * 业务归属 , 类型: java.lang.String
	*/
	public static final String OWNER_ID="ownerId";
	
	/**
	 * 业务归属 , 类型: java.lang.String
	*/
	public static final BeanProperty<com.dt.platform.domain.common.FormData,java.lang.String> OWNER_ID_PROP = new BeanProperty(com.dt.platform.domain.common.FormData.class ,OWNER_ID, java.lang.String.class, "业务归属", "业务归属", java.lang.String.class, null);
	
	/**
	 * 表单定义 , 类型: java.lang.String
	*/
	public static final String DEF_ID="defId";
	
	/**
	 * 表单定义 , 类型: java.lang.String
	*/
	public static final BeanProperty<com.dt.platform.domain.common.FormData,java.lang.String> DEF_ID_PROP = new BeanProperty(com.dt.platform.domain.common.FormData.class ,DEF_ID, java.lang.String.class, "表单定义", "表单定义", java.lang.String.class, null);
	
	/**
	 * 表单 , 类型: java.lang.String
	*/
	public static final String FORM_ID="formId";
	
	/**
	 * 表单 , 类型: java.lang.String
	*/
	public static final BeanProperty<com.dt.platform.domain.common.FormData,java.lang.String> FORM_ID_PROP = new BeanProperty(com.dt.platform.domain.common.FormData.class ,FORM_ID, java.lang.String.class, "表单", "表单", java.lang.String.class, null);
	
	/**
	 * 设计 , 类型: java.lang.String
	*/
	public static final String DESIGNER_DATA="designerData";
	
	/**
	 * 设计 , 类型: java.lang.String
	*/
	public static final BeanProperty<com.dt.platform.domain.common.FormData,java.lang.String> DESIGNER_DATA_PROP = new BeanProperty(com.dt.platform.domain.common.FormData.class ,DESIGNER_DATA, java.lang.String.class, "设计", "设计", java.lang.String.class, null);
	
	/**
	 * 数据 , 类型: java.lang.String
	*/
	public static final String DATA="data";
	
	/**
	 * 数据 , 类型: java.lang.String
	*/
	public static final BeanProperty<com.dt.platform.domain.common.FormData,java.lang.String> DATA_PROP = new BeanProperty(com.dt.platform.domain.common.FormData.class ,DATA, java.lang.String.class, "数据", "数据", java.lang.String.class, null);
	
	/**
	 * 表单状态 , 类型: java.lang.String
	*/
	public static final String FORM_STATUS="formStatus";
	
	/**
	 * 表单状态 , 类型: java.lang.String
	*/
	public static final BeanProperty<com.dt.platform.domain.common.FormData,java.lang.String> FORM_STATUS_PROP = new BeanProperty(com.dt.platform.domain.common.FormData.class ,FORM_STATUS, java.lang.String.class, "表单状态", "表单状态", java.lang.String.class, null);
	
	/**
	 * 创建人ID , 类型: java.lang.String
	*/
	public static final String CREATE_BY="createBy";
	
	/**
	 * 创建人ID , 类型: java.lang.String
	*/
	public static final BeanProperty<com.dt.platform.domain.common.FormData,java.lang.String> CREATE_BY_PROP = new BeanProperty(com.dt.platform.domain.common.FormData.class ,CREATE_BY, java.lang.String.class, "创建人ID", "创建人ID", java.lang.String.class, null);
	
	/**
	 * 创建时间 , 类型: java.util.Date
	*/
	public static final String CREATE_TIME="createTime";
	
	/**
	 * 创建时间 , 类型: java.util.Date
	*/
	public static final BeanProperty<com.dt.platform.domain.common.FormData,java.util.Date> CREATE_TIME_PROP = new BeanProperty(com.dt.platform.domain.common.FormData.class ,CREATE_TIME, java.util.Date.class, "创建时间", "创建时间", java.util.Date.class, null);
	
	/**
	 * 修改人ID , 类型: java.lang.String
	*/
	public static final String UPDATE_BY="updateBy";
	
	/**
	 * 修改人ID , 类型: java.lang.String
	*/
	public static final BeanProperty<com.dt.platform.domain.common.FormData,java.lang.String> UPDATE_BY_PROP = new BeanProperty(com.dt.platform.domain.common.FormData.class ,UPDATE_BY, java.lang.String.class, "修改人ID", "修改人ID", java.lang.String.class, null);
	
	/**
	 * 修改时间 , 类型: java.util.Date
	*/
	public static final String UPDATE_TIME="updateTime";
	
	/**
	 * 修改时间 , 类型: java.util.Date
	*/
	public static final BeanProperty<com.dt.platform.domain.common.FormData,java.util.Date> UPDATE_TIME_PROP = new BeanProperty(com.dt.platform.domain.common.FormData.class ,UPDATE_TIME, java.util.Date.class, "修改时间", "修改时间", java.util.Date.class, null);
	
	/**
	 * 是否已删除 , 类型: java.lang.Integer
	*/
	public static final String DELETED="deleted";
	
	/**
	 * 是否已删除 , 类型: java.lang.Integer
	*/
	public static final BeanProperty<com.dt.platform.domain.common.FormData,java.lang.Integer> DELETED_PROP = new BeanProperty(com.dt.platform.domain.common.FormData.class ,DELETED, java.lang.Integer.class, "是否已删除", "是否已删除", java.lang.Integer.class, null);
	
	/**
	 * 删除人ID , 类型: java.lang.String
	*/
	public static final String DELETE_BY="deleteBy";
	
	/**
	 * 删除人ID , 类型: java.lang.String
	*/
	public static final BeanProperty<com.dt.platform.domain.common.FormData,java.lang.String> DELETE_BY_PROP = new BeanProperty(com.dt.platform.domain.common.FormData.class ,DELETE_BY, java.lang.String.class, "删除人ID", "删除人ID", java.lang.String.class, null);
	
	/**
	 * 删除时间 , 类型: java.util.Date
	*/
	public static final String DELETE_TIME="deleteTime";
	
	/**
	 * 删除时间 , 类型: java.util.Date
	*/
	public static final BeanProperty<com.dt.platform.domain.common.FormData,java.util.Date> DELETE_TIME_PROP = new BeanProperty(com.dt.platform.domain.common.FormData.class ,DELETE_TIME, java.util.Date.class, "删除时间", "删除时间", java.util.Date.class, null);
	
	/**
	 * version , 类型: java.lang.Integer
	*/
	public static final String VERSION="version";
	
	/**
	 * version , 类型: java.lang.Integer
	*/
	public static final BeanProperty<com.dt.platform.domain.common.FormData,java.lang.Integer> VERSION_PROP = new BeanProperty(com.dt.platform.domain.common.FormData.class ,VERSION, java.lang.Integer.class, "version", "version", java.lang.Integer.class, null);
	
	/**
	 * formDataExt , 类型: com.dt.platform.domain.common.FormDataExt
	*/
	public static final String FORM_DATA_EXT="formDataExt";
	
	/**
	 * formDataExt , 类型: com.dt.platform.domain.common.FormDataExt
	*/
	public static final BeanProperty<com.dt.platform.domain.common.FormData,com.dt.platform.domain.common.FormDataExt> FORM_DATA_EXT_PROP = new BeanProperty(com.dt.platform.domain.common.FormData.class ,FORM_DATA_EXT, com.dt.platform.domain.common.FormDataExt.class, "formDataExt", "formDataExt", com.dt.platform.domain.common.FormDataExt.class, null);
	
	/**
	 * 全部属性清单
	*/
	public static final String[] $PROPS={ ID , OWNER_ID , DEF_ID , FORM_ID , DESIGNER_DATA , DATA , FORM_STATUS , CREATE_BY , CREATE_TIME , UPDATE_BY , UPDATE_TIME , DELETED , DELETE_BY , DELETE_TIME , VERSION , FORM_DATA_EXT };
	
	/**
	 * 代理类
	*/
	public static class $$proxy$$ extends com.dt.platform.domain.common.FormData {

		private static final long serialVersionUID = 1L;

		
		/**
		 * 设置 主键
		 * @param id 主键
		 * @return 当前对象
		*/
		public FormData setId(String id) {
			super.change(ID,super.getId(),id);
			super.setId(id);
			return this;
		}
		
		/**
		 * 设置 业务归属
		 * @param ownerId 业务归属
		 * @return 当前对象
		*/
		public FormData setOwnerId(String ownerId) {
			super.change(OWNER_ID,super.getOwnerId(),ownerId);
			super.setOwnerId(ownerId);
			return this;
		}
		
		/**
		 * 设置 表单定义
		 * @param defId 表单定义
		 * @return 当前对象
		*/
		public FormData setDefId(String defId) {
			super.change(DEF_ID,super.getDefId(),defId);
			super.setDefId(defId);
			return this;
		}
		
		/**
		 * 设置 表单
		 * @param formId 表单
		 * @return 当前对象
		*/
		public FormData setFormId(String formId) {
			super.change(FORM_ID,super.getFormId(),formId);
			super.setFormId(formId);
			return this;
		}
		
		/**
		 * 设置 设计
		 * @param designerData 设计
		 * @return 当前对象
		*/
		public FormData setDesignerData(String designerData) {
			super.change(DESIGNER_DATA,super.getDesignerData(),designerData);
			super.setDesignerData(designerData);
			return this;
		}
		
		/**
		 * 设置 数据
		 * @param data 数据
		 * @return 当前对象
		*/
		public FormData setData(String data) {
			super.change(DATA,super.getData(),data);
			super.setData(data);
			return this;
		}
		
		/**
		 * 设置 表单状态
		 * @param formStatus 表单状态
		 * @return 当前对象
		*/
		public FormData setFormStatus(String formStatus) {
			super.change(FORM_STATUS,super.getFormStatus(),formStatus);
			super.setFormStatus(formStatus);
			return this;
		}
		
		/**
		 * 设置 创建人ID
		 * @param createBy 创建人ID
		 * @return 当前对象
		*/
		public FormData setCreateBy(String createBy) {
			super.change(CREATE_BY,super.getCreateBy(),createBy);
			super.setCreateBy(createBy);
			return this;
		}
		
		/**
		 * 设置 创建时间
		 * @param createTime 创建时间
		 * @return 当前对象
		*/
		public FormData setCreateTime(Date createTime) {
			super.change(CREATE_TIME,super.getCreateTime(),createTime);
			super.setCreateTime(createTime);
			return this;
		}
		
		/**
		 * 设置 修改人ID
		 * @param updateBy 修改人ID
		 * @return 当前对象
		*/
		public FormData setUpdateBy(String updateBy) {
			super.change(UPDATE_BY,super.getUpdateBy(),updateBy);
			super.setUpdateBy(updateBy);
			return this;
		}
		
		/**
		 * 设置 修改时间
		 * @param updateTime 修改时间
		 * @return 当前对象
		*/
		public FormData setUpdateTime(Date updateTime) {
			super.change(UPDATE_TIME,super.getUpdateTime(),updateTime);
			super.setUpdateTime(updateTime);
			return this;
		}
		
		/**
		 * 设置 是否已删除
		 * @param deleted 是否已删除
		 * @return 当前对象
		*/
		public FormData setDeleted(Integer deleted) {
			super.change(DELETED,super.getDeleted(),deleted);
			super.setDeleted(deleted);
			return this;
		}
		
		/**
		 * 设置 删除人ID
		 * @param deleteBy 删除人ID
		 * @return 当前对象
		*/
		public FormData setDeleteBy(String deleteBy) {
			super.change(DELETE_BY,super.getDeleteBy(),deleteBy);
			super.setDeleteBy(deleteBy);
			return this;
		}
		
		/**
		 * 设置 删除时间
		 * @param deleteTime 删除时间
		 * @return 当前对象
		*/
		public FormData setDeleteTime(Date deleteTime) {
			super.change(DELETE_TIME,super.getDeleteTime(),deleteTime);
			super.setDeleteTime(deleteTime);
			return this;
		}
		
		/**
		 * 设置 version
		 * @param version version
		 * @return 当前对象
		*/
		public FormData setVersion(Integer version) {
			super.change(VERSION,super.getVersion(),version);
			super.setVersion(version);
			return this;
		}
		
		/**
		 * 设置 formDataExt
		 * @param formDataExt formDataExt
		 * @return 当前对象
		*/
		public FormData setFormDataExt(FormDataExt formDataExt) {
			super.change(FORM_DATA_EXT,super.getFormDataExt(),formDataExt);
			super.setFormDataExt(formDataExt);
			return this;
		}

		/**
		 * 克隆当前对象
		*/
		@Transient
		public FormData clone() {
			return duplicate(true);
		}

		/**
		 * 复制当前对象
		 * @param all 是否复制全部属性，当 false 时，仅复制来自数据表的属性
		*/
		@Transient
		public FormData duplicate(boolean all) {
			$$proxy$$ inst=new $$proxy$$();
			inst.setFormId(this.getFormId());
			inst.setDesignerData(this.getDesignerData());
			inst.setData(this.getData());
			inst.setUpdateTime(this.getUpdateTime());
			inst.setOwnerId(this.getOwnerId());
			inst.setVersion(this.getVersion());
			inst.setDefId(this.getDefId());
			inst.setCreateBy(this.getCreateBy());
			inst.setDeleted(this.getDeleted());
			inst.setCreateTime(this.getCreateTime());
			inst.setUpdateBy(this.getUpdateBy());
			inst.setDeleteTime(this.getDeleteTime());
			inst.setFormStatus(this.getFormStatus());
			inst.setDeleteBy(this.getDeleteBy());
			inst.setId(this.getId());
			if(all) {
				inst.setFormDataExt(this.getFormDataExt());
			}
			inst.clearModifies();
			return inst;
		}

	}
}