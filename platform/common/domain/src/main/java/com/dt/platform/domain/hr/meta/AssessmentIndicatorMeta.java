package com.dt.platform.domain.hr.meta;

import com.github.foxnic.api.bean.BeanProperty;
import com.dt.platform.domain.hr.AssessmentIndicator;
import java.math.BigDecimal;
import java.util.Date;
import com.dt.platform.domain.hr.AssessmentIndicatorValue;
import java.util.List;
import com.dt.platform.domain.hr.IndicatorLib;
import javax.persistence.Transient;



/**
 * @author 金杰 , maillank@qq.com
 * @since 2024-03-15 18:43:28
 * @sign E86A1F690A2CE4DDD9A70C3CD6D32AA8
 * 此文件由工具自动生成，请勿修改。若表结构或配置发生变动，请使用工具重新生成。
*/

public class AssessmentIndicatorMeta {
	
	/**
	 * 主键 , 类型: java.lang.String
	*/
	public static final String ID="id";
	
	/**
	 * 主键 , 类型: java.lang.String
	*/
	public static final BeanProperty<com.dt.platform.domain.hr.AssessmentIndicator,java.lang.String> ID_PROP = new BeanProperty(com.dt.platform.domain.hr.AssessmentIndicator.class ,ID, java.lang.String.class, "主键", "主键", java.lang.String.class, null);
	
	/**
	 * 归属 , tpl,inst , 类型: java.lang.String
	*/
	public static final String OWNER="owner";
	
	/**
	 * 归属 , tpl,inst , 类型: java.lang.String
	*/
	public static final BeanProperty<com.dt.platform.domain.hr.AssessmentIndicator,java.lang.String> OWNER_PROP = new BeanProperty(com.dt.platform.domain.hr.AssessmentIndicator.class ,OWNER, java.lang.String.class, "归属", "tpl,inst", java.lang.String.class, null);
	
	/**
	 * 考核主题 , 类型: java.lang.String
	*/
	public static final String ASSESSMENT_ID="assessmentId";
	
	/**
	 * 考核主题 , 类型: java.lang.String
	*/
	public static final BeanProperty<com.dt.platform.domain.hr.AssessmentIndicator,java.lang.String> ASSESSMENT_ID_PROP = new BeanProperty(com.dt.platform.domain.hr.AssessmentIndicator.class ,ASSESSMENT_ID, java.lang.String.class, "考核主题", "考核主题", java.lang.String.class, null);
	
	/**
	 * 指标库 , 类型: java.lang.String
	*/
	public static final String TPL_INDICATOR_ID="tplIndicatorId";
	
	/**
	 * 指标库 , 类型: java.lang.String
	*/
	public static final BeanProperty<com.dt.platform.domain.hr.AssessmentIndicator,java.lang.String> TPL_INDICATOR_ID_PROP = new BeanProperty(com.dt.platform.domain.hr.AssessmentIndicator.class ,TPL_INDICATOR_ID, java.lang.String.class, "指标库", "指标库", java.lang.String.class, null);
	
	/**
	 * 分类 , 类型: java.lang.String
	*/
	public static final String GROUPNAME="groupname";
	
	/**
	 * 分类 , 类型: java.lang.String
	*/
	public static final BeanProperty<com.dt.platform.domain.hr.AssessmentIndicator,java.lang.String> GROUPNAME_PROP = new BeanProperty(com.dt.platform.domain.hr.AssessmentIndicator.class ,GROUPNAME, java.lang.String.class, "分类", "分类", java.lang.String.class, null);
	
	/**
	 * 指标名称 , 类型: java.lang.String
	*/
	public static final String NAME="name";
	
	/**
	 * 指标名称 , 类型: java.lang.String
	*/
	public static final BeanProperty<com.dt.platform.domain.hr.AssessmentIndicator,java.lang.String> NAME_PROP = new BeanProperty(com.dt.platform.domain.hr.AssessmentIndicator.class ,NAME, java.lang.String.class, "指标名称", "指标名称", java.lang.String.class, null);
	
	/**
	 * 权重 , %) , 类型: java.math.BigDecimal
	*/
	public static final String WEIGHT="weight";
	
	/**
	 * 权重 , %) , 类型: java.math.BigDecimal
	*/
	public static final BeanProperty<com.dt.platform.domain.hr.AssessmentIndicator,java.math.BigDecimal> WEIGHT_PROP = new BeanProperty(com.dt.platform.domain.hr.AssessmentIndicator.class ,WEIGHT, java.math.BigDecimal.class, "权重", "%)", java.math.BigDecimal.class, null);
	
	/**
	 * 最小评分值 , 类型: java.math.BigDecimal
	*/
	public static final String TARGET_MIN_VALUE="targetMinValue";
	
	/**
	 * 最小评分值 , 类型: java.math.BigDecimal
	*/
	public static final BeanProperty<com.dt.platform.domain.hr.AssessmentIndicator,java.math.BigDecimal> TARGET_MIN_VALUE_PROP = new BeanProperty(com.dt.platform.domain.hr.AssessmentIndicator.class ,TARGET_MIN_VALUE, java.math.BigDecimal.class, "最小评分值", "最小评分值", java.math.BigDecimal.class, null);
	
	/**
	 * 最大评分值 , 类型: java.math.BigDecimal
	*/
	public static final String TARGET_MAX_VALUE="targetMaxValue";
	
	/**
	 * 最大评分值 , 类型: java.math.BigDecimal
	*/
	public static final BeanProperty<com.dt.platform.domain.hr.AssessmentIndicator,java.math.BigDecimal> TARGET_MAX_VALUE_PROP = new BeanProperty(com.dt.platform.domain.hr.AssessmentIndicator.class ,TARGET_MAX_VALUE, java.math.BigDecimal.class, "最大评分值", "最大评分值", java.math.BigDecimal.class, null);
	
	/**
	 * 默认评分值 , 类型: java.math.BigDecimal
	*/
	public static final String DEFAULT_VALUE="defaultValue";
	
	/**
	 * 默认评分值 , 类型: java.math.BigDecimal
	*/
	public static final BeanProperty<com.dt.platform.domain.hr.AssessmentIndicator,java.math.BigDecimal> DEFAULT_VALUE_PROP = new BeanProperty(com.dt.platform.domain.hr.AssessmentIndicator.class ,DEFAULT_VALUE, java.math.BigDecimal.class, "默认评分值", "默认评分值", java.math.BigDecimal.class, null);
	
	/**
	 * 定性/定量指标 , 类型: java.lang.String
	*/
	public static final String PROPERTY="property";
	
	/**
	 * 定性/定量指标 , 类型: java.lang.String
	*/
	public static final BeanProperty<com.dt.platform.domain.hr.AssessmentIndicator,java.lang.String> PROPERTY_PROP = new BeanProperty(com.dt.platform.domain.hr.AssessmentIndicator.class ,PROPERTY, java.lang.String.class, "定性/定量指标", "定性/定量指标", java.lang.String.class, null);
	
	/**
	 * 指标定义 , 类型: java.lang.String
	*/
	public static final String DEF="def";
	
	/**
	 * 指标定义 , 类型: java.lang.String
	*/
	public static final BeanProperty<com.dt.platform.domain.hr.AssessmentIndicator,java.lang.String> DEF_PROP = new BeanProperty(com.dt.platform.domain.hr.AssessmentIndicator.class ,DEF, java.lang.String.class, "指标定义", "指标定义", java.lang.String.class, null);
	
	/**
	 * 评分标准 , 类型: java.lang.String
	*/
	public static final String SCORING_BASE="scoringBase";
	
	/**
	 * 评分标准 , 类型: java.lang.String
	*/
	public static final BeanProperty<com.dt.platform.domain.hr.AssessmentIndicator,java.lang.String> SCORING_BASE_PROP = new BeanProperty(com.dt.platform.domain.hr.AssessmentIndicator.class ,SCORING_BASE, java.lang.String.class, "评分标准", "评分标准", java.lang.String.class, null);
	
	/**
	 * 评分依据 , 类型: java.lang.String
	*/
	public static final String SCORING_BY="scoringBy";
	
	/**
	 * 评分依据 , 类型: java.lang.String
	*/
	public static final BeanProperty<com.dt.platform.domain.hr.AssessmentIndicator,java.lang.String> SCORING_BY_PROP = new BeanProperty(com.dt.platform.domain.hr.AssessmentIndicator.class ,SCORING_BY, java.lang.String.class, "评分依据", "评分依据", java.lang.String.class, null);
	
	/**
	 * 计量单位 , 类型: java.lang.String
	*/
	public static final String UNIT="unit";
	
	/**
	 * 计量单位 , 类型: java.lang.String
	*/
	public static final BeanProperty<com.dt.platform.domain.hr.AssessmentIndicator,java.lang.String> UNIT_PROP = new BeanProperty(com.dt.platform.domain.hr.AssessmentIndicator.class ,UNIT, java.lang.String.class, "计量单位", "计量单位", java.lang.String.class, null);
	
	/**
	 * 组件类型 , 类型: java.lang.String
	*/
	public static final String INPUT_TYPE="inputType";
	
	/**
	 * 组件类型 , 类型: java.lang.String
	*/
	public static final BeanProperty<com.dt.platform.domain.hr.AssessmentIndicator,java.lang.String> INPUT_TYPE_PROP = new BeanProperty(com.dt.platform.domain.hr.AssessmentIndicator.class ,INPUT_TYPE, java.lang.String.class, "组件类型", "组件类型", java.lang.String.class, null);
	
	/**
	 * 排序 , 类型: java.lang.Integer
	*/
	public static final String SN="sn";
	
	/**
	 * 排序 , 类型: java.lang.Integer
	*/
	public static final BeanProperty<com.dt.platform.domain.hr.AssessmentIndicator,java.lang.Integer> SN_PROP = new BeanProperty(com.dt.platform.domain.hr.AssessmentIndicator.class ,SN, java.lang.Integer.class, "排序", "排序", java.lang.Integer.class, null);
	
	/**
	 * 创建人ID , 类型: java.lang.String
	*/
	public static final String CREATE_BY="createBy";
	
	/**
	 * 创建人ID , 类型: java.lang.String
	*/
	public static final BeanProperty<com.dt.platform.domain.hr.AssessmentIndicator,java.lang.String> CREATE_BY_PROP = new BeanProperty(com.dt.platform.domain.hr.AssessmentIndicator.class ,CREATE_BY, java.lang.String.class, "创建人ID", "创建人ID", java.lang.String.class, null);
	
	/**
	 * 创建时间 , 类型: java.util.Date
	*/
	public static final String CREATE_TIME="createTime";
	
	/**
	 * 创建时间 , 类型: java.util.Date
	*/
	public static final BeanProperty<com.dt.platform.domain.hr.AssessmentIndicator,java.util.Date> CREATE_TIME_PROP = new BeanProperty(com.dt.platform.domain.hr.AssessmentIndicator.class ,CREATE_TIME, java.util.Date.class, "创建时间", "创建时间", java.util.Date.class, null);
	
	/**
	 * 修改人ID , 类型: java.lang.String
	*/
	public static final String UPDATE_BY="updateBy";
	
	/**
	 * 修改人ID , 类型: java.lang.String
	*/
	public static final BeanProperty<com.dt.platform.domain.hr.AssessmentIndicator,java.lang.String> UPDATE_BY_PROP = new BeanProperty(com.dt.platform.domain.hr.AssessmentIndicator.class ,UPDATE_BY, java.lang.String.class, "修改人ID", "修改人ID", java.lang.String.class, null);
	
	/**
	 * 修改时间 , 类型: java.util.Date
	*/
	public static final String UPDATE_TIME="updateTime";
	
	/**
	 * 修改时间 , 类型: java.util.Date
	*/
	public static final BeanProperty<com.dt.platform.domain.hr.AssessmentIndicator,java.util.Date> UPDATE_TIME_PROP = new BeanProperty(com.dt.platform.domain.hr.AssessmentIndicator.class ,UPDATE_TIME, java.util.Date.class, "修改时间", "修改时间", java.util.Date.class, null);
	
	/**
	 * 是否已删除 , 类型: java.lang.Integer
	*/
	public static final String DELETED="deleted";
	
	/**
	 * 是否已删除 , 类型: java.lang.Integer
	*/
	public static final BeanProperty<com.dt.platform.domain.hr.AssessmentIndicator,java.lang.Integer> DELETED_PROP = new BeanProperty(com.dt.platform.domain.hr.AssessmentIndicator.class ,DELETED, java.lang.Integer.class, "是否已删除", "是否已删除", java.lang.Integer.class, null);
	
	/**
	 * 删除人ID , 类型: java.lang.String
	*/
	public static final String DELETE_BY="deleteBy";
	
	/**
	 * 删除人ID , 类型: java.lang.String
	*/
	public static final BeanProperty<com.dt.platform.domain.hr.AssessmentIndicator,java.lang.String> DELETE_BY_PROP = new BeanProperty(com.dt.platform.domain.hr.AssessmentIndicator.class ,DELETE_BY, java.lang.String.class, "删除人ID", "删除人ID", java.lang.String.class, null);
	
	/**
	 * 删除时间 , 类型: java.util.Date
	*/
	public static final String DELETE_TIME="deleteTime";
	
	/**
	 * 删除时间 , 类型: java.util.Date
	*/
	public static final BeanProperty<com.dt.platform.domain.hr.AssessmentIndicator,java.util.Date> DELETE_TIME_PROP = new BeanProperty(com.dt.platform.domain.hr.AssessmentIndicator.class ,DELETE_TIME, java.util.Date.class, "删除时间", "删除时间", java.util.Date.class, null);
	
	/**
	 * 数据版本号 , 类型: java.lang.Integer
	*/
	public static final String VERSION="version";
	
	/**
	 * 数据版本号 , 类型: java.lang.Integer
	*/
	public static final BeanProperty<com.dt.platform.domain.hr.AssessmentIndicator,java.lang.Integer> VERSION_PROP = new BeanProperty(com.dt.platform.domain.hr.AssessmentIndicator.class ,VERSION, java.lang.Integer.class, "数据版本号", "数据版本号", java.lang.Integer.class, null);
	
	/**
	 * 租户 , 类型: java.lang.String
	*/
	public static final String TENANT_ID="tenantId";
	
	/**
	 * 租户 , 类型: java.lang.String
	*/
	public static final BeanProperty<com.dt.platform.domain.hr.AssessmentIndicator,java.lang.String> TENANT_ID_PROP = new BeanProperty(com.dt.platform.domain.hr.AssessmentIndicator.class ,TENANT_ID, java.lang.String.class, "租户", "租户", java.lang.String.class, null);
	
	/**
	 * selfAssessmentValue , 类型: com.dt.platform.domain.hr.AssessmentIndicatorValue
	*/
	public static final String SELF_ASSESSMENT_VALUE="selfAssessmentValue";
	
	/**
	 * selfAssessmentValue , 类型: com.dt.platform.domain.hr.AssessmentIndicatorValue
	*/
	public static final BeanProperty<com.dt.platform.domain.hr.AssessmentIndicator,com.dt.platform.domain.hr.AssessmentIndicatorValue> SELF_ASSESSMENT_VALUE_PROP = new BeanProperty(com.dt.platform.domain.hr.AssessmentIndicator.class ,SELF_ASSESSMENT_VALUE, com.dt.platform.domain.hr.AssessmentIndicatorValue.class, "selfAssessmentValue", "selfAssessmentValue", com.dt.platform.domain.hr.AssessmentIndicatorValue.class, null);
	
	/**
	 * leaderAssessmentValue , 类型: com.dt.platform.domain.hr.AssessmentIndicatorValue
	*/
	public static final String LEADER_ASSESSMENT_VALUE="leaderAssessmentValue";
	
	/**
	 * leaderAssessmentValue , 类型: com.dt.platform.domain.hr.AssessmentIndicatorValue
	*/
	public static final BeanProperty<com.dt.platform.domain.hr.AssessmentIndicator,com.dt.platform.domain.hr.AssessmentIndicatorValue> LEADER_ASSESSMENT_VALUE_PROP = new BeanProperty(com.dt.platform.domain.hr.AssessmentIndicator.class ,LEADER_ASSESSMENT_VALUE, com.dt.platform.domain.hr.AssessmentIndicatorValue.class, "leaderAssessmentValue", "leaderAssessmentValue", com.dt.platform.domain.hr.AssessmentIndicatorValue.class, null);
	
	/**
	 * sameAssessmentValue , 集合类型: LIST , 类型: com.dt.platform.domain.hr.AssessmentIndicatorValue
	*/
	public static final String SAME_ASSESSMENT_VALUE="sameAssessmentValue";
	
	/**
	 * sameAssessmentValue , 集合类型: LIST , 类型: com.dt.platform.domain.hr.AssessmentIndicatorValue
	*/
	public static final BeanProperty<com.dt.platform.domain.hr.AssessmentIndicator,com.dt.platform.domain.hr.AssessmentIndicatorValue> SAME_ASSESSMENT_VALUE_PROP = new BeanProperty(com.dt.platform.domain.hr.AssessmentIndicator.class ,SAME_ASSESSMENT_VALUE, java.util.List.class, "sameAssessmentValue", "sameAssessmentValue", com.dt.platform.domain.hr.AssessmentIndicatorValue.class, null);
	
	/**
	 * indicatorLib , 集合类型: LIST , 类型: com.dt.platform.domain.hr.IndicatorLib
	*/
	public static final String INDICATOR_LIB="indicatorLib";
	
	/**
	 * indicatorLib , 集合类型: LIST , 类型: com.dt.platform.domain.hr.IndicatorLib
	*/
	public static final BeanProperty<com.dt.platform.domain.hr.AssessmentIndicator,com.dt.platform.domain.hr.IndicatorLib> INDICATOR_LIB_PROP = new BeanProperty(com.dt.platform.domain.hr.AssessmentIndicator.class ,INDICATOR_LIB, java.util.List.class, "indicatorLib", "indicatorLib", com.dt.platform.domain.hr.IndicatorLib.class, null);
	
	/**
	 * 全部属性清单
	*/
	public static final String[] $PROPS={ ID , OWNER , ASSESSMENT_ID , TPL_INDICATOR_ID , GROUPNAME , NAME , WEIGHT , TARGET_MIN_VALUE , TARGET_MAX_VALUE , DEFAULT_VALUE , PROPERTY , DEF , SCORING_BASE , SCORING_BY , UNIT , INPUT_TYPE , SN , CREATE_BY , CREATE_TIME , UPDATE_BY , UPDATE_TIME , DELETED , DELETE_BY , DELETE_TIME , VERSION , TENANT_ID , SELF_ASSESSMENT_VALUE , LEADER_ASSESSMENT_VALUE , SAME_ASSESSMENT_VALUE , INDICATOR_LIB };
	
	/**
	 * 代理类
	*/
	public static class $$proxy$$ extends com.dt.platform.domain.hr.AssessmentIndicator {

		private static final long serialVersionUID = 1L;

		
		/**
		 * 设置 主键
		 * @param id 主键
		 * @return 当前对象
		*/
		public AssessmentIndicator setId(String id) {
			super.change(ID,super.getId(),id);
			super.setId(id);
			return this;
		}
		
		/**
		 * 设置 归属
		 * @param owner 归属
		 * @return 当前对象
		*/
		public AssessmentIndicator setOwner(String owner) {
			super.change(OWNER,super.getOwner(),owner);
			super.setOwner(owner);
			return this;
		}
		
		/**
		 * 设置 考核主题
		 * @param assessmentId 考核主题
		 * @return 当前对象
		*/
		public AssessmentIndicator setAssessmentId(String assessmentId) {
			super.change(ASSESSMENT_ID,super.getAssessmentId(),assessmentId);
			super.setAssessmentId(assessmentId);
			return this;
		}
		
		/**
		 * 设置 指标库
		 * @param tplIndicatorId 指标库
		 * @return 当前对象
		*/
		public AssessmentIndicator setTplIndicatorId(String tplIndicatorId) {
			super.change(TPL_INDICATOR_ID,super.getTplIndicatorId(),tplIndicatorId);
			super.setTplIndicatorId(tplIndicatorId);
			return this;
		}
		
		/**
		 * 设置 分类
		 * @param groupname 分类
		 * @return 当前对象
		*/
		public AssessmentIndicator setGroupname(String groupname) {
			super.change(GROUPNAME,super.getGroupname(),groupname);
			super.setGroupname(groupname);
			return this;
		}
		
		/**
		 * 设置 指标名称
		 * @param name 指标名称
		 * @return 当前对象
		*/
		public AssessmentIndicator setName(String name) {
			super.change(NAME,super.getName(),name);
			super.setName(name);
			return this;
		}
		
		/**
		 * 设置 权重
		 * @param weight 权重
		 * @return 当前对象
		*/
		public AssessmentIndicator setWeight(BigDecimal weight) {
			super.change(WEIGHT,super.getWeight(),weight);
			super.setWeight(weight);
			return this;
		}
		
		/**
		 * 设置 最小评分值
		 * @param targetMinValue 最小评分值
		 * @return 当前对象
		*/
		public AssessmentIndicator setTargetMinValue(BigDecimal targetMinValue) {
			super.change(TARGET_MIN_VALUE,super.getTargetMinValue(),targetMinValue);
			super.setTargetMinValue(targetMinValue);
			return this;
		}
		
		/**
		 * 设置 最大评分值
		 * @param targetMaxValue 最大评分值
		 * @return 当前对象
		*/
		public AssessmentIndicator setTargetMaxValue(BigDecimal targetMaxValue) {
			super.change(TARGET_MAX_VALUE,super.getTargetMaxValue(),targetMaxValue);
			super.setTargetMaxValue(targetMaxValue);
			return this;
		}
		
		/**
		 * 设置 默认评分值
		 * @param defaultValue 默认评分值
		 * @return 当前对象
		*/
		public AssessmentIndicator setDefaultValue(BigDecimal defaultValue) {
			super.change(DEFAULT_VALUE,super.getDefaultValue(),defaultValue);
			super.setDefaultValue(defaultValue);
			return this;
		}
		
		/**
		 * 设置 定性/定量指标
		 * @param property 定性/定量指标
		 * @return 当前对象
		*/
		public AssessmentIndicator setProperty(String property) {
			super.change(PROPERTY,super.getProperty(),property);
			super.setProperty(property);
			return this;
		}
		
		/**
		 * 设置 指标定义
		 * @param def 指标定义
		 * @return 当前对象
		*/
		public AssessmentIndicator setDef(String def) {
			super.change(DEF,super.getDef(),def);
			super.setDef(def);
			return this;
		}
		
		/**
		 * 设置 评分标准
		 * @param scoringBase 评分标准
		 * @return 当前对象
		*/
		public AssessmentIndicator setScoringBase(String scoringBase) {
			super.change(SCORING_BASE,super.getScoringBase(),scoringBase);
			super.setScoringBase(scoringBase);
			return this;
		}
		
		/**
		 * 设置 评分依据
		 * @param scoringBy 评分依据
		 * @return 当前对象
		*/
		public AssessmentIndicator setScoringBy(String scoringBy) {
			super.change(SCORING_BY,super.getScoringBy(),scoringBy);
			super.setScoringBy(scoringBy);
			return this;
		}
		
		/**
		 * 设置 计量单位
		 * @param unit 计量单位
		 * @return 当前对象
		*/
		public AssessmentIndicator setUnit(String unit) {
			super.change(UNIT,super.getUnit(),unit);
			super.setUnit(unit);
			return this;
		}
		
		/**
		 * 设置 组件类型
		 * @param inputType 组件类型
		 * @return 当前对象
		*/
		public AssessmentIndicator setInputType(String inputType) {
			super.change(INPUT_TYPE,super.getInputType(),inputType);
			super.setInputType(inputType);
			return this;
		}
		
		/**
		 * 设置 排序
		 * @param sn 排序
		 * @return 当前对象
		*/
		public AssessmentIndicator setSn(Integer sn) {
			super.change(SN,super.getSn(),sn);
			super.setSn(sn);
			return this;
		}
		
		/**
		 * 设置 创建人ID
		 * @param createBy 创建人ID
		 * @return 当前对象
		*/
		public AssessmentIndicator setCreateBy(String createBy) {
			super.change(CREATE_BY,super.getCreateBy(),createBy);
			super.setCreateBy(createBy);
			return this;
		}
		
		/**
		 * 设置 创建时间
		 * @param createTime 创建时间
		 * @return 当前对象
		*/
		public AssessmentIndicator setCreateTime(Date createTime) {
			super.change(CREATE_TIME,super.getCreateTime(),createTime);
			super.setCreateTime(createTime);
			return this;
		}
		
		/**
		 * 设置 修改人ID
		 * @param updateBy 修改人ID
		 * @return 当前对象
		*/
		public AssessmentIndicator setUpdateBy(String updateBy) {
			super.change(UPDATE_BY,super.getUpdateBy(),updateBy);
			super.setUpdateBy(updateBy);
			return this;
		}
		
		/**
		 * 设置 修改时间
		 * @param updateTime 修改时间
		 * @return 当前对象
		*/
		public AssessmentIndicator setUpdateTime(Date updateTime) {
			super.change(UPDATE_TIME,super.getUpdateTime(),updateTime);
			super.setUpdateTime(updateTime);
			return this;
		}
		
		/**
		 * 设置 是否已删除
		 * @param deleted 是否已删除
		 * @return 当前对象
		*/
		public AssessmentIndicator setDeleted(Integer deleted) {
			super.change(DELETED,super.getDeleted(),deleted);
			super.setDeleted(deleted);
			return this;
		}
		
		/**
		 * 设置 删除人ID
		 * @param deleteBy 删除人ID
		 * @return 当前对象
		*/
		public AssessmentIndicator setDeleteBy(String deleteBy) {
			super.change(DELETE_BY,super.getDeleteBy(),deleteBy);
			super.setDeleteBy(deleteBy);
			return this;
		}
		
		/**
		 * 设置 删除时间
		 * @param deleteTime 删除时间
		 * @return 当前对象
		*/
		public AssessmentIndicator setDeleteTime(Date deleteTime) {
			super.change(DELETE_TIME,super.getDeleteTime(),deleteTime);
			super.setDeleteTime(deleteTime);
			return this;
		}
		
		/**
		 * 设置 数据版本号
		 * @param version 数据版本号
		 * @return 当前对象
		*/
		public AssessmentIndicator setVersion(Integer version) {
			super.change(VERSION,super.getVersion(),version);
			super.setVersion(version);
			return this;
		}
		
		/**
		 * 设置 租户
		 * @param tenantId 租户
		 * @return 当前对象
		*/
		public AssessmentIndicator setTenantId(String tenantId) {
			super.change(TENANT_ID,super.getTenantId(),tenantId);
			super.setTenantId(tenantId);
			return this;
		}
		
		/**
		 * 设置 selfAssessmentValue
		 * @param selfAssessmentValue selfAssessmentValue
		 * @return 当前对象
		*/
		public AssessmentIndicator setSelfAssessmentValue(AssessmentIndicatorValue selfAssessmentValue) {
			super.change(SELF_ASSESSMENT_VALUE,super.getSelfAssessmentValue(),selfAssessmentValue);
			super.setSelfAssessmentValue(selfAssessmentValue);
			return this;
		}
		
		/**
		 * 设置 leaderAssessmentValue
		 * @param leaderAssessmentValue leaderAssessmentValue
		 * @return 当前对象
		*/
		public AssessmentIndicator setLeaderAssessmentValue(AssessmentIndicatorValue leaderAssessmentValue) {
			super.change(LEADER_ASSESSMENT_VALUE,super.getLeaderAssessmentValue(),leaderAssessmentValue);
			super.setLeaderAssessmentValue(leaderAssessmentValue);
			return this;
		}
		
		/**
		 * 设置 sameAssessmentValue
		 * @param sameAssessmentValue sameAssessmentValue
		 * @return 当前对象
		*/
		public AssessmentIndicator setSameAssessmentValue(List<AssessmentIndicatorValue> sameAssessmentValue) {
			super.change(SAME_ASSESSMENT_VALUE,super.getSameAssessmentValue(),sameAssessmentValue);
			super.setSameAssessmentValue(sameAssessmentValue);
			return this;
		}
		
		/**
		 * 设置 indicatorLib
		 * @param indicatorLib indicatorLib
		 * @return 当前对象
		*/
		public AssessmentIndicator setIndicatorLib(List<IndicatorLib> indicatorLib) {
			super.change(INDICATOR_LIB,super.getIndicatorLib(),indicatorLib);
			super.setIndicatorLib(indicatorLib);
			return this;
		}

		/**
		 * 克隆当前对象
		*/
		@Transient
		public AssessmentIndicator clone() {
			return duplicate(true);
		}

		/**
		 * 复制当前对象
		 * @param all 是否复制全部属性，当 false 时，仅复制来自数据表的属性
		*/
		@Transient
		public AssessmentIndicator duplicate(boolean all) {
			$$proxy$$ inst=new $$proxy$$();
			inst.setScoringBase(this.getScoringBase());
			inst.setDef(this.getDef());
			inst.setDefaultValue(this.getDefaultValue());
			inst.setUpdateBy(this.getUpdateBy());
			inst.setProperty(this.getProperty());
			inst.setInputType(this.getInputType());
			inst.setId(this.getId());
			inst.setSn(this.getSn());
			inst.setAssessmentId(this.getAssessmentId());
			inst.setOwner(this.getOwner());
			inst.setWeight(this.getWeight());
			inst.setUpdateTime(this.getUpdateTime());
			inst.setGroupname(this.getGroupname());
			inst.setVersion(this.getVersion());
			inst.setScoringBy(this.getScoringBy());
			inst.setUnit(this.getUnit());
			inst.setCreateBy(this.getCreateBy());
			inst.setDeleted(this.getDeleted());
			inst.setCreateTime(this.getCreateTime());
			inst.setDeleteTime(this.getDeleteTime());
			inst.setTargetMinValue(this.getTargetMinValue());
			inst.setName(this.getName());
			inst.setTargetMaxValue(this.getTargetMaxValue());
			inst.setTenantId(this.getTenantId());
			inst.setDeleteBy(this.getDeleteBy());
			inst.setTplIndicatorId(this.getTplIndicatorId());
			if(all) {
				inst.setIndicatorLib(this.getIndicatorLib());
				inst.setSelfAssessmentValue(this.getSelfAssessmentValue());
				inst.setLeaderAssessmentValue(this.getLeaderAssessmentValue());
				inst.setSameAssessmentValue(this.getSameAssessmentValue());
			}
			inst.clearModifies();
			return inst;
		}

	}
}