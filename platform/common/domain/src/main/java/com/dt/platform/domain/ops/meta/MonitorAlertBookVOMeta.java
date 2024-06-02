package com.dt.platform.domain.ops.meta;

import com.github.foxnic.api.bean.BeanProperty;
import com.dt.platform.domain.ops.MonitorAlertBookVO;
import java.util.List;
import com.dt.platform.domain.ops.MonitorAlertBook;
import java.util.Date;
import org.github.foxnic.web.domain.system.BusiRole;
import org.github.foxnic.web.domain.hrm.Employee;
import com.dt.platform.domain.ops.MonitorNodeGroup;
import com.dt.platform.domain.ops.MonitorNode;
import org.github.foxnic.web.domain.system.DictItem;
import com.dt.platform.domain.ops.MonitorAlertMethod;
import javax.persistence.Transient;



/**
 * @author 金杰 , maillank@qq.com
 * @since 2024-06-02 14:21:56
 * @sign A826E9B93F5393FFA9818F36134127F1
 * 此文件由工具自动生成，请勿修改。若表结构或配置发生变动，请使用工具重新生成。
*/

public class MonitorAlertBookVOMeta extends MonitorAlertBookMeta {
	
	/**
	 * 页码 , 类型: java.lang.Integer
	*/
	public static final String PAGE_INDEX="pageIndex";
	
	/**
	 * 页码 , 类型: java.lang.Integer
	*/
	public static final BeanProperty<com.dt.platform.domain.ops.MonitorAlertBookVO,java.lang.Integer> PAGE_INDEX_PROP = new BeanProperty(com.dt.platform.domain.ops.MonitorAlertBookVO.class ,PAGE_INDEX, java.lang.Integer.class, "页码", "", java.lang.Integer.class, null);
	
	/**
	 * 分页大小 , 类型: java.lang.Integer
	*/
	public static final String PAGE_SIZE="pageSize";
	
	/**
	 * 分页大小 , 类型: java.lang.Integer
	*/
	public static final BeanProperty<com.dt.platform.domain.ops.MonitorAlertBookVO,java.lang.Integer> PAGE_SIZE_PROP = new BeanProperty(com.dt.platform.domain.ops.MonitorAlertBookVO.class ,PAGE_SIZE, java.lang.Integer.class, "分页大小", "", java.lang.Integer.class, null);
	
	/**
	 * 搜索字段 , 类型: java.lang.String
	*/
	public static final String SEARCH_FIELD="searchField";
	
	/**
	 * 搜索字段 , 类型: java.lang.String
	*/
	public static final BeanProperty<com.dt.platform.domain.ops.MonitorAlertBookVO,java.lang.String> SEARCH_FIELD_PROP = new BeanProperty(com.dt.platform.domain.ops.MonitorAlertBookVO.class ,SEARCH_FIELD, java.lang.String.class, "搜索字段", "", java.lang.String.class, null);
	
	/**
	 * 模糊搜索字段 , 类型: java.lang.String
	*/
	public static final String FUZZY_FIELD="fuzzyField";
	
	/**
	 * 模糊搜索字段 , 类型: java.lang.String
	*/
	public static final BeanProperty<com.dt.platform.domain.ops.MonitorAlertBookVO,java.lang.String> FUZZY_FIELD_PROP = new BeanProperty(com.dt.platform.domain.ops.MonitorAlertBookVO.class ,FUZZY_FIELD, java.lang.String.class, "模糊搜索字段", "", java.lang.String.class, null);
	
	/**
	 * 搜索的值 , 类型: java.lang.String
	*/
	public static final String SEARCH_VALUE="searchValue";
	
	/**
	 * 搜索的值 , 类型: java.lang.String
	*/
	public static final BeanProperty<com.dt.platform.domain.ops.MonitorAlertBookVO,java.lang.String> SEARCH_VALUE_PROP = new BeanProperty(com.dt.platform.domain.ops.MonitorAlertBookVO.class ,SEARCH_VALUE, java.lang.String.class, "搜索的值", "", java.lang.String.class, null);
	
	/**
	 * 已修改字段 , 集合类型: LIST , 类型: java.lang.String
	*/
	public static final String DIRTY_FIELDS="dirtyFields";
	
	/**
	 * 已修改字段 , 集合类型: LIST , 类型: java.lang.String
	*/
	public static final BeanProperty<com.dt.platform.domain.ops.MonitorAlertBookVO,java.lang.String> DIRTY_FIELDS_PROP = new BeanProperty(com.dt.platform.domain.ops.MonitorAlertBookVO.class ,DIRTY_FIELDS, java.util.List.class, "已修改字段", "", java.lang.String.class, null);
	
	/**
	 * 排序字段 , 类型: java.lang.String
	*/
	public static final String SORT_FIELD="sortField";
	
	/**
	 * 排序字段 , 类型: java.lang.String
	*/
	public static final BeanProperty<com.dt.platform.domain.ops.MonitorAlertBookVO,java.lang.String> SORT_FIELD_PROP = new BeanProperty(com.dt.platform.domain.ops.MonitorAlertBookVO.class ,SORT_FIELD, java.lang.String.class, "排序字段", "", java.lang.String.class, null);
	
	/**
	 * 排序方式 , 类型: java.lang.String
	*/
	public static final String SORT_TYPE="sortType";
	
	/**
	 * 排序方式 , 类型: java.lang.String
	*/
	public static final BeanProperty<com.dt.platform.domain.ops.MonitorAlertBookVO,java.lang.String> SORT_TYPE_PROP = new BeanProperty(com.dt.platform.domain.ops.MonitorAlertBookVO.class ,SORT_TYPE, java.lang.String.class, "排序方式", "", java.lang.String.class, null);
	
	/**
	 * 数据来源 , 前端指定不同的来源，后端可按来源执行不同的逻辑 , 类型: java.lang.String
	*/
	public static final String DATA_ORIGIN="dataOrigin";
	
	/**
	 * 数据来源 , 前端指定不同的来源，后端可按来源执行不同的逻辑 , 类型: java.lang.String
	*/
	public static final BeanProperty<com.dt.platform.domain.ops.MonitorAlertBookVO,java.lang.String> DATA_ORIGIN_PROP = new BeanProperty(com.dt.platform.domain.ops.MonitorAlertBookVO.class ,DATA_ORIGIN, java.lang.String.class, "数据来源", "前端指定不同的来源，后端可按来源执行不同的逻辑", java.lang.String.class, null);
	
	/**
	 * 查询逻辑 , 默认and，可指定 or  , 类型: java.lang.String
	*/
	public static final String QUERY_LOGIC="queryLogic";
	
	/**
	 * 查询逻辑 , 默认and，可指定 or  , 类型: java.lang.String
	*/
	public static final BeanProperty<com.dt.platform.domain.ops.MonitorAlertBookVO,java.lang.String> QUERY_LOGIC_PROP = new BeanProperty(com.dt.platform.domain.ops.MonitorAlertBookVO.class ,QUERY_LOGIC, java.lang.String.class, "查询逻辑", "默认and，可指定 or ", java.lang.String.class, null);
	
	/**
	 * 请求动作 , 前端指定不同的Action，后端可Action执行不同的逻辑 , 类型: java.lang.String
	*/
	public static final String REQUEST_ACTION="requestAction";
	
	/**
	 * 请求动作 , 前端指定不同的Action，后端可Action执行不同的逻辑 , 类型: java.lang.String
	*/
	public static final BeanProperty<com.dt.platform.domain.ops.MonitorAlertBookVO,java.lang.String> REQUEST_ACTION_PROP = new BeanProperty(com.dt.platform.domain.ops.MonitorAlertBookVO.class ,REQUEST_ACTION, java.lang.String.class, "请求动作", "前端指定不同的Action，后端可Action执行不同的逻辑", java.lang.String.class, null);
	
	/**
	 * 主键清单 , 用于接收批量主键参数 , 集合类型: LIST , 类型: java.lang.String
	*/
	public static final String IDS="ids";
	
	/**
	 * 主键清单 , 用于接收批量主键参数 , 集合类型: LIST , 类型: java.lang.String
	*/
	public static final BeanProperty<com.dt.platform.domain.ops.MonitorAlertBookVO,java.lang.String> IDS_PROP = new BeanProperty(com.dt.platform.domain.ops.MonitorAlertBookVO.class ,IDS, java.util.List.class, "主键清单", "用于接收批量主键参数", java.lang.String.class, null);
	
	/**
	 * 主键 , 类型: java.lang.String
	*/
	public static final String ID="id";
	
	/**
	 * 主键 , 类型: java.lang.String
	*/
	public static final BeanProperty<com.dt.platform.domain.ops.MonitorAlertBookVO,java.lang.String> ID_PROP = new BeanProperty(com.dt.platform.domain.ops.MonitorAlertBookVO.class ,ID, java.lang.String.class, "主键", "主键", java.lang.String.class, null);
	
	/**
	 * 名称 , 类型: java.lang.String
	*/
	public static final String NAME="name";
	
	/**
	 * 名称 , 类型: java.lang.String
	*/
	public static final BeanProperty<com.dt.platform.domain.ops.MonitorAlertBookVO,java.lang.String> NAME_PROP = new BeanProperty(com.dt.platform.domain.ops.MonitorAlertBookVO.class ,NAME, java.lang.String.class, "名称", "名称", java.lang.String.class, null);
	
	/**
	 * 状态 , 类型: java.lang.String
	*/
	public static final String STATUS="status";
	
	/**
	 * 状态 , 类型: java.lang.String
	*/
	public static final BeanProperty<com.dt.platform.domain.ops.MonitorAlertBookVO,java.lang.String> STATUS_PROP = new BeanProperty(com.dt.platform.domain.ops.MonitorAlertBookVO.class ,STATUS, java.lang.String.class, "状态", "状态", java.lang.String.class, null);
	
	/**
	 * 全部对象 , 类型: java.lang.String
	*/
	public static final String MONITOR_IS_ALL="monitorIsAll";
	
	/**
	 * 全部对象 , 类型: java.lang.String
	*/
	public static final BeanProperty<com.dt.platform.domain.ops.MonitorAlertBookVO,java.lang.String> MONITOR_IS_ALL_PROP = new BeanProperty(com.dt.platform.domain.ops.MonitorAlertBookVO.class ,MONITOR_IS_ALL, java.lang.String.class, "全部对象", "全部对象", java.lang.String.class, null);
	
	/**
	 * 备注 , 类型: java.lang.String
	*/
	public static final String NOTES="notes";
	
	/**
	 * 备注 , 类型: java.lang.String
	*/
	public static final BeanProperty<com.dt.platform.domain.ops.MonitorAlertBookVO,java.lang.String> NOTES_PROP = new BeanProperty(com.dt.platform.domain.ops.MonitorAlertBookVO.class ,NOTES, java.lang.String.class, "备注", "备注", java.lang.String.class, null);
	
	/**
	 * 创建人ID , 类型: java.lang.String
	*/
	public static final String CREATE_BY="createBy";
	
	/**
	 * 创建人ID , 类型: java.lang.String
	*/
	public static final BeanProperty<com.dt.platform.domain.ops.MonitorAlertBookVO,java.lang.String> CREATE_BY_PROP = new BeanProperty(com.dt.platform.domain.ops.MonitorAlertBookVO.class ,CREATE_BY, java.lang.String.class, "创建人ID", "创建人ID", java.lang.String.class, null);
	
	/**
	 * 创建时间 , 类型: java.util.Date
	*/
	public static final String CREATE_TIME="createTime";
	
	/**
	 * 创建时间 , 类型: java.util.Date
	*/
	public static final BeanProperty<com.dt.platform.domain.ops.MonitorAlertBookVO,java.util.Date> CREATE_TIME_PROP = new BeanProperty(com.dt.platform.domain.ops.MonitorAlertBookVO.class ,CREATE_TIME, java.util.Date.class, "创建时间", "创建时间", java.util.Date.class, null);
	
	/**
	 * 修改人ID , 类型: java.lang.String
	*/
	public static final String UPDATE_BY="updateBy";
	
	/**
	 * 修改人ID , 类型: java.lang.String
	*/
	public static final BeanProperty<com.dt.platform.domain.ops.MonitorAlertBookVO,java.lang.String> UPDATE_BY_PROP = new BeanProperty(com.dt.platform.domain.ops.MonitorAlertBookVO.class ,UPDATE_BY, java.lang.String.class, "修改人ID", "修改人ID", java.lang.String.class, null);
	
	/**
	 * 修改时间 , 类型: java.util.Date
	*/
	public static final String UPDATE_TIME="updateTime";
	
	/**
	 * 修改时间 , 类型: java.util.Date
	*/
	public static final BeanProperty<com.dt.platform.domain.ops.MonitorAlertBookVO,java.util.Date> UPDATE_TIME_PROP = new BeanProperty(com.dt.platform.domain.ops.MonitorAlertBookVO.class ,UPDATE_TIME, java.util.Date.class, "修改时间", "修改时间", java.util.Date.class, null);
	
	/**
	 * 是否已删除 , 类型: java.lang.Integer
	*/
	public static final String DELETED="deleted";
	
	/**
	 * 是否已删除 , 类型: java.lang.Integer
	*/
	public static final BeanProperty<com.dt.platform.domain.ops.MonitorAlertBookVO,java.lang.Integer> DELETED_PROP = new BeanProperty(com.dt.platform.domain.ops.MonitorAlertBookVO.class ,DELETED, java.lang.Integer.class, "是否已删除", "是否已删除", java.lang.Integer.class, null);
	
	/**
	 * 删除人ID , 类型: java.lang.String
	*/
	public static final String DELETE_BY="deleteBy";
	
	/**
	 * 删除人ID , 类型: java.lang.String
	*/
	public static final BeanProperty<com.dt.platform.domain.ops.MonitorAlertBookVO,java.lang.String> DELETE_BY_PROP = new BeanProperty(com.dt.platform.domain.ops.MonitorAlertBookVO.class ,DELETE_BY, java.lang.String.class, "删除人ID", "删除人ID", java.lang.String.class, null);
	
	/**
	 * 删除时间 , 类型: java.util.Date
	*/
	public static final String DELETE_TIME="deleteTime";
	
	/**
	 * 删除时间 , 类型: java.util.Date
	*/
	public static final BeanProperty<com.dt.platform.domain.ops.MonitorAlertBookVO,java.util.Date> DELETE_TIME_PROP = new BeanProperty(com.dt.platform.domain.ops.MonitorAlertBookVO.class ,DELETE_TIME, java.util.Date.class, "删除时间", "删除时间", java.util.Date.class, null);
	
	/**
	 * 版本 , 类型: java.lang.Integer
	*/
	public static final String VERSION="version";
	
	/**
	 * 版本 , 类型: java.lang.Integer
	*/
	public static final BeanProperty<com.dt.platform.domain.ops.MonitorAlertBookVO,java.lang.Integer> VERSION_PROP = new BeanProperty(com.dt.platform.domain.ops.MonitorAlertBookVO.class ,VERSION, java.lang.Integer.class, "版本", "版本", java.lang.Integer.class, null);
	
	/**
	 * 人员群组 , 集合类型: LIST , 类型: org.github.foxnic.web.domain.system.BusiRole
	*/
	public static final String USER_GROUP_LIST="userGroupList";
	
	/**
	 * 人员群组 , 集合类型: LIST , 类型: org.github.foxnic.web.domain.system.BusiRole
	*/
	public static final BeanProperty<com.dt.platform.domain.ops.MonitorAlertBookVO,org.github.foxnic.web.domain.system.BusiRole> USER_GROUP_LIST_PROP = new BeanProperty(com.dt.platform.domain.ops.MonitorAlertBookVO.class ,USER_GROUP_LIST, java.util.List.class, "人员群组", "人员群组", org.github.foxnic.web.domain.system.BusiRole.class, null);
	
	/**
	 * 人员群组 , 集合类型: LIST , 类型: java.lang.String
	*/
	public static final String USER_GROUP_IDS="userGroupIds";
	
	/**
	 * 人员群组 , 集合类型: LIST , 类型: java.lang.String
	*/
	public static final BeanProperty<com.dt.platform.domain.ops.MonitorAlertBookVO,java.lang.String> USER_GROUP_IDS_PROP = new BeanProperty(com.dt.platform.domain.ops.MonitorAlertBookVO.class ,USER_GROUP_IDS, java.util.List.class, "人员群组", "人员群组", java.lang.String.class, null);
	
	/**
	 * userGroupUserList , 集合类型: LIST , 类型: org.github.foxnic.web.domain.hrm.Employee
	*/
	public static final String USER_GROUP_USER_LIST="userGroupUserList";
	
	/**
	 * userGroupUserList , 集合类型: LIST , 类型: org.github.foxnic.web.domain.hrm.Employee
	*/
	public static final BeanProperty<com.dt.platform.domain.ops.MonitorAlertBookVO,org.github.foxnic.web.domain.hrm.Employee> USER_GROUP_USER_LIST_PROP = new BeanProperty(com.dt.platform.domain.ops.MonitorAlertBookVO.class ,USER_GROUP_USER_LIST, java.util.List.class, "userGroupUserList", "userGroupUserList", org.github.foxnic.web.domain.hrm.Employee.class, null);
	
	/**
	 * 人员 , 集合类型: LIST , 类型: org.github.foxnic.web.domain.hrm.Employee
	*/
	public static final String USER_LIST="userList";
	
	/**
	 * 人员 , 集合类型: LIST , 类型: org.github.foxnic.web.domain.hrm.Employee
	*/
	public static final BeanProperty<com.dt.platform.domain.ops.MonitorAlertBookVO,org.github.foxnic.web.domain.hrm.Employee> USER_LIST_PROP = new BeanProperty(com.dt.platform.domain.ops.MonitorAlertBookVO.class ,USER_LIST, java.util.List.class, "人员", "人员", org.github.foxnic.web.domain.hrm.Employee.class, null);
	
	/**
	 * 人员 , 集合类型: LIST , 类型: java.lang.String
	*/
	public static final String USER_IDS="userIds";
	
	/**
	 * 人员 , 集合类型: LIST , 类型: java.lang.String
	*/
	public static final BeanProperty<com.dt.platform.domain.ops.MonitorAlertBookVO,java.lang.String> USER_IDS_PROP = new BeanProperty(com.dt.platform.domain.ops.MonitorAlertBookVO.class ,USER_IDS, java.util.List.class, "人员", "人员", java.lang.String.class, null);
	
	/**
	 * nodeGroupList , 集合类型: LIST , 类型: com.dt.platform.domain.ops.MonitorNodeGroup
	*/
	public static final String NODE_GROUP_LIST="nodeGroupList";
	
	/**
	 * nodeGroupList , 集合类型: LIST , 类型: com.dt.platform.domain.ops.MonitorNodeGroup
	*/
	public static final BeanProperty<com.dt.platform.domain.ops.MonitorAlertBookVO,com.dt.platform.domain.ops.MonitorNodeGroup> NODE_GROUP_LIST_PROP = new BeanProperty(com.dt.platform.domain.ops.MonitorAlertBookVO.class ,NODE_GROUP_LIST, java.util.List.class, "nodeGroupList", "nodeGroupList", com.dt.platform.domain.ops.MonitorNodeGroup.class, null);
	
	/**
	 * nodeGroupIds , 集合类型: LIST , 类型: java.lang.String
	*/
	public static final String NODE_GROUP_IDS="nodeGroupIds";
	
	/**
	 * nodeGroupIds , 集合类型: LIST , 类型: java.lang.String
	*/
	public static final BeanProperty<com.dt.platform.domain.ops.MonitorAlertBookVO,java.lang.String> NODE_GROUP_IDS_PROP = new BeanProperty(com.dt.platform.domain.ops.MonitorAlertBookVO.class ,NODE_GROUP_IDS, java.util.List.class, "nodeGroupIds", "nodeGroupIds", java.lang.String.class, null);
	
	/**
	 * nodeList , 集合类型: LIST , 类型: com.dt.platform.domain.ops.MonitorNode
	*/
	public static final String NODE_LIST="nodeList";
	
	/**
	 * nodeList , 集合类型: LIST , 类型: com.dt.platform.domain.ops.MonitorNode
	*/
	public static final BeanProperty<com.dt.platform.domain.ops.MonitorAlertBookVO,com.dt.platform.domain.ops.MonitorNode> NODE_LIST_PROP = new BeanProperty(com.dt.platform.domain.ops.MonitorAlertBookVO.class ,NODE_LIST, java.util.List.class, "nodeList", "nodeList", com.dt.platform.domain.ops.MonitorNode.class, null);
	
	/**
	 * nodeIds , 集合类型: LIST , 类型: java.lang.String
	*/
	public static final String NODE_IDS="nodeIds";
	
	/**
	 * nodeIds , 集合类型: LIST , 类型: java.lang.String
	*/
	public static final BeanProperty<com.dt.platform.domain.ops.MonitorAlertBookVO,java.lang.String> NODE_IDS_PROP = new BeanProperty(com.dt.platform.domain.ops.MonitorAlertBookVO.class ,NODE_IDS, java.util.List.class, "nodeIds", "nodeIds", java.lang.String.class, null);
	
	/**
	 * levelList , 集合类型: LIST , 类型: org.github.foxnic.web.domain.system.DictItem
	*/
	public static final String LEVEL_LIST="levelList";
	
	/**
	 * levelList , 集合类型: LIST , 类型: org.github.foxnic.web.domain.system.DictItem
	*/
	public static final BeanProperty<com.dt.platform.domain.ops.MonitorAlertBookVO,org.github.foxnic.web.domain.system.DictItem> LEVEL_LIST_PROP = new BeanProperty(com.dt.platform.domain.ops.MonitorAlertBookVO.class ,LEVEL_LIST, java.util.List.class, "levelList", "levelList", org.github.foxnic.web.domain.system.DictItem.class, null);
	
	/**
	 * levelIds , 集合类型: LIST , 类型: java.lang.String
	*/
	public static final String LEVEL_IDS="levelIds";
	
	/**
	 * levelIds , 集合类型: LIST , 类型: java.lang.String
	*/
	public static final BeanProperty<com.dt.platform.domain.ops.MonitorAlertBookVO,java.lang.String> LEVEL_IDS_PROP = new BeanProperty(com.dt.platform.domain.ops.MonitorAlertBookVO.class ,LEVEL_IDS, java.util.List.class, "levelIds", "levelIds", java.lang.String.class, null);
	
	/**
	 * alertMethodList , 集合类型: LIST , 类型: com.dt.platform.domain.ops.MonitorAlertMethod
	*/
	public static final String ALERT_METHOD_LIST="alertMethodList";
	
	/**
	 * alertMethodList , 集合类型: LIST , 类型: com.dt.platform.domain.ops.MonitorAlertMethod
	*/
	public static final BeanProperty<com.dt.platform.domain.ops.MonitorAlertBookVO,com.dt.platform.domain.ops.MonitorAlertMethod> ALERT_METHOD_LIST_PROP = new BeanProperty(com.dt.platform.domain.ops.MonitorAlertBookVO.class ,ALERT_METHOD_LIST, java.util.List.class, "alertMethodList", "alertMethodList", com.dt.platform.domain.ops.MonitorAlertMethod.class, null);
	
	/**
	 * alertMethodIds , 集合类型: LIST , 类型: java.lang.String
	*/
	public static final String ALERT_METHOD_IDS="alertMethodIds";
	
	/**
	 * alertMethodIds , 集合类型: LIST , 类型: java.lang.String
	*/
	public static final BeanProperty<com.dt.platform.domain.ops.MonitorAlertBookVO,java.lang.String> ALERT_METHOD_IDS_PROP = new BeanProperty(com.dt.platform.domain.ops.MonitorAlertBookVO.class ,ALERT_METHOD_IDS, java.util.List.class, "alertMethodIds", "alertMethodIds", java.lang.String.class, null);
	
	/**
	 * 全部属性清单
	*/
	public static final String[] $PROPS={ PAGE_INDEX , PAGE_SIZE , SEARCH_FIELD , FUZZY_FIELD , SEARCH_VALUE , DIRTY_FIELDS , SORT_FIELD , SORT_TYPE , DATA_ORIGIN , QUERY_LOGIC , REQUEST_ACTION , IDS , ID , NAME , STATUS , MONITOR_IS_ALL , NOTES , CREATE_BY , CREATE_TIME , UPDATE_BY , UPDATE_TIME , DELETED , DELETE_BY , DELETE_TIME , VERSION , USER_GROUP_LIST , USER_GROUP_IDS , USER_GROUP_USER_LIST , USER_LIST , USER_IDS , NODE_GROUP_LIST , NODE_GROUP_IDS , NODE_LIST , NODE_IDS , LEVEL_LIST , LEVEL_IDS , ALERT_METHOD_LIST , ALERT_METHOD_IDS };
	
	/**
	 * 代理类
	*/
	public static class $$proxy$$ extends com.dt.platform.domain.ops.MonitorAlertBookVO {

		private static final long serialVersionUID = 1L;

		
		/**
		 * 设置 页码
		 * @param pageIndex 页码
		 * @return 当前对象
		*/
		public MonitorAlertBookVO setPageIndex(Integer pageIndex) {
			super.change(PAGE_INDEX,super.getPageIndex(),pageIndex);
			super.setPageIndex(pageIndex);
			return this;
		}
		
		/**
		 * 设置 分页大小
		 * @param pageSize 分页大小
		 * @return 当前对象
		*/
		public MonitorAlertBookVO setPageSize(Integer pageSize) {
			super.change(PAGE_SIZE,super.getPageSize(),pageSize);
			super.setPageSize(pageSize);
			return this;
		}
		
		/**
		 * 设置 搜索字段
		 * @param searchField 搜索字段
		 * @return 当前对象
		*/
		public MonitorAlertBookVO setSearchField(String searchField) {
			super.change(SEARCH_FIELD,super.getSearchField(),searchField);
			super.setSearchField(searchField);
			return this;
		}
		
		/**
		 * 设置 模糊搜索字段
		 * @param fuzzyField 模糊搜索字段
		 * @return 当前对象
		*/
		public MonitorAlertBookVO setFuzzyField(String fuzzyField) {
			super.change(FUZZY_FIELD,super.getFuzzyField(),fuzzyField);
			super.setFuzzyField(fuzzyField);
			return this;
		}
		
		/**
		 * 设置 搜索的值
		 * @param searchValue 搜索的值
		 * @return 当前对象
		*/
		public MonitorAlertBookVO setSearchValue(String searchValue) {
			super.change(SEARCH_VALUE,super.getSearchValue(),searchValue);
			super.setSearchValue(searchValue);
			return this;
		}
		
		/**
		 * 设置 已修改字段
		 * @param dirtyFields 已修改字段
		 * @return 当前对象
		*/
		public MonitorAlertBookVO setDirtyFields(List<String> dirtyFields) {
			super.change(DIRTY_FIELDS,super.getDirtyFields(),dirtyFields);
			super.setDirtyFields(dirtyFields);
			return this;
		}
		
		/**
		 * 设置 排序字段
		 * @param sortField 排序字段
		 * @return 当前对象
		*/
		public MonitorAlertBookVO setSortField(String sortField) {
			super.change(SORT_FIELD,super.getSortField(),sortField);
			super.setSortField(sortField);
			return this;
		}
		
		/**
		 * 设置 排序方式
		 * @param sortType 排序方式
		 * @return 当前对象
		*/
		public MonitorAlertBookVO setSortType(String sortType) {
			super.change(SORT_TYPE,super.getSortType(),sortType);
			super.setSortType(sortType);
			return this;
		}
		
		/**
		 * 设置 数据来源
		 * @param dataOrigin 数据来源
		 * @return 当前对象
		*/
		public MonitorAlertBookVO setDataOrigin(String dataOrigin) {
			super.change(DATA_ORIGIN,super.getDataOrigin(),dataOrigin);
			super.setDataOrigin(dataOrigin);
			return this;
		}
		
		/**
		 * 设置 查询逻辑
		 * @param queryLogic 查询逻辑
		 * @return 当前对象
		*/
		public MonitorAlertBookVO setQueryLogic(String queryLogic) {
			super.change(QUERY_LOGIC,super.getQueryLogic(),queryLogic);
			super.setQueryLogic(queryLogic);
			return this;
		}
		
		/**
		 * 设置 请求动作
		 * @param requestAction 请求动作
		 * @return 当前对象
		*/
		public MonitorAlertBookVO setRequestAction(String requestAction) {
			super.change(REQUEST_ACTION,super.getRequestAction(),requestAction);
			super.setRequestAction(requestAction);
			return this;
		}
		
		/**
		 * 设置 主键清单
		 * @param ids 主键清单
		 * @return 当前对象
		*/
		public MonitorAlertBookVO setIds(List<String> ids) {
			super.change(IDS,super.getIds(),ids);
			super.setIds(ids);
			return this;
		}
		
		/**
		 * 设置 主键
		 * @param id 主键
		 * @return 当前对象
		*/
		public MonitorAlertBook setId(String id) {
			super.change(ID,super.getId(),id);
			super.setId(id);
			return this;
		}
		
		/**
		 * 设置 名称
		 * @param name 名称
		 * @return 当前对象
		*/
		public MonitorAlertBook setName(String name) {
			super.change(NAME,super.getName(),name);
			super.setName(name);
			return this;
		}
		
		/**
		 * 设置 状态
		 * @param status 状态
		 * @return 当前对象
		*/
		public MonitorAlertBook setStatus(String status) {
			super.change(STATUS,super.getStatus(),status);
			super.setStatus(status);
			return this;
		}
		
		/**
		 * 设置 全部对象
		 * @param monitorIsAll 全部对象
		 * @return 当前对象
		*/
		public MonitorAlertBook setMonitorIsAll(String monitorIsAll) {
			super.change(MONITOR_IS_ALL,super.getMonitorIsAll(),monitorIsAll);
			super.setMonitorIsAll(monitorIsAll);
			return this;
		}
		
		/**
		 * 设置 备注
		 * @param notes 备注
		 * @return 当前对象
		*/
		public MonitorAlertBook setNotes(String notes) {
			super.change(NOTES,super.getNotes(),notes);
			super.setNotes(notes);
			return this;
		}
		
		/**
		 * 设置 创建人ID
		 * @param createBy 创建人ID
		 * @return 当前对象
		*/
		public MonitorAlertBook setCreateBy(String createBy) {
			super.change(CREATE_BY,super.getCreateBy(),createBy);
			super.setCreateBy(createBy);
			return this;
		}
		
		/**
		 * 设置 创建时间
		 * @param createTime 创建时间
		 * @return 当前对象
		*/
		public MonitorAlertBook setCreateTime(Date createTime) {
			super.change(CREATE_TIME,super.getCreateTime(),createTime);
			super.setCreateTime(createTime);
			return this;
		}
		
		/**
		 * 设置 修改人ID
		 * @param updateBy 修改人ID
		 * @return 当前对象
		*/
		public MonitorAlertBook setUpdateBy(String updateBy) {
			super.change(UPDATE_BY,super.getUpdateBy(),updateBy);
			super.setUpdateBy(updateBy);
			return this;
		}
		
		/**
		 * 设置 修改时间
		 * @param updateTime 修改时间
		 * @return 当前对象
		*/
		public MonitorAlertBook setUpdateTime(Date updateTime) {
			super.change(UPDATE_TIME,super.getUpdateTime(),updateTime);
			super.setUpdateTime(updateTime);
			return this;
		}
		
		/**
		 * 设置 是否已删除
		 * @param deleted 是否已删除
		 * @return 当前对象
		*/
		public MonitorAlertBook setDeleted(Integer deleted) {
			super.change(DELETED,super.getDeleted(),deleted);
			super.setDeleted(deleted);
			return this;
		}
		
		/**
		 * 设置 删除人ID
		 * @param deleteBy 删除人ID
		 * @return 当前对象
		*/
		public MonitorAlertBook setDeleteBy(String deleteBy) {
			super.change(DELETE_BY,super.getDeleteBy(),deleteBy);
			super.setDeleteBy(deleteBy);
			return this;
		}
		
		/**
		 * 设置 删除时间
		 * @param deleteTime 删除时间
		 * @return 当前对象
		*/
		public MonitorAlertBook setDeleteTime(Date deleteTime) {
			super.change(DELETE_TIME,super.getDeleteTime(),deleteTime);
			super.setDeleteTime(deleteTime);
			return this;
		}
		
		/**
		 * 设置 版本
		 * @param version 版本
		 * @return 当前对象
		*/
		public MonitorAlertBook setVersion(Integer version) {
			super.change(VERSION,super.getVersion(),version);
			super.setVersion(version);
			return this;
		}
		
		/**
		 * 设置 人员群组
		 * @param userGroupList 人员群组
		 * @return 当前对象
		*/
		public MonitorAlertBook setUserGroupList(List<BusiRole> userGroupList) {
			super.change(USER_GROUP_LIST,super.getUserGroupList(),userGroupList);
			super.setUserGroupList(userGroupList);
			return this;
		}
		
		/**
		 * 设置 人员群组
		 * @param userGroupIds 人员群组
		 * @return 当前对象
		*/
		public MonitorAlertBook setUserGroupIds(List<String> userGroupIds) {
			super.change(USER_GROUP_IDS,super.getUserGroupIds(),userGroupIds);
			super.setUserGroupIds(userGroupIds);
			return this;
		}
		
		/**
		 * 设置 userGroupUserList
		 * @param userGroupUserList userGroupUserList
		 * @return 当前对象
		*/
		public MonitorAlertBook setUserGroupUserList(List<Employee> userGroupUserList) {
			super.change(USER_GROUP_USER_LIST,super.getUserGroupUserList(),userGroupUserList);
			super.setUserGroupUserList(userGroupUserList);
			return this;
		}
		
		/**
		 * 设置 人员
		 * @param userList 人员
		 * @return 当前对象
		*/
		public MonitorAlertBook setUserList(List<Employee> userList) {
			super.change(USER_LIST,super.getUserList(),userList);
			super.setUserList(userList);
			return this;
		}
		
		/**
		 * 设置 人员
		 * @param userIds 人员
		 * @return 当前对象
		*/
		public MonitorAlertBook setUserIds(List<String> userIds) {
			super.change(USER_IDS,super.getUserIds(),userIds);
			super.setUserIds(userIds);
			return this;
		}
		
		/**
		 * 设置 nodeGroupList
		 * @param nodeGroupList nodeGroupList
		 * @return 当前对象
		*/
		public MonitorAlertBook setNodeGroupList(List<MonitorNodeGroup> nodeGroupList) {
			super.change(NODE_GROUP_LIST,super.getNodeGroupList(),nodeGroupList);
			super.setNodeGroupList(nodeGroupList);
			return this;
		}
		
		/**
		 * 设置 nodeGroupIds
		 * @param nodeGroupIds nodeGroupIds
		 * @return 当前对象
		*/
		public MonitorAlertBook setNodeGroupIds(List<String> nodeGroupIds) {
			super.change(NODE_GROUP_IDS,super.getNodeGroupIds(),nodeGroupIds);
			super.setNodeGroupIds(nodeGroupIds);
			return this;
		}
		
		/**
		 * 设置 nodeList
		 * @param nodeList nodeList
		 * @return 当前对象
		*/
		public MonitorAlertBook setNodeList(List<MonitorNode> nodeList) {
			super.change(NODE_LIST,super.getNodeList(),nodeList);
			super.setNodeList(nodeList);
			return this;
		}
		
		/**
		 * 设置 nodeIds
		 * @param nodeIds nodeIds
		 * @return 当前对象
		*/
		public MonitorAlertBook setNodeIds(List<String> nodeIds) {
			super.change(NODE_IDS,super.getNodeIds(),nodeIds);
			super.setNodeIds(nodeIds);
			return this;
		}
		
		/**
		 * 设置 levelList
		 * @param levelList levelList
		 * @return 当前对象
		*/
		public MonitorAlertBook setLevelList(List<DictItem> levelList) {
			super.change(LEVEL_LIST,super.getLevelList(),levelList);
			super.setLevelList(levelList);
			return this;
		}
		
		/**
		 * 设置 levelIds
		 * @param levelIds levelIds
		 * @return 当前对象
		*/
		public MonitorAlertBook setLevelIds(List<String> levelIds) {
			super.change(LEVEL_IDS,super.getLevelIds(),levelIds);
			super.setLevelIds(levelIds);
			return this;
		}
		
		/**
		 * 设置 alertMethodList
		 * @param alertMethodList alertMethodList
		 * @return 当前对象
		*/
		public MonitorAlertBook setAlertMethodList(List<MonitorAlertMethod> alertMethodList) {
			super.change(ALERT_METHOD_LIST,super.getAlertMethodList(),alertMethodList);
			super.setAlertMethodList(alertMethodList);
			return this;
		}
		
		/**
		 * 设置 alertMethodIds
		 * @param alertMethodIds alertMethodIds
		 * @return 当前对象
		*/
		public MonitorAlertBook setAlertMethodIds(List<String> alertMethodIds) {
			super.change(ALERT_METHOD_IDS,super.getAlertMethodIds(),alertMethodIds);
			super.setAlertMethodIds(alertMethodIds);
			return this;
		}

		/**
		 * 克隆当前对象
		*/
		@Transient
		public MonitorAlertBookVO clone() {
			return duplicate(true);
		}

		/**
		 * 复制当前对象
		 * @param all 是否复制全部属性，当 false 时，仅复制来自数据表的属性
		*/
		@Transient
		public MonitorAlertBookVO duplicate(boolean all) {
			$$proxy$$ inst=new $$proxy$$();
			inst.setNotes(this.getNotes());
			inst.setUpdateTime(this.getUpdateTime());
			inst.setVersion(this.getVersion());
			inst.setCreateBy(this.getCreateBy());
			inst.setDeleted(this.getDeleted());
			inst.setCreateTime(this.getCreateTime());
			inst.setUpdateBy(this.getUpdateBy());
			inst.setDeleteTime(this.getDeleteTime());
			inst.setMonitorIsAll(this.getMonitorIsAll());
			inst.setName(this.getName());
			inst.setDeleteBy(this.getDeleteBy());
			inst.setId(this.getId());
			inst.setStatus(this.getStatus());
			if(all) {
				inst.setAlertMethodList(this.getAlertMethodList());
				inst.setSearchField(this.getSearchField());
				inst.setLevelList(this.getLevelList());
				inst.setFuzzyField(this.getFuzzyField());
				inst.setPageSize(this.getPageSize());
				inst.setUserGroupIds(this.getUserGroupIds());
				inst.setNodeIds(this.getNodeIds());
				inst.setUserGroupUserList(this.getUserGroupUserList());
				inst.setUserList(this.getUserList());
				inst.setUserIds(this.getUserIds());
				inst.setDirtyFields(this.getDirtyFields());
				inst.setSortField(this.getSortField());
				inst.setDataOrigin(this.getDataOrigin());
				inst.setQueryLogic(this.getQueryLogic());
				inst.setUserGroupList(this.getUserGroupList());
				inst.setAlertMethodIds(this.getAlertMethodIds());
				inst.setRequestAction(this.getRequestAction());
				inst.setLevelIds(this.getLevelIds());
				inst.setNodeGroupIds(this.getNodeGroupIds());
				inst.setNodeList(this.getNodeList());
				inst.setPageIndex(this.getPageIndex());
				inst.setSortType(this.getSortType());
				inst.setNodeGroupList(this.getNodeGroupList());
				inst.setIds(this.getIds());
				inst.setSearchValue(this.getSearchValue());
			}
			inst.clearModifies();
			return inst;
		}

	}
}