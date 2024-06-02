package com.dt.platform.domain.ops.meta;

import com.github.foxnic.api.bean.BeanProperty;
import com.dt.platform.domain.ops.SecurityInfoLib;
import java.util.Date;
import org.github.foxnic.web.domain.system.DictItem;
import javax.persistence.Transient;



/**
 * @author 金杰 , maillank@qq.com
 * @since 2024-05-31 09:59:02
 * @sign E50D273BC80951418D27F156C2AF956C
 * 此文件由工具自动生成，请勿修改。若表结构或配置发生变动，请使用工具重新生成。
*/

public class SecurityInfoLibMeta {
	
	/**
	 * 主键 , 类型: java.lang.String
	*/
	public static final String ID="id";
	
	/**
	 * 主键 , 类型: java.lang.String
	*/
	public static final BeanProperty<com.dt.platform.domain.ops.SecurityInfoLib,java.lang.String> ID_PROP = new BeanProperty(com.dt.platform.domain.ops.SecurityInfoLib.class ,ID, java.lang.String.class, "主键", "主键", java.lang.String.class, null);
	
	/**
	 * 名称 , 类型: java.lang.String
	*/
	public static final String NAME="name";
	
	/**
	 * 名称 , 类型: java.lang.String
	*/
	public static final BeanProperty<com.dt.platform.domain.ops.SecurityInfoLib,java.lang.String> NAME_PROP = new BeanProperty(com.dt.platform.domain.ops.SecurityInfoLib.class ,NAME, java.lang.String.class, "名称", "名称", java.lang.String.class, null);
	
	/**
	 * 类型 , 类型: java.lang.String
	*/
	public static final String TYPE="type";
	
	/**
	 * 类型 , 类型: java.lang.String
	*/
	public static final BeanProperty<com.dt.platform.domain.ops.SecurityInfoLib,java.lang.String> TYPE_PROP = new BeanProperty(com.dt.platform.domain.ops.SecurityInfoLib.class ,TYPE, java.lang.String.class, "类型", "类型", java.lang.String.class, null);
	
	/**
	 * 来源 , 类型: java.lang.String
	*/
	public static final String SOURCE="source";
	
	/**
	 * 来源 , 类型: java.lang.String
	*/
	public static final BeanProperty<com.dt.platform.domain.ops.SecurityInfoLib,java.lang.String> SOURCE_PROP = new BeanProperty(com.dt.platform.domain.ops.SecurityInfoLib.class ,SOURCE, java.lang.String.class, "来源", "来源", java.lang.String.class, null);
	
	/**
	 * 来源说明 , 类型: java.lang.String
	*/
	public static final String SOURCE_NAME="sourceName";
	
	/**
	 * 来源说明 , 类型: java.lang.String
	*/
	public static final BeanProperty<com.dt.platform.domain.ops.SecurityInfoLib,java.lang.String> SOURCE_NAME_PROP = new BeanProperty(com.dt.platform.domain.ops.SecurityInfoLib.class ,SOURCE_NAME, java.lang.String.class, "来源说明", "来源说明", java.lang.String.class, null);
	
	/**
	 * 风险等级 , 类型: java.lang.String
	*/
	public static final String SEC_LEVEL="secLevel";
	
	/**
	 * 风险等级 , 类型: java.lang.String
	*/
	public static final BeanProperty<com.dt.platform.domain.ops.SecurityInfoLib,java.lang.String> SEC_LEVEL_PROP = new BeanProperty(com.dt.platform.domain.ops.SecurityInfoLib.class ,SEC_LEVEL, java.lang.String.class, "风险等级", "风险等级", java.lang.String.class, null);
	
	/**
	 * 影响范围 , 类型: java.lang.String
	*/
	public static final String DATA_SCORE="dataScore";
	
	/**
	 * 影响范围 , 类型: java.lang.String
	*/
	public static final BeanProperty<com.dt.platform.domain.ops.SecurityInfoLib,java.lang.String> DATA_SCORE_PROP = new BeanProperty(com.dt.platform.domain.ops.SecurityInfoLib.class ,DATA_SCORE, java.lang.String.class, "影响范围", "影响范围", java.lang.String.class, null);
	
	/**
	 * 处理方式 , 类型: java.lang.String
	*/
	public static final String PROCESS_CT="processCt";
	
	/**
	 * 处理方式 , 类型: java.lang.String
	*/
	public static final BeanProperty<com.dt.platform.domain.ops.SecurityInfoLib,java.lang.String> PROCESS_CT_PROP = new BeanProperty(com.dt.platform.domain.ops.SecurityInfoLib.class ,PROCESS_CT, java.lang.String.class, "处理方式", "处理方式", java.lang.String.class, null);
	
	/**
	 * 发现时间 , 类型: java.util.Date
	*/
	public static final String BUSINESS_DATA="businessData";
	
	/**
	 * 发现时间 , 类型: java.util.Date
	*/
	public static final BeanProperty<com.dt.platform.domain.ops.SecurityInfoLib,java.util.Date> BUSINESS_DATA_PROP = new BeanProperty(com.dt.platform.domain.ops.SecurityInfoLib.class ,BUSINESS_DATA, java.util.Date.class, "发现时间", "发现时间", java.util.Date.class, null);
	
	/**
	 * 备注 , 类型: java.lang.String
	*/
	public static final String NOTES="notes";
	
	/**
	 * 备注 , 类型: java.lang.String
	*/
	public static final BeanProperty<com.dt.platform.domain.ops.SecurityInfoLib,java.lang.String> NOTES_PROP = new BeanProperty(com.dt.platform.domain.ops.SecurityInfoLib.class ,NOTES, java.lang.String.class, "备注", "备注", java.lang.String.class, null);
	
	/**
	 * 创建人ID , 类型: java.lang.String
	*/
	public static final String CREATE_BY="createBy";
	
	/**
	 * 创建人ID , 类型: java.lang.String
	*/
	public static final BeanProperty<com.dt.platform.domain.ops.SecurityInfoLib,java.lang.String> CREATE_BY_PROP = new BeanProperty(com.dt.platform.domain.ops.SecurityInfoLib.class ,CREATE_BY, java.lang.String.class, "创建人ID", "创建人ID", java.lang.String.class, null);
	
	/**
	 * 创建时间 , 类型: java.util.Date
	*/
	public static final String CREATE_TIME="createTime";
	
	/**
	 * 创建时间 , 类型: java.util.Date
	*/
	public static final BeanProperty<com.dt.platform.domain.ops.SecurityInfoLib,java.util.Date> CREATE_TIME_PROP = new BeanProperty(com.dt.platform.domain.ops.SecurityInfoLib.class ,CREATE_TIME, java.util.Date.class, "创建时间", "创建时间", java.util.Date.class, null);
	
	/**
	 * 修改人ID , 类型: java.lang.String
	*/
	public static final String UPDATE_BY="updateBy";
	
	/**
	 * 修改人ID , 类型: java.lang.String
	*/
	public static final BeanProperty<com.dt.platform.domain.ops.SecurityInfoLib,java.lang.String> UPDATE_BY_PROP = new BeanProperty(com.dt.platform.domain.ops.SecurityInfoLib.class ,UPDATE_BY, java.lang.String.class, "修改人ID", "修改人ID", java.lang.String.class, null);
	
	/**
	 * 修改时间 , 类型: java.util.Date
	*/
	public static final String UPDATE_TIME="updateTime";
	
	/**
	 * 修改时间 , 类型: java.util.Date
	*/
	public static final BeanProperty<com.dt.platform.domain.ops.SecurityInfoLib,java.util.Date> UPDATE_TIME_PROP = new BeanProperty(com.dt.platform.domain.ops.SecurityInfoLib.class ,UPDATE_TIME, java.util.Date.class, "修改时间", "修改时间", java.util.Date.class, null);
	
	/**
	 * 是否已删除 , 类型: java.lang.Integer
	*/
	public static final String DELETED="deleted";
	
	/**
	 * 是否已删除 , 类型: java.lang.Integer
	*/
	public static final BeanProperty<com.dt.platform.domain.ops.SecurityInfoLib,java.lang.Integer> DELETED_PROP = new BeanProperty(com.dt.platform.domain.ops.SecurityInfoLib.class ,DELETED, java.lang.Integer.class, "是否已删除", "是否已删除", java.lang.Integer.class, null);
	
	/**
	 * 删除人ID , 类型: java.lang.String
	*/
	public static final String DELETE_BY="deleteBy";
	
	/**
	 * 删除人ID , 类型: java.lang.String
	*/
	public static final BeanProperty<com.dt.platform.domain.ops.SecurityInfoLib,java.lang.String> DELETE_BY_PROP = new BeanProperty(com.dt.platform.domain.ops.SecurityInfoLib.class ,DELETE_BY, java.lang.String.class, "删除人ID", "删除人ID", java.lang.String.class, null);
	
	/**
	 * 删除时间 , 类型: java.util.Date
	*/
	public static final String DELETE_TIME="deleteTime";
	
	/**
	 * 删除时间 , 类型: java.util.Date
	*/
	public static final BeanProperty<com.dt.platform.domain.ops.SecurityInfoLib,java.util.Date> DELETE_TIME_PROP = new BeanProperty(com.dt.platform.domain.ops.SecurityInfoLib.class ,DELETE_TIME, java.util.Date.class, "删除时间", "删除时间", java.util.Date.class, null);
	
	/**
	 * version , 类型: java.lang.Integer
	*/
	public static final String VERSION="version";
	
	/**
	 * version , 类型: java.lang.Integer
	*/
	public static final BeanProperty<com.dt.platform.domain.ops.SecurityInfoLib,java.lang.Integer> VERSION_PROP = new BeanProperty(com.dt.platform.domain.ops.SecurityInfoLib.class ,VERSION, java.lang.Integer.class, "version", "version", java.lang.Integer.class, null);
	
	/**
	 * 租户 , 类型: java.lang.String
	*/
	public static final String TENANT_ID="tenantId";
	
	/**
	 * 租户 , 类型: java.lang.String
	*/
	public static final BeanProperty<com.dt.platform.domain.ops.SecurityInfoLib,java.lang.String> TENANT_ID_PROP = new BeanProperty(com.dt.platform.domain.ops.SecurityInfoLib.class ,TENANT_ID, java.lang.String.class, "租户", "租户", java.lang.String.class, null);
	
	/**
	 * typeDict , 类型: org.github.foxnic.web.domain.system.DictItem
	*/
	public static final String TYPE_DICT="typeDict";
	
	/**
	 * typeDict , 类型: org.github.foxnic.web.domain.system.DictItem
	*/
	public static final BeanProperty<com.dt.platform.domain.ops.SecurityInfoLib,org.github.foxnic.web.domain.system.DictItem> TYPE_DICT_PROP = new BeanProperty(com.dt.platform.domain.ops.SecurityInfoLib.class ,TYPE_DICT, org.github.foxnic.web.domain.system.DictItem.class, "typeDict", "typeDict", org.github.foxnic.web.domain.system.DictItem.class, null);
	
	/**
	 * sourceDict , 类型: org.github.foxnic.web.domain.system.DictItem
	*/
	public static final String SOURCE_DICT="sourceDict";
	
	/**
	 * sourceDict , 类型: org.github.foxnic.web.domain.system.DictItem
	*/
	public static final BeanProperty<com.dt.platform.domain.ops.SecurityInfoLib,org.github.foxnic.web.domain.system.DictItem> SOURCE_DICT_PROP = new BeanProperty(com.dt.platform.domain.ops.SecurityInfoLib.class ,SOURCE_DICT, org.github.foxnic.web.domain.system.DictItem.class, "sourceDict", "sourceDict", org.github.foxnic.web.domain.system.DictItem.class, null);
	
	/**
	 * levelDict , 类型: org.github.foxnic.web.domain.system.DictItem
	*/
	public static final String LEVEL_DICT="levelDict";
	
	/**
	 * levelDict , 类型: org.github.foxnic.web.domain.system.DictItem
	*/
	public static final BeanProperty<com.dt.platform.domain.ops.SecurityInfoLib,org.github.foxnic.web.domain.system.DictItem> LEVEL_DICT_PROP = new BeanProperty(com.dt.platform.domain.ops.SecurityInfoLib.class ,LEVEL_DICT, org.github.foxnic.web.domain.system.DictItem.class, "levelDict", "levelDict", org.github.foxnic.web.domain.system.DictItem.class, null);
	
	/**
	 * 全部属性清单
	*/
	public static final String[] $PROPS={ ID , NAME , TYPE , SOURCE , SOURCE_NAME , SEC_LEVEL , DATA_SCORE , PROCESS_CT , BUSINESS_DATA , NOTES , CREATE_BY , CREATE_TIME , UPDATE_BY , UPDATE_TIME , DELETED , DELETE_BY , DELETE_TIME , VERSION , TENANT_ID , TYPE_DICT , SOURCE_DICT , LEVEL_DICT };
	
	/**
	 * 代理类
	*/
	public static class $$proxy$$ extends com.dt.platform.domain.ops.SecurityInfoLib {

		private static final long serialVersionUID = 1L;

		
		/**
		 * 设置 主键
		 * @param id 主键
		 * @return 当前对象
		*/
		public SecurityInfoLib setId(String id) {
			super.change(ID,super.getId(),id);
			super.setId(id);
			return this;
		}
		
		/**
		 * 设置 名称
		 * @param name 名称
		 * @return 当前对象
		*/
		public SecurityInfoLib setName(String name) {
			super.change(NAME,super.getName(),name);
			super.setName(name);
			return this;
		}
		
		/**
		 * 设置 类型
		 * @param type 类型
		 * @return 当前对象
		*/
		public SecurityInfoLib setType(String type) {
			super.change(TYPE,super.getType(),type);
			super.setType(type);
			return this;
		}
		
		/**
		 * 设置 来源
		 * @param source 来源
		 * @return 当前对象
		*/
		public SecurityInfoLib setSource(String source) {
			super.change(SOURCE,super.getSource(),source);
			super.setSource(source);
			return this;
		}
		
		/**
		 * 设置 来源说明
		 * @param sourceName 来源说明
		 * @return 当前对象
		*/
		public SecurityInfoLib setSourceName(String sourceName) {
			super.change(SOURCE_NAME,super.getSourceName(),sourceName);
			super.setSourceName(sourceName);
			return this;
		}
		
		/**
		 * 设置 风险等级
		 * @param secLevel 风险等级
		 * @return 当前对象
		*/
		public SecurityInfoLib setSecLevel(String secLevel) {
			super.change(SEC_LEVEL,super.getSecLevel(),secLevel);
			super.setSecLevel(secLevel);
			return this;
		}
		
		/**
		 * 设置 影响范围
		 * @param dataScore 影响范围
		 * @return 当前对象
		*/
		public SecurityInfoLib setDataScore(String dataScore) {
			super.change(DATA_SCORE,super.getDataScore(),dataScore);
			super.setDataScore(dataScore);
			return this;
		}
		
		/**
		 * 设置 处理方式
		 * @param processCt 处理方式
		 * @return 当前对象
		*/
		public SecurityInfoLib setProcessCt(String processCt) {
			super.change(PROCESS_CT,super.getProcessCt(),processCt);
			super.setProcessCt(processCt);
			return this;
		}
		
		/**
		 * 设置 发现时间
		 * @param businessData 发现时间
		 * @return 当前对象
		*/
		public SecurityInfoLib setBusinessData(Date businessData) {
			super.change(BUSINESS_DATA,super.getBusinessData(),businessData);
			super.setBusinessData(businessData);
			return this;
		}
		
		/**
		 * 设置 备注
		 * @param notes 备注
		 * @return 当前对象
		*/
		public SecurityInfoLib setNotes(String notes) {
			super.change(NOTES,super.getNotes(),notes);
			super.setNotes(notes);
			return this;
		}
		
		/**
		 * 设置 创建人ID
		 * @param createBy 创建人ID
		 * @return 当前对象
		*/
		public SecurityInfoLib setCreateBy(String createBy) {
			super.change(CREATE_BY,super.getCreateBy(),createBy);
			super.setCreateBy(createBy);
			return this;
		}
		
		/**
		 * 设置 创建时间
		 * @param createTime 创建时间
		 * @return 当前对象
		*/
		public SecurityInfoLib setCreateTime(Date createTime) {
			super.change(CREATE_TIME,super.getCreateTime(),createTime);
			super.setCreateTime(createTime);
			return this;
		}
		
		/**
		 * 设置 修改人ID
		 * @param updateBy 修改人ID
		 * @return 当前对象
		*/
		public SecurityInfoLib setUpdateBy(String updateBy) {
			super.change(UPDATE_BY,super.getUpdateBy(),updateBy);
			super.setUpdateBy(updateBy);
			return this;
		}
		
		/**
		 * 设置 修改时间
		 * @param updateTime 修改时间
		 * @return 当前对象
		*/
		public SecurityInfoLib setUpdateTime(Date updateTime) {
			super.change(UPDATE_TIME,super.getUpdateTime(),updateTime);
			super.setUpdateTime(updateTime);
			return this;
		}
		
		/**
		 * 设置 是否已删除
		 * @param deleted 是否已删除
		 * @return 当前对象
		*/
		public SecurityInfoLib setDeleted(Integer deleted) {
			super.change(DELETED,super.getDeleted(),deleted);
			super.setDeleted(deleted);
			return this;
		}
		
		/**
		 * 设置 删除人ID
		 * @param deleteBy 删除人ID
		 * @return 当前对象
		*/
		public SecurityInfoLib setDeleteBy(String deleteBy) {
			super.change(DELETE_BY,super.getDeleteBy(),deleteBy);
			super.setDeleteBy(deleteBy);
			return this;
		}
		
		/**
		 * 设置 删除时间
		 * @param deleteTime 删除时间
		 * @return 当前对象
		*/
		public SecurityInfoLib setDeleteTime(Date deleteTime) {
			super.change(DELETE_TIME,super.getDeleteTime(),deleteTime);
			super.setDeleteTime(deleteTime);
			return this;
		}
		
		/**
		 * 设置 version
		 * @param version version
		 * @return 当前对象
		*/
		public SecurityInfoLib setVersion(Integer version) {
			super.change(VERSION,super.getVersion(),version);
			super.setVersion(version);
			return this;
		}
		
		/**
		 * 设置 租户
		 * @param tenantId 租户
		 * @return 当前对象
		*/
		public SecurityInfoLib setTenantId(String tenantId) {
			super.change(TENANT_ID,super.getTenantId(),tenantId);
			super.setTenantId(tenantId);
			return this;
		}
		
		/**
		 * 设置 typeDict
		 * @param typeDict typeDict
		 * @return 当前对象
		*/
		public SecurityInfoLib setTypeDict(DictItem typeDict) {
			super.change(TYPE_DICT,super.getTypeDict(),typeDict);
			super.setTypeDict(typeDict);
			return this;
		}
		
		/**
		 * 设置 sourceDict
		 * @param sourceDict sourceDict
		 * @return 当前对象
		*/
		public SecurityInfoLib setSourceDict(DictItem sourceDict) {
			super.change(SOURCE_DICT,super.getSourceDict(),sourceDict);
			super.setSourceDict(sourceDict);
			return this;
		}
		
		/**
		 * 设置 levelDict
		 * @param levelDict levelDict
		 * @return 当前对象
		*/
		public SecurityInfoLib setLevelDict(DictItem levelDict) {
			super.change(LEVEL_DICT,super.getLevelDict(),levelDict);
			super.setLevelDict(levelDict);
			return this;
		}

		/**
		 * 克隆当前对象
		*/
		@Transient
		public SecurityInfoLib clone() {
			return duplicate(true);
		}

		/**
		 * 复制当前对象
		 * @param all 是否复制全部属性，当 false 时，仅复制来自数据表的属性
		*/
		@Transient
		public SecurityInfoLib duplicate(boolean all) {
			$$proxy$$ inst=new $$proxy$$();
			inst.setNotes(this.getNotes());
			inst.setUpdateTime(this.getUpdateTime());
			inst.setSource(this.getSource());
			inst.setType(this.getType());
			inst.setVersion(this.getVersion());
			inst.setDataScore(this.getDataScore());
			inst.setCreateBy(this.getCreateBy());
			inst.setDeleted(this.getDeleted());
			inst.setBusinessData(this.getBusinessData());
			inst.setCreateTime(this.getCreateTime());
			inst.setUpdateBy(this.getUpdateBy());
			inst.setDeleteTime(this.getDeleteTime());
			inst.setName(this.getName());
			inst.setTenantId(this.getTenantId());
			inst.setSecLevel(this.getSecLevel());
			inst.setDeleteBy(this.getDeleteBy());
			inst.setId(this.getId());
			inst.setSourceName(this.getSourceName());
			inst.setProcessCt(this.getProcessCt());
			if(all) {
				inst.setTypeDict(this.getTypeDict());
				inst.setSourceDict(this.getSourceDict());
				inst.setLevelDict(this.getLevelDict());
			}
			inst.clearModifies();
			return inst;
		}

	}
}