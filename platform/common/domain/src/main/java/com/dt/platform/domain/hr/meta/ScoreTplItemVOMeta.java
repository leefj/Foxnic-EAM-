package com.dt.platform.domain.hr.meta;

import com.github.foxnic.api.bean.BeanProperty;
import com.dt.platform.domain.hr.ScoreTplItemVO;
import java.util.List;
import com.dt.platform.domain.hr.ScoreTplItem;
import java.math.BigDecimal;
import java.util.Date;
import com.dt.platform.domain.hr.ScoreIndicator;
import javax.persistence.Transient;



/**
 * @author 金杰 , maillank@qq.com
 * @since 2024-02-13 12:57:42
 * @sign E230DDC3EE4823936B308DFBD873AA86
 * 此文件由工具自动生成，请勿修改。若表结构或配置发生变动，请使用工具重新生成。
*/

public class ScoreTplItemVOMeta extends ScoreTplItemMeta {
	
	/**
	 * 页码 , 类型: java.lang.Integer
	*/
	public static final String PAGE_INDEX="pageIndex";
	
	/**
	 * 页码 , 类型: java.lang.Integer
	*/
	public static final BeanProperty<com.dt.platform.domain.hr.ScoreTplItemVO,java.lang.Integer> PAGE_INDEX_PROP = new BeanProperty(com.dt.platform.domain.hr.ScoreTplItemVO.class ,PAGE_INDEX, java.lang.Integer.class, "页码", "", java.lang.Integer.class, null);
	
	/**
	 * 分页大小 , 类型: java.lang.Integer
	*/
	public static final String PAGE_SIZE="pageSize";
	
	/**
	 * 分页大小 , 类型: java.lang.Integer
	*/
	public static final BeanProperty<com.dt.platform.domain.hr.ScoreTplItemVO,java.lang.Integer> PAGE_SIZE_PROP = new BeanProperty(com.dt.platform.domain.hr.ScoreTplItemVO.class ,PAGE_SIZE, java.lang.Integer.class, "分页大小", "", java.lang.Integer.class, null);
	
	/**
	 * 搜索字段 , 类型: java.lang.String
	*/
	public static final String SEARCH_FIELD="searchField";
	
	/**
	 * 搜索字段 , 类型: java.lang.String
	*/
	public static final BeanProperty<com.dt.platform.domain.hr.ScoreTplItemVO,java.lang.String> SEARCH_FIELD_PROP = new BeanProperty(com.dt.platform.domain.hr.ScoreTplItemVO.class ,SEARCH_FIELD, java.lang.String.class, "搜索字段", "", java.lang.String.class, null);
	
	/**
	 * 模糊搜索字段 , 类型: java.lang.String
	*/
	public static final String FUZZY_FIELD="fuzzyField";
	
	/**
	 * 模糊搜索字段 , 类型: java.lang.String
	*/
	public static final BeanProperty<com.dt.platform.domain.hr.ScoreTplItemVO,java.lang.String> FUZZY_FIELD_PROP = new BeanProperty(com.dt.platform.domain.hr.ScoreTplItemVO.class ,FUZZY_FIELD, java.lang.String.class, "模糊搜索字段", "", java.lang.String.class, null);
	
	/**
	 * 搜索的值 , 类型: java.lang.String
	*/
	public static final String SEARCH_VALUE="searchValue";
	
	/**
	 * 搜索的值 , 类型: java.lang.String
	*/
	public static final BeanProperty<com.dt.platform.domain.hr.ScoreTplItemVO,java.lang.String> SEARCH_VALUE_PROP = new BeanProperty(com.dt.platform.domain.hr.ScoreTplItemVO.class ,SEARCH_VALUE, java.lang.String.class, "搜索的值", "", java.lang.String.class, null);
	
	/**
	 * 已修改字段 , 集合类型: LIST , 类型: java.lang.String
	*/
	public static final String DIRTY_FIELDS="dirtyFields";
	
	/**
	 * 已修改字段 , 集合类型: LIST , 类型: java.lang.String
	*/
	public static final BeanProperty<com.dt.platform.domain.hr.ScoreTplItemVO,java.lang.String> DIRTY_FIELDS_PROP = new BeanProperty(com.dt.platform.domain.hr.ScoreTplItemVO.class ,DIRTY_FIELDS, java.util.List.class, "已修改字段", "", java.lang.String.class, null);
	
	/**
	 * 排序字段 , 类型: java.lang.String
	*/
	public static final String SORT_FIELD="sortField";
	
	/**
	 * 排序字段 , 类型: java.lang.String
	*/
	public static final BeanProperty<com.dt.platform.domain.hr.ScoreTplItemVO,java.lang.String> SORT_FIELD_PROP = new BeanProperty(com.dt.platform.domain.hr.ScoreTplItemVO.class ,SORT_FIELD, java.lang.String.class, "排序字段", "", java.lang.String.class, null);
	
	/**
	 * 排序方式 , 类型: java.lang.String
	*/
	public static final String SORT_TYPE="sortType";
	
	/**
	 * 排序方式 , 类型: java.lang.String
	*/
	public static final BeanProperty<com.dt.platform.domain.hr.ScoreTplItemVO,java.lang.String> SORT_TYPE_PROP = new BeanProperty(com.dt.platform.domain.hr.ScoreTplItemVO.class ,SORT_TYPE, java.lang.String.class, "排序方式", "", java.lang.String.class, null);
	
	/**
	 * 数据来源 , 前端指定不同的来源，后端可按来源执行不同的逻辑 , 类型: java.lang.String
	*/
	public static final String DATA_ORIGIN="dataOrigin";
	
	/**
	 * 数据来源 , 前端指定不同的来源，后端可按来源执行不同的逻辑 , 类型: java.lang.String
	*/
	public static final BeanProperty<com.dt.platform.domain.hr.ScoreTplItemVO,java.lang.String> DATA_ORIGIN_PROP = new BeanProperty(com.dt.platform.domain.hr.ScoreTplItemVO.class ,DATA_ORIGIN, java.lang.String.class, "数据来源", "前端指定不同的来源，后端可按来源执行不同的逻辑", java.lang.String.class, null);
	
	/**
	 * 查询逻辑 , 默认and，可指定 or  , 类型: java.lang.String
	*/
	public static final String QUERY_LOGIC="queryLogic";
	
	/**
	 * 查询逻辑 , 默认and，可指定 or  , 类型: java.lang.String
	*/
	public static final BeanProperty<com.dt.platform.domain.hr.ScoreTplItemVO,java.lang.String> QUERY_LOGIC_PROP = new BeanProperty(com.dt.platform.domain.hr.ScoreTplItemVO.class ,QUERY_LOGIC, java.lang.String.class, "查询逻辑", "默认and，可指定 or ", java.lang.String.class, null);
	
	/**
	 * 请求动作 , 前端指定不同的Action，后端可Action执行不同的逻辑 , 类型: java.lang.String
	*/
	public static final String REQUEST_ACTION="requestAction";
	
	/**
	 * 请求动作 , 前端指定不同的Action，后端可Action执行不同的逻辑 , 类型: java.lang.String
	*/
	public static final BeanProperty<com.dt.platform.domain.hr.ScoreTplItemVO,java.lang.String> REQUEST_ACTION_PROP = new BeanProperty(com.dt.platform.domain.hr.ScoreTplItemVO.class ,REQUEST_ACTION, java.lang.String.class, "请求动作", "前端指定不同的Action，后端可Action执行不同的逻辑", java.lang.String.class, null);
	
	/**
	 * 主键清单 , 用于接收批量主键参数 , 集合类型: LIST , 类型: java.lang.String
	*/
	public static final String IDS="ids";
	
	/**
	 * 主键清单 , 用于接收批量主键参数 , 集合类型: LIST , 类型: java.lang.String
	*/
	public static final BeanProperty<com.dt.platform.domain.hr.ScoreTplItemVO,java.lang.String> IDS_PROP = new BeanProperty(com.dt.platform.domain.hr.ScoreTplItemVO.class ,IDS, java.util.List.class, "主键清单", "用于接收批量主键参数", java.lang.String.class, null);
	
	/**
	 * 主键 , 类型: java.lang.String
	*/
	public static final String ID="id";
	
	/**
	 * 主键 , 类型: java.lang.String
	*/
	public static final BeanProperty<com.dt.platform.domain.hr.ScoreTplItemVO,java.lang.String> ID_PROP = new BeanProperty(com.dt.platform.domain.hr.ScoreTplItemVO.class ,ID, java.lang.String.class, "主键", "主键", java.lang.String.class, null);
	
	/**
	 * 模版 , 类型: java.lang.String
	*/
	public static final String TPL_ID="tplId";
	
	/**
	 * 模版 , 类型: java.lang.String
	*/
	public static final BeanProperty<com.dt.platform.domain.hr.ScoreTplItemVO,java.lang.String> TPL_ID_PROP = new BeanProperty(com.dt.platform.domain.hr.ScoreTplItemVO.class ,TPL_ID, java.lang.String.class, "模版", "模版", java.lang.String.class, null);
	
	/**
	 * 组件类型 , 类型: java.lang.String
	*/
	public static final String ITEM_TYPE="itemType";
	
	/**
	 * 组件类型 , 类型: java.lang.String
	*/
	public static final BeanProperty<com.dt.platform.domain.hr.ScoreTplItemVO,java.lang.String> ITEM_TYPE_PROP = new BeanProperty(com.dt.platform.domain.hr.ScoreTplItemVO.class ,ITEM_TYPE, java.lang.String.class, "组件类型", "组件类型", java.lang.String.class, null);
	
	/**
	 * 题目 , 类型: java.lang.String
	*/
	public static final String ITEM_NAME="itemName";
	
	/**
	 * 题目 , 类型: java.lang.String
	*/
	public static final BeanProperty<com.dt.platform.domain.hr.ScoreTplItemVO,java.lang.String> ITEM_NAME_PROP = new BeanProperty(com.dt.platform.domain.hr.ScoreTplItemVO.class ,ITEM_NAME, java.lang.String.class, "题目", "题目", java.lang.String.class, null);
	
	/**
	 * 指标 , 类型: java.lang.String
	*/
	public static final String GROUP_ID="groupId";
	
	/**
	 * 指标 , 类型: java.lang.String
	*/
	public static final BeanProperty<com.dt.platform.domain.hr.ScoreTplItemVO,java.lang.String> GROUP_ID_PROP = new BeanProperty(com.dt.platform.domain.hr.ScoreTplItemVO.class ,GROUP_ID, java.lang.String.class, "指标", "指标", java.lang.String.class, null);
	
	/**
	 * 最小分 , 类型: java.math.BigDecimal
	*/
	public static final String MIN_SCORE="minScore";
	
	/**
	 * 最小分 , 类型: java.math.BigDecimal
	*/
	public static final BeanProperty<com.dt.platform.domain.hr.ScoreTplItemVO,java.math.BigDecimal> MIN_SCORE_PROP = new BeanProperty(com.dt.platform.domain.hr.ScoreTplItemVO.class ,MIN_SCORE, java.math.BigDecimal.class, "最小分", "最小分", java.math.BigDecimal.class, null);
	
	/**
	 * 最大分 , 类型: java.math.BigDecimal
	*/
	public static final String MAX_SCORE="maxScore";
	
	/**
	 * 最大分 , 类型: java.math.BigDecimal
	*/
	public static final BeanProperty<com.dt.platform.domain.hr.ScoreTplItemVO,java.math.BigDecimal> MAX_SCORE_PROP = new BeanProperty(com.dt.platform.domain.hr.ScoreTplItemVO.class ,MAX_SCORE, java.math.BigDecimal.class, "最大分", "最大分", java.math.BigDecimal.class, null);
	
	/**
	 * 默认分 , 类型: java.math.BigDecimal
	*/
	public static final String DEF_SCORE="defScore";
	
	/**
	 * 默认分 , 类型: java.math.BigDecimal
	*/
	public static final BeanProperty<com.dt.platform.domain.hr.ScoreTplItemVO,java.math.BigDecimal> DEF_SCORE_PROP = new BeanProperty(com.dt.platform.domain.hr.ScoreTplItemVO.class ,DEF_SCORE, java.math.BigDecimal.class, "默认分", "默认分", java.math.BigDecimal.class, null);
	
	/**
	 * 排序 , 类型: java.lang.Integer
	*/
	public static final String SN="sn";
	
	/**
	 * 排序 , 类型: java.lang.Integer
	*/
	public static final BeanProperty<com.dt.platform.domain.hr.ScoreTplItemVO,java.lang.Integer> SN_PROP = new BeanProperty(com.dt.platform.domain.hr.ScoreTplItemVO.class ,SN, java.lang.Integer.class, "排序", "排序", java.lang.Integer.class, null);
	
	/**
	 * 备注 , 类型: java.lang.String
	*/
	public static final String NOTES="notes";
	
	/**
	 * 备注 , 类型: java.lang.String
	*/
	public static final BeanProperty<com.dt.platform.domain.hr.ScoreTplItemVO,java.lang.String> NOTES_PROP = new BeanProperty(com.dt.platform.domain.hr.ScoreTplItemVO.class ,NOTES, java.lang.String.class, "备注", "备注", java.lang.String.class, null);
	
	/**
	 * 创建人ID , 类型: java.lang.String
	*/
	public static final String CREATE_BY="createBy";
	
	/**
	 * 创建人ID , 类型: java.lang.String
	*/
	public static final BeanProperty<com.dt.platform.domain.hr.ScoreTplItemVO,java.lang.String> CREATE_BY_PROP = new BeanProperty(com.dt.platform.domain.hr.ScoreTplItemVO.class ,CREATE_BY, java.lang.String.class, "创建人ID", "创建人ID", java.lang.String.class, null);
	
	/**
	 * 创建时间 , 类型: java.util.Date
	*/
	public static final String CREATE_TIME="createTime";
	
	/**
	 * 创建时间 , 类型: java.util.Date
	*/
	public static final BeanProperty<com.dt.platform.domain.hr.ScoreTplItemVO,java.util.Date> CREATE_TIME_PROP = new BeanProperty(com.dt.platform.domain.hr.ScoreTplItemVO.class ,CREATE_TIME, java.util.Date.class, "创建时间", "创建时间", java.util.Date.class, null);
	
	/**
	 * 修改人ID , 类型: java.lang.String
	*/
	public static final String UPDATE_BY="updateBy";
	
	/**
	 * 修改人ID , 类型: java.lang.String
	*/
	public static final BeanProperty<com.dt.platform.domain.hr.ScoreTplItemVO,java.lang.String> UPDATE_BY_PROP = new BeanProperty(com.dt.platform.domain.hr.ScoreTplItemVO.class ,UPDATE_BY, java.lang.String.class, "修改人ID", "修改人ID", java.lang.String.class, null);
	
	/**
	 * 修改时间 , 类型: java.util.Date
	*/
	public static final String UPDATE_TIME="updateTime";
	
	/**
	 * 修改时间 , 类型: java.util.Date
	*/
	public static final BeanProperty<com.dt.platform.domain.hr.ScoreTplItemVO,java.util.Date> UPDATE_TIME_PROP = new BeanProperty(com.dt.platform.domain.hr.ScoreTplItemVO.class ,UPDATE_TIME, java.util.Date.class, "修改时间", "修改时间", java.util.Date.class, null);
	
	/**
	 * 是否已删除 , 类型: java.lang.Integer
	*/
	public static final String DELETED="deleted";
	
	/**
	 * 是否已删除 , 类型: java.lang.Integer
	*/
	public static final BeanProperty<com.dt.platform.domain.hr.ScoreTplItemVO,java.lang.Integer> DELETED_PROP = new BeanProperty(com.dt.platform.domain.hr.ScoreTplItemVO.class ,DELETED, java.lang.Integer.class, "是否已删除", "是否已删除", java.lang.Integer.class, null);
	
	/**
	 * 删除人ID , 类型: java.lang.String
	*/
	public static final String DELETE_BY="deleteBy";
	
	/**
	 * 删除人ID , 类型: java.lang.String
	*/
	public static final BeanProperty<com.dt.platform.domain.hr.ScoreTplItemVO,java.lang.String> DELETE_BY_PROP = new BeanProperty(com.dt.platform.domain.hr.ScoreTplItemVO.class ,DELETE_BY, java.lang.String.class, "删除人ID", "删除人ID", java.lang.String.class, null);
	
	/**
	 * 删除时间 , 类型: java.util.Date
	*/
	public static final String DELETE_TIME="deleteTime";
	
	/**
	 * 删除时间 , 类型: java.util.Date
	*/
	public static final BeanProperty<com.dt.platform.domain.hr.ScoreTplItemVO,java.util.Date> DELETE_TIME_PROP = new BeanProperty(com.dt.platform.domain.hr.ScoreTplItemVO.class ,DELETE_TIME, java.util.Date.class, "删除时间", "删除时间", java.util.Date.class, null);
	
	/**
	 * version , 类型: java.lang.Integer
	*/
	public static final String VERSION="version";
	
	/**
	 * version , 类型: java.lang.Integer
	*/
	public static final BeanProperty<com.dt.platform.domain.hr.ScoreTplItemVO,java.lang.Integer> VERSION_PROP = new BeanProperty(com.dt.platform.domain.hr.ScoreTplItemVO.class ,VERSION, java.lang.Integer.class, "version", "version", java.lang.Integer.class, null);
	
	/**
	 * 租户 , 类型: java.lang.String
	*/
	public static final String TENANT_ID="tenantId";
	
	/**
	 * 租户 , 类型: java.lang.String
	*/
	public static final BeanProperty<com.dt.platform.domain.hr.ScoreTplItemVO,java.lang.String> TENANT_ID_PROP = new BeanProperty(com.dt.platform.domain.hr.ScoreTplItemVO.class ,TENANT_ID, java.lang.String.class, "租户", "租户", java.lang.String.class, null);
	
	/**
	 * scoreIndicator , 类型: com.dt.platform.domain.hr.ScoreIndicator
	*/
	public static final String SCORE_INDICATOR="scoreIndicator";
	
	/**
	 * scoreIndicator , 类型: com.dt.platform.domain.hr.ScoreIndicator
	*/
	public static final BeanProperty<com.dt.platform.domain.hr.ScoreTplItemVO,com.dt.platform.domain.hr.ScoreIndicator> SCORE_INDICATOR_PROP = new BeanProperty(com.dt.platform.domain.hr.ScoreTplItemVO.class ,SCORE_INDICATOR, com.dt.platform.domain.hr.ScoreIndicator.class, "scoreIndicator", "scoreIndicator", com.dt.platform.domain.hr.ScoreIndicator.class, null);
	
	/**
	 * 全部属性清单
	*/
	public static final String[] $PROPS={ PAGE_INDEX , PAGE_SIZE , SEARCH_FIELD , FUZZY_FIELD , SEARCH_VALUE , DIRTY_FIELDS , SORT_FIELD , SORT_TYPE , DATA_ORIGIN , QUERY_LOGIC , REQUEST_ACTION , IDS , ID , TPL_ID , ITEM_TYPE , ITEM_NAME , GROUP_ID , MIN_SCORE , MAX_SCORE , DEF_SCORE , SN , NOTES , CREATE_BY , CREATE_TIME , UPDATE_BY , UPDATE_TIME , DELETED , DELETE_BY , DELETE_TIME , VERSION , TENANT_ID , SCORE_INDICATOR };
	
	/**
	 * 代理类
	*/
	public static class $$proxy$$ extends com.dt.platform.domain.hr.ScoreTplItemVO {

		private static final long serialVersionUID = 1L;

		
		/**
		 * 设置 页码
		 * @param pageIndex 页码
		 * @return 当前对象
		*/
		public ScoreTplItemVO setPageIndex(Integer pageIndex) {
			super.change(PAGE_INDEX,super.getPageIndex(),pageIndex);
			super.setPageIndex(pageIndex);
			return this;
		}
		
		/**
		 * 设置 分页大小
		 * @param pageSize 分页大小
		 * @return 当前对象
		*/
		public ScoreTplItemVO setPageSize(Integer pageSize) {
			super.change(PAGE_SIZE,super.getPageSize(),pageSize);
			super.setPageSize(pageSize);
			return this;
		}
		
		/**
		 * 设置 搜索字段
		 * @param searchField 搜索字段
		 * @return 当前对象
		*/
		public ScoreTplItemVO setSearchField(String searchField) {
			super.change(SEARCH_FIELD,super.getSearchField(),searchField);
			super.setSearchField(searchField);
			return this;
		}
		
		/**
		 * 设置 模糊搜索字段
		 * @param fuzzyField 模糊搜索字段
		 * @return 当前对象
		*/
		public ScoreTplItemVO setFuzzyField(String fuzzyField) {
			super.change(FUZZY_FIELD,super.getFuzzyField(),fuzzyField);
			super.setFuzzyField(fuzzyField);
			return this;
		}
		
		/**
		 * 设置 搜索的值
		 * @param searchValue 搜索的值
		 * @return 当前对象
		*/
		public ScoreTplItemVO setSearchValue(String searchValue) {
			super.change(SEARCH_VALUE,super.getSearchValue(),searchValue);
			super.setSearchValue(searchValue);
			return this;
		}
		
		/**
		 * 设置 已修改字段
		 * @param dirtyFields 已修改字段
		 * @return 当前对象
		*/
		public ScoreTplItemVO setDirtyFields(List<String> dirtyFields) {
			super.change(DIRTY_FIELDS,super.getDirtyFields(),dirtyFields);
			super.setDirtyFields(dirtyFields);
			return this;
		}
		
		/**
		 * 设置 排序字段
		 * @param sortField 排序字段
		 * @return 当前对象
		*/
		public ScoreTplItemVO setSortField(String sortField) {
			super.change(SORT_FIELD,super.getSortField(),sortField);
			super.setSortField(sortField);
			return this;
		}
		
		/**
		 * 设置 排序方式
		 * @param sortType 排序方式
		 * @return 当前对象
		*/
		public ScoreTplItemVO setSortType(String sortType) {
			super.change(SORT_TYPE,super.getSortType(),sortType);
			super.setSortType(sortType);
			return this;
		}
		
		/**
		 * 设置 数据来源
		 * @param dataOrigin 数据来源
		 * @return 当前对象
		*/
		public ScoreTplItemVO setDataOrigin(String dataOrigin) {
			super.change(DATA_ORIGIN,super.getDataOrigin(),dataOrigin);
			super.setDataOrigin(dataOrigin);
			return this;
		}
		
		/**
		 * 设置 查询逻辑
		 * @param queryLogic 查询逻辑
		 * @return 当前对象
		*/
		public ScoreTplItemVO setQueryLogic(String queryLogic) {
			super.change(QUERY_LOGIC,super.getQueryLogic(),queryLogic);
			super.setQueryLogic(queryLogic);
			return this;
		}
		
		/**
		 * 设置 请求动作
		 * @param requestAction 请求动作
		 * @return 当前对象
		*/
		public ScoreTplItemVO setRequestAction(String requestAction) {
			super.change(REQUEST_ACTION,super.getRequestAction(),requestAction);
			super.setRequestAction(requestAction);
			return this;
		}
		
		/**
		 * 设置 主键清单
		 * @param ids 主键清单
		 * @return 当前对象
		*/
		public ScoreTplItemVO setIds(List<String> ids) {
			super.change(IDS,super.getIds(),ids);
			super.setIds(ids);
			return this;
		}
		
		/**
		 * 设置 主键
		 * @param id 主键
		 * @return 当前对象
		*/
		public ScoreTplItem setId(String id) {
			super.change(ID,super.getId(),id);
			super.setId(id);
			return this;
		}
		
		/**
		 * 设置 模版
		 * @param tplId 模版
		 * @return 当前对象
		*/
		public ScoreTplItem setTplId(String tplId) {
			super.change(TPL_ID,super.getTplId(),tplId);
			super.setTplId(tplId);
			return this;
		}
		
		/**
		 * 设置 组件类型
		 * @param itemType 组件类型
		 * @return 当前对象
		*/
		public ScoreTplItem setItemType(String itemType) {
			super.change(ITEM_TYPE,super.getItemType(),itemType);
			super.setItemType(itemType);
			return this;
		}
		
		/**
		 * 设置 题目
		 * @param itemName 题目
		 * @return 当前对象
		*/
		public ScoreTplItem setItemName(String itemName) {
			super.change(ITEM_NAME,super.getItemName(),itemName);
			super.setItemName(itemName);
			return this;
		}
		
		/**
		 * 设置 指标
		 * @param groupId 指标
		 * @return 当前对象
		*/
		public ScoreTplItem setGroupId(String groupId) {
			super.change(GROUP_ID,super.getGroupId(),groupId);
			super.setGroupId(groupId);
			return this;
		}
		
		/**
		 * 设置 最小分
		 * @param minScore 最小分
		 * @return 当前对象
		*/
		public ScoreTplItem setMinScore(BigDecimal minScore) {
			super.change(MIN_SCORE,super.getMinScore(),minScore);
			super.setMinScore(minScore);
			return this;
		}
		
		/**
		 * 设置 最大分
		 * @param maxScore 最大分
		 * @return 当前对象
		*/
		public ScoreTplItem setMaxScore(BigDecimal maxScore) {
			super.change(MAX_SCORE,super.getMaxScore(),maxScore);
			super.setMaxScore(maxScore);
			return this;
		}
		
		/**
		 * 设置 默认分
		 * @param defScore 默认分
		 * @return 当前对象
		*/
		public ScoreTplItem setDefScore(BigDecimal defScore) {
			super.change(DEF_SCORE,super.getDefScore(),defScore);
			super.setDefScore(defScore);
			return this;
		}
		
		/**
		 * 设置 排序
		 * @param sn 排序
		 * @return 当前对象
		*/
		public ScoreTplItem setSn(Integer sn) {
			super.change(SN,super.getSn(),sn);
			super.setSn(sn);
			return this;
		}
		
		/**
		 * 设置 备注
		 * @param notes 备注
		 * @return 当前对象
		*/
		public ScoreTplItem setNotes(String notes) {
			super.change(NOTES,super.getNotes(),notes);
			super.setNotes(notes);
			return this;
		}
		
		/**
		 * 设置 创建人ID
		 * @param createBy 创建人ID
		 * @return 当前对象
		*/
		public ScoreTplItem setCreateBy(String createBy) {
			super.change(CREATE_BY,super.getCreateBy(),createBy);
			super.setCreateBy(createBy);
			return this;
		}
		
		/**
		 * 设置 创建时间
		 * @param createTime 创建时间
		 * @return 当前对象
		*/
		public ScoreTplItem setCreateTime(Date createTime) {
			super.change(CREATE_TIME,super.getCreateTime(),createTime);
			super.setCreateTime(createTime);
			return this;
		}
		
		/**
		 * 设置 修改人ID
		 * @param updateBy 修改人ID
		 * @return 当前对象
		*/
		public ScoreTplItem setUpdateBy(String updateBy) {
			super.change(UPDATE_BY,super.getUpdateBy(),updateBy);
			super.setUpdateBy(updateBy);
			return this;
		}
		
		/**
		 * 设置 修改时间
		 * @param updateTime 修改时间
		 * @return 当前对象
		*/
		public ScoreTplItem setUpdateTime(Date updateTime) {
			super.change(UPDATE_TIME,super.getUpdateTime(),updateTime);
			super.setUpdateTime(updateTime);
			return this;
		}
		
		/**
		 * 设置 是否已删除
		 * @param deleted 是否已删除
		 * @return 当前对象
		*/
		public ScoreTplItem setDeleted(Integer deleted) {
			super.change(DELETED,super.getDeleted(),deleted);
			super.setDeleted(deleted);
			return this;
		}
		
		/**
		 * 设置 删除人ID
		 * @param deleteBy 删除人ID
		 * @return 当前对象
		*/
		public ScoreTplItem setDeleteBy(String deleteBy) {
			super.change(DELETE_BY,super.getDeleteBy(),deleteBy);
			super.setDeleteBy(deleteBy);
			return this;
		}
		
		/**
		 * 设置 删除时间
		 * @param deleteTime 删除时间
		 * @return 当前对象
		*/
		public ScoreTplItem setDeleteTime(Date deleteTime) {
			super.change(DELETE_TIME,super.getDeleteTime(),deleteTime);
			super.setDeleteTime(deleteTime);
			return this;
		}
		
		/**
		 * 设置 version
		 * @param version version
		 * @return 当前对象
		*/
		public ScoreTplItem setVersion(Integer version) {
			super.change(VERSION,super.getVersion(),version);
			super.setVersion(version);
			return this;
		}
		
		/**
		 * 设置 租户
		 * @param tenantId 租户
		 * @return 当前对象
		*/
		public ScoreTplItem setTenantId(String tenantId) {
			super.change(TENANT_ID,super.getTenantId(),tenantId);
			super.setTenantId(tenantId);
			return this;
		}
		
		/**
		 * 设置 scoreIndicator
		 * @param scoreIndicator scoreIndicator
		 * @return 当前对象
		*/
		public ScoreTplItem setScoreIndicator(ScoreIndicator scoreIndicator) {
			super.change(SCORE_INDICATOR,super.getScoreIndicator(),scoreIndicator);
			super.setScoreIndicator(scoreIndicator);
			return this;
		}

		/**
		 * 克隆当前对象
		*/
		@Transient
		public ScoreTplItemVO clone() {
			return duplicate(true);
		}

		/**
		 * 复制当前对象
		 * @param all 是否复制全部属性，当 false 时，仅复制来自数据表的属性
		*/
		@Transient
		public ScoreTplItemVO duplicate(boolean all) {
			$$proxy$$ inst=new $$proxy$$();
			inst.setItemType(this.getItemType());
			inst.setMinScore(this.getMinScore());
			inst.setNotes(this.getNotes());
			inst.setGroupId(this.getGroupId());
			inst.setUpdateTime(this.getUpdateTime());
			inst.setMaxScore(this.getMaxScore());
			inst.setVersion(this.getVersion());
			inst.setItemName(this.getItemName());
			inst.setCreateBy(this.getCreateBy());
			inst.setDeleted(this.getDeleted());
			inst.setDefScore(this.getDefScore());
			inst.setCreateTime(this.getCreateTime());
			inst.setUpdateBy(this.getUpdateBy());
			inst.setDeleteTime(this.getDeleteTime());
			inst.setTenantId(this.getTenantId());
			inst.setDeleteBy(this.getDeleteBy());
			inst.setId(this.getId());
			inst.setSn(this.getSn());
			inst.setTplId(this.getTplId());
			if(all) {
				inst.setSearchField(this.getSearchField());
				inst.setRequestAction(this.getRequestAction());
				inst.setFuzzyField(this.getFuzzyField());
				inst.setPageSize(this.getPageSize());
				inst.setPageIndex(this.getPageIndex());
				inst.setSortType(this.getSortType());
				inst.setDirtyFields(this.getDirtyFields());
				inst.setSortField(this.getSortField());
				inst.setDataOrigin(this.getDataOrigin());
				inst.setIds(this.getIds());
				inst.setQueryLogic(this.getQueryLogic());
				inst.setScoreIndicator(this.getScoreIndicator());
				inst.setSearchValue(this.getSearchValue());
			}
			inst.clearModifies();
			return inst;
		}

	}
}