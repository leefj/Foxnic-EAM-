package com.dt.platform.domain.hr.meta;

import com.github.foxnic.api.bean.BeanProperty;
import com.dt.platform.domain.hr.ScoreTplItemValue;
import java.math.BigDecimal;
import java.util.Date;
import org.github.foxnic.web.domain.system.DictItem;
import javax.persistence.Transient;



/**
 * @author 金杰 , maillank@qq.com
 * @since 2024-02-11 23:55:06
 * @sign DA29F33F0FE66CF667A2BB0176B97782
 * 此文件由工具自动生成，请勿修改。若表结构或配置发生变动，请使用工具重新生成。
*/

public class ScoreTplItemValueMeta {
	
	/**
	 * 主键 , 类型: java.lang.String
	*/
	public static final String ID="id";
	
	/**
	 * 主键 , 类型: java.lang.String
	*/
	public static final BeanProperty<com.dt.platform.domain.hr.ScoreTplItemValue,java.lang.String> ID_PROP = new BeanProperty(com.dt.platform.domain.hr.ScoreTplItemValue.class ,ID, java.lang.String.class, "主键", "主键", java.lang.String.class, null);
	
	/**
	 * 所属 , 类型: java.lang.String
	*/
	public static final String TASK_ID="taskId";
	
	/**
	 * 所属 , 类型: java.lang.String
	*/
	public static final BeanProperty<com.dt.platform.domain.hr.ScoreTplItemValue,java.lang.String> TASK_ID_PROP = new BeanProperty(com.dt.platform.domain.hr.ScoreTplItemValue.class ,TASK_ID, java.lang.String.class, "所属", "所属", java.lang.String.class, null);
	
	/**
	 * 模版 , 类型: java.lang.String
	*/
	public static final String TPL_ID="tplId";
	
	/**
	 * 模版 , 类型: java.lang.String
	*/
	public static final BeanProperty<com.dt.platform.domain.hr.ScoreTplItemValue,java.lang.String> TPL_ID_PROP = new BeanProperty(com.dt.platform.domain.hr.ScoreTplItemValue.class ,TPL_ID, java.lang.String.class, "模版", "模版", java.lang.String.class, null);
	
	/**
	 * 评分项 , 类型: java.lang.String
	*/
	public static final String TPL_ITEM_ID="tplItemId";
	
	/**
	 * 评分项 , 类型: java.lang.String
	*/
	public static final BeanProperty<com.dt.platform.domain.hr.ScoreTplItemValue,java.lang.String> TPL_ITEM_ID_PROP = new BeanProperty(com.dt.platform.domain.hr.ScoreTplItemValue.class ,TPL_ITEM_ID, java.lang.String.class, "评分项", "评分项", java.lang.String.class, null);
	
	/**
	 * 组件类型 , 类型: java.lang.String
	*/
	public static final String ITEM_TYPE="itemType";
	
	/**
	 * 组件类型 , 类型: java.lang.String
	*/
	public static final BeanProperty<com.dt.platform.domain.hr.ScoreTplItemValue,java.lang.String> ITEM_TYPE_PROP = new BeanProperty(com.dt.platform.domain.hr.ScoreTplItemValue.class ,ITEM_TYPE, java.lang.String.class, "组件类型", "组件类型", java.lang.String.class, null);
	
	/**
	 * 说明 , 类型: java.lang.String
	*/
	public static final String ITEM_NAME="itemName";
	
	/**
	 * 说明 , 类型: java.lang.String
	*/
	public static final BeanProperty<com.dt.platform.domain.hr.ScoreTplItemValue,java.lang.String> ITEM_NAME_PROP = new BeanProperty(com.dt.platform.domain.hr.ScoreTplItemValue.class ,ITEM_NAME, java.lang.String.class, "说明", "说明", java.lang.String.class, null);
	
	/**
	 * 评分组 , 类型: java.lang.String
	*/
	public static final String GROUP_ID="groupId";
	
	/**
	 * 评分组 , 类型: java.lang.String
	*/
	public static final BeanProperty<com.dt.platform.domain.hr.ScoreTplItemValue,java.lang.String> GROUP_ID_PROP = new BeanProperty(com.dt.platform.domain.hr.ScoreTplItemValue.class ,GROUP_ID, java.lang.String.class, "评分组", "评分组", java.lang.String.class, null);
	
	/**
	 * 评分组 , 类型: java.lang.String
	*/
	public static final String GROUP_NAME="groupName";
	
	/**
	 * 评分组 , 类型: java.lang.String
	*/
	public static final BeanProperty<com.dt.platform.domain.hr.ScoreTplItemValue,java.lang.String> GROUP_NAME_PROP = new BeanProperty(com.dt.platform.domain.hr.ScoreTplItemValue.class ,GROUP_NAME, java.lang.String.class, "评分组", "评分组", java.lang.String.class, null);
	
	/**
	 * 最小分 , 类型: java.math.BigDecimal
	*/
	public static final String MIN_SCORE="minScore";
	
	/**
	 * 最小分 , 类型: java.math.BigDecimal
	*/
	public static final BeanProperty<com.dt.platform.domain.hr.ScoreTplItemValue,java.math.BigDecimal> MIN_SCORE_PROP = new BeanProperty(com.dt.platform.domain.hr.ScoreTplItemValue.class ,MIN_SCORE, java.math.BigDecimal.class, "最小分", "最小分", java.math.BigDecimal.class, null);
	
	/**
	 * 最大分 , 类型: java.math.BigDecimal
	*/
	public static final String MAX_SCORE="maxScore";
	
	/**
	 * 最大分 , 类型: java.math.BigDecimal
	*/
	public static final BeanProperty<com.dt.platform.domain.hr.ScoreTplItemValue,java.math.BigDecimal> MAX_SCORE_PROP = new BeanProperty(com.dt.platform.domain.hr.ScoreTplItemValue.class ,MAX_SCORE, java.math.BigDecimal.class, "最大分", "最大分", java.math.BigDecimal.class, null);
	
	/**
	 * 默认分 , 类型: java.math.BigDecimal
	*/
	public static final String DEF_SCORE="defScore";
	
	/**
	 * 默认分 , 类型: java.math.BigDecimal
	*/
	public static final BeanProperty<com.dt.platform.domain.hr.ScoreTplItemValue,java.math.BigDecimal> DEF_SCORE_PROP = new BeanProperty(com.dt.platform.domain.hr.ScoreTplItemValue.class ,DEF_SCORE, java.math.BigDecimal.class, "默认分", "默认分", java.math.BigDecimal.class, null);
	
	/**
	 * 排序 , 类型: java.lang.Integer
	*/
	public static final String SN="sn";
	
	/**
	 * 排序 , 类型: java.lang.Integer
	*/
	public static final BeanProperty<com.dt.platform.domain.hr.ScoreTplItemValue,java.lang.Integer> SN_PROP = new BeanProperty(com.dt.platform.domain.hr.ScoreTplItemValue.class ,SN, java.lang.Integer.class, "排序", "排序", java.lang.Integer.class, null);
	
	/**
	 * 备注 , 类型: java.lang.String
	*/
	public static final String NOTES="notes";
	
	/**
	 * 备注 , 类型: java.lang.String
	*/
	public static final BeanProperty<com.dt.platform.domain.hr.ScoreTplItemValue,java.lang.String> NOTES_PROP = new BeanProperty(com.dt.platform.domain.hr.ScoreTplItemValue.class ,NOTES, java.lang.String.class, "备注", "备注", java.lang.String.class, null);
	
	/**
	 * 创建人ID , 类型: java.lang.String
	*/
	public static final String CREATE_BY="createBy";
	
	/**
	 * 创建人ID , 类型: java.lang.String
	*/
	public static final BeanProperty<com.dt.platform.domain.hr.ScoreTplItemValue,java.lang.String> CREATE_BY_PROP = new BeanProperty(com.dt.platform.domain.hr.ScoreTplItemValue.class ,CREATE_BY, java.lang.String.class, "创建人ID", "创建人ID", java.lang.String.class, null);
	
	/**
	 * 创建时间 , 类型: java.util.Date
	*/
	public static final String CREATE_TIME="createTime";
	
	/**
	 * 创建时间 , 类型: java.util.Date
	*/
	public static final BeanProperty<com.dt.platform.domain.hr.ScoreTplItemValue,java.util.Date> CREATE_TIME_PROP = new BeanProperty(com.dt.platform.domain.hr.ScoreTplItemValue.class ,CREATE_TIME, java.util.Date.class, "创建时间", "创建时间", java.util.Date.class, null);
	
	/**
	 * 修改人ID , 类型: java.lang.String
	*/
	public static final String UPDATE_BY="updateBy";
	
	/**
	 * 修改人ID , 类型: java.lang.String
	*/
	public static final BeanProperty<com.dt.platform.domain.hr.ScoreTplItemValue,java.lang.String> UPDATE_BY_PROP = new BeanProperty(com.dt.platform.domain.hr.ScoreTplItemValue.class ,UPDATE_BY, java.lang.String.class, "修改人ID", "修改人ID", java.lang.String.class, null);
	
	/**
	 * 修改时间 , 类型: java.util.Date
	*/
	public static final String UPDATE_TIME="updateTime";
	
	/**
	 * 修改时间 , 类型: java.util.Date
	*/
	public static final BeanProperty<com.dt.platform.domain.hr.ScoreTplItemValue,java.util.Date> UPDATE_TIME_PROP = new BeanProperty(com.dt.platform.domain.hr.ScoreTplItemValue.class ,UPDATE_TIME, java.util.Date.class, "修改时间", "修改时间", java.util.Date.class, null);
	
	/**
	 * 是否已删除 , 类型: java.lang.Integer
	*/
	public static final String DELETED="deleted";
	
	/**
	 * 是否已删除 , 类型: java.lang.Integer
	*/
	public static final BeanProperty<com.dt.platform.domain.hr.ScoreTplItemValue,java.lang.Integer> DELETED_PROP = new BeanProperty(com.dt.platform.domain.hr.ScoreTplItemValue.class ,DELETED, java.lang.Integer.class, "是否已删除", "是否已删除", java.lang.Integer.class, null);
	
	/**
	 * 删除人ID , 类型: java.lang.String
	*/
	public static final String DELETE_BY="deleteBy";
	
	/**
	 * 删除人ID , 类型: java.lang.String
	*/
	public static final BeanProperty<com.dt.platform.domain.hr.ScoreTplItemValue,java.lang.String> DELETE_BY_PROP = new BeanProperty(com.dt.platform.domain.hr.ScoreTplItemValue.class ,DELETE_BY, java.lang.String.class, "删除人ID", "删除人ID", java.lang.String.class, null);
	
	/**
	 * 删除时间 , 类型: java.util.Date
	*/
	public static final String DELETE_TIME="deleteTime";
	
	/**
	 * 删除时间 , 类型: java.util.Date
	*/
	public static final BeanProperty<com.dt.platform.domain.hr.ScoreTplItemValue,java.util.Date> DELETE_TIME_PROP = new BeanProperty(com.dt.platform.domain.hr.ScoreTplItemValue.class ,DELETE_TIME, java.util.Date.class, "删除时间", "删除时间", java.util.Date.class, null);
	
	/**
	 * version , 类型: java.lang.Integer
	*/
	public static final String VERSION="version";
	
	/**
	 * version , 类型: java.lang.Integer
	*/
	public static final BeanProperty<com.dt.platform.domain.hr.ScoreTplItemValue,java.lang.Integer> VERSION_PROP = new BeanProperty(com.dt.platform.domain.hr.ScoreTplItemValue.class ,VERSION, java.lang.Integer.class, "version", "version", java.lang.Integer.class, null);
	
	/**
	 * 租户 , 类型: java.lang.String
	*/
	public static final String TENANT_ID="tenantId";
	
	/**
	 * 租户 , 类型: java.lang.String
	*/
	public static final BeanProperty<com.dt.platform.domain.hr.ScoreTplItemValue,java.lang.String> TENANT_ID_PROP = new BeanProperty(com.dt.platform.domain.hr.ScoreTplItemValue.class ,TENANT_ID, java.lang.String.class, "租户", "租户", java.lang.String.class, null);
	
	/**
	 * scoreGroup , 类型: org.github.foxnic.web.domain.system.DictItem
	*/
	public static final String SCORE_GROUP="scoreGroup";
	
	/**
	 * scoreGroup , 类型: org.github.foxnic.web.domain.system.DictItem
	*/
	public static final BeanProperty<com.dt.platform.domain.hr.ScoreTplItemValue,org.github.foxnic.web.domain.system.DictItem> SCORE_GROUP_PROP = new BeanProperty(com.dt.platform.domain.hr.ScoreTplItemValue.class ,SCORE_GROUP, org.github.foxnic.web.domain.system.DictItem.class, "scoreGroup", "scoreGroup", org.github.foxnic.web.domain.system.DictItem.class, null);
	
	/**
	 * 全部属性清单
	*/
	public static final String[] $PROPS={ ID , TASK_ID , TPL_ID , TPL_ITEM_ID , ITEM_TYPE , ITEM_NAME , GROUP_ID , GROUP_NAME , MIN_SCORE , MAX_SCORE , DEF_SCORE , SN , NOTES , CREATE_BY , CREATE_TIME , UPDATE_BY , UPDATE_TIME , DELETED , DELETE_BY , DELETE_TIME , VERSION , TENANT_ID , SCORE_GROUP };
	
	/**
	 * 代理类
	*/
	public static class $$proxy$$ extends com.dt.platform.domain.hr.ScoreTplItemValue {

		private static final long serialVersionUID = 1L;

		
		/**
		 * 设置 主键
		 * @param id 主键
		 * @return 当前对象
		*/
		public ScoreTplItemValue setId(String id) {
			super.change(ID,super.getId(),id);
			super.setId(id);
			return this;
		}
		
		/**
		 * 设置 所属
		 * @param taskId 所属
		 * @return 当前对象
		*/
		public ScoreTplItemValue setTaskId(String taskId) {
			super.change(TASK_ID,super.getTaskId(),taskId);
			super.setTaskId(taskId);
			return this;
		}
		
		/**
		 * 设置 模版
		 * @param tplId 模版
		 * @return 当前对象
		*/
		public ScoreTplItemValue setTplId(String tplId) {
			super.change(TPL_ID,super.getTplId(),tplId);
			super.setTplId(tplId);
			return this;
		}
		
		/**
		 * 设置 评分项
		 * @param tplItemId 评分项
		 * @return 当前对象
		*/
		public ScoreTplItemValue setTplItemId(String tplItemId) {
			super.change(TPL_ITEM_ID,super.getTplItemId(),tplItemId);
			super.setTplItemId(tplItemId);
			return this;
		}
		
		/**
		 * 设置 组件类型
		 * @param itemType 组件类型
		 * @return 当前对象
		*/
		public ScoreTplItemValue setItemType(String itemType) {
			super.change(ITEM_TYPE,super.getItemType(),itemType);
			super.setItemType(itemType);
			return this;
		}
		
		/**
		 * 设置 说明
		 * @param itemName 说明
		 * @return 当前对象
		*/
		public ScoreTplItemValue setItemName(String itemName) {
			super.change(ITEM_NAME,super.getItemName(),itemName);
			super.setItemName(itemName);
			return this;
		}
		
		/**
		 * 设置 评分组
		 * @param groupId 评分组
		 * @return 当前对象
		*/
		public ScoreTplItemValue setGroupId(String groupId) {
			super.change(GROUP_ID,super.getGroupId(),groupId);
			super.setGroupId(groupId);
			return this;
		}
		
		/**
		 * 设置 评分组
		 * @param groupName 评分组
		 * @return 当前对象
		*/
		public ScoreTplItemValue setGroupName(String groupName) {
			super.change(GROUP_NAME,super.getGroupName(),groupName);
			super.setGroupName(groupName);
			return this;
		}
		
		/**
		 * 设置 最小分
		 * @param minScore 最小分
		 * @return 当前对象
		*/
		public ScoreTplItemValue setMinScore(BigDecimal minScore) {
			super.change(MIN_SCORE,super.getMinScore(),minScore);
			super.setMinScore(minScore);
			return this;
		}
		
		/**
		 * 设置 最大分
		 * @param maxScore 最大分
		 * @return 当前对象
		*/
		public ScoreTplItemValue setMaxScore(BigDecimal maxScore) {
			super.change(MAX_SCORE,super.getMaxScore(),maxScore);
			super.setMaxScore(maxScore);
			return this;
		}
		
		/**
		 * 设置 默认分
		 * @param defScore 默认分
		 * @return 当前对象
		*/
		public ScoreTplItemValue setDefScore(BigDecimal defScore) {
			super.change(DEF_SCORE,super.getDefScore(),defScore);
			super.setDefScore(defScore);
			return this;
		}
		
		/**
		 * 设置 排序
		 * @param sn 排序
		 * @return 当前对象
		*/
		public ScoreTplItemValue setSn(Integer sn) {
			super.change(SN,super.getSn(),sn);
			super.setSn(sn);
			return this;
		}
		
		/**
		 * 设置 备注
		 * @param notes 备注
		 * @return 当前对象
		*/
		public ScoreTplItemValue setNotes(String notes) {
			super.change(NOTES,super.getNotes(),notes);
			super.setNotes(notes);
			return this;
		}
		
		/**
		 * 设置 创建人ID
		 * @param createBy 创建人ID
		 * @return 当前对象
		*/
		public ScoreTplItemValue setCreateBy(String createBy) {
			super.change(CREATE_BY,super.getCreateBy(),createBy);
			super.setCreateBy(createBy);
			return this;
		}
		
		/**
		 * 设置 创建时间
		 * @param createTime 创建时间
		 * @return 当前对象
		*/
		public ScoreTplItemValue setCreateTime(Date createTime) {
			super.change(CREATE_TIME,super.getCreateTime(),createTime);
			super.setCreateTime(createTime);
			return this;
		}
		
		/**
		 * 设置 修改人ID
		 * @param updateBy 修改人ID
		 * @return 当前对象
		*/
		public ScoreTplItemValue setUpdateBy(String updateBy) {
			super.change(UPDATE_BY,super.getUpdateBy(),updateBy);
			super.setUpdateBy(updateBy);
			return this;
		}
		
		/**
		 * 设置 修改时间
		 * @param updateTime 修改时间
		 * @return 当前对象
		*/
		public ScoreTplItemValue setUpdateTime(Date updateTime) {
			super.change(UPDATE_TIME,super.getUpdateTime(),updateTime);
			super.setUpdateTime(updateTime);
			return this;
		}
		
		/**
		 * 设置 是否已删除
		 * @param deleted 是否已删除
		 * @return 当前对象
		*/
		public ScoreTplItemValue setDeleted(Integer deleted) {
			super.change(DELETED,super.getDeleted(),deleted);
			super.setDeleted(deleted);
			return this;
		}
		
		/**
		 * 设置 删除人ID
		 * @param deleteBy 删除人ID
		 * @return 当前对象
		*/
		public ScoreTplItemValue setDeleteBy(String deleteBy) {
			super.change(DELETE_BY,super.getDeleteBy(),deleteBy);
			super.setDeleteBy(deleteBy);
			return this;
		}
		
		/**
		 * 设置 删除时间
		 * @param deleteTime 删除时间
		 * @return 当前对象
		*/
		public ScoreTplItemValue setDeleteTime(Date deleteTime) {
			super.change(DELETE_TIME,super.getDeleteTime(),deleteTime);
			super.setDeleteTime(deleteTime);
			return this;
		}
		
		/**
		 * 设置 version
		 * @param version version
		 * @return 当前对象
		*/
		public ScoreTplItemValue setVersion(Integer version) {
			super.change(VERSION,super.getVersion(),version);
			super.setVersion(version);
			return this;
		}
		
		/**
		 * 设置 租户
		 * @param tenantId 租户
		 * @return 当前对象
		*/
		public ScoreTplItemValue setTenantId(String tenantId) {
			super.change(TENANT_ID,super.getTenantId(),tenantId);
			super.setTenantId(tenantId);
			return this;
		}
		
		/**
		 * 设置 scoreGroup
		 * @param scoreGroup scoreGroup
		 * @return 当前对象
		*/
		public ScoreTplItemValue setScoreGroup(DictItem scoreGroup) {
			super.change(SCORE_GROUP,super.getScoreGroup(),scoreGroup);
			super.setScoreGroup(scoreGroup);
			return this;
		}

		/**
		 * 克隆当前对象
		*/
		@Transient
		public ScoreTplItemValue clone() {
			return duplicate(true);
		}

		/**
		 * 复制当前对象
		 * @param all 是否复制全部属性，当 false 时，仅复制来自数据表的属性
		*/
		@Transient
		public ScoreTplItemValue duplicate(boolean all) {
			$$proxy$$ inst=new $$proxy$$();
			inst.setItemType(this.getItemType());
			inst.setMinScore(this.getMinScore());
			inst.setNotes(this.getNotes());
			inst.setGroupId(this.getGroupId());
			inst.setUpdateTime(this.getUpdateTime());
			inst.setMaxScore(this.getMaxScore());
			inst.setVersion(this.getVersion());
			inst.setItemName(this.getItemName());
			inst.setGroupName(this.getGroupName());
			inst.setCreateBy(this.getCreateBy());
			inst.setDeleted(this.getDeleted());
			inst.setTplItemId(this.getTplItemId());
			inst.setDefScore(this.getDefScore());
			inst.setCreateTime(this.getCreateTime());
			inst.setUpdateBy(this.getUpdateBy());
			inst.setDeleteTime(this.getDeleteTime());
			inst.setTenantId(this.getTenantId());
			inst.setDeleteBy(this.getDeleteBy());
			inst.setId(this.getId());
			inst.setSn(this.getSn());
			inst.setTplId(this.getTplId());
			inst.setTaskId(this.getTaskId());
			if(all) {
				inst.setScoreGroup(this.getScoreGroup());
			}
			inst.clearModifies();
			return inst;
		}

	}
}