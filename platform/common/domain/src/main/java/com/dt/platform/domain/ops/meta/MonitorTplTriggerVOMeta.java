package com.dt.platform.domain.ops.meta;

import com.github.foxnic.api.bean.BeanProperty;
import com.dt.platform.domain.ops.MonitorTplTriggerVO;
import java.util.List;
import com.dt.platform.domain.ops.MonitorTplTrigger;
import java.util.Date;
import com.dt.platform.domain.ops.MonitorTpl;
import com.dt.platform.domain.ops.MonitorNode;
import javax.persistence.Transient;



/**
 * @author 金杰 , maillank@qq.com
 * @since 2023-10-05 23:33:26
 * @sign 1CE0B46D4AE363891DE76A401E183965
 * 此文件由工具自动生成，请勿修改。若表结构或配置发生变动，请使用工具重新生成。
*/

public class MonitorTplTriggerVOMeta extends MonitorTplTriggerMeta {
	
	/**
	 * 页码 , 类型: java.lang.Integer
	*/
	public static final String PAGE_INDEX="pageIndex";
	
	/**
	 * 页码 , 类型: java.lang.Integer
	*/
	public static final BeanProperty<com.dt.platform.domain.ops.MonitorTplTriggerVO,java.lang.Integer> PAGE_INDEX_PROP = new BeanProperty(com.dt.platform.domain.ops.MonitorTplTriggerVO.class ,PAGE_INDEX, java.lang.Integer.class, "页码", "", java.lang.Integer.class, null);
	
	/**
	 * 分页大小 , 类型: java.lang.Integer
	*/
	public static final String PAGE_SIZE="pageSize";
	
	/**
	 * 分页大小 , 类型: java.lang.Integer
	*/
	public static final BeanProperty<com.dt.platform.domain.ops.MonitorTplTriggerVO,java.lang.Integer> PAGE_SIZE_PROP = new BeanProperty(com.dt.platform.domain.ops.MonitorTplTriggerVO.class ,PAGE_SIZE, java.lang.Integer.class, "分页大小", "", java.lang.Integer.class, null);
	
	/**
	 * 搜索字段 , 类型: java.lang.String
	*/
	public static final String SEARCH_FIELD="searchField";
	
	/**
	 * 搜索字段 , 类型: java.lang.String
	*/
	public static final BeanProperty<com.dt.platform.domain.ops.MonitorTplTriggerVO,java.lang.String> SEARCH_FIELD_PROP = new BeanProperty(com.dt.platform.domain.ops.MonitorTplTriggerVO.class ,SEARCH_FIELD, java.lang.String.class, "搜索字段", "", java.lang.String.class, null);
	
	/**
	 * 模糊搜索字段 , 类型: java.lang.String
	*/
	public static final String FUZZY_FIELD="fuzzyField";
	
	/**
	 * 模糊搜索字段 , 类型: java.lang.String
	*/
	public static final BeanProperty<com.dt.platform.domain.ops.MonitorTplTriggerVO,java.lang.String> FUZZY_FIELD_PROP = new BeanProperty(com.dt.platform.domain.ops.MonitorTplTriggerVO.class ,FUZZY_FIELD, java.lang.String.class, "模糊搜索字段", "", java.lang.String.class, null);
	
	/**
	 * 搜索的值 , 类型: java.lang.String
	*/
	public static final String SEARCH_VALUE="searchValue";
	
	/**
	 * 搜索的值 , 类型: java.lang.String
	*/
	public static final BeanProperty<com.dt.platform.domain.ops.MonitorTplTriggerVO,java.lang.String> SEARCH_VALUE_PROP = new BeanProperty(com.dt.platform.domain.ops.MonitorTplTriggerVO.class ,SEARCH_VALUE, java.lang.String.class, "搜索的值", "", java.lang.String.class, null);
	
	/**
	 * 已修改字段 , 集合类型: LIST , 类型: java.lang.String
	*/
	public static final String DIRTY_FIELDS="dirtyFields";
	
	/**
	 * 已修改字段 , 集合类型: LIST , 类型: java.lang.String
	*/
	public static final BeanProperty<com.dt.platform.domain.ops.MonitorTplTriggerVO,java.lang.String> DIRTY_FIELDS_PROP = new BeanProperty(com.dt.platform.domain.ops.MonitorTplTriggerVO.class ,DIRTY_FIELDS, java.util.List.class, "已修改字段", "", java.lang.String.class, null);
	
	/**
	 * 排序字段 , 类型: java.lang.String
	*/
	public static final String SORT_FIELD="sortField";
	
	/**
	 * 排序字段 , 类型: java.lang.String
	*/
	public static final BeanProperty<com.dt.platform.domain.ops.MonitorTplTriggerVO,java.lang.String> SORT_FIELD_PROP = new BeanProperty(com.dt.platform.domain.ops.MonitorTplTriggerVO.class ,SORT_FIELD, java.lang.String.class, "排序字段", "", java.lang.String.class, null);
	
	/**
	 * 排序方式 , 类型: java.lang.String
	*/
	public static final String SORT_TYPE="sortType";
	
	/**
	 * 排序方式 , 类型: java.lang.String
	*/
	public static final BeanProperty<com.dt.platform.domain.ops.MonitorTplTriggerVO,java.lang.String> SORT_TYPE_PROP = new BeanProperty(com.dt.platform.domain.ops.MonitorTplTriggerVO.class ,SORT_TYPE, java.lang.String.class, "排序方式", "", java.lang.String.class, null);
	
	/**
	 * 数据来源 , 前端指定不同的来源，后端可按来源执行不同的逻辑 , 类型: java.lang.String
	*/
	public static final String DATA_ORIGIN="dataOrigin";
	
	/**
	 * 数据来源 , 前端指定不同的来源，后端可按来源执行不同的逻辑 , 类型: java.lang.String
	*/
	public static final BeanProperty<com.dt.platform.domain.ops.MonitorTplTriggerVO,java.lang.String> DATA_ORIGIN_PROP = new BeanProperty(com.dt.platform.domain.ops.MonitorTplTriggerVO.class ,DATA_ORIGIN, java.lang.String.class, "数据来源", "前端指定不同的来源，后端可按来源执行不同的逻辑", java.lang.String.class, null);
	
	/**
	 * 查询逻辑 , 默认and，可指定 or  , 类型: java.lang.String
	*/
	public static final String QUERY_LOGIC="queryLogic";
	
	/**
	 * 查询逻辑 , 默认and，可指定 or  , 类型: java.lang.String
	*/
	public static final BeanProperty<com.dt.platform.domain.ops.MonitorTplTriggerVO,java.lang.String> QUERY_LOGIC_PROP = new BeanProperty(com.dt.platform.domain.ops.MonitorTplTriggerVO.class ,QUERY_LOGIC, java.lang.String.class, "查询逻辑", "默认and，可指定 or ", java.lang.String.class, null);
	
	/**
	 * 请求动作 , 前端指定不同的Action，后端可Action执行不同的逻辑 , 类型: java.lang.String
	*/
	public static final String REQUEST_ACTION="requestAction";
	
	/**
	 * 请求动作 , 前端指定不同的Action，后端可Action执行不同的逻辑 , 类型: java.lang.String
	*/
	public static final BeanProperty<com.dt.platform.domain.ops.MonitorTplTriggerVO,java.lang.String> REQUEST_ACTION_PROP = new BeanProperty(com.dt.platform.domain.ops.MonitorTplTriggerVO.class ,REQUEST_ACTION, java.lang.String.class, "请求动作", "前端指定不同的Action，后端可Action执行不同的逻辑", java.lang.String.class, null);
	
	/**
	 * 主键清单 , 用于接收批量主键参数 , 集合类型: LIST , 类型: java.lang.String
	*/
	public static final String IDS="ids";
	
	/**
	 * 主键清单 , 用于接收批量主键参数 , 集合类型: LIST , 类型: java.lang.String
	*/
	public static final BeanProperty<com.dt.platform.domain.ops.MonitorTplTriggerVO,java.lang.String> IDS_PROP = new BeanProperty(com.dt.platform.domain.ops.MonitorTplTriggerVO.class ,IDS, java.util.List.class, "主键清单", "用于接收批量主键参数", java.lang.String.class, null);
	
	/**
	 * 主键 , 类型: java.lang.String
	*/
	public static final String ID="id";
	
	/**
	 * 主键 , 类型: java.lang.String
	*/
	public static final BeanProperty<com.dt.platform.domain.ops.MonitorTplTriggerVO,java.lang.String> ID_PROP = new BeanProperty(com.dt.platform.domain.ops.MonitorTplTriggerVO.class ,ID, java.lang.String.class, "主键", "主键", java.lang.String.class, null);
	
	/**
	 * 触发器 , 类型: java.lang.String
	*/
	public static final String NAME="name";
	
	/**
	 * 触发器 , 类型: java.lang.String
	*/
	public static final BeanProperty<com.dt.platform.domain.ops.MonitorTplTriggerVO,java.lang.String> NAME_PROP = new BeanProperty(com.dt.platform.domain.ops.MonitorTplTriggerVO.class ,NAME, java.lang.String.class, "触发器", "触发器", java.lang.String.class, null);
	
	/**
	 * 告警等级 , 类型: java.lang.String
	*/
	public static final String WARN_LEVEL="warnLevel";
	
	/**
	 * 告警等级 , 类型: java.lang.String
	*/
	public static final BeanProperty<com.dt.platform.domain.ops.MonitorTplTriggerVO,java.lang.String> WARN_LEVEL_PROP = new BeanProperty(com.dt.platform.domain.ops.MonitorTplTriggerVO.class ,WARN_LEVEL, java.lang.String.class, "告警等级", "告警等级", java.lang.String.class, null);
	
	/**
	 * 规则描述 , 类型: java.lang.String
	*/
	public static final String RULE_DESC="ruleDesc";
	
	/**
	 * 规则描述 , 类型: java.lang.String
	*/
	public static final BeanProperty<com.dt.platform.domain.ops.MonitorTplTriggerVO,java.lang.String> RULE_DESC_PROP = new BeanProperty(com.dt.platform.domain.ops.MonitorTplTriggerVO.class ,RULE_DESC, java.lang.String.class, "规则描述", "规则描述", java.lang.String.class, null);
	
	/**
	 * 规则 , 类型: java.lang.String
	*/
	public static final String RULE="rule";
	
	/**
	 * 规则 , 类型: java.lang.String
	*/
	public static final BeanProperty<com.dt.platform.domain.ops.MonitorTplTriggerVO,java.lang.String> RULE_PROP = new BeanProperty(com.dt.platform.domain.ops.MonitorTplTriggerVO.class ,RULE, java.lang.String.class, "规则", "规则", java.lang.String.class, null);
	
	/**
	 * 告警值 , 类型: java.lang.String
	*/
	public static final String CONTENT_VALUE="contentValue";
	
	/**
	 * 告警值 , 类型: java.lang.String
	*/
	public static final BeanProperty<com.dt.platform.domain.ops.MonitorTplTriggerVO,java.lang.String> CONTENT_VALUE_PROP = new BeanProperty(com.dt.platform.domain.ops.MonitorTplTriggerVO.class ,CONTENT_VALUE, java.lang.String.class, "告警值", "告警值", java.lang.String.class, null);
	
	/**
	 * 状态 , 类型: java.lang.String
	*/
	public static final String STATUS="status";
	
	/**
	 * 状态 , 类型: java.lang.String
	*/
	public static final BeanProperty<com.dt.platform.domain.ops.MonitorTplTriggerVO,java.lang.String> STATUS_PROP = new BeanProperty(com.dt.platform.domain.ops.MonitorTplTriggerVO.class ,STATUS, java.lang.String.class, "状态", "状态", java.lang.String.class, null);
	
	/**
	 * 监控模版 , 类型: java.lang.String
	*/
	public static final String MONITOR_TPL_CODE="monitorTplCode";
	
	/**
	 * 监控模版 , 类型: java.lang.String
	*/
	public static final BeanProperty<com.dt.platform.domain.ops.MonitorTplTriggerVO,java.lang.String> MONITOR_TPL_CODE_PROP = new BeanProperty(com.dt.platform.domain.ops.MonitorTplTriggerVO.class ,MONITOR_TPL_CODE, java.lang.String.class, "监控模版", "监控模版", java.lang.String.class, null);
	
	/**
	 * 备注 , 类型: java.lang.String
	*/
	public static final String NOTES="notes";
	
	/**
	 * 备注 , 类型: java.lang.String
	*/
	public static final BeanProperty<com.dt.platform.domain.ops.MonitorTplTriggerVO,java.lang.String> NOTES_PROP = new BeanProperty(com.dt.platform.domain.ops.MonitorTplTriggerVO.class ,NOTES, java.lang.String.class, "备注", "备注", java.lang.String.class, null);
	
	/**
	 * 创建人ID , 类型: java.lang.String
	*/
	public static final String CREATE_BY="createBy";
	
	/**
	 * 创建人ID , 类型: java.lang.String
	*/
	public static final BeanProperty<com.dt.platform.domain.ops.MonitorTplTriggerVO,java.lang.String> CREATE_BY_PROP = new BeanProperty(com.dt.platform.domain.ops.MonitorTplTriggerVO.class ,CREATE_BY, java.lang.String.class, "创建人ID", "创建人ID", java.lang.String.class, null);
	
	/**
	 * 创建时间 , 类型: java.util.Date
	*/
	public static final String CREATE_TIME="createTime";
	
	/**
	 * 创建时间 , 类型: java.util.Date
	*/
	public static final BeanProperty<com.dt.platform.domain.ops.MonitorTplTriggerVO,java.util.Date> CREATE_TIME_PROP = new BeanProperty(com.dt.platform.domain.ops.MonitorTplTriggerVO.class ,CREATE_TIME, java.util.Date.class, "创建时间", "创建时间", java.util.Date.class, null);
	
	/**
	 * 修改人ID , 类型: java.lang.String
	*/
	public static final String UPDATE_BY="updateBy";
	
	/**
	 * 修改人ID , 类型: java.lang.String
	*/
	public static final BeanProperty<com.dt.platform.domain.ops.MonitorTplTriggerVO,java.lang.String> UPDATE_BY_PROP = new BeanProperty(com.dt.platform.domain.ops.MonitorTplTriggerVO.class ,UPDATE_BY, java.lang.String.class, "修改人ID", "修改人ID", java.lang.String.class, null);
	
	/**
	 * 修改时间 , 类型: java.util.Date
	*/
	public static final String UPDATE_TIME="updateTime";
	
	/**
	 * 修改时间 , 类型: java.util.Date
	*/
	public static final BeanProperty<com.dt.platform.domain.ops.MonitorTplTriggerVO,java.util.Date> UPDATE_TIME_PROP = new BeanProperty(com.dt.platform.domain.ops.MonitorTplTriggerVO.class ,UPDATE_TIME, java.util.Date.class, "修改时间", "修改时间", java.util.Date.class, null);
	
	/**
	 * 是否已删除 , 类型: java.lang.Integer
	*/
	public static final String DELETED="deleted";
	
	/**
	 * 是否已删除 , 类型: java.lang.Integer
	*/
	public static final BeanProperty<com.dt.platform.domain.ops.MonitorTplTriggerVO,java.lang.Integer> DELETED_PROP = new BeanProperty(com.dt.platform.domain.ops.MonitorTplTriggerVO.class ,DELETED, java.lang.Integer.class, "是否已删除", "是否已删除", java.lang.Integer.class, null);
	
	/**
	 * 删除人ID , 类型: java.lang.String
	*/
	public static final String DELETE_BY="deleteBy";
	
	/**
	 * 删除人ID , 类型: java.lang.String
	*/
	public static final BeanProperty<com.dt.platform.domain.ops.MonitorTplTriggerVO,java.lang.String> DELETE_BY_PROP = new BeanProperty(com.dt.platform.domain.ops.MonitorTplTriggerVO.class ,DELETE_BY, java.lang.String.class, "删除人ID", "删除人ID", java.lang.String.class, null);
	
	/**
	 * 删除时间 , 类型: java.util.Date
	*/
	public static final String DELETE_TIME="deleteTime";
	
	/**
	 * 删除时间 , 类型: java.util.Date
	*/
	public static final BeanProperty<com.dt.platform.domain.ops.MonitorTplTriggerVO,java.util.Date> DELETE_TIME_PROP = new BeanProperty(com.dt.platform.domain.ops.MonitorTplTriggerVO.class ,DELETE_TIME, java.util.Date.class, "删除时间", "删除时间", java.util.Date.class, null);
	
	/**
	 * 版本 , 类型: java.lang.Integer
	*/
	public static final String VERSION="version";
	
	/**
	 * 版本 , 类型: java.lang.Integer
	*/
	public static final BeanProperty<com.dt.platform.domain.ops.MonitorTplTriggerVO,java.lang.Integer> VERSION_PROP = new BeanProperty(com.dt.platform.domain.ops.MonitorTplTriggerVO.class ,VERSION, java.lang.Integer.class, "版本", "版本", java.lang.Integer.class, null);
	
	/**
	 * 节点模版 , 类型: com.dt.platform.domain.ops.MonitorTpl
	*/
	public static final String TPL="tpl";
	
	/**
	 * 节点模版 , 类型: com.dt.platform.domain.ops.MonitorTpl
	*/
	public static final BeanProperty<com.dt.platform.domain.ops.MonitorTplTriggerVO,com.dt.platform.domain.ops.MonitorTpl> TPL_PROP = new BeanProperty(com.dt.platform.domain.ops.MonitorTplTriggerVO.class ,TPL, com.dt.platform.domain.ops.MonitorTpl.class, "节点模版", "节点模版", com.dt.platform.domain.ops.MonitorTpl.class, null);
	
	/**
	 * monitorNodeList , 集合类型: LIST , 类型: com.dt.platform.domain.ops.MonitorNode
	*/
	public static final String MONITOR_NODE_LIST="monitorNodeList";
	
	/**
	 * monitorNodeList , 集合类型: LIST , 类型: com.dt.platform.domain.ops.MonitorNode
	*/
	public static final BeanProperty<com.dt.platform.domain.ops.MonitorTplTriggerVO,com.dt.platform.domain.ops.MonitorNode> MONITOR_NODE_LIST_PROP = new BeanProperty(com.dt.platform.domain.ops.MonitorTplTriggerVO.class ,MONITOR_NODE_LIST, java.util.List.class, "monitorNodeList", "monitorNodeList", com.dt.platform.domain.ops.MonitorNode.class, null);
	
	/**
	 * 全部属性清单
	*/
	public static final String[] $PROPS={ PAGE_INDEX , PAGE_SIZE , SEARCH_FIELD , FUZZY_FIELD , SEARCH_VALUE , DIRTY_FIELDS , SORT_FIELD , SORT_TYPE , DATA_ORIGIN , QUERY_LOGIC , REQUEST_ACTION , IDS , ID , NAME , WARN_LEVEL , RULE_DESC , RULE , CONTENT_VALUE , STATUS , MONITOR_TPL_CODE , NOTES , CREATE_BY , CREATE_TIME , UPDATE_BY , UPDATE_TIME , DELETED , DELETE_BY , DELETE_TIME , VERSION , TPL , MONITOR_NODE_LIST };
	
	/**
	 * 代理类
	*/
	public static class $$proxy$$ extends com.dt.platform.domain.ops.MonitorTplTriggerVO {

		private static final long serialVersionUID = 1L;

		
		/**
		 * 设置 页码
		 * @param pageIndex 页码
		 * @return 当前对象
		*/
		public MonitorTplTriggerVO setPageIndex(Integer pageIndex) {
			super.change(PAGE_INDEX,super.getPageIndex(),pageIndex);
			super.setPageIndex(pageIndex);
			return this;
		}
		
		/**
		 * 设置 分页大小
		 * @param pageSize 分页大小
		 * @return 当前对象
		*/
		public MonitorTplTriggerVO setPageSize(Integer pageSize) {
			super.change(PAGE_SIZE,super.getPageSize(),pageSize);
			super.setPageSize(pageSize);
			return this;
		}
		
		/**
		 * 设置 搜索字段
		 * @param searchField 搜索字段
		 * @return 当前对象
		*/
		public MonitorTplTriggerVO setSearchField(String searchField) {
			super.change(SEARCH_FIELD,super.getSearchField(),searchField);
			super.setSearchField(searchField);
			return this;
		}
		
		/**
		 * 设置 模糊搜索字段
		 * @param fuzzyField 模糊搜索字段
		 * @return 当前对象
		*/
		public MonitorTplTriggerVO setFuzzyField(String fuzzyField) {
			super.change(FUZZY_FIELD,super.getFuzzyField(),fuzzyField);
			super.setFuzzyField(fuzzyField);
			return this;
		}
		
		/**
		 * 设置 搜索的值
		 * @param searchValue 搜索的值
		 * @return 当前对象
		*/
		public MonitorTplTriggerVO setSearchValue(String searchValue) {
			super.change(SEARCH_VALUE,super.getSearchValue(),searchValue);
			super.setSearchValue(searchValue);
			return this;
		}
		
		/**
		 * 设置 已修改字段
		 * @param dirtyFields 已修改字段
		 * @return 当前对象
		*/
		public MonitorTplTriggerVO setDirtyFields(List<String> dirtyFields) {
			super.change(DIRTY_FIELDS,super.getDirtyFields(),dirtyFields);
			super.setDirtyFields(dirtyFields);
			return this;
		}
		
		/**
		 * 设置 排序字段
		 * @param sortField 排序字段
		 * @return 当前对象
		*/
		public MonitorTplTriggerVO setSortField(String sortField) {
			super.change(SORT_FIELD,super.getSortField(),sortField);
			super.setSortField(sortField);
			return this;
		}
		
		/**
		 * 设置 排序方式
		 * @param sortType 排序方式
		 * @return 当前对象
		*/
		public MonitorTplTriggerVO setSortType(String sortType) {
			super.change(SORT_TYPE,super.getSortType(),sortType);
			super.setSortType(sortType);
			return this;
		}
		
		/**
		 * 设置 数据来源
		 * @param dataOrigin 数据来源
		 * @return 当前对象
		*/
		public MonitorTplTriggerVO setDataOrigin(String dataOrigin) {
			super.change(DATA_ORIGIN,super.getDataOrigin(),dataOrigin);
			super.setDataOrigin(dataOrigin);
			return this;
		}
		
		/**
		 * 设置 查询逻辑
		 * @param queryLogic 查询逻辑
		 * @return 当前对象
		*/
		public MonitorTplTriggerVO setQueryLogic(String queryLogic) {
			super.change(QUERY_LOGIC,super.getQueryLogic(),queryLogic);
			super.setQueryLogic(queryLogic);
			return this;
		}
		
		/**
		 * 设置 请求动作
		 * @param requestAction 请求动作
		 * @return 当前对象
		*/
		public MonitorTplTriggerVO setRequestAction(String requestAction) {
			super.change(REQUEST_ACTION,super.getRequestAction(),requestAction);
			super.setRequestAction(requestAction);
			return this;
		}
		
		/**
		 * 设置 主键清单
		 * @param ids 主键清单
		 * @return 当前对象
		*/
		public MonitorTplTriggerVO setIds(List<String> ids) {
			super.change(IDS,super.getIds(),ids);
			super.setIds(ids);
			return this;
		}
		
		/**
		 * 设置 主键
		 * @param id 主键
		 * @return 当前对象
		*/
		public MonitorTplTrigger setId(String id) {
			super.change(ID,super.getId(),id);
			super.setId(id);
			return this;
		}
		
		/**
		 * 设置 触发器
		 * @param name 触发器
		 * @return 当前对象
		*/
		public MonitorTplTrigger setName(String name) {
			super.change(NAME,super.getName(),name);
			super.setName(name);
			return this;
		}
		
		/**
		 * 设置 告警等级
		 * @param warnLevel 告警等级
		 * @return 当前对象
		*/
		public MonitorTplTrigger setWarnLevel(String warnLevel) {
			super.change(WARN_LEVEL,super.getWarnLevel(),warnLevel);
			super.setWarnLevel(warnLevel);
			return this;
		}
		
		/**
		 * 设置 规则描述
		 * @param ruleDesc 规则描述
		 * @return 当前对象
		*/
		public MonitorTplTrigger setRuleDesc(String ruleDesc) {
			super.change(RULE_DESC,super.getRuleDesc(),ruleDesc);
			super.setRuleDesc(ruleDesc);
			return this;
		}
		
		/**
		 * 设置 规则
		 * @param rule 规则
		 * @return 当前对象
		*/
		public MonitorTplTrigger setRule(String rule) {
			super.change(RULE,super.getRule(),rule);
			super.setRule(rule);
			return this;
		}
		
		/**
		 * 设置 告警值
		 * @param contentValue 告警值
		 * @return 当前对象
		*/
		public MonitorTplTrigger setContentValue(String contentValue) {
			super.change(CONTENT_VALUE,super.getContentValue(),contentValue);
			super.setContentValue(contentValue);
			return this;
		}
		
		/**
		 * 设置 状态
		 * @param status 状态
		 * @return 当前对象
		*/
		public MonitorTplTrigger setStatus(String status) {
			super.change(STATUS,super.getStatus(),status);
			super.setStatus(status);
			return this;
		}
		
		/**
		 * 设置 监控模版
		 * @param monitorTplCode 监控模版
		 * @return 当前对象
		*/
		public MonitorTplTrigger setMonitorTplCode(String monitorTplCode) {
			super.change(MONITOR_TPL_CODE,super.getMonitorTplCode(),monitorTplCode);
			super.setMonitorTplCode(monitorTplCode);
			return this;
		}
		
		/**
		 * 设置 备注
		 * @param notes 备注
		 * @return 当前对象
		*/
		public MonitorTplTrigger setNotes(String notes) {
			super.change(NOTES,super.getNotes(),notes);
			super.setNotes(notes);
			return this;
		}
		
		/**
		 * 设置 创建人ID
		 * @param createBy 创建人ID
		 * @return 当前对象
		*/
		public MonitorTplTrigger setCreateBy(String createBy) {
			super.change(CREATE_BY,super.getCreateBy(),createBy);
			super.setCreateBy(createBy);
			return this;
		}
		
		/**
		 * 设置 创建时间
		 * @param createTime 创建时间
		 * @return 当前对象
		*/
		public MonitorTplTrigger setCreateTime(Date createTime) {
			super.change(CREATE_TIME,super.getCreateTime(),createTime);
			super.setCreateTime(createTime);
			return this;
		}
		
		/**
		 * 设置 修改人ID
		 * @param updateBy 修改人ID
		 * @return 当前对象
		*/
		public MonitorTplTrigger setUpdateBy(String updateBy) {
			super.change(UPDATE_BY,super.getUpdateBy(),updateBy);
			super.setUpdateBy(updateBy);
			return this;
		}
		
		/**
		 * 设置 修改时间
		 * @param updateTime 修改时间
		 * @return 当前对象
		*/
		public MonitorTplTrigger setUpdateTime(Date updateTime) {
			super.change(UPDATE_TIME,super.getUpdateTime(),updateTime);
			super.setUpdateTime(updateTime);
			return this;
		}
		
		/**
		 * 设置 是否已删除
		 * @param deleted 是否已删除
		 * @return 当前对象
		*/
		public MonitorTplTrigger setDeleted(Integer deleted) {
			super.change(DELETED,super.getDeleted(),deleted);
			super.setDeleted(deleted);
			return this;
		}
		
		/**
		 * 设置 删除人ID
		 * @param deleteBy 删除人ID
		 * @return 当前对象
		*/
		public MonitorTplTrigger setDeleteBy(String deleteBy) {
			super.change(DELETE_BY,super.getDeleteBy(),deleteBy);
			super.setDeleteBy(deleteBy);
			return this;
		}
		
		/**
		 * 设置 删除时间
		 * @param deleteTime 删除时间
		 * @return 当前对象
		*/
		public MonitorTplTrigger setDeleteTime(Date deleteTime) {
			super.change(DELETE_TIME,super.getDeleteTime(),deleteTime);
			super.setDeleteTime(deleteTime);
			return this;
		}
		
		/**
		 * 设置 版本
		 * @param version 版本
		 * @return 当前对象
		*/
		public MonitorTplTrigger setVersion(Integer version) {
			super.change(VERSION,super.getVersion(),version);
			super.setVersion(version);
			return this;
		}
		
		/**
		 * 设置 节点模版
		 * @param tpl 节点模版
		 * @return 当前对象
		*/
		public MonitorTplTrigger setTpl(MonitorTpl tpl) {
			super.change(TPL,super.getTpl(),tpl);
			super.setTpl(tpl);
			return this;
		}
		
		/**
		 * 设置 monitorNodeList
		 * @param monitorNodeList monitorNodeList
		 * @return 当前对象
		*/
		public MonitorTplTrigger setMonitorNodeList(List<MonitorNode> monitorNodeList) {
			super.change(MONITOR_NODE_LIST,super.getMonitorNodeList(),monitorNodeList);
			super.setMonitorNodeList(monitorNodeList);
			return this;
		}

		/**
		 * 克隆当前对象
		*/
		@Transient
		public MonitorTplTriggerVO clone() {
			return duplicate(true);
		}

		/**
		 * 复制当前对象
		 * @param all 是否复制全部属性，当 false 时，仅复制来自数据表的属性
		*/
		@Transient
		public MonitorTplTriggerVO duplicate(boolean all) {
			$$proxy$$ inst=new $$proxy$$();
			inst.setNotes(this.getNotes());
			inst.setWarnLevel(this.getWarnLevel());
			inst.setRule(this.getRule());
			inst.setUpdateTime(this.getUpdateTime());
			inst.setVersion(this.getVersion());
			inst.setCreateBy(this.getCreateBy());
			inst.setDeleted(this.getDeleted());
			inst.setContentValue(this.getContentValue());
			inst.setMonitorTplCode(this.getMonitorTplCode());
			inst.setCreateTime(this.getCreateTime());
			inst.setUpdateBy(this.getUpdateBy());
			inst.setDeleteTime(this.getDeleteTime());
			inst.setRuleDesc(this.getRuleDesc());
			inst.setName(this.getName());
			inst.setDeleteBy(this.getDeleteBy());
			inst.setId(this.getId());
			inst.setStatus(this.getStatus());
			if(all) {
				inst.setMonitorNodeList(this.getMonitorNodeList());
				inst.setSearchField(this.getSearchField());
				inst.setRequestAction(this.getRequestAction());
				inst.setFuzzyField(this.getFuzzyField());
				inst.setPageSize(this.getPageSize());
				inst.setTpl(this.getTpl());
				inst.setPageIndex(this.getPageIndex());
				inst.setSortType(this.getSortType());
				inst.setDirtyFields(this.getDirtyFields());
				inst.setSortField(this.getSortField());
				inst.setDataOrigin(this.getDataOrigin());
				inst.setIds(this.getIds());
				inst.setQueryLogic(this.getQueryLogic());
				inst.setSearchValue(this.getSearchValue());
			}
			inst.clearModifies();
			return inst;
		}

	}
}