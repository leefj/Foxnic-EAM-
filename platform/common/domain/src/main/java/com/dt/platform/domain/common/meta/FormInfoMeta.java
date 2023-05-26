package com.dt.platform.domain.common.meta;

import com.github.foxnic.api.bean.BeanProperty;
import com.dt.platform.domain.common.FormInfo;
import java.util.Date;
import com.dt.platform.domain.common.FormCategory;
import com.dt.platform.domain.common.FormDef;
import com.dt.platform.domain.common.FormData;
import javax.persistence.Transient;



/**
 * @author 金杰 , maillank@qq.com
 * @since 2023-05-26 14:18:15
 * @sign 1FC1284780557AA1C74630C367B51017
 * 此文件由工具自动生成，请勿修改。若表结构或配置发生变动，请使用工具重新生成。
*/

public class FormInfoMeta {
	
	/**
	 * 主键 , 类型: java.lang.String
	*/
	public static final String ID="id";
	
	/**
	 * 主键 , 类型: java.lang.String
	*/
	public static final BeanProperty<com.dt.platform.domain.common.FormInfo,java.lang.String> ID_PROP = new BeanProperty(com.dt.platform.domain.common.FormInfo.class ,ID, java.lang.String.class, "主键", "主键", java.lang.String.class, null);
	
	/**
	 * 编码 , 类型: java.lang.String
	*/
	public static final String CODE="code";
	
	/**
	 * 编码 , 类型: java.lang.String
	*/
	public static final BeanProperty<com.dt.platform.domain.common.FormInfo,java.lang.String> CODE_PROP = new BeanProperty(com.dt.platform.domain.common.FormInfo.class ,CODE, java.lang.String.class, "编码", "编码", java.lang.String.class, null);
	
	/**
	 * 分类 , 类型: java.lang.String
	*/
	public static final String CATALOG_ID="catalogId";
	
	/**
	 * 分类 , 类型: java.lang.String
	*/
	public static final BeanProperty<com.dt.platform.domain.common.FormInfo,java.lang.String> CATALOG_ID_PROP = new BeanProperty(com.dt.platform.domain.common.FormInfo.class ,CATALOG_ID, java.lang.String.class, "分类", "分类", java.lang.String.class, null);
	
	/**
	 * 名称 , 类型: java.lang.String
	*/
	public static final String NAME="name";
	
	/**
	 * 名称 , 类型: java.lang.String
	*/
	public static final BeanProperty<com.dt.platform.domain.common.FormInfo,java.lang.String> NAME_PROP = new BeanProperty(com.dt.platform.domain.common.FormInfo.class ,NAME, java.lang.String.class, "名称", "名称", java.lang.String.class, null);
	
	/**
	 * 状态 , 类型: java.lang.String
	*/
	public static final String STATUS="status";
	
	/**
	 * 状态 , 类型: java.lang.String
	*/
	public static final BeanProperty<com.dt.platform.domain.common.FormInfo,java.lang.String> STATUS_PROP = new BeanProperty(com.dt.platform.domain.common.FormInfo.class ,STATUS, java.lang.String.class, "状态", "状态", java.lang.String.class, null);
	
	/**
	 * 路径 , 类型: java.lang.String
	*/
	public static final String ROUTE="route";
	
	/**
	 * 路径 , 类型: java.lang.String
	*/
	public static final BeanProperty<com.dt.platform.domain.common.FormInfo,java.lang.String> ROUTE_PROP = new BeanProperty(com.dt.platform.domain.common.FormInfo.class ,ROUTE, java.lang.String.class, "路径", "路径", java.lang.String.class, null);
	
	/**
	 * 备注 , 类型: java.lang.String
	*/
	public static final String NOTES="notes";
	
	/**
	 * 备注 , 类型: java.lang.String
	*/
	public static final BeanProperty<com.dt.platform.domain.common.FormInfo,java.lang.String> NOTES_PROP = new BeanProperty(com.dt.platform.domain.common.FormInfo.class ,NOTES, java.lang.String.class, "备注", "备注", java.lang.String.class, null);
	
	/**
	 * 存储 , 类型: java.lang.String
	*/
	public static final String STORAGE="storage";
	
	/**
	 * 存储 , 类型: java.lang.String
	*/
	public static final BeanProperty<com.dt.platform.domain.common.FormInfo,java.lang.String> STORAGE_PROP = new BeanProperty(com.dt.platform.domain.common.FormInfo.class ,STORAGE, java.lang.String.class, "存储", "存储", java.lang.String.class, null);
	
	/**
	 * 创建人ID , 类型: java.lang.String
	*/
	public static final String CREATE_BY="createBy";
	
	/**
	 * 创建人ID , 类型: java.lang.String
	*/
	public static final BeanProperty<com.dt.platform.domain.common.FormInfo,java.lang.String> CREATE_BY_PROP = new BeanProperty(com.dt.platform.domain.common.FormInfo.class ,CREATE_BY, java.lang.String.class, "创建人ID", "创建人ID", java.lang.String.class, null);
	
	/**
	 * 创建时间 , 类型: java.util.Date
	*/
	public static final String CREATE_TIME="createTime";
	
	/**
	 * 创建时间 , 类型: java.util.Date
	*/
	public static final BeanProperty<com.dt.platform.domain.common.FormInfo,java.util.Date> CREATE_TIME_PROP = new BeanProperty(com.dt.platform.domain.common.FormInfo.class ,CREATE_TIME, java.util.Date.class, "创建时间", "创建时间", java.util.Date.class, null);
	
	/**
	 * 修改人ID , 类型: java.lang.String
	*/
	public static final String UPDATE_BY="updateBy";
	
	/**
	 * 修改人ID , 类型: java.lang.String
	*/
	public static final BeanProperty<com.dt.platform.domain.common.FormInfo,java.lang.String> UPDATE_BY_PROP = new BeanProperty(com.dt.platform.domain.common.FormInfo.class ,UPDATE_BY, java.lang.String.class, "修改人ID", "修改人ID", java.lang.String.class, null);
	
	/**
	 * 修改时间 , 类型: java.util.Date
	*/
	public static final String UPDATE_TIME="updateTime";
	
	/**
	 * 修改时间 , 类型: java.util.Date
	*/
	public static final BeanProperty<com.dt.platform.domain.common.FormInfo,java.util.Date> UPDATE_TIME_PROP = new BeanProperty(com.dt.platform.domain.common.FormInfo.class ,UPDATE_TIME, java.util.Date.class, "修改时间", "修改时间", java.util.Date.class, null);
	
	/**
	 * 是否已删除 , 类型: java.lang.Integer
	*/
	public static final String DELETED="deleted";
	
	/**
	 * 是否已删除 , 类型: java.lang.Integer
	*/
	public static final BeanProperty<com.dt.platform.domain.common.FormInfo,java.lang.Integer> DELETED_PROP = new BeanProperty(com.dt.platform.domain.common.FormInfo.class ,DELETED, java.lang.Integer.class, "是否已删除", "是否已删除", java.lang.Integer.class, null);
	
	/**
	 * 删除人ID , 类型: java.lang.String
	*/
	public static final String DELETE_BY="deleteBy";
	
	/**
	 * 删除人ID , 类型: java.lang.String
	*/
	public static final BeanProperty<com.dt.platform.domain.common.FormInfo,java.lang.String> DELETE_BY_PROP = new BeanProperty(com.dt.platform.domain.common.FormInfo.class ,DELETE_BY, java.lang.String.class, "删除人ID", "删除人ID", java.lang.String.class, null);
	
	/**
	 * 删除时间 , 类型: java.util.Date
	*/
	public static final String DELETE_TIME="deleteTime";
	
	/**
	 * 删除时间 , 类型: java.util.Date
	*/
	public static final BeanProperty<com.dt.platform.domain.common.FormInfo,java.util.Date> DELETE_TIME_PROP = new BeanProperty(com.dt.platform.domain.common.FormInfo.class ,DELETE_TIME, java.util.Date.class, "删除时间", "删除时间", java.util.Date.class, null);
	
	/**
	 * version , 类型: java.lang.Integer
	*/
	public static final String VERSION="version";
	
	/**
	 * version , 类型: java.lang.Integer
	*/
	public static final BeanProperty<com.dt.platform.domain.common.FormInfo,java.lang.Integer> VERSION_PROP = new BeanProperty(com.dt.platform.domain.common.FormInfo.class ,VERSION, java.lang.Integer.class, "version", "version", java.lang.Integer.class, null);
	
	/**
	 * 租户 , 类型: java.lang.String
	*/
	public static final String TENANT_ID="tenantId";
	
	/**
	 * 租户 , 类型: java.lang.String
	*/
	public static final BeanProperty<com.dt.platform.domain.common.FormInfo,java.lang.String> TENANT_ID_PROP = new BeanProperty(com.dt.platform.domain.common.FormInfo.class ,TENANT_ID, java.lang.String.class, "租户", "租户", java.lang.String.class, null);
	
	/**
	 * formCategory , reportCategory , 类型: com.dt.platform.domain.common.FormCategory
	*/
	public static final String FORM_CATEGORY="formCategory";
	
	/**
	 * formCategory , reportCategory , 类型: com.dt.platform.domain.common.FormCategory
	*/
	public static final BeanProperty<com.dt.platform.domain.common.FormInfo,com.dt.platform.domain.common.FormCategory> FORM_CATEGORY_PROP = new BeanProperty(com.dt.platform.domain.common.FormInfo.class ,FORM_CATEGORY, com.dt.platform.domain.common.FormCategory.class, "formCategory", "reportCategory", com.dt.platform.domain.common.FormCategory.class, null);
	
	/**
	 * formDef , 类型: com.dt.platform.domain.common.FormDef
	*/
	public static final String FORM_DEF="formDef";
	
	/**
	 * formDef , 类型: com.dt.platform.domain.common.FormDef
	*/
	public static final BeanProperty<com.dt.platform.domain.common.FormInfo,com.dt.platform.domain.common.FormDef> FORM_DEF_PROP = new BeanProperty(com.dt.platform.domain.common.FormInfo.class ,FORM_DEF, com.dt.platform.domain.common.FormDef.class, "formDef", "formDef", com.dt.platform.domain.common.FormDef.class, null);
	
	/**
	 * newFormData , 类型: com.dt.platform.domain.common.FormData
	*/
	public static final String NEW_FORM_DATA="newFormData";
	
	/**
	 * newFormData , 类型: com.dt.platform.domain.common.FormData
	*/
	public static final BeanProperty<com.dt.platform.domain.common.FormInfo,com.dt.platform.domain.common.FormData> NEW_FORM_DATA_PROP = new BeanProperty(com.dt.platform.domain.common.FormInfo.class ,NEW_FORM_DATA, com.dt.platform.domain.common.FormData.class, "newFormData", "newFormData", com.dt.platform.domain.common.FormData.class, null);
	
	/**
	 * 全部属性清单
	*/
	public static final String[] $PROPS={ ID , CODE , CATALOG_ID , NAME , STATUS , ROUTE , NOTES , STORAGE , CREATE_BY , CREATE_TIME , UPDATE_BY , UPDATE_TIME , DELETED , DELETE_BY , DELETE_TIME , VERSION , TENANT_ID , FORM_CATEGORY , FORM_DEF , NEW_FORM_DATA };
	
	/**
	 * 代理类
	*/
	public static class $$proxy$$ extends com.dt.platform.domain.common.FormInfo {

		private static final long serialVersionUID = 1L;

		
		/**
		 * 设置 主键
		 * @param id 主键
		 * @return 当前对象
		*/
		public FormInfo setId(String id) {
			super.change(ID,super.getId(),id);
			super.setId(id);
			return this;
		}
		
		/**
		 * 设置 编码
		 * @param code 编码
		 * @return 当前对象
		*/
		public FormInfo setCode(String code) {
			super.change(CODE,super.getCode(),code);
			super.setCode(code);
			return this;
		}
		
		/**
		 * 设置 分类
		 * @param catalogId 分类
		 * @return 当前对象
		*/
		public FormInfo setCatalogId(String catalogId) {
			super.change(CATALOG_ID,super.getCatalogId(),catalogId);
			super.setCatalogId(catalogId);
			return this;
		}
		
		/**
		 * 设置 名称
		 * @param name 名称
		 * @return 当前对象
		*/
		public FormInfo setName(String name) {
			super.change(NAME,super.getName(),name);
			super.setName(name);
			return this;
		}
		
		/**
		 * 设置 状态
		 * @param status 状态
		 * @return 当前对象
		*/
		public FormInfo setStatus(String status) {
			super.change(STATUS,super.getStatus(),status);
			super.setStatus(status);
			return this;
		}
		
		/**
		 * 设置 路径
		 * @param route 路径
		 * @return 当前对象
		*/
		public FormInfo setRoute(String route) {
			super.change(ROUTE,super.getRoute(),route);
			super.setRoute(route);
			return this;
		}
		
		/**
		 * 设置 备注
		 * @param notes 备注
		 * @return 当前对象
		*/
		public FormInfo setNotes(String notes) {
			super.change(NOTES,super.getNotes(),notes);
			super.setNotes(notes);
			return this;
		}
		
		/**
		 * 设置 存储
		 * @param storage 存储
		 * @return 当前对象
		*/
		public FormInfo setStorage(String storage) {
			super.change(STORAGE,super.getStorage(),storage);
			super.setStorage(storage);
			return this;
		}
		
		/**
		 * 设置 创建人ID
		 * @param createBy 创建人ID
		 * @return 当前对象
		*/
		public FormInfo setCreateBy(String createBy) {
			super.change(CREATE_BY,super.getCreateBy(),createBy);
			super.setCreateBy(createBy);
			return this;
		}
		
		/**
		 * 设置 创建时间
		 * @param createTime 创建时间
		 * @return 当前对象
		*/
		public FormInfo setCreateTime(Date createTime) {
			super.change(CREATE_TIME,super.getCreateTime(),createTime);
			super.setCreateTime(createTime);
			return this;
		}
		
		/**
		 * 设置 修改人ID
		 * @param updateBy 修改人ID
		 * @return 当前对象
		*/
		public FormInfo setUpdateBy(String updateBy) {
			super.change(UPDATE_BY,super.getUpdateBy(),updateBy);
			super.setUpdateBy(updateBy);
			return this;
		}
		
		/**
		 * 设置 修改时间
		 * @param updateTime 修改时间
		 * @return 当前对象
		*/
		public FormInfo setUpdateTime(Date updateTime) {
			super.change(UPDATE_TIME,super.getUpdateTime(),updateTime);
			super.setUpdateTime(updateTime);
			return this;
		}
		
		/**
		 * 设置 是否已删除
		 * @param deleted 是否已删除
		 * @return 当前对象
		*/
		public FormInfo setDeleted(Integer deleted) {
			super.change(DELETED,super.getDeleted(),deleted);
			super.setDeleted(deleted);
			return this;
		}
		
		/**
		 * 设置 删除人ID
		 * @param deleteBy 删除人ID
		 * @return 当前对象
		*/
		public FormInfo setDeleteBy(String deleteBy) {
			super.change(DELETE_BY,super.getDeleteBy(),deleteBy);
			super.setDeleteBy(deleteBy);
			return this;
		}
		
		/**
		 * 设置 删除时间
		 * @param deleteTime 删除时间
		 * @return 当前对象
		*/
		public FormInfo setDeleteTime(Date deleteTime) {
			super.change(DELETE_TIME,super.getDeleteTime(),deleteTime);
			super.setDeleteTime(deleteTime);
			return this;
		}
		
		/**
		 * 设置 version
		 * @param version version
		 * @return 当前对象
		*/
		public FormInfo setVersion(Integer version) {
			super.change(VERSION,super.getVersion(),version);
			super.setVersion(version);
			return this;
		}
		
		/**
		 * 设置 租户
		 * @param tenantId 租户
		 * @return 当前对象
		*/
		public FormInfo setTenantId(String tenantId) {
			super.change(TENANT_ID,super.getTenantId(),tenantId);
			super.setTenantId(tenantId);
			return this;
		}
		
		/**
		 * 设置 formCategory
		 * @param formCategory formCategory
		 * @return 当前对象
		*/
		public FormInfo setFormCategory(FormCategory formCategory) {
			super.change(FORM_CATEGORY,super.getFormCategory(),formCategory);
			super.setFormCategory(formCategory);
			return this;
		}
		
		/**
		 * 设置 formDef
		 * @param formDef formDef
		 * @return 当前对象
		*/
		public FormInfo setFormDef(FormDef formDef) {
			super.change(FORM_DEF,super.getFormDef(),formDef);
			super.setFormDef(formDef);
			return this;
		}
		
		/**
		 * 设置 newFormData
		 * @param newFormData newFormData
		 * @return 当前对象
		*/
		public FormInfo setNewFormData(FormData newFormData) {
			super.change(NEW_FORM_DATA,super.getNewFormData(),newFormData);
			super.setNewFormData(newFormData);
			return this;
		}

		/**
		 * 克隆当前对象
		*/
		@Transient
		public FormInfo clone() {
			return duplicate(true);
		}

		/**
		 * 复制当前对象
		 * @param all 是否复制全部属性，当 false 时，仅复制来自数据表的属性
		*/
		@Transient
		public FormInfo duplicate(boolean all) {
			$$proxy$$ inst=new $$proxy$$();
			inst.setCode(this.getCode());
			inst.setNotes(this.getNotes());
			inst.setUpdateTime(this.getUpdateTime());
			inst.setStorage(this.getStorage());
			inst.setVersion(this.getVersion());
			inst.setCreateBy(this.getCreateBy());
			inst.setCatalogId(this.getCatalogId());
			inst.setRoute(this.getRoute());
			inst.setDeleted(this.getDeleted());
			inst.setCreateTime(this.getCreateTime());
			inst.setUpdateBy(this.getUpdateBy());
			inst.setDeleteTime(this.getDeleteTime());
			inst.setName(this.getName());
			inst.setTenantId(this.getTenantId());
			inst.setDeleteBy(this.getDeleteBy());
			inst.setId(this.getId());
			inst.setStatus(this.getStatus());
			if(all) {
				inst.setNewFormData(this.getNewFormData());
				inst.setFormCategory(this.getFormCategory());
				inst.setFormDef(this.getFormDef());
			}
			inst.clearModifies();
			return inst;
		}

	}
}