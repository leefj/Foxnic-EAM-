package com.dt.platform.domain.hr.meta;

import com.github.foxnic.api.bean.BeanProperty;
import com.dt.platform.domain.hr.AssessmentIndicatorValue;
import java.math.BigDecimal;
import java.util.Date;
import com.dt.platform.domain.hr.AssessmentIndicator;
import javax.persistence.Transient;



/**
 * @author 金杰 , maillank@qq.com
 * @since 2024-03-15 18:11:48
 * @sign 4D73E285831145B4E430AA30FAF126A1
 * 此文件由工具自动生成，请勿修改。若表结构或配置发生变动，请使用工具重新生成。
*/

public class AssessmentIndicatorValueMeta {
	
	/**
	 * 主键 , 类型: java.lang.String
	*/
	public static final String ID="id";
	
	/**
	 * 主键 , 类型: java.lang.String
	*/
	public static final BeanProperty<com.dt.platform.domain.hr.AssessmentIndicatorValue,java.lang.String> ID_PROP = new BeanProperty(com.dt.platform.domain.hr.AssessmentIndicatorValue.class ,ID, java.lang.String.class, "主键", "主键", java.lang.String.class, null);
	
	/**
	 * 评分表 , 类型: java.lang.String
	*/
	public static final String TASK_PAPER_ID="taskPaperId";
	
	/**
	 * 评分表 , 类型: java.lang.String
	*/
	public static final BeanProperty<com.dt.platform.domain.hr.AssessmentIndicatorValue,java.lang.String> TASK_PAPER_ID_PROP = new BeanProperty(com.dt.platform.domain.hr.AssessmentIndicatorValue.class ,TASK_PAPER_ID, java.lang.String.class, "评分表", "评分表", java.lang.String.class, null);
	
	/**
	 * 指标 , 类型: java.lang.String
	*/
	public static final String INDICATOR_ID="indicatorId";
	
	/**
	 * 指标 , 类型: java.lang.String
	*/
	public static final BeanProperty<com.dt.platform.domain.hr.AssessmentIndicatorValue,java.lang.String> INDICATOR_ID_PROP = new BeanProperty(com.dt.platform.domain.hr.AssessmentIndicatorValue.class ,INDICATOR_ID, java.lang.String.class, "指标", "指标", java.lang.String.class, null);
	
	/**
	 * 得分 , 类型: java.math.BigDecimal
	*/
	public static final String VALUE="value";
	
	/**
	 * 得分 , 类型: java.math.BigDecimal
	*/
	public static final BeanProperty<com.dt.platform.domain.hr.AssessmentIndicatorValue,java.math.BigDecimal> VALUE_PROP = new BeanProperty(com.dt.platform.domain.hr.AssessmentIndicatorValue.class ,VALUE, java.math.BigDecimal.class, "得分", "得分", java.math.BigDecimal.class, null);
	
	/**
	 * 内容 , 类型: java.lang.String
	*/
	public static final String CONTENT="content";
	
	/**
	 * 内容 , 类型: java.lang.String
	*/
	public static final BeanProperty<com.dt.platform.domain.hr.AssessmentIndicatorValue,java.lang.String> CONTENT_PROP = new BeanProperty(com.dt.platform.domain.hr.AssessmentIndicatorValue.class ,CONTENT, java.lang.String.class, "内容", "内容", java.lang.String.class, null);
	
	/**
	 * 顺序 , 类型: java.lang.Integer
	*/
	public static final String SN="sn";
	
	/**
	 * 顺序 , 类型: java.lang.Integer
	*/
	public static final BeanProperty<com.dt.platform.domain.hr.AssessmentIndicatorValue,java.lang.Integer> SN_PROP = new BeanProperty(com.dt.platform.domain.hr.AssessmentIndicatorValue.class ,SN, java.lang.Integer.class, "顺序", "顺序", java.lang.Integer.class, null);
	
	/**
	 * 创建人ID , 类型: java.lang.String
	*/
	public static final String CREATE_BY="createBy";
	
	/**
	 * 创建人ID , 类型: java.lang.String
	*/
	public static final BeanProperty<com.dt.platform.domain.hr.AssessmentIndicatorValue,java.lang.String> CREATE_BY_PROP = new BeanProperty(com.dt.platform.domain.hr.AssessmentIndicatorValue.class ,CREATE_BY, java.lang.String.class, "创建人ID", "创建人ID", java.lang.String.class, null);
	
	/**
	 * 创建时间 , 类型: java.util.Date
	*/
	public static final String CREATE_TIME="createTime";
	
	/**
	 * 创建时间 , 类型: java.util.Date
	*/
	public static final BeanProperty<com.dt.platform.domain.hr.AssessmentIndicatorValue,java.util.Date> CREATE_TIME_PROP = new BeanProperty(com.dt.platform.domain.hr.AssessmentIndicatorValue.class ,CREATE_TIME, java.util.Date.class, "创建时间", "创建时间", java.util.Date.class, null);
	
	/**
	 * 修改人ID , 类型: java.lang.String
	*/
	public static final String UPDATE_BY="updateBy";
	
	/**
	 * 修改人ID , 类型: java.lang.String
	*/
	public static final BeanProperty<com.dt.platform.domain.hr.AssessmentIndicatorValue,java.lang.String> UPDATE_BY_PROP = new BeanProperty(com.dt.platform.domain.hr.AssessmentIndicatorValue.class ,UPDATE_BY, java.lang.String.class, "修改人ID", "修改人ID", java.lang.String.class, null);
	
	/**
	 * 修改时间 , 类型: java.util.Date
	*/
	public static final String UPDATE_TIME="updateTime";
	
	/**
	 * 修改时间 , 类型: java.util.Date
	*/
	public static final BeanProperty<com.dt.platform.domain.hr.AssessmentIndicatorValue,java.util.Date> UPDATE_TIME_PROP = new BeanProperty(com.dt.platform.domain.hr.AssessmentIndicatorValue.class ,UPDATE_TIME, java.util.Date.class, "修改时间", "修改时间", java.util.Date.class, null);
	
	/**
	 * 是否已删除 , 类型: java.lang.Integer
	*/
	public static final String DELETED="deleted";
	
	/**
	 * 是否已删除 , 类型: java.lang.Integer
	*/
	public static final BeanProperty<com.dt.platform.domain.hr.AssessmentIndicatorValue,java.lang.Integer> DELETED_PROP = new BeanProperty(com.dt.platform.domain.hr.AssessmentIndicatorValue.class ,DELETED, java.lang.Integer.class, "是否已删除", "是否已删除", java.lang.Integer.class, null);
	
	/**
	 * 删除人ID , 类型: java.lang.String
	*/
	public static final String DELETE_BY="deleteBy";
	
	/**
	 * 删除人ID , 类型: java.lang.String
	*/
	public static final BeanProperty<com.dt.platform.domain.hr.AssessmentIndicatorValue,java.lang.String> DELETE_BY_PROP = new BeanProperty(com.dt.platform.domain.hr.AssessmentIndicatorValue.class ,DELETE_BY, java.lang.String.class, "删除人ID", "删除人ID", java.lang.String.class, null);
	
	/**
	 * 删除时间 , 类型: java.util.Date
	*/
	public static final String DELETE_TIME="deleteTime";
	
	/**
	 * 删除时间 , 类型: java.util.Date
	*/
	public static final BeanProperty<com.dt.platform.domain.hr.AssessmentIndicatorValue,java.util.Date> DELETE_TIME_PROP = new BeanProperty(com.dt.platform.domain.hr.AssessmentIndicatorValue.class ,DELETE_TIME, java.util.Date.class, "删除时间", "删除时间", java.util.Date.class, null);
	
	/**
	 * 数据版本号 , 类型: java.lang.Integer
	*/
	public static final String VERSION="version";
	
	/**
	 * 数据版本号 , 类型: java.lang.Integer
	*/
	public static final BeanProperty<com.dt.platform.domain.hr.AssessmentIndicatorValue,java.lang.Integer> VERSION_PROP = new BeanProperty(com.dt.platform.domain.hr.AssessmentIndicatorValue.class ,VERSION, java.lang.Integer.class, "数据版本号", "数据版本号", java.lang.Integer.class, null);
	
	/**
	 * 租户 , 类型: java.lang.String
	*/
	public static final String TENANT_ID="tenantId";
	
	/**
	 * 租户 , 类型: java.lang.String
	*/
	public static final BeanProperty<com.dt.platform.domain.hr.AssessmentIndicatorValue,java.lang.String> TENANT_ID_PROP = new BeanProperty(com.dt.platform.domain.hr.AssessmentIndicatorValue.class ,TENANT_ID, java.lang.String.class, "租户", "租户", java.lang.String.class, null);
	
	/**
	 * assessmentIndicator , 类型: com.dt.platform.domain.hr.AssessmentIndicator
	*/
	public static final String ASSESSMENT_INDICATOR="assessmentIndicator";
	
	/**
	 * assessmentIndicator , 类型: com.dt.platform.domain.hr.AssessmentIndicator
	*/
	public static final BeanProperty<com.dt.platform.domain.hr.AssessmentIndicatorValue,com.dt.platform.domain.hr.AssessmentIndicator> ASSESSMENT_INDICATOR_PROP = new BeanProperty(com.dt.platform.domain.hr.AssessmentIndicatorValue.class ,ASSESSMENT_INDICATOR, com.dt.platform.domain.hr.AssessmentIndicator.class, "assessmentIndicator", "assessmentIndicator", com.dt.platform.domain.hr.AssessmentIndicator.class, null);
	
	/**
	 * IndicatorGroupName , 类型: java.lang.String
	*/
	public static final String INDICATOR_GROUP_NAME="IndicatorGroupName";
	
	/**
	 * IndicatorGroupName , 类型: java.lang.String
	*/
	public static final BeanProperty<com.dt.platform.domain.hr.AssessmentIndicatorValue,java.lang.String> INDICATOR_GROUP_NAME_PROP = new BeanProperty(com.dt.platform.domain.hr.AssessmentIndicatorValue.class ,INDICATOR_GROUP_NAME, java.lang.String.class, "IndicatorGroupName", "IndicatorGroupName", java.lang.String.class, null);
	
	/**
	 * IndicatorName , 类型: java.lang.String
	*/
	public static final String INDICATOR_NAME="IndicatorName";
	
	/**
	 * IndicatorName , 类型: java.lang.String
	*/
	public static final BeanProperty<com.dt.platform.domain.hr.AssessmentIndicatorValue,java.lang.String> INDICATOR_NAME_PROP = new BeanProperty(com.dt.platform.domain.hr.AssessmentIndicatorValue.class ,INDICATOR_NAME, java.lang.String.class, "IndicatorName", "IndicatorName", java.lang.String.class, null);
	
	/**
	 * IndicatorScoringBase , 类型: java.lang.String
	*/
	public static final String INDICATOR_SCORING_BASE="IndicatorScoringBase";
	
	/**
	 * IndicatorScoringBase , 类型: java.lang.String
	*/
	public static final BeanProperty<com.dt.platform.domain.hr.AssessmentIndicatorValue,java.lang.String> INDICATOR_SCORING_BASE_PROP = new BeanProperty(com.dt.platform.domain.hr.AssessmentIndicatorValue.class ,INDICATOR_SCORING_BASE, java.lang.String.class, "IndicatorScoringBase", "IndicatorScoringBase", java.lang.String.class, null);
	
	/**
	 * IndicatorDef , 类型: java.lang.String
	*/
	public static final String INDICATOR_DEF="IndicatorDef";
	
	/**
	 * IndicatorDef , 类型: java.lang.String
	*/
	public static final BeanProperty<com.dt.platform.domain.hr.AssessmentIndicatorValue,java.lang.String> INDICATOR_DEF_PROP = new BeanProperty(com.dt.platform.domain.hr.AssessmentIndicatorValue.class ,INDICATOR_DEF, java.lang.String.class, "IndicatorDef", "IndicatorDef", java.lang.String.class, null);
	
	/**
	 * IndicatorMinValue , 类型: java.lang.String
	*/
	public static final String INDICATOR_MIN_VALUE="IndicatorMinValue";
	
	/**
	 * IndicatorMinValue , 类型: java.lang.String
	*/
	public static final BeanProperty<com.dt.platform.domain.hr.AssessmentIndicatorValue,java.lang.String> INDICATOR_MIN_VALUE_PROP = new BeanProperty(com.dt.platform.domain.hr.AssessmentIndicatorValue.class ,INDICATOR_MIN_VALUE, java.lang.String.class, "IndicatorMinValue", "IndicatorMinValue", java.lang.String.class, null);
	
	/**
	 * IndicatorMaxValue , 类型: java.lang.String
	*/
	public static final String INDICATOR_MAX_VALUE="IndicatorMaxValue";
	
	/**
	 * IndicatorMaxValue , 类型: java.lang.String
	*/
	public static final BeanProperty<com.dt.platform.domain.hr.AssessmentIndicatorValue,java.lang.String> INDICATOR_MAX_VALUE_PROP = new BeanProperty(com.dt.platform.domain.hr.AssessmentIndicatorValue.class ,INDICATOR_MAX_VALUE, java.lang.String.class, "IndicatorMaxValue", "IndicatorMaxValue", java.lang.String.class, null);
	
	/**
	 * 全部属性清单
	*/
	public static final String[] $PROPS={ ID , TASK_PAPER_ID , INDICATOR_ID , VALUE , CONTENT , SN , CREATE_BY , CREATE_TIME , UPDATE_BY , UPDATE_TIME , DELETED , DELETE_BY , DELETE_TIME , VERSION , TENANT_ID , ASSESSMENT_INDICATOR , INDICATOR_GROUP_NAME , INDICATOR_NAME , INDICATOR_SCORING_BASE , INDICATOR_DEF , INDICATOR_MIN_VALUE , INDICATOR_MAX_VALUE };
	
	/**
	 * 代理类
	*/
	public static class $$proxy$$ extends com.dt.platform.domain.hr.AssessmentIndicatorValue {

		private static final long serialVersionUID = 1L;

		
		/**
		 * 设置 主键
		 * @param id 主键
		 * @return 当前对象
		*/
		public AssessmentIndicatorValue setId(String id) {
			super.change(ID,super.getId(),id);
			super.setId(id);
			return this;
		}
		
		/**
		 * 设置 评分表
		 * @param taskPaperId 评分表
		 * @return 当前对象
		*/
		public AssessmentIndicatorValue setTaskPaperId(String taskPaperId) {
			super.change(TASK_PAPER_ID,super.getTaskPaperId(),taskPaperId);
			super.setTaskPaperId(taskPaperId);
			return this;
		}
		
		/**
		 * 设置 指标
		 * @param indicatorId 指标
		 * @return 当前对象
		*/
		public AssessmentIndicatorValue setIndicatorId(String indicatorId) {
			super.change(INDICATOR_ID,super.getIndicatorId(),indicatorId);
			super.setIndicatorId(indicatorId);
			return this;
		}
		
		/**
		 * 设置 得分
		 * @param value 得分
		 * @return 当前对象
		*/
		public AssessmentIndicatorValue setValue(BigDecimal value) {
			super.change(VALUE,super.getValue(),value);
			super.setValue(value);
			return this;
		}
		
		/**
		 * 设置 内容
		 * @param content 内容
		 * @return 当前对象
		*/
		public AssessmentIndicatorValue setContent(String content) {
			super.change(CONTENT,super.getContent(),content);
			super.setContent(content);
			return this;
		}
		
		/**
		 * 设置 顺序
		 * @param sn 顺序
		 * @return 当前对象
		*/
		public AssessmentIndicatorValue setSn(Integer sn) {
			super.change(SN,super.getSn(),sn);
			super.setSn(sn);
			return this;
		}
		
		/**
		 * 设置 创建人ID
		 * @param createBy 创建人ID
		 * @return 当前对象
		*/
		public AssessmentIndicatorValue setCreateBy(String createBy) {
			super.change(CREATE_BY,super.getCreateBy(),createBy);
			super.setCreateBy(createBy);
			return this;
		}
		
		/**
		 * 设置 创建时间
		 * @param createTime 创建时间
		 * @return 当前对象
		*/
		public AssessmentIndicatorValue setCreateTime(Date createTime) {
			super.change(CREATE_TIME,super.getCreateTime(),createTime);
			super.setCreateTime(createTime);
			return this;
		}
		
		/**
		 * 设置 修改人ID
		 * @param updateBy 修改人ID
		 * @return 当前对象
		*/
		public AssessmentIndicatorValue setUpdateBy(String updateBy) {
			super.change(UPDATE_BY,super.getUpdateBy(),updateBy);
			super.setUpdateBy(updateBy);
			return this;
		}
		
		/**
		 * 设置 修改时间
		 * @param updateTime 修改时间
		 * @return 当前对象
		*/
		public AssessmentIndicatorValue setUpdateTime(Date updateTime) {
			super.change(UPDATE_TIME,super.getUpdateTime(),updateTime);
			super.setUpdateTime(updateTime);
			return this;
		}
		
		/**
		 * 设置 是否已删除
		 * @param deleted 是否已删除
		 * @return 当前对象
		*/
		public AssessmentIndicatorValue setDeleted(Integer deleted) {
			super.change(DELETED,super.getDeleted(),deleted);
			super.setDeleted(deleted);
			return this;
		}
		
		/**
		 * 设置 删除人ID
		 * @param deleteBy 删除人ID
		 * @return 当前对象
		*/
		public AssessmentIndicatorValue setDeleteBy(String deleteBy) {
			super.change(DELETE_BY,super.getDeleteBy(),deleteBy);
			super.setDeleteBy(deleteBy);
			return this;
		}
		
		/**
		 * 设置 删除时间
		 * @param deleteTime 删除时间
		 * @return 当前对象
		*/
		public AssessmentIndicatorValue setDeleteTime(Date deleteTime) {
			super.change(DELETE_TIME,super.getDeleteTime(),deleteTime);
			super.setDeleteTime(deleteTime);
			return this;
		}
		
		/**
		 * 设置 数据版本号
		 * @param version 数据版本号
		 * @return 当前对象
		*/
		public AssessmentIndicatorValue setVersion(Integer version) {
			super.change(VERSION,super.getVersion(),version);
			super.setVersion(version);
			return this;
		}
		
		/**
		 * 设置 租户
		 * @param tenantId 租户
		 * @return 当前对象
		*/
		public AssessmentIndicatorValue setTenantId(String tenantId) {
			super.change(TENANT_ID,super.getTenantId(),tenantId);
			super.setTenantId(tenantId);
			return this;
		}
		
		/**
		 * 设置 assessmentIndicator
		 * @param assessmentIndicator assessmentIndicator
		 * @return 当前对象
		*/
		public AssessmentIndicatorValue setAssessmentIndicator(AssessmentIndicator assessmentIndicator) {
			super.change(ASSESSMENT_INDICATOR,super.getAssessmentIndicator(),assessmentIndicator);
			super.setAssessmentIndicator(assessmentIndicator);
			return this;
		}
		
		/**
		 * 设置 IndicatorGroupName
		 * @param IndicatorGroupName IndicatorGroupName
		 * @return 当前对象
		*/
		public AssessmentIndicatorValue setIndicatorGroupName(String IndicatorGroupName) {
			super.change(INDICATOR_GROUP_NAME,super.getIndicatorGroupName(),IndicatorGroupName);
			super.setIndicatorGroupName(IndicatorGroupName);
			return this;
		}
		
		/**
		 * 设置 IndicatorName
		 * @param IndicatorName IndicatorName
		 * @return 当前对象
		*/
		public AssessmentIndicatorValue setIndicatorName(String IndicatorName) {
			super.change(INDICATOR_NAME,super.getIndicatorName(),IndicatorName);
			super.setIndicatorName(IndicatorName);
			return this;
		}
		
		/**
		 * 设置 IndicatorScoringBase
		 * @param IndicatorScoringBase IndicatorScoringBase
		 * @return 当前对象
		*/
		public AssessmentIndicatorValue setIndicatorScoringBase(String IndicatorScoringBase) {
			super.change(INDICATOR_SCORING_BASE,super.getIndicatorScoringBase(),IndicatorScoringBase);
			super.setIndicatorScoringBase(IndicatorScoringBase);
			return this;
		}
		
		/**
		 * 设置 IndicatorDef
		 * @param IndicatorDef IndicatorDef
		 * @return 当前对象
		*/
		public AssessmentIndicatorValue setIndicatorDef(String IndicatorDef) {
			super.change(INDICATOR_DEF,super.getIndicatorDef(),IndicatorDef);
			super.setIndicatorDef(IndicatorDef);
			return this;
		}
		
		/**
		 * 设置 IndicatorMinValue
		 * @param IndicatorMinValue IndicatorMinValue
		 * @return 当前对象
		*/
		public AssessmentIndicatorValue setIndicatorMinValue(String IndicatorMinValue) {
			super.change(INDICATOR_MIN_VALUE,super.getIndicatorMinValue(),IndicatorMinValue);
			super.setIndicatorMinValue(IndicatorMinValue);
			return this;
		}
		
		/**
		 * 设置 IndicatorMaxValue
		 * @param IndicatorMaxValue IndicatorMaxValue
		 * @return 当前对象
		*/
		public AssessmentIndicatorValue setIndicatorMaxValue(String IndicatorMaxValue) {
			super.change(INDICATOR_MAX_VALUE,super.getIndicatorMaxValue(),IndicatorMaxValue);
			super.setIndicatorMaxValue(IndicatorMaxValue);
			return this;
		}

		/**
		 * 克隆当前对象
		*/
		@Transient
		public AssessmentIndicatorValue clone() {
			return duplicate(true);
		}

		/**
		 * 复制当前对象
		 * @param all 是否复制全部属性，当 false 时，仅复制来自数据表的属性
		*/
		@Transient
		public AssessmentIndicatorValue duplicate(boolean all) {
			$$proxy$$ inst=new $$proxy$$();
			inst.setTaskPaperId(this.getTaskPaperId());
			inst.setUpdateTime(this.getUpdateTime());
			inst.setVersion(this.getVersion());
			inst.setContent(this.getContent());
			inst.setIndicatorId(this.getIndicatorId());
			inst.setCreateBy(this.getCreateBy());
			inst.setDeleted(this.getDeleted());
			inst.setCreateTime(this.getCreateTime());
			inst.setUpdateBy(this.getUpdateBy());
			inst.setDeleteTime(this.getDeleteTime());
			inst.setTenantId(this.getTenantId());
			inst.setDeleteBy(this.getDeleteBy());
			inst.setId(this.getId());
			inst.setSn(this.getSn());
			inst.setValue(this.getValue());
			if(all) {
				inst.setIndicatorName(this.getIndicatorName());
				inst.setIndicatorMaxValue(this.getIndicatorMaxValue());
				inst.setIndicatorDef(this.getIndicatorDef());
				inst.setIndicatorGroupName(this.getIndicatorGroupName());
				inst.setIndicatorScoringBase(this.getIndicatorScoringBase());
				inst.setAssessmentIndicator(this.getAssessmentIndicator());
				inst.setIndicatorMinValue(this.getIndicatorMinValue());
			}
			inst.clearModifies();
			return inst;
		}

	}
}