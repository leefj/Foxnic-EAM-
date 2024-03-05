package com.dt.platform.domain.hr.meta;

import com.github.foxnic.api.bean.BeanProperty;
import com.dt.platform.domain.hr.AssessmentIndicatorVO;
import java.util.List;
import com.dt.platform.domain.hr.AssessmentIndicator;
import java.math.BigDecimal;
import java.util.Date;
import com.dt.platform.domain.hr.AssessmentIndicatorValue;
import com.dt.platform.domain.hr.IndicatorLib;
import javax.persistence.Transient;



/**
 * @author 金杰 , maillank@qq.com
 * @since 2024-02-29 16:32:31
 * @sign 93A6886A9E8CEF3CD1F4844E3086978F
 * 此文件由工具自动生成，请勿修改。若表结构或配置发生变动，请使用工具重新生成。
*/

public class AssessmentIndicatorVOMeta extends AssessmentIndicatorMeta {
	
	/**
	 * 页码 , 类型: java.lang.Integer
	*/
	public static final String PAGE_INDEX="pageIndex";
	
	/**
	 * 页码 , 类型: java.lang.Integer
	*/
	public static final BeanProperty<com.dt.platform.domain.hr.AssessmentIndicatorVO,java.lang.Integer> PAGE_INDEX_PROP = new BeanProperty(com.dt.platform.domain.hr.AssessmentIndicatorVO.class ,PAGE_INDEX, java.lang.Integer.class, "页码", "", java.lang.Integer.class, null);
	
	/**
	 * 分页大小 , 类型: java.lang.Integer
	*/
	public static final String PAGE_SIZE="pageSize";
	
	/**
	 * 分页大小 , 类型: java.lang.Integer
	*/
	public static final BeanProperty<com.dt.platform.domain.hr.AssessmentIndicatorVO,java.lang.Integer> PAGE_SIZE_PROP = new BeanProperty(com.dt.platform.domain.hr.AssessmentIndicatorVO.class ,PAGE_SIZE, java.lang.Integer.class, "分页大小", "", java.lang.Integer.class, null);
	
	/**
	 * 搜索字段 , 类型: java.lang.String
	*/
	public static final String SEARCH_FIELD="searchField";
	
	/**
	 * 搜索字段 , 类型: java.lang.String
	*/
	public static final BeanProperty<com.dt.platform.domain.hr.AssessmentIndicatorVO,java.lang.String> SEARCH_FIELD_PROP = new BeanProperty(com.dt.platform.domain.hr.AssessmentIndicatorVO.class ,SEARCH_FIELD, java.lang.String.class, "搜索字段", "", java.lang.String.class, null);
	
	/**
	 * 模糊搜索字段 , 类型: java.lang.String
	*/
	public static final String FUZZY_FIELD="fuzzyField";
	
	/**
	 * 模糊搜索字段 , 类型: java.lang.String
	*/
	public static final BeanProperty<com.dt.platform.domain.hr.AssessmentIndicatorVO,java.lang.String> FUZZY_FIELD_PROP = new BeanProperty(com.dt.platform.domain.hr.AssessmentIndicatorVO.class ,FUZZY_FIELD, java.lang.String.class, "模糊搜索字段", "", java.lang.String.class, null);
	
	/**
	 * 搜索的值 , 类型: java.lang.String
	*/
	public static final String SEARCH_VALUE="searchValue";
	
	/**
	 * 搜索的值 , 类型: java.lang.String
	*/
	public static final BeanProperty<com.dt.platform.domain.hr.AssessmentIndicatorVO,java.lang.String> SEARCH_VALUE_PROP = new BeanProperty(com.dt.platform.domain.hr.AssessmentIndicatorVO.class ,SEARCH_VALUE, java.lang.String.class, "搜索的值", "", java.lang.String.class, null);
	
	/**
	 * 已修改字段 , 集合类型: LIST , 类型: java.lang.String
	*/
	public static final String DIRTY_FIELDS="dirtyFields";
	
	/**
	 * 已修改字段 , 集合类型: LIST , 类型: java.lang.String
	*/
	public static final BeanProperty<com.dt.platform.domain.hr.AssessmentIndicatorVO,java.lang.String> DIRTY_FIELDS_PROP = new BeanProperty(com.dt.platform.domain.hr.AssessmentIndicatorVO.class ,DIRTY_FIELDS, java.util.List.class, "已修改字段", "", java.lang.String.class, null);
	
	/**
	 * 排序字段 , 类型: java.lang.String
	*/
	public static final String SORT_FIELD="sortField";
	
	/**
	 * 排序字段 , 类型: java.lang.String
	*/
	public static final BeanProperty<com.dt.platform.domain.hr.AssessmentIndicatorVO,java.lang.String> SORT_FIELD_PROP = new BeanProperty(com.dt.platform.domain.hr.AssessmentIndicatorVO.class ,SORT_FIELD, java.lang.String.class, "排序字段", "", java.lang.String.class, null);
	
	/**
	 * 排序方式 , 类型: java.lang.String
	*/
	public static final String SORT_TYPE="sortType";
	
	/**
	 * 排序方式 , 类型: java.lang.String
	*/
	public static final BeanProperty<com.dt.platform.domain.hr.AssessmentIndicatorVO,java.lang.String> SORT_TYPE_PROP = new BeanProperty(com.dt.platform.domain.hr.AssessmentIndicatorVO.class ,SORT_TYPE, java.lang.String.class, "排序方式", "", java.lang.String.class, null);
	
	/**
	 * 数据来源 , 前端指定不同的来源，后端可按来源执行不同的逻辑 , 类型: java.lang.String
	*/
	public static final String DATA_ORIGIN="dataOrigin";
	
	/**
	 * 数据来源 , 前端指定不同的来源，后端可按来源执行不同的逻辑 , 类型: java.lang.String
	*/
	public static final BeanProperty<com.dt.platform.domain.hr.AssessmentIndicatorVO,java.lang.String> DATA_ORIGIN_PROP = new BeanProperty(com.dt.platform.domain.hr.AssessmentIndicatorVO.class ,DATA_ORIGIN, java.lang.String.class, "数据来源", "前端指定不同的来源，后端可按来源执行不同的逻辑", java.lang.String.class, null);
	
	/**
	 * 查询逻辑 , 默认and，可指定 or  , 类型: java.lang.String
	*/
	public static final String QUERY_LOGIC="queryLogic";
	
	/**
	 * 查询逻辑 , 默认and，可指定 or  , 类型: java.lang.String
	*/
	public static final BeanProperty<com.dt.platform.domain.hr.AssessmentIndicatorVO,java.lang.String> QUERY_LOGIC_PROP = new BeanProperty(com.dt.platform.domain.hr.AssessmentIndicatorVO.class ,QUERY_LOGIC, java.lang.String.class, "查询逻辑", "默认and，可指定 or ", java.lang.String.class, null);
	
	/**
	 * 请求动作 , 前端指定不同的Action，后端可Action执行不同的逻辑 , 类型: java.lang.String
	*/
	public static final String REQUEST_ACTION="requestAction";
	
	/**
	 * 请求动作 , 前端指定不同的Action，后端可Action执行不同的逻辑 , 类型: java.lang.String
	*/
	public static final BeanProperty<com.dt.platform.domain.hr.AssessmentIndicatorVO,java.lang.String> REQUEST_ACTION_PROP = new BeanProperty(com.dt.platform.domain.hr.AssessmentIndicatorVO.class ,REQUEST_ACTION, java.lang.String.class, "请求动作", "前端指定不同的Action，后端可Action执行不同的逻辑", java.lang.String.class, null);
	
	/**
	 * 主键清单 , 用于接收批量主键参数 , 集合类型: LIST , 类型: java.lang.String
	*/
	public static final String IDS="ids";
	
	/**
	 * 主键清单 , 用于接收批量主键参数 , 集合类型: LIST , 类型: java.lang.String
	*/
	public static final BeanProperty<com.dt.platform.domain.hr.AssessmentIndicatorVO,java.lang.String> IDS_PROP = new BeanProperty(com.dt.platform.domain.hr.AssessmentIndicatorVO.class ,IDS, java.util.List.class, "主键清单", "用于接收批量主键参数", java.lang.String.class, null);
	
	/**
	 * 主键 , 类型: java.lang.String
	*/
	public static final String ID="id";
	
	/**
	 * 主键 , 类型: java.lang.String
	*/
	public static final BeanProperty<com.dt.platform.domain.hr.AssessmentIndicatorVO,java.lang.String> ID_PROP = new BeanProperty(com.dt.platform.domain.hr.AssessmentIndicatorVO.class ,ID, java.lang.String.class, "主键", "主键", java.lang.String.class, null);
	
	/**
	 * 考核主题 , 类型: java.lang.String
	*/
	public static final String ASSESSMENT_ID="assessmentId";
	
	/**
	 * 考核主题 , 类型: java.lang.String
	*/
	public static final BeanProperty<com.dt.platform.domain.hr.AssessmentIndicatorVO,java.lang.String> ASSESSMENT_ID_PROP = new BeanProperty(com.dt.platform.domain.hr.AssessmentIndicatorVO.class ,ASSESSMENT_ID, java.lang.String.class, "考核主题", "考核主题", java.lang.String.class, null);
	
	/**
	 * 指标库 , 类型: java.lang.String
	*/
	public static final String TPL_INDICATOR_ID="tplIndicatorId";
	
	/**
	 * 指标库 , 类型: java.lang.String
	*/
	public static final BeanProperty<com.dt.platform.domain.hr.AssessmentIndicatorVO,java.lang.String> TPL_INDICATOR_ID_PROP = new BeanProperty(com.dt.platform.domain.hr.AssessmentIndicatorVO.class ,TPL_INDICATOR_ID, java.lang.String.class, "指标库", "指标库", java.lang.String.class, null);
	
	/**
	 * 指标名称 , 类型: java.lang.String
	*/
	public static final String NAME="name";
	
	/**
	 * 指标名称 , 类型: java.lang.String
	*/
	public static final BeanProperty<com.dt.platform.domain.hr.AssessmentIndicatorVO,java.lang.String> NAME_PROP = new BeanProperty(com.dt.platform.domain.hr.AssessmentIndicatorVO.class ,NAME, java.lang.String.class, "指标名称", "指标名称", java.lang.String.class, null);
	
	/**
	 * 权重 , %) , 类型: java.math.BigDecimal
	*/
	public static final String WEIGHT="weight";
	
	/**
	 * 权重 , %) , 类型: java.math.BigDecimal
	*/
	public static final BeanProperty<com.dt.platform.domain.hr.AssessmentIndicatorVO,java.math.BigDecimal> WEIGHT_PROP = new BeanProperty(com.dt.platform.domain.hr.AssessmentIndicatorVO.class ,WEIGHT, java.math.BigDecimal.class, "权重", "%)", java.math.BigDecimal.class, null);
	
	/**
	 * 最小评分值 , 类型: java.math.BigDecimal
	*/
	public static final String TARGET_MIN_VALUE="targetMinValue";
	
	/**
	 * 最小评分值 , 类型: java.math.BigDecimal
	*/
	public static final BeanProperty<com.dt.platform.domain.hr.AssessmentIndicatorVO,java.math.BigDecimal> TARGET_MIN_VALUE_PROP = new BeanProperty(com.dt.platform.domain.hr.AssessmentIndicatorVO.class ,TARGET_MIN_VALUE, java.math.BigDecimal.class, "最小评分值", "最小评分值", java.math.BigDecimal.class, null);
	
	/**
	 * 最大评分值 , 类型: java.math.BigDecimal
	*/
	public static final String TARGET_MAX_VALUE="targetMaxValue";
	
	/**
	 * 最大评分值 , 类型: java.math.BigDecimal
	*/
	public static final BeanProperty<com.dt.platform.domain.hr.AssessmentIndicatorVO,java.math.BigDecimal> TARGET_MAX_VALUE_PROP = new BeanProperty(com.dt.platform.domain.hr.AssessmentIndicatorVO.class ,TARGET_MAX_VALUE, java.math.BigDecimal.class, "最大评分值", "最大评分值", java.math.BigDecimal.class, null);
	
	/**
	 * 默认评分值 , 类型: java.math.BigDecimal
	*/
	public static final String DEFAULT_VALUE="defaultValue";
	
	/**
	 * 默认评分值 , 类型: java.math.BigDecimal
	*/
	public static final BeanProperty<com.dt.platform.domain.hr.AssessmentIndicatorVO,java.math.BigDecimal> DEFAULT_VALUE_PROP = new BeanProperty(com.dt.platform.domain.hr.AssessmentIndicatorVO.class ,DEFAULT_VALUE, java.math.BigDecimal.class, "默认评分值", "默认评分值", java.math.BigDecimal.class, null);
	
	/**
	 * 定性/定量指标 , 类型: java.lang.String
	*/
	public static final String PROPERTY="property";
	
	/**
	 * 定性/定量指标 , 类型: java.lang.String
	*/
	public static final BeanProperty<com.dt.platform.domain.hr.AssessmentIndicatorVO,java.lang.String> PROPERTY_PROP = new BeanProperty(com.dt.platform.domain.hr.AssessmentIndicatorVO.class ,PROPERTY, java.lang.String.class, "定性/定量指标", "定性/定量指标", java.lang.String.class, null);
	
	/**
	 * 计量单位 , 类型: java.lang.String
	*/
	public static final String UNIT="unit";
	
	/**
	 * 计量单位 , 类型: java.lang.String
	*/
	public static final BeanProperty<com.dt.platform.domain.hr.AssessmentIndicatorVO,java.lang.String> UNIT_PROP = new BeanProperty(com.dt.platform.domain.hr.AssessmentIndicatorVO.class ,UNIT, java.lang.String.class, "计量单位", "计量单位", java.lang.String.class, null);
	
	/**
	 * 指标定义 , 类型: java.lang.String
	*/
	public static final String DEF="def";
	
	/**
	 * 指标定义 , 类型: java.lang.String
	*/
	public static final BeanProperty<com.dt.platform.domain.hr.AssessmentIndicatorVO,java.lang.String> DEF_PROP = new BeanProperty(com.dt.platform.domain.hr.AssessmentIndicatorVO.class ,DEF, java.lang.String.class, "指标定义", "指标定义", java.lang.String.class, null);
	
	/**
	 * 评分标准 , 类型: java.lang.String
	*/
	public static final String SCORING_BASE="scoringBase";
	
	/**
	 * 评分标准 , 类型: java.lang.String
	*/
	public static final BeanProperty<com.dt.platform.domain.hr.AssessmentIndicatorVO,java.lang.String> SCORING_BASE_PROP = new BeanProperty(com.dt.platform.domain.hr.AssessmentIndicatorVO.class ,SCORING_BASE, java.lang.String.class, "评分标准", "评分标准", java.lang.String.class, null);
	
	/**
	 * 评分依据 , 类型: java.lang.String
	*/
	public static final String SCORING_BY="scoringBy";
	
	/**
	 * 评分依据 , 类型: java.lang.String
	*/
	public static final BeanProperty<com.dt.platform.domain.hr.AssessmentIndicatorVO,java.lang.String> SCORING_BY_PROP = new BeanProperty(com.dt.platform.domain.hr.AssessmentIndicatorVO.class ,SCORING_BY, java.lang.String.class, "评分依据", "评分依据", java.lang.String.class, null);
	
	/**
	 * 排序 , 类型: java.lang.Integer
	*/
	public static final String SN="sn";
	
	/**
	 * 排序 , 类型: java.lang.Integer
	*/
	public static final BeanProperty<com.dt.platform.domain.hr.AssessmentIndicatorVO,java.lang.Integer> SN_PROP = new BeanProperty(com.dt.platform.domain.hr.AssessmentIndicatorVO.class ,SN, java.lang.Integer.class, "排序", "排序", java.lang.Integer.class, null);
	
	/**
	 * 创建人ID , 类型: java.lang.String
	*/
	public static final String CREATE_BY="createBy";
	
	/**
	 * 创建人ID , 类型: java.lang.String
	*/
	public static final BeanProperty<com.dt.platform.domain.hr.AssessmentIndicatorVO,java.lang.String> CREATE_BY_PROP = new BeanProperty(com.dt.platform.domain.hr.AssessmentIndicatorVO.class ,CREATE_BY, java.lang.String.class, "创建人ID", "创建人ID", java.lang.String.class, null);
	
	/**
	 * 创建时间 , 类型: java.util.Date
	*/
	public static final String CREATE_TIME="createTime";
	
	/**
	 * 创建时间 , 类型: java.util.Date
	*/
	public static final BeanProperty<com.dt.platform.domain.hr.AssessmentIndicatorVO,java.util.Date> CREATE_TIME_PROP = new BeanProperty(com.dt.platform.domain.hr.AssessmentIndicatorVO.class ,CREATE_TIME, java.util.Date.class, "创建时间", "创建时间", java.util.Date.class, null);
	
	/**
	 * 修改人ID , 类型: java.lang.String
	*/
	public static final String UPDATE_BY="updateBy";
	
	/**
	 * 修改人ID , 类型: java.lang.String
	*/
	public static final BeanProperty<com.dt.platform.domain.hr.AssessmentIndicatorVO,java.lang.String> UPDATE_BY_PROP = new BeanProperty(com.dt.platform.domain.hr.AssessmentIndicatorVO.class ,UPDATE_BY, java.lang.String.class, "修改人ID", "修改人ID", java.lang.String.class, null);
	
	/**
	 * 修改时间 , 类型: java.util.Date
	*/
	public static final String UPDATE_TIME="updateTime";
	
	/**
	 * 修改时间 , 类型: java.util.Date
	*/
	public static final BeanProperty<com.dt.platform.domain.hr.AssessmentIndicatorVO,java.util.Date> UPDATE_TIME_PROP = new BeanProperty(com.dt.platform.domain.hr.AssessmentIndicatorVO.class ,UPDATE_TIME, java.util.Date.class, "修改时间", "修改时间", java.util.Date.class, null);
	
	/**
	 * 是否已删除 , 类型: java.lang.Integer
	*/
	public static final String DELETED="deleted";
	
	/**
	 * 是否已删除 , 类型: java.lang.Integer
	*/
	public static final BeanProperty<com.dt.platform.domain.hr.AssessmentIndicatorVO,java.lang.Integer> DELETED_PROP = new BeanProperty(com.dt.platform.domain.hr.AssessmentIndicatorVO.class ,DELETED, java.lang.Integer.class, "是否已删除", "是否已删除", java.lang.Integer.class, null);
	
	/**
	 * 删除人ID , 类型: java.lang.String
	*/
	public static final String DELETE_BY="deleteBy";
	
	/**
	 * 删除人ID , 类型: java.lang.String
	*/
	public static final BeanProperty<com.dt.platform.domain.hr.AssessmentIndicatorVO,java.lang.String> DELETE_BY_PROP = new BeanProperty(com.dt.platform.domain.hr.AssessmentIndicatorVO.class ,DELETE_BY, java.lang.String.class, "删除人ID", "删除人ID", java.lang.String.class, null);
	
	/**
	 * 删除时间 , 类型: java.util.Date
	*/
	public static final String DELETE_TIME="deleteTime";
	
	/**
	 * 删除时间 , 类型: java.util.Date
	*/
	public static final BeanProperty<com.dt.platform.domain.hr.AssessmentIndicatorVO,java.util.Date> DELETE_TIME_PROP = new BeanProperty(com.dt.platform.domain.hr.AssessmentIndicatorVO.class ,DELETE_TIME, java.util.Date.class, "删除时间", "删除时间", java.util.Date.class, null);
	
	/**
	 * 数据版本号 , 类型: java.lang.Integer
	*/
	public static final String VERSION="version";
	
	/**
	 * 数据版本号 , 类型: java.lang.Integer
	*/
	public static final BeanProperty<com.dt.platform.domain.hr.AssessmentIndicatorVO,java.lang.Integer> VERSION_PROP = new BeanProperty(com.dt.platform.domain.hr.AssessmentIndicatorVO.class ,VERSION, java.lang.Integer.class, "数据版本号", "数据版本号", java.lang.Integer.class, null);
	
	/**
	 * 租户 , 类型: java.lang.String
	*/
	public static final String TENANT_ID="tenantId";
	
	/**
	 * 租户 , 类型: java.lang.String
	*/
	public static final BeanProperty<com.dt.platform.domain.hr.AssessmentIndicatorVO,java.lang.String> TENANT_ID_PROP = new BeanProperty(com.dt.platform.domain.hr.AssessmentIndicatorVO.class ,TENANT_ID, java.lang.String.class, "租户", "租户", java.lang.String.class, null);
	
	/**
	 * selfAssessmentValue , 类型: com.dt.platform.domain.hr.AssessmentIndicatorValue
	*/
	public static final String SELF_ASSESSMENT_VALUE="selfAssessmentValue";
	
	/**
	 * selfAssessmentValue , 类型: com.dt.platform.domain.hr.AssessmentIndicatorValue
	*/
	public static final BeanProperty<com.dt.platform.domain.hr.AssessmentIndicatorVO,com.dt.platform.domain.hr.AssessmentIndicatorValue> SELF_ASSESSMENT_VALUE_PROP = new BeanProperty(com.dt.platform.domain.hr.AssessmentIndicatorVO.class ,SELF_ASSESSMENT_VALUE, com.dt.platform.domain.hr.AssessmentIndicatorValue.class, "selfAssessmentValue", "selfAssessmentValue", com.dt.platform.domain.hr.AssessmentIndicatorValue.class, null);
	
	/**
	 * leaderAssessmentValue , 类型: com.dt.platform.domain.hr.AssessmentIndicatorValue
	*/
	public static final String LEADER_ASSESSMENT_VALUE="leaderAssessmentValue";
	
	/**
	 * leaderAssessmentValue , 类型: com.dt.platform.domain.hr.AssessmentIndicatorValue
	*/
	public static final BeanProperty<com.dt.platform.domain.hr.AssessmentIndicatorVO,com.dt.platform.domain.hr.AssessmentIndicatorValue> LEADER_ASSESSMENT_VALUE_PROP = new BeanProperty(com.dt.platform.domain.hr.AssessmentIndicatorVO.class ,LEADER_ASSESSMENT_VALUE, com.dt.platform.domain.hr.AssessmentIndicatorValue.class, "leaderAssessmentValue", "leaderAssessmentValue", com.dt.platform.domain.hr.AssessmentIndicatorValue.class, null);
	
	/**
	 * sameAssessmentValue , 集合类型: LIST , 类型: com.dt.platform.domain.hr.AssessmentIndicatorValue
	*/
	public static final String SAME_ASSESSMENT_VALUE="sameAssessmentValue";
	
	/**
	 * sameAssessmentValue , 集合类型: LIST , 类型: com.dt.platform.domain.hr.AssessmentIndicatorValue
	*/
	public static final BeanProperty<com.dt.platform.domain.hr.AssessmentIndicatorVO,com.dt.platform.domain.hr.AssessmentIndicatorValue> SAME_ASSESSMENT_VALUE_PROP = new BeanProperty(com.dt.platform.domain.hr.AssessmentIndicatorVO.class ,SAME_ASSESSMENT_VALUE, java.util.List.class, "sameAssessmentValue", "sameAssessmentValue", com.dt.platform.domain.hr.AssessmentIndicatorValue.class, null);
	
	/**
	 * indicatorLib , 集合类型: LIST , 类型: com.dt.platform.domain.hr.IndicatorLib
	*/
	public static final String INDICATOR_LIB="indicatorLib";
	
	/**
	 * indicatorLib , 集合类型: LIST , 类型: com.dt.platform.domain.hr.IndicatorLib
	*/
	public static final BeanProperty<com.dt.platform.domain.hr.AssessmentIndicatorVO,com.dt.platform.domain.hr.IndicatorLib> INDICATOR_LIB_PROP = new BeanProperty(com.dt.platform.domain.hr.AssessmentIndicatorVO.class ,INDICATOR_LIB, java.util.List.class, "indicatorLib", "indicatorLib", com.dt.platform.domain.hr.IndicatorLib.class, null);
	
	/**
	 * 全部属性清单
	*/
	public static final String[] $PROPS={ PAGE_INDEX , PAGE_SIZE , SEARCH_FIELD , FUZZY_FIELD , SEARCH_VALUE , DIRTY_FIELDS , SORT_FIELD , SORT_TYPE , DATA_ORIGIN , QUERY_LOGIC , REQUEST_ACTION , IDS , ID , ASSESSMENT_ID , TPL_INDICATOR_ID , NAME , WEIGHT , TARGET_MIN_VALUE , TARGET_MAX_VALUE , DEFAULT_VALUE , PROPERTY , UNIT , DEF , SCORING_BASE , SCORING_BY , SN , CREATE_BY , CREATE_TIME , UPDATE_BY , UPDATE_TIME , DELETED , DELETE_BY , DELETE_TIME , VERSION , TENANT_ID , SELF_ASSESSMENT_VALUE , LEADER_ASSESSMENT_VALUE , SAME_ASSESSMENT_VALUE , INDICATOR_LIB };
	
	/**
	 * 代理类
	*/
	public static class $$proxy$$ extends com.dt.platform.domain.hr.AssessmentIndicatorVO {

		private static final long serialVersionUID = 1L;

		
		/**
		 * 设置 页码
		 * @param pageIndex 页码
		 * @return 当前对象
		*/
		public AssessmentIndicatorVO setPageIndex(Integer pageIndex) {
			super.change(PAGE_INDEX,super.getPageIndex(),pageIndex);
			super.setPageIndex(pageIndex);
			return this;
		}
		
		/**
		 * 设置 分页大小
		 * @param pageSize 分页大小
		 * @return 当前对象
		*/
		public AssessmentIndicatorVO setPageSize(Integer pageSize) {
			super.change(PAGE_SIZE,super.getPageSize(),pageSize);
			super.setPageSize(pageSize);
			return this;
		}
		
		/**
		 * 设置 搜索字段
		 * @param searchField 搜索字段
		 * @return 当前对象
		*/
		public AssessmentIndicatorVO setSearchField(String searchField) {
			super.change(SEARCH_FIELD,super.getSearchField(),searchField);
			super.setSearchField(searchField);
			return this;
		}
		
		/**
		 * 设置 模糊搜索字段
		 * @param fuzzyField 模糊搜索字段
		 * @return 当前对象
		*/
		public AssessmentIndicatorVO setFuzzyField(String fuzzyField) {
			super.change(FUZZY_FIELD,super.getFuzzyField(),fuzzyField);
			super.setFuzzyField(fuzzyField);
			return this;
		}
		
		/**
		 * 设置 搜索的值
		 * @param searchValue 搜索的值
		 * @return 当前对象
		*/
		public AssessmentIndicatorVO setSearchValue(String searchValue) {
			super.change(SEARCH_VALUE,super.getSearchValue(),searchValue);
			super.setSearchValue(searchValue);
			return this;
		}
		
		/**
		 * 设置 已修改字段
		 * @param dirtyFields 已修改字段
		 * @return 当前对象
		*/
		public AssessmentIndicatorVO setDirtyFields(List<String> dirtyFields) {
			super.change(DIRTY_FIELDS,super.getDirtyFields(),dirtyFields);
			super.setDirtyFields(dirtyFields);
			return this;
		}
		
		/**
		 * 设置 排序字段
		 * @param sortField 排序字段
		 * @return 当前对象
		*/
		public AssessmentIndicatorVO setSortField(String sortField) {
			super.change(SORT_FIELD,super.getSortField(),sortField);
			super.setSortField(sortField);
			return this;
		}
		
		/**
		 * 设置 排序方式
		 * @param sortType 排序方式
		 * @return 当前对象
		*/
		public AssessmentIndicatorVO setSortType(String sortType) {
			super.change(SORT_TYPE,super.getSortType(),sortType);
			super.setSortType(sortType);
			return this;
		}
		
		/**
		 * 设置 数据来源
		 * @param dataOrigin 数据来源
		 * @return 当前对象
		*/
		public AssessmentIndicatorVO setDataOrigin(String dataOrigin) {
			super.change(DATA_ORIGIN,super.getDataOrigin(),dataOrigin);
			super.setDataOrigin(dataOrigin);
			return this;
		}
		
		/**
		 * 设置 查询逻辑
		 * @param queryLogic 查询逻辑
		 * @return 当前对象
		*/
		public AssessmentIndicatorVO setQueryLogic(String queryLogic) {
			super.change(QUERY_LOGIC,super.getQueryLogic(),queryLogic);
			super.setQueryLogic(queryLogic);
			return this;
		}
		
		/**
		 * 设置 请求动作
		 * @param requestAction 请求动作
		 * @return 当前对象
		*/
		public AssessmentIndicatorVO setRequestAction(String requestAction) {
			super.change(REQUEST_ACTION,super.getRequestAction(),requestAction);
			super.setRequestAction(requestAction);
			return this;
		}
		
		/**
		 * 设置 主键清单
		 * @param ids 主键清单
		 * @return 当前对象
		*/
		public AssessmentIndicatorVO setIds(List<String> ids) {
			super.change(IDS,super.getIds(),ids);
			super.setIds(ids);
			return this;
		}
		
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
		public AssessmentIndicatorVO clone() {
			return duplicate(true);
		}

		/**
		 * 复制当前对象
		 * @param all 是否复制全部属性，当 false 时，仅复制来自数据表的属性
		*/
		@Transient
		public AssessmentIndicatorVO duplicate(boolean all) {
			$$proxy$$ inst=new $$proxy$$();
			inst.setScoringBase(this.getScoringBase());
			inst.setDef(this.getDef());
			inst.setDefaultValue(this.getDefaultValue());
			inst.setWeight(this.getWeight());
			inst.setUpdateTime(this.getUpdateTime());
			inst.setVersion(this.getVersion());
			inst.setScoringBy(this.getScoringBy());
			inst.setUnit(this.getUnit());
			inst.setCreateBy(this.getCreateBy());
			inst.setDeleted(this.getDeleted());
			inst.setCreateTime(this.getCreateTime());
			inst.setUpdateBy(this.getUpdateBy());
			inst.setDeleteTime(this.getDeleteTime());
			inst.setTargetMinValue(this.getTargetMinValue());
			inst.setName(this.getName());
			inst.setTargetMaxValue(this.getTargetMaxValue());
			inst.setProperty(this.getProperty());
			inst.setTenantId(this.getTenantId());
			inst.setDeleteBy(this.getDeleteBy());
			inst.setId(this.getId());
			inst.setSn(this.getSn());
			inst.setTplIndicatorId(this.getTplIndicatorId());
			inst.setAssessmentId(this.getAssessmentId());
			if(all) {
				inst.setIndicatorLib(this.getIndicatorLib());
				inst.setSearchField(this.getSearchField());
				inst.setSelfAssessmentValue(this.getSelfAssessmentValue());
				inst.setRequestAction(this.getRequestAction());
				inst.setFuzzyField(this.getFuzzyField());
				inst.setPageSize(this.getPageSize());
				inst.setLeaderAssessmentValue(this.getLeaderAssessmentValue());
				inst.setPageIndex(this.getPageIndex());
				inst.setSortType(this.getSortType());
				inst.setDirtyFields(this.getDirtyFields());
				inst.setSortField(this.getSortField());
				inst.setDataOrigin(this.getDataOrigin());
				inst.setIds(this.getIds());
				inst.setQueryLogic(this.getQueryLogic());
				inst.setSearchValue(this.getSearchValue());
				inst.setSameAssessmentValue(this.getSameAssessmentValue());
			}
			inst.clearModifies();
			return inst;
		}

	}
}