package com.dt.platform.domain.ops.meta;

import com.github.foxnic.api.bean.BeanProperty;
import com.dt.platform.domain.ops.AutoActionVO;
import java.util.List;
import com.dt.platform.domain.ops.AutoAction;
import java.util.Date;
import com.dt.platform.domain.ops.AutoActionScript;
import com.dt.platform.domain.ops.AutoActionFile;
import org.github.foxnic.web.domain.system.DictItem;
import javax.persistence.Transient;



/**
 * @author 金杰 , maillank@qq.com
 * @since 2023-09-01 18:56:10
 * @sign 9636481218004CE01A567242085AB52E
 * 此文件由工具自动生成，请勿修改。若表结构或配置发生变动，请使用工具重新生成。
*/

public class AutoActionVOMeta extends AutoActionMeta {
	
	/**
	 * 页码 , 类型: java.lang.Integer
	*/
	public static final String PAGE_INDEX="pageIndex";
	
	/**
	 * 页码 , 类型: java.lang.Integer
	*/
	public static final BeanProperty<com.dt.platform.domain.ops.AutoActionVO,java.lang.Integer> PAGE_INDEX_PROP = new BeanProperty(com.dt.platform.domain.ops.AutoActionVO.class ,PAGE_INDEX, java.lang.Integer.class, "页码", "", java.lang.Integer.class, null);
	
	/**
	 * 分页大小 , 类型: java.lang.Integer
	*/
	public static final String PAGE_SIZE="pageSize";
	
	/**
	 * 分页大小 , 类型: java.lang.Integer
	*/
	public static final BeanProperty<com.dt.platform.domain.ops.AutoActionVO,java.lang.Integer> PAGE_SIZE_PROP = new BeanProperty(com.dt.platform.domain.ops.AutoActionVO.class ,PAGE_SIZE, java.lang.Integer.class, "分页大小", "", java.lang.Integer.class, null);
	
	/**
	 * 搜索字段 , 类型: java.lang.String
	*/
	public static final String SEARCH_FIELD="searchField";
	
	/**
	 * 搜索字段 , 类型: java.lang.String
	*/
	public static final BeanProperty<com.dt.platform.domain.ops.AutoActionVO,java.lang.String> SEARCH_FIELD_PROP = new BeanProperty(com.dt.platform.domain.ops.AutoActionVO.class ,SEARCH_FIELD, java.lang.String.class, "搜索字段", "", java.lang.String.class, null);
	
	/**
	 * 模糊搜索字段 , 类型: java.lang.String
	*/
	public static final String FUZZY_FIELD="fuzzyField";
	
	/**
	 * 模糊搜索字段 , 类型: java.lang.String
	*/
	public static final BeanProperty<com.dt.platform.domain.ops.AutoActionVO,java.lang.String> FUZZY_FIELD_PROP = new BeanProperty(com.dt.platform.domain.ops.AutoActionVO.class ,FUZZY_FIELD, java.lang.String.class, "模糊搜索字段", "", java.lang.String.class, null);
	
	/**
	 * 搜索的值 , 类型: java.lang.String
	*/
	public static final String SEARCH_VALUE="searchValue";
	
	/**
	 * 搜索的值 , 类型: java.lang.String
	*/
	public static final BeanProperty<com.dt.platform.domain.ops.AutoActionVO,java.lang.String> SEARCH_VALUE_PROP = new BeanProperty(com.dt.platform.domain.ops.AutoActionVO.class ,SEARCH_VALUE, java.lang.String.class, "搜索的值", "", java.lang.String.class, null);
	
	/**
	 * 已修改字段 , 集合类型: LIST , 类型: java.lang.String
	*/
	public static final String DIRTY_FIELDS="dirtyFields";
	
	/**
	 * 已修改字段 , 集合类型: LIST , 类型: java.lang.String
	*/
	public static final BeanProperty<com.dt.platform.domain.ops.AutoActionVO,java.lang.String> DIRTY_FIELDS_PROP = new BeanProperty(com.dt.platform.domain.ops.AutoActionVO.class ,DIRTY_FIELDS, java.util.List.class, "已修改字段", "", java.lang.String.class, null);
	
	/**
	 * 排序字段 , 类型: java.lang.String
	*/
	public static final String SORT_FIELD="sortField";
	
	/**
	 * 排序字段 , 类型: java.lang.String
	*/
	public static final BeanProperty<com.dt.platform.domain.ops.AutoActionVO,java.lang.String> SORT_FIELD_PROP = new BeanProperty(com.dt.platform.domain.ops.AutoActionVO.class ,SORT_FIELD, java.lang.String.class, "排序字段", "", java.lang.String.class, null);
	
	/**
	 * 排序方式 , 类型: java.lang.String
	*/
	public static final String SORT_TYPE="sortType";
	
	/**
	 * 排序方式 , 类型: java.lang.String
	*/
	public static final BeanProperty<com.dt.platform.domain.ops.AutoActionVO,java.lang.String> SORT_TYPE_PROP = new BeanProperty(com.dt.platform.domain.ops.AutoActionVO.class ,SORT_TYPE, java.lang.String.class, "排序方式", "", java.lang.String.class, null);
	
	/**
	 * 数据来源 , 前端指定不同的来源，后端可按来源执行不同的逻辑 , 类型: java.lang.String
	*/
	public static final String DATA_ORIGIN="dataOrigin";
	
	/**
	 * 数据来源 , 前端指定不同的来源，后端可按来源执行不同的逻辑 , 类型: java.lang.String
	*/
	public static final BeanProperty<com.dt.platform.domain.ops.AutoActionVO,java.lang.String> DATA_ORIGIN_PROP = new BeanProperty(com.dt.platform.domain.ops.AutoActionVO.class ,DATA_ORIGIN, java.lang.String.class, "数据来源", "前端指定不同的来源，后端可按来源执行不同的逻辑", java.lang.String.class, null);
	
	/**
	 * 查询逻辑 , 默认and，可指定 or  , 类型: java.lang.String
	*/
	public static final String QUERY_LOGIC="queryLogic";
	
	/**
	 * 查询逻辑 , 默认and，可指定 or  , 类型: java.lang.String
	*/
	public static final BeanProperty<com.dt.platform.domain.ops.AutoActionVO,java.lang.String> QUERY_LOGIC_PROP = new BeanProperty(com.dt.platform.domain.ops.AutoActionVO.class ,QUERY_LOGIC, java.lang.String.class, "查询逻辑", "默认and，可指定 or ", java.lang.String.class, null);
	
	/**
	 * 请求动作 , 前端指定不同的Action，后端可Action执行不同的逻辑 , 类型: java.lang.String
	*/
	public static final String REQUEST_ACTION="requestAction";
	
	/**
	 * 请求动作 , 前端指定不同的Action，后端可Action执行不同的逻辑 , 类型: java.lang.String
	*/
	public static final BeanProperty<com.dt.platform.domain.ops.AutoActionVO,java.lang.String> REQUEST_ACTION_PROP = new BeanProperty(com.dt.platform.domain.ops.AutoActionVO.class ,REQUEST_ACTION, java.lang.String.class, "请求动作", "前端指定不同的Action，后端可Action执行不同的逻辑", java.lang.String.class, null);
	
	/**
	 * 主键清单 , 用于接收批量主键参数 , 集合类型: LIST , 类型: java.lang.String
	*/
	public static final String IDS="ids";
	
	/**
	 * 主键清单 , 用于接收批量主键参数 , 集合类型: LIST , 类型: java.lang.String
	*/
	public static final BeanProperty<com.dt.platform.domain.ops.AutoActionVO,java.lang.String> IDS_PROP = new BeanProperty(com.dt.platform.domain.ops.AutoActionVO.class ,IDS, java.util.List.class, "主键清单", "用于接收批量主键参数", java.lang.String.class, null);
	
	/**
	 * 主键 , 类型: java.lang.String
	*/
	public static final String ID="id";
	
	/**
	 * 主键 , 类型: java.lang.String
	*/
	public static final BeanProperty<com.dt.platform.domain.ops.AutoActionVO,java.lang.String> ID_PROP = new BeanProperty(com.dt.platform.domain.ops.AutoActionVO.class ,ID, java.lang.String.class, "主键", "主键", java.lang.String.class, null);
	
	/**
	 * 名称 , 类型: java.lang.String
	*/
	public static final String NAME="name";
	
	/**
	 * 名称 , 类型: java.lang.String
	*/
	public static final BeanProperty<com.dt.platform.domain.ops.AutoActionVO,java.lang.String> NAME_PROP = new BeanProperty(com.dt.platform.domain.ops.AutoActionVO.class ,NAME, java.lang.String.class, "名称", "名称", java.lang.String.class, null);
	
	/**
	 * 状态 , 类型: java.lang.String
	*/
	public static final String STATUS="status";
	
	/**
	 * 状态 , 类型: java.lang.String
	*/
	public static final BeanProperty<com.dt.platform.domain.ops.AutoActionVO,java.lang.String> STATUS_PROP = new BeanProperty(com.dt.platform.domain.ops.AutoActionVO.class ,STATUS, java.lang.String.class, "状态", "状态", java.lang.String.class, null);
	
	/**
	 * 类型 , 类型: java.lang.String
	*/
	public static final String TYPE="type";
	
	/**
	 * 类型 , 类型: java.lang.String
	*/
	public static final BeanProperty<com.dt.platform.domain.ops.AutoActionVO,java.lang.String> TYPE_PROP = new BeanProperty(com.dt.platform.domain.ops.AutoActionVO.class ,TYPE, java.lang.String.class, "类型", "类型", java.lang.String.class, null);
	
	/**
	 * 模版版本 , 类型: java.lang.String
	*/
	public static final String TPL_VERSION="tplVersion";
	
	/**
	 * 模版版本 , 类型: java.lang.String
	*/
	public static final BeanProperty<com.dt.platform.domain.ops.AutoActionVO,java.lang.String> TPL_VERSION_PROP = new BeanProperty(com.dt.platform.domain.ops.AutoActionVO.class ,TPL_VERSION, java.lang.String.class, "模版版本", "模版版本", java.lang.String.class, null);
	
	/**
	 * 场景 , 类型: java.lang.String
	*/
	public static final String SUPPORT="support";
	
	/**
	 * 场景 , 类型: java.lang.String
	*/
	public static final BeanProperty<com.dt.platform.domain.ops.AutoActionVO,java.lang.String> SUPPORT_PROP = new BeanProperty(com.dt.platform.domain.ops.AutoActionVO.class ,SUPPORT, java.lang.String.class, "场景", "场景", java.lang.String.class, null);
	
	/**
	 * 说明 , 类型: java.lang.String
	*/
	public static final String INFO="info";
	
	/**
	 * 说明 , 类型: java.lang.String
	*/
	public static final BeanProperty<com.dt.platform.domain.ops.AutoActionVO,java.lang.String> INFO_PROP = new BeanProperty(com.dt.platform.domain.ops.AutoActionVO.class ,INFO, java.lang.String.class, "说明", "说明", java.lang.String.class, null);
	
	/**
	 * 介质状态 , 类型: java.lang.String
	*/
	public static final String FILE_STATUS="fileStatus";
	
	/**
	 * 介质状态 , 类型: java.lang.String
	*/
	public static final BeanProperty<com.dt.platform.domain.ops.AutoActionVO,java.lang.String> FILE_STATUS_PROP = new BeanProperty(com.dt.platform.domain.ops.AutoActionVO.class ,FILE_STATUS, java.lang.String.class, "介质状态", "介质状态", java.lang.String.class, null);
	
	/**
	 * 节点数量 , 类型: java.lang.String
	*/
	public static final String NODE_NUMBER_TYPE="nodeNumberType";
	
	/**
	 * 节点数量 , 类型: java.lang.String
	*/
	public static final BeanProperty<com.dt.platform.domain.ops.AutoActionVO,java.lang.String> NODE_NUMBER_TYPE_PROP = new BeanProperty(com.dt.platform.domain.ops.AutoActionVO.class ,NODE_NUMBER_TYPE, java.lang.String.class, "节点数量", "节点数量", java.lang.String.class, null);
	
	/**
	 * 配置内容 , 类型: java.lang.String
	*/
	public static final String CONF_CONTENT="confContent";
	
	/**
	 * 配置内容 , 类型: java.lang.String
	*/
	public static final BeanProperty<com.dt.platform.domain.ops.AutoActionVO,java.lang.String> CONF_CONTENT_PROP = new BeanProperty(com.dt.platform.domain.ops.AutoActionVO.class ,CONF_CONTENT, java.lang.String.class, "配置内容", "配置内容", java.lang.String.class, null);
	
	/**
	 * 配置例子 , 类型: java.lang.String
	*/
	public static final String EXAMPLE_CONF_CONTENT="exampleConfContent";
	
	/**
	 * 配置例子 , 类型: java.lang.String
	*/
	public static final BeanProperty<com.dt.platform.domain.ops.AutoActionVO,java.lang.String> EXAMPLE_CONF_CONTENT_PROP = new BeanProperty(com.dt.platform.domain.ops.AutoActionVO.class ,EXAMPLE_CONF_CONTENT, java.lang.String.class, "配置例子", "配置例子", java.lang.String.class, null);
	
	/**
	 * 执行内容 , 类型: java.lang.String
	*/
	public static final String EXECUTE_CONTENT="executeContent";
	
	/**
	 * 执行内容 , 类型: java.lang.String
	*/
	public static final BeanProperty<com.dt.platform.domain.ops.AutoActionVO,java.lang.String> EXECUTE_CONTENT_PROP = new BeanProperty(com.dt.platform.domain.ops.AutoActionVO.class ,EXECUTE_CONTENT, java.lang.String.class, "执行内容", "执行内容", java.lang.String.class, null);
	
	/**
	 * 执行工具 , 类型: java.lang.String
	*/
	public static final String EXECUTE_TOOL="executeTool";
	
	/**
	 * 执行工具 , 类型: java.lang.String
	*/
	public static final BeanProperty<com.dt.platform.domain.ops.AutoActionVO,java.lang.String> EXECUTE_TOOL_PROP = new BeanProperty(com.dt.platform.domain.ops.AutoActionVO.class ,EXECUTE_TOOL, java.lang.String.class, "执行工具", "执行工具", java.lang.String.class, null);
	
	/**
	 * 备注 , 类型: java.lang.String
	*/
	public static final String NOTES="notes";
	
	/**
	 * 备注 , 类型: java.lang.String
	*/
	public static final BeanProperty<com.dt.platform.domain.ops.AutoActionVO,java.lang.String> NOTES_PROP = new BeanProperty(com.dt.platform.domain.ops.AutoActionVO.class ,NOTES, java.lang.String.class, "备注", "备注", java.lang.String.class, null);
	
	/**
	 * 创建人 , 类型: java.lang.String
	*/
	public static final String CREATE_BY="createBy";
	
	/**
	 * 创建人 , 类型: java.lang.String
	*/
	public static final BeanProperty<com.dt.platform.domain.ops.AutoActionVO,java.lang.String> CREATE_BY_PROP = new BeanProperty(com.dt.platform.domain.ops.AutoActionVO.class ,CREATE_BY, java.lang.String.class, "创建人", "创建人", java.lang.String.class, null);
	
	/**
	 * 创建时间 , 类型: java.util.Date
	*/
	public static final String CREATE_TIME="createTime";
	
	/**
	 * 创建时间 , 类型: java.util.Date
	*/
	public static final BeanProperty<com.dt.platform.domain.ops.AutoActionVO,java.util.Date> CREATE_TIME_PROP = new BeanProperty(com.dt.platform.domain.ops.AutoActionVO.class ,CREATE_TIME, java.util.Date.class, "创建时间", "创建时间", java.util.Date.class, null);
	
	/**
	 * 修改人ID , 类型: java.lang.String
	*/
	public static final String UPDATE_BY="updateBy";
	
	/**
	 * 修改人ID , 类型: java.lang.String
	*/
	public static final BeanProperty<com.dt.platform.domain.ops.AutoActionVO,java.lang.String> UPDATE_BY_PROP = new BeanProperty(com.dt.platform.domain.ops.AutoActionVO.class ,UPDATE_BY, java.lang.String.class, "修改人ID", "修改人ID", java.lang.String.class, null);
	
	/**
	 * 修改时间 , 类型: java.util.Date
	*/
	public static final String UPDATE_TIME="updateTime";
	
	/**
	 * 修改时间 , 类型: java.util.Date
	*/
	public static final BeanProperty<com.dt.platform.domain.ops.AutoActionVO,java.util.Date> UPDATE_TIME_PROP = new BeanProperty(com.dt.platform.domain.ops.AutoActionVO.class ,UPDATE_TIME, java.util.Date.class, "修改时间", "修改时间", java.util.Date.class, null);
	
	/**
	 * 是否已删除 , 类型: java.lang.Integer
	*/
	public static final String DELETED="deleted";
	
	/**
	 * 是否已删除 , 类型: java.lang.Integer
	*/
	public static final BeanProperty<com.dt.platform.domain.ops.AutoActionVO,java.lang.Integer> DELETED_PROP = new BeanProperty(com.dt.platform.domain.ops.AutoActionVO.class ,DELETED, java.lang.Integer.class, "是否已删除", "是否已删除", java.lang.Integer.class, null);
	
	/**
	 * 删除人ID , 类型: java.lang.String
	*/
	public static final String DELETE_BY="deleteBy";
	
	/**
	 * 删除人ID , 类型: java.lang.String
	*/
	public static final BeanProperty<com.dt.platform.domain.ops.AutoActionVO,java.lang.String> DELETE_BY_PROP = new BeanProperty(com.dt.platform.domain.ops.AutoActionVO.class ,DELETE_BY, java.lang.String.class, "删除人ID", "删除人ID", java.lang.String.class, null);
	
	/**
	 * 删除时间 , 类型: java.util.Date
	*/
	public static final String DELETE_TIME="deleteTime";
	
	/**
	 * 删除时间 , 类型: java.util.Date
	*/
	public static final BeanProperty<com.dt.platform.domain.ops.AutoActionVO,java.util.Date> DELETE_TIME_PROP = new BeanProperty(com.dt.platform.domain.ops.AutoActionVO.class ,DELETE_TIME, java.util.Date.class, "删除时间", "删除时间", java.util.Date.class, null);
	
	/**
	 * version , 类型: java.lang.Integer
	*/
	public static final String VERSION="version";
	
	/**
	 * version , 类型: java.lang.Integer
	*/
	public static final BeanProperty<com.dt.platform.domain.ops.AutoActionVO,java.lang.Integer> VERSION_PROP = new BeanProperty(com.dt.platform.domain.ops.AutoActionVO.class ,VERSION, java.lang.Integer.class, "version", "version", java.lang.Integer.class, null);
	
	/**
	 * 租户 , 类型: java.lang.String
	*/
	public static final String TENANT_ID="tenantId";
	
	/**
	 * 租户 , 类型: java.lang.String
	*/
	public static final BeanProperty<com.dt.platform.domain.ops.AutoActionVO,java.lang.String> TENANT_ID_PROP = new BeanProperty(com.dt.platform.domain.ops.AutoActionVO.class ,TENANT_ID, java.lang.String.class, "租户", "租户", java.lang.String.class, null);
	
	/**
	 * autoActionScriptList , 集合类型: LIST , 类型: com.dt.platform.domain.ops.AutoActionScript
	*/
	public static final String AUTO_ACTION_SCRIPT_LIST="autoActionScriptList";
	
	/**
	 * autoActionScriptList , 集合类型: LIST , 类型: com.dt.platform.domain.ops.AutoActionScript
	*/
	public static final BeanProperty<com.dt.platform.domain.ops.AutoActionVO,com.dt.platform.domain.ops.AutoActionScript> AUTO_ACTION_SCRIPT_LIST_PROP = new BeanProperty(com.dt.platform.domain.ops.AutoActionVO.class ,AUTO_ACTION_SCRIPT_LIST, java.util.List.class, "autoActionScriptList", "autoActionScriptList", com.dt.platform.domain.ops.AutoActionScript.class, null);
	
	/**
	 * autoActionScriptIds , 集合类型: LIST , 类型: java.lang.String
	*/
	public static final String AUTO_ACTION_SCRIPT_IDS="autoActionScriptIds";
	
	/**
	 * autoActionScriptIds , 集合类型: LIST , 类型: java.lang.String
	*/
	public static final BeanProperty<com.dt.platform.domain.ops.AutoActionVO,java.lang.String> AUTO_ACTION_SCRIPT_IDS_PROP = new BeanProperty(com.dt.platform.domain.ops.AutoActionVO.class ,AUTO_ACTION_SCRIPT_IDS, java.util.List.class, "autoActionScriptIds", "autoActionScriptIds", java.lang.String.class, null);
	
	/**
	 * autoActionFileList , 集合类型: LIST , 类型: com.dt.platform.domain.ops.AutoActionFile
	*/
	public static final String AUTO_ACTION_FILE_LIST="autoActionFileList";
	
	/**
	 * autoActionFileList , 集合类型: LIST , 类型: com.dt.platform.domain.ops.AutoActionFile
	*/
	public static final BeanProperty<com.dt.platform.domain.ops.AutoActionVO,com.dt.platform.domain.ops.AutoActionFile> AUTO_ACTION_FILE_LIST_PROP = new BeanProperty(com.dt.platform.domain.ops.AutoActionVO.class ,AUTO_ACTION_FILE_LIST, java.util.List.class, "autoActionFileList", "autoActionFileList", com.dt.platform.domain.ops.AutoActionFile.class, null);
	
	/**
	 * autoActionFileIds , 集合类型: LIST , 类型: java.lang.String
	*/
	public static final String AUTO_ACTION_FILE_IDS="autoActionFileIds";
	
	/**
	 * autoActionFileIds , 集合类型: LIST , 类型: java.lang.String
	*/
	public static final BeanProperty<com.dt.platform.domain.ops.AutoActionVO,java.lang.String> AUTO_ACTION_FILE_IDS_PROP = new BeanProperty(com.dt.platform.domain.ops.AutoActionVO.class ,AUTO_ACTION_FILE_IDS, java.util.List.class, "autoActionFileIds", "autoActionFileIds", java.lang.String.class, null);
	
	/**
	 * typeDict , 类型: org.github.foxnic.web.domain.system.DictItem
	*/
	public static final String TYPE_DICT="typeDict";
	
	/**
	 * typeDict , 类型: org.github.foxnic.web.domain.system.DictItem
	*/
	public static final BeanProperty<com.dt.platform.domain.ops.AutoActionVO,org.github.foxnic.web.domain.system.DictItem> TYPE_DICT_PROP = new BeanProperty(com.dt.platform.domain.ops.AutoActionVO.class ,TYPE_DICT, org.github.foxnic.web.domain.system.DictItem.class, "typeDict", "typeDict", org.github.foxnic.web.domain.system.DictItem.class, null);
	
	/**
	 * 全部属性清单
	*/
	public static final String[] $PROPS={ PAGE_INDEX , PAGE_SIZE , SEARCH_FIELD , FUZZY_FIELD , SEARCH_VALUE , DIRTY_FIELDS , SORT_FIELD , SORT_TYPE , DATA_ORIGIN , QUERY_LOGIC , REQUEST_ACTION , IDS , ID , NAME , STATUS , TYPE , TPL_VERSION , SUPPORT , INFO , FILE_STATUS , NODE_NUMBER_TYPE , CONF_CONTENT , EXAMPLE_CONF_CONTENT , EXECUTE_CONTENT , EXECUTE_TOOL , NOTES , CREATE_BY , CREATE_TIME , UPDATE_BY , UPDATE_TIME , DELETED , DELETE_BY , DELETE_TIME , VERSION , TENANT_ID , AUTO_ACTION_SCRIPT_LIST , AUTO_ACTION_SCRIPT_IDS , AUTO_ACTION_FILE_LIST , AUTO_ACTION_FILE_IDS , TYPE_DICT };
	
	/**
	 * 代理类
	*/
	public static class $$proxy$$ extends com.dt.platform.domain.ops.AutoActionVO {

		private static final long serialVersionUID = 1L;

		
		/**
		 * 设置 页码
		 * @param pageIndex 页码
		 * @return 当前对象
		*/
		public AutoActionVO setPageIndex(Integer pageIndex) {
			super.change(PAGE_INDEX,super.getPageIndex(),pageIndex);
			super.setPageIndex(pageIndex);
			return this;
		}
		
		/**
		 * 设置 分页大小
		 * @param pageSize 分页大小
		 * @return 当前对象
		*/
		public AutoActionVO setPageSize(Integer pageSize) {
			super.change(PAGE_SIZE,super.getPageSize(),pageSize);
			super.setPageSize(pageSize);
			return this;
		}
		
		/**
		 * 设置 搜索字段
		 * @param searchField 搜索字段
		 * @return 当前对象
		*/
		public AutoActionVO setSearchField(String searchField) {
			super.change(SEARCH_FIELD,super.getSearchField(),searchField);
			super.setSearchField(searchField);
			return this;
		}
		
		/**
		 * 设置 模糊搜索字段
		 * @param fuzzyField 模糊搜索字段
		 * @return 当前对象
		*/
		public AutoActionVO setFuzzyField(String fuzzyField) {
			super.change(FUZZY_FIELD,super.getFuzzyField(),fuzzyField);
			super.setFuzzyField(fuzzyField);
			return this;
		}
		
		/**
		 * 设置 搜索的值
		 * @param searchValue 搜索的值
		 * @return 当前对象
		*/
		public AutoActionVO setSearchValue(String searchValue) {
			super.change(SEARCH_VALUE,super.getSearchValue(),searchValue);
			super.setSearchValue(searchValue);
			return this;
		}
		
		/**
		 * 设置 已修改字段
		 * @param dirtyFields 已修改字段
		 * @return 当前对象
		*/
		public AutoActionVO setDirtyFields(List<String> dirtyFields) {
			super.change(DIRTY_FIELDS,super.getDirtyFields(),dirtyFields);
			super.setDirtyFields(dirtyFields);
			return this;
		}
		
		/**
		 * 设置 排序字段
		 * @param sortField 排序字段
		 * @return 当前对象
		*/
		public AutoActionVO setSortField(String sortField) {
			super.change(SORT_FIELD,super.getSortField(),sortField);
			super.setSortField(sortField);
			return this;
		}
		
		/**
		 * 设置 排序方式
		 * @param sortType 排序方式
		 * @return 当前对象
		*/
		public AutoActionVO setSortType(String sortType) {
			super.change(SORT_TYPE,super.getSortType(),sortType);
			super.setSortType(sortType);
			return this;
		}
		
		/**
		 * 设置 数据来源
		 * @param dataOrigin 数据来源
		 * @return 当前对象
		*/
		public AutoActionVO setDataOrigin(String dataOrigin) {
			super.change(DATA_ORIGIN,super.getDataOrigin(),dataOrigin);
			super.setDataOrigin(dataOrigin);
			return this;
		}
		
		/**
		 * 设置 查询逻辑
		 * @param queryLogic 查询逻辑
		 * @return 当前对象
		*/
		public AutoActionVO setQueryLogic(String queryLogic) {
			super.change(QUERY_LOGIC,super.getQueryLogic(),queryLogic);
			super.setQueryLogic(queryLogic);
			return this;
		}
		
		/**
		 * 设置 请求动作
		 * @param requestAction 请求动作
		 * @return 当前对象
		*/
		public AutoActionVO setRequestAction(String requestAction) {
			super.change(REQUEST_ACTION,super.getRequestAction(),requestAction);
			super.setRequestAction(requestAction);
			return this;
		}
		
		/**
		 * 设置 主键清单
		 * @param ids 主键清单
		 * @return 当前对象
		*/
		public AutoActionVO setIds(List<String> ids) {
			super.change(IDS,super.getIds(),ids);
			super.setIds(ids);
			return this;
		}
		
		/**
		 * 设置 主键
		 * @param id 主键
		 * @return 当前对象
		*/
		public AutoAction setId(String id) {
			super.change(ID,super.getId(),id);
			super.setId(id);
			return this;
		}
		
		/**
		 * 设置 名称
		 * @param name 名称
		 * @return 当前对象
		*/
		public AutoAction setName(String name) {
			super.change(NAME,super.getName(),name);
			super.setName(name);
			return this;
		}
		
		/**
		 * 设置 状态
		 * @param status 状态
		 * @return 当前对象
		*/
		public AutoAction setStatus(String status) {
			super.change(STATUS,super.getStatus(),status);
			super.setStatus(status);
			return this;
		}
		
		/**
		 * 设置 类型
		 * @param type 类型
		 * @return 当前对象
		*/
		public AutoAction setType(String type) {
			super.change(TYPE,super.getType(),type);
			super.setType(type);
			return this;
		}
		
		/**
		 * 设置 模版版本
		 * @param tplVersion 模版版本
		 * @return 当前对象
		*/
		public AutoAction setTplVersion(String tplVersion) {
			super.change(TPL_VERSION,super.getTplVersion(),tplVersion);
			super.setTplVersion(tplVersion);
			return this;
		}
		
		/**
		 * 设置 场景
		 * @param support 场景
		 * @return 当前对象
		*/
		public AutoAction setSupport(String support) {
			super.change(SUPPORT,super.getSupport(),support);
			super.setSupport(support);
			return this;
		}
		
		/**
		 * 设置 说明
		 * @param info 说明
		 * @return 当前对象
		*/
		public AutoAction setInfo(String info) {
			super.change(INFO,super.getInfo(),info);
			super.setInfo(info);
			return this;
		}
		
		/**
		 * 设置 介质状态
		 * @param fileStatus 介质状态
		 * @return 当前对象
		*/
		public AutoAction setFileStatus(String fileStatus) {
			super.change(FILE_STATUS,super.getFileStatus(),fileStatus);
			super.setFileStatus(fileStatus);
			return this;
		}
		
		/**
		 * 设置 节点数量
		 * @param nodeNumberType 节点数量
		 * @return 当前对象
		*/
		public AutoAction setNodeNumberType(String nodeNumberType) {
			super.change(NODE_NUMBER_TYPE,super.getNodeNumberType(),nodeNumberType);
			super.setNodeNumberType(nodeNumberType);
			return this;
		}
		
		/**
		 * 设置 配置内容
		 * @param confContent 配置内容
		 * @return 当前对象
		*/
		public AutoAction setConfContent(String confContent) {
			super.change(CONF_CONTENT,super.getConfContent(),confContent);
			super.setConfContent(confContent);
			return this;
		}
		
		/**
		 * 设置 配置例子
		 * @param exampleConfContent 配置例子
		 * @return 当前对象
		*/
		public AutoAction setExampleConfContent(String exampleConfContent) {
			super.change(EXAMPLE_CONF_CONTENT,super.getExampleConfContent(),exampleConfContent);
			super.setExampleConfContent(exampleConfContent);
			return this;
		}
		
		/**
		 * 设置 执行内容
		 * @param executeContent 执行内容
		 * @return 当前对象
		*/
		public AutoAction setExecuteContent(String executeContent) {
			super.change(EXECUTE_CONTENT,super.getExecuteContent(),executeContent);
			super.setExecuteContent(executeContent);
			return this;
		}
		
		/**
		 * 设置 执行工具
		 * @param executeTool 执行工具
		 * @return 当前对象
		*/
		public AutoAction setExecuteTool(String executeTool) {
			super.change(EXECUTE_TOOL,super.getExecuteTool(),executeTool);
			super.setExecuteTool(executeTool);
			return this;
		}
		
		/**
		 * 设置 备注
		 * @param notes 备注
		 * @return 当前对象
		*/
		public AutoAction setNotes(String notes) {
			super.change(NOTES,super.getNotes(),notes);
			super.setNotes(notes);
			return this;
		}
		
		/**
		 * 设置 创建人
		 * @param createBy 创建人
		 * @return 当前对象
		*/
		public AutoAction setCreateBy(String createBy) {
			super.change(CREATE_BY,super.getCreateBy(),createBy);
			super.setCreateBy(createBy);
			return this;
		}
		
		/**
		 * 设置 创建时间
		 * @param createTime 创建时间
		 * @return 当前对象
		*/
		public AutoAction setCreateTime(Date createTime) {
			super.change(CREATE_TIME,super.getCreateTime(),createTime);
			super.setCreateTime(createTime);
			return this;
		}
		
		/**
		 * 设置 修改人ID
		 * @param updateBy 修改人ID
		 * @return 当前对象
		*/
		public AutoAction setUpdateBy(String updateBy) {
			super.change(UPDATE_BY,super.getUpdateBy(),updateBy);
			super.setUpdateBy(updateBy);
			return this;
		}
		
		/**
		 * 设置 修改时间
		 * @param updateTime 修改时间
		 * @return 当前对象
		*/
		public AutoAction setUpdateTime(Date updateTime) {
			super.change(UPDATE_TIME,super.getUpdateTime(),updateTime);
			super.setUpdateTime(updateTime);
			return this;
		}
		
		/**
		 * 设置 是否已删除
		 * @param deleted 是否已删除
		 * @return 当前对象
		*/
		public AutoAction setDeleted(Integer deleted) {
			super.change(DELETED,super.getDeleted(),deleted);
			super.setDeleted(deleted);
			return this;
		}
		
		/**
		 * 设置 删除人ID
		 * @param deleteBy 删除人ID
		 * @return 当前对象
		*/
		public AutoAction setDeleteBy(String deleteBy) {
			super.change(DELETE_BY,super.getDeleteBy(),deleteBy);
			super.setDeleteBy(deleteBy);
			return this;
		}
		
		/**
		 * 设置 删除时间
		 * @param deleteTime 删除时间
		 * @return 当前对象
		*/
		public AutoAction setDeleteTime(Date deleteTime) {
			super.change(DELETE_TIME,super.getDeleteTime(),deleteTime);
			super.setDeleteTime(deleteTime);
			return this;
		}
		
		/**
		 * 设置 version
		 * @param version version
		 * @return 当前对象
		*/
		public AutoAction setVersion(Integer version) {
			super.change(VERSION,super.getVersion(),version);
			super.setVersion(version);
			return this;
		}
		
		/**
		 * 设置 租户
		 * @param tenantId 租户
		 * @return 当前对象
		*/
		public AutoAction setTenantId(String tenantId) {
			super.change(TENANT_ID,super.getTenantId(),tenantId);
			super.setTenantId(tenantId);
			return this;
		}
		
		/**
		 * 设置 autoActionScriptList
		 * @param autoActionScriptList autoActionScriptList
		 * @return 当前对象
		*/
		public AutoAction setAutoActionScriptList(List<AutoActionScript> autoActionScriptList) {
			super.change(AUTO_ACTION_SCRIPT_LIST,super.getAutoActionScriptList(),autoActionScriptList);
			super.setAutoActionScriptList(autoActionScriptList);
			return this;
		}
		
		/**
		 * 设置 autoActionScriptIds
		 * @param autoActionScriptIds autoActionScriptIds
		 * @return 当前对象
		*/
		public AutoAction setAutoActionScriptIds(List<String> autoActionScriptIds) {
			super.change(AUTO_ACTION_SCRIPT_IDS,super.getAutoActionScriptIds(),autoActionScriptIds);
			super.setAutoActionScriptIds(autoActionScriptIds);
			return this;
		}
		
		/**
		 * 设置 autoActionFileList
		 * @param autoActionFileList autoActionFileList
		 * @return 当前对象
		*/
		public AutoAction setAutoActionFileList(List<AutoActionFile> autoActionFileList) {
			super.change(AUTO_ACTION_FILE_LIST,super.getAutoActionFileList(),autoActionFileList);
			super.setAutoActionFileList(autoActionFileList);
			return this;
		}
		
		/**
		 * 设置 autoActionFileIds
		 * @param autoActionFileIds autoActionFileIds
		 * @return 当前对象
		*/
		public AutoAction setAutoActionFileIds(List<String> autoActionFileIds) {
			super.change(AUTO_ACTION_FILE_IDS,super.getAutoActionFileIds(),autoActionFileIds);
			super.setAutoActionFileIds(autoActionFileIds);
			return this;
		}
		
		/**
		 * 设置 typeDict
		 * @param typeDict typeDict
		 * @return 当前对象
		*/
		public AutoAction setTypeDict(DictItem typeDict) {
			super.change(TYPE_DICT,super.getTypeDict(),typeDict);
			super.setTypeDict(typeDict);
			return this;
		}

		/**
		 * 克隆当前对象
		*/
		@Transient
		public AutoActionVO clone() {
			return duplicate(true);
		}

		/**
		 * 复制当前对象
		 * @param all 是否复制全部属性，当 false 时，仅复制来自数据表的属性
		*/
		@Transient
		public AutoActionVO duplicate(boolean all) {
			$$proxy$$ inst=new $$proxy$$();
			inst.setNotes(this.getNotes());
			inst.setNodeNumberType(this.getNodeNumberType());
			inst.setExecuteContent(this.getExecuteContent());
			inst.setUpdateTime(this.getUpdateTime());
			inst.setType(this.getType());
			inst.setTplVersion(this.getTplVersion());
			inst.setConfContent(this.getConfContent());
			inst.setExampleConfContent(this.getExampleConfContent());
			inst.setVersion(this.getVersion());
			inst.setCreateBy(this.getCreateBy());
			inst.setExecuteTool(this.getExecuteTool());
			inst.setDeleted(this.getDeleted());
			inst.setFileStatus(this.getFileStatus());
			inst.setCreateTime(this.getCreateTime());
			inst.setUpdateBy(this.getUpdateBy());
			inst.setDeleteTime(this.getDeleteTime());
			inst.setName(this.getName());
			inst.setTenantId(this.getTenantId());
			inst.setDeleteBy(this.getDeleteBy());
			inst.setId(this.getId());
			inst.setSupport(this.getSupport());
			inst.setStatus(this.getStatus());
			inst.setInfo(this.getInfo());
			if(all) {
				inst.setSearchField(this.getSearchField());
				inst.setRequestAction(this.getRequestAction());
				inst.setFuzzyField(this.getFuzzyField());
				inst.setPageSize(this.getPageSize());
				inst.setAutoActionScriptList(this.getAutoActionScriptList());
				inst.setAutoActionScriptIds(this.getAutoActionScriptIds());
				inst.setAutoActionFileIds(this.getAutoActionFileIds());
				inst.setAutoActionFileList(this.getAutoActionFileList());
				inst.setPageIndex(this.getPageIndex());
				inst.setSortType(this.getSortType());
				inst.setDirtyFields(this.getDirtyFields());
				inst.setSortField(this.getSortField());
				inst.setTypeDict(this.getTypeDict());
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