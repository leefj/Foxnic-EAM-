package com.dt.platform.domain.common.meta;

import com.github.foxnic.api.bean.BeanProperty;
import com.dt.platform.domain.common.BpmFormData;
import java.util.Date;
import com.dt.platform.domain.common.FormData;
import org.github.foxnic.web.domain.bpm.ProcessInstance;
import java.util.List;
import javax.persistence.Transient;



/**
 * @author 金杰 , maillank@qq.com
 * @since 2023-05-26 14:20:19
 * @sign BB7B5591F8B2573AE19361940C974725
 * 此文件由工具自动生成，请勿修改。若表结构或配置发生变动，请使用工具重新生成。
*/

public class BpmFormDataMeta {
	
	/**
	 * 主键 , 类型: java.lang.String
	*/
	public static final String ID="id";
	
	/**
	 * 主键 , 类型: java.lang.String
	*/
	public static final BeanProperty<com.dt.platform.domain.common.BpmFormData,java.lang.String> ID_PROP = new BeanProperty(com.dt.platform.domain.common.BpmFormData.class ,ID, java.lang.String.class, "主键", "主键", java.lang.String.class, null);
	
	/**
	 * 表单 , 类型: java.lang.String
	*/
	public static final String FORM_ID="formId";
	
	/**
	 * 表单 , 类型: java.lang.String
	*/
	public static final BeanProperty<com.dt.platform.domain.common.BpmFormData,java.lang.String> FORM_ID_PROP = new BeanProperty(com.dt.platform.domain.common.BpmFormData.class ,FORM_ID, java.lang.String.class, "表单", "表单", java.lang.String.class, null);
	
	/**
	 * 数据 , 类型: java.lang.String
	*/
	public static final String FORM_DATA_ID="formDataId";
	
	/**
	 * 数据 , 类型: java.lang.String
	*/
	public static final BeanProperty<com.dt.platform.domain.common.BpmFormData,java.lang.String> FORM_DATA_ID_PROP = new BeanProperty(com.dt.platform.domain.common.BpmFormData.class ,FORM_DATA_ID, java.lang.String.class, "数据", "数据", java.lang.String.class, null);
	
	/**
	 * 备注 , 类型: java.lang.String
	*/
	public static final String NOTES="notes";
	
	/**
	 * 备注 , 类型: java.lang.String
	*/
	public static final BeanProperty<com.dt.platform.domain.common.BpmFormData,java.lang.String> NOTES_PROP = new BeanProperty(com.dt.platform.domain.common.BpmFormData.class ,NOTES, java.lang.String.class, "备注", "备注", java.lang.String.class, null);
	
	/**
	 * 创建人ID , 类型: java.lang.String
	*/
	public static final String CREATE_BY="createBy";
	
	/**
	 * 创建人ID , 类型: java.lang.String
	*/
	public static final BeanProperty<com.dt.platform.domain.common.BpmFormData,java.lang.String> CREATE_BY_PROP = new BeanProperty(com.dt.platform.domain.common.BpmFormData.class ,CREATE_BY, java.lang.String.class, "创建人ID", "创建人ID", java.lang.String.class, null);
	
	/**
	 * 创建时间 , 类型: java.util.Date
	*/
	public static final String CREATE_TIME="createTime";
	
	/**
	 * 创建时间 , 类型: java.util.Date
	*/
	public static final BeanProperty<com.dt.platform.domain.common.BpmFormData,java.util.Date> CREATE_TIME_PROP = new BeanProperty(com.dt.platform.domain.common.BpmFormData.class ,CREATE_TIME, java.util.Date.class, "创建时间", "创建时间", java.util.Date.class, null);
	
	/**
	 * 修改人ID , 类型: java.lang.String
	*/
	public static final String UPDATE_BY="updateBy";
	
	/**
	 * 修改人ID , 类型: java.lang.String
	*/
	public static final BeanProperty<com.dt.platform.domain.common.BpmFormData,java.lang.String> UPDATE_BY_PROP = new BeanProperty(com.dt.platform.domain.common.BpmFormData.class ,UPDATE_BY, java.lang.String.class, "修改人ID", "修改人ID", java.lang.String.class, null);
	
	/**
	 * 修改时间 , 类型: java.util.Date
	*/
	public static final String UPDATE_TIME="updateTime";
	
	/**
	 * 修改时间 , 类型: java.util.Date
	*/
	public static final BeanProperty<com.dt.platform.domain.common.BpmFormData,java.util.Date> UPDATE_TIME_PROP = new BeanProperty(com.dt.platform.domain.common.BpmFormData.class ,UPDATE_TIME, java.util.Date.class, "修改时间", "修改时间", java.util.Date.class, null);
	
	/**
	 * 是否已删除 , 类型: java.lang.Integer
	*/
	public static final String DELETED="deleted";
	
	/**
	 * 是否已删除 , 类型: java.lang.Integer
	*/
	public static final BeanProperty<com.dt.platform.domain.common.BpmFormData,java.lang.Integer> DELETED_PROP = new BeanProperty(com.dt.platform.domain.common.BpmFormData.class ,DELETED, java.lang.Integer.class, "是否已删除", "是否已删除", java.lang.Integer.class, null);
	
	/**
	 * 删除人ID , 类型: java.lang.String
	*/
	public static final String DELETE_BY="deleteBy";
	
	/**
	 * 删除人ID , 类型: java.lang.String
	*/
	public static final BeanProperty<com.dt.platform.domain.common.BpmFormData,java.lang.String> DELETE_BY_PROP = new BeanProperty(com.dt.platform.domain.common.BpmFormData.class ,DELETE_BY, java.lang.String.class, "删除人ID", "删除人ID", java.lang.String.class, null);
	
	/**
	 * 删除时间 , 类型: java.util.Date
	*/
	public static final String DELETE_TIME="deleteTime";
	
	/**
	 * 删除时间 , 类型: java.util.Date
	*/
	public static final BeanProperty<com.dt.platform.domain.common.BpmFormData,java.util.Date> DELETE_TIME_PROP = new BeanProperty(com.dt.platform.domain.common.BpmFormData.class ,DELETE_TIME, java.util.Date.class, "删除时间", "删除时间", java.util.Date.class, null);
	
	/**
	 * version , 类型: java.lang.Integer
	*/
	public static final String VERSION="version";
	
	/**
	 * version , 类型: java.lang.Integer
	*/
	public static final BeanProperty<com.dt.platform.domain.common.BpmFormData,java.lang.Integer> VERSION_PROP = new BeanProperty(com.dt.platform.domain.common.BpmFormData.class ,VERSION, java.lang.Integer.class, "version", "version", java.lang.Integer.class, null);
	
	/**
	 * formData , 类型: com.dt.platform.domain.common.FormData
	*/
	public static final String FORM_DATA="formData";
	
	/**
	 * formData , 类型: com.dt.platform.domain.common.FormData
	*/
	public static final BeanProperty<com.dt.platform.domain.common.BpmFormData,com.dt.platform.domain.common.FormData> FORM_DATA_PROP = new BeanProperty(com.dt.platform.domain.common.BpmFormData.class ,FORM_DATA, com.dt.platform.domain.common.FormData.class, "formData", "formData", com.dt.platform.domain.common.FormData.class, null);
	
	/**
	 * 历史流程清单 , 集合类型: LIST , 类型: org.github.foxnic.web.domain.bpm.ProcessInstance
	*/
	public static final String HISTORIC_PROCESS_LIST="historicProcessList";
	
	/**
	 * 历史流程清单 , 集合类型: LIST , 类型: org.github.foxnic.web.domain.bpm.ProcessInstance
	*/
	public static final BeanProperty<com.dt.platform.domain.common.BpmFormData,org.github.foxnic.web.domain.bpm.ProcessInstance> HISTORIC_PROCESS_LIST_PROP = new BeanProperty(com.dt.platform.domain.common.BpmFormData.class ,HISTORIC_PROCESS_LIST, java.util.List.class, "历史流程清单", "历史流程清单", org.github.foxnic.web.domain.bpm.ProcessInstance.class, null);
	
	/**
	 * 在批的流程清单 , 集合类型: LIST , 类型: org.github.foxnic.web.domain.bpm.ProcessInstance
	*/
	public static final String CURRENT_PROCESS_LIST="currentProcessList";
	
	/**
	 * 在批的流程清单 , 集合类型: LIST , 类型: org.github.foxnic.web.domain.bpm.ProcessInstance
	*/
	public static final BeanProperty<com.dt.platform.domain.common.BpmFormData,org.github.foxnic.web.domain.bpm.ProcessInstance> CURRENT_PROCESS_LIST_PROP = new BeanProperty(com.dt.platform.domain.common.BpmFormData.class ,CURRENT_PROCESS_LIST, java.util.List.class, "在批的流程清单", "在批的流程清单", org.github.foxnic.web.domain.bpm.ProcessInstance.class, null);
	
	/**
	 * 默认流程 , 优先取在批的流程 , 类型: org.github.foxnic.web.domain.bpm.ProcessInstance
	*/
	public static final String DEFAULT_PROCESS="defaultProcess";
	
	/**
	 * 默认流程 , 优先取在批的流程 , 类型: org.github.foxnic.web.domain.bpm.ProcessInstance
	*/
	public static final BeanProperty<com.dt.platform.domain.common.BpmFormData,org.github.foxnic.web.domain.bpm.ProcessInstance> DEFAULT_PROCESS_PROP = new BeanProperty(com.dt.platform.domain.common.BpmFormData.class ,DEFAULT_PROCESS, org.github.foxnic.web.domain.bpm.ProcessInstance.class, "默认流程", "优先取在批的流程", org.github.foxnic.web.domain.bpm.ProcessInstance.class, null);
	
	/**
	 * 全部属性清单
	*/
	public static final String[] $PROPS={ ID , FORM_ID , FORM_DATA_ID , NOTES , CREATE_BY , CREATE_TIME , UPDATE_BY , UPDATE_TIME , DELETED , DELETE_BY , DELETE_TIME , VERSION , FORM_DATA , HISTORIC_PROCESS_LIST , CURRENT_PROCESS_LIST , DEFAULT_PROCESS };
	
	/**
	 * 代理类
	*/
	public static class $$proxy$$ extends com.dt.platform.domain.common.BpmFormData {

		private static final long serialVersionUID = 1L;

		
		/**
		 * 设置 主键
		 * @param id 主键
		 * @return 当前对象
		*/
		public BpmFormData setId(String id) {
			super.change(ID,super.getId(),id);
			super.setId(id);
			return this;
		}
		
		/**
		 * 设置 表单
		 * @param formId 表单
		 * @return 当前对象
		*/
		public BpmFormData setFormId(String formId) {
			super.change(FORM_ID,super.getFormId(),formId);
			super.setFormId(formId);
			return this;
		}
		
		/**
		 * 设置 数据
		 * @param formDataId 数据
		 * @return 当前对象
		*/
		public BpmFormData setFormDataId(String formDataId) {
			super.change(FORM_DATA_ID,super.getFormDataId(),formDataId);
			super.setFormDataId(formDataId);
			return this;
		}
		
		/**
		 * 设置 备注
		 * @param notes 备注
		 * @return 当前对象
		*/
		public BpmFormData setNotes(String notes) {
			super.change(NOTES,super.getNotes(),notes);
			super.setNotes(notes);
			return this;
		}
		
		/**
		 * 设置 创建人ID
		 * @param createBy 创建人ID
		 * @return 当前对象
		*/
		public BpmFormData setCreateBy(String createBy) {
			super.change(CREATE_BY,super.getCreateBy(),createBy);
			super.setCreateBy(createBy);
			return this;
		}
		
		/**
		 * 设置 创建时间
		 * @param createTime 创建时间
		 * @return 当前对象
		*/
		public BpmFormData setCreateTime(Date createTime) {
			super.change(CREATE_TIME,super.getCreateTime(),createTime);
			super.setCreateTime(createTime);
			return this;
		}
		
		/**
		 * 设置 修改人ID
		 * @param updateBy 修改人ID
		 * @return 当前对象
		*/
		public BpmFormData setUpdateBy(String updateBy) {
			super.change(UPDATE_BY,super.getUpdateBy(),updateBy);
			super.setUpdateBy(updateBy);
			return this;
		}
		
		/**
		 * 设置 修改时间
		 * @param updateTime 修改时间
		 * @return 当前对象
		*/
		public BpmFormData setUpdateTime(Date updateTime) {
			super.change(UPDATE_TIME,super.getUpdateTime(),updateTime);
			super.setUpdateTime(updateTime);
			return this;
		}
		
		/**
		 * 设置 是否已删除
		 * @param deleted 是否已删除
		 * @return 当前对象
		*/
		public BpmFormData setDeleted(Integer deleted) {
			super.change(DELETED,super.getDeleted(),deleted);
			super.setDeleted(deleted);
			return this;
		}
		
		/**
		 * 设置 删除人ID
		 * @param deleteBy 删除人ID
		 * @return 当前对象
		*/
		public BpmFormData setDeleteBy(String deleteBy) {
			super.change(DELETE_BY,super.getDeleteBy(),deleteBy);
			super.setDeleteBy(deleteBy);
			return this;
		}
		
		/**
		 * 设置 删除时间
		 * @param deleteTime 删除时间
		 * @return 当前对象
		*/
		public BpmFormData setDeleteTime(Date deleteTime) {
			super.change(DELETE_TIME,super.getDeleteTime(),deleteTime);
			super.setDeleteTime(deleteTime);
			return this;
		}
		
		/**
		 * 设置 version
		 * @param version version
		 * @return 当前对象
		*/
		public BpmFormData setVersion(Integer version) {
			super.change(VERSION,super.getVersion(),version);
			super.setVersion(version);
			return this;
		}
		
		/**
		 * 设置 formData
		 * @param formData formData
		 * @return 当前对象
		*/
		public BpmFormData setFormData(FormData formData) {
			super.change(FORM_DATA,super.getFormData(),formData);
			super.setFormData(formData);
			return this;
		}
		
		/**
		 * 设置 历史流程清单
		 * @param historicProcessList 历史流程清单
		 * @return 当前对象
		*/
		public BpmFormData setHistoricProcessList(List<ProcessInstance> historicProcessList) {
			super.change(HISTORIC_PROCESS_LIST,super.getHistoricProcessList(),historicProcessList);
			super.setHistoricProcessList(historicProcessList);
			return this;
		}
		
		/**
		 * 设置 在批的流程清单
		 * @param currentProcessList 在批的流程清单
		 * @return 当前对象
		*/
		public BpmFormData setCurrentProcessList(List<ProcessInstance> currentProcessList) {
			super.change(CURRENT_PROCESS_LIST,super.getCurrentProcessList(),currentProcessList);
			super.setCurrentProcessList(currentProcessList);
			return this;
		}
		
		/**
		 * 设置 默认流程
		 * @param defaultProcess 默认流程
		 * @return 当前对象
		*/
		public BpmFormData setDefaultProcess(ProcessInstance defaultProcess) {
			super.change(DEFAULT_PROCESS,super.getDefaultProcess(),defaultProcess);
			super.setDefaultProcess(defaultProcess);
			return this;
		}

		/**
		 * 克隆当前对象
		*/
		@Transient
		public BpmFormData clone() {
			return duplicate(true);
		}

		/**
		 * 复制当前对象
		 * @param all 是否复制全部属性，当 false 时，仅复制来自数据表的属性
		*/
		@Transient
		public BpmFormData duplicate(boolean all) {
			$$proxy$$ inst=new $$proxy$$();
			inst.setFormId(this.getFormId());
			inst.setCreateBy(this.getCreateBy());
			inst.setNotes(this.getNotes());
			inst.setDeleted(this.getDeleted());
			inst.setCreateTime(this.getCreateTime());
			inst.setUpdateBy(this.getUpdateBy());
			inst.setDeleteTime(this.getDeleteTime());
			inst.setDeleteBy(this.getDeleteBy());
			inst.setFormDataId(this.getFormDataId());
			inst.setUpdateTime(this.getUpdateTime());
			inst.setId(this.getId());
			inst.setVersion(this.getVersion());
			if(all) {
				inst.setFormData(this.getFormData());
				inst.setHistoricProcessList(this.getHistoricProcessList());
				inst.setCurrentProcessList(this.getCurrentProcessList());
				inst.setDefaultProcess(this.getDefaultProcess());
			}
			inst.clearModifies();
			return inst;
		}

	}
}