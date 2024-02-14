package com.dt.platform.domain.hr.meta;

import com.github.foxnic.api.bean.BeanProperty;
import com.dt.platform.domain.hr.ScoreTaskDtl;
import java.math.BigDecimal;
import java.util.Date;
import javax.persistence.Transient;



/**
 * @author 金杰 , maillank@qq.com
 * @since 2024-02-12 00:04:02
 * @sign 52D3E423C6C087035BBD8AA23C325AC2
 * 此文件由工具自动生成，请勿修改。若表结构或配置发生变动，请使用工具重新生成。
*/

public class ScoreTaskDtlMeta {
	
	/**
	 * 主键 , 类型: java.lang.String
	*/
	public static final String ID="id";
	
	/**
	 * 主键 , 类型: java.lang.String
	*/
	public static final BeanProperty<com.dt.platform.domain.hr.ScoreTaskDtl,java.lang.String> ID_PROP = new BeanProperty(com.dt.platform.domain.hr.ScoreTaskDtl.class ,ID, java.lang.String.class, "主键", "主键", java.lang.String.class, null);
	
	/**
	 * 任务单 , 类型: java.lang.String
	*/
	public static final String TASK_ID="taskId";
	
	/**
	 * 任务单 , 类型: java.lang.String
	*/
	public static final BeanProperty<com.dt.platform.domain.hr.ScoreTaskDtl,java.lang.String> TASK_ID_PROP = new BeanProperty(com.dt.platform.domain.hr.ScoreTaskDtl.class ,TASK_ID, java.lang.String.class, "任务单", "任务单", java.lang.String.class, null);
	
	/**
	 * 模版 , 类型: java.lang.String
	*/
	public static final String TPL_ID="tplId";
	
	/**
	 * 模版 , 类型: java.lang.String
	*/
	public static final BeanProperty<com.dt.platform.domain.hr.ScoreTaskDtl,java.lang.String> TPL_ID_PROP = new BeanProperty(com.dt.platform.domain.hr.ScoreTaskDtl.class ,TPL_ID, java.lang.String.class, "模版", "模版", java.lang.String.class, null);
	
	/**
	 * 状态 , 类型: java.lang.String
	*/
	public static final String STATUS="status";
	
	/**
	 * 状态 , 类型: java.lang.String
	*/
	public static final BeanProperty<com.dt.platform.domain.hr.ScoreTaskDtl,java.lang.String> STATUS_PROP = new BeanProperty(com.dt.platform.domain.hr.ScoreTaskDtl.class ,STATUS, java.lang.String.class, "状态", "状态", java.lang.String.class, null);
	
	/**
	 * 评分人 , 类型: java.lang.String
	*/
	public static final String RATER_ID="raterId";
	
	/**
	 * 评分人 , 类型: java.lang.String
	*/
	public static final BeanProperty<com.dt.platform.domain.hr.ScoreTaskDtl,java.lang.String> RATER_ID_PROP = new BeanProperty(com.dt.platform.domain.hr.ScoreTaskDtl.class ,RATER_ID, java.lang.String.class, "评分人", "评分人", java.lang.String.class, null);
	
	/**
	 * 被评分人 , 类型: java.lang.String
	*/
	public static final String RATED_ID="ratedId";
	
	/**
	 * 被评分人 , 类型: java.lang.String
	*/
	public static final BeanProperty<com.dt.platform.domain.hr.ScoreTaskDtl,java.lang.String> RATED_ID_PROP = new BeanProperty(com.dt.platform.domain.hr.ScoreTaskDtl.class ,RATED_ID, java.lang.String.class, "被评分人", "被评分人", java.lang.String.class, null);
	
	/**
	 * 总分 , 类型: java.math.BigDecimal
	*/
	public static final String TOTAL_SCORE="totalScore";
	
	/**
	 * 总分 , 类型: java.math.BigDecimal
	*/
	public static final BeanProperty<com.dt.platform.domain.hr.ScoreTaskDtl,java.math.BigDecimal> TOTAL_SCORE_PROP = new BeanProperty(com.dt.platform.domain.hr.ScoreTaskDtl.class ,TOTAL_SCORE, java.math.BigDecimal.class, "总分", "总分", java.math.BigDecimal.class, null);
	
	/**
	 * 备注 , 类型: java.lang.String
	*/
	public static final String NOTES="notes";
	
	/**
	 * 备注 , 类型: java.lang.String
	*/
	public static final BeanProperty<com.dt.platform.domain.hr.ScoreTaskDtl,java.lang.String> NOTES_PROP = new BeanProperty(com.dt.platform.domain.hr.ScoreTaskDtl.class ,NOTES, java.lang.String.class, "备注", "备注", java.lang.String.class, null);
	
	/**
	 * 创建人ID , 类型: java.lang.String
	*/
	public static final String CREATE_BY="createBy";
	
	/**
	 * 创建人ID , 类型: java.lang.String
	*/
	public static final BeanProperty<com.dt.platform.domain.hr.ScoreTaskDtl,java.lang.String> CREATE_BY_PROP = new BeanProperty(com.dt.platform.domain.hr.ScoreTaskDtl.class ,CREATE_BY, java.lang.String.class, "创建人ID", "创建人ID", java.lang.String.class, null);
	
	/**
	 * 创建时间 , 类型: java.util.Date
	*/
	public static final String CREATE_TIME="createTime";
	
	/**
	 * 创建时间 , 类型: java.util.Date
	*/
	public static final BeanProperty<com.dt.platform.domain.hr.ScoreTaskDtl,java.util.Date> CREATE_TIME_PROP = new BeanProperty(com.dt.platform.domain.hr.ScoreTaskDtl.class ,CREATE_TIME, java.util.Date.class, "创建时间", "创建时间", java.util.Date.class, null);
	
	/**
	 * 修改人ID , 类型: java.lang.String
	*/
	public static final String UPDATE_BY="updateBy";
	
	/**
	 * 修改人ID , 类型: java.lang.String
	*/
	public static final BeanProperty<com.dt.platform.domain.hr.ScoreTaskDtl,java.lang.String> UPDATE_BY_PROP = new BeanProperty(com.dt.platform.domain.hr.ScoreTaskDtl.class ,UPDATE_BY, java.lang.String.class, "修改人ID", "修改人ID", java.lang.String.class, null);
	
	/**
	 * 修改时间 , 类型: java.util.Date
	*/
	public static final String UPDATE_TIME="updateTime";
	
	/**
	 * 修改时间 , 类型: java.util.Date
	*/
	public static final BeanProperty<com.dt.platform.domain.hr.ScoreTaskDtl,java.util.Date> UPDATE_TIME_PROP = new BeanProperty(com.dt.platform.domain.hr.ScoreTaskDtl.class ,UPDATE_TIME, java.util.Date.class, "修改时间", "修改时间", java.util.Date.class, null);
	
	/**
	 * 是否已删除 , 类型: java.lang.Integer
	*/
	public static final String DELETED="deleted";
	
	/**
	 * 是否已删除 , 类型: java.lang.Integer
	*/
	public static final BeanProperty<com.dt.platform.domain.hr.ScoreTaskDtl,java.lang.Integer> DELETED_PROP = new BeanProperty(com.dt.platform.domain.hr.ScoreTaskDtl.class ,DELETED, java.lang.Integer.class, "是否已删除", "是否已删除", java.lang.Integer.class, null);
	
	/**
	 * 删除人ID , 类型: java.lang.String
	*/
	public static final String DELETE_BY="deleteBy";
	
	/**
	 * 删除人ID , 类型: java.lang.String
	*/
	public static final BeanProperty<com.dt.platform.domain.hr.ScoreTaskDtl,java.lang.String> DELETE_BY_PROP = new BeanProperty(com.dt.platform.domain.hr.ScoreTaskDtl.class ,DELETE_BY, java.lang.String.class, "删除人ID", "删除人ID", java.lang.String.class, null);
	
	/**
	 * 删除时间 , 类型: java.util.Date
	*/
	public static final String DELETE_TIME="deleteTime";
	
	/**
	 * 删除时间 , 类型: java.util.Date
	*/
	public static final BeanProperty<com.dt.platform.domain.hr.ScoreTaskDtl,java.util.Date> DELETE_TIME_PROP = new BeanProperty(com.dt.platform.domain.hr.ScoreTaskDtl.class ,DELETE_TIME, java.util.Date.class, "删除时间", "删除时间", java.util.Date.class, null);
	
	/**
	 * version , 类型: java.lang.Integer
	*/
	public static final String VERSION="version";
	
	/**
	 * version , 类型: java.lang.Integer
	*/
	public static final BeanProperty<com.dt.platform.domain.hr.ScoreTaskDtl,java.lang.Integer> VERSION_PROP = new BeanProperty(com.dt.platform.domain.hr.ScoreTaskDtl.class ,VERSION, java.lang.Integer.class, "version", "version", java.lang.Integer.class, null);
	
	/**
	 * 租户 , 类型: java.lang.String
	*/
	public static final String TENANT_ID="tenantId";
	
	/**
	 * 租户 , 类型: java.lang.String
	*/
	public static final BeanProperty<com.dt.platform.domain.hr.ScoreTaskDtl,java.lang.String> TENANT_ID_PROP = new BeanProperty(com.dt.platform.domain.hr.ScoreTaskDtl.class ,TENANT_ID, java.lang.String.class, "租户", "租户", java.lang.String.class, null);
	
	/**
	 * 全部属性清单
	*/
	public static final String[] $PROPS={ ID , TASK_ID , TPL_ID , STATUS , RATER_ID , RATED_ID , TOTAL_SCORE , NOTES , CREATE_BY , CREATE_TIME , UPDATE_BY , UPDATE_TIME , DELETED , DELETE_BY , DELETE_TIME , VERSION , TENANT_ID };
	
	/**
	 * 代理类
	*/
	public static class $$proxy$$ extends com.dt.platform.domain.hr.ScoreTaskDtl {

		private static final long serialVersionUID = 1L;

		
		/**
		 * 设置 主键
		 * @param id 主键
		 * @return 当前对象
		*/
		public ScoreTaskDtl setId(String id) {
			super.change(ID,super.getId(),id);
			super.setId(id);
			return this;
		}
		
		/**
		 * 设置 任务单
		 * @param taskId 任务单
		 * @return 当前对象
		*/
		public ScoreTaskDtl setTaskId(String taskId) {
			super.change(TASK_ID,super.getTaskId(),taskId);
			super.setTaskId(taskId);
			return this;
		}
		
		/**
		 * 设置 模版
		 * @param tplId 模版
		 * @return 当前对象
		*/
		public ScoreTaskDtl setTplId(String tplId) {
			super.change(TPL_ID,super.getTplId(),tplId);
			super.setTplId(tplId);
			return this;
		}
		
		/**
		 * 设置 状态
		 * @param status 状态
		 * @return 当前对象
		*/
		public ScoreTaskDtl setStatus(String status) {
			super.change(STATUS,super.getStatus(),status);
			super.setStatus(status);
			return this;
		}
		
		/**
		 * 设置 评分人
		 * @param raterId 评分人
		 * @return 当前对象
		*/
		public ScoreTaskDtl setRaterId(String raterId) {
			super.change(RATER_ID,super.getRaterId(),raterId);
			super.setRaterId(raterId);
			return this;
		}
		
		/**
		 * 设置 被评分人
		 * @param ratedId 被评分人
		 * @return 当前对象
		*/
		public ScoreTaskDtl setRatedId(String ratedId) {
			super.change(RATED_ID,super.getRatedId(),ratedId);
			super.setRatedId(ratedId);
			return this;
		}
		
		/**
		 * 设置 总分
		 * @param totalScore 总分
		 * @return 当前对象
		*/
		public ScoreTaskDtl setTotalScore(BigDecimal totalScore) {
			super.change(TOTAL_SCORE,super.getTotalScore(),totalScore);
			super.setTotalScore(totalScore);
			return this;
		}
		
		/**
		 * 设置 备注
		 * @param notes 备注
		 * @return 当前对象
		*/
		public ScoreTaskDtl setNotes(String notes) {
			super.change(NOTES,super.getNotes(),notes);
			super.setNotes(notes);
			return this;
		}
		
		/**
		 * 设置 创建人ID
		 * @param createBy 创建人ID
		 * @return 当前对象
		*/
		public ScoreTaskDtl setCreateBy(String createBy) {
			super.change(CREATE_BY,super.getCreateBy(),createBy);
			super.setCreateBy(createBy);
			return this;
		}
		
		/**
		 * 设置 创建时间
		 * @param createTime 创建时间
		 * @return 当前对象
		*/
		public ScoreTaskDtl setCreateTime(Date createTime) {
			super.change(CREATE_TIME,super.getCreateTime(),createTime);
			super.setCreateTime(createTime);
			return this;
		}
		
		/**
		 * 设置 修改人ID
		 * @param updateBy 修改人ID
		 * @return 当前对象
		*/
		public ScoreTaskDtl setUpdateBy(String updateBy) {
			super.change(UPDATE_BY,super.getUpdateBy(),updateBy);
			super.setUpdateBy(updateBy);
			return this;
		}
		
		/**
		 * 设置 修改时间
		 * @param updateTime 修改时间
		 * @return 当前对象
		*/
		public ScoreTaskDtl setUpdateTime(Date updateTime) {
			super.change(UPDATE_TIME,super.getUpdateTime(),updateTime);
			super.setUpdateTime(updateTime);
			return this;
		}
		
		/**
		 * 设置 是否已删除
		 * @param deleted 是否已删除
		 * @return 当前对象
		*/
		public ScoreTaskDtl setDeleted(Integer deleted) {
			super.change(DELETED,super.getDeleted(),deleted);
			super.setDeleted(deleted);
			return this;
		}
		
		/**
		 * 设置 删除人ID
		 * @param deleteBy 删除人ID
		 * @return 当前对象
		*/
		public ScoreTaskDtl setDeleteBy(String deleteBy) {
			super.change(DELETE_BY,super.getDeleteBy(),deleteBy);
			super.setDeleteBy(deleteBy);
			return this;
		}
		
		/**
		 * 设置 删除时间
		 * @param deleteTime 删除时间
		 * @return 当前对象
		*/
		public ScoreTaskDtl setDeleteTime(Date deleteTime) {
			super.change(DELETE_TIME,super.getDeleteTime(),deleteTime);
			super.setDeleteTime(deleteTime);
			return this;
		}
		
		/**
		 * 设置 version
		 * @param version version
		 * @return 当前对象
		*/
		public ScoreTaskDtl setVersion(Integer version) {
			super.change(VERSION,super.getVersion(),version);
			super.setVersion(version);
			return this;
		}
		
		/**
		 * 设置 租户
		 * @param tenantId 租户
		 * @return 当前对象
		*/
		public ScoreTaskDtl setTenantId(String tenantId) {
			super.change(TENANT_ID,super.getTenantId(),tenantId);
			super.setTenantId(tenantId);
			return this;
		}

		/**
		 * 克隆当前对象
		*/
		@Transient
		public ScoreTaskDtl clone() {
			return duplicate(true);
		}

		/**
		 * 复制当前对象
		 * @param all 是否复制全部属性，当 false 时，仅复制来自数据表的属性
		*/
		@Transient
		public ScoreTaskDtl duplicate(boolean all) {
			$$proxy$$ inst=new $$proxy$$();
			inst.setRatedId(this.getRatedId());
			inst.setNotes(this.getNotes());
			inst.setUpdateTime(this.getUpdateTime());
			inst.setTotalScore(this.getTotalScore());
			inst.setVersion(this.getVersion());
			inst.setCreateBy(this.getCreateBy());
			inst.setRaterId(this.getRaterId());
			inst.setDeleted(this.getDeleted());
			inst.setCreateTime(this.getCreateTime());
			inst.setUpdateBy(this.getUpdateBy());
			inst.setDeleteTime(this.getDeleteTime());
			inst.setTenantId(this.getTenantId());
			inst.setDeleteBy(this.getDeleteBy());
			inst.setId(this.getId());
			inst.setTplId(this.getTplId());
			inst.setTaskId(this.getTaskId());
			inst.setStatus(this.getStatus());
			inst.clearModifies();
			return inst;
		}

	}
}