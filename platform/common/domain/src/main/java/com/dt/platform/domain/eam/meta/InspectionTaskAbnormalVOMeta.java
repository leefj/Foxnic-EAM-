package com.dt.platform.domain.eam.meta;

import com.github.foxnic.api.bean.BeanProperty;
import com.dt.platform.domain.eam.InspectionTaskAbnormalVO;
import java.util.List;
import com.dt.platform.domain.eam.InspectionTaskAbnormal;
import java.util.Date;
import com.dt.platform.domain.eam.InspectionTask;
import org.github.foxnic.web.domain.hrm.Employee;
import javax.persistence.Transient;



/**
 * @author 金杰 , maillank@qq.com
 * @since 2023-07-23 12:43:17
 * @sign DD607B44C901A30BC4D85CF3251DA938
 * 此文件由工具自动生成，请勿修改。若表结构或配置发生变动，请使用工具重新生成。
*/

public class InspectionTaskAbnormalVOMeta extends InspectionTaskAbnormalMeta {
	
	/**
	 * 页码 , 类型: java.lang.Integer
	*/
	public static final String PAGE_INDEX="pageIndex";
	
	/**
	 * 页码 , 类型: java.lang.Integer
	*/
	public static final BeanProperty<com.dt.platform.domain.eam.InspectionTaskAbnormalVO,java.lang.Integer> PAGE_INDEX_PROP = new BeanProperty(com.dt.platform.domain.eam.InspectionTaskAbnormalVO.class ,PAGE_INDEX, java.lang.Integer.class, "页码", "", java.lang.Integer.class, null);
	
	/**
	 * 分页大小 , 类型: java.lang.Integer
	*/
	public static final String PAGE_SIZE="pageSize";
	
	/**
	 * 分页大小 , 类型: java.lang.Integer
	*/
	public static final BeanProperty<com.dt.platform.domain.eam.InspectionTaskAbnormalVO,java.lang.Integer> PAGE_SIZE_PROP = new BeanProperty(com.dt.platform.domain.eam.InspectionTaskAbnormalVO.class ,PAGE_SIZE, java.lang.Integer.class, "分页大小", "", java.lang.Integer.class, null);
	
	/**
	 * 搜索字段 , 类型: java.lang.String
	*/
	public static final String SEARCH_FIELD="searchField";
	
	/**
	 * 搜索字段 , 类型: java.lang.String
	*/
	public static final BeanProperty<com.dt.platform.domain.eam.InspectionTaskAbnormalVO,java.lang.String> SEARCH_FIELD_PROP = new BeanProperty(com.dt.platform.domain.eam.InspectionTaskAbnormalVO.class ,SEARCH_FIELD, java.lang.String.class, "搜索字段", "", java.lang.String.class, null);
	
	/**
	 * 模糊搜索字段 , 类型: java.lang.String
	*/
	public static final String FUZZY_FIELD="fuzzyField";
	
	/**
	 * 模糊搜索字段 , 类型: java.lang.String
	*/
	public static final BeanProperty<com.dt.platform.domain.eam.InspectionTaskAbnormalVO,java.lang.String> FUZZY_FIELD_PROP = new BeanProperty(com.dt.platform.domain.eam.InspectionTaskAbnormalVO.class ,FUZZY_FIELD, java.lang.String.class, "模糊搜索字段", "", java.lang.String.class, null);
	
	/**
	 * 搜索的值 , 类型: java.lang.String
	*/
	public static final String SEARCH_VALUE="searchValue";
	
	/**
	 * 搜索的值 , 类型: java.lang.String
	*/
	public static final BeanProperty<com.dt.platform.domain.eam.InspectionTaskAbnormalVO,java.lang.String> SEARCH_VALUE_PROP = new BeanProperty(com.dt.platform.domain.eam.InspectionTaskAbnormalVO.class ,SEARCH_VALUE, java.lang.String.class, "搜索的值", "", java.lang.String.class, null);
	
	/**
	 * 已修改字段 , 集合类型: LIST , 类型: java.lang.String
	*/
	public static final String DIRTY_FIELDS="dirtyFields";
	
	/**
	 * 已修改字段 , 集合类型: LIST , 类型: java.lang.String
	*/
	public static final BeanProperty<com.dt.platform.domain.eam.InspectionTaskAbnormalVO,java.lang.String> DIRTY_FIELDS_PROP = new BeanProperty(com.dt.platform.domain.eam.InspectionTaskAbnormalVO.class ,DIRTY_FIELDS, java.util.List.class, "已修改字段", "", java.lang.String.class, null);
	
	/**
	 * 排序字段 , 类型: java.lang.String
	*/
	public static final String SORT_FIELD="sortField";
	
	/**
	 * 排序字段 , 类型: java.lang.String
	*/
	public static final BeanProperty<com.dt.platform.domain.eam.InspectionTaskAbnormalVO,java.lang.String> SORT_FIELD_PROP = new BeanProperty(com.dt.platform.domain.eam.InspectionTaskAbnormalVO.class ,SORT_FIELD, java.lang.String.class, "排序字段", "", java.lang.String.class, null);
	
	/**
	 * 排序方式 , 类型: java.lang.String
	*/
	public static final String SORT_TYPE="sortType";
	
	/**
	 * 排序方式 , 类型: java.lang.String
	*/
	public static final BeanProperty<com.dt.platform.domain.eam.InspectionTaskAbnormalVO,java.lang.String> SORT_TYPE_PROP = new BeanProperty(com.dt.platform.domain.eam.InspectionTaskAbnormalVO.class ,SORT_TYPE, java.lang.String.class, "排序方式", "", java.lang.String.class, null);
	
	/**
	 * 数据来源 , 前端指定不同的来源，后端可按来源执行不同的逻辑 , 类型: java.lang.String
	*/
	public static final String DATA_ORIGIN="dataOrigin";
	
	/**
	 * 数据来源 , 前端指定不同的来源，后端可按来源执行不同的逻辑 , 类型: java.lang.String
	*/
	public static final BeanProperty<com.dt.platform.domain.eam.InspectionTaskAbnormalVO,java.lang.String> DATA_ORIGIN_PROP = new BeanProperty(com.dt.platform.domain.eam.InspectionTaskAbnormalVO.class ,DATA_ORIGIN, java.lang.String.class, "数据来源", "前端指定不同的来源，后端可按来源执行不同的逻辑", java.lang.String.class, null);
	
	/**
	 * 查询逻辑 , 默认and，可指定 or  , 类型: java.lang.String
	*/
	public static final String QUERY_LOGIC="queryLogic";
	
	/**
	 * 查询逻辑 , 默认and，可指定 or  , 类型: java.lang.String
	*/
	public static final BeanProperty<com.dt.platform.domain.eam.InspectionTaskAbnormalVO,java.lang.String> QUERY_LOGIC_PROP = new BeanProperty(com.dt.platform.domain.eam.InspectionTaskAbnormalVO.class ,QUERY_LOGIC, java.lang.String.class, "查询逻辑", "默认and，可指定 or ", java.lang.String.class, null);
	
	/**
	 * 请求动作 , 前端指定不同的Action，后端可Action执行不同的逻辑 , 类型: java.lang.String
	*/
	public static final String REQUEST_ACTION="requestAction";
	
	/**
	 * 请求动作 , 前端指定不同的Action，后端可Action执行不同的逻辑 , 类型: java.lang.String
	*/
	public static final BeanProperty<com.dt.platform.domain.eam.InspectionTaskAbnormalVO,java.lang.String> REQUEST_ACTION_PROP = new BeanProperty(com.dt.platform.domain.eam.InspectionTaskAbnormalVO.class ,REQUEST_ACTION, java.lang.String.class, "请求动作", "前端指定不同的Action，后端可Action执行不同的逻辑", java.lang.String.class, null);
	
	/**
	 * 主键清单 , 用于接收批量主键参数 , 集合类型: LIST , 类型: java.lang.String
	*/
	public static final String IDS="ids";
	
	/**
	 * 主键清单 , 用于接收批量主键参数 , 集合类型: LIST , 类型: java.lang.String
	*/
	public static final BeanProperty<com.dt.platform.domain.eam.InspectionTaskAbnormalVO,java.lang.String> IDS_PROP = new BeanProperty(com.dt.platform.domain.eam.InspectionTaskAbnormalVO.class ,IDS, java.util.List.class, "主键清单", "用于接收批量主键参数", java.lang.String.class, null);
	
	/**
	 * 主键 , 类型: java.lang.String
	*/
	public static final String ID="id";
	
	/**
	 * 主键 , 类型: java.lang.String
	*/
	public static final BeanProperty<com.dt.platform.domain.eam.InspectionTaskAbnormalVO,java.lang.String> ID_PROP = new BeanProperty(com.dt.platform.domain.eam.InspectionTaskAbnormalVO.class ,ID, java.lang.String.class, "主键", "主键", java.lang.String.class, null);
	
	/**
	 * 任务名称 , 类型: java.lang.String
	*/
	public static final String TASK_ID="taskId";
	
	/**
	 * 任务名称 , 类型: java.lang.String
	*/
	public static final BeanProperty<com.dt.platform.domain.eam.InspectionTaskAbnormalVO,java.lang.String> TASK_ID_PROP = new BeanProperty(com.dt.platform.domain.eam.InspectionTaskAbnormalVO.class ,TASK_ID, java.lang.String.class, "任务名称", "任务名称", java.lang.String.class, null);
	
	/**
	 * 异常信息 , 类型: java.lang.String
	*/
	public static final String TASK_ABNORMAL_INFO="taskAbnormalInfo";
	
	/**
	 * 异常信息 , 类型: java.lang.String
	*/
	public static final BeanProperty<com.dt.platform.domain.eam.InspectionTaskAbnormalVO,java.lang.String> TASK_ABNORMAL_INFO_PROP = new BeanProperty(com.dt.platform.domain.eam.InspectionTaskAbnormalVO.class ,TASK_ABNORMAL_INFO, java.lang.String.class, "异常信息", "异常信息", java.lang.String.class, null);
	
	/**
	 * 处理状态 , 类型: java.lang.String
	*/
	public static final String STATUS="status";
	
	/**
	 * 处理状态 , 类型: java.lang.String
	*/
	public static final BeanProperty<com.dt.platform.domain.eam.InspectionTaskAbnormalVO,java.lang.String> STATUS_PROP = new BeanProperty(com.dt.platform.domain.eam.InspectionTaskAbnormalVO.class ,STATUS, java.lang.String.class, "处理状态", "处理状态", java.lang.String.class, null);
	
	/**
	 * 处理人员 , 类型: java.lang.String
	*/
	public static final String OPER_ID="operId";
	
	/**
	 * 处理人员 , 类型: java.lang.String
	*/
	public static final BeanProperty<com.dt.platform.domain.eam.InspectionTaskAbnormalVO,java.lang.String> OPER_ID_PROP = new BeanProperty(com.dt.platform.domain.eam.InspectionTaskAbnormalVO.class ,OPER_ID, java.lang.String.class, "处理人员", "处理人员", java.lang.String.class, null);
	
	/**
	 * 处理方式 , 类型: java.lang.String
	*/
	public static final String CONTENT="content";
	
	/**
	 * 处理方式 , 类型: java.lang.String
	*/
	public static final BeanProperty<com.dt.platform.domain.eam.InspectionTaskAbnormalVO,java.lang.String> CONTENT_PROP = new BeanProperty(com.dt.platform.domain.eam.InspectionTaskAbnormalVO.class ,CONTENT, java.lang.String.class, "处理方式", "处理方式", java.lang.String.class, null);
	
	/**
	 * 处理时间 , 类型: java.util.Date
	*/
	public static final String OPER_TIME="operTime";
	
	/**
	 * 处理时间 , 类型: java.util.Date
	*/
	public static final BeanProperty<com.dt.platform.domain.eam.InspectionTaskAbnormalVO,java.util.Date> OPER_TIME_PROP = new BeanProperty(com.dt.platform.domain.eam.InspectionTaskAbnormalVO.class ,OPER_TIME, java.util.Date.class, "处理时间", "处理时间", java.util.Date.class, null);
	
	/**
	 * 图片 , 类型: java.lang.String
	*/
	public static final String FILE_IDS="fileIds";
	
	/**
	 * 图片 , 类型: java.lang.String
	*/
	public static final BeanProperty<com.dt.platform.domain.eam.InspectionTaskAbnormalVO,java.lang.String> FILE_IDS_PROP = new BeanProperty(com.dt.platform.domain.eam.InspectionTaskAbnormalVO.class ,FILE_IDS, java.lang.String.class, "图片", "图片", java.lang.String.class, null);
	
	/**
	 * 备注 , 类型: java.lang.String
	*/
	public static final String NOTES="notes";
	
	/**
	 * 备注 , 类型: java.lang.String
	*/
	public static final BeanProperty<com.dt.platform.domain.eam.InspectionTaskAbnormalVO,java.lang.String> NOTES_PROP = new BeanProperty(com.dt.platform.domain.eam.InspectionTaskAbnormalVO.class ,NOTES, java.lang.String.class, "备注", "备注", java.lang.String.class, null);
	
	/**
	 * 创建人ID , 类型: java.lang.String
	*/
	public static final String CREATE_BY="createBy";
	
	/**
	 * 创建人ID , 类型: java.lang.String
	*/
	public static final BeanProperty<com.dt.platform.domain.eam.InspectionTaskAbnormalVO,java.lang.String> CREATE_BY_PROP = new BeanProperty(com.dt.platform.domain.eam.InspectionTaskAbnormalVO.class ,CREATE_BY, java.lang.String.class, "创建人ID", "创建人ID", java.lang.String.class, null);
	
	/**
	 * 创建时间 , 类型: java.util.Date
	*/
	public static final String CREATE_TIME="createTime";
	
	/**
	 * 创建时间 , 类型: java.util.Date
	*/
	public static final BeanProperty<com.dt.platform.domain.eam.InspectionTaskAbnormalVO,java.util.Date> CREATE_TIME_PROP = new BeanProperty(com.dt.platform.domain.eam.InspectionTaskAbnormalVO.class ,CREATE_TIME, java.util.Date.class, "创建时间", "创建时间", java.util.Date.class, null);
	
	/**
	 * 修改人ID , 类型: java.lang.String
	*/
	public static final String UPDATE_BY="updateBy";
	
	/**
	 * 修改人ID , 类型: java.lang.String
	*/
	public static final BeanProperty<com.dt.platform.domain.eam.InspectionTaskAbnormalVO,java.lang.String> UPDATE_BY_PROP = new BeanProperty(com.dt.platform.domain.eam.InspectionTaskAbnormalVO.class ,UPDATE_BY, java.lang.String.class, "修改人ID", "修改人ID", java.lang.String.class, null);
	
	/**
	 * 修改时间 , 类型: java.util.Date
	*/
	public static final String UPDATE_TIME="updateTime";
	
	/**
	 * 修改时间 , 类型: java.util.Date
	*/
	public static final BeanProperty<com.dt.platform.domain.eam.InspectionTaskAbnormalVO,java.util.Date> UPDATE_TIME_PROP = new BeanProperty(com.dt.platform.domain.eam.InspectionTaskAbnormalVO.class ,UPDATE_TIME, java.util.Date.class, "修改时间", "修改时间", java.util.Date.class, null);
	
	/**
	 * 是否已删除 , 类型: java.lang.Integer
	*/
	public static final String DELETED="deleted";
	
	/**
	 * 是否已删除 , 类型: java.lang.Integer
	*/
	public static final BeanProperty<com.dt.platform.domain.eam.InspectionTaskAbnormalVO,java.lang.Integer> DELETED_PROP = new BeanProperty(com.dt.platform.domain.eam.InspectionTaskAbnormalVO.class ,DELETED, java.lang.Integer.class, "是否已删除", "是否已删除", java.lang.Integer.class, null);
	
	/**
	 * 删除人ID , 类型: java.lang.String
	*/
	public static final String DELETE_BY="deleteBy";
	
	/**
	 * 删除人ID , 类型: java.lang.String
	*/
	public static final BeanProperty<com.dt.platform.domain.eam.InspectionTaskAbnormalVO,java.lang.String> DELETE_BY_PROP = new BeanProperty(com.dt.platform.domain.eam.InspectionTaskAbnormalVO.class ,DELETE_BY, java.lang.String.class, "删除人ID", "删除人ID", java.lang.String.class, null);
	
	/**
	 * 删除时间 , 类型: java.util.Date
	*/
	public static final String DELETE_TIME="deleteTime";
	
	/**
	 * 删除时间 , 类型: java.util.Date
	*/
	public static final BeanProperty<com.dt.platform.domain.eam.InspectionTaskAbnormalVO,java.util.Date> DELETE_TIME_PROP = new BeanProperty(com.dt.platform.domain.eam.InspectionTaskAbnormalVO.class ,DELETE_TIME, java.util.Date.class, "删除时间", "删除时间", java.util.Date.class, null);
	
	/**
	 * 租户 , 类型: java.lang.String
	*/
	public static final String TENANT_ID="tenantId";
	
	/**
	 * 租户 , 类型: java.lang.String
	*/
	public static final BeanProperty<com.dt.platform.domain.eam.InspectionTaskAbnormalVO,java.lang.String> TENANT_ID_PROP = new BeanProperty(com.dt.platform.domain.eam.InspectionTaskAbnormalVO.class ,TENANT_ID, java.lang.String.class, "租户", "租户", java.lang.String.class, null);
	
	/**
	 * version , 类型: java.lang.Integer
	*/
	public static final String VERSION="version";
	
	/**
	 * version , 类型: java.lang.Integer
	*/
	public static final BeanProperty<com.dt.platform.domain.eam.InspectionTaskAbnormalVO,java.lang.Integer> VERSION_PROP = new BeanProperty(com.dt.platform.domain.eam.InspectionTaskAbnormalVO.class ,VERSION, java.lang.Integer.class, "version", "version", java.lang.Integer.class, null);
	
	/**
	 * task , 类型: com.dt.platform.domain.eam.InspectionTask
	*/
	public static final String TASK="task";
	
	/**
	 * task , 类型: com.dt.platform.domain.eam.InspectionTask
	*/
	public static final BeanProperty<com.dt.platform.domain.eam.InspectionTaskAbnormalVO,com.dt.platform.domain.eam.InspectionTask> TASK_PROP = new BeanProperty(com.dt.platform.domain.eam.InspectionTaskAbnormalVO.class ,TASK, com.dt.platform.domain.eam.InspectionTask.class, "task", "task", com.dt.platform.domain.eam.InspectionTask.class, null);
	
	/**
	 * operUser , 类型: org.github.foxnic.web.domain.hrm.Employee
	*/
	public static final String OPER_USER="operUser";
	
	/**
	 * operUser , 类型: org.github.foxnic.web.domain.hrm.Employee
	*/
	public static final BeanProperty<com.dt.platform.domain.eam.InspectionTaskAbnormalVO,org.github.foxnic.web.domain.hrm.Employee> OPER_USER_PROP = new BeanProperty(com.dt.platform.domain.eam.InspectionTaskAbnormalVO.class ,OPER_USER, org.github.foxnic.web.domain.hrm.Employee.class, "operUser", "operUser", org.github.foxnic.web.domain.hrm.Employee.class, null);
	
	/**
	 * taskCode , 类型: java.lang.String
	*/
	public static final String TASK_CODE="taskCode";
	
	/**
	 * taskCode , 类型: java.lang.String
	*/
	public static final BeanProperty<com.dt.platform.domain.eam.InspectionTaskAbnormalVO,java.lang.String> TASK_CODE_PROP = new BeanProperty(com.dt.platform.domain.eam.InspectionTaskAbnormalVO.class ,TASK_CODE, java.lang.String.class, "taskCode", "taskCode", java.lang.String.class, null);
	
	/**
	 * taskCreateTime , 类型: java.lang.String
	*/
	public static final String TASK_CREATE_TIME="taskCreateTime";
	
	/**
	 * taskCreateTime , 类型: java.lang.String
	*/
	public static final BeanProperty<com.dt.platform.domain.eam.InspectionTaskAbnormalVO,java.lang.String> TASK_CREATE_TIME_PROP = new BeanProperty(com.dt.platform.domain.eam.InspectionTaskAbnormalVO.class ,TASK_CREATE_TIME, java.lang.String.class, "taskCreateTime", "taskCreateTime", java.lang.String.class, null);
	
	/**
	 * 全部属性清单
	*/
	public static final String[] $PROPS={ PAGE_INDEX , PAGE_SIZE , SEARCH_FIELD , FUZZY_FIELD , SEARCH_VALUE , DIRTY_FIELDS , SORT_FIELD , SORT_TYPE , DATA_ORIGIN , QUERY_LOGIC , REQUEST_ACTION , IDS , ID , TASK_ID , TASK_ABNORMAL_INFO , STATUS , OPER_ID , CONTENT , OPER_TIME , FILE_IDS , NOTES , CREATE_BY , CREATE_TIME , UPDATE_BY , UPDATE_TIME , DELETED , DELETE_BY , DELETE_TIME , TENANT_ID , VERSION , TASK , OPER_USER , TASK_CODE , TASK_CREATE_TIME };
	
	/**
	 * 代理类
	*/
	public static class $$proxy$$ extends com.dt.platform.domain.eam.InspectionTaskAbnormalVO {

		private static final long serialVersionUID = 1L;

		
		/**
		 * 设置 页码
		 * @param pageIndex 页码
		 * @return 当前对象
		*/
		public InspectionTaskAbnormalVO setPageIndex(Integer pageIndex) {
			super.change(PAGE_INDEX,super.getPageIndex(),pageIndex);
			super.setPageIndex(pageIndex);
			return this;
		}
		
		/**
		 * 设置 分页大小
		 * @param pageSize 分页大小
		 * @return 当前对象
		*/
		public InspectionTaskAbnormalVO setPageSize(Integer pageSize) {
			super.change(PAGE_SIZE,super.getPageSize(),pageSize);
			super.setPageSize(pageSize);
			return this;
		}
		
		/**
		 * 设置 搜索字段
		 * @param searchField 搜索字段
		 * @return 当前对象
		*/
		public InspectionTaskAbnormalVO setSearchField(String searchField) {
			super.change(SEARCH_FIELD,super.getSearchField(),searchField);
			super.setSearchField(searchField);
			return this;
		}
		
		/**
		 * 设置 模糊搜索字段
		 * @param fuzzyField 模糊搜索字段
		 * @return 当前对象
		*/
		public InspectionTaskAbnormalVO setFuzzyField(String fuzzyField) {
			super.change(FUZZY_FIELD,super.getFuzzyField(),fuzzyField);
			super.setFuzzyField(fuzzyField);
			return this;
		}
		
		/**
		 * 设置 搜索的值
		 * @param searchValue 搜索的值
		 * @return 当前对象
		*/
		public InspectionTaskAbnormalVO setSearchValue(String searchValue) {
			super.change(SEARCH_VALUE,super.getSearchValue(),searchValue);
			super.setSearchValue(searchValue);
			return this;
		}
		
		/**
		 * 设置 已修改字段
		 * @param dirtyFields 已修改字段
		 * @return 当前对象
		*/
		public InspectionTaskAbnormalVO setDirtyFields(List<String> dirtyFields) {
			super.change(DIRTY_FIELDS,super.getDirtyFields(),dirtyFields);
			super.setDirtyFields(dirtyFields);
			return this;
		}
		
		/**
		 * 设置 排序字段
		 * @param sortField 排序字段
		 * @return 当前对象
		*/
		public InspectionTaskAbnormalVO setSortField(String sortField) {
			super.change(SORT_FIELD,super.getSortField(),sortField);
			super.setSortField(sortField);
			return this;
		}
		
		/**
		 * 设置 排序方式
		 * @param sortType 排序方式
		 * @return 当前对象
		*/
		public InspectionTaskAbnormalVO setSortType(String sortType) {
			super.change(SORT_TYPE,super.getSortType(),sortType);
			super.setSortType(sortType);
			return this;
		}
		
		/**
		 * 设置 数据来源
		 * @param dataOrigin 数据来源
		 * @return 当前对象
		*/
		public InspectionTaskAbnormalVO setDataOrigin(String dataOrigin) {
			super.change(DATA_ORIGIN,super.getDataOrigin(),dataOrigin);
			super.setDataOrigin(dataOrigin);
			return this;
		}
		
		/**
		 * 设置 查询逻辑
		 * @param queryLogic 查询逻辑
		 * @return 当前对象
		*/
		public InspectionTaskAbnormalVO setQueryLogic(String queryLogic) {
			super.change(QUERY_LOGIC,super.getQueryLogic(),queryLogic);
			super.setQueryLogic(queryLogic);
			return this;
		}
		
		/**
		 * 设置 请求动作
		 * @param requestAction 请求动作
		 * @return 当前对象
		*/
		public InspectionTaskAbnormalVO setRequestAction(String requestAction) {
			super.change(REQUEST_ACTION,super.getRequestAction(),requestAction);
			super.setRequestAction(requestAction);
			return this;
		}
		
		/**
		 * 设置 主键清单
		 * @param ids 主键清单
		 * @return 当前对象
		*/
		public InspectionTaskAbnormalVO setIds(List<String> ids) {
			super.change(IDS,super.getIds(),ids);
			super.setIds(ids);
			return this;
		}
		
		/**
		 * 设置 主键
		 * @param id 主键
		 * @return 当前对象
		*/
		public InspectionTaskAbnormal setId(String id) {
			super.change(ID,super.getId(),id);
			super.setId(id);
			return this;
		}
		
		/**
		 * 设置 任务名称
		 * @param taskId 任务名称
		 * @return 当前对象
		*/
		public InspectionTaskAbnormal setTaskId(String taskId) {
			super.change(TASK_ID,super.getTaskId(),taskId);
			super.setTaskId(taskId);
			return this;
		}
		
		/**
		 * 设置 异常信息
		 * @param taskAbnormalInfo 异常信息
		 * @return 当前对象
		*/
		public InspectionTaskAbnormal setTaskAbnormalInfo(String taskAbnormalInfo) {
			super.change(TASK_ABNORMAL_INFO,super.getTaskAbnormalInfo(),taskAbnormalInfo);
			super.setTaskAbnormalInfo(taskAbnormalInfo);
			return this;
		}
		
		/**
		 * 设置 处理状态
		 * @param status 处理状态
		 * @return 当前对象
		*/
		public InspectionTaskAbnormal setStatus(String status) {
			super.change(STATUS,super.getStatus(),status);
			super.setStatus(status);
			return this;
		}
		
		/**
		 * 设置 处理人员
		 * @param operId 处理人员
		 * @return 当前对象
		*/
		public InspectionTaskAbnormal setOperId(String operId) {
			super.change(OPER_ID,super.getOperId(),operId);
			super.setOperId(operId);
			return this;
		}
		
		/**
		 * 设置 处理方式
		 * @param content 处理方式
		 * @return 当前对象
		*/
		public InspectionTaskAbnormal setContent(String content) {
			super.change(CONTENT,super.getContent(),content);
			super.setContent(content);
			return this;
		}
		
		/**
		 * 设置 处理时间
		 * @param operTime 处理时间
		 * @return 当前对象
		*/
		public InspectionTaskAbnormal setOperTime(Date operTime) {
			super.change(OPER_TIME,super.getOperTime(),operTime);
			super.setOperTime(operTime);
			return this;
		}
		
		/**
		 * 设置 图片
		 * @param fileIds 图片
		 * @return 当前对象
		*/
		public InspectionTaskAbnormal setFileIds(String fileIds) {
			super.change(FILE_IDS,super.getFileIds(),fileIds);
			super.setFileIds(fileIds);
			return this;
		}
		
		/**
		 * 设置 备注
		 * @param notes 备注
		 * @return 当前对象
		*/
		public InspectionTaskAbnormal setNotes(String notes) {
			super.change(NOTES,super.getNotes(),notes);
			super.setNotes(notes);
			return this;
		}
		
		/**
		 * 设置 创建人ID
		 * @param createBy 创建人ID
		 * @return 当前对象
		*/
		public InspectionTaskAbnormal setCreateBy(String createBy) {
			super.change(CREATE_BY,super.getCreateBy(),createBy);
			super.setCreateBy(createBy);
			return this;
		}
		
		/**
		 * 设置 创建时间
		 * @param createTime 创建时间
		 * @return 当前对象
		*/
		public InspectionTaskAbnormal setCreateTime(Date createTime) {
			super.change(CREATE_TIME,super.getCreateTime(),createTime);
			super.setCreateTime(createTime);
			return this;
		}
		
		/**
		 * 设置 修改人ID
		 * @param updateBy 修改人ID
		 * @return 当前对象
		*/
		public InspectionTaskAbnormal setUpdateBy(String updateBy) {
			super.change(UPDATE_BY,super.getUpdateBy(),updateBy);
			super.setUpdateBy(updateBy);
			return this;
		}
		
		/**
		 * 设置 修改时间
		 * @param updateTime 修改时间
		 * @return 当前对象
		*/
		public InspectionTaskAbnormal setUpdateTime(Date updateTime) {
			super.change(UPDATE_TIME,super.getUpdateTime(),updateTime);
			super.setUpdateTime(updateTime);
			return this;
		}
		
		/**
		 * 设置 是否已删除
		 * @param deleted 是否已删除
		 * @return 当前对象
		*/
		public InspectionTaskAbnormal setDeleted(Integer deleted) {
			super.change(DELETED,super.getDeleted(),deleted);
			super.setDeleted(deleted);
			return this;
		}
		
		/**
		 * 设置 删除人ID
		 * @param deleteBy 删除人ID
		 * @return 当前对象
		*/
		public InspectionTaskAbnormal setDeleteBy(String deleteBy) {
			super.change(DELETE_BY,super.getDeleteBy(),deleteBy);
			super.setDeleteBy(deleteBy);
			return this;
		}
		
		/**
		 * 设置 删除时间
		 * @param deleteTime 删除时间
		 * @return 当前对象
		*/
		public InspectionTaskAbnormal setDeleteTime(Date deleteTime) {
			super.change(DELETE_TIME,super.getDeleteTime(),deleteTime);
			super.setDeleteTime(deleteTime);
			return this;
		}
		
		/**
		 * 设置 租户
		 * @param tenantId 租户
		 * @return 当前对象
		*/
		public InspectionTaskAbnormal setTenantId(String tenantId) {
			super.change(TENANT_ID,super.getTenantId(),tenantId);
			super.setTenantId(tenantId);
			return this;
		}
		
		/**
		 * 设置 version
		 * @param version version
		 * @return 当前对象
		*/
		public InspectionTaskAbnormal setVersion(Integer version) {
			super.change(VERSION,super.getVersion(),version);
			super.setVersion(version);
			return this;
		}
		
		/**
		 * 设置 task
		 * @param task task
		 * @return 当前对象
		*/
		public InspectionTaskAbnormal setTask(InspectionTask task) {
			super.change(TASK,super.getTask(),task);
			super.setTask(task);
			return this;
		}
		
		/**
		 * 设置 operUser
		 * @param operUser operUser
		 * @return 当前对象
		*/
		public InspectionTaskAbnormal setOperUser(Employee operUser) {
			super.change(OPER_USER,super.getOperUser(),operUser);
			super.setOperUser(operUser);
			return this;
		}
		
		/**
		 * 设置 taskCode
		 * @param taskCode taskCode
		 * @return 当前对象
		*/
		public InspectionTaskAbnormal setTaskCode(String taskCode) {
			super.change(TASK_CODE,super.getTaskCode(),taskCode);
			super.setTaskCode(taskCode);
			return this;
		}
		
		/**
		 * 设置 taskCreateTime
		 * @param taskCreateTime taskCreateTime
		 * @return 当前对象
		*/
		public InspectionTaskAbnormal setTaskCreateTime(String taskCreateTime) {
			super.change(TASK_CREATE_TIME,super.getTaskCreateTime(),taskCreateTime);
			super.setTaskCreateTime(taskCreateTime);
			return this;
		}

		/**
		 * 克隆当前对象
		*/
		@Transient
		public InspectionTaskAbnormalVO clone() {
			return duplicate(true);
		}

		/**
		 * 复制当前对象
		 * @param all 是否复制全部属性，当 false 时，仅复制来自数据表的属性
		*/
		@Transient
		public InspectionTaskAbnormalVO duplicate(boolean all) {
			$$proxy$$ inst=new $$proxy$$();
			inst.setNotes(this.getNotes());
			inst.setOperId(this.getOperId());
			inst.setUpdateTime(this.getUpdateTime());
			inst.setVersion(this.getVersion());
			inst.setContent(this.getContent());
			inst.setTaskAbnormalInfo(this.getTaskAbnormalInfo());
			inst.setCreateBy(this.getCreateBy());
			inst.setDeleted(this.getDeleted());
			inst.setFileIds(this.getFileIds());
			inst.setCreateTime(this.getCreateTime());
			inst.setUpdateBy(this.getUpdateBy());
			inst.setDeleteTime(this.getDeleteTime());
			inst.setTenantId(this.getTenantId());
			inst.setDeleteBy(this.getDeleteBy());
			inst.setId(this.getId());
			inst.setTaskId(this.getTaskId());
			inst.setStatus(this.getStatus());
			inst.setOperTime(this.getOperTime());
			if(all) {
				inst.setSearchField(this.getSearchField());
				inst.setRequestAction(this.getRequestAction());
				inst.setFuzzyField(this.getFuzzyField());
				inst.setPageSize(this.getPageSize());
				inst.setTask(this.getTask());
				inst.setTaskCode(this.getTaskCode());
				inst.setPageIndex(this.getPageIndex());
				inst.setSortType(this.getSortType());
				inst.setDirtyFields(this.getDirtyFields());
				inst.setSortField(this.getSortField());
				inst.setDataOrigin(this.getDataOrigin());
				inst.setIds(this.getIds());
				inst.setTaskCreateTime(this.getTaskCreateTime());
				inst.setQueryLogic(this.getQueryLogic());
				inst.setSearchValue(this.getSearchValue());
				inst.setOperUser(this.getOperUser());
			}
			inst.clearModifies();
			return inst;
		}

	}
}