package com.dt.platform.domain.common.meta;

import com.github.foxnic.api.bean.BeanProperty;
import com.dt.platform.domain.common.ScreenDsData;
import java.util.Date;
import com.dt.platform.domain.common.ScreenDsCategory;
import com.dt.platform.domain.common.ScreenDsDb;
import com.dt.platform.domain.common.ScreenDsApi;
import java.util.List;
import javax.persistence.Transient;



/**
 * @author 金杰 , maillank@qq.com
 * @since 2023-10-28 08:24:17
 * @sign 442090C9207A5B3B74888904CF39AE44
 * 此文件由工具自动生成，请勿修改。若表结构或配置发生变动，请使用工具重新生成。
*/

public class ScreenDsDataMeta {
	
	/**
	 * 主键 , 类型: java.lang.String
	*/
	public static final String ID="id";
	
	/**
	 * 主键 , 类型: java.lang.String
	*/
	public static final BeanProperty<com.dt.platform.domain.common.ScreenDsData,java.lang.String> ID_PROP = new BeanProperty(com.dt.platform.domain.common.ScreenDsData.class ,ID, java.lang.String.class, "主键", "主键", java.lang.String.class, null);
	
	/**
	 * 编号 , 类型: java.lang.String
	*/
	public static final String CODE="code";
	
	/**
	 * 编号 , 类型: java.lang.String
	*/
	public static final BeanProperty<com.dt.platform.domain.common.ScreenDsData,java.lang.String> CODE_PROP = new BeanProperty(com.dt.platform.domain.common.ScreenDsData.class ,CODE, java.lang.String.class, "编号", "编号", java.lang.String.class, null);
	
	/**
	 * 名称 , 类型: java.lang.String
	*/
	public static final String NAME="name";
	
	/**
	 * 名称 , 类型: java.lang.String
	*/
	public static final BeanProperty<com.dt.platform.domain.common.ScreenDsData,java.lang.String> NAME_PROP = new BeanProperty(com.dt.platform.domain.common.ScreenDsData.class ,NAME, java.lang.String.class, "名称", "名称", java.lang.String.class, null);
	
	/**
	 * 来源 , 类型: java.lang.String
	*/
	public static final String SOURCE_CODE="sourceCode";
	
	/**
	 * 来源 , 类型: java.lang.String
	*/
	public static final BeanProperty<com.dt.platform.domain.common.ScreenDsData,java.lang.String> SOURCE_CODE_PROP = new BeanProperty(com.dt.platform.domain.common.ScreenDsData.class ,SOURCE_CODE, java.lang.String.class, "来源", "来源", java.lang.String.class, null);
	
	/**
	 * 分类 , 类型: java.lang.String
	*/
	public static final String CATEGORY_ID="categoryId";
	
	/**
	 * 分类 , 类型: java.lang.String
	*/
	public static final BeanProperty<com.dt.platform.domain.common.ScreenDsData,java.lang.String> CATEGORY_ID_PROP = new BeanProperty(com.dt.platform.domain.common.ScreenDsData.class ,CATEGORY_ID, java.lang.String.class, "分类", "分类", java.lang.String.class, null);
	
	/**
	 * 数据库 , 类型: java.lang.String
	*/
	public static final String DS_CODE="dsCode";
	
	/**
	 * 数据库 , 类型: java.lang.String
	*/
	public static final BeanProperty<com.dt.platform.domain.common.ScreenDsData,java.lang.String> DS_CODE_PROP = new BeanProperty(com.dt.platform.domain.common.ScreenDsData.class ,DS_CODE, java.lang.String.class, "数据库", "数据库", java.lang.String.class, null);
	
	/**
	 * 内容 , 类型: java.lang.String
	*/
	public static final String CT_TEXT="ctText";
	
	/**
	 * 内容 , 类型: java.lang.String
	*/
	public static final BeanProperty<com.dt.platform.domain.common.ScreenDsData,java.lang.String> CT_TEXT_PROP = new BeanProperty(com.dt.platform.domain.common.ScreenDsData.class ,CT_TEXT, java.lang.String.class, "内容", "内容", java.lang.String.class, null);
	
	/**
	 * 转换脚本 , 类型: java.lang.String
	*/
	public static final String RESULT_ACTION="resultAction";
	
	/**
	 * 转换脚本 , 类型: java.lang.String
	*/
	public static final BeanProperty<com.dt.platform.domain.common.ScreenDsData,java.lang.String> RESULT_ACTION_PROP = new BeanProperty(com.dt.platform.domain.common.ScreenDsData.class ,RESULT_ACTION, java.lang.String.class, "转换脚本", "转换脚本", java.lang.String.class, null);
	
	/**
	 * 备注 , 类型: java.lang.String
	*/
	public static final String NOTES="notes";
	
	/**
	 * 备注 , 类型: java.lang.String
	*/
	public static final BeanProperty<com.dt.platform.domain.common.ScreenDsData,java.lang.String> NOTES_PROP = new BeanProperty(com.dt.platform.domain.common.ScreenDsData.class ,NOTES, java.lang.String.class, "备注", "备注", java.lang.String.class, null);
	
	/**
	 * 创建人ID , 类型: java.lang.String
	*/
	public static final String CREATE_BY="createBy";
	
	/**
	 * 创建人ID , 类型: java.lang.String
	*/
	public static final BeanProperty<com.dt.platform.domain.common.ScreenDsData,java.lang.String> CREATE_BY_PROP = new BeanProperty(com.dt.platform.domain.common.ScreenDsData.class ,CREATE_BY, java.lang.String.class, "创建人ID", "创建人ID", java.lang.String.class, null);
	
	/**
	 * 创建时间 , 类型: java.util.Date
	*/
	public static final String CREATE_TIME="createTime";
	
	/**
	 * 创建时间 , 类型: java.util.Date
	*/
	public static final BeanProperty<com.dt.platform.domain.common.ScreenDsData,java.util.Date> CREATE_TIME_PROP = new BeanProperty(com.dt.platform.domain.common.ScreenDsData.class ,CREATE_TIME, java.util.Date.class, "创建时间", "创建时间", java.util.Date.class, null);
	
	/**
	 * 修改人ID , 类型: java.lang.String
	*/
	public static final String UPDATE_BY="updateBy";
	
	/**
	 * 修改人ID , 类型: java.lang.String
	*/
	public static final BeanProperty<com.dt.platform.domain.common.ScreenDsData,java.lang.String> UPDATE_BY_PROP = new BeanProperty(com.dt.platform.domain.common.ScreenDsData.class ,UPDATE_BY, java.lang.String.class, "修改人ID", "修改人ID", java.lang.String.class, null);
	
	/**
	 * 修改时间 , 类型: java.util.Date
	*/
	public static final String UPDATE_TIME="updateTime";
	
	/**
	 * 修改时间 , 类型: java.util.Date
	*/
	public static final BeanProperty<com.dt.platform.domain.common.ScreenDsData,java.util.Date> UPDATE_TIME_PROP = new BeanProperty(com.dt.platform.domain.common.ScreenDsData.class ,UPDATE_TIME, java.util.Date.class, "修改时间", "修改时间", java.util.Date.class, null);
	
	/**
	 * 是否已删除 , 类型: java.lang.Integer
	*/
	public static final String DELETED="deleted";
	
	/**
	 * 是否已删除 , 类型: java.lang.Integer
	*/
	public static final BeanProperty<com.dt.platform.domain.common.ScreenDsData,java.lang.Integer> DELETED_PROP = new BeanProperty(com.dt.platform.domain.common.ScreenDsData.class ,DELETED, java.lang.Integer.class, "是否已删除", "是否已删除", java.lang.Integer.class, null);
	
	/**
	 * 删除人ID , 类型: java.lang.String
	*/
	public static final String DELETE_BY="deleteBy";
	
	/**
	 * 删除人ID , 类型: java.lang.String
	*/
	public static final BeanProperty<com.dt.platform.domain.common.ScreenDsData,java.lang.String> DELETE_BY_PROP = new BeanProperty(com.dt.platform.domain.common.ScreenDsData.class ,DELETE_BY, java.lang.String.class, "删除人ID", "删除人ID", java.lang.String.class, null);
	
	/**
	 * 删除时间 , 类型: java.util.Date
	*/
	public static final String DELETE_TIME="deleteTime";
	
	/**
	 * 删除时间 , 类型: java.util.Date
	*/
	public static final BeanProperty<com.dt.platform.domain.common.ScreenDsData,java.util.Date> DELETE_TIME_PROP = new BeanProperty(com.dt.platform.domain.common.ScreenDsData.class ,DELETE_TIME, java.util.Date.class, "删除时间", "删除时间", java.util.Date.class, null);
	
	/**
	 * version , 类型: java.lang.Integer
	*/
	public static final String VERSION="version";
	
	/**
	 * version , 类型: java.lang.Integer
	*/
	public static final BeanProperty<com.dt.platform.domain.common.ScreenDsData,java.lang.Integer> VERSION_PROP = new BeanProperty(com.dt.platform.domain.common.ScreenDsData.class ,VERSION, java.lang.Integer.class, "version", "version", java.lang.Integer.class, null);
	
	/**
	 * 租户 , 类型: java.lang.String
	*/
	public static final String TENANT_ID="tenantId";
	
	/**
	 * 租户 , 类型: java.lang.String
	*/
	public static final BeanProperty<com.dt.platform.domain.common.ScreenDsData,java.lang.String> TENANT_ID_PROP = new BeanProperty(com.dt.platform.domain.common.ScreenDsData.class ,TENANT_ID, java.lang.String.class, "租户", "租户", java.lang.String.class, null);
	
	/**
	 * screenDsCategory , 类型: com.dt.platform.domain.common.ScreenDsCategory
	*/
	public static final String SCREEN_DS_CATEGORY="screenDsCategory";
	
	/**
	 * screenDsCategory , 类型: com.dt.platform.domain.common.ScreenDsCategory
	*/
	public static final BeanProperty<com.dt.platform.domain.common.ScreenDsData,com.dt.platform.domain.common.ScreenDsCategory> SCREEN_DS_CATEGORY_PROP = new BeanProperty(com.dt.platform.domain.common.ScreenDsData.class ,SCREEN_DS_CATEGORY, com.dt.platform.domain.common.ScreenDsCategory.class, "screenDsCategory", "screenDsCategory", com.dt.platform.domain.common.ScreenDsCategory.class, null);
	
	/**
	 * screenDsDb , 类型: com.dt.platform.domain.common.ScreenDsDb
	*/
	public static final String SCREEN_DS_DB="screenDsDb";
	
	/**
	 * screenDsDb , 类型: com.dt.platform.domain.common.ScreenDsDb
	*/
	public static final BeanProperty<com.dt.platform.domain.common.ScreenDsData,com.dt.platform.domain.common.ScreenDsDb> SCREEN_DS_DB_PROP = new BeanProperty(com.dt.platform.domain.common.ScreenDsData.class ,SCREEN_DS_DB, com.dt.platform.domain.common.ScreenDsDb.class, "screenDsDb", "screenDsDb", com.dt.platform.domain.common.ScreenDsDb.class, null);
	
	/**
	 * screenDsApi , 集合类型: LIST , 类型: com.dt.platform.domain.common.ScreenDsApi
	*/
	public static final String SCREEN_DS_API="screenDsApi";
	
	/**
	 * screenDsApi , 集合类型: LIST , 类型: com.dt.platform.domain.common.ScreenDsApi
	*/
	public static final BeanProperty<com.dt.platform.domain.common.ScreenDsData,com.dt.platform.domain.common.ScreenDsApi> SCREEN_DS_API_PROP = new BeanProperty(com.dt.platform.domain.common.ScreenDsData.class ,SCREEN_DS_API, java.util.List.class, "screenDsApi", "screenDsApi", com.dt.platform.domain.common.ScreenDsApi.class, null);
	
	/**
	 * screenDsApiIds , 集合类型: LIST , 类型: java.lang.String
	*/
	public static final String SCREEN_DS_API_IDS="screenDsApiIds";
	
	/**
	 * screenDsApiIds , 集合类型: LIST , 类型: java.lang.String
	*/
	public static final BeanProperty<com.dt.platform.domain.common.ScreenDsData,java.lang.String> SCREEN_DS_API_IDS_PROP = new BeanProperty(com.dt.platform.domain.common.ScreenDsData.class ,SCREEN_DS_API_IDS, java.util.List.class, "screenDsApiIds", "screenDsApiIds", java.lang.String.class, null);
	
	/**
	 * 全部属性清单
	*/
	public static final String[] $PROPS={ ID , CODE , NAME , SOURCE_CODE , CATEGORY_ID , DS_CODE , CT_TEXT , RESULT_ACTION , NOTES , CREATE_BY , CREATE_TIME , UPDATE_BY , UPDATE_TIME , DELETED , DELETE_BY , DELETE_TIME , VERSION , TENANT_ID , SCREEN_DS_CATEGORY , SCREEN_DS_DB , SCREEN_DS_API , SCREEN_DS_API_IDS };
	
	/**
	 * 代理类
	*/
	public static class $$proxy$$ extends com.dt.platform.domain.common.ScreenDsData {

		private static final long serialVersionUID = 1L;

		
		/**
		 * 设置 主键
		 * @param id 主键
		 * @return 当前对象
		*/
		public ScreenDsData setId(String id) {
			super.change(ID,super.getId(),id);
			super.setId(id);
			return this;
		}
		
		/**
		 * 设置 编号
		 * @param code 编号
		 * @return 当前对象
		*/
		public ScreenDsData setCode(String code) {
			super.change(CODE,super.getCode(),code);
			super.setCode(code);
			return this;
		}
		
		/**
		 * 设置 名称
		 * @param name 名称
		 * @return 当前对象
		*/
		public ScreenDsData setName(String name) {
			super.change(NAME,super.getName(),name);
			super.setName(name);
			return this;
		}
		
		/**
		 * 设置 来源
		 * @param sourceCode 来源
		 * @return 当前对象
		*/
		public ScreenDsData setSourceCode(String sourceCode) {
			super.change(SOURCE_CODE,super.getSourceCode(),sourceCode);
			super.setSourceCode(sourceCode);
			return this;
		}
		
		/**
		 * 设置 分类
		 * @param categoryId 分类
		 * @return 当前对象
		*/
		public ScreenDsData setCategoryId(String categoryId) {
			super.change(CATEGORY_ID,super.getCategoryId(),categoryId);
			super.setCategoryId(categoryId);
			return this;
		}
		
		/**
		 * 设置 数据库
		 * @param dsCode 数据库
		 * @return 当前对象
		*/
		public ScreenDsData setDsCode(String dsCode) {
			super.change(DS_CODE,super.getDsCode(),dsCode);
			super.setDsCode(dsCode);
			return this;
		}
		
		/**
		 * 设置 内容
		 * @param ctText 内容
		 * @return 当前对象
		*/
		public ScreenDsData setCtText(String ctText) {
			super.change(CT_TEXT,super.getCtText(),ctText);
			super.setCtText(ctText);
			return this;
		}
		
		/**
		 * 设置 转换脚本
		 * @param resultAction 转换脚本
		 * @return 当前对象
		*/
		public ScreenDsData setResultAction(String resultAction) {
			super.change(RESULT_ACTION,super.getResultAction(),resultAction);
			super.setResultAction(resultAction);
			return this;
		}
		
		/**
		 * 设置 备注
		 * @param notes 备注
		 * @return 当前对象
		*/
		public ScreenDsData setNotes(String notes) {
			super.change(NOTES,super.getNotes(),notes);
			super.setNotes(notes);
			return this;
		}
		
		/**
		 * 设置 创建人ID
		 * @param createBy 创建人ID
		 * @return 当前对象
		*/
		public ScreenDsData setCreateBy(String createBy) {
			super.change(CREATE_BY,super.getCreateBy(),createBy);
			super.setCreateBy(createBy);
			return this;
		}
		
		/**
		 * 设置 创建时间
		 * @param createTime 创建时间
		 * @return 当前对象
		*/
		public ScreenDsData setCreateTime(Date createTime) {
			super.change(CREATE_TIME,super.getCreateTime(),createTime);
			super.setCreateTime(createTime);
			return this;
		}
		
		/**
		 * 设置 修改人ID
		 * @param updateBy 修改人ID
		 * @return 当前对象
		*/
		public ScreenDsData setUpdateBy(String updateBy) {
			super.change(UPDATE_BY,super.getUpdateBy(),updateBy);
			super.setUpdateBy(updateBy);
			return this;
		}
		
		/**
		 * 设置 修改时间
		 * @param updateTime 修改时间
		 * @return 当前对象
		*/
		public ScreenDsData setUpdateTime(Date updateTime) {
			super.change(UPDATE_TIME,super.getUpdateTime(),updateTime);
			super.setUpdateTime(updateTime);
			return this;
		}
		
		/**
		 * 设置 是否已删除
		 * @param deleted 是否已删除
		 * @return 当前对象
		*/
		public ScreenDsData setDeleted(Integer deleted) {
			super.change(DELETED,super.getDeleted(),deleted);
			super.setDeleted(deleted);
			return this;
		}
		
		/**
		 * 设置 删除人ID
		 * @param deleteBy 删除人ID
		 * @return 当前对象
		*/
		public ScreenDsData setDeleteBy(String deleteBy) {
			super.change(DELETE_BY,super.getDeleteBy(),deleteBy);
			super.setDeleteBy(deleteBy);
			return this;
		}
		
		/**
		 * 设置 删除时间
		 * @param deleteTime 删除时间
		 * @return 当前对象
		*/
		public ScreenDsData setDeleteTime(Date deleteTime) {
			super.change(DELETE_TIME,super.getDeleteTime(),deleteTime);
			super.setDeleteTime(deleteTime);
			return this;
		}
		
		/**
		 * 设置 version
		 * @param version version
		 * @return 当前对象
		*/
		public ScreenDsData setVersion(Integer version) {
			super.change(VERSION,super.getVersion(),version);
			super.setVersion(version);
			return this;
		}
		
		/**
		 * 设置 租户
		 * @param tenantId 租户
		 * @return 当前对象
		*/
		public ScreenDsData setTenantId(String tenantId) {
			super.change(TENANT_ID,super.getTenantId(),tenantId);
			super.setTenantId(tenantId);
			return this;
		}
		
		/**
		 * 设置 screenDsCategory
		 * @param screenDsCategory screenDsCategory
		 * @return 当前对象
		*/
		public ScreenDsData setScreenDsCategory(ScreenDsCategory screenDsCategory) {
			super.change(SCREEN_DS_CATEGORY,super.getScreenDsCategory(),screenDsCategory);
			super.setScreenDsCategory(screenDsCategory);
			return this;
		}
		
		/**
		 * 设置 screenDsDb
		 * @param screenDsDb screenDsDb
		 * @return 当前对象
		*/
		public ScreenDsData setScreenDsDb(ScreenDsDb screenDsDb) {
			super.change(SCREEN_DS_DB,super.getScreenDsDb(),screenDsDb);
			super.setScreenDsDb(screenDsDb);
			return this;
		}
		
		/**
		 * 设置 screenDsApi
		 * @param screenDsApi screenDsApi
		 * @return 当前对象
		*/
		public ScreenDsData setScreenDsApi(List<ScreenDsApi> screenDsApi) {
			super.change(SCREEN_DS_API,super.getScreenDsApi(),screenDsApi);
			super.setScreenDsApi(screenDsApi);
			return this;
		}
		
		/**
		 * 设置 screenDsApiIds
		 * @param screenDsApiIds screenDsApiIds
		 * @return 当前对象
		*/
		public ScreenDsData setScreenDsApiIds(List<String> screenDsApiIds) {
			super.change(SCREEN_DS_API_IDS,super.getScreenDsApiIds(),screenDsApiIds);
			super.setScreenDsApiIds(screenDsApiIds);
			return this;
		}

		/**
		 * 克隆当前对象
		*/
		@Transient
		public ScreenDsData clone() {
			return duplicate(true);
		}

		/**
		 * 复制当前对象
		 * @param all 是否复制全部属性，当 false 时，仅复制来自数据表的属性
		*/
		@Transient
		public ScreenDsData duplicate(boolean all) {
			$$proxy$$ inst=new $$proxy$$();
			inst.setCode(this.getCode());
			inst.setNotes(this.getNotes());
			inst.setCtText(this.getCtText());
			inst.setDsCode(this.getDsCode());
			inst.setUpdateTime(this.getUpdateTime());
			inst.setVersion(this.getVersion());
			inst.setSourceCode(this.getSourceCode());
			inst.setCreateBy(this.getCreateBy());
			inst.setResultAction(this.getResultAction());
			inst.setDeleted(this.getDeleted());
			inst.setCreateTime(this.getCreateTime());
			inst.setUpdateBy(this.getUpdateBy());
			inst.setDeleteTime(this.getDeleteTime());
			inst.setName(this.getName());
			inst.setTenantId(this.getTenantId());
			inst.setDeleteBy(this.getDeleteBy());
			inst.setId(this.getId());
			inst.setCategoryId(this.getCategoryId());
			if(all) {
				inst.setScreenDsDb(this.getScreenDsDb());
				inst.setScreenDsCategory(this.getScreenDsCategory());
				inst.setScreenDsApi(this.getScreenDsApi());
				inst.setScreenDsApiIds(this.getScreenDsApiIds());
			}
			inst.clearModifies();
			return inst;
		}

	}
}